package com.tencent.qapmsdk.dns.utils;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.dns.HttpDns.Callback;
import com.tencent.qapmsdk.dns.logic.DnsCacheWrapper;
import java.lang.reflect.Field;
import java.net.InetAddress;

public class HookUtils
{
  private static final DnsHookCompatImpl HOOK_IMPL = new DnsHookCompatImplBase(null);
  private static final String TAG = "QAPM_DNS_HookUtils";
  
  static
  {
    if (AndroidVersion.isN())
    {
      HOOK_IMPL = new DnsHookCompatImplV24(null);
      return;
    }
  }
  
  public static void hook()
  {
    try
    {
      HOOK_IMPL.hook();
      Utils.getAsyncCallbackWrapper().onHook(true, null);
      Logger.INSTANCE.i(new String[] { "QAPM_DNS_HookUtils", "hook success!" });
      return;
    }
    catch (Throwable localThrowable)
    {
      Utils.getAsyncCallbackWrapper().onHook(false, localThrowable);
      Logger.INSTANCE.exception("QAPM_DNS_HookUtils", "hook failed!", localThrowable);
    }
  }
  
  static abstract interface DnsHookCompatImpl
  {
    public abstract void hook()
      throws Exception;
  }
  
  static class DnsHookCompatImplBase
    implements HookUtils.DnsHookCompatImpl
  {
    public void hook()
      throws Exception
    {
      Object localObject = InetAddress.class.getDeclaredField("addressCache");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      Field localField = Class.forName("java.net.AddressCache").getDeclaredField("cache");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = Class.forName("libcore.util.BasicLruCache").getDeclaredField("map");
      localField.setAccessible(true);
      localField.set(localObject, new DnsCacheWrapper());
    }
  }
  
  static class DnsHookCompatImplV24
    implements HookUtils.DnsHookCompatImpl
  {
    public void hook()
      throws Exception
    {
      Object localObject = Class.forName("java.net.Inet6AddressImpl").getDeclaredField("addressCache");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      Field localField = Class.forName("java.net.AddressCache").getDeclaredField("cache");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = Class.forName("libcore.util.BasicLruCache").getDeclaredField("map");
      localField.setAccessible(true);
      localField.set(localObject, new DnsCacheWrapper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.HookUtils
 * JD-Core Version:    0.7.0.1
 */