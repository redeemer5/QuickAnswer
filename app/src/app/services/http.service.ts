import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders, HttpErrorResponse} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(public http:HttpClient) { }

        // Http Options
        httpOptions = {
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'GET, PUT, POST, OPTIONS',
            'Access-Control-Allow-Headers': '*'
          })
        }
      
          // Handle API errors
          handleError(error: HttpErrorResponse) {
            if (error.error instanceof ErrorEvent) {
              // A client-side or network error occurred. Handle it accordingly.
              console.error('An error occurred:', error.error.message);
            } else {
              // The backend returned an unsuccessful response code.
              // The response body may contain clues as to what went wrong,
              console.error(
                `Backend returned code ${error.status}, ` +
                `body was: ${error.error}`);
            }
            // return an observable with a user-facing error message
            return throwError(
              'Something bad happened; please try again later.');
          };



  // gets all topic
  getTopics()
  {
    return this.http.get('http://localhost:8080/getTopics');
  }

  // get topic by id
  getTopicByid(id)
  {
    return this.http.get('http://localhost:8080/getTopic/' + id)
  }


  // post question
  postQuestion(questionData)
  {
    return this.http.post('http://localhost:8080/postQuestion', JSON.stringify(questionData), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  getQuestionByTopic(topic)
  {
    return this.http.get('http://localhost:8080/getQuestion/' + topic)
  }

  getQuestionById(qid)
  {
    return this.http.get('http://localhost:8080/getQuestionById/' + qid)
  }

    // post answer
    postAnswer(answerData)
    {
      return this.http.post('http://localhost:8080/postAnswer', JSON.stringify(answerData), this.httpOptions)
        .pipe(
          retry(1),
          catchError(this.handleError)
        )
    }

    // get answer by id
    getAnswerByQid(qid)
    {
      return this.http.get('http://localhost:8080/getAnswerByqid/' + qid);
    }

    // rate answer by answerId
    positiveRate(aid)
    {
      return this.http.get('http://localhost:8080/rateAnswer/' + aid);
    }

    // give a negative rate
    negativeRate(aid)
    {
      return this.http.get('http://localhost:8080/derateAnswer/' + aid);
    }

    // delete question
    deleteQuestion(qid)
    {
      return this.http.get('http://localhost:8080/deleteQuestion/' + qid);
    }

    // get answers
    getAnswers()
    {
      return this.http.get('http://localhost:8080/getAnswers');
    }

    sendEmail(email,message)
    {
      return this.http.get('http://localhost:8080/sendEmail/' + email +'/'+ message)
    }
}
