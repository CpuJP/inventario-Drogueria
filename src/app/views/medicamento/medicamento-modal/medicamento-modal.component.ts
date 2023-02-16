import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Medicamento } from 'src/app/model/medicamento';
import { Venta } from 'src/app/model/venta';
import { MedicamentoService } from 'src/app/service/medicamento.service';
import { VentaService } from 'src/app/service/venta.service';

@Component({
  selector: 'app-medicamento-modal',
  templateUrl: './medicamento-modal.component.html',
  styleUrls: ['./medicamento-modal.component.scss']
})
export class MedicamentoModalComponent {

  medicamento!: Medicamento;
  venta!: Venta[];

  constructor(
    private dialogRef: MatDialogRef<MedicamentoModalComponent>,
    private ventaService: VentaService,
    private medicamentoService: MedicamentoService,
    @Inject(MAT_DIALOG_DATA) private data: Medicamento){ }

  ngOnInit(): void {
    this.medicamento = new Medicamento();
    this.medicamento.id = this.data.id;
    this.medicamento.nombre = this.data.nombre;
    this.medicamento.laboratorio = this.data.laboratorio;
    this.medicamento.fechaFabricacion = this.data.fechaFabricacion;
    this.medicamento.fechaVencimiento = this.data.fechaVencimiento;
    this.medicamento.cantidadStock = this.data.cantidadStock;
    this.medicamento.valorUnitario= this.data.valorUnitario;

    this.ventaService.listar().subscribe(data => {
      this.venta=data;
    })
  }

  aceptar(){
    if(this.medicamento != null && this.medicamento.id > 0){
      this.medicamentoService.editar(this.medicamento.id, this.medicamento).subscribe(() => {
        return this.medicamentoService.listar().subscribe(data => {
          this.medicamentoService.medicamentoActualizar.next(data);
        })
      })
    } else {
      this.medicamentoService.registrar(this.medicamento).subscribe(()=>{
        this.medicamentoService.listar().subscribe(data => {
          this.medicamentoService.medicamentoActualizar.next(data);
        })
      })
    }
    
    this.cancelar();
  }

  cancelar(){
    this.dialogRef.close();
  }
}
