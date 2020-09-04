import { Component, OnInit } from '@angular/core';


import {element} from 'protractor';
import { Employee, HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {
  employees:Employee;
  

  constructor(public httpclient:HttpClientService) { }

  ngOnInit()  {
    
  }

  public getEmployeeById(empId:any) {
    this.httpclient.getEmployeeById(empId)
      .subscribe(data => {
        console.log(data);
      });
  }
}