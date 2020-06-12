import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LectureLendingPage } from './lecture-lending.page';

const routes: Routes = [
  {
    path: '',
    component: LectureLendingPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LectureLendingPageRoutingModule {}
