import { Component, OnInit, inject } from '@angular/core';
import { StockServiceService } from './_services/stock-service.service';
import { Stock } from './_models/Stock';

@Component({
  selector: 'app-stock',
  standalone: true,
  imports: [],
  templateUrl: './stock.component.html',
  styleUrl: './stock.component.css'
})
export class StockComponent {
  
  stockService: StockServiceService = inject(StockServiceService);
  stock: Stock | null = null;
  
  updateStocks() {
    this.stockService.updateStocks();
    this.stockService.getStock(1).subscribe(stock => this.stock = stock)
  }
}
