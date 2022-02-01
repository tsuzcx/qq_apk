import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class kgi
  implements lcm.e
{
  private Map<Integer, List<kgi.b>> L = new HashMap();
  private kgi.c a = new kgi.c();
  private Map<Integer, Double> dG = new HashMap();
  private Map<String, List<Double>> dH = new HashMap();
  
  private kgi()
  {
    lcm.d.a(this);
    awiy.a().a(this.a);
  }
  
  public static kgi a()
  {
    return kgi.a.b();
  }
  
  private int aJ(String paramString)
  {
    int i = -1;
    if ("list_new_kandian".equals(paramString)) {
      i = 0;
    }
    do
    {
      int j;
      do
      {
        return i;
        if ("list_subscript".equals(paramString)) {
          return 70;
        }
        if ((paramString == null) || (!paramString.startsWith("list_kandian_channel_"))) {
          break;
        }
        j = "list_kandian_channel_".length();
      } while (j >= paramString.length());
      return Integer.parseInt(paramString.substring(j));
      if ("list_comment_kandian".equals(paramString)) {
        return 6666;
      }
      if ("proteus_family_feeds".equals(paramString)) {
        return 8888;
      }
      if ("list_kandian_native_web".equals(paramString)) {
        return 5555;
      }
    } while (!"list_kandian_daily_new".equals(paramString));
    return 9999;
  }
  
  private void b(String paramString, double paramDouble)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDropFrameHelper.2(this, paramString, paramDouble));
  }
  
  private JSONObject m()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("proteus_bid", awit.sn("default_feeds_proteus_offline_bid"));
    localJSONObject.put("cpu_type", aqgz.getCpuType());
    localJSONObject.put("cpu_frequency", aqgz.getCpuFrequency());
    localJSONObject.put("cache_memory", aqgz.getSystemTotalMemory());
    localJSONObject.put("device_model", aqgz.getDeviceModel());
    localJSONObject.put("os_version", aqgz.getDeviceOSVersion());
    if (NetworkState.isWifiConn()) {}
    for (int i = 1;; i = 2)
    {
      localJSONObject.put("network_type", i);
      localJSONObject.put("package_name", "3.4.4.3058");
      return localJSONObject;
    }
  }
  
  public static boolean zo()
  {
    boolean bool = ((Boolean)awit.f("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(true))).booleanValue();
    QLog.d("ReadInJoyDropFrameHelper", 1, "ReadInJoyDropFrameHelper | Report enable :" + bool);
    return bool;
  }
  
  public void a(int paramInt, kgi.b paramb)
  {
    if (this.L != null) {
      if (!this.L.containsKey(Integer.valueOf(paramInt))) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (List)this.L.get(Integer.valueOf(paramInt));; localObject = new ArrayList())
    {
      if (!((List)localObject).contains(paramb)) {
        ((List)localObject).add(paramb);
      }
      this.L.put(Integer.valueOf(paramInt), localObject);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (!zo()) {
      return;
    }
    int i = aJ(paramString);
    double d = (paramArrayOfLong[0] * 16.699999999999999D + paramArrayOfLong[1] * 16.699999999999999D * 1.5D + paramArrayOfLong[2] * 16.699999999999999D * 3.0D + paramArrayOfLong[3] * 16.699999999999999D * 6.0D) / paramLong2;
    if (d < 1.0D) {}
    for (;;)
    {
      QLog.d("ReadInJoyDropFrameHelper", 1, "caculateFeedsFlunency | channelId " + i + " fluencyVal " + d);
      if (this.dH != null)
      {
        if (this.dH.get(String.valueOf(i)) == null) {
          this.dH.put(String.valueOf(i), new ArrayList());
        }
        QLog.d("ReadInJoyDropFrameHelper", 1, "addFluency into reportMap | channelId " + i + " fluencyVal " + d);
        ((List)this.dH.get(String.valueOf(i))).add(Double.valueOf(d));
      }
      if (this.dG == null) {
        break;
      }
      return;
      d = 1.0D;
    }
  }
  
  public void aCg()
  {
    if ((this.dH == null) || (this.dH.isEmpty()))
    {
      QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportMap is empty");
      return;
    }
    QLog.d("ReadInJoyDropFrameHelper", 2, "background | reporFeeds Fluency");
    Iterator localIterator1 = this.dH.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      List localList = (List)this.dH.get(str);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator2 = new ArrayList(localList).iterator();
        while (localIterator2.hasNext())
        {
          Double localDouble = (Double)localIterator2.next();
          b(str, localDouble.doubleValue());
          QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportFeedsFluency channelid " + str + " fluencyVal " + localDouble);
        }
        localList.clear();
      }
    }
    nxr.bcp();
  }
  
  public void b(int paramInt, kgi.b paramb)
  {
    if ((this.L != null) && (this.L.get(Integer.valueOf(paramInt)) != null)) {
      ((List)this.L.get(Integer.valueOf(paramInt))).remove(paramb);
    }
  }
  
  public void foreground() {}
  
  static class a
  {
    private static final kgi a = new kgi(null);
  }
  
  public static abstract interface b
  {
    public abstract void mc(String paramString);
  }
  
  public static class c
    extends awiy.a
  {
    protected void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
    {
      kgi.a().a(paramString, paramLong1, paramArrayOfLong, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgi
 * JD-Core Version:    0.7.0.1
 */