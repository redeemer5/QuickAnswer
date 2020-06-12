import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { AlertController } from '@ionic/angular';



@Component({
  selector: 'app-questions',
  templateUrl: './questions.page.html',
  styleUrls: ['./questions.page.scss'],
})
export class QuestionsPage implements OnInit {

  topic$:object;
  topic:string;
  id;
  question;
  ques:string;
  ques$:object;
  

  constructor(public alertController: AlertController,public router:Router,public http:HttpService,public route: ActivatedRoute,public navCtr : NavController) 
  {
    this.id = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit() {
    this.getTopicById();
  }

  getTopicById()
  {
    var res;
    // gets topics by id
    this.http.getTopicByid(this.id).subscribe(http =>{
      this.topic$ = http;
      res = this.topic$[0].topic
      // console.log(this.topic$[0].topic)
      this.getQuestionbyTopic(res);

    });
  }

postQuestion(topic1)
{
  let postQuestiondData = 
  {
    topic:topic1,
    question:this.question
  }

  this.doRefresh(event);
  this.presentAlert();
  this.http.postQuestion(postQuestiondData).subscribe();


}


getQuestionbyTopic(topic)
{
  this.http.getQuestionByTopic(topic).subscribe(http =>{
    this.ques$ = http;
  })
}

goToAnswer(qid)
{
  localStorage.setItem('TopicData', JSON.parse(this.id));
  this.navCtr.navigateForward('/answer/' + qid)
}

doRefresh(event) {
  setTimeout(() => {
  this.getTopicById();
    event.target.complete();
  }, 3000);
}

async presentAlert() {
  const alert = await this.alertController.create({
    cssClass: 'my-custom-class',
    header: 'Alert',
    subHeader: 'Subtitle',
    message: 'Your question has been posted.',
    buttons: ['OK']
  });

  await alert.present();
}

deleteQuestion(qid)
{
  this.http.deleteQuestion(qid).subscribe();
  this.getTopicById();
}


}
