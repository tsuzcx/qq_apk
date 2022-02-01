package com.google.common.io;

import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

class CharSource$CharSequenceCharSource$1$1
  extends AbstractIterator<String>
{
  Iterator<String> lines = CharSource.CharSequenceCharSource.access$200().split(CharSource.CharSequenceCharSource.access$100(this.this$1.this$0)).iterator();
  
  CharSource$CharSequenceCharSource$1$1(CharSource.CharSequenceCharSource.1 param1) {}
  
  protected String computeNext()
  {
    if (this.lines.hasNext())
    {
      String str = (String)this.lines.next();
      if ((this.lines.hasNext()) || (!str.isEmpty())) {
        return str;
      }
    }
    return (String)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.CharSource.CharSequenceCharSource.1.1
 * JD-Core Version:    0.7.0.1
 */