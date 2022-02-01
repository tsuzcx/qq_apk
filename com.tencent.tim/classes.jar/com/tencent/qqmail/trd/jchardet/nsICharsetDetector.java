package com.tencent.qqmail.trd.jchardet;

public abstract interface nsICharsetDetector
{
  public abstract boolean DoIt(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
  
  public abstract void Done();
  
  public abstract void Init(nsICharsetDetectionObserver paramnsICharsetDetectionObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsICharsetDetector
 * JD-Core Version:    0.7.0.1
 */