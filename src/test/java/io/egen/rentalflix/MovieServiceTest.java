package io.egen.rentalflix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */

public class MovieServiceTest {
	
	private MovieService ms = new MovieService();
	
	@BeforeClass
	public static void testClass(){
		System.out.println("You Started Testing MovieService Class.");
	}
	@Before
	public void testTestBegin(){
		System.out.println("New Testcase Execution");
	}
	
	@Test
	public void testfindAll(){
		Movie m =new Movie("Herry potter",1990,"English");
		Movie m1 =new Movie("Herry potter",1992,"English");
		Movie m2 =new Movie("Movie",1991,"English");
		m=ms.create(m);
		m1=ms.create(m1);
		m2=ms.create(m2);
		int actual=ms.findAll().size();
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public void testCreate(){
		Movie m =new Movie("Movie-1",1990,"English");
		String actual= ms.create(m).getTitle();
		Assert.assertEquals("Movie-1", actual);
	}
	
	@Test
	public void testfindByName(){
		Movie m =new Movie("Herry potter",1990,"English");
		Movie m1 =new Movie("Herry potter",1992,"English");
		Movie m2 =new Movie("Movie",1991,"English");
		m= ms.create(m);
		m1=ms.create(m1);
		m2=ms.create(m2);
		int actual=ms.findByName("Herry").size();
		Assert.assertEquals(2, actual);
	}
	
	
	@Test
	public void testupdate(){
		Movie m =new Movie("Herry potter",1990,"English");
		m=ms.create(m);
		m.setTitle("Cherry potter");
		m=ms.update(m);
		String actual=m.getTitle();
		Assert.assertEquals("Cherry potter", actual);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testupdateFail(){
		Movie m =new Movie("Herry potter",1990,"English");
		m.setTitle("Cherry potter");
		m.setId("930f94e0-d157-11e5-8b86-0002a5d5c51b");
		m=ms.update(m);
		String actual=m.getTitle();
	}
	
	@Test
	public void testdelete(){
		Movie m =new Movie("Herry potter",1990,"English");
		m=ms.create(m);
		m=ms.delete(m.getId());
		String actual=m.getTitle();
		Assert.assertEquals("Herry potter", actual);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testdeleteFail(){
		Movie m =new Movie("Herry potter",1990,"English");
		m.setId("930f94e0-d157-11e5-8b86-0002a5d5c51b");
		m=ms.delete(m.getId());
	}
	
	@Test
	public void testrent(){
		Movie m =new Movie("Herry potter",1990,"English");
		m=ms.create(m);
		boolean actual=ms.rentMovie(m.getId(), "Bhavin");
		Assert.assertEquals(true, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testrentFail(){
		Movie m =new Movie("Herry potter",1990,"English");
		m=ms.create(m);
		boolean firstTime=ms.rentMovie(m.getId(), "Bhavin");
		boolean actual=ms.rentMovie(m.getId(), "Second Renting");
	}
	
	
	@After
	public void testTestEnd(){
		System.out.println("End of Testcase Execution");
	}
	
	@AfterClass
	public static void testEndClass(){
		System.out.println("End of Testing MovieService Class.");
	}

}
