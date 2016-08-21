package springmvcdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvcdemo.model.Student;

@Controller
public class DemoController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)  
    public ModelAndView handleRequest(HttpServletRequest request,  
              HttpServletResponse response) throws Exception {  

         Student student = new Student();  
         student.setName("NguyetNT6");  

         List<String> books = new ArrayList<String>();  
         books.add("English");  
         books.add("java");  
         student.setListBook(books);  

         ModelAndView mav = new ModelAndView("index", "model", student);  
         return mav;  
    }  

	
    @RequestMapping(value="/submitStudentInfo", method = RequestMethod.POST)  
    public ModelAndView submitStudentInfo(ModelMap model, @ModelAttribute("model") Student student){  

         List<String> listBooks = student.getListBook();  
         boolean bookSameName = checkSameBookName(listBooks);  

         String message = "Update success !!!";  
         if(bookSameName){  
              message = "Books must have different name !!!";  
         }  
         model.addAttribute("message", message);  

         ModelAndView mav = new ModelAndView("index", "model", student);  
         return mav;  
    }  

    
    private boolean checkSameBookName( List<String> listBooks ) {  
         for(int i = 0; i < listBooks.size(); i++){  
              String firstBookName = listBooks.get(i);  
              for(int j = i+1; j<listBooks.size(); j++){  
                   String secondBookName = listBooks.get(j);  
                   if(firstBookName.equalsIgnoreCase(secondBookName)){  
                        return true;  
                   }  
              }  
         }  
         return false;  
    }  
}
