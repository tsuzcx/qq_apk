import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyPatchAdUtils.1;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyPatchAdUtils.2;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class kng
{
  public static String TAG = "ReadInJoyPatchAdUtils";
  private static ArrayBlockingQueue<AdvertisementInfo> a = new ArrayBlockingQueue(10);
  public static int aKf;
  public static int aKg = 3;
  public static boolean agw;
  public static boolean agx;
  public static boolean agy;
  private static ArrayBlockingQueue<AdvertisementInfo> b = new ArrayBlockingQueue(10);
  public static long sy;
  public static long sz;
  
  public static AdvertisementInfo a(int paramInt)
  {
    ArrayBlockingQueue localArrayBlockingQueue2;
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (paramInt == 1)
    {
      localArrayBlockingQueue2 = a;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() <= 2)
      {
        pk(1);
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
      localArrayBlockingQueue2 = b;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() > 2) {
        break;
      }
      pk(2);
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      break;
    }
    return (AdvertisementInfo)localArrayBlockingQueue1.poll();
  }
  
  public static void a(Activity paramActivity, mza parammza, mye parammye, myc parammyc, mza.a parama, kng.a parama1)
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = parammza.a();
    if (localReadInJoyPatchAdView == null) {
      return;
    }
    localReadInJoyPatchAdView.setOnPatchAdListener(new knh(localReadInJoyPatchAdView, paramActivity, parammza, parammye, parama, parammyc, parama1));
  }
  
  public static void a(mye.b paramb, mza parammza, boolean paramBoolean, kng.a parama)
  {
    int j = 0;
    mza localmza = null;
    if (!b(paramb, parammza)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        if (paramBoolean)
        {
          parammza = parammza.a().advertisementInfo;
          localmza = parammza;
          if (parammza != null) {
            break label71;
          }
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (parama != null)) {
          parama.a(paramb, parammza);
        }
        return;
        parammza = a(1);
        break;
        label71:
        parammza = localmza;
      }
    }
  }
  
  public static void a(mye.b paramb, mza parammza, boolean paramBoolean1, boolean paramBoolean2, mza.a parama, myc parammyc, kng.a parama1)
  {
    int j = 1;
    Object localObject = null;
    if (!a(paramb, parammza)) {
      j = 0;
    }
    int i = j;
    if (paramBoolean1)
    {
      i = j;
      if (agy) {
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
      localAdvertisementInfo = parammza.a().advertisementInfo;
      if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mAdExtInfo != null))
      {
        localObject = localAdvertisementInfo;
        j = i;
        if (k(localAdvertisementInfo.mAdExtInfo, 2)) {}
      }
      else
      {
        j = 0;
        localObject = localAdvertisementInfo;
      }
    }
    if (j != 0) {
      parama1.b(paramb, localObject);
    }
    label116:
    while (parama == null)
    {
      return;
      localAdvertisementInfo = a(2);
      break;
    }
    parama.a(parammza.d());
    parammyc.aTG();
  }
  
  public static void a(mza parammza)
  {
    if (parammza.a() != null)
    {
      parammza.a().setVisibility(8);
      parammza.a().finish();
    }
  }
  
  public static boolean a(mye.b paramb)
  {
    if ((paramb == null) || (paramb.d == null)) {}
    while (paramb.channelId != 56L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(mye.b paramb, mza parammza)
  {
    int i = paramb.d.patchStatus.V.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramb, parammza);
  }
  
  public static boolean a(mza parammza)
  {
    if ((parammza == null) || (parammza.a() == null)) {}
    while ((parammza.a() == null) || (parammza.a().getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public static void aEL()
  {
    a.clear();
    b.clear();
  }
  
  public static void aEM()
  {
    sy = sz;
    sz = SystemClock.elapsedRealtime();
  }
  
  public static void aEN()
  {
    sz = sy;
  }
  
  public static void aEO()
  {
    Object localObject = b;
    ArrayBlockingQueue localArrayBlockingQueue = a;
    if ((((ArrayBlockingQueue)localObject).size() <= 2) || (localArrayBlockingQueue.size() <= 2))
    {
      localObject = new jys();
      ((jys)localObject).aEz = 1;
      ((jys)localObject).aEA = 3;
      ((jys)localObject).aEB = 3;
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.1((jys)localObject));
    }
  }
  
  public static void b(mye.b paramb, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramb.d.patchStatus.U.set(paramInt2);
      return;
    }
    paramb.d.patchStatus.V.set(paramInt2);
  }
  
  public static boolean b(mye.b paramb, mza parammza)
  {
    int i = paramb.d.patchStatus.U.get();
    if ((i != 0) && (i != 2)) {
      return false;
    }
    return c(paramb, parammza);
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.ar.get()) || (paramBaseArticleInfo.patchStatus.U.get() != 3) || (paramBaseArticleInfo.patchStatus.V.get() != 0)) {
      return false;
    }
    return true;
  }
  
  private static boolean c(mye.b paramb, mza parammza)
  {
    if (paramb.videoDuration <= 30) {}
    while ((paramb.d.mChannelID != 56L) || (paramb.aqp) || ((parammza != null) && (parammza.EV()))) {
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.patchStatus.as.get()) || (paramBaseArticleInfo.patchStatus.V.get() != 3)) {
      return false;
    }
    return true;
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.ar.get()) || (paramBaseArticleInfo.patchStatus.U.get() != 2) || (paramBaseArticleInfo.patchStatus.V.get() != 0)) {
      return false;
    }
    return true;
  }
  
  public static int f(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("patchAdDisplaySeconds");
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.patchStatus.as.get()) || (paramBaseArticleInfo.patchStatus.V.get() != 2)) {
      return false;
    }
    return true;
  }
  
  public static boolean k(String paramString, int paramInt)
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
      } while (SystemClock.elapsedRealtime() - sz < paramInt * 60000);
    }
    return true;
  }
  
  public static void pk(int paramInt)
  {
    jys localjys = new jys();
    localjys.aEz = 1;
    if (paramInt == 1)
    {
      localjys.aEA = 3;
      localjys.aEB = 0;
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyPatchAdUtils.2(localjys));
      return;
      localjys.aEB = 3;
      localjys.aEA = 0;
    }
  }
  
  public static boolean t(AdvertisementInfo paramAdvertisementInfo)
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
            agw = true;
            a.offer(paramAdvertisementInfo);
            if (localJSONObject.optInt("postPatchAdNoFirst") == 1)
            {
              bool = true;
              agy = bool;
              aKf = localJSONObject.optInt("patchAdLimitMinutes");
              aKg = localJSONObject.optInt("patchAdDisplaySeconds");
              return true;
            }
          }
          else
          {
            if (localJSONObject.optInt("patchAdType") != 2) {
              continue;
            }
            agx = true;
            b.offer(paramAdvertisementInfo);
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
  
  public static abstract interface a
  {
    public abstract void a(mye.b paramb, AdvertisementInfo paramAdvertisementInfo);
    
    public abstract void b(mye.b paramb, AdvertisementInfo paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kng
 * JD-Core Version:    0.7.0.1
 */