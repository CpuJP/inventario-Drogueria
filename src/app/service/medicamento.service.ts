import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Medicamento } from '../model/medicamento';

@Injectable({
  providedIn: 'root'
})
export class MedicamentoService {

  private url: string = 'http://localhost:8080/api/medicamento/'

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Medicamento[]>(this.url+'all');
  }
}
