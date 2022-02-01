package moai.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 并行先进后出队列
 */
public final class BlockingLIFOQueue<T> implements BlockingQueue<T>
{
    private final BlockingDeque<T> deque;

    public BlockingLIFOQueue(int limit) {
        deque = new LinkedBlockingDeque<>(limit);
    }

    public boolean add(T e) {
        deque.addLast(e);
        return true;
    }

    public boolean contains(Object o) {
        return deque.contains(o);
    }

    public int drainTo(Collection<? super T> c) {
        return deque.drainTo(c);
    }

    public int drainTo(Collection<? super T> c, int maxElements) {
        return deque.drainTo(c,maxElements);
    }

    public boolean offer(T e) {
        return deque.offerLast(e);
    }

    public boolean offer(T e, long timeout, TimeUnit unit) throws InterruptedException {
        return deque.offerLast(e,timeout,unit);
    }

    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        return deque.pollLast(timeout, unit);
    }

    public void put(T e) throws InterruptedException {
        deque.putLast(e);
    }

    public int remainingCapacity() {
        return deque.size();
    }

    public boolean remove(Object o) {
        return deque.remove(o);
    }

    public T take() throws InterruptedException {
        return deque.takeLast();
    }

    public T element() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException("empty stack");
        }

        return deque.pollLast();
    }

    public T peek() {
        return deque.peekLast();
    }

    public T poll() {
        return deque.pollLast();
    }

    public T remove() {
        if (deque.isEmpty()) {
            throw new NoSuchElementException("empty stack");
        }

        return deque.pollLast();
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) { deque.add(e); }
        return true;
    }

    public void clear() {
        deque.clear();
    }

    public boolean containsAll(Collection<?> c){
        return deque.containsAll(c);
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public Iterator<T> iterator() {
        return deque.descendingIterator();
    }

    public boolean removeAll(Collection<?> c) {
        return deque.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return deque.retainAll(c);
    }

    public int size() {
        return deque.size();
    }

    public Object[] toArray() {
        return deque.toArray();
    }

    public <R> R[] toArray(R[] a) {
        return deque.toArray(a);
    }
}