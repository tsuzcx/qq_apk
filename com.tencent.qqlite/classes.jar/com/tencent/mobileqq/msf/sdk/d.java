package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  static ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (paramToServiceMsg.getServiceName().equals(MsfServiceSdk.get().getMsfServiceName())) {
      return MsfServiceSdk.get().sendMsg(paramToServiceMsg);
    }
    if (!a.containsKey(paramToServiceMsg.getServiceName())) {
      a.putIfAbsent(paramToServiceMsg.getServiceName(), new t(paramToServiceMsg.getServiceName()));
    }
    return ((t)a.get(paramToServiceMsg.getServiceName())).b(paramToServiceMsg);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
    {
      MsfServiceSdk.get().initMsfService();
      return;
    }
    if (!a.containsKey(paramString)) {
      a.putIfAbsent(paramString, new t(paramString));
    }
    ((t)a.get(paramString)).i();
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
    {
      MsfServiceSdk.get().startBaseService();
      return;
    }
    if (!a.containsKey(paramString)) {
      a.putIfAbsent(paramString, new t(paramString));
    }
    ((t)a.get(paramString)).a();
  }
  
  public static void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
    {
      MsfServiceSdk.get().bindBaseService();
      return;
    }
    if (!a.containsKey(paramString)) {
      a.putIfAbsent(paramString, new t(paramString));
    }
    ((t)a.get(paramString)).b();
  }
  
  public static boolean d(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
      {
        MsfServiceSdk.get().unbindMsfService();
        return true;
      }
    } while (!a.containsKey(paramString));
    ((t)a.get(paramString)).g();
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
      {
        MsfServiceSdk.get().stopMsfService();
        return true;
      }
    } while (!a.containsKey(paramString));
    ((t)a.get(paramString)).c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.d
 * JD-Core Version:    0.7.0.1
 */