package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class Striped$2
  implements Supplier<Lock>
{
  public Lock get()
  {
    return new ReentrantLock(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Striped.2
 * JD-Core Version:    0.7.0.1
 */