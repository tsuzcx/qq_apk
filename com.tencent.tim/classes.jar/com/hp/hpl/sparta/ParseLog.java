package com.hp.hpl.sparta;

public abstract interface ParseLog
{
  public abstract void error(String paramString1, String paramString2, int paramInt);
  
  public abstract void note(String paramString1, String paramString2, int paramInt);
  
  public abstract void warning(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.ParseLog
 * JD-Core Version:    0.7.0.1
 */