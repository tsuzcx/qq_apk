package com.google.common.base;

class Splitter$4$1
  extends Splitter.SplittingIterator
{
  Splitter$4$1(Splitter.4 param4, Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public int separatorEnd(int paramInt)
  {
    return paramInt;
  }
  
  public int separatorStart(int paramInt)
  {
    paramInt = this.this$0.val$length + paramInt;
    if (paramInt < this.toSplit.length()) {
      return paramInt;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Splitter.4.1
 * JD-Core Version:    0.7.0.1
 */