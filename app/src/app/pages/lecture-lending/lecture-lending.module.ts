import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LectureLendingPageRoutingModule } from './lecture-lending-routing.module';

import { LectureLendingPage } from './lecture-lending.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    LectureLendingPageRoutingModule
  ],
  declarations: [LectureLendingPage]
})
export class LectureLendingPageModule {}
