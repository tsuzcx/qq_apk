package com.google.common.base;

final class Splitter$3
  implements Splitter.Strategy
{
  Splitter$3(CommonPattern paramCommonPattern) {}
  
  public Splitter.SplittingIterator iterator(Splitter paramSplitter, CharSequence paramCharSequence)
  {
    return new Splitter.3.1(this, paramSplitter, paramCharSequence, this.val$separatorPattern.matcher(paramCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Splitter.3
 * JD-Core Version:    0.7.0.1
 */