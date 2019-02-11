import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  constructor(
    private auth: AuthenticationService,
    private router: Router
    ) {}

  submitLogin() {
    this.auth

      .login(this.username, this.password)

      .subscribe(
        data => {
          this.router.navigate(['account']);
        },
        e => console.log("An error was encountered") + e
      );
  }

  ngOnInit() {
  }

}
