package com.tencent.mobileqq.app;

import RegisterProxySvcPack.SvcRespParam;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class RegisterProxySvcPackHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "RegisterProxySvcPack";
  private boolean a = false;
  private int b = 0;
  private int c = 1;
  private int d = 1;
  
  RegisterProxySvcPackHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class a()
  {
    return RegisterProxySvcPackObserver.class;
  }
  
  public void a()
  {
    a(a("RegPrxySvc.infoAndroid"));
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid")) {
      QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PushParam")) {
      return;
    }
    if (paramObject != null)
    {
      paramToServiceMsg = (SvcRespParam)paramObject;
      int i = paramToServiceMsg.PCstat;
      if (paramToServiceMsg.iIsSupportDataLine == 2) {
        i = 0;
      }
      a(i);
      b(paramToServiceMsg.iIsSupportDataLine);
      c(paramToServiceMsg.iIsSupportViewPCFile);
      QLog.d("RegisterProxySvcPack", 2, "online status of pc: state:" + paramToServiceMsg.PCstat + "- ram:" + paramToServiceMsg.iIsSupportC2CRoamMsg + "- supportdataline:" + paramToServiceMsg.iIsSupportDataLine);
      a(1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.iIsSupportDataLine) });
      return;
    }
    QLog.d("RegisterProxySvcPack", 2, "RegPrxySvc.PushParam is null");
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int c()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackHandler
 * JD-Core Version:    0.7.0.1
 */