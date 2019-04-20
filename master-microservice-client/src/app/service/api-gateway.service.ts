import { Observable } from 'rxjs';

export interface ApiGatewayService {

  getResponseApi(from: any, to: any, qtd: any): Observable<any>;
  getAllExchange(): Observable<any>;

}
