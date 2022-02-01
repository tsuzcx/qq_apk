package com.tencent.mqp.app.sec;

final class d$1
  implements Runnable
{
  d$1(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if ((this.val$type != -1) && (this.u != null) && (this.val$data != null)) {}
    try
    {
      d.e(this.val$type, this.u, this.val$data);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.d.1
 * JD-Core Version:    0.7.0.1
 */