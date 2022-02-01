package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.AuthDataRes;
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
import taiji.bk;
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
      bn.b("Taiji", "onRecvPush:" + paramAnonymousLong + "|" + paramAnonymousInt2);
      h.a(h.this, paramAnonymousJceStruct, false, 0);
      return null;
    }
  };
  
  private h(Context paramContext)
  {
    this.f = paramContext;
    this.c = c.a().b();
    i locali = i.a(paramContext);
    if ((locali.f()) && (locali.g())) {}
    for (this.j = new d(paramContext, "taiji", 43200000L, 2);; this.j = new d(paramContext, "taiji", 14400000L, 2))
    {
      paramContext = new HandlerThread("taiji");
      paramContext.start();
      this.d = new a(paramContext.getLooper());
      if ((this.c != null) && (this.c.isSupportPush()))
      {
        bn.b("Taiji", "shark support push");
        this.c.registerSharkPush(13560, new SCSolutionRes(), 2, this.k);
      }
      this.d.sendEmptyMessage(3);
      this.d.sendEmptyMessage(0);
      return;
    }
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
    final Object localObject;
    final HashMap localHashMap1;
    final HashMap localHashMap2;
    if (paramMessage.arg1 == 1)
    {
      bool = true;
      localObject = paramMessage.obj;
      if (bool) {
        this.d.removeMessages(0);
      }
      localHashMap1 = f.a(this.f);
      localHashMap2 = f.b(this.f);
      i locali = i.a(this.f);
      if (locali.d() != 0L) {
        locali.b(localHashMap1, localHashMap2);
      }
      bn.b("Taiji", "profile size:" + localHashMap1.size() + "|" + localHashMap2.size());
      if ((localHashMap1.size() <= 0) && (localHashMap2.size() <= 0)) {
        break label180;
      }
      bn.b("Taiji", "start upload profile");
      if (this.c != null) {
        break label150;
      }
    }
    label150:
    label180:
    do
    {
      return;
      bool = false;
      break;
      c.a().c().uploadKVProfile(localHashMap1, localHashMap2, new ITaijiKVProfileManager.IProfileUploadCallback()
      {
        public void onUploadSuccess()
        {
          bn.b("Taiji", "onUploadSuccess:isToPull?" + bool + ":profileUploadTimeInterval:" + (System.currentTimeMillis() - h.b(h.this)));
          i locali = i.a(h.a(h.this));
          locali.b(System.currentTimeMillis());
          locali.a(localHashMap1, localHashMap2);
          if (bool) {
            h.c(h.this).sendMessageDelayed(h.c(h.this).obtainMessage(1, localObject), 500L);
          }
        }
      });
      return;
      bn.b("Taiji", "no need to upload profile");
    } while (paramMessage.arg1 != 1);
    this.d.sendMessage(this.d.obtainMessage(1, localObject));
  }
  
  private void a(JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    bn.b("Taiji", "handleCloudSolutions isPull?" + paramBoolean + " pullType?" + paramInt);
    Object localObject;
    if (this.g)
    {
      this.g = false;
      localObject = b(paramJceStruct, paramBoolean, paramInt);
      if ((((CSAuthDataRes)localObject).resList != null) && (((CSAuthDataRes)localObject).resList.size() != 0)) {
        break label172;
      }
      if ((paramBoolean) && (paramInt == 2))
      {
        localObject = new ArrayList(1);
        if (paramJceStruct != null) {
          break label147;
        }
        ((ArrayList)localObject).add("n");
      }
    }
    for (;;)
    {
      if (((ArrayList)localObject).size() > 0) {
        c.a().e().reportString(266935, (ArrayList)localObject);
      }
      bn.b("Taiji", "Cmd_CSAuthSolutionReport no data");
      return;
      this.j.b();
      break;
      label147:
      paramInt = ((SCSolutionRes)paramJceStruct).ret;
      if (paramInt != 0) {
        ((ArrayList)localObject).add(String.valueOf(paramInt));
      }
    }
    label172:
    this.c.sendShark(3561, (JceStruct)localObject, new SCAuthDataRes(), 2, new ISharkCallBack()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        bn.b("Taiji", "Cmd_CSAuthSolutionReport onFinish :" + paramAnonymousInt3 + "|dataRetCode:" + paramAnonymousInt4);
        if ((paramAnonymousJceStruct != null) && ((paramAnonymousJceStruct instanceof SCAuthDataRes)))
        {
          if (((SCAuthDataRes)paramAnonymousJceStruct).ret == 0)
          {
            bn.b("Taiji", "Cmd_CSAuthSolutionReport success");
            return;
          }
          bn.b("Taiji", "Cmd_CSAuthSolutionReport success");
          return;
        }
        bn.b("Taiji", "Cmd_CSAuthSolutionReport failure");
      }
    });
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
    CSAuthDataRes localCSAuthDataRes = new CSAuthDataRes();
    if ((paramJceStruct == null) || (!(paramJceStruct instanceof SCSolutionRes))) {
      return localCSAuthDataRes;
    }
    paramJceStruct = (SCSolutionRes)paramJceStruct;
    if (paramJceStruct.ret != 0) {
      return localCSAuthDataRes;
    }
    Object localObject1 = i.a(this.f);
    ((i)localObject1).c(System.currentTimeMillis());
    Object localObject2 = new ArrayList();
    if (paramJceStruct.solutionList != null)
    {
      ((List)localObject2).addAll(paramJceStruct.solutionList);
      bn.b("Taiji", "sols size:" + paramJceStruct.solutionList.size());
    }
    if (paramJceStruct.canceledSolutionList != null)
    {
      ((List)localObject2).addAll(paramJceStruct.canceledSolutionList);
      bn.b("Taiji", "canceld sols size:" + paramJceStruct.canceledSolutionList.size());
    }
    int m;
    if (((List)localObject2).size() > 0)
    {
      if (paramInt == 2) {
        bn.b("Taiji", "GotSolsTime:" + (System.currentTimeMillis() - this.h));
      }
      localCSAuthDataRes.resList = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SolutionItem localSolutionItem = (SolutionItem)((Iterator)localObject2).next();
        AuthDataRes localAuthDataRes = new AuthDataRes();
        localAuthDataRes.commSoluId = localSolutionItem.commSoluId;
        localAuthDataRes.extSoluId = localSolutionItem.extSoluId;
        localAuthDataRes.policyId = localSolutionItem.policyId;
        localCSAuthDataRes.resList.add(localAuthDataRes);
        bn.b("Taiji", "solution info:" + localSolutionItem.adapterId + "|" + localSolutionItem.commSoluId + "|" + localSolutionItem.extSoluId + "|" + localSolutionItem.policyId);
      }
      localObject2 = ((i)localObject1).e();
      this.e = null;
      if (((TextUtils.isEmpty((CharSequence)localObject2)) && ((!paramBoolean) || (paramInt == 3))) || ((paramBoolean) && (paramInt == 2)))
      {
        this.e = bk.c(bj.a(paramJceStruct));
        bn.b("Taiji", "lastAllMd5:" + (String)localObject2 + "|currentAllMd5:" + this.e);
      }
      if ((!paramBoolean) || (paramInt != 2) || (!((String)localObject2).equals(this.e)))
      {
        localObject1 = this.d;
        localObject2 = this.d;
        if (paramBoolean)
        {
          m = 1;
          ((a)localObject1).sendMessage(((a)localObject2).obtainMessage(2, m, paramInt, paramJceStruct));
        }
      }
    }
    for (;;)
    {
      return localCSAuthDataRes;
      m = 0;
      break;
      if (!((i)localObject1).f())
      {
        ((i)localObject1).a(true);
        continue;
        if ((paramBoolean) && (paramInt == 2) && (this.i + 1 < 3))
        {
          this.i += 1;
          this.g = true;
          this.d.sendMessageDelayed(this.d.obtainMessage(1, null), 500L);
          paramJceStruct = new ArrayList(1);
          if (TextUtils.isEmpty(((i)localObject1).e())) {
            if (!((i)localObject1).g())
            {
              paramJceStruct.add("r");
              ((i)localObject1).b(true);
            }
          }
          for (;;)
          {
            c.a().e().reportString(266935, paramJceStruct);
            bn.b("Taiji", "no data, retry pull all");
            break;
            paramJceStruct.add("rr");
            continue;
            paramJceStruct.add("rt");
          }
        }
        if (!((i)localObject1).f()) {
          ((i)localObject1).a(true);
        }
        if (this.i + 1 >= 3)
        {
          this.g = false;
          this.i = 0;
        }
      }
    }
  }
  
  private void b(Message paramMessage)
  {
    final CSPullSolutionInfo localCSPullSolutionInfo = new CSPullSolutionInfo();
    if (paramMessage.obj != null)
    {
      localCSPullSolutionInfo.adapterIdList = ((ArrayList)paramMessage.obj);
      localCSPullSolutionInfo.pullType = 1;
      bn.b("Taiji", "MSG_PULL_DIRECTLY EPSRT_ADAPTER");
    }
    while (this.c == null)
    {
      return;
      paramMessage = i.a(this.f);
      if (System.currentTimeMillis() - paramMessage.c() > a.longValue())
      {
        localCSPullSolutionInfo.pullType = 2;
        paramMessage.a(System.currentTimeMillis());
        bn.b("Taiji", "MSG_PULL_DIRECTLY EPSRT_ALL");
      }
      else
      {
        if ((!this.g) && (!this.j.a()))
        {
          bn.b("Taiji", "not time");
          return;
        }
        localCSPullSolutionInfo.pullType = 3;
        bn.b("Taiji", "MSG_PULL_DIRECTLY EPSRT_CHANGED");
      }
    }
    this.c.sendShark(3559, localCSPullSolutionInfo, new SCSolutionRes(), 2, new ISharkCallBack()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        bn.b("Taiji", "onFinish pull cmdId:" + paramAnonymousInt2);
        if ((paramAnonymousInt3 != 0) || (paramAnonymousInt4 != 0))
        {
          bn.b("Taiji", "onFinish pull shark error:" + paramAnonymousInt3 + "|dataRetCode:" + paramAnonymousInt4);
          if (localCSPullSolutionInfo.pullType == 2)
          {
            i.a(h.a(h.this)).a(0L);
            if (h.d(h.this) + 1 >= 3) {
              break label195;
            }
            h.a(h.this, true);
            h.e(h.this);
            h.c(h.this).sendMessageDelayed(h.c(h.this).obtainMessage(1, null), 500L);
            bn.b("Taiji", "retry pull all");
            if (paramAnonymousInt3 == 0) {
              break label216;
            }
            paramAnonymousJceStruct = new ArrayList(1);
            paramAnonymousJceStruct.add(String.valueOf(paramAnonymousInt3));
            c.a().e().reportString(266935, paramAnonymousJceStruct);
          }
          label195:
          label216:
          while (paramAnonymousInt4 == 0)
          {
            return;
            h.a(h.this, false);
            h.a(h.this, 0);
            break;
          }
          paramAnonymousJceStruct = new ArrayList(1);
          paramAnonymousJceStruct.add(String.valueOf(paramAnonymousInt4));
          c.a().e().reportString(266935, paramAnonymousJceStruct);
          return;
        }
        h.a(h.this, paramAnonymousJceStruct, true, localCSPullSolutionInfo.pullType);
      }
    });
  }
  
  private void c(Message paramMessage)
  {
    boolean bool;
    Object localObject2;
    Object localObject4;
    Object localObject1;
    HashMap localHashMap;
    if ((paramMessage.arg1 == 1) && (paramMessage.arg2 == 2))
    {
      bool = true;
      bn.b("Taiji", "isPullAll?" + bool);
      localObject2 = (SCSolutionRes)paramMessage.obj;
      localObject4 = ((SCSolutionRes)localObject2).solutionList;
      localObject1 = a.a(this.f);
      localHashMap = new HashMap();
      localObject3 = new HashMap();
      if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
        localObject4 = ((List)localObject4).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label416;
        }
        SolutionItem localSolutionItem = (SolutionItem)((Iterator)localObject4).next();
        if (localSolutionItem == null)
        {
          bn.b("Taiji", "sol is null");
          continue;
          bool = false;
          break;
        }
        Object localObject5 = b.a().a(this.f, bj.a(localSolutionItem));
        if (localObject5 == null)
        {
          bn.b("Taiji", "encode return, data null");
        }
        else
        {
          localObject5 = Base64.encodeToString((byte[])localObject5, 2);
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            if (((String)localObject5).equals(((a)localObject1).a(localSolutionItem.adapterId)))
            {
              if (bool) {
                ((HashMap)localObject3).put(Integer.valueOf(localSolutionItem.adapterId), localObject5);
              }
              bn.b("Taiji", "nochanged adapter : " + (String)localObject5 + "|" + localSolutionItem.adapterId + "|" + localSolutionItem.commSoluId + "|" + localSolutionItem.extSoluId + "|" + localSolutionItem.policyId);
            }
            else
            {
              localHashMap.put(Integer.valueOf(localSolutionItem.adapterId), localObject5);
              bn.b("Taiji", "changed adapter : " + (String)localObject5 + "|" + localSolutionItem.adapterId + "|" + localSolutionItem.commSoluId + "|" + localSolutionItem.extSoluId + "|" + localSolutionItem.policyId);
            }
          }
        }
      }
    }
    label416:
    if (bool)
    {
      ((a)localObject1).a();
      ((a)localObject1).a((HashMap)localObject3);
    }
    ((a)localObject1).a(localHashMap);
    Object localObject3 = i.a(this.f);
    if (this.e != null)
    {
      ((i)localObject3).c(this.e);
      ((i)localObject3).a(System.currentTimeMillis());
    }
    if ((((SCSolutionRes)localObject2).canceledSolutionList != null) && (((SCSolutionRes)localObject2).canceledSolutionList.size() > 0))
    {
      localObject2 = ((SCSolutionRes)localObject2).canceledSolutionList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (SolutionItem)((Iterator)localObject2).next();
        ((a)localObject1).b(((SolutionItem)localObject4).adapterId);
        bn.b("Taiji", "remove " + ((SolutionItem)localObject4).adapterId);
      }
    }
    if ((!((i)localObject3).f()) || (((i)localObject3).g()))
    {
      ((i)localObject3).a(true);
      localObject1 = new ArrayList(1);
      if (paramMessage.arg1 != 1) {
        break label699;
      }
      ((ArrayList)localObject1).add("pl");
    }
    for (;;)
    {
      c.a().e().reportString(266935, (ArrayList)localObject1);
      if (((i)localObject3).g())
      {
        ((i)localObject3).b(false);
        paramMessage = new ArrayList(1);
        ((ArrayList)localObject1).add("rs");
        c.a().e().reportString(266935, paramMessage);
      }
      if (localHashMap.size() > 0) {
        a(new ArrayList(localHashMap.keySet()));
      }
      return;
      label699:
      ((ArrayList)localObject1).add("ps");
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
    if (this.c == null) {
      throw new RuntimeException("host was not set shark before pull solutions!");
    }
    this.d.sendMessage(this.d.obtainMessage(0, 1, 0, paramList));
    this.h = System.currentTimeMillis();
    bn.b("Taiji", "pullTime:" + this.h);
  }
  
  public boolean a()
  {
    return i.a(this.f).f();
  }
  
  public List<SolutionItem> b(List<Integer> paramList)
  {
    Object localObject1 = a.a(this.f).a(paramList);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      bn.b("Taiji", "getSolutionsFromLocal datas is null");
      return null;
    }
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
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      bn.b("Taiji", "handleMessage :msg:" + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        bn.b("Taiji", "MSG_UPLOAD_PROFILE:" + paramMessage.arg1);
        h.a(h.this, paramMessage);
        return;
      case 1: 
        bn.b("Taiji", "MSG_PULL_DIRECTLY");
        h.b(h.this, paramMessage);
        return;
      case 2: 
        h.c(h.this, paramMessage);
        return;
      }
      e.a().a(h.a(h.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.h
 * JD-Core Version:    0.7.0.1
 */