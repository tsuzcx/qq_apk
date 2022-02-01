import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoySocialSmallAdUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class kni
{
  public static GdtHandler.Params a;
  public static AtomicBoolean an = new AtomicBoolean(false);
  private static ArrayBlockingQueue<AdvertisementInfo> c = new ArrayBlockingQueue(10);
  public static ArrayList<kni.a> ki = new ArrayList();
  public static long sr = -2147483648L;
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mChannelID != 0L)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramTemplateBean == null) || (TextUtils.isEmpty(paramTemplateBean.getStyleName())) || ((!paramTemplateBean.getStyleName().equals("ReadInjoy_biu_cell")) && (!paramTemplateBean.getStyleName().equals("ReadInjoy_biu_small_pgc_cell"))) || (di(paramInt)));
        paramTemplateBean = paramTemplateBean.getViewDataBinding();
      } while (paramTemplateBean == null);
      paramTemplateBean.remove("id_ad_biu_small_image_ugc");
      paramTemplateBean.remove("id_ad_biu_small_image_pgc");
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (paramBaseArticleInfo == null);
    paramBaseArticleInfo.amL = true;
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (paramBaseArticleInfo == null) || (paramBaseArticleInfo.mChannelID != 0L)) {}
    do
    {
      return;
      if (c.size() < 1)
      {
        aEP();
        return;
      }
    } while ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.amL) || (paramJSONObject.has("id_ad_biu_small_image_ugc")) || (paramJSONObject.has("id_ad_biu_small_image_pgc")));
    AdvertisementInfo localAdvertisementInfo1 = null;
    if (paramBaseArticleInfo.mSocialFeedInfo != null) {
      localAdvertisementInfo1 = paramBaseArticleInfo.mSocialFeedInfo.g;
    }
    AdvertisementInfo localAdvertisementInfo2;
    if (paramInt == 1)
    {
      localAdvertisementInfo2 = localAdvertisementInfo1;
      if (localAdvertisementInfo1 != null) {}
    }
    for (;;)
    {
      try
      {
        localAdvertisementInfo2 = b();
        llu.b(localAdvertisementInfo2, paramJSONObject);
        if (localAdvertisementInfo2 == null) {
          break;
        }
        paramBaseArticleInfo.mSocialFeedInfo.g = localAdvertisementInfo2;
        return;
      }
      catch (Exception paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return;
      }
      localAdvertisementInfo2 = localAdvertisementInfo1;
      if (paramInt == 2)
      {
        localAdvertisementInfo2 = localAdvertisementInfo1;
        if (localAdvertisementInfo1 == null) {
          localAdvertisementInfo2 = b();
        }
        llu.a(localAdvertisementInfo2, paramJSONObject);
      }
    }
  }
  
  public static void a(lie paramlie, ViewBase paramViewBase, Container paramContainer, int paramInt)
  {
    if ((paramlie != null) && (paramlie.a() != null) && (paramlie.a().mSocialFeedInfo != null) && (paramlie.a().mSocialFeedInfo.g != null))
    {
      paramViewBase = paramViewBase.findViewBaseByName("id_view_AdDownloadView");
      if ((paramViewBase instanceof koh))
      {
        koh localkoh = (koh)paramViewBase;
        localkoh.pq(paramInt);
        localkoh.setModel(new lis(paramContainer.getContext(), paramlie.a().mSocialFeedInfo.g, paramlie.getCellType(), paramlie.nh(), paramlie.ni(), paramlie.getPosition(), false, paramlie.getTotal(), paramlie.b(), paramlie.b()), true);
        ((koh)paramViewBase).aFj();
      }
    }
  }
  
  public static boolean a(Activity paramActivity, int paramInt, BaseArticleInfo paramBaseArticleInfo, ndi paramndi, lie paramlie, aqdf paramaqdf, Container paramContainer, ViewBase paramViewBase)
  {
    boolean bool = false;
    if (paramInt == 1178) {
      bool = true;
    }
    int i = 1000;
    if (paramInt == 1179)
    {
      bool = true;
      i = 4;
    }
    if (paramInt == 1180)
    {
      bool = true;
      i = 1;
    }
    if (paramInt == 1181)
    {
      bool = true;
      i = 3;
    }
    if (paramInt == 1182)
    {
      bool = true;
      i = 1;
    }
    if (paramInt == 1085)
    {
      bool = true;
      i = 5;
    }
    if (paramInt == 1086)
    {
      bool = true;
      i = 4;
    }
    if (paramInt == 1183)
    {
      bool = true;
      i = 8;
    }
    for (;;)
    {
      if (bool)
      {
        if (paramInt != 1182) {
          break label188;
        }
        if ((paramlie == null) || (paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.g == null)) {
          return true;
        }
        paramActivity = new lyy(paramActivity, paramaqdf, paramndi);
        paramActivity.a(paramlie);
        paramActivity.a(paramContainer);
        paramActivity.cE(paramViewBase.getNativeView());
      }
      for (;;)
      {
        return bool;
        label188:
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.g != null))
        {
          paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.g;
          paramBaseArticleInfo.mChannelID = 0L;
          paramBaseArticleInfo.setClickPos(i);
          a = ods.a(paramActivity, paramBaseArticleInfo, paramndi, 0, true, null);
          sr = SystemClock.elapsedRealtime();
          paramBaseArticleInfo.setClickPos(i);
          ods.a(paramActivity, paramBaseArticleInfo, paramndi, 0, true, null);
        }
      }
    }
  }
  
  private static boolean a(kni.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 - paramInt1 > parama.aKh) && (paramInt3 - paramInt2 > parama.aKi);
  }
  
  public static boolean a(lie paramlie)
  {
    if (paramlie == null) {
      return false;
    }
    return g(paramlie.a());
  }
  
  public static void aEL()
  {
    an.compareAndSet(true, false);
    c.clear();
    ki.clear();
  }
  
  public static void aEP()
  {
    an.compareAndSet(false, true);
    jys localjys = new jys();
    localjys.aEC = 1;
    ThreadManager.executeOnSubThread(new ReadInJoySocialSmallAdUtils.1(localjys));
  }
  
  public static AdvertisementInfo b()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)c.poll();
    if (c.size() < 1) {
      aEP();
    }
    return localAdvertisementInfo;
  }
  
  private static boolean di(int paramInt)
  {
    AdvertisementInfo localAdvertisementInfo = lbz.a().c(0, paramInt);
    if (localAdvertisementInfo == null) {
      return true;
    }
    return h(localAdvertisementInfo.mAdKdPos, paramInt, localAdvertisementInfo.getNextAdPosition());
  }
  
  public static void g(AdvertisementInfo paramAdvertisementInfo)
  {
    c.offer(paramAdvertisementInfo);
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.g != null);
  }
  
  private static boolean h(int paramInt1, int paramInt2, int paramInt3)
  {
    if (ki.size() == 0)
    {
      if ((paramInt2 - paramInt1 > 1) && (paramInt3 - paramInt2 > 1)) {
        return true;
      }
      localObject = new kni.a();
      ((kni.a)localObject).aKi = 1;
      ((kni.a)localObject).aKh = 1;
      return a((kni.a)localObject, paramInt1, paramInt2, paramInt3);
    }
    Object localObject = ki.iterator();
    for (boolean bool = true; ((Iterator)localObject).hasNext(); bool = a((kni.a)((Iterator)localObject).next(), paramInt1, paramInt2, paramInt3) & bool) {}
    return bool;
  }
  
  public static void onResume()
  {
    ods.a(0, a, sr);
    a = null;
    sr = -2147483648L;
  }
  
  public static boolean u(AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      if (((JSONObject)localObject).optInt("social_card_flag") == 1)
      {
        g(paramAdvertisementInfo);
        paramAdvertisementInfo = ((JSONObject)localObject).optJSONArray("social_card_ad_strategy");
        if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.length() > 0))
        {
          ki.clear();
          int i = 0;
          while (i < paramAdvertisementInfo.length())
          {
            localObject = paramAdvertisementInfo.get(i);
            if ((localObject instanceof JSONObject))
            {
              int j = ((JSONObject)localObject).optInt("A");
              int k = ((JSONObject)localObject).optInt("B");
              localObject = new kni.a();
              ((kni.a)localObject).aKh = j;
              ((kni.a)localObject).aKi = k;
              ki.add(localObject);
            }
            i += 1;
          }
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return true;
  }
  
  public static boolean v(AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      int i = new JSONObject(paramAdvertisementInfo.mAdExtInfo).optInt("social_card_flag");
      return i == 1;
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return false;
  }
  
  public static class a
  {
    public int aKh;
    public int aKi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kni
 * JD-Core Version:    0.7.0.1
 */