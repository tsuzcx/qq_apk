import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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

public class ttq
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
  
  public ttq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashSet.clear();
    ttr.a();
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, slt paramslt)
  {
    if ((paramslt == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if (!jdField_b_of_type_JavaUtilHashSet.contains(paramAdvertisementInfo.mAdTraceId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : has already checked!, traceId=" + paramAdvertisementInfo.mAdTraceId);
    return;
    Object localObject = (ReadInJoyXListView)paramslt.a();
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
        jdField_b_of_type_JavaUtilHashMap.put(paramAdvertisementInfo.mAdTraceId, Long.valueOf(paramslt.jdField_b_of_type_Long));
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
      if ((!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId)) || (paramslt.jdField_b_of_type_Long - ((Long)jdField_b_of_type_JavaUtilHashMap.get(paramAdvertisementInfo.mAdTraceId)).longValue() < 500L)) {
        break;
      }
      bgsi.b(1);
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
  
  private void a(slt paramslt, Activity paramActivity, double paramDouble, int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_double_image");
    if (!(localViewBase instanceof tzy)) {
      return;
    }
    tzy localtzy = (tzy)localViewBase;
    boolean bool;
    int i;
    if (twr.e(paramAdvertisementInfo))
    {
      bool = false;
      if (paramInt2 < 4) {
        bool = true;
      }
      paramInt1 = paramslt.a().getPaddingTop();
      paramInt2 = paramView.getTop() + localViewBase.getNativeView().getTop();
      i = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
      int j = localViewBase.getNativeView().getHeight();
      int k = AIOUtils.dp2px(50.0F, paramActivity.getResources());
      localtzy.a(localViewBase.getNativeView().getHeight(), i, i - paramInt2 - j - k, paramInt2 - paramInt1, bool);
      return;
    }
    if (twr.h(paramAdvertisementInfo))
    {
      paramInt1 = paramView.getTop() + localViewBase.getNativeView().getTop();
      paramInt2 = paramView.getLeft();
      i = localViewBase.getNativeView().getLeft();
      paramslt = new int[2];
      paramView.getLocationOnScreen(paramslt);
      if (paramslt[1] != 0) {
        paramInt1 = paramslt[1];
      }
      localtzy.a(i + paramInt2, paramInt1, this.jdField_a_of_type_Int, paramDouble);
      return;
    }
    if (twr.k(paramAdvertisementInfo))
    {
      if (paramInt2 - paramInt1 == 0) {}
      for (bool = true;; bool = false)
      {
        localtzy.a(bool);
        return;
      }
    }
    localtzy.a();
  }
  
  private void a(slt paramslt, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_brand_optimization");
    if ((localViewBase instanceof tyr))
    {
      tyr localtyr = (tyr)localViewBase;
      if (localViewBase.getNativeView() != null)
      {
        int i = paramView.getTop();
        if (localViewBase.getNativeView().getTop() + i <= AIOUtils.dp2px(120.0F, paramView.getResources()) + paramslt.a().getPaddingTop()) {
          localtyr.b();
        }
      }
    }
  }
  
  private void a(slt paramslt, ReadInJoyXListView paramReadInJoyXListView, int paramInt, View paramView)
  {
    ViewBase localViewBase = ((ProteusItemView)paramView).a().getVirtualView().findViewBaseByName("id_article_triple_image_interact");
    if (!(localViewBase instanceof uad)) {}
    uad localuad;
    do
    {
      return;
      localuad = (uad)localViewBase;
    } while (localViewBase.getNativeView() == null);
    Object localObject = new Rect();
    localViewBase.getNativeView().getGlobalVisibleRect((Rect)localObject);
    boolean bool;
    int k;
    int i;
    int j;
    if (paramInt < 4)
    {
      bool = true;
      if ((bool) && (localuad.a()))
      {
        k = 0;
        i = -1;
        j = i;
        if (k >= paramInt) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = paramslt.a().getChildAt(k);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        if (localLayoutParams == null) {
          break label298;
        }
        i = localLayoutParams.width;
        ((View)localObject).measure(ViewGroup.getChildMeasureSpec(paramReadInJoyXListView.getMeasuredWidthAndState(), paramReadInJoyXListView.getPaddingLeft() + paramReadInJoyXListView.getPaddingRight(), i), 0);
        i = j + ((View)localObject).getMeasuredHeight();
        k += 1;
      }
      catch (Exception paramslt)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramslt.getMessage());
        i = j;
        continue;
      }
      i = localViewBase.getNativeView().getTop();
      i = j + i;
      j = paramView.getTop();
      k = localViewBase.getNativeView().getTop();
      localuad.a(localViewBase.getNativeView().getWidth(), localViewBase.getNativeView().getHeight(), k + j, bool, paramInt, i);
      return;
      i = -1;
      continue;
      bool = false;
      break;
      label298:
      i = -1;
    }
  }
  
  private void a(boolean paramBoolean, double paramDouble, List<BaseArticleInfo> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((!paramBoolean) && (paramInt3 > 0))
    {
      i = paramInt3 - 10;
      if (i >= 0) {
        break label325;
      }
      i = 0;
    }
    label325:
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
            tro localtro = ((AdvertisementInfo)localObject).mAdvertisementExtInfo;
            int k = paramInt3 - j;
            double d = Math.abs(paramDouble) * 100.0D;
            if ((localtro != null) && (localtro.a()) && (k == localtro.c) && (!localtro.jdField_a_of_type_Boolean) && (d < localtro.jdField_a_of_type_Int) && (((AdvertisementInfo)localObject).hasAddExposure) && (twr.f((AdvertisementInfo)localObject)))
            {
              localtro.jdField_a_of_type_Boolean = true;
              oaa localoaa = new oaa();
              localoaa.jdField_a_of_type_Int = ((AdvertisementInfo)localObject).mAdMaterialId;
              localoaa.b = 1;
              localoaa.c = ((AdvertisementInfo)localObject).mAdKdPos;
              localoaa.jdField_a_of_type_Long = ((AdvertisementInfo)localObject).mAdPosID;
              if (QLog.isColorLevel()) {
                QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 符合规则触发请求 distance=" + k + ",scrollSpeed=" + d + ",adExtInfo=" + localtro.toString() + "|" + localoaa.toString());
              }
              ThreadManager.executeOnSubThread(new ReadInjoyADExposureManager.1(this, paramInt1, localoaa));
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
        if ((localAdvertisementInfo != null) && (twr.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i;
          if (localAdvertisementInfo.mChannelID == 56L) {
            i = obb.O;
          }
          for (;;)
          {
            obb.a(new trn().a(paramActivity).a(obb.l).b(i).a(localAdvertisementInfo).a());
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str);
            break;
            if (pay.a(localAdvertisementInfo)) {
              i = obb.S;
            } else {
              i = obb.N;
            }
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
        if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mChannelID == paramInt) && (twr.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i;
          if (localAdvertisementInfo.mChannelID == 56L) {
            i = obb.O;
          }
          for (;;)
          {
            obb.a(new trn().a(paramContext).a(obb.l).b(i).a(localAdvertisementInfo).a());
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str + " mChannelID = " + paramInt);
            }
            ((HashSet)localObject).add(str);
            break;
            if (pay.a(localAdvertisementInfo)) {
              i = obb.S;
            } else {
              i = obb.N;
            }
          }
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
        if (twr.i(paramBaseArticleInfo))
        {
          paramView = paramBaseArticleInfo;
          if (twr.g(paramBaseArticleInfo))
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
          obb.a(paramContext, paramView, paramInt, obb.b);
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
          nzz localnzz = new nzz().a(501L).b(50101L).c(5010102L).d(6L).i(String.valueOf(paramInt)).b(paramBaseArticleInfo.mSmallMiniGameInfo.c);
          if (paramBaseArticleInfo.mSmallMiniGameInfo.a())
          {
            str1 = "3";
            obb.a(paramContext, localnzz.h(str1).a());
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
            obb.a(paramContext, paramBaseArticleInfo, paramInt, 2, obb.b);
          }
          if ((i - j > m) && (!jdField_a_of_type_JavaUtilHashSet.contains(str3)))
          {
            jdField_a_of_type_JavaUtilHashSet.add(str3);
            obb.a(paramContext, paramBaseArticleInfo, paramInt, 1, obb.b);
          }
          if ((i - j <= k) || (jdField_a_of_type_JavaUtilHashSet.contains(str2))) {
            break;
          }
          jdField_a_of_type_JavaUtilHashSet.add(str2);
          obb.a(paramContext, paramBaseArticleInfo, paramInt, 0, obb.b);
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
  
  public void a(slt paramslt, Activity paramActivity, boolean paramBoolean)
  {
    if ((paramslt == null) || (paramActivity == null)) {}
    List localList;
    do
    {
      return;
      paramActivity = (ReadInJoyXListView)paramslt.a();
      localList = paramslt.a();
    } while ((paramActivity == null) || (localList == null));
    int i = paramslt.a();
    for (;;)
    {
      try
      {
        if ((!twr.a(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label525;
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
          break label516;
        }
        int i2 = i - i1;
        Object localObject1 = (BaseArticleInfo)localList.get(i2);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label516;
        }
        Object localObject2 = (AdvertisementInfo)localObject1;
        int j = slv.a.a((ArticleInfo)localObject2, 0);
        localObject1 = paramslt.a().getChildAt(i - n);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label516;
        }
        localObject1 = ((ProteusItemView)localObject1).a().getVirtualView();
        paramBoolean = twr.i((AdvertisementInfo)localObject2);
        if ((!paramBoolean) || (j != 117)) {
          break label516;
        }
        int k = n;
        j = 0;
        if (k < i) {
          try
          {
            localObject2 = paramslt.a().getChildAt(k);
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
        if ((localObject1 == null) || (!(localObject1 instanceof uad))) {
          break label516;
        }
        uad localuad = (uad)localObject1;
        if (((ViewBase)localObject1).getNativeView() == null) {
          break label516;
        }
        Object localObject3 = new Rect();
        ((ViewBase)localObject1).getNativeView().getGlobalVisibleRect((Rect)localObject3);
        paramBoolean = false;
        if (i2 < 4) {
          paramBoolean = true;
        }
        k = ((ViewBase)localObject1).getNativeView().getTop();
        localuad.a(((ViewBase)localObject1).getNativeView().getWidth(), j + k, paramBoolean);
      }
      catch (Exception paramslt) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramslt.getMessage());
      return;
      label516:
      i -= 1;
      continue;
      label525:
      paramBoolean = false;
    }
  }
  
  public void a(slt paramslt, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    if ((paramslt == null) || (paramActivity == null)) {}
    ReadInJoyXListView localReadInJoyXListView;
    List localList;
    int k;
    do
    {
      return;
      localReadInJoyXListView = (ReadInJoyXListView)paramslt.a();
      localList = paramslt.a();
      k = paramslt.a();
    } while ((localReadInJoyXListView == null) || (localList == null) || (!twr.a(k)) || (k == 56));
    for (;;)
    {
      Object localObject;
      int m;
      int n;
      int i;
      int i1;
      View localView;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("checkADScrollAction 向下滑动=");
          if (paramBoolean) {
            break label424;
          }
          bool = true;
          QLog.d("ReadInjoyADExposureManager", 2, bool);
        }
        m = localReadInJoyXListView.getHeaderViewsCount();
        n = localReadInJoyXListView.getFirstVisiblePosition();
        int j = localReadInJoyXListView.getLastVisiblePosition();
        i = j;
        if (i < n) {
          break label399;
        }
        if ((i < m) || (i - m >= localList.size())) {
          break label415;
        }
        i1 = i - m;
        localObject = (BaseArticleInfo)localList.get(i1);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) {
          break label345;
        }
        localObject = (AdvertisementInfo)localObject;
        int i2 = slv.a.a((ArticleInfo)localObject, 0);
        localView = paramslt.a().getChildAt(i - n);
        if (((i2 == 39) || (i2 == 122)) && ((localView instanceof ProteusItemView))) {
          a(paramslt, paramActivity, paramDouble, j, i1, (AdvertisementInfo)localObject, localView);
        }
      }
      catch (Exception paramslt)
      {
        QLog.e("ReadInjoyADExposureManager", 1, "checkADScrollAction 出现异常:" + paramslt.getMessage());
        return;
      }
      if ((twr.i((AdvertisementInfo)localObject)) && ((localView instanceof ProteusItemView))) {
        a(paramslt, localReadInJoyXListView, i1, localView);
      } else {
        label399:
        if ((twr.j((AdvertisementInfo)localObject)) && ((localView instanceof ProteusItemView)))
        {
          a(paramslt, localView);
          break label415;
          label345:
          if ((((BaseArticleInfo)localObject).mFeedType == 38) || (twr.i((BaseArticleInfo)localObject)))
          {
            localView = paramslt.a().getChildAt(i - n);
            if ((localView instanceof ProteusItemView))
            {
              a(paramActivity, localView, (BaseArticleInfo)localObject, i1);
              break label415;
              a(paramBoolean, paramDouble, localList, k, m, n);
              return;
            }
          }
        }
      }
      label415:
      i -= 1;
      continue;
      label424:
      boolean bool = false;
    }
  }
  
  public void a(slt paramslt, Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramslt == null) || (paramActivity == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramslt.a();
      paramActivity = paramslt.a();
    } while ((localObject1 == null) || (paramActivity == null));
    int i = paramslt.a();
    for (;;)
    {
      int i2;
      try
      {
        if ((!twr.a(i)) || (i == 56)) {
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
        j = slv.a.a((ArticleInfo)localObject1, 0);
        localObject1 = paramslt.a().getChildAt(i - m);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label404;
        }
        Object localObject3 = ((ProteusItemView)localObject1).a().getVirtualView();
        if ((!twr.h((AdvertisementInfo)localObject2)) || (j != 39)) {
          break label404;
        }
        localObject3 = ((ViewBase)localObject3).findViewBaseByName("id_article_double_image");
        if ((localObject3 == null) || (!(localObject3 instanceof tzy))) {
          break label404;
        }
        localObject2 = (tzy)localObject3;
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
        ((tzy)localObject2).a(i1 + n, j, this.jdField_a_of_type_Int, 1.0D);
      }
      catch (Exception paramslt) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramslt.getMessage());
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
  
  public boolean a(slt paramslt, Activity paramActivity)
  {
    if ((paramslt == null) || (paramActivity == null)) {
      return false;
    }
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramslt.a();
    List localList = paramslt.a();
    int i = paramslt.a();
    if ((localReadInJoyXListView == null) || (localList == null)) {
      return false;
    }
    if ((twr.a(i)) && (System.currentTimeMillis() - paramslt.jdField_b_of_type_Long > bkwm.G(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramslt.jdField_b_of_type_Long = System.currentTimeMillis();
      paramslt.jdField_a_of_type_JavaUtilHashSet.clear();
      paramslt.jdField_b_of_type_JavaUtilHashSet.clear();
      int i2 = localReadInJoyXListView.getHeaderViewsCount();
      int n = localReadInJoyXListView.getFirstVisiblePosition();
      int i3 = localReadInJoyXListView.getLastVisiblePosition();
      int k = n;
      Object localObject1;
      if (k <= i3)
      {
        if ((k < i2) || (k - i2 >= localList.size())) {}
        Object localObject2;
        label265:
        int j;
        int m;
        int i1;
        label375:
        do
        {
          do
          {
            k += 1;
            break;
            localObject2 = (BaseArticleInfo)localList.get(k - i2);
          } while (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2));
          localObject1 = null;
          if ((localObject2 instanceof AdvertisementInfo)) {
            localObject1 = (AdvertisementInfo)localObject2;
          }
          if (localObject1 == null) {
            return false;
          }
          if (twq.f((AdvertisementInfo)localObject1)) {
            a((AdvertisementInfo)localObject1, n, i3, k, paramslt);
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
          if ((k <= n) || (k >= i3)) {
            break label447;
          }
          m = 1;
          i1 = 1;
          i = i1;
          j = m;
          if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            i = i1;
            j = m;
            if (QLog.isColorLevel())
            {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId);
              j = m;
              i = i1;
            }
          }
          if (i != 0) {
            nwz.a().a(Long.valueOf(((AdvertisementInfo)localObject1).mAdAid));
          }
        } while (j == 0);
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)) {
          jdField_a_of_type_JavaUtilHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, Long.valueOf(paramslt.jdField_b_of_type_Long));
        }
        label447:
        while (paramslt.jdField_b_of_type_Long - ((Long)jdField_a_of_type_JavaUtilHashMap.get(((AdvertisementInfo)localObject1).mAdTraceId)).longValue() <= 1000L)
        {
          paramslt.jdField_a_of_type_JavaUtilHashSet.add(((AdvertisementInfo)localObject1).mAdTraceId);
          break;
          View localView = localReadInJoyXListView.getChildAt(k - n);
          i1 = localView.getHeight();
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          m = localRect.height();
          if (m > i1 >> 1) {
            i = 1;
          }
          if (m > i1 * nwz.a().a() / 100.0F) {
            j = 1;
          }
          if ((m > 0) && (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId)))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AdvertisementInfo)localObject1).mAdTraceId, localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + ((AdvertisementInfo)localObject1).mAdTraceId + " visibleHeight = " + m);
            }
          }
          m = i;
          i = j;
          j = m;
          break label375;
        }
        if (twr.a((int)((AdvertisementInfo)localObject1).mChannelID))
        {
          if (((AdvertisementInfo)localObject1).mChannelID != 56L) {
            break label926;
          }
          i = obb.O;
        }
        for (;;)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("ad_strategy_type", Integer.valueOf(((AdvertisementInfo)localObject1).adStrategyType));
          obb.a(new trn().a(paramActivity).a(obb.b).b(i).a((AdvertisementInfo)localObject1).e(new JSONObject()).d(obb.a((HashMap)localObject2)).a());
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((AdvertisementInfo)localObject1).mAdTraceId))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((AdvertisementInfo)localObject1).mAdTraceId);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport remove " + ((AdvertisementInfo)localObject1).mAdTraceId);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure i = " + k + " headerCount = " + i2 + " firstPos = " + n + " lastPos = " + i3 + " adInfo = " + ((AdvertisementInfo)localObject1).toSString());
          }
          ((AdvertisementInfo)localObject1).hasAddExposure = true;
          jdField_a_of_type_JavaUtilHashSet.add(((AdvertisementInfo)localObject1).mAdTraceId);
          jdField_a_of_type_JavaUtilHashMap.remove(((AdvertisementInfo)localObject1).mAdTraceId);
          break;
          label926:
          if (pay.a((BaseArticleInfo)localObject2)) {
            i = obb.S;
          } else {
            i = obb.N;
          }
        }
      }
      paramActivity = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (String)paramActivity.next();
        if (!paramslt.jdField_a_of_type_JavaUtilHashSet.contains(localObject1)) {
          paramslt.jdField_b_of_type_JavaUtilHashSet.add(localObject1);
        }
      }
      paramslt = paramslt.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (paramslt.hasNext())
      {
        paramActivity = (String)paramslt.next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttq
 * JD-Core Version:    0.7.0.1
 */