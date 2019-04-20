import { Component, OnInit } from '@angular/core';
import { ApiGatewayService } from './service/api-gateway.service';
import { ResponseApi } from './model/response-api.model';
import { ApiGatewayServiceImpl } from './service/impl/api-gateway.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'master-microservice-client';
  private apiGatewayService: ApiGatewayService;
  response: ResponseApi;
  allFromAndTo: any;
  forms: FormGroup;

  constructor(private apiGatewayServiceImpl: ApiGatewayServiceImpl, private formBuilder: FormBuilder) {
    this.apiGatewayService = this.apiGatewayServiceImpl;
  }

  ngOnInit(): void {
    this.instanceOfForms();
    this.apiGatewayService.getAllExchange().subscribe(response => {
      this.allFromAndTo = response;
    });
  }

  private instanceOfForms() {
    this.forms = this.formBuilder.group({
      from: [null, [Validators.required]],
      to: [null, [Validators.required]],
      qtd: [null, [Validators.required]]
    });
  }

  public callServiceGateway() {
    this.apiGatewayService
            .getResponseApi(this.forms.get('from').value, this.forms.get('to').value, this.forms.get('qtd').value)
              .subscribe(res => {
      this.response = res;
    });
  }
}
