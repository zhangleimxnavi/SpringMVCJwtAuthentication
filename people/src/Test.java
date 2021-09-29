import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mxnavi.pojo.People;
import com.mxnavi.service.PeopleService;
import com.mxnavi.serviceimpl.PeopleServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(Test.class);
		
		
		PeopleService ps = new PeopleServiceImpl();
		try {
			List<People> lists = ps.showAll();
			for (People people : lists) {
				System.out.println(people);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			
/*			e.printStackTrace();*/
		}
		
		
		logger.debug("this is debug messages");
		logger.info("this is info messages");
		
		
		
		

	}
	
}
