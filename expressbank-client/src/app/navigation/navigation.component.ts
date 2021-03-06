import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  loggedIn: boolean = false;

  constructor(private auth: AuthenticationService) { }

  ngOnInit() {}
  

  logout() {
    console.log("This is running logout");
    this.auth.logout();
  }

}
