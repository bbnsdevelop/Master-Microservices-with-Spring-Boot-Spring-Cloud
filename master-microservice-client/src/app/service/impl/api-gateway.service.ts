import { Injectable } from '@angular/core';
import { ApiGatewayService } from '../api-gateway.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API } from '../../config/conguration-api';

@Injectable({
  providedIn: 'root'
})

export class ApiGatewayServiceImpl implements ApiGatewayService {

  private SERVICE = 'currency-conversion-service';
  private URL = 'currency-converter-feign';
  private URL_GET_ALL_EXCHANGE = 'currency-converter-feign/all-exchange';

  constructor(private http: HttpClient) {
  }

  getResponseApi(from: any, to: any, qtd: any): Observable<any> {
    return this.http.get(`${API}/${this.SERVICE}/${this.URL}/from/${from}/to/${to}/quantity/${qtd}`);
  }

  getAllExchange(): Observable<any> {
    return this.http.get(`${API}/${this.SERVICE}/${this.URL_GET_ALL_EXCHANGE}`);
  }
}
