import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers : new HttpHeaders({ 'Content-Type': 'application/json'})
};

export class Employee{
  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) { 
     }

     getEmployees()
  {
    console.log("test call");
    return this.httpClient.get<Employee[]>('http://localhost:8080/employees');
  }
  public deleteEmployee(empId:number) {
    return this.httpClient.delete<Employee>("http://localhost:8080/employees" + "/"+ empId);
  }

  public createEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8080/employees", employee);
  }

  public editEmployee(employee) {
    return this.httpClient.put<Employee>("http://localhost:8080/employees" , employee);
  }

  getEmployeeById(empId: string) {
    return this.httpClient.get<Employee>("http://localhost:8080/employees" +"/" +empId);
    
    
}
}
