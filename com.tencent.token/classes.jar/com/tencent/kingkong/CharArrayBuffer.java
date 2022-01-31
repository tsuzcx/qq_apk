package com.tencent.kingkong;

public final class CharArrayBuffer
{
  public char[] data;
  public int sizeCopied;
  
  public CharArrayBuffer(int paramInt)
  {
    this.data = new char[paramInt];
  }
  
  public CharArrayBuffer(char[] paramArrayOfChar)
  {
    this.data = paramArrayOfChar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.CharArrayBuffer
 * JD-Core Version:    0.7.0.1
 */