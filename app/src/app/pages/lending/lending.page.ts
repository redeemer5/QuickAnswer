import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../services/http.service';
import { NavController } from '@ionic/angular';


@Component({
  selector: 'app-lending',
  templateUrl: './lending.page.html',
  styleUrls: ['./lending.page.scss'],
})
export class LendingPage implements OnInit {

  topic$:object;
  topic:string;
  topicData$;

  constructor(public http:HttpService,public navCtr : NavController) { }

  ngOnInit() {
    this.http.getTopics().subscribe(http =>{
      this.topic$ = http
    })
  }

  getTopic(id)
  {
    this.navCtr.navigateForward('/questions/' + id)
  }

}
