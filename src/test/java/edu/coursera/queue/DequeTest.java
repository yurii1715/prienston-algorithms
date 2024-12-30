package edu.coursera.queue;

import edu.coursera.percolation.Deque;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    public void test() {
        Deque<String> deque = new Deque<String>();

        assertThat(deque.isEmpty()).isTrue();

        assertThrows(NoSuchElementException.class, deque::removeFirst);
        assertThrows(NoSuchElementException.class, deque::removeLast);

        deque.addFirst("1");
        assertThat(deque.removeLast()).isEqualTo("1");

        assertThrows(NoSuchElementException.class, deque::removeFirst);
        assertThrows(NoSuchElementException.class, deque::removeLast);

        deque.addLast("2");
        assertThat(deque.removeFirst()).isEqualTo("2");

        deque.addFirst("3");
        assertThat(deque.removeFirst()).isEqualTo("3");

        deque.addLast("4");
        assertThat(deque.removeLast()).isEqualTo("4");

        deque.addLast("5");
        deque.addFirst("6");
        deque.addFirst("7");
        deque.addFirst("8");

        assertThat(deque.removeLast()).isEqualTo("5");
        assertThat(deque.removeLast()).isEqualTo("6");
        assertThat(deque.removeFirst()).isEqualTo("8");
        assertThat(deque.removeFirst()).isEqualTo("7");
    }

    @Test
    public void testIterator() {
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        deque.addFirst(7);
        deque.addLast(8);
        deque.addFirst(9);

        Iterator<Integer> iterator = deque.iterator();

        assertThat(iterator.next()).isEqualTo(9);
        assertThat(iterator.next()).isEqualTo(7);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(5);
        assertThat(iterator.next()).isEqualTo(6);
        assertThat(iterator.next()).isEqualTo(8);
    }
}