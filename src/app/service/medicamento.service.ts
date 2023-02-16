import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Medicamento } from '../model/medicamento';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicamentoService {

  medicamentoActualizar = new Subject<Medicamento[]>();

  private url: string = 'http://localhost:8080/api/medicamento/'

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Medicamento[]>(this.url+'all');
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}delete/${id}`);
  }

  editar(id: number, medicamento: Medicamento){
    return this.http.put(this.url+'update/'+id, medicamento);
  }

  registrar(medicamento: Medicamento){
    return this.http.post(this.url+'save', medicamento);
  }
}


