package com.tencent.theme;

public abstract interface SkinEngineHandler
{
  public abstract boolean onDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean);
  
  public abstract boolean onDecodeReturnNullBitmap(String paramString, boolean paramBoolean);
  
  public abstract boolean onSecondDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngineHandler
 * JD-Core Version:    0.7.0.1
 */