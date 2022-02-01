package org.apache.commons.lang3.concurrent;

public abstract interface ConcurrentInitializer<T>
{
  public abstract T get()
    throws ConcurrentException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.ConcurrentInitializer
 * JD-Core Version:    0.7.0.1
 */