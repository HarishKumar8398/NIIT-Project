import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';




const routes: Routes = [
  { path:'', component: EmployeeComponent},
{ path:'addemployee', component: AddEmployeeComponent},
{ path:'editemployee', component: EditEmployeeComponent},
{ path:'searchemployee', component: SearchEmployeeComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
