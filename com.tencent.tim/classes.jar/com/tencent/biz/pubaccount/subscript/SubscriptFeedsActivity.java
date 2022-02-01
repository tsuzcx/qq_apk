package com.tencent.biz.pubaccount.subscript;

import aalb;
import achq;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import anot;
import ausj;
import auss;
import awit;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.XListView.a;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jpa;
import kbp;
import mqq.os.MqqHandler;
import nzg;
import nzh;
import nzi;
import nzj;
import nzk;
import nzl;
import nzm;
import nzn;
import nzo;
import nzr;
import nzs;
import nzt;
import nzu;
import oac;
import oal;
import oan;
import obt;
import ocp;
import odd;
import vnj;
import wja;

public class SubscriptFeedsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragFrameLayout.c, SwipListView.a, Observer
{
  private EditText I;
  private CustomGuideView jdField_a_of_type_ComTencentBizUiCustomGuideView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected DragFrameLayout a;
  private XListView.a jdField_a_of_type_ComTencentWidgetXListView$a = new nzg(this);
  private nzo jdField_a_of_type_Nzo;
  private nzt jdField_a_of_type_Nzt = new nzk(this);
  private nzu jdField_a_of_type_Nzu;
  public oac a;
  public boolean afs;
  public boolean aft;
  protected boolean avH;
  public boolean avI;
  private boolean avJ;
  private boolean avK;
  private boolean avL;
  private boolean avM;
  private boolean avN;
  achq b = new nzi(this);
  private int bdi = -1;
  protected int bdj = 0;
  private int bdk;
  private SwipListView e;
  private List<oal> ge;
  private long iu;
  public View jB;
  public MqqHandler k = new nzj(this, ThreadManager.getSubThreadLooper());
  private ArrayList<ReadInJoyArticle> lT;
  private float lx;
  private float ly;
  public long mCreateTime;
  private View nk;
  private PopupWindow popupWindow;
  private long startTime;
  
  private void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
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
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void bS(List<oal> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() != -1)) {}
    while ((this.jdField_a_of_type_Nzo == null) || (this.jB == null)) {
      return;
    }
    if (paramList != null) {
      this.ge = paramList;
    }
    this.jdField_a_of_type_Nzo.ds(this.ge);
    if (((this.jdField_a_of_type_Nzo.bdu == -1) || (this.jdField_a_of_type_Nzo.bdt == -1)) && (((!this.avL) && (oac.j(this.app))) || (ocp.s(this.app))))
    {
      this.jdField_a_of_type_Nzo.bdu = 0;
      this.jdField_a_of_type_Nzo.bdt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptFeedsActivity", 2, "subscript inner recommend need show !");
      }
    }
    k(true, false, false);
  }
  
  private void bcF()
  {
    int i = 1;
    Object localObject = "3.4.4" + this.app.getCurrentUin() + "subscript_guid";
    if ((this.app.getPreferences().getBoolean((String)localObject, true)) && (oac.o(this.app))) {
      if (i != 0) {
        break label70;
      }
    }
    label70:
    do
    {
      return;
      i = 0;
      break;
      this.app.getPreferences().edit().putBoolean((String)localObject, false).commit();
      try
      {
        localObject = getResources();
        this.popupWindow = new PopupWindow();
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView = new CustomGuideView(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.bgColor = ((Resources)localObject).getColor(2131167484);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.textColor = ((Resources)localObject).getColor(2131167485);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.textSize = wja.a(2, 14, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.radius = wja.dp2px(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.mContentHeight = wja.dp2px(30.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.byu = wja.dp2px(7.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.byv = wja.dp2px(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.padding = wja.dp2px(3.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131378976);
        this.popupWindow.setContentView(this.jdField_a_of_type_ComTencentBizUiCustomGuideView);
        this.popupWindow.setFocusable(false);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setWidth(this.jdField_a_of_type_ComTencentBizUiCustomGuideView.uq());
        this.popupWindow.setHeight(-2);
        i = this.jdField_a_of_type_ComTencentBizUiCustomGuideView.uq();
        int j = getResources().getDisplayMetrics().widthPixels;
        this.rightViewText.post(new SubscriptFeedsActivity.6(this, j, i));
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("SubscriptFeedsActivity", 2, "showSubscriptCenterGuideWindow, " + localException);
  }
  
  private void bcG()
  {
    if ((this.popupWindow != null) && (this.popupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(null);
    }
    try
    {
      this.popupWindow.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SubscriptFeedsActivity", 2, "closeSubscriptCenterGuideWindow, " + localException);
    }
  }
  
  private void bcH()
  {
    ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.7(this));
    if (oan.a().p(this.app)) {
      oan.a().a(this.app.a().createEntityManager(), this.app);
    }
    addObserver(this.b);
    addObserver(this.jdField_a_of_type_Nzt);
    this.app.b().addObserver(this);
    if ((awit.cB(this.app)) && ((nzs)this.app.getBusinessHandler(64) != null)) {}
    jpa.b("2278", this.app, true, new nzn(this));
  }
  
  private void bcK()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.jdField_a_of_type_Nzo.getCount() == 0)
    {
      ((TextView)this.jB.findViewById(2131380239)).setText(2131700033);
      this.jB.setVisibility(0);
      if (!bool) {
        this.jB.setBackgroundResource(2131166344);
      }
      for (;;)
      {
        this.e.setBackgroundResource(2130851770);
        this.e.setEnabled(false);
        if (this.jdField_a_of_type_Oac != null) {
          this.jdField_a_of_type_Oac.showEmptyView();
        }
        return;
        this.jB.setBackgroundResource(2131166345);
      }
    }
    this.jB.setVisibility(8);
    if (!bool) {
      this.e.setBackgroundResource(2131166344);
    }
    for (;;)
    {
      this.e.setEnabled(true);
      return;
      this.e.setBackgroundResource(2131166345);
    }
  }
  
  private void k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
    {
      this.aft = true;
      this.jdField_a_of_type_Nzo.bcL();
      this.jdField_a_of_type_Nzo.notifyDataSetChanged();
      bcK();
    }
    if ((this.jdField_a_of_type_Oac != null) && (this.jdField_a_of_type_Nzo != null) && (!this.avN) && (this.jdField_a_of_type_Oac.avU) && (this.jdField_a_of_type_Nzo.bdu == 0) && (this.jdField_a_of_type_Nzo.avP) && (this.jdField_a_of_type_Nzo.bdt == 0))
    {
      this.avN = true;
      this.jdField_a_of_type_Oac.bcO();
    }
  }
  
  private boolean v(ArrayList<ReadInJoyArticle> paramArrayList)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    Object localObject;
    if (paramArrayList != null) {
      localObject = awit.b(this.app, 1);
    }
    for (;;)
    {
      try
      {
        paramArrayList = nzr.list2String(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          awit.a((SharedPreferences.Editor)localObject, true);
          bool1 = bool2;
          return bool1;
        }
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      bool1 = false;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1) && (paramDragFrameLayout.bI() != null) && (paramDragFrameLayout.bI().getId() == 2131381284))
    {
      paramDragFrameLayout = (oal)paramDragFrameLayout.bI().getTag(2131378978);
      if (paramDragFrameLayout != null)
      {
        anot.a(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.mUin, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.aOr, "", "", "");
        paramDragFrameLayout.bcT();
        aQ();
        this.k.removeMessages(1002);
        this.k.sendEmptyMessage(1002);
      }
    }
  }
  
  void aQ()
  {
    if (this.leftView != null) {
      ThreadManager.post(new SubscriptFeedsActivity.9(this), 5, null, true);
    }
  }
  
  public void bcI()
  {
    if (this.avH)
    {
      this.jdField_a_of_type_Oac.reload();
      this.avH = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Nzo.a(this.jdField_a_of_type_Oac);
      return;
      this.jdField_a_of_type_Oac.update();
    }
  }
  
  public void bcJ()
  {
    try
    {
      if (this.k != null)
      {
        this.k.removeMessages(1002);
        this.k.sendEmptyMessage(1002);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SubscriptFeedsActivity", 2, "refreshTroopBarAccountList, error: ", localException);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((this.e == null) || (this.jdField_a_of_type_Nzo == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    Object localObject;
    if (this.bdk == 0)
    {
      localObject = new int[2];
      this.e.getLocationOnScreen((int[])localObject);
      this.bdk = localObject[1];
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.lx = f1;
      this.ly = f2;
      this.avM = false;
      int i = this.e.getHeight();
      if (f2 >= this.bdk) {
        if ((this.jdField_a_of_type_Oac != null) && (this.jdField_a_of_type_Oac.bdz == 1) && (this.jdField_a_of_type_Oac.nn != null))
        {
          localObject = this.jdField_a_of_type_Oac.nn.findViewById(2131377746);
          int[] arrayOfInt = new int[2];
          ((View)localObject).getLocationOnScreen(arrayOfInt);
          if (f2 >= arrayOfInt[1])
          {
            i = arrayOfInt[1];
            if (f2 < ((View)localObject).getHeight() + i) {
              this.avM = true;
            }
          }
        }
        else if (f2 < i + this.bdk)
        {
          i = this.e.pointToPosition((int)f1, (int)f2 - this.bdk);
          if (i != -1)
          {
            i -= this.e.getHeaderViewsCount();
            if ((i >= 0) && (i < this.jdField_a_of_type_Nzo.getCount()))
            {
              if (i == this.bdi) {
                this.avM = true;
              }
              if (this.jdField_a_of_type_Nzo.getItem(i).equals("SubscriptRecommendController"))
              {
                this.avM = true;
                continue;
                if (Math.abs(f1 - this.lx) > Math.abs(f2 - this.ly))
                {
                  if (f1 - this.lx > 20.0F)
                  {
                    if (this.avM) {
                      ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                    }
                  }
                  else if (f1 - this.lx < -20.0F) {
                    ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                  }
                }
                else if (Math.abs(f2 - this.ly) > 20.0F)
                {
                  continue;
                  ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(false);
                  this.avM = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mCreateTime = SystemClock.uptimeMillis();
    odd.bU(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      new MqqHandler().postDelayed(new SubscriptFeedsActivity.2(this), 1000L);
    }
    setContentView(2131560567);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.avH = true;
    this.bdj = super.getIntent().getIntExtra("come_from", 0);
    this.startTime = super.getIntent().getLongExtra("start_time", 0L);
    this.avK = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_Nzu = new nzu();
    setTitle(obt.a(this.app, getApplicationContext()));
    aQ();
    boolean bool = oac.o(this.app);
    this.rightViewText.setText(2131692996);
    if (bool)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(this);
      this.jB = findViewById(2131366438);
      this.e = ((SwipListView)findViewById(2131366997));
      SwipListView localSwipListView = this.e;
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label644;
      }
      paramBundle = getResources().getDrawable(2131167483);
      label281:
      localSwipListView.setDivider(paramBundle);
      this.e.setDividerHeight(getResources().getDimensionPixelSize(2131297134));
      this.e.setOnScrollListener(new nzl(this));
      this.e.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$a);
      this.nk = LayoutInflater.from(this).inflate(2131563008, null);
      this.nk.setBackgroundDrawable(null);
      ((Button)this.nk.findViewById(2131363801)).setVisibility(8);
      ((TextView)this.nk.findViewById(2131380917)).setText(String.format(getResources().getString(2131698738), new Object[] { obt.a(this.app, getApplicationContext()) }));
      this.I = ((EditText)this.nk.findViewById(2131366542));
      this.I.setCursorVisible(false);
      this.I.setOnFocusChangeListener(new nzm(this));
      this.e.addHeaderView(this.nk);
      bcF();
      this.jdField_a_of_type_Nzo = new nzo(this, this.app, this.e, getLayoutInflater());
      this.jdField_a_of_type_Nzo.setOnClickListener(this);
      this.e.setAdapter(this.jdField_a_of_type_Nzo);
      this.jdField_a_of_type_Nzo.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_Nzo.a(this.jdField_a_of_type_Nzu);
      if (ThemeUtil.isInNightMode(this.app)) {
        break label658;
      }
      this.e.setBackgroundResource(2131166344);
    }
    for (;;)
    {
      this.e.setDragEnable(true);
      this.e.setRightIconMenuListener(this);
      ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.5(this));
      bcH();
      if (this.jdField_a_of_type_Oac == null) {
        this.jdField_a_of_type_Oac = new oac(this, this.app, this.jdField_a_of_type_Nzu);
      }
      this.app.setHandler(getClass(), this.k);
      return true;
      this.rightViewText.setVisibility(8);
      break;
      label644:
      paramBundle = getResources().getDrawable(2131166633);
      break label281;
      label658:
      this.e.setBackgroundResource(2131166345);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.k != null)
    {
      this.k.removeCallbacksAndMessages(null);
      this.k = null;
    }
    removeObserver(this.b);
    removeObserver(this.jdField_a_of_type_Nzt);
    if ((this.app != null) && (this.app.b() != null)) {
      this.app.b().deleteObserver(this);
    }
    if (this.e != null)
    {
      this.e.setAdapter(null);
      this.e.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_Nzo != null)
    {
      this.jdField_a_of_type_Nzo.onDestory();
      this.jdField_a_of_type_Nzo = null;
    }
    this.ge = null;
    this.lT = null;
    if (this.jdField_a_of_type_Oac != null) {
      this.jdField_a_of_type_Oac.destory();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    this.jdField_a_of_type_Nzu.destroy();
    this.jdField_a_of_type_Nzu = null;
    if (this.startTime != 0L)
    {
      this.startTime = (System.currentTimeMillis() - this.startTime);
      if (!this.avK) {
        break label286;
      }
    }
    label286:
    for (int i = 1;; i = 0)
    {
      anot.a(this.app, "dc00899", "Pb_account_lifeservice", "0", "0X80064CC", "0X80064CC", 0, 0, "" + i, "" + this.startTime, "", "");
      this.startTime = 0L;
      this.avK = false;
      super.doOnDestroy();
      return;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    boolean bool = oac.l(this.app);
    Object localObject = super.findViewById(2131369614);
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if (this.avI)
      {
        if ((awit.cB(this.app)) && ((nzs)this.app.getBusinessHandler(64) != null)) {}
        this.avI = false;
      }
      if (this.avL)
      {
        String str = oac.f(this.app);
        Intent localIntent = new Intent(this, PublicAccountBrowser.class);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "https://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
        }
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.app.getCurrentUin());
        localIntent.putExtra("fromLocalUrl", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("hideRightButton", true);
        localIntent.putExtra("assignBackText", obt.a(this.app, this));
        localIntent.putExtra("call_from", 1001);
        startActivity(localIntent);
        overridePendingTransition(2130772259, 2130771992);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
        }
        this.avL = false;
        anot.a(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
      }
      bcI();
      bcJ();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    oan.a().aq(this.app);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label303:
    label317:
    label367:
    int j;
    switch (paramView.getId())
    {
    default: 
    case 2131378976: 
    case 2131369612: 
    case 2131378975: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          anot.a(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
          vnj.d(this, obt.a(this.app, this), null, "https://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
          oac.c(this.app, false);
          bcG();
          continue;
          anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
          vnj.d(this, obt.a(this.app, this), null, "https://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
          oac.c(this.app, false);
          bcG();
        }
      } while (((Integer)paramView.getTag(2131378979)).intValue() != nzo.bdr);
      localObject2 = paramView.getTag(2131378978);
      localObject3 = paramView.getTag(2131378987);
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label554;
        }
        i = ((Integer)localObject2).intValue();
        localObject3 = Integer.valueOf(i);
        if (((Integer)localObject3).intValue() <= 0) {
          break label559;
        }
        anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        anot.a(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(oan.a().getNickName((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.app.getBusinessHandler(11);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).AF();
          }
        }
        localObject2 = paramView.getTag(2131378980);
        if (localObject2 == null) {
          break label598;
        }
      }
      for (localObject2 = (String)localObject2;; localObject2 = "")
      {
        Intent localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtra("uintype", 1008);
        localIntent.putExtra("uin", (String)localObject1);
        localIntent.putExtra("uinname", (String)localObject2);
        localIntent.putExtra("start_time", System.currentTimeMillis());
        localIntent.putExtra("red_hot_count", (Serializable)localObject3);
        startActivity(localIntent);
        bcG();
        break;
        localObject1 = "";
        break label303;
        i = 0;
        break label317;
        anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        break label367;
      }
    case 2131370008: 
    case 2131370009: 
    case 2131370010: 
    case 2131370011: 
    case 2131370025: 
      anot.a(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).putExtra("channel_id", 0);
      ((Intent)localObject1).putExtra("readinjoy_launch_source", 9);
      localObject2 = new ArrayList();
      long l;
      if ((this.lT != null) && (this.lT.size() == 4))
      {
        i = 0;
        while (i < 4)
        {
          ((ArrayList)localObject2).add(Long.valueOf(((ReadInJoyArticle)this.lT.get(i)).mArticleID));
          i += 1;
        }
        ((Intent)localObject1).putExtra("subscription_all_article_id", (Serializable)localObject2);
        if ((paramView.getId() == 2131370008) || (paramView.getId() == 2131370009) || (paramView.getId() == 2131370010) || (paramView.getId() == 2131370011))
        {
          i = ((Integer)paramView.getTag()).intValue();
          localObject2 = (ReadInJoyArticle)this.lT.get(i);
          if (localObject2 != null)
          {
            l = ((ReadInJoyArticle)localObject2).mArticleID;
            ((Intent)localObject1).putExtra("subscription_click_article_id", Long.valueOf(l));
          }
        }
      }
      for (;;)
      {
        this.avI = true;
        awit.b(this.app, this, (Intent)localObject1);
        bcG();
        break;
        l = -1L;
        break label823;
        ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
        }
      }
    case 2131371300: 
    case 2131371306: 
      label554:
      label559:
      label598:
      localObject1 = paramView.getTag(2131378987);
      label823:
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        if (oan.a().a((String)localObject1, this.app)) {
          break label1127;
        }
        oan.a().e((String)localObject1, this.app);
        kbp.b(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        j = oan.a().rd();
        localObject2 = this.ge.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (oal)((Iterator)localObject2).next();
        } while ((((oal)localObject3).mUin == null) || (!((oal)localObject3).mUin.equals(localObject1)));
      }
      label919:
      break;
    }
    for (int i = ((oal)localObject3).aOr;; i = 0)
    {
      anot.a(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CD", "0X80064CD", 0, 0, "" + i, "" + j, "", "");
      label1112:
      bcJ();
      break;
      localObject1 = "";
      break label919;
      label1127:
      oan.a().f((String)localObject1, this.app);
      j = oan.a().rd();
      localObject2 = this.ge.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (oal)((Iterator)localObject2).next();
      } while ((((oal)localObject3).mUin == null) || (!((oal)localObject3).mUin.equals(localObject1)));
      for (i = ((oal)localObject3).aOr;; i = 0)
      {
        anot.a(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CE", "0X80064CE", 0, 0, "" + i, "" + j, "", "");
        break label1112;
        localObject1 = paramView.getTag(2131378987);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          label1296:
          localObject2 = paramView.getTag(2131378980);
          if (localObject2 == null) {
            break label1404;
          }
        }
        label1404:
        for (localObject2 = (String)localObject2;; localObject2 = "")
        {
          localObject3 = (ausj)auss.a(this, null);
          ((ausj)localObject3).setMainTitle(String.format(getResources().getString(2131698742), new Object[] { localObject2 }));
          ((ausj)localObject3).addButton(2131698678, 3);
          ((ausj)localObject3).addCancelButton(2131721058);
          ((ausj)localObject3).a(new nzh(this, (String)localObject1, (ausj)localObject3));
          ((ausj)localObject3).show();
          break;
          localObject1 = "";
          break label1296;
        }
        localObject1 = paramView.getTag(2131378987);
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          label1433:
          anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
          anot.a(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
          oan.a().d((String)localObject1, this.app);
          bcJ();
          i = ocp.e(this.app, (String)localObject1);
          aalb.l(this.app, (String)localObject1, i);
          this.app.b().ca((String)localObject1, 1008);
          localObject2 = this.app.getHandler(Conversation.class);
          if (localObject2 != null) {
            ((MqqHandler)localObject2).sendEmptyMessage(1014);
          }
          localObject2 = this.ge.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (oal)((Iterator)localObject2).next();
          } while ((((oal)localObject3).mUin == null) || (!((oal)localObject3).mUin.equals(localObject1)));
        }
        for (i = ((oal)localObject3).aOr;; i = 0)
        {
          anot.a(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064D0", "0X80064D0", 0, 0, "" + i, "", "", "");
          break;
          localObject1 = "";
          break label1433;
        }
      }
    }
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    this.bdi = -1;
    L(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    this.bdi = ((Integer)paramView.getTag(2131378981)).intValue();
    L(false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new SubscriptFeedsActivity.13(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
    else
    {
      return;
    }
    bcJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity
 * JD-Core Version:    0.7.0.1
 */