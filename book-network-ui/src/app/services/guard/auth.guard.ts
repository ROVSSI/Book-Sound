import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {TokenService} from "../token/token.service";

export const authGuard: CanActivateFn = () => {
  const tokenService = inject(TokenService);
  const route = inject(Router);
  if (tokenService.isTokenNotValid()){
    route.navigate(['login']);
    return false;
  }
  return true;
};
