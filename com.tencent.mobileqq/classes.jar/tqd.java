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

public class tqd
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
      if (localArrayBlockingQueue1 != null) {
        break label54;
      }
    }
    label54:
    while (localArrayBlockingQueue1.size() <= 0)
    {
      return null;
      localArrayBlockingQueue2 = jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() > 2) {
        break;
      }
      a(2);
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      break;
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
    nyp localnyp = new nyp();
    localnyp.d = 1;
    if (paramInt == 1)
    {
      localnyp.e = 3;
      localnyp.f = 0;
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localnyp));
      return;
      localnyp.f = 3;
      localnyp.e = 0;
    }
  }
  
  public static void a(Activity paramActivity, rwu paramrwu, rvy paramrvy, rvs paramrvs, rxa paramrxa, tqf paramtqf)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = paramrwu.a();
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new tqe(localReadInJoyPatchAdView, paramActivity, paramrwu, paramrvy, paramrxa, paramrvs, paramtqf));
  }
  
  public static void a(rwc paramrwc, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramrwc.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
      return;
    }
    paramrwc.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(rwc paramrwc, rwu paramrwu, boolean paramBoolean, tqf paramtqf)
  {
    int j = 0;
    rwu localrwu = null;
    if (!b(paramrwc, paramrwu)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        if (paramBoolean)
        {
          paramrwu = paramrwu.a().a;
          localrwu = paramrwu;
          if (paramrwu != null) {
            break label71;
          }
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (paramtqf != null)) {
          paramtqf.a(paramrwc, paramrwu);
        }
        return;
        paramrwu = a(1);
        break;
        label71:
        paramrwu = localrwu;
      }
    }
  }
  
  public static void a(rwc paramrwc, rwu paramrwu, boolean paramBoolean1, boolean paramBoolean2, rxa paramrxa, rvs paramrvs, tqf paramtqf)
  {
    int j = 1;
    Object localObject = null;
    if (!a(paramrwc, paramrwu)) {
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
      localAdvertisementInfo = paramrwu.a().a;
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
      paramtqf.b(paramrwc, localObject);
    }
    label116:
    while (paramrxa == null)
    {
      return;
      localAdvertisementInfo = a(2);
      break;
    }
    paramrxa.a(paramrwu.a());
    paramrvs.c();
  }
  
  public static void a(rwu paramrwu)
  {
    if (paramrwu.a() != null)
    {
      paramrwu.a().setVisibility(8);
      paramrwu.a().a();
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
  
  public static boolean a(rwc paramrwc)
  {
    if ((paramrwc == null) || (paramrwc.a == null)) {}
    while (paramrwc.jdField_b_of_type_Long != 56L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(rwc paramrwc, rwu paramrwu)
  {
    int i = paramrwc.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramrwc, paramrwu);
  }
  
  public static boolean a(rwu paramrwu)
  {
    if ((paramrwu == null) || (paramrwu.a() == null)) {}
    while ((paramrwu.a() == null) || (paramrwu.a().getVisibility() != 0)) {
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
  
  public static boolean b(rwc paramrwc, rwu paramrwu)
  {
    int i = paramrwc.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramrwc, paramrwu);
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
  
  private static boolean c(rwc paramrwc, rwu paramrwu)
  {
    if (paramrwc.jdField_b_of_type_Int <= 30) {}
    while ((paramrwc.a.mChannelID != 56L) || (paramrwc.jdField_b_of_type_Boolean) || ((paramrwu != null) && (paramrwu.a()))) {
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
      localObject = new nyp();
      ((nyp)localObject).d = 1;
      ((nyp)localObject).e = 3;
      ((nyp)localObject).f = 3;
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.1((nyp)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqd
 * JD-Core Version:    0.7.0.1
 */