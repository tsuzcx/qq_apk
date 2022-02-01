package com.google.common.base;

import java.util.Iterator;

class Converter$1$1
  implements Iterator<B>
{
  private final Iterator<? extends A> fromIterator = this.this$1.val$fromIterable.iterator();
  
  Converter$1$1(Converter.1 param1) {}
  
  public boolean hasNext()
  {
    return this.fromIterator.hasNext();
  }
  
  public B next()
  {
    return this.this$1.this$0.convert(this.fromIterator.next());
  }
  
  public void remove()
  {
    this.fromIterator.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Converter.1.1
 * JD-Core Version:    0.7.0.1
 */