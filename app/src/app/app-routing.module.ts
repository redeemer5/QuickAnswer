import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'lending',
    pathMatch: 'full'
  },
  {
    path: 'lending',
    loadChildren: () => import('./pages/lending/lending.module').then( m => m.LendingPageModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'questions/:id',
    loadChildren: () => import('./pages/questions/questions.module').then( m => m.QuestionsPageModule)
  },
  {
    path: 'answer/:id',
    loadChildren: () => import('./pages/answer/answer.module').then( m => m.AnswerPageModule)
  },
  {
    path: 'lecture-lending',
    loadChildren: () => import('./pages/lecture-lending/lecture-lending.module').then( m => m.LectureLendingPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
