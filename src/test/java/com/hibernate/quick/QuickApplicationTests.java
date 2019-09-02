package com.hibernate.quick;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hibernate.quick.entities.Author;
import com.hibernate.quick.entities.Book;
import com.hibernate.quick.entities.Email;
import com.hibernate.quick.entities.Employee;
import com.hibernate.quick.repositories.AuthorRepository;
import com.hibernate.quick.repositories.BookRepository;
import com.hibernate.quick.repositories.EmailRepository;
import com.hibernate.quick.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuickApplicationTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Transactional
	private void SaveFirst() {
		
		Employee employee = new Employee();
		employee.setName("Big Head");
		

        Email email1 = new Email();
        email1.setAddress("example@email.com");
        email1.setEmployee(employee);
        
        Email email2 = new Email();
        email2.setAddress("example222@email.com");
        email2.setEmployee(employee);
        
        Email email3 = new Email();
        email3.setAddress("example333@email.com");
        email3.setEmployee(employee);
        employeeRepository.save(employee);
	}
	
	@Test
	public void testingOneToMany() {
	
        
//        emailRepository.saveAll(Arrays.asList(email1, email2, email3));
		SaveFirst();	
		
        
        Optional<Employee>look = employeeRepository.findById(1L);
        if(look.isPresent()) {
        	
        	List<Email> mails = look.get().getEmails();
        	
        	System.out.println("Size of the elements: " + (mails == null));
//        	System.out.println("0 element: " + mails.size());
        	
        	
        	
        }
        
		
	}
	
	@Ignore
	@Test
	public void addingSomeAndReading() {
		
		
		Author williamGolding = new Author();
		williamGolding.setName("William Golding");
		authorRepository.save(williamGolding);
		
		
		Book book1 = new Book();
		book1.setName("Lord of the flies");
		book1.setAuthor(williamGolding);
		bookRepository.save(book1);
		
		Book book2 = new Book();
		book2.setName("Unwritten");
		book2.setAuthor(williamGolding);
		bookRepository.save(book2);
		
		
		List<Author> resultAuthor = authorRepository.findAll();
		System.out.println("authorRepository.findAll().size(): " + resultAuthor.size());
		System.out.println("result content: " + resultAuthor.get(0).getName());
		resultAuthor.forEach(System.out::println);
		System.out.println("------------------");
		
		List<Book> result = bookRepository.findAllByAuthor(williamGolding);
		System.out.println("bookRepository.findAllByAuthor(williamGolding).size(): " + result.size());
		result.forEach(System.out::println);
		
		/*.forEach(
				author->{
					System.out.printf("%d%n", author.getBooks().size());
				});*/
	}

}
