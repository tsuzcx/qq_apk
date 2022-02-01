import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.ad.manager.ReadInjoyADExposureManager.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class klu
  implements Manager
{
  public static HashSet<String> H;
  public static HashSet<String> I = new HashSet();
  public static ConcurrentHashMap<String, AdvertisementInfo> aU;
  public static HashMap<String, Long> dk = new HashMap();
  public static HashMap<String, Long> dl;
  private QQAppInterface app;
  private int mScrollState = -1;
  
  static
  {
    H = new HashSet();
    aU = new ConcurrentHashMap();
    dl = new HashMap();
  }
  
  public klu(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    aEi();
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, ndi paramndi)
  {
    if ((paramndi == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if (!I.contains(paramAdvertisementInfo.mAdTraceId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : has already checked!, traceId=" + paramAdvertisementInfo.mAdTraceId);
    return;
    Object localObject = (ReadInJoyXListView)paramndi.b();
    boolean bool;
    if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2)) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible=" + bool + ", traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      if (!bool) {
        break;
      }
      if (!dl.containsKey(paramAdvertisementInfo.mAdTraceId))
      {
        dl.put(paramAdvertisementInfo.mAdTraceId, Long.valueOf(paramndi.xn));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible startTime");
        return;
        localObject = ((ReadInJoyXListView)localObject).getChildAt(paramInt3 - paramInt1);
        Rect localRect = new Rect();
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.height() <= 0) {
          break label324;
        }
        bool = true;
        continue;
      }
      if ((!dl.containsKey(paramAdvertisementInfo.mAdTraceId)) || (paramndi.xn - ((Long)dl.get(paramAdvertisementInfo.mAdTraceId)).longValue() < 500L)) {
        break;
      }
      aqyc.Yb(1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : preloadWebview ! traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      I.add(paramAdvertisementInfo.mAdTraceId);
      dl.remove(paramAdvertisementInfo.mAdTraceId);
      return;
      label324:
      bool = false;
    }
  }
  
  private void aEi()
  {
    dk.clear();
    H.clear();
    klv.aEk();
  }
  
  private void aEj()
  {
    dl.clear();
    I.clear();
  }
  
  public void N(Context paramContext, int paramInt)
  {
    if ((aU != null) && (aU.size() > 0))
    {
      Object localObject = new HashSet();
      Iterator localIterator = aU.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)aU.get(str);
        if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mChannelID == paramInt) && (knd.dh((int)localAdvertisementInfo.mChannelID)))
        {
          int i;
          if (localAdvertisementInfo.mChannelID == 56L) {
            i = jzk.aFx;
          }
          for (;;)
          {
            jzk.a(new kku.a().a(paramContext).a(jzk.aEU).b(i).a(localAdvertisementInfo).a());
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str + " mChannelID = " + paramInt);
            }
            ((HashSet)localObject).add(str);
            break;
            if (kxm.j(localAdvertisementInfo)) {
              i = jzk.aFB;
            } else {
              i = jzk.aFw;
            }
          }
        }
      }
      paramContext = ((HashSet)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (String)paramContext.next();
        aU.remove(localObject);
      }
    }
  }
  
  public void a(Context paramContext, View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    try
    {
      if (paramBaseArticleInfo.mFeedType == 39)
      {
        if (!H.contains(paramBaseArticleInfo.innerUniqueID))
        {
          H.add(paramBaseArticleInfo.innerUniqueID);
          jzk.a(paramContext, new jyq.a().a(504L).b(50401L).c(5040103L).a(paramBaseArticleInfo.innerUniqueID).b(paramBaseArticleInfo.mTitle).h(String.valueOf(paramInt)).c(paramBaseArticleInfo.mSubscribeName).f("1").g(paramBaseArticleInfo.mArticleContentUrl).a());
        }
      }
      else if (paramBaseArticleInfo.mFeedType == 38)
      {
        int i = ((View)paramView.getParent()).getHeight() - 200;
        int j = paramView.getTop();
        int k = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container1").getNativeView().getTop();
        int m = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container2").getNativeView().getTop();
        int n = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container3").getNativeView().getTop();
        paramView = paramBaseArticleInfo.mSmallMiniGameInfo.traceId + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.abd;
        String str1 = paramBaseArticleInfo.mSmallMiniGameInfo.traceId + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.abe;
        String str2 = paramBaseArticleInfo.mSmallMiniGameInfo.traceId + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.abf;
        String str3 = paramBaseArticleInfo.mSmallMiniGameInfo.traceId;
        if (!H.contains(str3))
        {
          H.add(str3);
          jzk.a(paramContext, new jyq.a().a(501L).b(50101L).c(5010102L).h(String.valueOf(paramInt)).b(paramBaseArticleInfo.mSmallMiniGameInfo.Vb).a());
        }
        if ((i - j > n) && (!H.contains(str2)))
        {
          H.add(str2);
          jzk.a(paramContext, new jyq.a().a(501L).b(50101L).c(5010103L).c(paramBaseArticleInfo.mSmallMiniGameInfo.abj).d(paramBaseArticleInfo.mSmallMiniGameInfo.abf).h(String.valueOf(paramInt)).e(paramBaseArticleInfo.mSmallMiniGameInfo.abm).f("3").g(paramBaseArticleInfo.mSmallMiniGameInfo.abc).a());
        }
        if ((i - j > m) && (!H.contains(str1)))
        {
          H.add(str1);
          jzk.a(paramContext, new jyq.a().a(501L).b(50101L).c(5010103L).c(paramBaseArticleInfo.mSmallMiniGameInfo.abh).d(paramBaseArticleInfo.mSmallMiniGameInfo.abe).h(String.valueOf(paramInt)).e(paramBaseArticleInfo.mSmallMiniGameInfo.abl).f("2").g(paramBaseArticleInfo.mSmallMiniGameInfo.abb).a());
        }
        if ((i - j > k) && (!H.contains(paramView)))
        {
          H.add(paramView);
          jzk.a(paramContext, new jyq.a().a(501L).b(50101L).c(5010103L).c(paramBaseArticleInfo.mSmallMiniGameInfo.abg).d(paramBaseArticleInfo.mSmallMiniGameInfo.abd).h(String.valueOf(paramInt)).e(paramBaseArticleInfo.mSmallMiniGameInfo.abk).f("1").g(paramBaseArticleInfo.mSmallMiniGameInfo.aba).a());
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ReadInjoyADExposureManager", 2, "reportMiniGame error" + paramContext.getMessage());
    }
  }
  
  public void a(ndi paramndi, Activity paramActivity, boolean paramBoolean)
  {
    if ((paramndi == null) || (paramActivity == null)) {}
    List localList;
    do
    {
      return;
      paramActivity = (ReadInJoyXListView)paramndi.b();
      localList = paramndi.getData();
    } while ((paramActivity == null) || (localList == null));
    int i = paramndi.nh();
    for (;;)
    {
      try
      {
        if ((!knd.dh(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label522;
          }
          paramBoolean = true;
          QLog.d("ReadInjoyADExposureManager", 2, paramBoolean);
        }
        int i1 = paramActivity.getHeaderViewsCount();
        int n = paramActivity.getFirstVisiblePosition();
        i = paramActivity.getLastVisiblePosition();
        if (i < n) {
          break;
        }
        if ((i < i1) || (i - i1 >= localList.size())) {
          break label513;
        }
        int i2 = i - i1;
        Object localObject1 = (BaseArticleInfo)localList.get(i2);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label513;
        }
        Object localObject2 = (AdvertisementInfo)localObject1;
        int j = ndi.b((ArticleInfo)localObject2, 0);
        localObject1 = paramndi.b().getChildAt(i - n);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label513;
        }
        localObject1 = ((ProteusItemView)localObject1).a().getVirtualView();
        paramBoolean = knd.o((AdvertisementInfo)localObject2);
        if ((!paramBoolean) || (j != 117)) {
          break label513;
        }
        int k = n;
        j = 0;
        if (k < i) {
          try
          {
            localObject2 = paramndi.b().getChildAt(k);
            localObject3 = ((View)localObject2).getLayoutParams();
            if (localObject3 != null)
            {
              m = ((ViewGroup.LayoutParams)localObject3).width;
              ((View)localObject2).measure(ViewGroup.getChildMeasureSpec(paramActivity.getMeasuredWidthAndState(), paramActivity.getPaddingLeft() + paramActivity.getPaddingRight(), m), 0);
              m = ((View)localObject2).getMeasuredHeight();
              k += 1;
              j += m;
              continue;
            }
            int m = -1;
            continue;
            localObject1 = ((ViewBase)localObject1).findViewBaseByName("id_article_triple_image_interact");
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + localException.getMessage());
            }
          }
        }
        if ((localObject1 == null) || (!(localObject1 instanceof kow))) {
          break label513;
        }
        kow localkow = (kow)localObject1;
        if (((ViewBase)localObject1).getNativeView() == null) {
          break label513;
        }
        Object localObject3 = new Rect();
        ((ViewBase)localObject1).getNativeView().getGlobalVisibleRect((Rect)localObject3);
        paramBoolean = false;
        if (i2 < 4) {
          paramBoolean = true;
        }
        k = ((ViewBase)localObject1).getNativeView().getTop();
        localkow.h(((ViewBase)localObject1).getNativeView().getWidth(), j + k, paramBoolean);
      }
      catch (Exception paramndi) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramndi.getMessage());
      return;
      label513:
      i -= 1;
      continue;
      label522:
      paramBoolean = false;
    }
  }
  
  public void a(ndi paramndi, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    if ((paramndi == null) || (paramActivity == null)) {}
    label1408:
    for (;;)
    {
      return;
      Object localObject1 = (ReadInJoyXListView)paramndi.b();
      List localList = paramndi.getData();
      int i1 = paramndi.nh();
      if ((localObject1 != null) && (localList != null))
      {
        Object localObject2;
        boolean bool1;
        label83:
        int i2;
        int i3;
        int n;
        int j;
        label124:
        int i4;
        Object localObject4;
        int i;
        Object localObject5;
        Object localObject3;
        label292:
        int k;
        int m;
        try
        {
          if ((!knd.dh(i1)) || (i1 == 56)) {
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("checkADScrollAction 向下滑动=");
            if (paramBoolean) {
              break label1350;
            }
            bool1 = true;
            QLog.d("ReadInjoyADExposureManager", 2, bool1);
          }
          i2 = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
          i3 = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
          n = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
          j = n;
          if (j < i3) {
            break label1368;
          }
          if ((j < i2) || (j - i2 >= localList.size())) {
            break label1341;
          }
          i4 = j - i2;
          localObject2 = (BaseArticleInfo)localList.get(i4);
          if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
            break label997;
          }
          localObject4 = (AdvertisementInfo)localObject2;
          i = ndi.b((ArticleInfo)localObject4, 0);
          localObject2 = paramndi.b().getChildAt(j - i3);
          if (((i != 39) && (i != 122)) || (!(localObject2 instanceof ProteusItemView))) {
            break label551;
          }
          localObject5 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_article_double_image");
          if ((localObject5 == null) || (!(localObject5 instanceof kos))) {
            break label1341;
          }
          localObject3 = (kos)localObject5;
          if (!knd.k((AdvertisementInfo)localObject4)) {
            break label426;
          }
          if (i4 >= 4) {
            break label1335;
          }
          bool1 = true;
          i = paramndi.b().getPaddingTop();
          k = ((View)localObject2).getTop() + ((ViewBase)localObject5).getNativeView().getTop();
          m = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
          i4 = ((ViewBase)localObject5).getNativeView().getHeight();
          int i5 = wja.dp2px(50.0F, paramActivity.getResources());
          ((kos)localObject3).c(((ViewBase)localObject5).getNativeView().getHeight(), m, m - k - i4 - i5, k - i, bool1);
        }
        catch (Exception paramndi) {}
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 出现异常:" + paramndi.getMessage());
          return;
          label426:
          if (knd.n((AdvertisementInfo)localObject4))
          {
            i = ((View)localObject2).getTop();
            i4 = ((ViewBase)localObject5).getNativeView().getTop();
            k = ((View)localObject2).getLeft();
            m = ((ViewBase)localObject5).getNativeView().getLeft();
            localObject4 = new int[2];
            ((View)localObject2).getLocationOnScreen((int[])localObject4);
            if (localObject4[1] != 0)
            {
              i = localObject4[1];
              label493:
              ((kos)localObject3).a(k + m, i, this.mScrollState, paramDouble);
              break label1341;
            }
          }
          else
          {
            if (knd.q((AdvertisementInfo)localObject4))
            {
              if (i4 - n != 0) {
                break label1356;
              }
              bool1 = true;
              ((kos)localObject3).mA(bool1);
              break label1341;
            }
            ((kos)localObject3).aFy();
            break label1341;
            if ((knd.o((AdvertisementInfo)localObject4)) && ((localObject2 instanceof ProteusItemView)))
            {
              localObject3 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_article_triple_image_interact");
              if ((localObject3 == null) || (!(localObject3 instanceof kow))) {
                break label1341;
              }
              localObject4 = (kow)localObject3;
              if (((ViewBase)localObject3).getNativeView() == null) {
                break label1341;
              }
              localObject5 = new Rect();
              ((ViewBase)localObject3).getNativeView().getGlobalVisibleRect((Rect)localObject5);
              bool1 = false;
              if (i4 < 4) {
                bool1 = true;
              }
              k = -1;
              i = k;
              if (bool1)
              {
                boolean bool2 = ((kow)localObject4).Ah();
                i = k;
                if (bool2)
                {
                  m = 0;
                  i = k;
                }
              }
              for (;;)
              {
                k = i;
                if (m < i4) {}
                try
                {
                  localObject5 = paramndi.b().getChildAt(m);
                  ViewGroup.LayoutParams localLayoutParams = ((View)localObject5).getLayoutParams();
                  if (localLayoutParams == null) {
                    break label1362;
                  }
                  i = localLayoutParams.width;
                  label722:
                  ((View)localObject5).measure(ViewGroup.getChildMeasureSpec(((ReadInJoyXListView)localObject1).getMeasuredWidthAndState(), ((ReadInJoyXListView)localObject1).getPaddingLeft() + ((ReadInJoyXListView)localObject1).getPaddingRight(), i), 0);
                  i = k + ((View)localObject5).getMeasuredHeight();
                  m += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    i = k;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + localException.getMessage());
                      i = k;
                    }
                  }
                }
              }
              i = ((ViewBase)localObject3).getNativeView().getTop();
              i = k + i;
              k = ((View)localObject2).getTop();
              m = ((ViewBase)localObject3).getNativeView().getTop();
              ((kow)localObject4).a(((ViewBase)localObject3).getNativeView().getWidth(), ((ViewBase)localObject3).getNativeView().getHeight(), k + m, bool1, i4, i);
              break label1341;
            }
            if ((!knd.p((AdvertisementInfo)localObject4)) || (!(localObject2 instanceof ProteusItemView))) {
              break label1341;
            }
            localObject3 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_article_brand_optimization");
            if ((localObject3 == null) || (!(localObject3 instanceof kod))) {
              break label1341;
            }
            localObject4 = (kod)localObject3;
            if (((ViewBase)localObject3).getNativeView() == null) {
              break label1341;
            }
            i = ((View)localObject2).getTop();
            if (((ViewBase)localObject3).getNativeView().getTop() + i > wja.dp2px(120.0F, ((View)localObject2).getResources()) + paramndi.b().getPaddingTop()) {
              break label1341;
            }
            ((kod)localObject4).aFd();
            break label1341;
            label997:
            if ((!knd.b((BaseArticleInfo)localObject2)) && (((BaseArticleInfo)localObject2).mFeedType != 39)) {
              break label1341;
            }
            localObject3 = paramndi.b().getChildAt(j - i3);
            if (!(localObject3 instanceof ProteusItemView)) {
              break label1341;
            }
            a(paramActivity, (View)localObject3, (BaseArticleInfo)localObject2, i4);
            break label1341;
          }
          for (;;)
          {
            label533:
            label551:
            if (j <= i) {
              break label1408;
            }
            if ((j >= i2) && (j - i2 < localList.size()))
            {
              paramndi = (BaseArticleInfo)localList.get(j - i2);
              if (AdvertisementInfo.isAdvertisementInfo(paramndi))
              {
                paramndi = (AdvertisementInfo)paramndi;
                paramActivity = paramndi.mAdvertisementExtInfo;
                k = i3 - j;
                double d = Math.abs(paramDouble) * 100.0D;
                if ((paramActivity != null) && (paramActivity.yO()) && (k == paramActivity.aJv) && (!paramActivity.agb) && (d < paramActivity.aJt) && (paramndi.hasAddExposure) && (knd.l(paramndi)))
                {
                  paramActivity.agb = true;
                  localObject1 = new jys();
                  ((jys)localObject1).aEw = paramndi.mAdMaterialId;
                  ((jys)localObject1).aEx = 1;
                  ((jys)localObject1).aEy = paramndi.mAdKdPos;
                  ((jys)localObject1).re = paramndi.mAdPosID;
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 符合规则触发请求 distance=" + k + ",scrollspeed=" + d + ",adExtInfo=" + paramActivity.toString() + "|" + ((jys)localObject1).toString());
                  }
                  ThreadManager.executeOnSubThread(new ReadInjoyADExposureManager.1(this, i1, (jys)localObject1));
                  break label1401;
                  for (;;)
                  {
                    break label1392;
                    i = i4 + i;
                    break label493;
                    label1335:
                    bool1 = false;
                    break label292;
                    label1341:
                    j -= 1;
                    break label124;
                    label1350:
                    bool1 = false;
                    break label83;
                    label1356:
                    bool1 = false;
                    break label533;
                    label1362:
                    i = -1;
                    break label722;
                    label1368:
                    if ((paramBoolean) || (i3 <= 0)) {
                      break;
                    }
                    i = i3 - 10;
                    if (i < 0) {
                      i = 0;
                    }
                  }
                  label1392:
                  j = i3 - 1;
                  continue;
                }
              }
            }
            label1401:
            j -= 1;
          }
        }
      }
    }
  }
  
  public void a(ndi paramndi, Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramndi == null) || (paramActivity == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramndi.b();
      paramActivity = paramndi.getData();
    } while ((localObject1 == null) || (paramActivity == null));
    int i = paramndi.nh();
    for (;;)
    {
      int i2;
      try
      {
        if ((!knd.dh(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label407;
          }
          paramBoolean = bool;
          QLog.d("ReadInjoyADExposureManager", 2, paramBoolean);
        }
        int k = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
        int m = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
        i = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
        if (i < m) {
          break;
        }
        if ((i < k) || (i - k >= paramActivity.size())) {
          break label398;
        }
        Object localObject2 = (BaseArticleInfo)paramActivity.get(i - k);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
          break label398;
        }
        j = ndi.b((AdvertisementInfo)localObject2, 0);
        localObject1 = paramndi.b().getChildAt(i - m);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label398;
        }
        Object localObject3 = ((ProteusItemView)localObject1).a().getVirtualView();
        if ((!knd.n((AdvertisementInfo)localObject2)) || (j != 39)) {
          break label398;
        }
        localObject3 = ((ViewBase)localObject3).findViewBaseByName("id_article_double_image");
        if ((localObject3 == null) || (!(localObject3 instanceof kos))) {
          break label398;
        }
        localObject2 = (kos)localObject3;
        j = ((View)localObject1).getTop();
        i2 = ((ViewBase)localObject3).getNativeView().getTop();
        int n = ((View)localObject1).getLeft();
        int i1 = ((ViewBase)localObject3).getNativeView().getLeft();
        localObject3 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject3);
        if (localObject3[1] == 0) {
          break label385;
        }
        j = localObject3[1];
        ((kos)localObject2).a(i1 + n, j, this.mScrollState, 1.0D);
      }
      catch (Exception paramndi) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramndi.getMessage());
      return;
      label385:
      int j = j + i2 + paramInt;
      continue;
      label398:
      i -= 1;
      continue;
      label407:
      paramBoolean = false;
    }
  }
  
  public boolean a(ndi paramndi, Activity paramActivity)
  {
    if ((paramndi == null) || (paramActivity == null)) {
      return false;
    }
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramndi.b();
    List localList = paramndi.getData();
    int i = paramndi.nh();
    if ((localReadInJoyXListView == null) || (localList == null)) {
      return false;
    }
    if ((knd.dh(i)) && (System.currentTimeMillis() - paramndi.xn > awit.R(this.app)))
    {
      paramndi.xn = System.currentTimeMillis();
      paramndi.L.clear();
      paramndi.V.clear();
      int n = localReadInJoyXListView.getHeaderViewsCount();
      int m = localReadInJoyXListView.getFirstVisiblePosition();
      int i1 = localReadInJoyXListView.getLastVisiblePosition();
      int j = m;
      Object localObject1;
      if (j <= i1)
      {
        if ((j < n) || (j - n >= localList.size())) {}
        Object localObject2;
        do
        {
          j += 1;
          break;
          localObject2 = (BaseArticleInfo)localList.get(j - n);
        } while ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (!kni.g((BaseArticleInfo)localObject2)));
        localObject1 = null;
        if ((localObject2 instanceof AdvertisementInfo)) {
          localObject1 = (AdvertisementInfo)localObject2;
        }
        while (localObject1 == null)
        {
          return false;
          if (kni.g((BaseArticleInfo)localObject2)) {
            localObject1 = ((BaseArticleInfo)localObject2).mSocialFeedInfo.g;
          }
        }
        if (knc.f((AdvertisementInfo)localObject1)) {
          a((AdvertisementInfo)localObject1, m, i1, j, paramndi);
        }
        for (;;)
        {
          if (!H.contains(((AdvertisementInfo)localObject1).mAdTraceId)) {
            break label294;
          }
          ((AdvertisementInfo)localObject1).hasAddExposure = true;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess enableCheckWebProcess : false.");
          }
        }
        label294:
        i = 0;
        int k;
        if ((j > m) && (j < i1))
        {
          i = 1;
          k = i;
          if (!aU.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
          {
            aU.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            k = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId);
              k = i;
            }
          }
          label385:
          if (k == 0) {
            break label586;
          }
          if (dk.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)) {
            break label588;
          }
          dk.put(((AdvertisementInfo)localObject1).mAdTraceId, Long.valueOf(paramndi.xn));
        }
        label586:
        label588:
        while (paramndi.xn - ((Long)dk.get(((AdvertisementInfo)localObject1).mAdTraceId)).longValue() <= 1000L)
        {
          paramndi.L.add(((AdvertisementInfo)localObject1).mAdTraceId);
          break;
          View localView = localReadInJoyXListView.getChildAt(j - m);
          k = localView.getHeight();
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          int i2 = localRect.height();
          if (i2 > k >> 1) {
            i = 1;
          }
          k = i;
          if (i2 <= 0) {
            break label385;
          }
          k = i;
          if (aU.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)) {
            break label385;
          }
          aU.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
          k = i;
          if (!QLog.isColorLevel()) {
            break label385;
          }
          QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId + " visibleHeight = " + i2);
          k = i;
          break label385;
          break;
        }
        if (knd.dh((int)((AdvertisementInfo)localObject1).mChannelID))
        {
          if (((AdvertisementInfo)localObject1).mChannelID != 56L) {
            break label896;
          }
          i = jzk.aFx;
        }
        for (;;)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("ad_strategy_type", Integer.valueOf(((AdvertisementInfo)localObject1).adStrategyType));
          jzk.a(new kku.a().a(paramActivity).a(jzk.aEK).b(i).a((AdvertisementInfo)localObject1).e(new JSONObject()).d(jzk.a((HashMap)localObject2)).a());
          if (aU.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
          {
            aU.remove(((AdvertisementInfo)localObject1).mAdTraceId);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport remove " + ((AdvertisementInfo)localObject1).mAdTraceId);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure i = " + j + " headerCount = " + n + " firstPos = " + m + " lastPos = " + i1 + " adInfo = " + ((AdvertisementInfo)localObject1).toSString());
          }
          ((AdvertisementInfo)localObject1).hasAddExposure = true;
          H.add(((AdvertisementInfo)localObject1).mAdTraceId);
          dk.remove(((AdvertisementInfo)localObject1).mAdTraceId);
          break;
          label896:
          if (kxm.j((BaseArticleInfo)localObject2)) {
            i = jzk.aFB;
          } else if ((knd.r((AdvertisementInfo)localObject1)) && (knj.a().getShowStatus() == 3)) {
            i = jzk.aFY;
          } else {
            i = jzk.aFw;
          }
        }
      }
      paramActivity = dk.keySet().iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (String)paramActivity.next();
        if (!paramndi.L.contains(localObject1)) {
          paramndi.V.add(localObject1);
        }
      }
      paramndi = paramndi.V.iterator();
      while (paramndi.hasNext())
      {
        paramActivity = (String)paramndi.next();
        dk.remove(paramActivity);
      }
      return true;
    }
    return false;
  }
  
  public void aB(Activity paramActivity)
  {
    if ((aU != null) && (aU.size() > 0))
    {
      Iterator localIterator = aU.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)aU.get(str);
        if ((localAdvertisementInfo != null) && (knd.dh((int)localAdvertisementInfo.mChannelID)))
        {
          int i;
          if (localAdvertisementInfo.mChannelID == 56L) {
            i = jzk.aFx;
          }
          for (;;)
          {
            jzk.a(new kku.a().a(paramActivity).a(jzk.aEU).b(i).a(localAdvertisementInfo).a());
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str);
            break;
            if (kxm.j(localAdvertisementInfo)) {
              i = jzk.aFB;
            } else {
              i = jzk.aFw;
            }
          }
        }
      }
      aU.clear();
    }
  }
  
  public void onDestroy()
  {
    aEi();
    aEj();
  }
  
  public void pj(int paramInt)
  {
    this.mScrollState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klu
 * JD-Core Version:    0.7.0.1
 */