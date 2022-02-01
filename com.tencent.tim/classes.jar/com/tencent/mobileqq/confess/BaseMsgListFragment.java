package com.tencent.mobileqq.confess;

import aajb;
import aajg;
import acbn;
import acfd;
import acfp;
import aegm;
import aegn;
import afcp;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqgw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import ton;
import top;

public class BaseMsgListFragment
  extends IphoneTitleBarFragment
  implements aajb, afcp, Handler.Callback, DragFrameLayout.c, AbsListView.e, SwipListView.a, Observer
{
  public long VX;
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aegn(this);
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public DragFrameLayout a;
  boolean aey = true;
  FPSSwipListView b;
  public boolean bTI = false;
  public boolean bTJ = false;
  String bwL = "";
  int cMA = -1;
  int cMB;
  public aajg f;
  Map<String, RecentBaseData> jP;
  MqqHandler k;
  protected QQAppInterface mApp;
  protected BaseActivity mContext;
  public View mFooterView;
  public boolean mHasMore = false;
  LinearLayout mHeaderView;
  int mScrollState = 0;
  MqqHandler mUIHandler;
  final acfd n = new aegm(this);
  final List<RecentBaseData> yR = new LinkedList();
  List<MessageRecord> yS;
  public List<RecentBaseData> yT;
  
  private TopGestureLayout b()
  {
    ViewGroup localViewGroup = (ViewGroup)this.mContext.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  public void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public boolean Pr()
  {
    return (this.mScrollState != 0) && (this.mScrollState != 1);
  }
  
  public boolean X(String paramString, int paramInt)
  {
    try
    {
      Iterator localIterator = this.yT.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData != null)
        {
          boolean bool = TextUtils.equals(localRecentBaseData.qx(), paramString);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      return false;
    }
    return false;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1)
    {
      cWP();
      aQ();
    }
  }
  
  protected void aQ()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null)) {}
    TextView localTextView;
    do
    {
      return;
      this.leftView.setVisibility(0);
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localTextView = this.leftView;
      localObject = this.mApp.b();
    } while (localObject == null);
    int i = ((QQMessageFacade)localObject).bl();
    Object localObject = acfp.m(2131703139);
    if (i > 99)
    {
      String.format(Locale.getDefault(), "%s(99+)", new Object[] { acfp.m(2131703142) });
      localObject = String.format(Locale.getDefault(), acfp.m(2131703137), new Object[] { acfp.m(2131703140) });
    }
    for (;;)
    {
      localTextView.setContentDescription((CharSequence)localObject);
      return;
      if (i <= 0)
      {
        acfp.m(2131703144);
      }
      else
      {
        String.format(Locale.getDefault(), "%s(%s)", new Object[] { acfp.m(2131703141), Integer.valueOf(i) });
        localObject = String.format(Locale.getDefault(), acfp.m(2131703138), new Object[] { Integer.valueOf(i), acfp.m(2131703143) });
      }
    }
  }
  
  protected List<RecentBaseData> aV(List<MessageRecord> paramList)
  {
    return null;
  }
  
  public RecentBaseData c()
  {
    RecentBaseData localRecentBaseData = null;
    synchronized (this.yR)
    {
      if (this.yR.size() > 0) {
        localRecentBaseData = (RecentBaseData)this.yR.remove(0);
      }
      return localRecentBaseData;
    }
  }
  
  public void cWP()
  {
    if (this.k != null)
    {
      this.k.removeMessages(0);
      this.k.sendEmptyMessage(0);
    }
  }
  
  public void cWQ() {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    this.b = ((FPSSwipListView)this.mContentView.findViewById(2131370573));
    try
    {
      this.b.setBackgroundResource(2130838900);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      this.mHeaderView = new LinearLayout(this.mContext);
      this.mHeaderView.setOrientation(1);
      this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.b.addHeaderView(this.mHeaderView, 0);
      this.mFooterView = paramLayoutInflater.inflate(2131559027, null);
      this.mFooterView.setVisibility(8);
      this.b.addFooterView(this.mFooterView);
      this.b.setRightIconMenuListener(this);
      this.b.setOnScrollListener(this);
      this.f = new aajg(this.mContext, this.mApp, this.b, this, 11);
      this.f.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.b.setAdapter(this.f);
      this.f.FX(16);
      this.k = new aqgw(ThreadManager.getSubThreadLooper(), this);
      this.mUIHandler = new aqgw(this.mContext.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jP = new ConcurrentHashMap();
      this.yT = new ArrayList();
      this.mApp.addObserver(this.n, true);
      this.mApp.b().addObserver(this);
      if (QLog.isColorLevel()) {
        this.VX = System.currentTimeMillis();
      }
      return;
    }
    catch (Throwable paramViewGroup)
    {
      for (;;)
      {
        QLog.e("BaseMsgListFragment", 1, paramViewGroup, new Object[0]);
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561273;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 50;
    long l;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l = System.currentTimeMillis();
      this.yS = this.mApp.a(this.cMA).g(this.bwL, this.cMA);
      if (this.yS == null) {
        this.yS = new ArrayList();
      }
      jM(this.yS);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      if (this.yS == null)
      {
        i = 0;
        if (i > 50) {
          break label304;
        }
        j = i;
        label142:
        if ((this.cMB <= j) || (this.cMB > i)) {
          break label522;
        }
        j = this.cMB;
      }
      break;
    }
    label517:
    label522:
    for (;;)
    {
      if (j > 50)
      {
        this.mHasMore = true;
        label174:
        if (QLog.isColorLevel()) {
          QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.cMB) }));
        }
        LinkedList localLinkedList = new LinkedList();
        paramMessage = localLinkedList;
        if (this.yS != null)
        {
          paramMessage = localLinkedList;
          if (i > 0) {
            paramMessage = this.yS.subList(0, j);
          }
        }
        paramMessage = aV(paramMessage);
        if (paramMessage == null) {
          break label318;
        }
      }
      label304:
      label318:
      for (i = paramMessage.size();; i = 0)
      {
        this.cMB = i;
        jL(paramMessage);
        return false;
        i = this.yS.size();
        break;
        j = 50;
        break label142;
        this.mHasMore = false;
        break label174;
      }
      l = System.currentTimeMillis();
      if ((this.cMB > 0) && (this.yS != null))
      {
        int m = this.cMB;
        int i1 = this.yS.size();
        j = i1 - this.cMB;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label507;
        }
        this.mHasMore = true;
        label382:
        if (QLog.isColorLevel()) {
          QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i) }));
        }
        paramMessage = aV(this.yS.subList(0, m - 1 + 1 + i));
        if (paramMessage == null) {
          break label517;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.cMB = i;
        jL(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
        label507:
        this.mHasMore = false;
        i = j;
        break label382;
      }
    }
  }
  
  protected void jL(List<RecentBaseData> paramList)
  {
    if (this.mUIHandler != null)
    {
      synchronized (this.yR)
      {
        Iterator localIterator = this.yT.iterator();
        while (localIterator.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
          if (localRecentBaseData != null) {
            this.yR.add(localRecentBaseData);
          }
        }
      }
      this.yT.clear();
      if (paramList != null) {
        this.yT.addAll(paramList);
      }
      paramList = new Message();
      paramList.what = 0;
      this.mUIHandler.removeMessages(0);
      this.mUIHandler.sendMessage(paramList);
      this.bTJ = false;
    }
  }
  
  protected void jM(List<MessageRecord> paramList) {}
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    this.mApp = ((QQAppInterface)this.mContext.getAppInterface());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.cMA = paramBundle.getInt("uintype", -1);
      this.bwL = paramBundle.getString("uin", "");
    }
    if (!top.x(this.bwL, this.cMA))
    {
      this.cMA = 1032;
      this.bwL = acbn.blK;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("BaseMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.cMA), this.bwL }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.k.removeCallbacksAndMessages(null);
    this.mUIHandler.removeCallbacksAndMessages(null);
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.n);
      if (this.mApp.b() != null) {
        this.mApp.b().deleteObserver(this);
      }
    }
    if (this.f != null) {
      this.f.onDestory();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    cWP();
    aQ();
    this.mScrollState = 0;
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramAbsListView.getCount() - 1 == paramAbsListView.getLastVisiblePosition()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.f.Cq(false);
      }
      for (;;)
      {
        this.mScrollState = paramInt;
        if ((paramInt == 0) && (this.bTJ) && (this.k != null))
        {
          this.k.removeMessages(0);
          this.k.sendEmptyMessage(0);
        }
        if ((i == 0) || (this.k == null)) {
          break;
        }
        this.k.sendEmptyMessage(1);
        return;
        this.f.Cq(true);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollRLFlag(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (getActivity() == null) {
      return;
    }
    getActivity().runOnUiThread(new BaseMsgListFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment
 * JD-Core Version:    0.7.0.1
 */