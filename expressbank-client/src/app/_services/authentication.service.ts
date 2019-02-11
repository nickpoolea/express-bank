import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseUrl = 'http://localhost:8080/session/';
  options = { withCredentials: false };

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {

    const payload = { username, password };

    return this.http
      .post(this.baseUrl + "login", payload, this.options)
      .pipe(map(
        user => {
          localStorage.setItem('currentUser', JSON.stringify(user));
        },
        err => {
          console.log('Encountered error logging in ' + err);
        }
      ));
  }

  logout() {
    console.log("Removing User!");
    localStorage.removeItem('currentUser');
  }

  register(firstName: string, lastName: string, email: string, username: string, password: string) {

    const payload = { firstName, lastName, email, username, password };

    return this.http
      .post(this.baseUrl + "register", payload, this.options)
      .pipe(map(
        user => {
          localStorage.setItem('currentUser', JSON.stringify(user));
        },
        err => {
          console.log('Encountered error registering ' + err);
        }
      ));
  }

}
