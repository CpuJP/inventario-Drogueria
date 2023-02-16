import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Medicamento } from 'src/app/model/medicamento';
import { MedicamentoService } from 'src/app/service/medicamento.service';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { MedicamentoModalComponent } from './medicamento-modal/medicamento-modal.component';


@Component({
  selector: 'app-medicamento',
  templateUrl: './medicamento.component.html',
  styleUrls: ['./medicamento.component.scss']
})
export class MedicamentoComponent {

  displayedColumns = ['id', 'nombre', 'laboratorio', 'fechaFabricacion', 'fechaVencimiento', 'cantidadStock', 'valorUnitario', 'editar-eliminar'];

  dataSource!: MatTableDataSource<Medicamento>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;


  constructor(
    private dialog: MatDialog,
    private medicamentoService: MedicamentoService) { }

  ngOnInit(): void {
    this.medicamentoService.medicamentoActualizar.subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    })

    this.medicamentoService.listar().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  openModel(id?: number, medicamento?: Medicamento){
    let medi = medicamento != null ? medicamento: new Medicamento();
    this.dialog.open(MedicamentoModalComponent,{
      width: '260px',
      data: medicamento
    })
  }

  onDelete(id: number){
    let dialogRef = this.dialog.open(ConfirmDialogComponent,{
      disableClose: true,
    });
    dialogRef.afterClosed().subscribe(estado => {
      if(estado){
        this.medicamentoService.eliminar(id).subscribe(() => {
          this.medicamentoService.listar().subscribe(data => {
            this.dataSource = new MatTableDataSource(data);
          })
        })
      }
    })
  }

  filtrar(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
