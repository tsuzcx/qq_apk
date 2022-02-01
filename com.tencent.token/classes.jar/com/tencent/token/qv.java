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

public final class qv
{
  private static final Long d = Long.valueOf(604800000L);
  @SuppressLint({"StaticFieldLeak"})
  private static qv e;
  public asj a;
  public a b;
  public long c = 0L;
  private String f;
  private Context g;
  private boolean h = false;
  private int i = 0;
  private qr j;
  private asn k = new asn()
  {
    public final aso<Long, Integer, JceStruct> a(long paramAnonymousLong, int paramAnonymousInt, JceStruct paramAnonymousJceStruct)
    {
      StringBuilder localStringBuilder = new StringBuilder("onRecvPush:");
      localStringBuilder.append(paramAnonymousLong);
      localStringBuilder.append("|");
      localStringBuilder.append(paramAnonymousInt);
      aod.b();
      qv.a(qv.this, paramAnonymousJceStruct, false, 0);
      return null;
    }
  };
  
  private qv(Context paramContext)
  {
    this.g = paramContext;
    this.a = qq.a.a().a.a();
    qw.a(paramContext);
    if ((qw.b()) && (qw.d())) {
      paramContext = new qr(paramContext, "taiji", 43200000L);
    } else {
      paramContext = new qr(paramContext, "taiji", 14400000L);
    }
    this.j = paramContext;
    paramContext = new HandlerThread("taiji");
    paramContext.start();
    this.b = new a(paramContext.getLooper());
    if (this.a != null)
    {
      aod.b();
      this.a.a(new j(), this.k);
    }
    this.b.sendEmptyMessage(3);
    this.b.sendEmptyMessage(0);
  }
  
  private g a(JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static qv a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new qv(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public final k a(int paramInt)
  {
    String str = qo.a(this.g).a(paramInt);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return (k)anz.a(qp.a.a().a(this.g, Base64.decode(str, 2), false), new k());
  }
  
  public final List<k> a(List<Integer> paramList)
  {
    qo localqo = qo.a(this.g);
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
        localObject1 = localqo.a.a("ad_".concat(String.valueOf(m)));
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
          localObject2 = (k)anz.a(qp.a.a().a(this.g, Base64.decode((String)localObject2, 2), false), new k());
          if (localObject2 != null) {
            paramList.add(localObject2);
          }
        }
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        m = ((k)((Iterator)localObject1).next()).d;
        aod.b();
      }
      return paramList;
    }
    aod.b();
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
      aod.b();
      switch (paramMessage.what)
      {
      default: 
      case 3: 
        qs.a.a();
        paramMessage = qv.a(qv.this);
        qw.a(paramMessage);
        int i = qq.a.a().a("tjs").a("k_t_a_v", 0);
        int j = aoc.c(paramMessage, paramMessage.getPackageName());
        if ((i == 0) || (i != j))
        {
          qw.b(true);
          qq.a.a().a("tjs").b("k_t_a_v", j);
        }
        if (qq.a.a().a("tjs").a("k_l_l_s_s", true))
        {
          qw.b(false);
          Object localObject = new StringBuilder("startAndLoadScheme, process id:");
          ((StringBuilder)localObject).append(Process.myPid());
          ((StringBuilder)localObject).append(", thread id:");
          ((StringBuilder)localObject).append(Thread.currentThread().getId());
          aod.b();
          localObject = qs.a(paramMessage);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            aod.b();
            return;
          }
          "loadAssetLocalSchemeFile json:".concat(String.valueOf(localObject));
          aod.b();
          localObject = qs.a(paramMessage, (String)localObject);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            new StringBuilder("getSolutionListForPhone result list size:").append(((List)localObject).size());
            aod.b();
            qs.a(paramMessage, (List)localObject);
            return;
          }
          aod.b();
          return;
        }
        break;
      case 2: 
        qv.c(qv.this, paramMessage);
        return;
      case 1: 
        aod.b();
        qv.b(qv.this, paramMessage);
        return;
      case 0: 
        new StringBuilder("MSG_UPLOAD_PROFILE:").append(paramMessage.arg1);
        aod.b();
        qv.a(qv.this, paramMessage);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qv
 * JD-Core Version:    0.7.0.1
 */