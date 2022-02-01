import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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

public class uhx
  implements Manager
{
  public static HashMap<String, Long> a;
  public static HashSet<String> a;
  public static ConcurrentHashMap<String, AdvertisementInfo> a;
  public static HashMap<String, Long> b;
  public static HashSet<String> b;
  private int jdField_a_of_type_Int = -1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public uhx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private int a(BaseArticleInfo paramBaseArticleInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo.mChannelID == 56L) {
      return 4;
    }
    if (pqw.a(paramBaseArticleInfo)) {
      return 11;
    }
    return 3;
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashSet.clear();
    uhy.a();
  }
  
  private void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    int i = a(paramBaseArticleInfo, paramAdvertisementInfo);
    paramBaseArticleInfo = new HashMap();
    paramBaseArticleInfo.put("ad_strategy_type", Integer.valueOf(paramAdvertisementInfo.adStrategyType));
    ois.a(new ufy().a(paramActivity).a(2).b(i).a(paramAdvertisementInfo).e(new JSONObject()).d(ois.a(paramBaseArticleInfo)).a(ExposeMode.LOOSE).b(true).a());
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, szd paramszd)
  {
    if ((paramszd == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if (!jdField_b_of_type_JavaUtilHashSet.contains(paramAdvertisementInfo.mAdTraceId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : has already checked!, traceId=" + paramAdvertisementInfo.mAdTraceId);
    return;
    Object localObject = (ReadInJoyXListView)paramszd.a();
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
      if (!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId))
      {
        jdField_b_of_type_JavaUtilHashMap.put(paramAdvertisementInfo.mAdTraceId, Long.valueOf(paramszd.jdField_b_of_type_Long));
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
      if ((!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId)) || (paramszd.jdField_b_of_type_Long - ((Long)jdField_b_of_type_JavaUtilHashMap.get(paramAdvertisementInfo.mAdTraceId)).longValue() < 500L)) {
        break;
      }
      bicy.b(1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : preloadWebview ! traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      jdField_b_of_type_JavaUtilHashSet.add(paramAdvertisementInfo.mAdTraceId);
      jdField_b_of_type_JavaUtilHashMap.remove(paramAdvertisementInfo.mAdTraceId);
      return;
      label324:
      bool = false;
    }
  }
  
  private void a(szd paramszd, Activity paramActivity, double paramDouble, int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_double_image");
    if (!(localViewBase instanceof unz)) {
      return;
    }
    unz localunz = (unz)localViewBase;
    int i;
    if (uks.e(paramAdvertisementInfo))
    {
      boolean bool = false;
      if (paramInt2 < 4) {
        bool = true;
      }
      paramInt1 = paramszd.a().getPaddingTop();
      paramInt2 = paramView.getTop() + localViewBase.getNativeView().getTop();
      i = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
      int j = localViewBase.getNativeView().getHeight();
      int k = AIOUtils.dp2px(50.0F, paramActivity.getResources());
      localunz.a(localViewBase.getNativeView().getHeight(), i, i - paramInt2 - j - k, paramInt2 - paramInt1, bool);
      return;
    }
    if (uks.h(paramAdvertisementInfo))
    {
      paramInt1 = paramView.getTop() + localViewBase.getNativeView().getTop();
      paramInt2 = paramView.getLeft();
      i = localViewBase.getNativeView().getLeft();
      paramszd = new int[2];
      paramView.getLocationOnScreen(paramszd);
      if (paramszd[1] != 0) {
        paramInt1 = paramszd[1];
      }
      localunz.a(i + paramInt2, paramInt1, this.jdField_a_of_type_Int, paramDouble);
      return;
    }
    localunz.a();
  }
  
  private void a(szd paramszd, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_brand_optimization");
    if ((localViewBase instanceof ump))
    {
      ump localump = (ump)localViewBase;
      if (localViewBase.getNativeView() != null)
      {
        int i = paramView.getTop();
        if (localViewBase.getNativeView().getTop() + i <= AIOUtils.dp2px(120.0F, paramView.getResources()) + paramszd.a().getPaddingTop()) {
          localump.b();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, double paramDouble, List<BaseArticleInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((!paramBoolean) && (paramInt3 > 0))
    {
      i = paramInt3 - 10;
      if (i >= 0) {
        break label331;
      }
      i = 0;
    }
    label331:
    for (;;)
    {
      int j = paramInt3 - 1;
      if (j > i)
      {
        if ((j < paramInt2) || (j - paramInt2 >= paramList.size())) {}
        for (;;)
        {
          j -= 1;
          break;
          Object localObject = (BaseArticleInfo)paramList.get(j - paramInt2);
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))
          {
            localObject = (AdvertisementInfo)localObject;
            ufz localufz = ((AdvertisementInfo)localObject).mAdvertisementExtInfo;
            int k = paramInt3 - j;
            double d = Math.abs(paramDouble) * 100.0D;
            if ((localufz != null) && (localufz.a()) && (k == localufz.c) && (!localufz.jdField_a_of_type_Boolean) && (d < localufz.jdField_a_of_type_Int) && (((AdvertisementInfo)localObject).hasAddExposure) && (uks.f((AdvertisementInfo)localObject)))
            {
              localufz.jdField_a_of_type_Boolean = true;
              oha localoha = new oha();
              localoha.jdField_a_of_type_Int = ((AdvertisementInfo)localObject).mAdMaterialId;
              localoha.b = 1;
              localoha.c = ((AdvertisementInfo)localObject).mAdKdPos;
              localoha.jdField_a_of_type_Long = ((AdvertisementInfo)localObject).mAdPosID;
              localoha.jdField_a_of_type_Boolean = true;
              if (QLog.isColorLevel()) {
                QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 符合规则触发请求 distance=" + k + ",scrollSpeed=" + d + ",adExtInfo=" + localufz.toString() + "|" + localoha.toString());
              }
              ThreadManager.executeOnSubThread(new ReadInjoyADExposureManager.1(this, paramInt1, localoha));
            }
          }
        }
      }
      return;
    }
  }
  
  private void b()
  {
    jdField_b_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localAdvertisementInfo != null) && (uks.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i = a(localAdvertisementInfo, localAdvertisementInfo);
          ois.a(new ufy().a(paramActivity).a(81).b(i).a(localAdvertisementInfo).a());
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str);
          }
        }
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Object localObject = new HashSet();
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mChannelID == paramInt) && (uks.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i = a(localAdvertisementInfo, localAdvertisementInfo);
          ois.a(new ufy().a(paramContext).a(81).b(i).a(localAdvertisementInfo).a());
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str + " mChannelID = " + paramInt);
          }
          ((HashSet)localObject).add(str);
        }
      }
      paramContext = ((HashSet)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (String)paramContext.next();
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
      }
    }
  }
  
  public void a(Context paramContext, View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (uks.k(paramBaseArticleInfo))
        {
          paramView = paramBaseArticleInfo;
          if (uks.i(paramBaseArticleInfo))
          {
            paramView = paramBaseArticleInfo;
            if (paramBaseArticleInfo.mFeedType != 39) {
              paramView = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
            }
          }
          if (jdField_a_of_type_JavaUtilHashSet.contains(paramView.innerUniqueID)) {
            break;
          }
          jdField_a_of_type_JavaUtilHashSet.add(paramView.innerUniqueID);
          ois.a(paramContext, paramView, paramInt, 2);
          return;
        }
        if (paramBaseArticleInfo.mFeedType != 38) {
          break;
        }
        String str2 = paramBaseArticleInfo.mSmallMiniGameInfo.b + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.a(0);
        String str3 = paramBaseArticleInfo.mSmallMiniGameInfo.b + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.a(1);
        String str4 = paramBaseArticleInfo.mSmallMiniGameInfo.b + "-" + paramBaseArticleInfo.mSmallMiniGameInfo.a(2);
        str1 = paramBaseArticleInfo.mSmallMiniGameInfo.b;
        if (!jdField_a_of_type_JavaUtilHashSet.contains(str1))
        {
          jdField_a_of_type_JavaUtilHashSet.add(str1);
          ogz localogz = new ogz().a(501L).b(50101L).c(5010102L).d(6L).i(String.valueOf(paramInt)).b(paramBaseArticleInfo.mSmallMiniGameInfo.c);
          if (paramBaseArticleInfo.mSmallMiniGameInfo.a())
          {
            str1 = "3";
            ois.a(paramContext, localogz.h(str1).a());
          }
        }
        else
        {
          if (!paramBaseArticleInfo.mSmallMiniGameInfo.a()) {
            break;
          }
          int i = ((View)paramView.getParent()).getHeight() - 200;
          int j = paramView.getTop();
          int k = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container1").getNativeView().getTop();
          int m = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container2").getNativeView().getTop();
          if ((i - j > ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_game_container3").getNativeView().getTop()) && (!jdField_a_of_type_JavaUtilHashSet.contains(str4)))
          {
            jdField_a_of_type_JavaUtilHashSet.add(str4);
            ois.a(paramContext, paramBaseArticleInfo, paramInt, 2, 2);
          }
          if ((i - j > m) && (!jdField_a_of_type_JavaUtilHashSet.contains(str3)))
          {
            jdField_a_of_type_JavaUtilHashSet.add(str3);
            ois.a(paramContext, paramBaseArticleInfo, paramInt, 1, 2);
          }
          if ((i - j <= k) || (jdField_a_of_type_JavaUtilHashSet.contains(str2))) {
            break;
          }
          jdField_a_of_type_JavaUtilHashSet.add(str2);
          ois.a(paramContext, paramBaseArticleInfo, paramInt, 0, 2);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ReadInjoyADExposureManager", 2, "reportMiniGame error" + paramContext.getMessage());
        return;
      }
      String str1 = "2";
    }
  }
  
  public void a(szd paramszd, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    if ((paramszd == null) || (paramActivity == null)) {}
    Object localObject1;
    List localList;
    int k;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramszd.a();
      localList = paramszd.a();
      k = paramszd.a();
    } while ((localObject1 == null) || (localList == null) || (!uks.a(k)) || (k == 56));
    for (;;)
    {
      Object localObject2;
      int m;
      int n;
      int i;
      int i1;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("checkADScrollAction 向下滑动=");
          if (paramBoolean) {
            break label387;
          }
          bool = true;
          QLog.d("ReadInjoyADExposureManager", 2, bool);
        }
        m = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
        n = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
        int j = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
        i = j;
        if (i < n) {
          break label362;
        }
        if ((i < m) || (i - m >= localList.size())) {
          break label378;
        }
        i1 = i - m;
        localObject1 = (BaseArticleInfo)localList.get(i1);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label308;
        }
        localObject1 = (AdvertisementInfo)localObject1;
        int i2 = szf.a.a((ArticleInfo)localObject1, 0);
        localObject2 = paramszd.a().getChildAt(i - n);
        if ((i2 == 39) && ((localObject2 instanceof ProteusItemView))) {
          a(paramszd, paramActivity, paramDouble, j, i1, (AdvertisementInfo)localObject1, (View)localObject2);
        }
      }
      catch (Exception paramszd)
      {
        QLog.e("ReadInjoyADExposureManager", 1, "checkADScrollAction 出现异常:" + paramszd.getMessage());
        return;
      }
      if ((uks.i((AdvertisementInfo)localObject1)) && ((localObject2 instanceof ProteusItemView)))
      {
        a(paramszd, (View)localObject2);
        break label378;
        label308:
        if ((((BaseArticleInfo)localObject1).mFeedType == 38) || (uks.k((BaseArticleInfo)localObject1)))
        {
          localObject2 = paramszd.a().getChildAt(i - n);
          if ((localObject2 instanceof ProteusItemView))
          {
            a(paramActivity, (View)localObject2, (BaseArticleInfo)localObject1, i1);
            break label378;
            label362:
            a(paramBoolean, paramDouble, localList, k, m, n);
            return;
          }
        }
      }
      label378:
      i -= 1;
      continue;
      label387:
      boolean bool = false;
    }
  }
  
  public void a(szd paramszd, Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramszd == null) || (paramActivity == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramszd.a();
      paramActivity = paramszd.a();
    } while ((localObject1 == null) || (paramActivity == null));
    int i = paramszd.a();
    for (;;)
    {
      int i2;
      try
      {
        if ((!uks.a(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label413;
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
          break label404;
        }
        Object localObject2 = (BaseArticleInfo)paramActivity.get(i - k);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
          break label404;
        }
        localObject1 = (AdvertisementInfo)localObject2;
        j = szf.a.a((ArticleInfo)localObject1, 0);
        localObject1 = paramszd.a().getChildAt(i - m);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label404;
        }
        Object localObject3 = ((ProteusItemView)localObject1).a().getVirtualView();
        if ((!uks.h((AdvertisementInfo)localObject2)) || (j != 39)) {
          break label404;
        }
        localObject3 = ((ViewBase)localObject3).findViewBaseByName("id_article_double_image");
        if ((localObject3 == null) || (!(localObject3 instanceof unz))) {
          break label404;
        }
        localObject2 = (unz)localObject3;
        j = ((View)localObject1).getTop();
        i2 = ((ViewBase)localObject3).getNativeView().getTop();
        int n = ((View)localObject1).getLeft();
        int i1 = ((ViewBase)localObject3).getNativeView().getLeft();
        localObject3 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject3);
        if (localObject3[1] == 0) {
          break label391;
        }
        j = localObject3[1];
        ((unz)localObject2).a(i1 + n, j, this.jdField_a_of_type_Int, 1.0D);
      }
      catch (Exception paramszd) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramszd.getMessage());
      return;
      label391:
      int j = j + i2 + paramInt;
      continue;
      label404:
      i -= 1;
      continue;
      label413:
      paramBoolean = false;
    }
  }
  
  public boolean a(szd paramszd, Activity paramActivity)
  {
    if ((paramszd == null) || (paramActivity == null)) {
      return false;
    }
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramszd.a();
    List localList = paramszd.a();
    int i = paramszd.a();
    if ((localReadInJoyXListView == null) || (localList == null)) {
      return false;
    }
    if ((uks.a(i)) && (System.currentTimeMillis() - paramszd.jdField_b_of_type_Long > bmhv.G(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramszd.jdField_b_of_type_Long = System.currentTimeMillis();
      paramszd.jdField_a_of_type_JavaUtilHashSet.clear();
      paramszd.jdField_b_of_type_JavaUtilHashSet.clear();
      int i4 = localReadInJoyXListView.getHeaderViewsCount();
      int i1 = localReadInJoyXListView.getFirstVisiblePosition();
      int i5 = localReadInJoyXListView.getLastVisiblePosition();
      int m = i1;
      Object localObject1;
      if (m <= i5)
      {
        if ((m < i4) || (m - i4 >= localList.size())) {}
        Object localObject2;
        label265:
        int j;
        int k;
        int n;
        int i2;
        label393:
        do
        {
          do
          {
            m += 1;
            break;
            localObject2 = (BaseArticleInfo)localList.get(m - i4);
          } while (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2));
          localObject1 = null;
          if ((localObject2 instanceof AdvertisementInfo)) {
            localObject1 = (AdvertisementInfo)localObject2;
          }
          if (localObject1 == null) {
            return false;
          }
          if (ukr.f((AdvertisementInfo)localObject1)) {
            a((AdvertisementInfo)localObject1, i1, i5, m, paramszd);
          }
          for (;;)
          {
            if (!jdField_a_of_type_JavaUtilHashSet.contains(((AdvertisementInfo)localObject1).mAdTraceId)) {
              break label265;
            }
            ((AdvertisementInfo)localObject1).hasAddExposure = true;
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess enableCheckWebProcess : false.");
            }
          }
          i = 0;
          j = 0;
          k = 0;
          if ((m <= i1) || (m >= i5)) {
            break label479;
          }
          n = 1;
          i2 = 1;
          int i3 = 1;
          i = i3;
          j = i2;
          k = n;
          if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            i = i3;
            j = i2;
            k = n;
            if (QLog.isColorLevel())
            {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId);
              k = n;
              j = i2;
              i = i3;
            }
          }
          if (j != 0) {
            odz.a().a(Long.valueOf(((AdvertisementInfo)localObject1).mAdAid));
          }
          if (i != 0) {
            a(paramActivity, (BaseArticleInfo)localObject2, (AdvertisementInfo)localObject1);
          }
        } while (k == 0);
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)) {
          jdField_a_of_type_JavaUtilHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, Long.valueOf(paramszd.jdField_b_of_type_Long));
        }
        for (;;)
        {
          paramszd.jdField_a_of_type_JavaUtilHashSet.add(((AdvertisementInfo)localObject1).mAdTraceId);
          break;
          label479:
          View localView = localReadInJoyXListView.getChildAt(m - i1);
          i2 = localView.getHeight();
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          n = localRect.height();
          if (n > i2 >> 1) {
            i = 1;
          }
          if (n > odz.a().a() * i2 / 100.0F) {
            j = 1;
          }
          if (n > i2 * 0.01F) {
            k = 1;
          }
          if ((n > 0) && (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId + " visibleHeight = " + n);
            }
          }
          n = i;
          i = k;
          k = n;
          break label393;
          if (paramszd.jdField_b_of_type_Long - ((Long)jdField_a_of_type_JavaUtilHashMap.get(((AdvertisementInfo)localObject1).mAdTraceId)).longValue() > 1000L)
          {
            if (uks.a((int)((AdvertisementInfo)localObject1).mChannelID))
            {
              i = a((BaseArticleInfo)localObject2, (AdvertisementInfo)localObject1);
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("ad_strategy_type", Integer.valueOf(((AdvertisementInfo)localObject1).adStrategyType));
              ois.a(new ufy().a(paramActivity).a(2).b(i).a(ExposeMode.STRICT).a((AdvertisementInfo)localObject1).e(new JSONObject()).d(ois.a((HashMap)localObject2)).a());
              if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
              {
                jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((AdvertisementInfo)localObject1).mAdTraceId);
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport remove " + ((AdvertisementInfo)localObject1).mAdTraceId);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure i = " + m + " headerCount = " + i4 + " firstPos = " + i1 + " lastPos = " + i5 + " adInfo = " + ((AdvertisementInfo)localObject1).toSString());
              }
            }
            ((AdvertisementInfo)localObject1).hasAddExposure = true;
            jdField_a_of_type_JavaUtilHashSet.add(((AdvertisementInfo)localObject1).mAdTraceId);
            jdField_a_of_type_JavaUtilHashMap.remove(((AdvertisementInfo)localObject1).mAdTraceId);
          }
        }
      }
      paramActivity = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (String)paramActivity.next();
        if (!paramszd.jdField_a_of_type_JavaUtilHashSet.contains(localObject1)) {
          paramszd.jdField_b_of_type_JavaUtilHashSet.add(localObject1);
        }
      }
      paramszd = paramszd.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (paramszd.hasNext())
      {
        paramActivity = (String)paramszd.next();
        jdField_a_of_type_JavaUtilHashMap.remove(paramActivity);
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */