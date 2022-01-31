package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

class SafeIterableMap$IteratorWithAdditions
  implements SafeIterableMap.SupportRemove, Iterator
{
  private boolean mBeforeStart = true;
  private SafeIterableMap.Entry mCurrent;
  
  private SafeIterableMap$IteratorWithAdditions(SafeIterableMap paramSafeIterableMap) {}
  
  public boolean hasNext()
  {
    if (this.mBeforeStart) {
      if (SafeIterableMap.access$100(this.this$0) == null) {}
    }
    while ((this.mCurrent != null) && (this.mCurrent.mNext != null))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public Map.Entry next()
  {
    if (this.mBeforeStart)
    {
      this.mBeforeStart = false;
      this.mCurrent = SafeIterableMap.access$100(this.this$0);
      return this.mCurrent;
    }
    if (this.mCurrent != null) {}
    for (SafeIterableMap.Entry localEntry = this.mCurrent.mNext;; localEntry = null)
    {
      this.mCurrent = localEntry;
      break;
    }
  }
  
  public void supportRemove(@NonNull SafeIterableMap.Entry paramEntry)
  {
    if (paramEntry == this.mCurrent)
    {
      this.mCurrent = this.mCurrent.mPrevious;
      if (this.mCurrent != null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.mBeforeStart = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.IteratorWithAdditions
 * JD-Core Version:    0.7.0.1
 */