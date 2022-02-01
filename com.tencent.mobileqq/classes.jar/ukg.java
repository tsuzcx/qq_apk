import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ukg
{
  private static boolean jdField_a_of_type_Boolean;
  private static HashMap<String, Long> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<String, VideoAdInfo> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<String, VideoAdInfo> f = new HashMap();
  private static HashMap<String, Long> g = new HashMap();
  private int jdField_a_of_type_Int;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private HashMap<String, AdvertisementInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private HashSet<String> jdField_c_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_c_of_type_Boolean = true;
  private boolean jdField_d_of_type_Boolean;
  private HashMap<String, AdvertisementInfo> jdField_e_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_e_of_type_Boolean;
  
  public ukg(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return 4;
    }
    if (pqw.a(paramAdvertisementInfo)) {
      return 11;
    }
    return 3;
  }
  
  private static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("stat_type", 1);
      localJSONObject2.put("percent", paramInt2);
      if (paramInt1 != 0) {
        localJSONObject2.put("duration", paramInt1);
      }
      localJSONObject1.put("statistics_data_report", uks.a(paramContext, paramAdvertisementInfo, localJSONObject2).toString());
      return localJSONObject1;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public static void a(Activity paramActivity, float paramFloat, RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (!a()) {}
    do
    {
      return;
      if ((!paramBoolean) && (paramFloat < 1.0D)) {
        b(paramActivity, paramViewHolder);
      }
      if ((paramBoolean) && (paramFloat <= 0.5D))
      {
        a(paramActivity, paramViewHolder);
        return;
      }
    } while ((paramBoolean) || (paramFloat != 1.0D));
    a(paramActivity, 50, true);
    a(paramViewHolder);
  }
  
  private static void a(Activity paramActivity, int paramInt, VideoAdInfo paramVideoAdInfo)
  {
    if (!a()) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = ois.a(paramVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportVideoFeeds1px ,traceid =" + paramVideoAdInfo.h);
    }
    if (paramVideoAdInfo.jdField_c_of_type_Boolean)
    {
      a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, 10, 0, paramInt);
      return;
    }
    a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, 5, 0, paramInt);
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (!a()) {}
    Object localObject;
    String str;
    VideoAdInfo localVideoAdInfo;
    do
    {
      return;
      Iterator localIterator = jdField_c_of_type_JavaUtilHashMap.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (Long)((Map.Entry)localObject).getValue();
      } while ((localObject == null) || (((Long)localObject).longValue() == 0L));
      jdField_c_of_type_JavaUtilHashMap.put(str, Long.valueOf(0L));
      localVideoAdInfo = (VideoAdInfo)jdField_d_of_type_JavaUtilHashMap.get(str);
    } while (localVideoAdInfo == null);
    AdvertisementInfo localAdvertisementInfo = ois.a(localVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportVideoFeeds size =" + jdField_c_of_type_JavaUtilHashMap.size() + ",traceid =" + str);
    }
    if (localVideoAdInfo.jdField_c_of_type_Boolean)
    {
      if (paramBoolean) {}
      for (i = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());; i = 0)
      {
        a(paramActivity, localVideoAdInfo, localAdvertisementInfo, 10, i, paramInt);
        break;
      }
    }
    if (paramBoolean) {}
    for (int i = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());; i = 0)
    {
      a(paramActivity, localVideoAdInfo, localAdvertisementInfo, 5, i, paramInt);
      break;
    }
    jdField_d_of_type_JavaUtilHashMap.clear();
  }
  
  public static void a(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!a()) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof swu));
        paramViewHolder = (swu)paramViewHolder;
      } while ((paramViewHolder.a == null) || (paramViewHolder.a.a == null) || (!paramViewHolder.a.a.jdField_c_of_type_Boolean) || (paramViewHolder.a.a.a == null) || (jdField_c_of_type_JavaUtilHashMap.containsKey(paramViewHolder.a.a.a.h)));
      str = paramViewHolder.a.a.a.h;
      paramViewHolder.a.a.a.jdField_c_of_type_Boolean = paramViewHolder.a.a.a(paramActivity);
    } while (jdField_c_of_type_JavaUtilHashMap.containsKey(str));
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportVideoFeeds add to collections , size=" + jdField_c_of_type_JavaUtilHashMap.size());
    }
    jdField_c_of_type_JavaUtilHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    jdField_d_of_type_JavaUtilHashMap.put(str, paramViewHolder.a.a.a);
  }
  
  private static void a(Activity paramActivity, VideoAdInfo paramVideoAdInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a()) {
      return;
    }
    ois.a(new ufy().a(paramActivity).a(25).b(paramInt1).a(paramAdvertisementInfo).a(paramVideoAdInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)).a());
  }
  
  private void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a()) {
      return;
    }
    ois.a(new ufy().a(paramActivity).a(25).b(paramInt1).a(paramAdvertisementInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)).a());
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (!a()) {}
    Long localLong;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString));
        localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      } while ((localLong == null) || (localLong.longValue() == 0L));
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "reportFeeds,channelID=" + this.jdField_a_of_type_Int + ",traceId" + paramString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
      paramString = (AdvertisementInfo)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    } while (paramString == null);
    long l1 = System.currentTimeMillis();
    long l2 = localLong.longValue();
    a(paramActivity, paramString, a(paramString), (int)(l1 - l2), 50);
  }
  
  public static void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!a()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof swu));
        paramViewHolder = (swu)paramViewHolder;
      } while ((paramViewHolder.a == null) || (paramViewHolder.a.a == null) || (!paramViewHolder.a.a.jdField_c_of_type_Boolean) || (paramViewHolder.a.a.a == null) || (!g.containsKey(paramViewHolder.a.a.a.h)));
      paramViewHolder = paramViewHolder.a.a.a.h;
      g.put(paramViewHolder, Long.valueOf(0L));
      f.remove(paramViewHolder);
    } while (!QLog.isColorLevel());
    QLog.d("ExposureSupplementUtil", 2, "removeVideoFeeds1px and remove , trace_id=" + paramViewHolder);
  }
  
  public static boolean a()
  {
    boolean bool = "1".equals(bmhv.a("readinjjoy_ad_supplement_config"));
    if ((QLog.isColorLevel()) && (!bool) && (!jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = true;
      QLog.d("ExposureSupplementUtil", 2, "supplement report is close!");
      return bool;
    }
    jdField_a_of_type_Boolean = false;
    return bool;
  }
  
  public static void b(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!a()) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof swu));
        paramViewHolder = (swu)paramViewHolder;
      } while ((paramViewHolder.a == null) || (paramViewHolder.a.a == null) || (!paramViewHolder.a.a.jdField_c_of_type_Boolean) || (paramViewHolder.a.a.a == null) || (g.containsKey(paramViewHolder.a.a.a.h)));
      str = paramViewHolder.a.a.a.h;
      paramViewHolder.a.a.a.jdField_c_of_type_Boolean = paramViewHolder.a.a.a(paramActivity);
    } while (g.containsKey(str));
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "recordVideoFeeds1px and add trace_id=" + str);
    }
    f.put(str, paramViewHolder.a.a.a);
    g.put(str, Long.valueOf(System.currentTimeMillis()));
    a(paramActivity, 1, paramViewHolder.a.a.a);
  }
  
  public static void c(Activity paramActivity)
  {
    if (!a()) {}
    label191:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "doOnVideoPause reportVideoFeeds size =" + jdField_c_of_type_JavaUtilHashMap.size());
      }
      Iterator localIterator = jdField_c_of_type_JavaUtilHashMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label191;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (Long)((Map.Entry)localObject1).getValue();
        if ((localObject1 != null) && (((Long)localObject1).longValue() != 0L))
        {
          jdField_c_of_type_JavaUtilHashMap.put(localObject2, Long.valueOf(0L));
          localObject2 = (VideoAdInfo)jdField_d_of_type_JavaUtilHashMap.get(localObject2);
          if (localObject2 == null) {
            break;
          }
          AdvertisementInfo localAdvertisementInfo = ois.a((VideoAdInfo)localObject2);
          if (((VideoAdInfo)localObject2).jdField_c_of_type_Boolean) {
            a(paramActivity, (VideoAdInfo)localObject2, localAdvertisementInfo, 10, (int)(System.currentTimeMillis() - ((Long)localObject1).longValue()), 50);
          } else {
            a(paramActivity, (VideoAdInfo)localObject2, localAdvertisementInfo, 5, (int)(System.currentTimeMillis() - ((Long)localObject1).longValue()), 50);
          }
        }
      }
    }
  }
  
  public static void d()
  {
    if (!a()) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ExposureSupplementUtil", 2, "doOnVideoResume reportVideoFeeds size =" + jdField_c_of_type_JavaUtilHashMap.size());
  }
  
  public static void e()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_d_of_type_JavaUtilHashMap.clear();
    f.clear();
    g.clear();
  }
  
  public void a()
  {
    if ((!a()) || (!this.jdField_c_of_type_Boolean)) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "doOnFeedsResume , channelID=" + this.jdField_a_of_type_Int + " , size = " + this.jdField_a_of_type_JavaUtilHashMap.size() + ",this = " + this);
      }
    } while (!this.jdField_e_of_type_Boolean);
    this.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "doOnFeedsResume , isDestroyFromFeeds channelID=" + this.jdField_a_of_type_Int + " , size = " + this.jdField_a_of_type_JavaUtilHashMap.size() + ",this = " + this);
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        if (str.equals(localEntry.getKey()))
        {
          localEntry.setValue(Long.valueOf(System.currentTimeMillis()));
          if (QLog.isColorLevel()) {
            QLog.d("ExposureSupplementUtil", 2, "doOnFeedsResume , reset traceid=" + (String)localEntry.getKey());
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(Activity paramActivity)
  {
    if (!a()) {
      break label6;
    }
    label6:
    while (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!this.jdField_c_of_type_JavaUtilHashSet.contains(((Map.Entry)localObject2).getKey())) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((Map.Entry)localObject2).getKey());
      }
    }
    int i = 0;
    label97:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
      {
        localObject2 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        if ((localObject2 != null) && (((Long)localObject2).longValue() != 0L)) {
          break label169;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label97;
      break label6;
      label169:
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Long.valueOf(0L));
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
      if (localAdvertisementInfo == null) {
        break;
      }
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)localObject2).longValue();
      int j = a(localAdvertisementInfo);
      this.jdField_b_of_type_JavaUtilHashSet.add(localObject1);
      a(paramActivity, localAdvertisementInfo, j, (int)(l1 - l2), 50);
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "reportFeedsWhenRemove traceId=" + (String)localObject1);
      }
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (!a())) {}
    String str;
    do
    {
      return;
      str = paramAdvertisementInfo.mAdTraceId;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        this.jdField_b_of_type_JavaUtilHashSet.remove(str);
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str, paramAdvertisementInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    } while (!QLog.isColorLevel());
    QLog.d("ExposureSupplementUtil", 2, "add traceId=" + str + " , channelID=" + this.jdField_a_of_type_Int);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    if (!a()) {}
    while (this.jdField_e_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportAnd1Px: traceid=" + paramAdvertisementInfo.mAdTraceId);
    }
    this.jdField_e_of_type_JavaUtilHashMap.put(paramAdvertisementInfo.mAdTraceId, paramAdvertisementInfo);
    a(paramActivity, paramAdvertisementInfo, a(paramAdvertisementInfo), 0, 1);
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, int paramInt1, int paramInt2, int paramInt3, AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    int i = 1;
    if (!a()) {}
    for (;;)
    {
      return;
      b(paramAdvertisementInfo);
      if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2)) {
        paramInt1 = i;
      }
      while (paramInt1 != 0)
      {
        a(paramAdvertisementInfo);
        return;
        paramReadInJoyXListView = paramReadInJoyXListView.getChildAt(paramInt3 - paramInt1);
        paramInt2 = paramReadInJoyXListView.getHeight();
        paramActivity = new Rect();
        paramReadInJoyXListView.getGlobalVisibleRect(paramActivity);
        paramInt1 = i;
        if (paramActivity.height() <= paramInt2 >> 1) {
          paramInt1 = 0;
        }
      }
    }
  }
  
  public void a(szd paramszd, Activity paramActivity)
  {
    if ((paramszd == null) || (paramActivity == null) || (this.jdField_c_of_type_Boolean)) {}
    ReadInJoyXListView localReadInJoyXListView;
    List localList;
    do
    {
      return;
      localReadInJoyXListView = (ReadInJoyXListView)paramszd.a();
      localList = paramszd.a();
      i = paramszd.a();
    } while ((localReadInJoyXListView == null) || (localList == null) || (!uks.a(i)));
    c();
    int k = localReadInJoyXListView.getHeaderViewsCount();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int m = localReadInJoyXListView.getLastVisiblePosition();
    int i = j;
    if (i <= m)
    {
      if ((i < k) || (i - k >= localList.size())) {}
      for (;;)
      {
        i += 1;
        break;
        paramszd = (BaseArticleInfo)localList.get(i - k);
        if (AdvertisementInfo.isAdvertisementInfo(paramszd)) {
          a(localReadInJoyXListView, j, m, i, (AdvertisementInfo)paramszd, paramActivity);
        }
      }
    }
    a(paramActivity);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "destroyDataFromFeeds , channelID=" + this.jdField_a_of_type_Int + ", size =" + this.jdField_a_of_type_JavaUtilHashMap.size() + ",this = " + this);
    }
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilHashSet.clear();
    this.jdField_e_of_type_JavaUtilHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!this.jdField_b_of_type_JavaUtilHashSet.contains(localEntry.getKey())) {
        this.jdField_a_of_type_JavaUtilHashSet.add(localEntry.getKey());
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!a()) || (this.jdField_b_of_type_Boolean)) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "doOnFeedsPause , channelID=" + this.jdField_a_of_type_Int + ", size =" + this.jdField_a_of_type_JavaUtilHashMap.size() + ",this = " + this);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        a(paramActivity, (String)((Map.Entry)localIterator.next()).getKey());
      }
    }
  }
  
  public void b(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_c_of_type_JavaUtilHashSet.add(paramAdvertisementInfo.mAdTraceId);
  }
  
  public void c()
  {
    if (!a()) {
      return;
    }
    this.jdField_c_of_type_JavaUtilHashSet.clear();
  }
  
  public void f()
  {
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukg
 * JD-Core Version:    0.7.0.1
 */