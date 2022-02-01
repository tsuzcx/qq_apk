import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ubi
  implements ubd.a
{
  private static ubi jdField_a_of_type_Ubi;
  ubd jdField_a_of_type_Ubd;
  LruCache<String, Map<String, APIQuotaItem>> b = new LruCache(5);
  Map<String, Boolean> hd = new ConcurrentHashMap();
  
  private ubi()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter");
      }
    }
    for (this.jdField_a_of_type_Ubd = new ube();; this.jdField_a_of_type_Ubd = new ubg())
    {
      this.jdField_a_of_type_Ubd.a(this);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter proxy");
      }
    }
  }
  
  @NonNull
  private Map<String, APIQuotaItem> a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "init key=" + paramString1);
    }
    int i = 0;
    int j = 0;
    Map localMap = (Map)this.b.get(paramString1);
    Object localObject = localMap;
    if (localMap == null) {}
    try
    {
      localMap = (Map)this.b.get(paramString1);
      localObject = localMap;
      i = j;
      if (localMap == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "init create cache map, key=" + paramString1);
        }
        localObject = new ConcurrentHashMap();
        this.b.put(paramString1, localObject);
        i = 1;
      }
      if (i != 0) {
        this.jdField_a_of_type_Ubd.A(paramString1, paramInt, paramString2);
      }
      return localObject;
    }
    finally {}
  }
  
  public static ubi a()
  {
    if (jdField_a_of_type_Ubi == null) {}
    try
    {
      if (jdField_a_of_type_Ubi == null) {
        jdField_a_of_type_Ubi = new ubi();
      }
      return jdField_a_of_type_Ubi;
    }
    finally {}
  }
  
  public void B(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, paramString2);
  }
  
  public void C(String paramString1, int paramInt, String paramString2)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "load from proxy key=" + paramString1);
    }
    this.hd.put(paramString1, Boolean.TRUE);
    this.jdField_a_of_type_Ubd.A(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "update key=" + paramString1 + ", api=" + paramString3 + ", remain=" + paramLong1);
    }
    Object localObject = (Map)this.b.get(paramString1);
    APIQuotaItem localAPIQuotaItem;
    if (localObject != null)
    {
      localAPIQuotaItem = (APIQuotaItem)((Map)localObject).get(paramString3);
      if (localAPIQuotaItem != null) {
        break label222;
      }
      localAPIQuotaItem = new APIQuotaItem();
      localAPIQuotaItem.remainTimes = paramLong1;
      localAPIQuotaItem.expireTimeMillis = paramLong2;
      ((Map)localObject).put(paramString3, localAPIQuotaItem);
    }
    for (;;)
    {
      if ((BaseApplicationImpl.sProcessId == 1) && (this.hd.containsKey(paramString1)))
      {
        localObject = new Intent("com.tencent.mobileqq.Doraemon.monitor.update");
        ((Intent)localObject).putExtra("key", paramString1);
        ((Intent)localObject).putExtra("type", paramInt);
        ((Intent)localObject).putExtra("appid", paramString2);
        ((Intent)localObject).putExtra("api", paramString3);
        ((Intent)localObject).putExtra("remain", paramLong1);
        ((Intent)localObject).putExtra("time", paramLong2);
        BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
      }
      return;
      label222:
      localAPIQuotaItem.remainTimes = paramLong1;
      localAPIQuotaItem.expireTimeMillis = paramLong2;
    }
  }
  
  public boolean b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = (Map)this.b.get(paramString1);
    if (localObject == null) {}
    for (paramString2 = a(paramString1, paramInt, paramString2);; paramString2 = (String)localObject)
    {
      localObject = (APIQuotaItem)paramString2.get(paramString3);
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "no record use default key=" + paramString1 + ", api=" + paramString3);
        }
        paramString1 = new APIQuotaItem();
        paramString1.remainTimes = 10L;
        paramString1.expireTimeMillis = (l + 60000L);
        paramString2.put(paramString3, paramString1);
        return true;
      }
      if (((APIQuotaItem)localObject).remainTimes > 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "has quota key=" + paramString1 + ", api=" + paramString3 + ", remain=" + ((APIQuotaItem)localObject).remainTimes);
        }
        return true;
      }
      if (((APIQuotaItem)localObject).expireTimeMillis < l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "expired use default key=" + paramString1 + ", api=" + paramString3);
        }
        ((APIQuotaItem)localObject).remainTimes = 10L;
        ((APIQuotaItem)localObject).expireTimeMillis = (l + 60000L);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "no quota key=" + paramString1 + ", api=" + paramString3);
      }
      return false;
    }
  }
  
  public void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "report key=" + paramString1 + ", api=" + paramString3);
    }
    this.jdField_a_of_type_Ubd.f(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "report from proxy key=" + paramString1 + ", api=" + paramString3);
    }
    this.hd.put(paramString1, Boolean.TRUE);
    this.jdField_a_of_type_Ubd.f(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void j(String paramString, HashMap<String, APIQuotaItem> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "update all key=" + paramString);
    }
    Object localObject = (Map)this.b.get(paramString);
    if (localObject != null) {
      ((Map)localObject).putAll(paramHashMap);
    }
    if ((BaseApplicationImpl.sProcessId == 1) && (this.hd.containsKey(paramString)))
    {
      localObject = new Intent("com.tencent.mobileqq.Doraemon.monitor.update_batch");
      ((Intent)localObject).putExtra("key", paramString);
      ((Intent)localObject).putExtra("map", paramHashMap);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubi
 * JD-Core Version:    0.7.0.1
 */