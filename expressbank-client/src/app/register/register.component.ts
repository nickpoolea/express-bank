import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private firstName: string;
  private lastName: string;
  private email: string;
  private username: string;
  private password: string;

  constructor(
    private auth: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit() {
  }
  
  submitRegistration() {

    this.auth

      .register(this.firstName, this.lastName, this.email, this.username, this.password)

      .subscribe(
        data => {
          this.router.navigate(['account']);
        },
        e => console.log("An error was encountered") + e
      );
  }

}
