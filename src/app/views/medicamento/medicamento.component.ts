import { Component } from '@angular/core';
import { Medicamento } from 'src/app/model/medicamento';
import { MedicamentoService } from 'src/app/service/medicamento.service';

@Component({
  selector: 'app-medicamento',
  templateUrl: './medicamento.component.html',
  styleUrls: ['./medicamento.component.scss']
})
export class MedicamentoComponent {

  medicamento!: Medicamento[];

  constructor(private medicamentoService: MedicamentoService) { }

  ngOnInit(): void {
    this.medicamentoService.listar().subscribe(data => this.medicamento=data);
  }

}
