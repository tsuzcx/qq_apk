package com.tencent.mobileqq.app.automator.step;

import accy;
import aehl;
import afem;
import ahzd;
import aimc;
import avfw;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener b;
  
  public int od()
  {
    ((aimc)this.a.app.getBusinessHandler(128)).dsP();
    Object localObject = new PluginConfigProxy();
    this.a.app.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).ct(this.a.app);
    ((avfw)this.a.app.getManager(27)).ezM();
    ((afem)this.a.app.getManager(77)).HK(true);
    localObject = (accy)this.a.app.getBusinessHandler(4);
    ((accy)localObject).a(null, new GetResourceReqInfo[] { ((accy)localObject).d(), ((accy)localObject).f(), ((accy)localObject).b(), ((accy)localObject).e(), ((accy)localObject).c() });
    ahzd.a(this.a.app).drc();
    return 2;
  }
  
  public void onCreate()
  {
    if (this.b == null)
    {
      this.b = new a(null);
      this.a.app.c(this.b);
      this.a.app.d(this.b);
    }
  }
  
  public void onDestroy()
  {
    this.b = null;
  }
  
  class a
    extends ResourcePluginListener
  {
    private a() {}
    
    public void e(byte paramByte)
    {
      if (GetConfig.this.cyx == 44)
      {
        if ((paramByte != 2) && (paramByte == 3)) {}
        GetConfig.this.a.app.e(GetConfig.a(GetConfig.this));
        GetConfig.this.setResult(7);
      }
    }
    
    public void h(byte paramByte)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      GetConfig.this.a.app.f(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */