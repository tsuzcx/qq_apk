package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class SafeIterableMap$ListIterator
  implements SafeIterableMap.SupportRemove, Iterator
{
  SafeIterableMap.Entry mExpectedEnd;
  SafeIterableMap.Entry mNext;
  
  SafeIterableMap$ListIterator(SafeIterableMap.Entry paramEntry1, SafeIterableMap.Entry paramEntry2)
  {
    this.mExpectedEnd = paramEntry2;
    this.mNext = paramEntry1;
  }
  
  private SafeIterableMap.Entry nextNode()
  {
    if ((this.mNext == this.mExpectedEnd) || (this.mExpectedEnd == null)) {
      return null;
    }
    return forward(this.mNext);
  }
  
  abstract SafeIterableMap.Entry backward(SafeIterableMap.Entry paramEntry);
  
  abstract SafeIterableMap.Entry forward(SafeIterableMap.Entry paramEntry);
  
  public boolean hasNext()
  {
    return this.mNext != null;
  }
  
  public Map.Entry next()
  {
    SafeIterableMap.Entry localEntry = this.mNext;
    this.mNext = nextNode();
    return localEntry;
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry paramEntry)
  {
    if ((this.mExpectedEnd == paramEntry) && (paramEntry == this.mNext))
    {
      this.mNext = null;
      this.mExpectedEnd = null;
    }
    if (this.mExpectedEnd == paramEntry) {
      this.mExpectedEnd = backward(this.mExpectedEnd);
    }
    if (this.mNext == paramEntry) {
      this.mNext = nextNode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.ListIterator
 * JD-Core Version:    0.7.0.1
 */