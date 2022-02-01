package com.tencent.android.tpush.service.cache;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.a;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CacheManager
{
  public static void UninstallInfoByPkgName(String paramString)
  {
    a(paramString, (byte)2);
  }
  
  public static void UninstallInfoSuccessByPkgName(String paramString)
  {
    a(paramString, (byte)4);
  }
  
  public static void UnregisterInfoByPkgName(String paramString)
  {
    a(paramString, (byte)1);
  }
  
  public static void UnregisterInfoSuccessByPkgName(String paramString)
  {
    a(paramString, (byte)3);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + ".com.tencent.tpush.cache" + paramString2;
  }
  
  private static void a(String paramString) {}
  
  private static void a(String paramString, byte paramByte)
  {
    if (i.b(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = getRegisterEntityMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        RegisterEntity localRegisterEntity = (RegisterEntity)((Map.Entry)localIterator.next()).getValue();
        if ((localRegisterEntity != null) && (!i.b(localRegisterEntity.packageName)) && (paramString.equals(localRegisterEntity.packageName))) {
          localRegisterEntity.state = paramByte;
        }
      }
    }
  }
  
  public static void addRegisterInfo(RegisterEntity paramRegisterEntity)
  {
    if ((paramRegisterEntity != null) && (paramRegisterEntity.accessId > 0L)) {
      getRegisterEntityMap().put(Long.valueOf(paramRegisterEntity.accessId), paramRegisterEntity);
    }
  }
  
  public static void clearDomainServerItem(Context paramContext)
  {
    try
    {
      Object localObject = getDomainKeyList(paramContext);
      ((ArrayList)localObject).add(String.valueOf(MobileType.CHINAMOBILE.getType()));
      ((ArrayList)localObject).add(String.valueOf(MobileType.TELCOM.getType()));
      ((ArrayList)localObject).add(String.valueOf(MobileType.UNICOM.getType()));
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        str = str + ".com.tencent.tpush.cache.server";
        try
        {
          PushPreferences.putString(paramContext, str, "");
        }
        catch (Throwable localThrowable)
        {
          TLogger.e("CacheManager", "", localThrowable);
        }
      }
    }
    catch (NullReturnException localNullReturnException)
    {
      for (;;)
      {
        ArrayList localArrayList = new ArrayList();
      }
    }
  }
  
  public static String findValidPackageByAccessid(long paramLong)
  {
    RegisterEntity localRegisterEntity = (RegisterEntity)getRegisterEntityMap().get(Long.valueOf(paramLong));
    if ((localRegisterEntity != null) && (localRegisterEntity.isRegistered())) {
      return localRegisterEntity.packageName;
    }
    return null;
  }
  
  public static RegisterEntity findValidRegisterEntityByPkg(String paramString)
  {
    if (i.b(paramString)) {
      return null;
    }
    Iterator localIterator = getRegisterEntityMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      RegisterEntity localRegisterEntity = (RegisterEntity)((Map.Entry)localIterator.next()).getValue();
      if ((localRegisterEntity != null) && (paramString.equals(localRegisterEntity.packageName))) {
        return localRegisterEntity;
      }
    }
    return null;
  }
  
  public static Context getContext()
  {
    if (b.e() != null) {
      return b.e();
    }
    return XGPushManager.getContext();
  }
  
  public static RegisterEntity getCurrentAppRegisterEntity(Context paramContext)
  {
    paramContext = PushPreferences.getString(paramContext, a("cur.register", ".reg"), "");
    if (!i.b(paramContext)) {
      return RegisterEntity.decode(paramContext);
    }
    return null;
  }
  
  public static String getDomain(Context paramContext)
  {
    if (paramContext != null) {
      PushPreferences.getString(paramContext, ".com.tencent.tpush.cache.domain", "");
    }
    return "";
  }
  
  public static ArrayList<String> getDomainKeyList(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullReturnException("getDomainKeyList return null,because ctx is null");
    }
    try
    {
      paramContext = d.a(Rijndael.decrypt(PushPreferences.getString(paramContext, ".com.tencent.tpush.cache.domain.key", "")));
      if ((paramContext instanceof ArrayList)) {
        return (ArrayList)paramContext;
      }
      throw new NullReturnException("getDomainKeyList return null,because object not instance of ArrayList<?>");
    }
    catch (Exception paramContext)
    {
      throw new NullReturnException("getDomainKeyList return null，deseriallize err", paramContext);
    }
  }
  
  public static long getGuid(Context paramContext)
  {
    return GuidInfoManager.getGuid(paramContext);
  }
  
  public static String getQua(Context paramContext, long paramLong)
  {
    String str = "";
    if (paramContext != null) {
      str = Rijndael.decrypt(PushPreferences.getString(paramContext, ".com.tencent.tpush.cache.qua." + paramLong, ""));
    }
    return str;
  }
  
  public static Map<Long, RegisterEntity> getRegInfoByApps(Context paramContext)
  {
    paramContext = new a(paramContext);
    Thread localThread = new Thread(paramContext);
    localThread.start();
    try
    {
      localThread.join(3500L);
      return paramContext.a();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TLogger.e("CacheManager", localThrowable.toString());
      }
    }
  }
  
  public static Map<Long, RegisterEntity> getRegisterEntityMap()
  {
    try
    {
      Map localMap = getRegInfoByApps(getContext());
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static List<RegisterEntity> getRegisterInfo(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramContext != null)
    {
      paramContext = getRegisterEntityMap().entrySet().iterator();
      while (paramContext.hasNext())
      {
        RegisterEntity localRegisterEntity = (RegisterEntity)((Map.Entry)paramContext.next()).getValue();
        if ((localRegisterEntity != null) && (localRegisterEntity.isRegistered())) {
          localArrayList.add(localRegisterEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public static RegisterEntity getRegisterInfoByPkgName(String paramString)
  {
    return findValidRegisterEntityByPkg(paramString);
  }
  
  public static List<String> getRegisterInfos(Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2;
    try
    {
      Iterator localIterator = getRegisterEntityMap().entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          RegisterEntity localRegisterEntity = (RegisterEntity)((Map.Entry)localIterator.next()).getValue();
          if ((localRegisterEntity != null) && (!i.b(localRegisterEntity.packageName)) && (localRegisterEntity.isRegistered()))
          {
            localArrayList1.add(localRegisterEntity.packageName);
            continue;
            if (localArrayList2.contains(paramContext.getPackageName())) {
              break;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("CacheManager", "", localThrowable);
      localArrayList2 = new ArrayList();
    }
    for (;;)
    {
      localArrayList2.add(paramContext.getPackageName());
      return localArrayList2;
    }
  }
  
  public static String getToken(Context paramContext)
  {
    return GuidInfoManager.getToken(paramContext);
  }
  
  public static void removeRegisterInfoByPkgName(String paramString)
  {
    a(paramString);
  }
  
  public static void removeRegisterInfos(String paramString)
  {
    a(paramString, (byte)1);
  }
  
  public static void saveDomain(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      PushPreferences.putString(paramContext, ".com.tencent.tpush.cache.domain", paramString);
    }
  }
  
  public static void saveDomainKey(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    try
    {
      ArrayList localArrayList1 = getDomainKeyList(paramContext);
      localArrayList1.add(paramString);
      saveDomainKeyList(paramContext, localArrayList1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList2 = new ArrayList();
      }
    }
  }
  
  public static void saveDomainKeyList(Context paramContext, ArrayList<String> paramArrayList)
  {
    String str;
    if (paramContext != null)
    {
      str = "";
      if (paramArrayList == null) {}
    }
    try
    {
      str = d.a(paramArrayList);
      PushPreferences.putString(paramContext, ".com.tencent.tpush.cache.domain.key", Rijndael.encrypt(str));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("CacheManager", "", paramContext);
    }
  }
  
  public static void setCurrentAppRegisterEntity(Context paramContext, RegisterEntity paramRegisterEntity)
  {
    PushPreferences.putString(paramContext, a("cur.register", ".reg"), RegisterEntity.encode(paramRegisterEntity));
  }
  
  public static void setQua(Context paramContext, long paramLong, String paramString)
  {
    if ((paramContext != null) && (!i.b(paramString)) && (paramLong > 0L)) {
      PushPreferences.putString(paramContext, ".com.tencent.tpush.cache.qua." + paramLong, paramString);
    }
  }
  
  static class a
    implements Runnable
  {
    private Context a;
    private Map<Long, RegisterEntity> b = new HashMap();
    
    a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public Map<Long, RegisterEntity> a()
    {
      try
      {
        Map localMap = this.b;
        return localMap;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void a(Map<Long, RegisterEntity> paramMap)
    {
      try
      {
        this.b = paramMap;
        return;
      }
      finally
      {
        paramMap = finally;
        throw paramMap;
      }
    }
    
    public void run()
    {
      try
      {
        a(a.c(CacheManager.getContext()));
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */