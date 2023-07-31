package cn.teamhelper.library.util;

import cn.teamhelper.library.entity.Book;

import java.util.Collections;
import java.util.List;

public class BookSorter {

    public enum SortableFields {
        ID, TITLE, AUTHOR, STATUS
    }

    public static void sortBooks(List<Book> books, SortableFields sortBy) {
        switch (sortBy) {
            case ID -> books.sort(Book.IdComparator);
            case TITLE -> books.sort(Book.TitleComparator);
            case AUTHOR -> books.sort(Book.AuthorComparator);
            case STATUS -> books.sort(Book.StatusComparator);
        }
    }
}
