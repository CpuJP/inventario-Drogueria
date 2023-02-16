import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Venta } from '../model/venta';

@Injectable({
  providedIn: 'root'
})
export class VentaService {

  private url: string = 'http://localhost:8080/api/venta/'

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Venta[]>(this.url+'all');
  }
}
