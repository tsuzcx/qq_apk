package com.tencent.securemodule.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.ac.a;
import com.tencent.securemodule.ad;
import com.tencent.securemodule.ae;
import com.tencent.securemodule.af;
import com.tencent.securemodule.ah;
import com.tencent.securemodule.ai;
import com.tencent.securemodule.aj;
import com.tencent.securemodule.ak;
import com.tencent.securemodule.al;
import com.tencent.securemodule.am;
import com.tencent.securemodule.an;
import com.tencent.securemodule.e;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.p;
import com.tencent.securemodule.r;
import com.tencent.securemodule.s;

public class TransparentActivity
  extends Activity
{
  private Context a;
  private e b;
  private r c;
  private ProgressDialog d = null;
  private Handler e = new af(this);
  private ae f;
  private ServiceConnection g = new ah(this);
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf("发现“" + this.c.b() + "应用”被病毒感染，"));
    if (paramBoolean) {}
    for (String str = "建议立即启动腾讯手机管家查杀";; str = "建议立即安装最新版腾讯手机管家查杀")
    {
      str = str;
      new AlertDialog.Builder(this).setTitle("QQ安全登录扫描").setMessage(str).setPositiveButton("确定", new al(this, paramBoolean)).setNegativeButton("取消", new am(this)).setOnCancelListener(new an(this)).show();
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getResources().getDrawable(17170445);
    getWindow().setBackgroundDrawable(paramBundle);
    this.a = this;
    paramBundle = new Intent();
    paramBundle.setClass(this.a, SecureService.class);
    bindService(paramBundle, this.g, 1);
    paramBundle = getIntent().getAction();
    if ("1000040".equals(paramBundle))
    {
      this.b = ((e)getIntent().getSerializableExtra("data"));
      if (this.b != null)
      {
        paramBundle = this.b.b();
        if (paramBundle != null)
        {
          Object localObject = paramBundle.a();
          String str = paramBundle.b();
          localObject = new AlertDialog.Builder(this).setTitle((CharSequence)localObject).setMessage(str).setPositiveButton("确定", new ai(this)).setOnCancelListener(new aj(this));
          if (paramBundle.d() != 1) {
            ((AlertDialog.Builder)localObject).setNegativeButton("取消", new ak(this));
          }
          ((AlertDialog.Builder)localObject).show();
          return;
        }
        finish();
        return;
      }
      finish();
      return;
    }
    if ("1000041".equals(paramBundle))
    {
      this.c = ((r)getIntent().getSerializableExtra("data"));
      if (this.c != null)
      {
        paramBundle = s.a(this.a, "com.tencent.qqpimsecure");
        if ((paramBundle != null) && ("00B1208638DE0FCD3E920886D658DAF6".equals(paramBundle.c())) && (paramBundle.e() >= 77))
        {
          a(true);
          return;
        }
        a(false);
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  public void onDestroy()
  {
    if (this.g != null) {
      unbindService(this.g);
    }
    super.onDestroy();
  }
  
  public final class a
    extends Thread
    implements Runnable
  {
    private int a;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    private void a()
    {
      for (;;)
      {
        try
        {
          int i = this.a;
          if (i < 5) {
            try
            {
              Thread.sleep(2000L);
              Message localMessage1 = TransparentActivity.c(TransparentActivity.this).obtainMessage(4);
              localMessage1.arg1 = (this.a + 1);
              TransparentActivity.c(TransparentActivity.this).sendMessage(localMessage1);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              continue;
            }
          }
          localMessage2 = TransparentActivity.c(TransparentActivity.this).obtainMessage(2);
        }
        finally {}
        Message localMessage2;
        localMessage2.arg1 = 0;
        TransparentActivity.c(TransparentActivity.this).sendMessage(localMessage2);
      }
    }
    
    public final void run()
    {
      try
      {
        if (TransparentActivity.d(TransparentActivity.this) == null) {
          break label86;
        }
        Object localObject = new UniAttribute();
        ((UniAttribute)localObject).setEncodeName("UTF-8");
        ((UniAttribute)localObject).put("data", TransparentActivity.e(TransparentActivity.this));
        localObject = ((UniAttribute)localObject).encode();
        if (localObject != null) {
          TransparentActivity.d(TransparentActivity.this).a(ac.a.a((byte[])localObject), new ad(this));
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          label86:
          int i = 0;
        }
      }
      if (i == 0) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ui.TransparentActivity
 * JD-Core Version:    0.7.0.1
 */