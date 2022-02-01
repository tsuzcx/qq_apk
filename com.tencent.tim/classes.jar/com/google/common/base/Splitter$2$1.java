package com.google.common.base;

class Splitter$2$1
  extends Splitter.SplittingIterator
{
  Splitter$2$1(Splitter.2 param2, Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public int separatorEnd(int paramInt)
  {
    return this.this$0.val$separator.length() + paramInt;
  }
  
  public int separatorStart(int paramInt)
  {
    int k = this.this$0.val$separator.length();
    int m = this.toSplit.length();
    if (paramInt <= m - k)
    {
      int i = 0;
      for (;;)
      {
        j = paramInt;
        if (i >= k) {
          return j;
        }
        if (this.toSplit.charAt(i + paramInt) != this.this$0.val$separator.charAt(i))
        {
          paramInt += 1;
          break;
        }
        i += 1;
      }
    }
    int j = -1;
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Splitter.2.1
 * JD-Core Version:    0.7.0.1
 */