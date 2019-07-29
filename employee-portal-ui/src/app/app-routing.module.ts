import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeesComponent } from './components/employees/employees.component';
import { RegistrationComponent } from './components/registration/registration.component';

const routes: Routes = [

   { path: 'users', component: EmployeesComponent },
  { path: 'add', component: RegistrationComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
