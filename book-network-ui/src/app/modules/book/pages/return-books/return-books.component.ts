import {Component, OnInit} from '@angular/core';
import {PageResponseBorrowedResponse} from "../../../../services/models/page-response-borrowed-response";
import {BookService} from "../../../../services/services/book.service";
import {FeedbacksService} from "../../../../services/services/feedbacks.service";
import {BorrowedResponse} from "../../../../services/models/borrowed-response";

@Component({
  selector: 'app-return-books',
  templateUrl: './return-books.component.html',
  styleUrl: './return-books.component.css'
})
export class ReturnBooksComponent implements OnInit {
  returnedBooks: PageResponseBorrowedResponse= {};
  page = 0;
  size = 5;
  pages: any = [];
  message: string = '';
  level: string = 'success';

  constructor(
    private bookService: BookService,
  ) {
  }

  ngOnInit(): void {
    this.findAllReturnedBooks();
  }

  private findAllReturnedBooks() {
    this.bookService.findAllReturnedBooks({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (resp) => {
        console.log(resp);
        this.returnedBooks = resp;
        this.pages = Array(this.returnedBooks.totalPages)
          .fill(0)
          .map((x, i) => i);
      }
    });

  }

  gotToPage(page: number) {
    this.page = page;
    this.findAllReturnedBooks();
  }

  goToFirstPage() {
    this.page = 0;
    this.findAllReturnedBooks();
  }

  goToPreviousPage() {
    this.page--;
    this.findAllReturnedBooks();
  }

  goToLastPage() {
    this.page = this.returnedBooks.totalPages as number - 1;
    this.findAllReturnedBooks();
  }

  goToNextPage() {
    this.page++;
    this.findAllReturnedBooks();
  }

  get isLastPage() {
    return this.page === this.returnedBooks.totalPages as number - 1;
  }

  approveBookReturn(book: BorrowedResponse) {
    if (!book.returned){
      this.level = 'error';
      this.message = 'The book is not yet returned';
      return;
    }
    this.bookService.approveReturnBorrowBook({
      'book-id': book.id as number
    }).subscribe({
      next: ()=>{
        this.level = 'success';
        this.message = 'Book return approved';
        this.findAllReturnedBooks();
      }
    })
  }
}
