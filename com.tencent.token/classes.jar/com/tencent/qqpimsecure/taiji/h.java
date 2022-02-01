package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.CSAuthDataRes;
import Protocol.MMGRAuth.CSPullSolutionInfo;
import Protocol.MMGRAuth.SCAuthDataRes;
import Protocol.MMGRAuth.SCSolutionRes;
import Protocol.MMGRAuth.SolutionItem;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import taiji.bj;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager.IProfileUploadCallback;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;
import tmsdk.common.module.pgsdk.manager.shark.Triple;

public class h
{
  private static final Long a = Long.valueOf(604800000L);
  @SuppressLint({"StaticFieldLeak"})
  private static h b;
  private ITaijiSharkNetwork c;
  private a d;
  private String e;
  private Context f;
  private boolean g = false;
  private long h = 0L;
  private int i = 0;
  private d j;
  private ISharkPushListener k = new ISharkPushListener()
  {
    public Triple<Long, Integer, JceStruct> onRecvPush(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvPush:");
      localStringBuilder.append(paramAnonymousLong);
      localStringBuilder.append("|");
      localStringBuilder.append(paramAnonymousInt2);
      bn.b("Taiji", localStringBuilder.toString());
      h.a(h.this, paramAnonymousJceStruct, false, 0);
      return null;
    }
  };
  
  private h(Context paramContext)
  {
    this.f = paramContext;
    this.c = c.a().b();
    i locali = i.a(paramContext);
    if ((locali.f()) && (locali.g())) {
      paramContext = new d(paramContext, "taiji", 43200000L, 2);
    } else {
      paramContext = new d(paramContext, "taiji", 14400000L, 2);
    }
    this.j = paramContext;
    paramContext = new HandlerThread("taiji");
    paramContext.start();
    this.d = new a(paramContext.getLooper());
    paramContext = this.c;
    if ((paramContext != null) && (paramContext.isSupportPush()))
    {
      bn.b("Taiji", "shark support push");
      this.c.registerSharkPush(13560, new SCSolutionRes(), 2, this.k);
    }
    this.d.sendEmptyMessage(3);
    this.d.sendEmptyMessage(0);
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new h(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Message paramMessage)
  {
    final boolean bool;
    if (paramMessage.arg1 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    final Object localObject1 = paramMessage.obj;
    if (bool) {
      this.d.removeMessages(0);
    }
    final HashMap localHashMap1 = f.a(this.f);
    final HashMap localHashMap2 = f.b(this.f);
    Object localObject2 = i.a(this.f);
    if (((i)localObject2).d() != 0L) {
      ((i)localObject2).b(localHashMap1, localHashMap2);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("profile size:");
    ((StringBuilder)localObject2).append(localHashMap1.size());
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(localHashMap2.size());
    bn.b("Taiji", ((StringBuilder)localObject2).toString());
    if ((localHashMap1.size() <= 0) && (localHashMap2.size() <= 0))
    {
      bn.b("Taiji", "no need to upload profile");
      if (paramMessage.arg1 == 1)
      {
        paramMessage = this.d;
        paramMessage.sendMessage(paramMessage.obtainMessage(1, localObject1));
      }
    }
    else
    {
      bn.b("Taiji", "start upload profile");
      if (this.c == null) {
        return;
      }
      c.a().c().uploadKVProfile(localHashMap1, localHashMap2, new ITaijiKVProfileManager.IProfileUploadCallback()
      {
        public void onUploadSuccess()
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUploadSuccess:isToPull?");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(":profileUploadTimeInterval:");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - h.b(h.this));
          bn.b("Taiji", ((StringBuilder)localObject).toString());
          localObject = i.a(h.a(h.this));
          ((i)localObject).b(System.currentTimeMillis());
          ((i)localObject).a(localHashMap1, localHashMap2);
          if (bool) {
            h.c(h.this).sendMessageDelayed(h.c(h.this).obtainMessage(1, localObject1), 500L);
          }
        }
      });
    }
  }
  
  private void a(JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleCloudSolutions isPull?");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" pullType?");
    ((StringBuilder)localObject).append(paramInt);
    bn.b("Taiji", ((StringBuilder)localObject).toString());
    if (this.g) {
      this.g = false;
    } else {
      this.j.b();
    }
    localObject = b(paramJceStruct, paramBoolean, paramInt);
    if ((((CSAuthDataRes)localObject).resList != null) && (((CSAuthDataRes)localObject).resList.size() != 0))
    {
      this.c.sendShark(3561, (JceStruct)localObject, new SCAuthDataRes(), 2, new ISharkCallBack()
      {
        public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cmd_CSAuthSolutionReport onFinish :");
          localStringBuilder.append(paramAnonymousInt3);
          localStringBuilder.append("|dataRetCode:");
          localStringBuilder.append(paramAnonymousInt4);
          bn.b("Taiji", localStringBuilder.toString());
          if ((paramAnonymousJceStruct != null) && ((paramAnonymousJceStruct instanceof SCAuthDataRes)))
          {
            paramAnonymousInt1 = ((SCAuthDataRes)paramAnonymousJceStruct).ret;
            paramAnonymousJceStruct = "Cmd_CSAuthSolutionReport success";
          }
          else
          {
            paramAnonymousJceStruct = "Cmd_CSAuthSolutionReport failure";
          }
          bn.b("Taiji", paramAnonymousJceStruct);
        }
      });
      return;
    }
    if ((paramBoolean) && (paramInt == 2))
    {
      localObject = new ArrayList(1);
      if (paramJceStruct == null) {}
      for (paramJceStruct = "n";; paramJceStruct = String.valueOf(paramInt))
      {
        ((ArrayList)localObject).add(paramJceStruct);
        break;
        paramInt = ((SCSolutionRes)paramJceStruct).ret;
        if (paramInt == 0) {
          break;
        }
      }
      if (((ArrayList)localObject).size() > 0) {
        c.a().e().reportString(266935, (ArrayList)localObject);
      }
    }
    bn.b("Taiji", "Cmd_CSAuthSolutionReport no data");
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    Intent localIntent = new Intent("act_got_ads");
    localIntent.setPackage(this.f.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("up", paramArrayList);
    localIntent.putExtras(localBundle);
    this.f.sendBroadcast(localIntent);
  }
  
  private CSAuthDataRes b(JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b(Message paramMessage)
  {
    final CSPullSolutionInfo localCSPullSolutionInfo = new CSPullSolutionInfo();
    if (paramMessage.obj != null)
    {
      localCSPullSolutionInfo.adapterIdList = ((ArrayList)paramMessage.obj);
      localCSPullSolutionInfo.pullType = 1;
      paramMessage = "MSG_PULL_DIRECTLY EPSRT_ADAPTER";
    }
    for (;;)
    {
      bn.b("Taiji", paramMessage);
      break;
      paramMessage = i.a(this.f);
      if (System.currentTimeMillis() - paramMessage.c() > a.longValue())
      {
        localCSPullSolutionInfo.pullType = 2;
        paramMessage.a(System.currentTimeMillis());
        paramMessage = "MSG_PULL_DIRECTLY EPSRT_ALL";
      }
      else
      {
        if ((!this.g) && (!this.j.a()))
        {
          bn.b("Taiji", "not time");
          return;
        }
        localCSPullSolutionInfo.pullType = 3;
        paramMessage = "MSG_PULL_DIRECTLY EPSRT_CHANGED";
      }
    }
    paramMessage = this.c;
    if (paramMessage == null) {
      return;
    }
    paramMessage.sendShark(3559, localCSPullSolutionInfo, new SCSolutionRes(), 2, new ISharkCallBack()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFinish pull cmdId:");
        localStringBuilder.append(paramAnonymousInt2);
        bn.b("Taiji", localStringBuilder.toString());
        if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
        {
          h.a(h.this, paramAnonymousJceStruct, true, localCSPullSolutionInfo.pullType);
          return;
        }
        paramAnonymousJceStruct = new StringBuilder();
        paramAnonymousJceStruct.append("onFinish pull shark error:");
        paramAnonymousJceStruct.append(paramAnonymousInt3);
        paramAnonymousJceStruct.append("|dataRetCode:");
        paramAnonymousJceStruct.append(paramAnonymousInt4);
        bn.b("Taiji", paramAnonymousJceStruct.toString());
        if (localCSPullSolutionInfo.pullType == 2)
        {
          i.a(h.a(h.this)).a(0L);
          if (h.d(h.this) + 1 < 3)
          {
            h.a(h.this, true);
            h.e(h.this);
            h.c(h.this).sendMessageDelayed(h.c(h.this).obtainMessage(1, null), 500L);
            bn.b("Taiji", "retry pull all");
          }
          else
          {
            h.a(h.this, false);
            h.a(h.this, 0);
          }
          if (paramAnonymousInt3 != 0)
          {
            paramAnonymousJceStruct = new ArrayList(1);
            paramAnonymousJceStruct.add(String.valueOf(paramAnonymousInt3));
            c.a().e().reportString(266935, paramAnonymousJceStruct);
            return;
          }
          if (paramAnonymousInt4 != 0)
          {
            paramAnonymousJceStruct = new ArrayList(1);
            paramAnonymousJceStruct.add(String.valueOf(paramAnonymousInt4));
            c.a().e().reportString(266935, paramAnonymousJceStruct);
          }
        }
      }
    });
  }
  
  private void c(Message paramMessage)
  {
    boolean bool;
    if ((paramMessage.arg1 == 1) && (paramMessage.arg2 == 2)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isPullAll?");
    ((StringBuilder)localObject1).append(bool);
    bn.b("Taiji", ((StringBuilder)localObject1).toString());
    Object localObject3 = (SCSolutionRes)paramMessage.obj;
    localObject1 = ((SCSolutionRes)localObject3).solutionList;
    Object localObject2 = a.a(this.f);
    HashMap localHashMap = new HashMap();
    Object localObject4 = new HashMap();
    Object localObject5;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (SolutionItem)((Iterator)localObject5).next();
        if (localObject1 == null) {}
        for (localObject1 = "sol is null";; localObject1 = "encode return, data null")
        {
          bn.b("Taiji", (String)localObject1);
          break;
          localObject6 = b.a().a(this.f, bj.a((JceStruct)localObject1));
          if (localObject6 != null) {
            break label183;
          }
        }
        label183:
        Object localObject6 = Base64.encodeToString((byte[])localObject6, 2);
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          StringBuilder localStringBuilder;
          if (((String)localObject6).equals(((a)localObject2).a(((SolutionItem)localObject1).adapterId)))
          {
            if (bool) {
              ((HashMap)localObject4).put(Integer.valueOf(((SolutionItem)localObject1).adapterId), localObject6);
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("nochanged adapter : ");
            localStringBuilder.append((String)localObject6);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).adapterId);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).commSoluId);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).extSoluId);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).policyId);
            bn.b("Taiji", localStringBuilder.toString());
          }
          else
          {
            localHashMap.put(Integer.valueOf(((SolutionItem)localObject1).adapterId), localObject6);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("changed adapter : ");
            localStringBuilder.append((String)localObject6);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).adapterId);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).commSoluId);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).extSoluId);
            localStringBuilder.append("|");
            localStringBuilder.append(((SolutionItem)localObject1).policyId);
            bn.b("Taiji", localStringBuilder.toString());
          }
        }
      }
    }
    if (bool)
    {
      ((a)localObject2).a();
      ((a)localObject2).a((HashMap)localObject4);
    }
    ((a)localObject2).a(localHashMap);
    localObject1 = i.a(this.f);
    localObject4 = this.e;
    if (localObject4 != null)
    {
      ((i)localObject1).c((String)localObject4);
      ((i)localObject1).a(System.currentTimeMillis());
    }
    if ((((SCSolutionRes)localObject3).canceledSolutionList != null) && (((SCSolutionRes)localObject3).canceledSolutionList.size() > 0))
    {
      localObject3 = ((SCSolutionRes)localObject3).canceledSolutionList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SolutionItem)((Iterator)localObject3).next();
        ((a)localObject2).b(((SolutionItem)localObject4).adapterId);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("remove ");
        ((StringBuilder)localObject5).append(((SolutionItem)localObject4).adapterId);
        bn.b("Taiji", ((StringBuilder)localObject5).toString());
      }
    }
    if ((!((i)localObject1).f()) || (((i)localObject1).g()))
    {
      ((i)localObject1).a(true);
      localObject2 = new ArrayList(1);
      if (paramMessage.arg1 == 1) {
        paramMessage = "pl";
      } else {
        paramMessage = "ps";
      }
      ((ArrayList)localObject2).add(paramMessage);
      c.a().e().reportString(266935, (ArrayList)localObject2);
      if (((i)localObject1).g())
      {
        ((i)localObject1).b(false);
        paramMessage = new ArrayList(1);
        ((ArrayList)localObject2).add("rs");
        c.a().e().reportString(266935, paramMessage);
      }
    }
    if (localHashMap.size() > 0) {
      a(new ArrayList(localHashMap.keySet()));
    }
  }
  
  public SolutionItem a(int paramInt)
  {
    String str = a.a(this.f).a(paramInt);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return (SolutionItem)bj.a(b.a().b(this.f, Base64.decode(str, 2)), new SolutionItem(), false);
  }
  
  public void a(List<Integer> paramList)
  {
    bn.b("Taiji", "pullSolutionsFromCloud");
    if (this.c != null)
    {
      a locala = this.d;
      locala.sendMessage(locala.obtainMessage(0, 1, 0, paramList));
      this.h = System.currentTimeMillis();
      paramList = new StringBuilder();
      paramList.append("pullTime:");
      paramList.append(this.h);
      bn.b("Taiji", paramList.toString());
      return;
    }
    throw new RuntimeException("host was not set shark before pull solutions!");
  }
  
  public boolean a()
  {
    return i.a(this.f).f();
  }
  
  public List<SolutionItem> b(List<Integer> paramList)
  {
    Object localObject1 = a.a(this.f).a(paramList);
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      paramList = new ArrayList(paramList.size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = (SolutionItem)bj.a(b.a().b(this.f, Base64.decode((String)localObject2, 2)), new SolutionItem(), false);
          if (localObject2 != null) {
            paramList.add(localObject2);
          }
        }
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        bn.b("Taiji", String.valueOf(((SolutionItem)((Iterator)localObject1).next()).adapterId));
      }
      return paramList;
    }
    bn.b("Taiji", "getSolutionsFromLocal datas is null");
    return null;
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage :msg:");
      localStringBuilder.append(paramMessage.what);
      bn.b("Taiji", localStringBuilder.toString());
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        e.a().a(h.a(h.this));
        return;
      case 2: 
        h.c(h.this, paramMessage);
        return;
      case 1: 
        bn.b("Taiji", "MSG_PULL_DIRECTLY");
        h.b(h.this, paramMessage);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSG_UPLOAD_PROFILE:");
      localStringBuilder.append(paramMessage.arg1);
      bn.b("Taiji", localStringBuilder.toString());
      h.a(h.this, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.h
 * JD-Core Version:    0.7.0.1
 */