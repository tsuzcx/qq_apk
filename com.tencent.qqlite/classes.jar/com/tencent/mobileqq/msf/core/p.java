package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class p
{
  private static final String a = p.class.getSimpleName();
  private static a b = null;
  private static final ConcurrentHashMap c = new ConcurrentHashMap(100);
  private static final int d = 100;
  private static final long e = 3600000L;
  private static final int f = 1000;
  private static Handler g = new q(Looper.getMainLooper());
  
  public static void a(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    if ((b == null) || (TextUtils.isEmpty(b.a)) || (!b.a.equals(paramToServiceMsg.getUin())))
    {
      b = new a();
      b.a = paramToServiceMsg.getUin();
      b.b = paramToServiceMsg.getRequestSsoSeq();
      b.c = SystemClock.elapsedRealtime();
      b.e = new StringBuilder();
      b.i = new StringBuilder();
    }
    if (!g.hasMessages(1000)) {
      g.sendEmptyMessageDelayed(1000, 3600000L);
    }
  }
  
  private static void a(a parama, boolean paramBoolean)
  {
    if ((parama != null) && (parama.e.length() > 0))
    {
      parama.d = (SystemClock.elapsedRealtime() - parama.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      localHashMap.put("ssoSeq", "" + parama.b);
      localHashMap.put("closeConnReason", parama.e.toString());
      MsfService.core.getStatReporter().a("dim.Msf.WEAKNET_INFOLOGIN3", paramBoolean, parama.d, 0L, localHashMap, false, false);
    }
  }
  
  public static void a(a parama)
  {
    Iterator localIterator;
    if (b != null)
    {
      if (b.e.length() < 100) {
        b.e.append(parama.ordinal()).append(",");
      }
    }
    else
    {
      if ((c == null) || (c.size() <= 0)) {
        return;
      }
      localIterator = c.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if (locala.e.length() < 100)
      {
        locala.e.append(parama.ordinal()).append(",");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(a, 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
      }
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    if ((b != null) && (!TextUtils.isEmpty(b.a)) && (b.a.equals(paramFromServiceMsg.getUin())) && (b.c > 0L))
    {
      a(b, true);
      b = null;
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (TextUtils.isEmpty(paramFromServiceMsg.getUin())) || ("0".equals(paramFromServiceMsg.getUin())) || (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool = false;
    long l = -1L;
    if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {}
    for (int i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();; i = -1)
    {
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {}
      for (String str = (String)paramToServiceMsg.getAttributes().get("fromUin");; str = null)
      {
        if (paramToServiceMsg.getAttributes().containsKey("uin")) {}
        for (paramToServiceMsg = (String)paramToServiceMsg.getAttributes().get("uin");; paramToServiceMsg = null)
        {
          if ((i != -1000) || (bool) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramToServiceMsg)) || (!c.containsKey(str + paramToServiceMsg + l))) {
            break label394;
          }
          if (paramFromServiceMsg.isSuccess())
          {
            b((a)c.remove(str + paramToServiceMsg + l), true);
            return;
          }
          paramToServiceMsg = (a)c.get(str + paramToServiceMsg + l);
          if ((paramToServiceMsg == null) || (paramToServiceMsg.i == null) || (paramToServiceMsg.i.length() >= 100)) {
            break;
          }
          paramToServiceMsg.i.append(paramFromServiceMsg.getBusinessFailCode()).append(",");
          return;
        }
        label394:
        break;
      }
    }
  }
  
  public static void b(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    int j = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (c.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool = false;
    long l = -1L;
    if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {}
    for (int i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();; i = -1)
    {
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        j = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {}
      for (paramMsfCore = (String)paramToServiceMsg.getAttributes().get("fromUin");; paramMsfCore = null)
      {
        if (paramToServiceMsg.getAttributes().containsKey("uin")) {}
        for (String str = (String)paramToServiceMsg.getAttributes().get("uin"); (i == -1000) && (!bool) && (j <= 0) && (!TextUtils.isEmpty(paramMsfCore)) && (!TextUtils.isEmpty(str)); str = null)
        {
          a locala = new a();
          locala.a = paramToServiceMsg.getUin();
          locala.b = paramToServiceMsg.getRequestSsoSeq();
          locala.c = SystemClock.elapsedRealtime();
          locala.e = new StringBuilder();
          locala.f = l;
          locala.g = paramMsfCore;
          locala.h = str;
          locala.i = new StringBuilder();
          c.put(paramMsfCore + str + l, locala);
          return;
        }
        break;
      }
    }
  }
  
  private static void b(a parama, boolean paramBoolean)
  {
    if ((parama != null) && (parama.e.length() > 0))
    {
      parama.d = (SystemClock.elapsedRealtime() - parama.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      localHashMap.put("ssoSeq", "" + parama.b);
      localHashMap.put("closeConnReason", parama.e.toString());
      localHashMap.put("msgSeq", "" + parama.f);
      localHashMap.put("fromUin", parama.g);
      localHashMap.put("toUin", parama.h);
      localHashMap.put("sendFailReason", parama.i.toString());
      MsfService.core.getStatReporter().a("dim.Msf.WEAKNET_SENDCHATMSG3", paramBoolean, parama.d, 0L, localHashMap, false, false);
    }
  }
  
  private static void c()
  {
    if ((b != null) && (SystemClock.elapsedRealtime() - b.c >= 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "clean, clean infoLoginItem by interval check.");
      }
      a(b, false);
      b = null;
    }
    if ((c != null) && (c.size() > 0))
    {
      Iterator localIterator = c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a locala = (a)localEntry.getValue();
        if (SystemClock.elapsedRealtime() - locala.c >= 3600000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "clean, clean SendMsgItem by interval check.");
          }
          b(locala, false);
          c.remove(localEntry.getKey());
        }
      }
    }
  }
  
  public static class a
  {
    public String a;
    public int b;
    public long c;
    public long d;
    public StringBuilder e;
    public long f;
    public String g;
    public String h;
    public StringBuilder i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.p
 * JD-Core Version:    0.7.0.1
 */