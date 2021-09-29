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
    	//����ܼ򵥵Ľ���У�飬����������ݿ���鵽������û��������룬˵����¼�ɹ���������Ըĳ�MD5����У��
        User User = userMapper.LoginByNamePass(user);
        //û�鵽˵����¼ʧ��
        if(User == null){
            return null;
        }else {
            //��¼�ɹ� ����jwt
            JWTUtils util = new JWTUtils();
            //����ѯ���Ľ�ɫID����һ����������д��jwt�У������Ȩ���õ�
            Map<String, Object> payload = new HashMap<String, Object>();
            //��������User�з�װ�˸�List<Role>  ����ʹ��Mybatis��װ��ȥ������������UserMapper�Ĳ��ִ���
            List<Role> roleList = User.getRoleList();
            List<Integer> roles = new ArrayList<>();
            if (roleList!=null&&roleList.size()>0){
                for (Role role : roleList) {
                    roles.add(role.getId());
                }
            }
            payload.put("roles", roles);

            try {
            	//86400000�ǹ���ʱ��  24Сʱ
                String jwt =util.createJWT("jwt", User.getName(), 86400000,payload);
                return jwt;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
	
	

}
