import { Component } from '@angular/core';
import {RegistrationRequest} from "../../services/models/registration-request";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registerRequest: RegistrationRequest = {email: '', firstName: '', lastName:'', password: ''};
  errorMsg: Array<string> = [];

  constructor(
    private route: Router,
    private authService: AuthenticationService,
  ) {}

  register() {
    this.errorMsg = [];
    this.authService.register({
      body: this.registerRequest
    }).subscribe({
      next: ()=>{
        this.route.navigate(["activate-account"]);
      },
      error:(err)=>{
        this.errorMsg = err.error.validationErrors;
      }
    })
  }

  login() {
      this.route.navigate(["login"]);
  }
}
