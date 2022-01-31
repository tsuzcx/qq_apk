package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

final class b
  extends Thread
{
  b(int paramInt) {}
  
  public void run()
  {
    if (this.a == 0) {
      a.a.onNetNone2Mobile();
    }
    do
    {
      return;
      if (this.a == 1)
      {
        a.a.onNetWifi2Mobile();
        return;
      }
      if (this.a == 2)
      {
        a.a.onNetNone2Wifi();
        return;
      }
      if (this.a == 3)
      {
        a.a.onNetMobile2Wifi();
        return;
      }
      if (this.a == 4)
      {
        a.a.onNetMobile2None();
        return;
      }
    } while (this.a != 5);
    a.a.onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b
 * JD-Core Version:    0.7.0.1
 */