package com.mxnavi.dubbo.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mxnavi.dubbo.DubboMenuService;
import com.mxnavi.mapper.MenuMapper;
import com.mxnavi.mapper.UserMapper;
import com.mxnavi.pojo.Menu;
import com.mxnavi.pojo.Role;
import com.mxnavi.pojo.User;
import com.mxnavi.utils.JWTUtils;

@Service
public class DubboMenuServiceImpl implements DubboMenuService{
	
	@Override
	public String toString() {
		return "DubboMenuServiceImpl [menuMapper=" + menuMapper + ", userMapper=" + userMapper + "]";
	}



	@Resource
	private MenuMapper menuMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public String sayHi(String name) {
		
		System.out.println("Hello Dubbo MenuService: " + name);
		return "Hello Dubbo MenuService: " + name ;
	}

	@Override
	public List<Menu> selAll() {
		
		return menuMapper.selAll();
	}

	@Override
	public int updByIdAndName(Menu menu) {
		
		int updateOk = menuMapper.updByIdAndName(menu);
		return updateOk;
		
	}

	public Menu selById(int id) {
		
		return menuMapper.selById(id);
	}
	

	
	public String login(User user){
    	//这里很简单的进行校验，如果能在数据库里查到传入的用户名和密码，说明登录成功，这里可以改成MD5加密校验
        User User = userMapper.LoginByNamePass(user);
        //没查到说明登录失败
        if(User == null){
            return null;
        }else {
            //登录成功 设置jwt
            JWTUtils util = new JWTUtils();
            //将查询到的角色ID存在一个数组里面写到jwt中，后面鉴权会用到
            Map<String, Object> payload = new HashMap<String, Object>();
            //这里我在User中封装了个List<Role>  可以使用Mybatis封装进去，下面我贴出UserMapper的部分代码
            List<Role> roleList = User.getRoleList();
            List<Integer> roles = new ArrayList<>();
            if (roleList!=null&&roleList.size()>0){
                for (Role role : roleList) {
                    roles.add(role.getId());
                }
            }
            payload.put("roles", roles);

            try {
            	//86400000是过期时间  24小时
                String jwt =util.createJWT("jwt", User.getName(), 86400000,payload);
                return jwt;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
	
	

}
