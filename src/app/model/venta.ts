import { Medicamento } from "./medicamento";

export class Venta {
    id!: number;
    fechaHora!: string;
    medicamento!: Medicamento;
    cantidad!: number;
    valorUnitario!: bigint;
    valorTotal!: bigint;
}