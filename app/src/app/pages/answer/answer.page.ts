import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';



@Component({
  selector: 'app-answer',
  templateUrl: './answer.page.html',
  styleUrls: ['./answer.page.scss'],
})
export class AnswerPage implements OnInit {


  ques:string;
  ques$:object;
  topic;
  id;
  answer;
  topicData:any = {};
  answ:string;
  answ$:object;


  constructor(public alertController: AlertController,public http:HttpService,public route: ActivatedRoute) 
  {
    this.id = this.route.snapshot.paramMap.get('id');
    // this.topicData = JSON.parse(localStorage.getItem('TopicData'));

    if (localStorage.getItem('TopicData') !== undefined) {
      this.topicData = JSON.parse(localStorage.getItem('TopicData'));
    }

  }

  ngOnInit() {
    this.http.getQuestionById(this.id).subscribe(http =>{
      this.ques$ = http;
    });
    this.getAnswerByQid();  
  }

  getAnswerByQid()
  {
    this.http.getAnswerByQid(this.id).subscribe(http =>{
      this.answ$ = http;
    });
  }


  postAnswer()
  {

    // convert id to int
    var id:Number = +this.id;

    let answerData = 
    {
      answer: this.answer,
      qid: id,
      tid: this.topicData,
      email: "123@gmail.com",
      studentNo: 215007194,
      rate: 0
    }
    this.presentAlert();
    this.doRefresh(event);
    this.http.postAnswer(answerData).subscribe();
    console.log(answerData);
  }

  doRefresh(event) {      
    setTimeout(() => {
    this.getAnswerByQid();
      event.target.complete();
    }, 3000);
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Alert',
      subHeader: 'Subtitle',
      message: 'Your answer has been posted.',
      buttons: ['OK']
    });
  
    await alert.present();
  }


  positiveRate(aid)
  {
    this.http.positiveRate(aid).subscribe();
    this.positiveRateanswer();
  }

  negativeRate(aid)
  {
    this.http.negativeRate(aid).subscribe();
    this.positiveRateanswer();
  }


  async positiveRateanswer() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Alert',
      subHeader: 'Subtitle',
      message: 'Thank you for your feedback.',
      buttons: ['OK']
    });
  
    await alert.present();
  }

}
