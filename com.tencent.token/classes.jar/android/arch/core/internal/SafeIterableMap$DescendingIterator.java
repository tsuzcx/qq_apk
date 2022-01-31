package android.arch.core.internal;

class SafeIterableMap$DescendingIterator
  extends SafeIterableMap.ListIterator
{
  SafeIterableMap$DescendingIterator(SafeIterableMap.Entry paramEntry1, SafeIterableMap.Entry paramEntry2)
  {
    super(paramEntry1, paramEntry2);
  }
  
  SafeIterableMap.Entry backward(SafeIterableMap.Entry paramEntry)
  {
    return paramEntry.mNext;
  }
  
  SafeIterableMap.Entry forward(SafeIterableMap.Entry paramEntry)
  {
    return paramEntry.mPrevious;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.DescendingIterator
 * JD-Core Version:    0.7.0.1
 */