package com.tencent.mobileqq.dating;

import aajb;
import aajg;
import aalb;
import acbn;
import acfd;
import acff;
import afcb;
import afcc;
import afcd;
import afcp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqgv;
import aqgw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tog;
import ton;
import top;

public class BaseMsgBoxActivity
  extends IphoneTitleBarActivity
  implements aajb, afcp, Handler.Callback, DragFrameLayout.c, AbsListView.e, SwipListView.a, Observer
{
  View BA;
  public View BB;
  public ViewStub F;
  TextView Rr;
  public long VX;
  acfd jdField_a_of_type_Acfd = new afcb(this);
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afcd(this);
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public DragFrameLayout a;
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  FPSSwipListView b;
  String bCR = "";
  String bCS = "";
  public int bIx = -1;
  public boolean bTI = false;
  public boolean bTJ = false;
  boolean bXf = false;
  public boolean bXg;
  public String bwL = "";
  public int cMA = -1;
  private int cMB;
  public int cQa = -1;
  public aajg f;
  private Runnable gp = new BaseMsgBoxActivity.6(this);
  public boolean isFromNearby;
  public Map<String, RecentBaseData> jP;
  public MqqHandler k;
  public View mFooterView;
  private boolean mHasMore;
  private int mScrollState = 0;
  public MqqHandler mUIHandler;
  ArrayList<NearbyActivity.TabInfo> mg = new ArrayList();
  public RedTouch s;
  private List<MessageRecord> yS;
  public List<RecentBaseData> yT;
  ImageView yy;
  
  private TopGestureLayout b()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
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
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    this.app.b().ca(paramRecentBaseData.qx(), this.cMA);
    paramView = paramRecentBaseData.qx();
    if (top.gR(paramView))
    {
      paramRecentBaseData = new Intent(this, SayHelloMsgListActivity.class);
      paramRecentBaseData.putExtra("uin", paramView);
      paramRecentBaseData.putExtra("uintype", this.cMA);
      startActivity(paramRecentBaseData);
      if (this.isFromNearby) {}
      for (paramView = "1";; paramView = "0")
      {
        anot.a(this.app, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_say_hi", 0, 0, "", "", paramView, "");
        return;
      }
    }
    paramString = (acff)this.app.getManager(51);
    if (paramString != null) {}
    for (paramBoolean = paramString.isFriend(paramView);; paramBoolean = false)
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramView);
      if (paramBoolean)
      {
        localIntent.putExtra("uintype", 0);
        paramString = aqgv.G(this.app, paramRecentBaseData.qx());
        paramView = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramView = aqgv.b(this.app, paramRecentBaseData.qx(), false);
        }
        localIntent.putExtra("uinname", paramView);
        startActivity(localIntent);
        if (!this.isFromNearby) {
          break label352;
        }
        paramView = "1";
        label231:
        if (!(paramRecentBaseData instanceof RecentSayHelloListItem)) {
          break label364;
        }
        paramString = (RecentSayHelloListItem)paramRecentBaseData;
        if (paramString.commonId > 0) {
          anot.a(this.app, "CliOper", "", "", "0X8005DEF", "0X8005DEF", paramString.commonId, 0, "", "", "", "");
        }
        paramString = this.app;
        if (paramRecentBaseData.ng() != 1001) {
          break label358;
        }
      }
      label352:
      label358:
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        anot.a(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "1", paramView, "");
        return;
        localIntent.putExtra("uintype", paramRecentBaseData.ng());
        localIntent.putExtra("NEARBY_MSG_REPORT_SOURCE", "4");
        break;
        paramView = "0";
        break label231;
      }
      label364:
      paramString = this.app;
      if (paramRecentBaseData.ng() == 1001) {}
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        anot.a(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_aio", 0, 0, paramRecentBaseData, "0", paramView, "");
        return;
      }
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      int i = this.app.a().A(paramRecentBaseData.qx(), paramRecentBaseData.ng());
      this.app.b().c(this.bwL, this.cMA, paramRecentBaseData.qx(), this.app.getCurrentAccountUin());
      if (i > 0)
      {
        if (!top.gR(paramRecentBaseData.qx())) {
          break label175;
        }
        ThreadManager.post(new BaseMsgBoxActivity.3(this, paramRecentBaseData.qx(), paramRecentBaseData.ng()), 8, null, false);
      }
    }
    for (;;)
    {
      if ((acbn.blh.equals(paramRecentBaseData.qx())) || (acbn.blg.equals(paramRecentBaseData.qx())))
      {
        anot.a(this.app, "CliOper", "", "", "0X8005297", "0X8005297", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      return;
      label175:
      this.bCR = (paramRecentBaseData.qx() + "_" + this.cMA);
      aalb.l(this.app, paramRecentBaseData.qx(), this.cMA);
      this.app.b().a(paramRecentBaseData.qx(), this.cMA, true, true);
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1) {
      cWP();
    }
  }
  
  protected List<RecentBaseData> aW(List<MessageRecord> paramList)
  {
    return null;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561429);
    getWindow().setBackgroundDrawable(null);
    paramBundle = getIntent();
    this.cMA = paramBundle.getIntExtra("uintype", -1);
    this.bwL = paramBundle.getStringExtra("uin");
    this.isFromNearby = paramBundle.getBooleanExtra("isFromNearby", false);
    this.cQa = paramBundle.getIntExtra("mUnReadMsgNum", -1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "BOX UIN:" + this.bwL + "|BOX TYPE:" + this.cMA);
    }
    if (!top.x(this.bwL, this.cMA))
    {
      this.bwL = acbn.bkE;
      this.cMA = 1001;
    }
    this.F = ((ViewStub)findViewById(2131374932));
    this.F.setVisibility(0);
    this.b = ((FPSSwipListView)findViewById(2131365617));
    this.BA = findViewById(2131365618);
    this.yy = ((ImageView)this.BA.findViewById(2131365619));
    this.Rr = ((TextView)this.BA.findViewById(2131365620));
    this.BB = findViewById(2131366431);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.mFooterView = getLayoutInflater().inflate(2131559027, null);
    this.b.addFooterView(this.mFooterView);
    this.b.setRightIconMenuListener(this);
    this.b.setOnScrollListener(this);
    if (top.gR(this.bwL))
    {
      this.f = new aajg(this, this.app, this.b, this, 7);
      this.f.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.b.setAdapter(this.f);
      this.k = new aqgw(ThreadManager.getSubThreadLooper(), this);
      this.mUIHandler = new aqgw(getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jP = new ConcurrentHashMap();
      this.yT = new ArrayList();
      this.app.addObserver(this.jdField_a_of_type_Acfd);
      this.app.b().addObserver(this);
      if (QLog.isColorLevel()) {
        this.VX = System.currentTimeMillis();
      }
      if (this.isFromNearby)
      {
        ArrayList localArrayList = (ArrayList)paramBundle.getSerializableExtra("tabs");
        if (localArrayList != null)
        {
          this.mg.clear();
          this.mg.addAll(localArrayList);
        }
        this.bIx = paramBundle.getIntExtra("msgTabIndex", -1);
        if ((this.mg.size() > 0) && (this.bIx >= 0) && (this.bIx < this.mg.size()))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131379139));
          NearbyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.mg);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(new afcc(this));
          findViewById(2131379140).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.bIx, false);
          this.s = NearbyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.mg.size(), this.bIx);
          if (this.cQa >= 0) {
            break label722;
          }
          ThreadManager.getUIHandler().postDelayed(this.gp, 5000L);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "BaseMsgBoxActivity, doOnCreate: msgBoxTabIndex=" + this.bIx + ", count=" + this.mg.size());
      }
      return true;
      this.f = new aajg(this, this.app, this.b, this, 6);
      break;
      label722:
      ThreadManager.getUIHandler().post(this.gp);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.getUIHandler().removeCallbacks(this.gp);
    this.k.removeCallbacksAndMessages(null);
    this.mUIHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_Acfd);
    if ((this.app != null) && (this.app.b() != null)) {
      this.app.b().deleteObserver(this);
    }
    if (this.f != null) {
      this.f.onDestory();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
    if ((this.app != null) && (this.f != null) && ((acbn.bkY.equals(this.bwL)) || (acbn.bkE.equals(this.bwL))))
    {
      QQMessageFacade.Message localMessage = this.app.b().a(this.bwL, this.cMA);
      if (localMessage != null) {
        this.app.a().T(this.cMA, localMessage.time);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    cWP();
    this.mScrollState = 0;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 50;
    long l1;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l1 = System.currentTimeMillis();
      this.yS = this.app.a(this.cMA).g(this.bwL, this.cMA);
      jM(this.yS);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "cloneMsgBoxList cost time: " + (System.currentTimeMillis() - l1));
      }
      if (this.yS == null)
      {
        i = 0;
        if (i > 50) {
          break label292;
        }
        j = i;
        label124:
        if ((this.cMB <= j) || (this.cMB > i)) {
          break label520;
        }
        j = this.cMB;
      }
      break;
    }
    label515:
    label520:
    for (;;)
    {
      if (j > 50)
      {
        this.mHasMore = true;
        label156:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "refresh_list|totalCount:" + i + ",curCount:" + this.cMB + ",loadCount:" + j);
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
        paramMessage = aW(paramMessage);
        if (paramMessage == null) {
          break label306;
        }
      }
      label292:
      label306:
      for (i = paramMessage.size();; i = 0)
      {
        this.cMB = i;
        jL(paramMessage);
        return false;
        i = this.yS.size();
        break;
        j = 50;
        break label124;
        this.mHasMore = false;
        break label156;
      }
      l1 = System.currentTimeMillis();
      if ((this.cMB > 0) && (this.yS != null))
      {
        int m = this.cMB;
        j = this.yS.size() - this.cMB;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label505;
        }
        this.mHasMore = true;
        label366:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "loadNextPageData|totalCount:" + this.yS.size() + ",loadCount:" + i);
        }
        paramMessage = aW(this.yS.subList(0, m - 1 + 1 + i));
        if (paramMessage == null) {
          break label515;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.cMB = i;
        jL(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("Q.msg_box", 2, "loadNextPageData cost time:" + (l2 - l1));
        return false;
        label505:
        this.mHasMore = false;
        i = j;
        break label366;
      }
    }
  }
  
  protected void jL(List<RecentBaseData> paramList)
  {
    if (this.mUIHandler != null)
    {
      Message localMessage = this.mUIHandler.obtainMessage(0);
      localMessage.what = 0;
      localMessage.obj = paramList;
      this.mUIHandler.removeMessages(0);
      this.mUIHandler.sendMessage(localMessage);
      this.bTJ = false;
    }
  }
  
  protected void jM(List<MessageRecord> paramList) {}
  
  public void onClick(View paramView, Object paramObject) {}
  
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
  
  public int q(List<RecentBaseData> paramList)
  {
    int j;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      j = i;
      if (!paramList.hasNext()) {
        break label57;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
      if (localRecentBaseData.mUnreadFlag != 1) {
        break label59;
      }
      i = localRecentBaseData.mUnreadNum + i;
    }
    label57:
    label59:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.bTI) && (!TextUtils.isEmpty(paramObservable.senderuin))) {}
    }
    else
    {
      return;
    }
    paramObject = paramObservable.senderuin + "_" + paramObservable.istroop;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "update key:" + paramObject + "|mDelItemKey:" + this.bCR);
    }
    if (paramObject.equals(this.bCR))
    {
      this.bCR = "";
      return;
    }
    boolean bool;
    if (((top.eD(paramObservable.istroop) == 1010) && (this.cMA == 1010)) || ((top.eD(paramObservable.istroop) == 1001) && (this.cMA == 1001))) {
      bool = true;
    }
    for (;;)
    {
      runOnUiThread(new BaseMsgBoxActivity.5(this, bool));
      return;
      if ((this.yS != null) && (this.yS.size() > 0))
      {
        paramObject = new ArrayList(this.yS).iterator();
        for (;;)
        {
          if (paramObject.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramObject.next();
            if (paramObservable.frienduin.equals(localMessageRecord.senderuin))
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg_box", 2, "needRefresh update,uin:" + paramObservable.frienduin + ",type:" + paramObservable.istroop);
                bool = true;
                break;
              }
              bool = true;
              break;
            }
          }
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity
 * JD-Core Version:    0.7.0.1
 */