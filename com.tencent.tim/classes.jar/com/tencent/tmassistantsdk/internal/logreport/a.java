package com.tencent.tmassistantsdk.internal.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements c
{
  protected d a = null;
  protected int b = 0;
  protected final List<byte[]> c = new ArrayList();
  
  public void a()
  {
    this.a = null;
    this.c.clear();
  }
  
  public void a(JceStruct paramJceStruct)
  {
    try
    {
      ab.c("BaseReportManager", "enter:" + paramJceStruct);
      if (paramJceStruct != null)
      {
        paramJceStruct = ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
        d().a(paramJceStruct);
      }
      ab.c("BaseReportManager", "exit");
      return;
    }
    finally {}
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    ab.c("BaseReportManager", "enter");
    ab.c("BaseReportManager", "result:" + paramBoolean);
    if ((!paramBoolean) && (this.c != null) && (this.c.size() > 0))
    {
      ab.c("BaseReportManager", "reback DB!");
      d().a(this.c);
    }
    this.a = null;
    this.c.clear();
    if ((paramBoolean) && (f()) && (this.b < 5))
    {
      ab.c("BaseReportManager", "reportlog go on,result:" + paramBoolean + " count:" + this.b);
      b();
      this.b += 1;
    }
    ab.c("BaseReportManager", "exit");
  }
  
  public void b()
  {
    try
    {
      ab.c("BaseReportManager", "enter");
      if (!GlobalUtil.getInstance().canReportValue())
      {
        ab.c("BaseReportManager", "Not WiFi");
        ab.c("BaseReportManager", "exit");
      }
      for (;;)
      {
        return;
        if (this.a == null) {
          break;
        }
        ab.c("BaseReportManager", "reportRequst is sending out");
        ab.c("BaseReportManager", "exit");
      }
      this.a = new d();
    }
    finally {}
    this.a.a(this);
    ab.c("BaseReportManager", " request:" + this.a + " reportManager:" + getClass().getName());
    b localb = d().a(1000);
    ab.c("BaseReportManager", "readLogDataAndSendToServer,wrappterCount:" + localb.b.size());
    if (localb != null) {
      if (localb.b.size() <= 0) {
        break label248;
      }
    }
    for (;;)
    {
      if (!bool) {
        this.a = null;
      }
      ab.c("BaseReportManager", "exit");
      break;
      this.c.addAll(localb.b);
      boolean bool = this.a.a(e(), localb);
      d().b(localb.a);
      continue;
      label248:
      bool = false;
    }
  }
  
  public void c()
  {
    this.b = 0;
  }
  
  protected abstract com.tencent.tmassistant.common.a.a d();
  
  protected abstract byte e();
  
  protected abstract boolean f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.a
 * JD-Core Version:    0.7.0.1
 */