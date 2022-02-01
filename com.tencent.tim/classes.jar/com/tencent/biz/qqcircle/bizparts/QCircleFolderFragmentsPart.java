package com.tencent.biz.qqcircle.bizparts;

import acfp;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ouq;
import owa;
import owg;
import owh;
import owi;
import owj;
import oyu;
import ozu;
import pco;
import peh;
import pel;
import qqcircle.QQCircleFeedBase.StTabInfo;
import rwv;
import rwx;
import rxk;
import ryo;

public class QCircleFolderFragmentsPart
  extends rxk
  implements TabLayoutCompat.b, rwx
{
  private FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private oyu jdField_a_of_type_Oyu;
  private peh jdField_a_of_type_Peh;
  private boolean ayP;
  private int bgw = -1;
  private int bgx;
  private ArrayList<QCircleBaseTabFragment> cg = new ArrayList();
  private ViewPagerCompat d;
  private TabLayoutCompat e;
  private ArrayList<String> mp = new ArrayList();
  private ViewStub w;
  private long zm = 300L;
  
  private void a(owa paramowa)
  {
    Object localObject = null;
    switch (paramowa.getType())
    {
    }
    while (localObject != null)
    {
      ((QCircleBaseTabFragment)localObject).b(paramowa);
      ((QCircleBaseTabFragment)localObject).a(this.jdField_a_of_type_Oyu, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
      ((QCircleBaseTabFragment)localObject).a(this);
      this.cg.add(localObject);
      this.mp.add(paramowa.getName());
      return;
      localObject = new QCircleFolderFollowTabFragment();
      continue;
      localObject = new QCircleFolderRcmdTabFragment();
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(pel<List<QQCircleFeedBase.StTabInfo>> parampel)
  {
    boolean bool = true;
    if (parampel == null) {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return unexpected data！");
    }
    do
    {
      return;
      switch (parampel.getState())
      {
      case 1: 
      default: 
        return;
      case 0: 
        QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return empty data!");
      }
    } while ((this.cg == null) || (this.cg.size() != 0) || (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.showErrorView(null);
    return;
    if (parampel.getMsg() == null) {}
    for (parampel = acfp.m(2131720624);; parampel = parampel.getMsg())
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return error！errMsg:" + parampel);
      if ((this.cg == null) || (this.cg.size() != 0)) {
        break label186;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, parampel, 1).show();
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.showErrorView(parampel);
      return;
    }
    label186:
    QQToast.a(BaseApplicationImpl.getContext(), 1, parampel, 1).show();
    return;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.bkV();
    }
    List localList = (List)parampel.getData();
    if (parampel.getState() == 2) {}
    for (;;)
    {
      u(localList, bool);
      return;
      bool = false;
    }
  }
  
  private void dE(int paramInt1, int paramInt2)
  {
    int i = 23;
    if (!this.ayP)
    {
      this.ayP = true;
      return;
    }
    if ((this.cg != null) && (this.cg.size() > paramInt1))
    {
      owa localowa = ((QCircleBaseTabFragment)this.cg.get(paramInt1)).a();
      if (localowa == null) {
        break label160;
      }
      if (localowa.getType() != 1) {
        break label98;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 == 1) {
        if (paramInt1 != 0)
        {
          if (paramInt1 == 0) {
            break label109;
          }
          l = 3L;
          pco.h("", i, l);
        }
      }
      label98:
      label109:
      while (paramInt2 != 2) {
        for (;;)
        {
          this.ayP = false;
          return;
          paramInt1 = 0;
          break;
          i = 22;
          continue;
          l = 9L;
        }
      }
      if (paramInt1 != 0) {
        label126:
        if (paramInt1 == 0) {
          break label152;
        }
      }
      label152:
      for (long l = 2L;; l = 11L)
      {
        pco.h("", i, l);
        break;
        i = 22;
        break label126;
      }
      label160:
      paramInt1 = 0;
    }
  }
  
  private void sF()
  {
    this.jdField_a_of_type_Peh = ((peh)getViewModel(peh.class));
    this.jdField_a_of_type_Peh.r().observe(b(), new owi(this));
    if (!this.jdField_a_of_type_Peh.HT())
    {
      QLog.d("QCircleFolderCacheHelper", 4, "initTabs without tab cache");
      if (ryo.exists("2002"))
      {
        QLog.i("QCircleFolderFragmentsPart", 1, "runPreload");
        ryo.a("2002", new owj(this));
        return;
      }
      this.jdField_a_of_type_Peh.a(ouq.a().a());
      return;
    }
    QLog.d("QCircleFolderCacheHelper", 4, "initTabs with tab cache");
  }
  
  private void u(List<QQCircleFeedBase.StTabInfo> paramList, boolean paramBoolean)
  {
    QLog.d("QCircleFolderFragmentsPart", 1, "initTabDatasFromServer isFromCache:" + paramBoolean);
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "initTabDatasFromServer invalid input data!");
      return;
    }
    if (paramList.size() > 4)
    {
      this.e.setTabMode(0);
      this.e.setTabGravity(1);
      this.e.setScrollableTabMinWidth(-2);
      if (this.cg.size() <= 0) {
        break label161;
      }
      if (!y(paramList))
      {
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment failed!refresh all!");
        this.mp.clear();
        this.cg.clear();
        u(paramList, paramBoolean);
      }
    }
    for (;;)
    {
      j(this.bgw, false, false);
      return;
      this.e.setTabMode(1);
      this.e.setTabGravity(1);
      break;
      label161:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
        if (localStTabInfo != null) {
          a(owa.a(localStTabInfo).a(paramBoolean));
        }
      }
      this.e.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
    }
  }
  
  private boolean y(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    try
    {
      if ((QzoneConfig.getQQCircleEnableReuseFragment()) && (paramList.size() == this.cg.size()) && (paramList.size() == this.mp.size()))
      {
        int i = 0;
        while (i < paramList.size())
        {
          QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.get(i);
          QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.cg.get(i);
          if (!((String)this.mp.get(i)).equals(localStTabInfo.tabName.get())) {
            return false;
          }
          if (localStTabInfo.tabType.get() != localQCircleBaseTabFragment.a().a.tabType.get()) {
            return false;
          }
          localQCircleBaseTabFragment.c(owa.a(localStTabInfo).a(false));
          i += 1;
        }
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment success!");
        return true;
      }
      return false;
    }
    catch (Exception paramList) {}
    return false;
  }
  
  public void a(TabLayoutCompat.d paramd)
  {
    this.bgx = paramd.getPosition();
  }
  
  public void b(TabLayoutCompat.d paramd)
  {
    ((QCircleBaseTabFragment)this.cg.get(paramd.getPosition())).bhT();
  }
  
  public void c(TabLayoutCompat.d paramd)
  {
    if (paramd.getPosition() == this.bgx) {
      ((QCircleBaseTabFragment)this.cg.get(this.bgx)).biP();
    }
  }
  
  public void dC(View paramView)
  {
    this.e = ((TabLayoutCompat)paramView.findViewById(2131373905));
    this.e.setTabTextColors(-16777216, -16777216);
    this.e.setTabMode(1);
    this.e.setTabGravity(1);
    this.e.setSelectedTabIndicatorHeight(0);
    this.e.setViewPagerTabEventListener(new owg(this));
    this.d = ((ViewPagerCompat)paramView.findViewById(2131373910));
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter = new FolderTabFragmentAdapter(((FragmentActivity)getActivity()).getSupportFragmentManager());
    this.d.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter);
    this.d.setOffscreenPageLimit(3);
    this.e.setupWithViewPager(this.d);
    this.e.a(this);
    this.d.addOnPageChangeListener(new owh(this));
    this.w = ((ViewStub)paramView.findViewById(2131374506));
    this.jdField_a_of_type_Oyu = new oyu(getActivity());
    this.jdField_a_of_type_Oyu.a(getActivity(), this.w);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = ((QCirclePolymorphicAniView)paramView.findViewById(2131374561));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)paramView.findViewById(2131374595));
    sF();
    ViewCompat.setPaddingRelative(this.e, 0, 0, 0, 0);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSelectTabEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return "QCircleFolderFragmentsPart";
  }
  
  public void j(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramInt > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.cg.size())
      {
        QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.cg.get(i);
        if ((localQCircleBaseTabFragment == null) || (localQCircleBaseTabFragment.a() == null) || (paramInt != localQCircleBaseTabFragment.a().getType()) || (this.d == null)) {
          break label85;
        }
        this.d.setCurrentItem(i, paramBoolean1);
        if (paramBoolean2) {
          localQCircleBaseTabFragment.scrollToTop();
        }
      }
      return;
      label85:
      i += 1;
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    rwv.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    ozu.a().a(this.jdField_a_of_type_Peh);
    rwv.a().b(this);
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Oyu != null) && (this.jdField_a_of_type_Oyu.onBackPress())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
    {
      int i = ((QCircleSelectTabEvent)paramSimpleBaseEvent).tabType;
      boolean bool = ((QCircleSelectTabEvent)paramSimpleBaseEvent).needScrollTop;
      ThreadManager.getUIHandler().post(new QCircleFolderFragmentsPart.5(this, i, bool));
    }
  }
  
  public void ve(int paramInt)
  {
    this.bgw = paramInt;
  }
  
  public class FolderTabFragmentAdapter
    extends FragmentPagerAdapter
  {
    public FolderTabFragmentAdapter(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return QCircleFolderFragmentsPart.a(QCircleFolderFragmentsPart.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)QCircleFolderFragmentsPart.a(QCircleFolderFragmentsPart.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(QCircleFolderFragmentsPart.this).get(paramInt)).hashCode();
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public CharSequence getPageTitle(int paramInt)
    {
      return (CharSequence)QCircleFolderFragmentsPart.b(QCircleFolderFragmentsPart.this).get(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart
 * JD-Core Version:    0.7.0.1
 */