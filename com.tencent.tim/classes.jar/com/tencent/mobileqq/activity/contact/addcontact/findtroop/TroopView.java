package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import acms;
import acnd;
import amxk;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import anwa;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.b;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import wja;
import ypn;
import ypn.a;
import ypq;
import ypq.a;
import ypq.c;
import ypz;
import yqa;
import yqb;
import yqc;
import yqd;
import yqe;
import yqf;
import yqg;
import yqh;
import yqi;
import yqj;
import yqk;
import zbi;

public class TroopView
  extends ContactBaseView
{
  TextView Ls;
  private ProgressBar S;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$a;
  public b a;
  private ContactsBaseFragment.b jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$b = new yqe(this);
  private ContactsViewPager jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
  private ContactsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
  SimpleCheckableSlidingIndicator.a jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$a = new yqd(this);
  private SimpleCheckableSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator;
  private SimpleSlidingIndicator.b jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$b = new yqf(this);
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private zbi jdField_a_of_type_Zbi = new yqg(this);
  EditText ay;
  private acnd jdField_b_of_type_Acnd = new yqc(this);
  private HeaderScrollView jdField_b_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  ypq.c jdField_b_of_type_Ypq$c = new ypz(this);
  private ypq jdField_b_of_type_Ypq = new ypq(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity(), this.sV, this.jdField_b_of_type_Ypq$c);
  private FrameLayout bh;
  private boolean boe;
  Rect bp = new Rect();
  private int caD;
  private int caE = -1;
  Button ei;
  public List<ypn> sV = new ArrayList();
  private RecyclerView v;
  
  public TroopView(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  private void Ax(boolean paramBoolean)
  {
    hideLoading();
    if (!paramBoolean) {
      ba(1, 2131720480);
    }
  }
  
  private void Et(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt);
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.fZ(paramInt, this.caE);
    this.jdField_b_of_type_Ypq.Es(paramInt);
    this.v.smoothScrollToPosition(paramInt);
    this.caD = paramInt;
    Object localObject1 = (ypn)this.sV.get(paramInt);
    Object localObject2;
    Object localObject3;
    ypn localypn;
    if (((ypn)localObject1).re != null)
    {
      int j = ((ypn)localObject1).re.size();
      if (j > 0)
      {
        localObject2 = new String[j];
        localObject3 = new int[j];
        int i = 0;
        while (i < j)
        {
          localObject2[i] = ((ypn.a)((ypn)localObject1).re.get(i)).tagName;
          localObject3[i] = i;
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setTabData((String[])localObject2, (int[])localObject3);
        this.bh.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new yqh(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setCurrentPosition(((ypn)localObject1).caz, false);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt + " currentClassifyPos:" + i);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(i, false);
        if (localObject2 != null)
        {
          localObject3 = (AddContactViewPagerTroopFragment)localObject2;
          localypn = (ypn)this.sV.get(i);
          localObject2 = localypn.keyword;
          if (((ypn)localObject1).caz < 0) {
            break label385;
          }
          localObject2 = ((ypn.a)localypn.re.get(((ypn)localObject1).caz)).keyword;
        }
      }
    }
    label385:
    for (localObject1 = ((ypn.a)localypn.re.get(((ypn)localObject1).caz)).tagName;; localObject1 = "")
    {
      ((AddContactViewPagerTroopFragment)localObject3).dK((String)localObject2, (String)localObject1);
      return;
      this.bh.setVisibility(8);
      return;
      this.bh.setVisibility(8);
      return;
    }
  }
  
  private TopGestureLayout b()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity().getWindow().getDecorView();
    View localView = localViewGroup2.getChildAt(0);
    ViewGroup localViewGroup1 = localViewGroup2;
    if (localView != null)
    {
      localViewGroup1 = localViewGroup2;
      if ((localView instanceof ViewGroup)) {
        localViewGroup1 = (ViewGroup)localView;
      }
    }
    if ((localViewGroup1 instanceof TopGestureLayout)) {
      return (TopGestureLayout)localViewGroup1;
    }
    return null;
  }
  
  private void ba(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.mContext).isResume()) {
      QQToast.a(this.mContext, paramInt1, getResources().getString(paramInt2), 0).show(((BaseActivity)this.mContext).getTitleBarHeight());
    }
  }
  
  private void ckG()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.getHitRect(this.bp);
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.E();
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.I();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
    ypn localypn = (ypn)this.sV.get(i);
    i = 0;
    if (i < arrayOfString.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.findViewById(arrayOfInt[i]).getLocalVisibleRect(this.bp))
      {
        anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_exp", 0, 0, arrayOfString[i], localypn.itemName, "", "");
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,visible:" + arrayOfString[i] + "," + localypn.itemName);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,not visible:" + arrayOfString[i]);
        }
      }
    }
  }
  
  private void ckH()
  {
    showLoading();
    if (aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      localObject = (acms)this.app.getBusinessHandler(20);
      if (localObject != null) {
        ((acms)localObject).cME();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "initData falied. network unavailable");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$a.obtainMessage(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$a.sendMessageDelayed((Message)localObject, 1000L);
  }
  
  private void ckI()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private long ek()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void hideLoading()
  {
    this.S.setVisibility(8);
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator = ((SimpleCheckableSlidingIndicator)findViewById(2131378499));
    int j = Color.parseColor("#F5F6FA");
    int i = getResources().getColor(2131167304);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      j = Color.parseColor("#282828");
      i = getResources().getColor(2131167461);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setIndicatorColor(j);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setCheckedTextColor(i);
    this.bh = ((FrameLayout)findViewById(2131369150));
    this.bh.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)findViewById(2131365258));
    this.ei = ((Button)findViewById(2131363801));
    this.ei.setVisibility(8);
    this.Ls = ((TextView)findViewById(2131380917));
    this.ay = ((EditText)findViewById(2131366542));
    this.ay.setFocusableInTouchMode(false);
    this.ay.setCursorVisible(false);
    this.v = ((RecyclerView)findViewById(2131376996));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.v.setLayoutManager((RecyclerView.LayoutManager)localObject);
    i = wja.dp2px(6.0F, getResources());
    j = wja.dp2px(16.0F, getResources());
    this.v.addItemDecoration(new ypq.a(i, j));
    if (!anwa.aze()) {
      this.v.setAdapter(this.jdField_b_of_type_Ypq);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager = ((ContactsViewPager)findViewById(2131365261));
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter = new AddContactFindTroopViewPagerAdapter(((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity()).getSupportFragmentManager(), this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getApp(), (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity(), (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOnPageChangeListener(new yqi(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setOnTabListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setOnRepeatClickListener(new yqj(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setScrollViewListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$a);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)findViewById(2131379046));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131379044));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new yqk(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this.jdField_a_of_type_Zbi);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setTopOffset(wja.dp2px(5.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setOnScrollListener(new yqa(this));
    this.ay.setOnClickListener(new yqb(this));
    this.Ls.setText(2131710383);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = b();
  }
  
  private void showLoading()
  {
    this.S.setVisibility(0);
  }
  
  public void onCreate()
  {
    super.onCreate();
    super.setContentView(2131560046);
    this.S = ((ProgressBar)findViewById(2131370811));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$a = new a(this);
    this.app.addObserver(this.jdField_b_of_type_Acnd);
    ckH();
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onDestroy");
    }
    this.app.removeObserver(this.jdField_b_of_type_Acnd);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.doOnDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    amxk.d("add_page", "search_grp", "exp", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void setNavStickyListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$b = paramb;
  }
  
  public static class a
    extends Handler
  {
    public WeakReference<TroopView> mWeakReference;
    
    public a(TroopView paramTroopView)
    {
      this.mWeakReference = new WeakReference(paramTroopView);
    }
    
    public void ckK()
    {
      TroopView localTroopView = (TroopView)this.mWeakReference.get();
      if (localTroopView == null) {}
      do
      {
        return;
        if (TroopView.a(localTroopView) != null) {
          TroopView.a(localTroopView).setRefreshing(false);
        }
      } while (TroopView.a(localTroopView) == null);
      TroopView.a(localTroopView).setRefresh(false);
    }
    
    public void handleMessage(Message paramMessage)
    {
      TroopView localTroopView = (TroopView)this.mWeakReference.get();
      if (localTroopView == null) {
        return;
      }
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        TroopView.c(localTroopView);
        TroopView.a(localTroopView, 1, 2131696272);
        return;
      case 4: 
        TroopView.a(localTroopView, true);
        return;
      case 5: 
        TroopView.a(localTroopView, false);
        return;
      case 13: 
        TroopView.a(localTroopView, 1, 2131696272);
        ckK();
        return;
      case 14: 
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label178;
          }
          TroopView.d(localTroopView);
          if (TroopView.a(localTroopView) == null) {
            break;
          }
          TroopView.a(localTroopView).tT(0);
          TroopView.a(localTroopView).sendEmptyMessageDelayed(15, 800L);
          return;
        }
        label178:
        ckK();
        TroopView.a(localTroopView, 1, 2131720480);
        return;
      }
      ckK();
    }
  }
  
  public static abstract interface b
  {
    public abstract void Ay(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView
 * JD-Core Version:    0.7.0.1
 */