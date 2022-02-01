import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ukv
{
  public static int a;
  public static long a;
  public static String a;
  private static ArrayBlockingQueue<AdvertisementInfo> a;
  public static boolean a;
  public static int b;
  public static long b;
  private static ArrayBlockingQueue<AdvertisementInfo> b;
  public static boolean b;
  public static boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ReadInJoyPatchAdUtils";
    jdField_b_of_type_Int = 3;
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
    jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
  }
  
  public static int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("patchAdDisplaySeconds");
  }
  
  public static AdvertisementInfo a(int paramInt)
  {
    ArrayBlockingQueue localArrayBlockingQueue2;
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (paramInt == 1)
    {
      localArrayBlockingQueue2 = jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        a(1);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
    }
    while (localArrayBlockingQueue1.size() <= 0)
    {
      return null;
      localArrayBlockingQueue2 = jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        a(2);
        localArrayBlockingQueue1 = localArrayBlockingQueue2;
      }
    }
    return (AdvertisementInfo)localArrayBlockingQueue1.poll();
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.clear();
    jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue.clear();
  }
  
  public static void a(int paramInt)
  {
    oha localoha = new oha();
    localoha.d = 1;
    if (paramInt == 1)
    {
      localoha.e = 3;
      localoha.f = 0;
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localoha));
      return;
      localoha.f = 3;
      localoha.e = 0;
    }
  }
  
  public static void a(Activity paramActivity, sqd paramsqd, spg paramspg, spa paramspa, sqj paramsqj, ukx paramukx)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = paramsqd.a();
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new ukw(localReadInJoyPatchAdView, paramActivity, paramsqd, paramspg, paramsqj, paramspa, paramukx));
  }
  
  public static void a(spk paramspk, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramspk.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
      return;
    }
    paramspk.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(spk paramspk, sqd paramsqd, boolean paramBoolean, ukx paramukx)
  {
    int j = 0;
    sqd localsqd = null;
    if (!b(paramspk, paramsqd)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        if (paramBoolean)
        {
          paramsqd = paramsqd.a().a;
          localsqd = paramsqd;
          if (paramsqd != null) {
            break label71;
          }
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (paramukx != null)) {
          paramukx.a(paramspk, paramsqd);
        }
        return;
        paramsqd = a(1);
        break;
        label71:
        paramsqd = localsqd;
      }
    }
  }
  
  public static void a(spk paramspk, sqd paramsqd, boolean paramBoolean1, boolean paramBoolean2, sqj paramsqj, spa paramspa, ukx paramukx)
  {
    int j = 1;
    Object localObject = null;
    if (!a(paramspk, paramsqd)) {
      j = 0;
    }
    int i = j;
    if (paramBoolean1)
    {
      i = j;
      if (c) {
        i = 0;
      }
    }
    j = i;
    AdvertisementInfo localAdvertisementInfo;
    if (i != 0)
    {
      if (!paramBoolean2) {
        break label116;
      }
      localAdvertisementInfo = paramsqd.a().a;
      if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mAdExtInfo != null))
      {
        localObject = localAdvertisementInfo;
        j = i;
        if (a(localAdvertisementInfo.mAdExtInfo, 2)) {}
      }
      else
      {
        j = 0;
        localObject = localAdvertisementInfo;
      }
    }
    if (j != 0) {
      paramukx.b(paramspk, localObject);
    }
    label116:
    while (paramsqj == null)
    {
      return;
      localAdvertisementInfo = a(2);
      break;
    }
    paramsqj.a(paramsqd.a());
    paramspa.c();
  }
  
  public static void a(sqd paramsqd)
  {
    if (paramsqd.a() != null)
    {
      paramsqd.a().setVisibility(8);
      paramsqd.a().a();
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        if (localJSONObject.has("patchAdType"))
        {
          if (localJSONObject.optInt("patchAdType") == 1)
          {
            jdField_a_of_type_Boolean = true;
            jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(paramAdvertisementInfo);
            if (localJSONObject.optInt("postPatchAdNoFirst") == 1)
            {
              bool = true;
              c = bool;
              jdField_a_of_type_Int = localJSONObject.optInt("patchAdLimitMinutes");
              jdField_b_of_type_Int = localJSONObject.optInt("patchAdDisplaySeconds");
              return true;
            }
          }
          else
          {
            if (localJSONObject.optInt("patchAdType") != 2) {
              continue;
            }
            jdField_b_of_type_Boolean = true;
            jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(paramAdvertisementInfo);
            continue;
          }
        }
        else {
          return false;
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      boolean bool = false;
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        do
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        } while (paramString.optInt("patchAdType") != paramInt);
        paramInt = paramString.optInt("patchAdLimitMinutes");
      } while (SystemClock.elapsedRealtime() - jdField_b_of_type_Long < paramInt * 60000);
    }
    return true;
  }
  
  public static boolean a(spk paramspk)
  {
    if ((paramspk == null) || (paramspk.a == null)) {}
    while (paramspk.jdField_b_of_type_Long != 56L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(spk paramspk, sqd paramsqd)
  {
    int i = paramspk.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramspk, paramsqd);
  }
  
  public static boolean a(sqd paramsqd)
  {
    if ((paramsqd == null) || (paramsqd.a() == null)) {}
    while ((paramsqd.a() == null) || (paramsqd.a().getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    jdField_a_of_type_Long = jdField_b_of_type_Long;
    jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(spk paramspk, sqd paramsqd)
  {
    int i = paramspk.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramspk, paramsqd);
  }
  
  public static void c()
  {
    jdField_b_of_type_Long = jdField_a_of_type_Long;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)) {
      return false;
    }
    return true;
  }
  
  private static boolean c(spk paramspk, sqd paramsqd)
  {
    if (paramspk.jdField_b_of_type_Int <= 30) {}
    while ((paramspk.a.mChannelID != 56L) || (paramspk.jdField_b_of_type_Boolean) || ((paramsqd != null) && (paramsqd.a()))) {
      return false;
    }
    return true;
  }
  
  public static void d()
  {
    Object localObject = jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
    ArrayBlockingQueue localArrayBlockingQueue = jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue;
    if ((((ArrayBlockingQueue)localObject).size() <= 2) || (localArrayBlockingQueue.size() <= 2))
    {
      localObject = new oha();
      ((oha)localObject).d = 1;
      ((oha)localObject).e = 3;
      ((oha)localObject).f = 3;
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.1((oha)localObject));
    }
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramBaseArticleInfo.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukv
 * JD-Core Version:    0.7.0.1
 */