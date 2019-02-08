import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';

const appRoutes: Routes = [
  { path: 'account', component: AccountComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    AccountComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } 
    ),
    BrowserModule,
    RouterModule,
 ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
