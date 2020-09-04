import { Component, OnInit } from '@angular/core';
import { HttpClientService, Employee } from '../service/http-client.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  empId: Employee;
   
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getEmployees().subscribe(
     response =>{this.employees = response;}
    );
  }

  deleteEmployee(empId: number): void {
    this.httpClientService.deleteEmployee(empId)
      .subscribe( data => {
        this.employees = this.employees.filter(u => u !== this.empId);
      })
  };   
}
