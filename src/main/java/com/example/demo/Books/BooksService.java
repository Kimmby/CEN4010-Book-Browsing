package com.example.demo.Books;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

  private final BooksRepository booksRepository;

  @Autowired
  public BooksService(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  public List<Books> getBooks() {
    return booksRepository.findAll();
  }

  //POST method to add to the database
  public void addNewBook(Books books) {
    System.out.println(books);
    booksRepository.save(books);
  }

  //genre
  public List<Books> getBookByGenre(String genre) {
    return booksRepository.findByGenre(genre);
  }

  //top 10
  public List<Books> getTopTen(){
    return booksRepository.findTop10ByOrderByCopiesSoldDesc();
  }

  //rating
  public List<Books> getBookByRating(double rating){
    return booksRepository.findAllByRatingGreaterThanEqual(rating);
  }

  //amt of books entered by user
  public List<Sorting> getBookByX(int index){
    List<Sorting> books = new ArrayList<>();
    for(int i = 0; i < index; i++){
      books.add(sortingRepository.findAll().get(i));
    }
    return books;
  }

}
