import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { LectureLendingPage } from './lecture-lending.page';

describe('LectureLendingPage', () => {
  let component: LectureLendingPage;
  let fixture: ComponentFixture<LectureLendingPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LectureLendingPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(LectureLendingPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
