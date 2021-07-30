package com.example.demo.Books;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //data access
public interface BooksRepository extends JpaRepository<Books,Integer> {


  //Retrieve List of books by Genre
  List<Books> findByGenre(String genre);

  //Retrieve List of top 10 books in Descending order.
  List<Books> findTop10ByOrderByCopiesSoldDesc();

  //  Retrieve List of books for a particular rating or higher
  List<Books> findAllByRatingGreaterThanEqual(double rating);

  //Retrieve List of X Books at a time where X is an integer
//  List<Books> findAllByX(int X);
}
