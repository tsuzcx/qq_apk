package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class rp
{
  private static final Long d = Long.valueOf(604800000L);
  @SuppressLint({"StaticFieldLeak"})
  private static rp e;
  public avd a;
  public a b;
  public long c = 0L;
  private String f;
  private Context g;
  private boolean h = false;
  private int i = 0;
  private rl j;
  private avh k = new avh()
  {
    public final avi<Long, Integer, JceStruct> a(long paramAnonymousLong, int paramAnonymousInt, JceStruct paramAnonymousJceStruct)
    {
      StringBuilder localStringBuilder = new StringBuilder("onRecvPush:");
      localStringBuilder.append(paramAnonymousLong);
      localStringBuilder.append("|");
      localStringBuilder.append(paramAnonymousInt);
      aqx.b();
      rp.a(rp.this, paramAnonymousJceStruct, false, 0);
      return null;
    }
  };
  
  private rp(Context paramContext)
  {
    this.g = paramContext;
    this.a = rk.a.a().a.a();
    rq.a(paramContext);
    if ((rq.b()) && (rq.d())) {
      paramContext = new rl(paramContext, "taiji", 43200000L);
    } else {
      paramContext = new rl(paramContext, "taiji", 14400000L);
    }
    this.j = paramContext;
    paramContext = new HandlerThread("taiji");
    paramContext.start();
    this.b = new a(paramContext.getLooper());
    if (this.a != null)
    {
      aqx.b();
      this.a.a(new j(), this.k);
    }
    this.b.sendEmptyMessage(3);
    this.b.sendEmptyMessage(0);
  }
  
  private g a(JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static rp a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new rp(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public final k a(int paramInt)
  {
    String str = ri.a(this.g).a(paramInt);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return (k)aqt.a(rj.a.a().a(this.g, Base64.decode(str, 2), false), new k());
  }
  
  public final List<k> a(List<Integer> paramList)
  {
    ri localri = ri.a(this.g);
    Object localObject1;
    Object localObject2;
    int m;
    if (paramList.size() == 0)
    {
      localObject1 = null;
    }
    else
    {
      localObject2 = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        m = ((Integer)localIterator.next()).intValue();
        localObject1 = localri.a.a("ad_".concat(String.valueOf(m)));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((List)localObject2).add(localObject1);
        }
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      paramList = new ArrayList(paramList.size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = (k)aqt.a(rj.a.a().a(this.g, Base64.decode((String)localObject2, 2), false), new k());
          if (localObject2 != null) {
            paramList.add(localObject2);
          }
        }
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        m = ((k)((Iterator)localObject1).next()).d;
        aqx.b();
      }
      return paramList;
    }
    aqx.b();
    return null;
  }
  
  public final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      new StringBuilder("handleMessage :msg:").append(paramMessage.what);
      aqx.b();
      switch (paramMessage.what)
      {
      default: 
      case 3: 
        rm.a.a();
        paramMessage = rp.a(rp.this);
        rq.a(paramMessage);
        int i = rk.a.a().a("tjs").a("k_t_a_v", 0);
        int j = aqw.c(paramMessage, paramMessage.getPackageName());
        if ((i == 0) || (i != j))
        {
          rq.b(true);
          rk.a.a().a("tjs").b("k_t_a_v", j);
        }
        if (rk.a.a().a("tjs").a("k_l_l_s_s", true))
        {
          rq.b(false);
          Object localObject = new StringBuilder("startAndLoadScheme, process id:");
          ((StringBuilder)localObject).append(Process.myPid());
          ((StringBuilder)localObject).append(", thread id:");
          ((StringBuilder)localObject).append(Thread.currentThread().getId());
          aqx.b();
          localObject = rm.a(paramMessage);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            aqx.b();
            return;
          }
          "loadAssetLocalSchemeFile json:".concat(String.valueOf(localObject));
          aqx.b();
          localObject = rm.a(paramMessage, (String)localObject);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            new StringBuilder("getSolutionListForPhone result list size:").append(((List)localObject).size());
            aqx.b();
            rm.a(paramMessage, (List)localObject);
            return;
          }
          aqx.b();
          return;
        }
        break;
      case 2: 
        rp.c(rp.this, paramMessage);
        return;
      case 1: 
        aqx.b();
        rp.b(rp.this, paramMessage);
        return;
      case 0: 
        new StringBuilder("MSG_UPLOAD_PROFILE:").append(paramMessage.arg1);
        aqx.b();
        rp.a(rp.this, paramMessage);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rp
 * JD-Core Version:    0.7.0.1
 */