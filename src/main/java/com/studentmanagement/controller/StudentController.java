package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.entities.Student;
import com.studentmanagement.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudent(Model model ) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/student/new")
	public String createNewStudent(Model model) {
		Student student =new Student();
		model.addAttribute("student",student);
		return "createStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String updateStudentPage(@PathVariable("id") Long id,Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student",student);
		return "updateStudent";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable("id") Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
}
