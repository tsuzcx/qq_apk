package com.google.common.base;

class Splitter$3$1
  extends Splitter.SplittingIterator
{
  Splitter$3$1(Splitter.3 param3, Splitter paramSplitter, CharSequence paramCharSequence, CommonMatcher paramCommonMatcher)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public int separatorEnd(int paramInt)
  {
    return this.val$matcher.end();
  }
  
  public int separatorStart(int paramInt)
  {
    if (this.val$matcher.find(paramInt)) {
      return this.val$matcher.start();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Splitter.3.1
 * JD-Core Version:    0.7.0.1
 */