import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import { AlertController } from '@ionic/angular';


@Component({
  selector: 'app-lecture-lending',
  templateUrl: './lecture-lending.page.html',
  styleUrls: ['./lecture-lending.page.scss'],
})
export class LectureLendingPage implements OnInit {

  answ:string;
  answ$:object
  message;

  constructor(public http:HttpService,public alertController: AlertController) { }

  ngOnInit() {
    this.http.getAnswers().subscribe(http =>{
      this.answ$ = http
    });
  }

  sendEmail(email)
  {
    this.http.sendEmail(email,this.message).subscribe();
    this.presentAlert();
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Alert',
      subHeader: 'Thank you.',
      message: 'Your email has been sent!',
      buttons: ['OK']
    });
  
    await alert.present();
  }

}
