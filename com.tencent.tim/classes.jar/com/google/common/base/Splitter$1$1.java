package com.google.common.base;

class Splitter$1$1
  extends Splitter.SplittingIterator
{
  Splitter$1$1(Splitter.1 param1, Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  int separatorEnd(int paramInt)
  {
    return paramInt + 1;
  }
  
  int separatorStart(int paramInt)
  {
    return this.this$0.val$separatorMatcher.indexIn(this.toSplit, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Splitter.1.1
 * JD-Core Version:    0.7.0.1
 */