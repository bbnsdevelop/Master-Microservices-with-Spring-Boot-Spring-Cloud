import { TestBed } from '@angular/core/testing';

import { ApiGatewayService } from './api-gateway.service';

describe('ApiGatewayService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiGatewayService = TestBed.get(ApiGatewayService);
    expect(service).toBeTruthy();
  });
});
