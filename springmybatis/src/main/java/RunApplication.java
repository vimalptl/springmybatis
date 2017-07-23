
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dc.springmybatis.bo.Customer;
import com.dc.springmybatis.common.DataConfig;
import com.dc.springmybatis.persistence.CustomerMapper;

public class RunApplication {
	public static void main(String[] args) {
	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	   ctx.register(DataConfig.class);
	   ctx.refresh();
	   CustomerMapper mapper = ctx.getBean(CustomerMapper.class);	
	   Customer customer = mapper.findByCustomerId(15704);
	   System.out.println("CustomerName: " + customer.getFirstName() + " " + customer.getLastName());
	}
} 