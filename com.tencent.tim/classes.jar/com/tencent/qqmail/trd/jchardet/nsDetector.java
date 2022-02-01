package com.tencent.qqmail.trd.jchardet;

public class nsDetector
  extends nsPSMDetector
  implements nsICharsetDetector
{
  nsICharsetDetectionObserver mObserver = null;
  
  public nsDetector() {}
  
  public nsDetector(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean DoIt(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramBoolean)) {
      return false;
    }
    HandleData(paramArrayOfByte, paramInt);
    return this.mDone;
  }
  
  public void Done()
  {
    DataEnd();
  }
  
  public void Init(nsICharsetDetectionObserver paramnsICharsetDetectionObserver)
  {
    this.mObserver = paramnsICharsetDetectionObserver;
  }
  
  public void Report(String paramString)
  {
    if (this.mObserver != null) {
      this.mObserver.Notify(paramString);
    }
  }
  
  public boolean isAscii(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if ((paramArrayOfByte[i] & 0x80) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsDetector
 * JD-Core Version:    0.7.0.1
 */