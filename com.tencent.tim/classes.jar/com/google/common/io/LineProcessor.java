package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@Beta
@GwtIncompatible
public abstract interface LineProcessor<T>
{
  public abstract T getResult();
  
  @CanIgnoreReturnValue
  public abstract boolean processLine(String paramString)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.LineProcessor
 * JD-Core Version:    0.7.0.1
 */