package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

final class Striped$5
  implements Supplier<ReadWriteLock>
{
  public ReadWriteLock get()
  {
    return new ReentrantReadWriteLock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Striped.5
 * JD-Core Version:    0.7.0.1
 */