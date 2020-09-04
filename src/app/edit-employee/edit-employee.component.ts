import { Component, OnInit } from '@angular/core';
import { HttpClientService, Employee } from '../service/http-client.service';


@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  user: Employee = new Employee("","","","");

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  editEmployee(): void {
    this.httpClientService.editEmployee(this.user)
        .subscribe( data => {
          alert("Employee updated successfully.");
        });

  };
}
