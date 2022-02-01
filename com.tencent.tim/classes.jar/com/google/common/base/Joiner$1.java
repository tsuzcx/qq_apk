package com.google.common.base;

import javax.annotation.Nullable;

class Joiner$1
  extends Joiner
{
  Joiner$1(Joiner paramJoiner1, Joiner paramJoiner2, String paramString)
  {
    super(paramJoiner2, null);
  }
  
  public Joiner skipNulls()
  {
    throw new UnsupportedOperationException("already specified useForNull");
  }
  
  CharSequence toString(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return this.val$nullText;
    }
    return this.this$0.toString(paramObject);
  }
  
  public Joiner useForNull(String paramString)
  {
    throw new UnsupportedOperationException("already specified useForNull");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Joiner.1
 * JD-Core Version:    0.7.0.1
 */