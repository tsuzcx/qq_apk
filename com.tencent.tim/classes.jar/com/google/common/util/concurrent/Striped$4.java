package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

final class Striped$4
  implements Supplier<Semaphore>
{
  Striped$4(int paramInt) {}
  
  public Semaphore get()
  {
    return new Semaphore(this.val$permits, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Striped.4
 * JD-Core Version:    0.7.0.1
 */