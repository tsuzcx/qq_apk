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

public class twu
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
    oaa localoaa = new oaa();
    localoaa.d = 1;
    if (paramInt == 1)
    {
      localoaa.e = 3;
      localoaa.f = 0;
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localoaa));
      return;
      localoaa.f = 3;
      localoaa.e = 0;
    }
  }
  
  public static void a(Activity paramActivity, sdy paramsdy, sdc paramsdc, scw paramscw, see paramsee, tww paramtww)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = paramsdy.a();
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new twv(localReadInJoyPatchAdView, paramActivity, paramsdy, paramsdc, paramsee, paramscw, paramtww));
  }
  
  public static void a(sdg paramsdg, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramsdg.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
      return;
    }
    paramsdg.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(sdg paramsdg, sdy paramsdy, boolean paramBoolean, tww paramtww)
  {
    int j = 0;
    sdy localsdy = null;
    if (!b(paramsdg, paramsdy)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        if (paramBoolean)
        {
          paramsdy = paramsdy.a().a;
          localsdy = paramsdy;
          if (paramsdy != null) {
            break label71;
          }
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (paramtww != null)) {
          paramtww.a(paramsdg, paramsdy);
        }
        return;
        paramsdy = a(1);
        break;
        label71:
        paramsdy = localsdy;
      }
    }
  }
  
  public static void a(sdg paramsdg, sdy paramsdy, boolean paramBoolean1, boolean paramBoolean2, see paramsee, scw paramscw, tww paramtww)
  {
    int j = 1;
    Object localObject = null;
    if (!a(paramsdg, paramsdy)) {
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
      localAdvertisementInfo = paramsdy.a().a;
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
      paramtww.b(paramsdg, localObject);
    }
    label116:
    while (paramsee == null)
    {
      return;
      localAdvertisementInfo = a(2);
      break;
    }
    paramsee.a(paramsdy.a());
    paramscw.c();
  }
  
  public static void a(sdy paramsdy)
  {
    if (paramsdy.a() != null)
    {
      paramsdy.a().setVisibility(8);
      paramsdy.a().a();
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
  
  public static boolean a(sdg paramsdg)
  {
    if ((paramsdg == null) || (paramsdg.a == null)) {}
    while (paramsdg.jdField_b_of_type_Long != 56L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(sdg paramsdg, sdy paramsdy)
  {
    int i = paramsdg.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramsdg, paramsdy);
  }
  
  public static boolean a(sdy paramsdy)
  {
    if ((paramsdy == null) || (paramsdy.a() == null)) {}
    while ((paramsdy.a() == null) || (paramsdy.a().getVisibility() != 0)) {
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
  
  public static boolean b(sdg paramsdg, sdy paramsdy)
  {
    int i = paramsdg.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramsdg, paramsdy);
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
  
  private static boolean c(sdg paramsdg, sdy paramsdy)
  {
    if (paramsdg.jdField_b_of_type_Int <= 30) {}
    while ((paramsdg.a.mChannelID != 56L) || (paramsdg.jdField_b_of_type_Boolean) || ((paramsdy != null) && (paramsdy.a()))) {
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
      localObject = new oaa();
      ((oaa)localObject).d = 1;
      ((oaa)localObject).e = 3;
      ((oaa)localObject).f = 3;
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.1((oaa)localObject));
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
 * Qualified Name:     twu
 * JD-Core Version:    0.7.0.1
 */