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
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import taiji.ch;
import taiji.ci;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener;

public class o
{
  private static final Long a = Long.valueOf(604800000L);
  @SuppressLint({"StaticFieldLeak"})
  private static o b;
  private ITaijiSharkNetwork c;
  private t d;
  private String e;
  private Context f;
  private boolean g = false;
  private long h = 0L;
  private int i = 0;
  private i j;
  private ISharkPushListener k = new p(this);
  
  private o(Context paramContext)
  {
    this.f = paramContext;
    this.c = f.a().b();
    u localu = u.a(paramContext);
    if ((localu.f()) && (localu.g())) {}
    for (this.j = new i(paramContext, "taiji", 43200000L, 2);; this.j = new i(paramContext, "taiji", 14400000L, 2))
    {
      paramContext = new HandlerThread("taiji");
      paramContext.start();
      this.d = new t(this, paramContext.getLooper());
      if ((this.c != null) && (this.c.isSupportPush()))
      {
        cl.b("Taiji", "shark support push");
        this.c.registerSharkPush(13560, new SCSolutionRes(), 2, this.k);
      }
      this.d.sendEmptyMessage(3);
      this.d.sendEmptyMessage(0);
      return;
    }
  }
  
  public static o a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new o(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Message paramMessage)
  {
    boolean bool;
    Object localObject;
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (paramMessage.arg1 == 1)
    {
      bool = true;
      localObject = paramMessage.obj;
      if (bool) {
        this.d.removeMessages(0);
      }
      localHashMap1 = m.a(this.f);
      localHashMap2 = m.b(this.f);
      u localu = u.a(this.f);
      if (localu.d() != 0L) {
        localu.b(localHashMap1, localHashMap2);
      }
      cl.b("Taiji", "profile size:" + localHashMap1.size() + "|" + localHashMap2.size());
      if ((localHashMap1.size() <= 0) && (localHashMap2.size() <= 0)) {
        break label180;
      }
      cl.b("Taiji", "start upload profile");
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
      f.a().c().uploadKVProfile(localHashMap1, localHashMap2, new q(this, bool, localHashMap1, localHashMap2, localObject));
      return;
      cl.b("Taiji", "no need to upload profile");
    } while (paramMessage.arg1 != 1);
    this.d.sendMessage(this.d.obtainMessage(1, localObject));
  }
  
  private void a(JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    cl.b("Taiji", "handleCloudSolutions isPull?" + paramBoolean + " pullType?" + paramInt);
    Object localObject;
    if (this.g)
    {
      this.g = false;
      localObject = b(paramJceStruct, paramBoolean, paramInt);
      if ((((CSAuthDataRes)localObject).resList != null) && (((CSAuthDataRes)localObject).resList.size() != 0)) {
        break label171;
      }
      if ((paramBoolean) && (paramInt == 2))
      {
        localObject = new ArrayList(1);
        if (paramJceStruct != null) {
          break label146;
        }
        ((ArrayList)localObject).add("n");
      }
    }
    for (;;)
    {
      if (((ArrayList)localObject).size() > 0) {
        f.a().e().reportString(266935, (ArrayList)localObject);
      }
      cl.b("Taiji", "Cmd_CSAuthSolutionReport no data");
      return;
      this.j.b();
      break;
      label146:
      paramInt = ((SCSolutionRes)paramJceStruct).ret;
      if (paramInt != 0) {
        ((ArrayList)localObject).add(String.valueOf(paramInt));
      }
    }
    label171:
    this.c.sendShark(3561, (JceStruct)localObject, new SCAuthDataRes(), 2, new s(this));
  }
  
  private void a(ArrayList paramArrayList)
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
    Object localObject1 = u.a(this.f);
    ((u)localObject1).c(System.currentTimeMillis());
    Object localObject2 = new ArrayList();
    if (paramJceStruct.solutionList != null)
    {
      ((List)localObject2).addAll(paramJceStruct.solutionList);
      cl.b("Taiji", "sols size:" + paramJceStruct.solutionList.size());
    }
    if (paramJceStruct.canceledSolutionList != null)
    {
      ((List)localObject2).addAll(paramJceStruct.canceledSolutionList);
      cl.b("Taiji", "canceld sols size:" + paramJceStruct.canceledSolutionList.size());
    }
    int m;
    if (((List)localObject2).size() > 0)
    {
      if (paramInt == 2) {
        cl.b("Taiji", "GotSolsTime:" + (System.currentTimeMillis() - this.h));
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
        cl.b("Taiji", "solution info:" + localSolutionItem.adapterId + "|" + localSolutionItem.commSoluId + "|" + localSolutionItem.extSoluId + "|" + localSolutionItem.policyId);
      }
      localObject2 = ((u)localObject1).e();
      this.e = null;
      if (((TextUtils.isEmpty((CharSequence)localObject2)) && ((!paramBoolean) || (paramInt == 3))) || ((paramBoolean) && (paramInt == 2)))
      {
        this.e = ci.c(ch.a(paramJceStruct));
        cl.b("Taiji", "lastAllMd5:" + (String)localObject2 + "|currentAllMd5:" + this.e);
      }
      if ((!paramBoolean) || (paramInt != 2) || (!((String)localObject2).equals(this.e)))
      {
        localObject1 = this.d;
        localObject2 = this.d;
        if (paramBoolean)
        {
          m = 1;
          ((t)localObject1).sendMessage(((t)localObject2).obtainMessage(2, m, paramInt, paramJceStruct));
        }
      }
    }
    for (;;)
    {
      return localCSAuthDataRes;
      m = 0;
      break;
      if (!((u)localObject1).f())
      {
        ((u)localObject1).a(true);
        continue;
        if ((paramBoolean) && (paramInt == 2) && (this.i + 1 < 3))
        {
          this.i += 1;
          this.g = true;
          this.d.sendMessageDelayed(this.d.obtainMessage(1, null), 500L);
          paramJceStruct = new ArrayList(1);
          if (TextUtils.isEmpty(((u)localObject1).e())) {
            if (!((u)localObject1).g())
            {
              paramJceStruct.add("r");
              ((u)localObject1).b(true);
            }
          }
          for (;;)
          {
            f.a().e().reportString(266935, paramJceStruct);
            cl.b("Taiji", "no data, retry pull all");
            break;
            paramJceStruct.add("rr");
            continue;
            paramJceStruct.add("rt");
          }
        }
        if (!((u)localObject1).f()) {
          ((u)localObject1).a(true);
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
    CSPullSolutionInfo localCSPullSolutionInfo = new CSPullSolutionInfo();
    if (paramMessage.obj != null)
    {
      localCSPullSolutionInfo.adapterIdList = ((ArrayList)paramMessage.obj);
      localCSPullSolutionInfo.pullType = 1;
      cl.b("Taiji", "MSG_PULL_DIRECTLY EPSRT_ADAPTER");
    }
    while (this.c == null)
    {
      return;
      paramMessage = u.a(this.f);
      if (System.currentTimeMillis() - paramMessage.c() > a.longValue())
      {
        localCSPullSolutionInfo.pullType = 2;
        paramMessage.a(System.currentTimeMillis());
        cl.b("Taiji", "MSG_PULL_DIRECTLY EPSRT_ALL");
      }
      else
      {
        if ((!this.g) && (!this.j.a()))
        {
          cl.b("Taiji", "not time");
          return;
        }
        localCSPullSolutionInfo.pullType = 3;
        cl.b("Taiji", "MSG_PULL_DIRECTLY EPSRT_CHANGED");
      }
    }
    this.c.sendShark(3559, localCSPullSolutionInfo, new SCSolutionRes(), 2, new r(this, localCSPullSolutionInfo));
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
      cl.b("Taiji", "isPullAll?" + bool);
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
          cl.b("Taiji", "sol is null");
          continue;
          bool = false;
          break;
        }
        Object localObject5 = c.a().a(this.f, ch.a(localSolutionItem));
        if (localObject5 == null)
        {
          cl.b("Taiji", "encode return, data null");
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
              cl.b("Taiji", "nochanged adapter : " + (String)localObject5 + "|" + localSolutionItem.adapterId + "|" + localSolutionItem.commSoluId + "|" + localSolutionItem.extSoluId + "|" + localSolutionItem.policyId);
            }
            else
            {
              localHashMap.put(Integer.valueOf(localSolutionItem.adapterId), localObject5);
              cl.b("Taiji", "changed adapter : " + (String)localObject5 + "|" + localSolutionItem.adapterId + "|" + localSolutionItem.commSoluId + "|" + localSolutionItem.extSoluId + "|" + localSolutionItem.policyId);
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
    Object localObject3 = u.a(this.f);
    if (this.e != null)
    {
      ((u)localObject3).c(this.e);
      ((u)localObject3).a(System.currentTimeMillis());
    }
    if ((((SCSolutionRes)localObject2).canceledSolutionList != null) && (((SCSolutionRes)localObject2).canceledSolutionList.size() > 0))
    {
      localObject2 = ((SCSolutionRes)localObject2).canceledSolutionList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (SolutionItem)((Iterator)localObject2).next();
        ((a)localObject1).b(((SolutionItem)localObject4).adapterId);
        cl.b("Taiji", "remove " + ((SolutionItem)localObject4).adapterId);
      }
    }
    if ((!((u)localObject3).f()) || (((u)localObject3).g()))
    {
      ((u)localObject3).a(true);
      localObject1 = new ArrayList(1);
      if (paramMessage.arg1 != 1) {
        break label697;
      }
      ((ArrayList)localObject1).add("pl");
    }
    for (;;)
    {
      f.a().e().reportString(266935, (ArrayList)localObject1);
      if (((u)localObject3).g())
      {
        ((u)localObject3).b(false);
        paramMessage = new ArrayList(1);
        ((ArrayList)localObject1).add("rs");
        f.a().e().reportString(266935, paramMessage);
      }
      if (localHashMap.size() > 0) {
        a(new ArrayList(localHashMap.keySet()));
      }
      return;
      label697:
      ((ArrayList)localObject1).add("ps");
    }
  }
  
  public SolutionItem a(int paramInt)
  {
    String str = a.a(this.f).a(paramInt);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return (SolutionItem)ch.a(c.a().b(this.f, Base64.decode(str, 2)), new SolutionItem(), false);
  }
  
  public void a(List paramList)
  {
    cl.b("Taiji", "pullSolutionsFromCloud");
    if (this.c == null) {
      throw new RuntimeException("host was not set shark before pull solutions!");
    }
    this.d.sendMessage(this.d.obtainMessage(0, 1, 0, paramList));
    this.h = System.currentTimeMillis();
    cl.b("Taiji", "pullTime:" + this.h);
  }
  
  public boolean a()
  {
    return u.a(this.f).f();
  }
  
  public List b(List paramList)
  {
    Object localObject1 = a.a(this.f).a(paramList);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      cl.b("Taiji", "getSolutionsFromLocal datas is null");
      return null;
    }
    paramList = new ArrayList(paramList.size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = (SolutionItem)ch.a(c.a().b(this.f, Base64.decode((String)localObject2, 2)), new SolutionItem(), false);
        if (localObject2 != null) {
          paramList.add(localObject2);
        }
      }
    }
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      cl.b("Taiji", String.valueOf(((SolutionItem)((Iterator)localObject1).next()).adapterId));
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.o
 * JD-Core Version:    0.7.0.1
 */