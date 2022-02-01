package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@GwtCompatible
public abstract class Escaper
{
  private final Function<String, String> asFunction = new Escaper.1(this);
  
  public final Function<String, String> asFunction()
  {
    return this.asFunction;
  }
  
  public abstract String escape(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.Escaper
 * JD-Core Version:    0.7.0.1
 */