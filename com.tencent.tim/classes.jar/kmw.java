import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
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

public class kmw
{
  private static boolean ags;
  private static HashMap<String, Long> dr = new HashMap();
  private static HashMap<String, VideoAdInfo> ds = new HashMap();
  private static HashMap<String, VideoAdInfo> du = new HashMap();
  private static HashMap<String, Long> dv = new HashMap();
  private boolean Ij;
  private HashSet<String> J = new HashSet();
  private HashSet<String> K = new HashSet();
  private HashSet<String> L = new HashSet();
  private boolean agt = true;
  private boolean agu;
  private boolean agv;
  private int channelID;
  private HashMap<String, Long> jdField_do = new HashMap();
  private HashMap<String, AdvertisementInfo> dp = new HashMap();
  private HashMap<String, AdvertisementInfo> dt = new HashMap();
  private ArrayList<String> kh = new ArrayList();
  
  public kmw(int paramInt)
  {
    this.channelID = paramInt;
  }
  
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return jzk.aFx;
    }
    if (kxm.j(paramAdvertisementInfo)) {
      return jzk.aFB;
    }
    return jzk.aFw;
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
      localJSONObject1.put("statistics_data_report", knd.a(paramContext, paramAdvertisementInfo, localJSONObject2).toString());
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
    if (!isNeedReport()) {}
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
    c(paramActivity, 50, true);
    a(paramViewHolder);
  }
  
  private static void a(Activity paramActivity, int paramInt, VideoAdInfo paramVideoAdInfo)
  {
    if (!isNeedReport()) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = jzk.a(paramVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportVideoFeeds1px ,traceid =" + paramVideoAdInfo.We);
    }
    if (paramVideoAdInfo.adz)
    {
      a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, jzk.aFA, 0, paramInt);
      return;
    }
    a(paramActivity, paramVideoAdInfo, localAdvertisementInfo, jzk.aFy, 0, paramInt);
  }
  
  public static void a(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!isNeedReport()) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof mtg.l));
        paramViewHolder = (mtg.l)paramViewHolder;
      } while ((paramViewHolder.a == null) || (paramViewHolder.a.d == null) || (!paramViewHolder.a.d.isAD) || (paramViewHolder.a.d.b == null) || (dr.containsKey(paramViewHolder.a.d.b.We)));
      str = paramViewHolder.a.d.b.We;
      paramViewHolder.a.d.b.adz = paramViewHolder.a.d.j(paramActivity);
    } while (dr.containsKey(str));
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportVideoFeeds add to collections , size=" + dr.size());
    }
    dr.put(str, Long.valueOf(System.currentTimeMillis()));
    ds.put(str, paramViewHolder.a.d.b);
  }
  
  private static void a(Activity paramActivity, VideoAdInfo paramVideoAdInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!isNeedReport()) {
      return;
    }
    jzk.a(new kku.a().a(paramActivity).a(jzk.aFk).b(paramInt1).a(paramAdvertisementInfo).a(paramVideoAdInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)).a());
  }
  
  private void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!isNeedReport()) {
      return;
    }
    jzk.a(new kku.a().a(paramActivity).a(jzk.aFk).b(paramInt1).a(paramAdvertisementInfo).e(a(paramActivity, paramAdvertisementInfo, paramInt2, paramInt3)).a());
  }
  
  public static void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!isNeedReport()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof mtg.l));
        paramViewHolder = (mtg.l)paramViewHolder;
      } while ((paramViewHolder.a == null) || (paramViewHolder.a.d == null) || (!paramViewHolder.a.d.isAD) || (paramViewHolder.a.d.b == null) || (!dv.containsKey(paramViewHolder.a.d.b.We)));
      paramViewHolder = paramViewHolder.a.d.b.We;
      dv.put(paramViewHolder, Long.valueOf(0L));
      du.remove(paramViewHolder);
    } while (!QLog.isColorLevel());
    QLog.d("ExposureSupplementUtil", 2, "removeVideoFeeds1px and remove , trace_id=" + paramViewHolder);
  }
  
  public static void aE(Activity paramActivity)
  {
    if (!isNeedReport()) {}
    label194:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "doOnVideoPause reportVideoFeeds size =" + dr.size());
      }
      Iterator localIterator = dr.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label194;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (Long)((Map.Entry)localObject1).getValue();
        if ((localObject1 != null) && (((Long)localObject1).longValue() != 0L))
        {
          dr.put(localObject2, Long.valueOf(0L));
          localObject2 = (VideoAdInfo)ds.get(localObject2);
          if (localObject2 == null) {
            break;
          }
          AdvertisementInfo localAdvertisementInfo = jzk.a((VideoAdInfo)localObject2);
          if (((VideoAdInfo)localObject2).adz) {
            a(paramActivity, (VideoAdInfo)localObject2, localAdvertisementInfo, jzk.aFA, (int)(System.currentTimeMillis() - ((Long)localObject1).longValue()), 50);
          } else {
            a(paramActivity, (VideoAdInfo)localObject2, localAdvertisementInfo, jzk.aFy, (int)(System.currentTimeMillis() - ((Long)localObject1).longValue()), 50);
          }
        }
      }
    }
  }
  
  public static void aEH()
  {
    if (!isNeedReport()) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ExposureSupplementUtil", 2, "doOnVideoResume reportVideoFeeds size =" + dr.size());
  }
  
  public static void aEI()
  {
    dr.clear();
    ds.clear();
    du.clear();
    dv.clear();
  }
  
  public static void b(Activity paramActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    if (!isNeedReport()) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramViewHolder instanceof mtg.l));
        paramViewHolder = (mtg.l)paramViewHolder;
      } while ((paramViewHolder.a == null) || (paramViewHolder.a.d == null) || (!paramViewHolder.a.d.isAD) || (paramViewHolder.a.d.b == null) || (dv.containsKey(paramViewHolder.a.d.b.We)));
      str = paramViewHolder.a.d.b.We;
      paramViewHolder.a.d.b.adz = paramViewHolder.a.d.j(paramActivity);
    } while (dv.containsKey(str));
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "recordVideoFeeds1px and add trace_id=" + str);
    }
    du.put(str, paramViewHolder.a.d.b);
    dv.put(str, Long.valueOf(System.currentTimeMillis()));
    a(paramActivity, 1, paramViewHolder.a.d.b);
  }
  
  public static void c(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (!isNeedReport()) {}
    Object localObject;
    String str;
    VideoAdInfo localVideoAdInfo;
    do
    {
      return;
      Iterator localIterator = dr.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (Long)((Map.Entry)localObject).getValue();
      } while ((localObject == null) || (((Long)localObject).longValue() == 0L));
      dr.put(str, Long.valueOf(0L));
      localVideoAdInfo = (VideoAdInfo)ds.get(str);
    } while (localVideoAdInfo == null);
    AdvertisementInfo localAdvertisementInfo = jzk.a(localVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportVideoFeeds size =" + dr.size() + ",traceid =" + str);
    }
    if (localVideoAdInfo.adz)
    {
      j = jzk.aFA;
      if (paramBoolean) {}
      for (i = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());; i = 0)
      {
        a(paramActivity, localVideoAdInfo, localAdvertisementInfo, j, i, paramInt);
        break;
      }
    }
    int j = jzk.aFy;
    if (paramBoolean) {}
    for (int i = (int)(System.currentTimeMillis() - ((Long)localObject).longValue());; i = 0)
    {
      a(paramActivity, localVideoAdInfo, localAdvertisementInfo, j, i, paramInt);
      break;
    }
    ds.clear();
  }
  
  public static boolean isNeedReport()
  {
    boolean bool = "1".equals(awit.sn("readinjjoy_ad_supplement_config"));
    if ((QLog.isColorLevel()) && (!bool) && (!ags))
    {
      ags = true;
      QLog.d("ExposureSupplementUtil", 2, "supplement report is close!");
      return bool;
    }
    ags = false;
    return bool;
  }
  
  private void s(Activity paramActivity, String paramString)
  {
    if (!isNeedReport()) {}
    Long localLong;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_do.containsKey(paramString));
        localLong = (Long)this.jdField_do.get(paramString);
      } while ((localLong == null) || (localLong.longValue() == 0L));
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "reportFeeds,channelID=" + this.channelID + ",traceId" + paramString);
      }
      this.jdField_do.put(paramString, Long.valueOf(0L));
      paramString = (AdvertisementInfo)this.dp.get(paramString);
    } while (paramString == null);
    long l1 = System.currentTimeMillis();
    long l2 = localLong.longValue();
    a(paramActivity, paramString, a(paramString), (int)(l1 - l2), 50);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    if (!isNeedReport()) {}
    while (this.dt.containsKey(paramAdvertisementInfo.mAdTraceId)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "reportAnd1Px: traceid=" + paramAdvertisementInfo.mAdTraceId);
    }
    this.dt.put(paramAdvertisementInfo.mAdTraceId, paramAdvertisementInfo);
    a(paramActivity, paramAdvertisementInfo, a(paramAdvertisementInfo), 0, 1);
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, int paramInt1, int paramInt2, int paramInt3, AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    int i = 1;
    if (!isNeedReport()) {}
    for (;;)
    {
      return;
      d(paramAdvertisementInfo);
      if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2)) {
        paramInt1 = i;
      }
      while (paramInt1 != 0)
      {
        c(paramAdvertisementInfo);
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
  
  public void a(ndi paramndi, Activity paramActivity)
  {
    if ((paramndi == null) || (paramActivity == null) || (this.agt)) {}
    ReadInJoyXListView localReadInJoyXListView;
    List localList;
    do
    {
      return;
      localReadInJoyXListView = (ReadInJoyXListView)paramndi.b();
      localList = paramndi.getData();
      i = paramndi.nh();
    } while ((localReadInJoyXListView == null) || (localList == null) || (!knd.dh(i)));
    aEG();
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
        paramndi = (BaseArticleInfo)localList.get(i - k);
        if (AdvertisementInfo.isAdvertisementInfo(paramndi)) {
          a(localReadInJoyXListView, j, m, i, (AdvertisementInfo)paramndi, paramActivity);
        }
      }
    }
    aC(paramActivity);
  }
  
  public void aC(Activity paramActivity)
  {
    if (!isNeedReport()) {
      break label6;
    }
    label6:
    while (this.jdField_do.isEmpty()) {
      return;
    }
    this.kh.clear();
    Object localObject1 = this.jdField_do.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!this.L.contains(((Map.Entry)localObject2).getKey())) {
        this.kh.add(((Map.Entry)localObject2).getKey());
      }
    }
    int i = 0;
    label97:
    if (i < this.kh.size())
    {
      localObject1 = (String)this.kh.get(i);
      if (this.jdField_do.containsKey(localObject1))
      {
        localObject2 = (Long)this.jdField_do.get(localObject1);
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
      this.jdField_do.put(localObject1, Long.valueOf(0L));
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.dp.get(localObject1);
      if (localAdvertisementInfo == null) {
        break;
      }
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)localObject2).longValue();
      int j = a(localAdvertisementInfo);
      this.K.add(localObject1);
      a(paramActivity, localAdvertisementInfo, j, (int)(l1 - l2), 50);
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "reportFeedsWhenRemove traceId=" + (String)localObject1);
      }
    }
  }
  
  public void aD(Activity paramActivity)
  {
    if ((!isNeedReport()) || (this.Ij)) {}
    for (;;)
    {
      return;
      this.Ij = true;
      this.agt = true;
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "doOnFeedsPause , channelID=" + this.channelID + ", size =" + this.jdField_do.size() + ",this = " + this);
      }
      Iterator localIterator = this.jdField_do.entrySet().iterator();
      while (localIterator.hasNext()) {
        s(paramActivity, (String)((Map.Entry)localIterator.next()).getKey());
      }
    }
  }
  
  public void aEE()
  {
    if ((!isNeedReport()) || (!this.agt)) {}
    do
    {
      return;
      this.agt = false;
      this.Ij = false;
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "doOnFeedsResume , channelID=" + this.channelID + " , size = " + this.jdField_do.size() + ",this = " + this);
      }
    } while (!this.agv);
    this.agv = false;
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "doOnFeedsResume , isDestroyFromFeeds channelID=" + this.channelID + " , size = " + this.jdField_do.size() + ",this = " + this);
    }
    Iterator localIterator1 = this.J.iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = this.jdField_do.entrySet().iterator();
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
    this.J.clear();
  }
  
  public void aEF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "destroyDataFromFeeds , channelID=" + this.channelID + ", size =" + this.jdField_do.size() + ",this = " + this);
    }
    this.agv = true;
    this.kh.clear();
    this.L.clear();
    this.dt.clear();
    Iterator localIterator = this.jdField_do.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!this.K.contains(localEntry.getKey())) {
        this.J.add(localEntry.getKey());
      }
    }
    this.jdField_do.clear();
    this.K.clear();
  }
  
  public void aEG()
  {
    if (!isNeedReport()) {
      return;
    }
    this.L.clear();
  }
  
  public void aEJ()
  {
    this.agu = true;
  }
  
  public void c(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (!isNeedReport())) {}
    String str;
    do
    {
      return;
      str = paramAdvertisementInfo.mAdTraceId;
      if (this.jdField_do.containsKey(str))
      {
        this.K.remove(str);
        return;
      }
      this.dp.put(str, paramAdvertisementInfo);
      this.jdField_do.put(str, Long.valueOf(System.currentTimeMillis()));
    } while (!QLog.isColorLevel());
    QLog.d("ExposureSupplementUtil", 2, "add traceId=" + str + " , channelID=" + this.channelID);
  }
  
  public void d(AdvertisementInfo paramAdvertisementInfo)
  {
    this.L.add(paramAdvertisementInfo.mAdTraceId);
  }
  
  public static class a
  {
    public SparseArray<kmw> Z = new SparseArray();
    
    public a()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
      }
    }
    
    public kmw a(int paramInt)
    {
      return (kmw)this.Z.get(paramInt);
    }
    
    public void a(int paramInt, kmw paramkmw)
    {
      this.Z.put(paramInt, paramkmw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmw
 * JD-Core Version:    0.7.0.1
 */