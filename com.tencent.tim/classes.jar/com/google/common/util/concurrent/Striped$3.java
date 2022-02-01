package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

final class Striped$3
  implements Supplier<Semaphore>
{
  Striped$3(int paramInt) {}
  
  public Semaphore get()
  {
    return new Striped.PaddedSemaphore(this.val$permits);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Striped.3
 * JD-Core Version:    0.7.0.1
 */