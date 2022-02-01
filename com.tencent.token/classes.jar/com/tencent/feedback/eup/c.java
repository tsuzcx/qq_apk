package com.tencent.feedback.eup;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements Thread.UncaughtExceptionHandler
{
  private static c c;
  private Thread.UncaughtExceptionHandler a = null;
  private Context b = null;
  
  private c(Context paramContext)
  {
    if (paramContext != null)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
    this.b = paramContext;
  }
  
  private int a(List<e> paramList, int paramInt, boolean paramBoolean)
  {
    Context localContext = this.b;
    if (paramList != null)
    {
      if (paramInt <= 0) {
        return 0;
      }
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new b.2());
      paramList = paramList.iterator();
      while ((paramList.hasNext()) && (paramInt > localArrayList.size()))
      {
        e locale = (e)paramList.next();
        if ((locale.b()) && (!paramBoolean)) {
          break;
        }
        localArrayList.add(locale);
        paramList.remove();
      }
      if (localArrayList.size() > 0) {
        return b.a(localContext, localArrayList);
      }
    }
    return 0;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new c(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (this.a != null)
      {
        com.tencent.feedback.common.e.b("rqdp{ sys crhandle!}", new Object[0]);
        this.a.uncaughtException(paramThread, paramThrowable);
        return;
      }
      com.tencent.feedback.common.e.b("rqdp{ kill!}", new Object[0]);
      Process.killProcess(Process.myPid());
      System.exit(1);
      return;
    }
    finally {}
  }
  
  private static void c()
  {
    b.1 local1 = new b.1();
    local1.setName("ImmediateEUP");
    local1.start();
    try
    {
      local1.join(3000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      if (!com.tencent.feedback.common.e.a(localInterruptedException)) {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public final void a()
  {
    try
    {
      com.tencent.feedback.common.e.a("rqdp{ eup regist}", new Object[0]);
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != this)
      {
        this.a = localUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
      }
      return;
    }
    finally {}
  }
  
  public final boolean a(e parame, CrashStrategyBean paramCrashStrategyBean)
  {
    if ((parame == null) && (paramCrashStrategyBean == null))
    {
      com.tencent.feedback.common.e.c("handler exception data params error", new Object[0]);
      return false;
    }
    Object localObject1;
    Object localObject3;
    if (paramCrashStrategyBean.isMerged())
    {
      localObject1 = this.b;
      if (parame == null) {}
      for (;;)
      {
        localObject1 = null;
        break;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(parame.P());
        ((StringBuilder)localObject2).append("\n");
        ((StringBuilder)localObject2).append(parame.e());
        ((StringBuilder)localObject2).append("\n");
        ((StringBuilder)localObject2).append(parame.h());
        localObject2 = com.tencent.feedback.proguard.a.c(((StringBuilder)localObject2).toString().getBytes());
        if (localObject2 == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  md5 error!}", new Object[0]);
        }
        else
        {
          parame.g((String)localObject2);
          parame.a(true);
          parame.b(1);
          parame.a(0);
          localObject2 = b.a((Context)localObject1, 1, "desc", -1, (String)localObject2, -1, -1, -1, -1, -1L, -1L, null);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (e)((List)localObject2).get(0);
            if (((e)localObject2).l() != null)
            {
              localObject3 = ((e)localObject2).l();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(parame.i());
              if (((String)localObject3).contains(localStringBuilder.toString()))
              {
                com.tencent.feedback.common.e.b("rqdp{ already merged} %d", new Object[] { Long.valueOf(parame.i()) });
                localObject1 = localObject2;
                break;
              }
            }
            ((e)localObject2).b(((e)localObject2).m() + 1);
            if (((e)localObject2).l() == null) {
              ((e)localObject2).f("");
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((e)localObject2).l());
            ((StringBuilder)localObject3).append(parame.i());
            ((StringBuilder)localObject3).append("\n");
            ((e)localObject2).f(((StringBuilder)localObject3).toString());
            com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertOrUpdateEUP() start}", new Object[0]);
            if ((localObject1 != null) && (localObject2 != null))
            {
              localObject3 = new ArrayList();
              ((List)localObject3).add(localObject2);
              bool = b.b((Context)localObject1, (List)localObject3);
            }
            else
            {
              com.tencent.feedback.common.e.c("rqdp{  context == null || bean == null,pls check}", new Object[0]);
              bool = false;
            }
            localObject1 = localObject2;
            if (!bool) {
              break;
            }
            com.tencent.feedback.common.e.a("rqdp{  eupMeg update success} %b , c:%d , at:%s up:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((e)localObject2).m()), ((e)localObject2).l(), Integer.valueOf(((e)localObject2).j()) });
            localObject1 = localObject2;
            if (parame.p() == null) {
              break;
            }
            localObject3 = new File(parame.p());
            localObject1 = localObject2;
            if (!((File)localObject3).exists()) {
              break;
            }
            localObject1 = localObject2;
            if (!((File)localObject3).isFile()) {
              break;
            }
            ((File)localObject3).delete();
            localObject1 = localObject2;
            break;
          }
          com.tencent.feedback.common.e.b("rqdp{  new one ,no merged!}", new Object[0]);
        }
      }
      if (localObject1 != null)
      {
        com.tencent.feedback.common.e.a("merge success return", new Object[0]);
        if ((!((e)localObject1).w()) && (((e)localObject1).m() >= 2))
        {
          com.tencent.feedback.common.e.a("rqdp{ may be crash too frequent! do immediate upload in merge!}", new Object[0]);
          c();
        }
        return true;
      }
    }
    int i = paramCrashStrategyBean.getMaxStoredNum();
    Object localObject2 = b.a(this.b, i + 1, "asc", -1, null, -1, -1, -1, -1, -1L, -1L, null);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = ((List)localObject2).size() - i + 1;
      if ((i > 0) && (a((List)localObject2, i, parame.b()) < i))
      {
        com.tencent.feedback.common.e.c("can't add more eup!", new Object[0]);
        return false;
      }
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 1))
    {
      localObject1 = (e)((List)localObject2).get(0);
      localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (e)((Iterator)localObject3).next();
        if ((((e)localObject1).i() < ((e)localObject2).i()) && (((e)localObject2).b())) {
          localObject1 = localObject2;
        }
      }
      if ((((e)localObject1).b()) && (parame.i() - ((e)localObject1).i() < 60000L))
      {
        com.tencent.feedback.common.e.c("rqdp{ may be crash too frequent! do immediate upload in not merge!}", new Object[0]);
        c();
      }
    }
    b.a(this.b, parame, paramCrashStrategyBean);
    if (com.tencent.feedback.common.a.e(this.b))
    {
      com.tencent.feedback.common.e.b("save log", new Object[0]);
      parame.a(com.tencent.feedback.proguard.a.a(paramCrashStrategyBean.getOnlyLogTag(), paramCrashStrategyBean.getMaxLogRow()));
    }
    else
    {
      parame.a(null);
    }
    boolean bool = b.a(this.b, parame);
    com.tencent.feedback.common.e.a("store new eup pn:%s, isMe:%b , isNa:%b , res:%b ", new Object[] { parame.q(), Boolean.valueOf(parame.c()), Boolean.valueOf(parame.b()), Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean a(String paramString1, Throwable paramThrowable, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    String str5 = com.tencent.feedback.common.c.a(this.b).E();
    String str2;
    if (paramThrowable != null) {
      str2 = paramThrowable.getMessage();
    } else {
      str2 = "";
    }
    String str1;
    if (paramThrowable != null) {
      str1 = paramThrowable.getClass().getName();
    } else {
      str1 = "";
    }
    Object localObject = f.l();
    if (localObject == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      localObject = null;
    }
    else
    {
      localObject = ((f)localObject).r();
    }
    long l = new Date().getTime();
    String str3;
    try
    {
      str3 = b.a(paramThrowable, CrashReport.getCrashRuntimeStrategy());
    }
    catch (Throwable paramThrowable)
    {
      com.tencent.feedback.common.e.d("create stack from throw fail!", new Object[0]);
      if (!com.tencent.feedback.common.e.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
      str3 = "";
    }
    String str4;
    if ((str3 != null) && (str3.contains("\n"))) {
      str4 = str3.substring(0, str3.indexOf("\n"));
    } else {
      str4 = "";
    }
    com.tencent.feedback.common.e.b("rqdp{ stack:}%s", new Object[] { str3 });
    if ((paramBoolean) && (localObject != null))
    {
      com.tencent.feedback.common.e.b("get crash extra...", new Object[0]);
      if (localObject != null) {
        try
        {
          com.tencent.feedback.common.e.a("your crmsg", new Object[0]);
          paramThrowable = ((CrashHandleListener)localObject).getCrashExtraMessage(false, str1, str4, str3, -10000, l);
        }
        catch (Throwable paramThrowable)
        {
          com.tencent.feedback.common.e.d("rqdp{ get extra msg error} %s", new Object[] { paramThrowable.toString() });
          if (!com.tencent.feedback.common.e.a(paramThrowable)) {
            paramThrowable.printStackTrace();
          }
        }
      } else {
        paramThrowable = paramString2;
      }
      if (localObject != null) {
        try
        {
          com.tencent.feedback.common.e.a("your crdata", new Object[0]);
          paramString2 = ((CrashHandleListener)localObject).getCrashExtraData(false, str1, str4, str3, -10000, l);
        }
        catch (Throwable paramString2)
        {
          com.tencent.feedback.common.e.d("rqdp{ get extra msg error} %s", new Object[] { paramString2.toString() });
          if (!com.tencent.feedback.common.e.a(paramString2)) {
            paramString2.printStackTrace();
          }
        }
      } else {
        paramString2 = paramArrayOfByte;
      }
    }
    else
    {
      paramThrowable = paramString2;
      paramString2 = paramArrayOfByte;
    }
    paramArrayOfByte = com.tencent.feedback.common.c.a(this.b);
    paramThrowable = b.a(this.b, paramArrayOfByte.g(), paramArrayOfByte.h(), paramArrayOfByte.j(), paramArrayOfByte.y(), str5, paramString1, str4, str1, str2, str3, l, paramThrowable, paramString2);
    paramThrowable.a(paramBoolean ^ true);
    try
    {
      paramString2 = com.tencent.feedback.proguard.a.b();
      if (paramString2 != null)
      {
        paramThrowable.C().putAll(paramString2);
        if ((paramString1 != null) && (paramString1.trim().length() > 0)) {
          paramThrowable.C().remove(paramString1);
        }
      }
    }
    catch (Throwable paramString1)
    {
      com.tencent.feedback.common.e.d("get all threads stack fail", new Object[0]);
      if (!com.tencent.feedback.common.e.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    if ((paramBoolean) && (localObject != null)) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        com.tencent.feedback.common.e.a("your ask2save", new Object[0]);
        if ((str2 == null) || (str2.trim().length() <= 0)) {
          break label688;
        }
        paramString1 = new StringBuilder();
        paramString1.append(str1);
        paramString1.append(":");
        paramString1.append(str2);
        paramString1 = paramString1.toString();
        bool1 = ((CrashHandleListener)localObject).onCrashSaving(false, paramString1, str4, str3, -10000, l, paramThrowable.k(), paramThrowable.D(), paramThrowable.v());
      }
      catch (Throwable paramString1)
      {
        bool2 = true;
        com.tencent.feedback.common.e.d("rqdp{ get extra msg error} %s", new Object[] { paramString1.toString() });
        bool1 = bool2;
        if (com.tencent.feedback.common.e.a(paramString1)) {
          break label645;
        }
      }
      paramString1.printStackTrace();
      boolean bool1 = bool2;
      break label645;
      bool1 = true;
      label645:
      if (paramBoolean) {
        BuglyBroadcastRecevier.brocastCrash(this.b, paramThrowable);
      }
      if (bool1) {
        return a(paramThrowable, CrashReport.getCrashRuntimeStrategy());
      }
      com.tencent.feedback.common.e.c("not to save", new Object[0]);
      return false;
      label688:
      paramString1 = str1;
    }
  }
  
  public final void b()
  {
    try
    {
      com.tencent.feedback.common.e.a("rqdp{ eup unregister}", new Object[0]);
      if (Thread.getDefaultUncaughtExceptionHandler() == this)
      {
        Thread.setDefaultUncaughtExceptionHandler(this.a);
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (paramThrowable != null) {}
    Object localObject;
    boolean bool2;
    try
    {
      if (!com.tencent.feedback.common.e.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
      localObject = f.l();
      if (localObject == null)
      {
        com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
        localObject = null;
      }
      else
      {
        localObject = ((f)localObject).r();
      }
      bool2 = true;
      if (localObject != null)
      {
        try
        {
          com.tencent.feedback.common.e.a("your crhandler start", new Object[0]);
          ((CrashHandleListener)localObject).onCrashHandleStart(false);
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.feedback.common.e.d("rqdp{ handle start error} %s", new Object[] { localThrowable2.toString() });
          if (com.tencent.feedback.common.e.a(localThrowable2)) {
            break label240;
          }
        }
        localThrowable2.printStackTrace();
      }
    }
    finally {}
    for (String str = paramThread.getName();; str = "")
    {
      com.tencent.feedback.common.e.b("rqdp{ handle eup result} %b", new Object[] { Boolean.valueOf(a(str, paramThrowable, null, null, true)) });
      boolean bool1 = bool2;
      if (localObject != null) {
        try
        {
          com.tencent.feedback.common.e.a("your crhandler end", new Object[0]);
          bool1 = ((CrashHandleListener)localObject).onCrashHandleEnd(false);
        }
        catch (Throwable localThrowable1)
        {
          com.tencent.feedback.common.e.d("rqdp{ your crash handle end error} %s", new Object[] { localThrowable1.toString() });
          bool1 = bool2;
          if (!com.tencent.feedback.common.e.a(localThrowable1))
          {
            localThrowable1.printStackTrace();
            bool1 = bool2;
          }
        }
      }
      if (bool1) {
        a(paramThread, paramThrowable);
      }
      return;
      label240:
      if (paramThread != null) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.c
 * JD-Core Version:    0.7.0.1
 */