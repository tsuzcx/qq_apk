package com.google.common.base;

import java.util.Iterator;

class Optional$1$1
  extends AbstractIterator<T>
{
  private final Iterator<? extends Optional<? extends T>> iterator = (Iterator)Preconditions.checkNotNull(this.this$0.val$optionals.iterator());
  
  Optional$1$1(Optional.1 param1) {}
  
  protected T computeNext()
  {
    while (this.iterator.hasNext())
    {
      Optional localOptional = (Optional)this.iterator.next();
      if (localOptional.isPresent()) {
        return localOptional.get();
      }
    }
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Optional.1.1
 * JD-Core Version:    0.7.0.1
 */