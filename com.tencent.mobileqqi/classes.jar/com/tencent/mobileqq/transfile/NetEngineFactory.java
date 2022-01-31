package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import mqq.manager.Manager;

public class NetEngineFactory
  implements Manager
{
  public static final int a = 0;
  public INetEngine a;
  public INetEngine b;
  
  public INetEngine a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a == null) {}
      try
      {
        if (this.a == null) {
          this.a = new OldHttpEngine(paramQQAppInterface.a(), false);
        }
        return this.a;
      }
      finally {}
    }
    return null;
  }
  
  public INetEngine a(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount)
  {
    if (this.b == null) {}
    try
    {
      this.b = new OldHttpEngine(new HttpCommunicator(paramIHttpCommunicatorFlowCount, 32), true);
      return this.b;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      ((OldHttpEngine)this.a).a();
    }
    if (this.b != null) {
      ((OldHttpEngine)this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetEngineFactory
 * JD-Core Version:    0.7.0.1
 */