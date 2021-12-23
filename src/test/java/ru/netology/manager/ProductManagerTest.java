package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book0 = new Book(1, "Alphabet", 49, "Author");
    Book book1 = new Book(3, "Java", 99, "You");
    Book book2 = new Book(5, "English", 79, "Teacher");

    Smartphone smartphone0 = new Smartphone(2, "Model1", 199, "Siemens");
    Smartphone smartphone1 = new Smartphone(4, "Model2", 199, "Motorola");
    Smartphone smartphone2 = new Smartphone(6, "Model3", 199, "Siemens");

    Product product0 = new Product(11, "Product", 699);

    @BeforeEach
    public void setUp() {
        manager.add(book0);
        manager.add(book1);
        manager.add(book2);

        manager.add(smartphone0);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.add(product0);
    }


    @Test
    public void shouldSearchByNameBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("English");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("You");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("They");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Model3");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducer() {
        Product[] expected = {smartphone0, smartphone2};
        Product[] actual = manager.searchBy("Siemens");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProducer() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }
}