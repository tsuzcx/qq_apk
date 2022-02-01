package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated=true)
final class Platform
{
  private static final ThreadLocal<char[]> DEST_TL = new Platform.1();
  
  static char[] charBufferFromThreadLocal()
  {
    return (char[])DEST_TL.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.Platform
 * JD-Core Version:    0.7.0.1
 */