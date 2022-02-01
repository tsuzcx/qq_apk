package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

class Joiner$2
  extends Joiner
{
  Joiner$2(Joiner paramJoiner1, Joiner paramJoiner2)
  {
    super(paramJoiner2, null);
  }
  
  public <A extends Appendable> A appendTo(A paramA, Iterator<?> paramIterator)
    throws IOException
  {
    Preconditions.checkNotNull(paramA, "appendable");
    Preconditions.checkNotNull(paramIterator, "parts");
    Object localObject;
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null) {
        paramA.append(this.this$0.toString(localObject));
      }
    }
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null)
      {
        paramA.append(Joiner.access$100(this.this$0));
        paramA.append(this.this$0.toString(localObject));
      }
    }
    return paramA;
  }
  
  public Joiner useForNull(String paramString)
  {
    throw new UnsupportedOperationException("already specified skipNulls");
  }
  
  public Joiner.MapJoiner withKeyValueSeparator(String paramString)
  {
    throw new UnsupportedOperationException("can't use .skipNulls() with maps");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Joiner.2
 * JD-Core Version:    0.7.0.1
 */