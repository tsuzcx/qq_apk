package com.tencent.biz.qqcircle.fragments;

import acfp;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import ovg;
import ovv;
import owa;
import oxh;
import oyu;
import ozw;
import ozx;
import ozy;
import ozz;
import pdy;
import pel;
import rxj;
import rxk;
import rxn;
import rxq;
import rxt;
import rxy;

public abstract class QCircleBaseTabFragment
  extends QCircleBaseFragment
{
  public static String TAG = "QCircleBaseTabFragment";
  public static String arP = "TAB_TYPE_FOLLOW";
  public static String arQ = "TAB_TYPE_SCHOOL";
  public static String arR = "TAB_TYPE_COMPANY";
  public static String arS = "TAB_TYPE_CITY";
  public static String arT = "TAB_TYPE_CIRCLE";
  public static String arU = "TAB_TYPE_RECOMMEND";
  private static int bgP;
  public QCirclePolymorphicAniView a;
  protected QCircleStatusView a;
  protected ovg a;
  public owa a;
  public oxh a;
  public oyu a;
  protected rxj a;
  public rxk a;
  protected pdy b;
  protected boolean mHasInit;
  private int mIndex = bgP;
  protected String mUin = "";
  
  public QCircleBaseTabFragment()
  {
    bgP += 1;
  }
  
  private ovv a()
  {
    return new ozx(this);
  }
  
  public static void biK()
  {
    bgP = 0;
  }
  
  private void biM()
  {
    ThreadManager.getUIHandler().postDelayed(new QCircleBaseTabFragment.3(this), 3000L);
  }
  
  private void dF(int paramInt1, int paramInt2)
  {
    NestScrollRecyclerView localNestScrollRecyclerView = this.jdField_a_of_type_Rxj.a().a();
    if (localNestScrollRecyclerView != null) {
      localNestScrollRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ozz(this, localNestScrollRecyclerView, paramInt1, paramInt2));
    }
  }
  
  public boolean HG()
  {
    return false;
  }
  
  protected boolean HH()
  {
    return (this.jdField_a_of_type_Ovg != null) && (this.jdField_a_of_type_Ovg.getItemCount() > 0);
  }
  
  public owa a()
  {
    return this.jdField_a_of_type_Owa;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "scrollToPosWithOffset pos:" + paramInt1 + ",top:" + paramInt2 + "." + lY());
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof rxy)) {
        ((rxy)paramRecyclerView).scrollToPositionWithOffset(paramInt1, paramInt2);
      }
      return;
    }
    catch (Exception paramRecyclerView)
    {
      QLog.e(TAG, 1, "scrollToPosWithOffset exception:" + paramRecyclerView.toString() + lY());
    }
  }
  
  public void a(oyu paramoyu, QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_a_of_type_Oyu = paramoyu;
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
  }
  
  public void a(rxk paramrxk)
  {
    this.jdField_a_of_type_Rxk = paramrxk;
  }
  
  public void b(owa paramowa)
  {
    this.jdField_a_of_type_Owa = paramowa;
  }
  
  public void bhT()
  {
    QLog.d(TAG, 1, "onPageUnSelected unique tabkey:" + lY());
    if (this.jdField_a_of_type_Ovg != null) {
      this.jdField_a_of_type_Ovg.bhT();
    }
  }
  
  public void biL()
  {
    if ((!this.mHasInit) && (!getUserVisibleHint()))
    {
      QLog.d(TAG, 4, "tryLazyLoadTab hasInit:" + this.mHasInit);
      this.mHasInit = true;
      biN();
      initViewData();
    }
  }
  
  protected void biN()
  {
    this.b = ((pdy)a(lY(), pdy.class));
    this.b.qC(lZ());
    this.b.l().observe(this, new ozy(this));
    this.b.b(this.jdField_a_of_type_Owa);
  }
  
  protected void biO() {}
  
  public void biP()
  {
    QLog.d(TAG, 1, "scrollToTopAndRefresh" + lY());
    try
    {
      this.jdField_a_of_type_Rxj.a().getBlockMerger().bxp();
      return;
    }
    catch (Exception localException)
    {
      QLog.d(TAG, 1, "scrollToTopAndRefresh exception:" + localException.toString() + lY());
    }
  }
  
  public List<rxk> bw()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Rxj = new rxj(2131365507, by(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Rxj);
    this.jdField_a_of_type_Oxh = new oxh();
    localArrayList.add(this.jdField_a_of_type_Oxh);
    dE(localArrayList);
    return localArrayList;
  }
  
  protected List<rxq> bx()
  {
    return null;
  }
  
  protected List<rxq> by()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Ovg = new ovg(new Bundle());
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    if (a() != null)
    {
      localExtraTypeInfo.pageType = a().getSource();
      this.jdField_a_of_type_Ovg.setExtraTypeInfo(localExtraTypeInfo);
    }
    this.jdField_a_of_type_Ovg.setInteractor(a());
    this.jdField_a_of_type_Ovg.re(arP.equals(lZ()));
    this.jdField_a_of_type_Ovg.setOnLoadDataDelegate(new ozw(this));
    if (bx() != null) {
      localArrayList.addAll(bx());
    }
    localArrayList.add(this.jdField_a_of_type_Ovg);
    return localArrayList;
  }
  
  public void c(owa paramowa)
  {
    this.jdField_a_of_type_Owa = paramowa;
    if (this.mHasInit)
    {
      if (this.b != null) {
        this.b.b(this.jdField_a_of_type_Owa);
      }
      refreshData(false);
    }
  }
  
  protected void dE(List<rxk> paramList) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Rxj.a().setEnableRefresh(true);
    this.jdField_a_of_type_Rxj.a().setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = this.jdField_a_of_type_Rxj.a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560912;
  }
  
  public void h(pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    int j = 0;
    if (parampel == null)
    {
      QLog.e(TAG, 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    boolean bool = parampel.HU();
    int i = j;
    switch (parampel.getState())
    {
    default: 
      i = j;
    }
    while ((i != 0) && (this.jdField_a_of_type_Ovg != null))
    {
      this.jdField_a_of_type_Ovg.notifyLoadingComplete(true, bool);
      return;
      QLog.e(TAG, 1, "handleFeedDataRsp() return empty");
      if ((parampel.HV()) && (this.jdField_a_of_type_Ovg != null) && (this.jdField_a_of_type_Ovg.getItemCount() > 0))
      {
        this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
        i = 1;
      }
      else
      {
        if ((this.jdField_a_of_type_Ovg != null) && (!this.jdField_a_of_type_Ovg.HC()))
        {
          if (!HH()) {
            break label190;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131720624), 1).show();
        }
        for (;;)
        {
          i = 1;
          break;
          label190:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.bkX();
          }
        }
        if (parampel.getMsg() == null) {}
        for (parampel = acfp.m(2131720624);; parampel = parampel.getMsg())
        {
          QLog.e(TAG, 1, "handleFeedDataRsp() return error！errMsg:" + parampel);
          if ((this.jdField_a_of_type_Ovg == null) || (this.jdField_a_of_type_Ovg.HC())) {
            break label492;
          }
          if (!HH()) {
            break label298;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, parampel, 1).show();
          i = 1;
          break;
        }
        label298:
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.qI(parampel);
          i = 1;
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.bkV();
          }
          if (this.jdField_a_of_type_Ovg != null)
          {
            if (parampel.HV()) {
              this.jdField_a_of_type_Ovg.addAll((List)parampel.getData());
            }
            for (;;)
            {
              this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
              biM();
              i = 1;
              break;
              this.jdField_a_of_type_Ovg.setDatas((ArrayList)parampel.getData());
              if (arP.equals(lZ())) {
                this.jdField_a_of_type_Ovg.bhS();
              }
            }
            if (this.jdField_a_of_type_Ovg != null)
            {
              this.jdField_a_of_type_Ovg.setDatas((ArrayList)parampel.getData());
              if (arP.equals(lZ())) {
                this.jdField_a_of_type_Ovg.bhS();
              }
              this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
              dF(parampel.getPos(), parampel.getTop());
              biM();
              i = 1;
              continue;
            }
          }
        }
        label492:
        i = 1;
      }
    }
  }
  
  protected void initViewData()
  {
    if (!this.b.HT())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "initViewData without page cache" + lY());
      refreshData(true);
      return;
    }
    biO();
    QLog.d("QCircleFolderCacheHelper", 1, "initViewData with page cache" + lY());
  }
  
  public String lY()
  {
    return lZ() + "_" + this.mIndex;
  }
  
  public abstract String lZ();
  
  public void loadMore()
  {
    if (this.b != null) {
      this.b.loadMore();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.mUin = getActivity().app.getAccount();
    }
  }
  
  public void onDestroyView()
  {
    int j = 0;
    QLog.d(TAG, 1, "onDestroyView" + lY());
    super.onDestroyView();
    for (;;)
    {
      try
      {
        if ((this.b != null) && (this.jdField_a_of_type_Rxj.a() != null) && (this.jdField_a_of_type_Rxj.a().a() != null))
        {
          Object localObject1 = this.jdField_a_of_type_Rxj.a().a();
          Object localObject2 = this.jdField_a_of_type_Rxj.a().a().getLayoutManager();
          if ((localObject2 instanceof rxy))
          {
            localObject2 = (rxy)localObject2;
            localObject1 = ((RecyclerView)localObject1).getChildAt(0);
            if (localObject1 == null) {
              break label159;
            }
            j = ((rxy)localObject2).getPosition((View)localObject1);
            i = ((View)localObject1).getTop();
            this.b.dG(this.jdField_a_of_type_Ovg.bs());
            this.b.dJ(j, i);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label159:
      int i = 0;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.b != null)
    {
      this.b.l().removeObservers(this);
      this.b = null;
    }
    if (this.jdField_a_of_type_Oyu != null)
    {
      this.jdField_a_of_type_Oyu.recycle();
      this.jdField_a_of_type_Oyu = null;
    }
    QLog.d(TAG, 1, "onDetach()" + lY());
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      L(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollLRFlag(false);
      }
      QLog.d(TAG, 1, "onPageSelected unique tabkey:" + lY());
      if (this.jdField_a_of_type_Ovg != null) {
        this.jdField_a_of_type_Ovg.onPageSelected(paramInt);
      }
      return;
    }
  }
  
  public void refreshData(boolean paramBoolean)
  {
    biO();
    if (this.b != null) {
      this.b.refreshData(paramBoolean);
    }
  }
  
  public void scrollToTop()
  {
    QLog.d(TAG, 1, "scrollToTop" + lY());
    try
    {
      this.jdField_a_of_type_Rxj.a().a().scrollToPosition(0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(TAG, 1, "scrollToTop exception:" + localException.toString() + lY());
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (!this.mHasInit))
    {
      this.mHasInit = true;
      biN();
      initViewData();
    }
    QLog.d(TAG, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */