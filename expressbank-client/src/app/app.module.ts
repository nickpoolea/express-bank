import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { NavigationComponent } from './navigation/navigation.component';


const appRoutes: Routes = [
  { path: 'account', component: AccountComponent },
  { path: 'login'  , component: LoginComponent },
  { path: 'home'  , component: HomeComponent },
  { path: 'register'  , component: RegisterComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    NavigationComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } 
    ),
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule
 ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
