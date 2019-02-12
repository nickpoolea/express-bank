import { Injectable } from '@angular/core';
import { AuthenticationService } from '../_services/authentication.service';
import { CanActivate } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private auth: AuthenticationService) { }

  canActivate() {
    return this.auth.loggedIn;
  }

}
