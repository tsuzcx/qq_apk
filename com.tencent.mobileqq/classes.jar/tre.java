import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class tre
{
  private static SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray;
  private static CopyOnWriteArrayList<VideoInfo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new trf(this, Looper.getMainLooper());
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private rnu jdField_a_of_type_Rnu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 2;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public tre(rnu paramrnu, ArrayList<VideoInfo> paramArrayList)
  {
    this.jdField_a_of_type_Rnu = paramrnu;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public static int a()
  {
    if ((jdField_b_of_type_JavaUtilArrayList != null) && (jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      return ((Integer)jdField_b_of_type_JavaUtilArrayList.get(jdField_b_of_type_JavaUtilArrayList.size() - 1)).intValue();
    }
    return 0;
  }
  
  private int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Integer.valueOf(0));
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static ArrayList<VideoInfo> a(ArrayList<VideoInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramArrayList.next();
        if (localVideoInfo.jdField_c_of_type_Boolean) {
          localArrayList.add(localVideoInfo);
        }
      }
    }
    if (localArrayList.size() > 0) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(localArrayList);
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt != 88888888) {
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public static void a(int paramInt, ArrayList<AdvertisementInfo> paramArrayList)
  {
    if ((paramInt != 88888888) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.next();
      VideoInfo localVideoInfo = trb.a(localAdvertisementInfo, false);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localVideoInfo);
      localStringBuilder.append(localAdvertisementInfo.mTitle + "---");
    }
    tpx.a("VideoAdTimeLoadManager", "onAsyncDataReady :" + localStringBuilder.toString());
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      localStringBuilder = new StringBuilder().append("repeat startPlay, so return isMainThread : ");
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        tpx.a("VideoAdTimeLoadManager", paramBoolean);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startTiming :").append(this.jdField_a_of_type_Long).append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      tpx.a("VideoAdTimeLoadManager", paramBoolean);
      this.jdField_a_of_type_Long += 1L;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 1000L);
      int i = trd.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        i = trd.jdField_c_of_type_Int;
      }
      if (this.jdField_a_of_type_Long >= i - trd.d) {
        i();
      }
      if (this.jdField_a_of_type_Long < i) {
        break;
      }
      g();
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rnu == null) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt))
    {
      tpx.a("VideoAdTimeLoadManager", "Invalid parameter");
      return false;
    }
    if (((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_c_of_type_Boolean)
    {
      tpx.a("VideoAdTimeLoadManager", paramInt + " has adVideo");
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt)
  {
    if ((this.jdField_a_of_type_Rnu == null) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)) {
      tpx.a("VideoAdTimeLoadManager", "Invalid parameter");
    }
    do
    {
      return false;
      int i = a();
      if ((i > 0) && (paramInt - i < trd.e + 1))
      {
        tpx.a("VideoAdTimeLoadManager", "not meet adProtectGap");
        return false;
      }
      if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        tpx.a("VideoAdTimeLoadManager", "article size = " + this.jdField_a_of_type_JavaUtilArrayList.size() + " but  pos = " + paramInt);
        return false;
      }
    } while (a(paramInt));
    return true;
  }
  
  public static void h()
  {
    jdField_b_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  private void i()
  {
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0) {
      tpx.a("VideoAdTimeLoadManager", "adVideoCache size :" + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    while (a(this.jdField_a_of_type_Int + 1)) {
      return;
    }
    int i = a();
    int j = a(i);
    if (j >= 3)
    {
      tpx.a("VideoAdTimeLoadManager", "has preLoad 3 times");
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      tpx.a("VideoAdTimeLoadManager", "preLoadAd :" + this.jdField_a_of_type_Long);
      nyp localnyp = new nyp();
      localnyp.h = 1;
      localnyp.i = this.jdField_b_of_type_Int;
      localnyp.j = i;
      ThreadManager.executeOnSubThread(new VideoAdTimeLoadManager.2(this, localnyp));
      jdField_a_of_type_AndroidUtilSparseArray.put(i, Integer.valueOf(j + 1));
      return;
    }
    tpx.a("VideoAdTimeLoadManager", "preLoading : so return");
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VideoInfo a()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)) {
      return (VideoInfo)jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(0);
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      i();
    }
    return null;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.jdField_b_of_type_Int > paramVideoInfo.jdField_c_of_type_Int) {}
      for (this.jdField_b_of_type_Int = 1;; this.jdField_b_of_type_Int = 2)
      {
        QLog.d("VideoAdTimeLoadManager", 1, "setSceneId : sceneId = " + this.jdField_b_of_type_Int + " , videoInfo = " + paramVideoInfo.jdField_c_of_type_JavaLangString);
        return;
      }
    }
    QLog.d("VideoAdTimeLoadManager", 1, "setSceneId : videoInfo is null");
  }
  
  public void b()
  {
    if (trd.b()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    StringBuilder localStringBuilder = new StringBuilder().append("pauseTiming :").append(this.jdField_a_of_type_Long).append(" isMainThread : ");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      tpx.a("VideoAdTimeLoadManager", bool);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    tpx.a("VideoAdTimeLoadManager", "lastPlayPosition = " + this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      a(true);
    }
  }
  
  public void c(int paramInt)
  {
    jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    f();
  }
  
  public void f()
  {
    if (trd.b()) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    tpx.a("VideoAdTimeLoadManager", "restoreTiming :" + this.jdField_a_of_type_Long);
  }
  
  public void g()
  {
    tpx.a("VideoAdTimeLoadManager", "onInsertAd :");
    int i = this.jdField_a_of_type_Int + 1;
    if (!b(i)) {
      return;
    }
    VideoInfo localVideoInfo = a();
    if (localVideoInfo == null)
    {
      tpx.a("VideoAdTimeLoadManager", "empty cache");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoAdTimeLoadManager.3(this, i, localVideoInfo));
    localVideoInfo.a.jdField_a_of_type_Int = i;
    int j = a();
    if (j == 0) {}
    for (localVideoInfo.a.jdField_b_of_type_Int = 0;; localVideoInfo.a.jdField_b_of_type_Int = (i - j))
    {
      localVideoInfo.a.jdField_c_of_type_Int = trd.jdField_c_of_type_Int;
      c(i);
      tpx.a("VideoAdTimeLoadManager", "insert success: pos = " + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tre
 * JD-Core Version:    0.7.0.1
 */