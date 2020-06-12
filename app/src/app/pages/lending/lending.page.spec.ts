import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { LendingPage } from './lending.page';

describe('LendingPage', () => {
  let component: LendingPage;
  let fixture: ComponentFixture<LendingPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LendingPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(LendingPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
