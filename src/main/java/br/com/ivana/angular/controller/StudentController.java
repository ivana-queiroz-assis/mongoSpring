package br.com.ivana.angular.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ivana.angular.entity.Student;
import br.com.ivana.angular.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;

	@RequestMapping(value="/student",method=RequestMethod.GET)
	public List<Student> listStudent(){
		this.studentRepository.findAll().forEach(System.out::println);
		return this.studentRepository.findAll();
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		return this.studentRepository.save(student);
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public Optional<Student> findById(@PathVariable String id){
		this.studentRepository.findAll().forEach(System.out::println);
		return this.studentRepository.findById(id);
	}
	
	@RequestMapping(value="/student/name/{name}",method=RequestMethod.GET)
	public Student findByName(@PathVariable String name){
		this.studentRepository.findAll().forEach(System.out::println);
		return this.studentRepository.findByNameLikeIgnoreCase(name).orElse(new Student("Ivanas2Filipe"));
	}
}
