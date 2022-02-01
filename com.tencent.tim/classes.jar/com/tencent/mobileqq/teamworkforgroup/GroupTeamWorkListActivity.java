package com.tencent.mobileqq.teamworkforgroup;

import aaiy;
import ajdr;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzt;
import aoaf;
import aobh;
import aobl;
import aobo;
import aobw;
import aodi;
import aodk;
import aodm;
import aodn;
import aodo;
import aodp;
import aodq;
import aodr;
import aods;
import aodt;
import aodu;
import aodv;
import aodx;
import aodz;
import aoea;
import aoeb;
import aoec;
import aoed;
import aoee;
import apuh;
import aqgx;
import aqha;
import aqju;
import aqmj;
import aurf;
import auuo;
import auuw.b;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class GroupTeamWorkListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, anzt, auuo, AbsListView.e
{
  TextView Co;
  List<GroupPadTemplateInfo> GX = new ArrayList();
  private View HF;
  private View HG;
  private View HH;
  private View HI;
  private TextView Wg;
  private TextView ZQ;
  private aaiy jdField_a_of_type_Aaiy;
  aobh jdField_a_of_type_Aobh;
  aobl jdField_a_of_type_Aobl;
  aobo jdField_a_of_type_Aobo = new aodu(this);
  public aodm a;
  aoed jdField_a_of_type_Aoed;
  aoee jdField_a_of_type_Aoee = new aodt(this);
  private auuw.b jdField_a_of_type_Auuw$b = new aoeb(this);
  List<GPadInfo> aa = new ArrayList();
  Comparator<PadInfo> ae = new aoec(this);
  private ProgressBar am;
  public long aoW;
  private long aoX;
  public Dialog az;
  private aodi jdField_b_of_type_Aodi;
  private aodk jdField_b_of_type_Aodk;
  public int bQb = 0;
  EditText by;
  private FPSSwipListView c;
  private boolean cLg;
  private boolean cLh;
  private boolean cLi;
  volatile boolean cLj = false;
  private volatile int dOc = 1;
  public int dOd;
  RelativeLayout fD;
  private PullRefreshHeader j;
  private aqju m;
  private View mEmptyView;
  private View mLoadingView;
  private View mRoot;
  private boolean ob;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private HorizontalListView y;
  
  private void VG(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.8(this, paramInt), null, true);
  }
  
  private void VH(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.10(this, paramInt), null, true);
  }
  
  private void aC()
  {
    this.leftView.setText(getResources().getString(2131694535));
    this.leftView.setBackgroundResource(2130851758);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840650);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131694533));
    this.centerView.setOnClickListener(this);
  }
  
  private void c(PadInfo paramPadInfo)
  {
    dUd();
    if (paramPadInfo == null) {
      return;
    }
    String str1 = "";
    String str2 = getString(2131721079);
    if ((this.bQb == 1) || ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))) {
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131692517);
        str2 = getString(2131692498);
        if ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))) {
          break label256;
        }
        this.m = aqha.b(this, 230, null, str1, getString(2131692525), getString(2131721058), str2, new aodo(this), new aodp(this, paramPadInfo), new aodq(this));
      }
    }
    for (;;)
    {
      this.m.show();
      return;
      str1 = getString(2131692523);
      str2 = getString(2131692498);
      break;
      if (!apuh.a(this.app, this.aoW, this.app.getCurrentAccountUin())) {
        break;
      }
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131692516);
        str2 = getString(2131692498);
        break;
      }
      str1 = getString(2131692522);
      str2 = getString(2131692498);
      break;
      label256:
      this.m = aqha.a(this, 230).setMessage(str1);
      this.m.setPositiveButton(str2, new aodr(this, paramPadInfo));
      this.m.setNegativeButton(getString(2131721058), new aods(this));
    }
  }
  
  private void dUd()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("GroupTeamWorkListActivity", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  private void i(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Aodm != null)
    {
      this.jdField_a_of_type_Aodm.h(paramLong, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_Aodm.lD(paramLong);
    }
  }
  
  private void initUI()
  {
    this.mRoot = findViewById(2131377546);
    this.mLoadingView = findViewById(2131379285);
    this.HI = findViewById(2131379284);
    this.HI.setOnClickListener(this);
    this.mEmptyView = findViewById(2131379270);
    this.Wg = ((TextView)findViewById(2131379272));
    this.c = ((FPSSwipListView)findViewById(2131370527));
    this.c.setDragEnable(true);
    this.c.setDivider(null);
    this.c.setOnScrollListener(this);
    this.c.setOverScrollListener(this);
    this.c.setOverscrollHeader(getResources().getDrawable(2130839645));
    View localView = LayoutInflater.from(this).inflate(2131563171, this.c, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.c.addHeaderView((View)localObject);
    this.HF = LayoutInflater.from(this).inflate(2131563190, this.c, false);
    this.y = ((HorizontalListView)this.HF.findViewById(2131368191));
    if (this.y != null)
    {
      this.y.setVisibility(0);
      this.y.setDividerWidth(getResources().getDimensionPixelSize(2131297439));
    }
    this.c.addHeaderView(this.HF);
    this.Co = ((TextView)this.HF.findViewById(2131380917));
    this.by = ((EditText)this.HF.findViewById(2131366542));
    this.by.setCursorVisible(false);
    this.by.setOnFocusChangeListener(new aodx(this));
    this.j = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559847, null));
    this.c.setOverScrollHeader(this.j);
    this.HG = LayoutInflater.from(this).inflate(2131563174, null);
    this.HH = this.HG.findViewById(2131379288);
    this.ZQ = ((TextView)this.HG.findViewById(2131379287));
    this.am = ((ProgressBar)this.HG.findViewById(2131379286));
    this.c.addFooterView(this.HG);
    aC();
    this.fD = ((RelativeLayout)findViewById(2131377361));
    localObject = new ArrayList();
    ((List)localObject).add(aaiy.a);
    ((List)localObject).add(aaiy.b);
    ((List)localObject).add(aaiy.c);
    this.jdField_a_of_type_Aaiy = new aaiy(this, (List)localObject, this.jdField_a_of_type_Auuw$b);
    this.c.setVisibility(8);
    this.mLoadingView.setVisibility(0);
    if (aqmj.e(this, this.app.getCurrentUin(), 1))
    {
      new aodz(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131364729);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131364728);
      ((TextView)localObject).setText(getString(2131691564));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new aoea(this, localView));
      return;
    }
    localView.setVisibility(8);
  }
  
  private void lz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.am.setVisibility(0);
      this.ZQ.setText(2131720954);
      this.HH.setVisibility(0);
      return;
    }
    this.am.setVisibility(8);
    this.ZQ.setText(2131720963);
    this.HH.setVisibility(0);
  }
  
  private void my(List<GPadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.aa.clear();
    this.aa.addAll(paramList);
  }
  
  private void mz(List<GroupPadTemplateInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.GX.clear();
    this.GX.addAll(paramList);
  }
  
  public void VI(int paramInt)
  {
    if (paramInt == 1)
    {
      this.cLj = true;
      startTitleProgress();
    }
    while (paramInt != 2) {
      return;
    }
    this.cLj = false;
    stopTitleProgress();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).Q(0L);
  }
  
  public void a(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url))) {
      c(paramPadInfo);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).S(0L);
    i(this.aoW, 0, 20, 2);
    this.ob = true;
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).R(0L);
  }
  
  public void b(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url)))
    {
      String str1 = paramPadInfo.pad_url;
      String str2 = paramPadInfo.title;
      String str3 = String.valueOf(paramPadInfo.creatorUin);
      Intent localIntent = new Intent(getApplicationContext(), TeamWorkTransparentShareActivity.class);
      if ((!TextUtils.isEmpty(str3)) && (str3.equals(getCurrentAccountUin()))) {
        localIntent.putExtra("team_is_my_document", true);
      }
      if (!TextUtils.isEmpty(str2)) {
        localIntent.putExtra(aoaf.cjn, str2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("team_work_pad_url", str1);
      }
      localIntent.putExtra("team_policy", paramPadInfo.policy);
      localIntent.putExtra("team_work_pad_list_type", paramPadInfo.type_list);
      localIntent.putExtra("team_work_pad_type", paramPadInfo.type);
      localIntent.putExtra("from_activity", "GroupTeamWorkListActivity");
      localIntent.putExtra("select_type", this.bQb);
      overridePendingTransition(0, 0);
      startActivity(localIntent);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupTeamWorkListActivity", 2, " onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 == 14001)
    {
      i(this.aoW, 0, 20, 1);
      this.cLi = true;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559421);
    this.aoW = getIntent().getLongExtra(aoaf.cjr, 0L);
    this.jdField_a_of_type_Aodm = ((aodm)this.app.getBusinessHandler(143));
    this.jdField_a_of_type_Aoed = ((aoed)this.app.getManager(304));
    this.jdField_a_of_type_Aobh = ((aobh)this.app.getBusinessHandler(122));
    this.jdField_a_of_type_Aobl = ((aobl)this.app.getManager(283));
    this.jdField_b_of_type_Aodk = new aodk(this.app, this, this, null);
    initUI();
    this.app.addObserver(this.jdField_a_of_type_Aoee);
    this.app.addObserver(this.jdField_a_of_type_Aobo);
    paramBundle = (TroopManager)this.app.getManager(52);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.b(String.valueOf(this.aoW));
      if (paramBundle != null) {
        this.aoX = paramBundle.dwGroupClassExt;
      }
    }
    VG(1);
    ((ajdr)this.app.getManager(37)).b(this.app.getApp(), String.valueOf(this.aoW), "TIM_GROUP_TM_REDDOT", false);
    ((aodm)this.app.getBusinessHandler(143)).lE(this.aoW);
    this.cLi = true;
    this.c.setAdapter(this.jdField_b_of_type_Aodk);
    this.jdField_b_of_type_Aodk.setOnClickListener(new aodn(this));
    this.jdField_b_of_type_Aodk.mx(this.aa);
    this.jdField_b_of_type_Aodi = new aodi(this, this);
    VH(1);
    this.y.setAdapter(this.jdField_b_of_type_Aodi);
    this.jdField_b_of_type_Aodi.setData(this.GX);
    this.jdField_b_of_type_Aodi.notifyDataSetChanged();
    this.jdField_b_of_type_Aodi.setOnClickListener(new aodv(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
    if (this.uiHandler != null)
    {
      this.uiHandler.removeMessages(114);
      this.uiHandler.removeMessages(111);
      this.uiHandler.removeMessages(112);
    }
    aqgx.k(this.app.getCurrentAccountUin(), "group_file_inner_reddot_tim", String.valueOf(this.aoW), false);
    this.app.removeObserver(this.jdField_a_of_type_Aoee);
    this.app.removeObserver(this.jdField_a_of_type_Aobo);
    dUd();
    if (this.jdField_b_of_type_Aodi != null) {
      this.jdField_b_of_type_Aodi = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new GroupTeamWorkListActivity.3(this), 100L);
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.j != null)
      {
        if (???.arg1 != 1) {
          break label93;
        }
        this.j.tT(0);
      }
      for (;;)
      {
        ??? = new Message();
        ???.what = 112;
        this.uiHandler.sendMessageDelayed(???, 500L);
        return true;
        label93:
        this.j.tT(1);
      }
      if (this.c == null) {
        continue;
      }
      this.c.springBackOverScrollHeaderView();
      return true;
      if (this.jdField_b_of_type_Aodk == null) {
        continue;
      }
      int i = ???.arg1;
      i = ???.arg2;
      if (i == 4) {
        lz(false);
      }
      for (;;)
      {
        synchronized (this.aa)
        {
          this.jdField_b_of_type_Aodk.mx(this.aa);
          if (i == 1)
          {
            if (this.jdField_b_of_type_Aodk.getCount() > 0)
            {
              if (this.mLoadingView.getVisibility() == 0) {
                this.mLoadingView.setVisibility(8);
              }
              if (this.mEmptyView.getVisibility() == 0) {
                this.mEmptyView.setVisibility(8);
              }
              this.c.setVisibility(0);
              if (this.cLi) {
                VI(1);
              }
            }
            if ((!this.cLj) && (i != 5)) {
              break;
            }
            VI(2);
            return true;
          }
        }
        if (this.jdField_b_of_type_Aodk.getCount() > 0)
        {
          if (this.mLoadingView.getVisibility() == 0) {
            this.mLoadingView.setVisibility(8);
          }
          if (this.mEmptyView.getVisibility() == 0) {
            this.mEmptyView.setVisibility(8);
          }
          this.c.setVisibility(0);
          if (this.c.getLastVisiblePosition() - this.c.getFirstVisiblePosition() + 1 >= this.jdField_b_of_type_Aodk.getCount()) {
            this.HH.setVisibility(8);
          }
        }
        else
        {
          if (this.mLoadingView.getVisibility() == 0) {
            this.mLoadingView.setVisibility(8);
          }
          if (this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
          }
          this.mEmptyView.setVisibility(0);
        }
      }
      this.uiHandler.removeMessages(114);
      if (this.am.getVisibility() != 8) {
        continue;
      }
      this.HH.setVisibility(8);
      return true;
      if (this.jdField_b_of_type_Aodi == null) {
        continue;
      }
      synchronized (this.GX)
      {
        this.jdField_b_of_type_Aodi.setData(this.GX);
        if (this.jdField_b_of_type_Aodi.getCount() <= 0) {
          continue;
        }
        this.y.setVisibility(0);
        return true;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aobw.h(this.app, "0X800993A");
      if (this.jdField_a_of_type_Aaiy != null)
      {
        this.jdField_a_of_type_Aaiy.t(this.fD, this.fD.getWidth() - getResources().getDimensionPixelSize(2131299279), getResources().getDimensionPixelSize(2131299276));
        continue;
        i(this.aoW, 0, 20, 1);
        this.HI.setVisibility(8);
        this.mLoadingView.setVisibility(0);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 0) && (paramInt1 + paramInt2 == paramInt3))
    {
      this.cLg = true;
      if (paramInt3 <= paramInt2)
      {
        this.cLh = false;
        return;
      }
      this.cLh = true;
      return;
    }
    this.cLg = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((this.cLg) && (this.jdField_b_of_type_Aodk != null) && (this.jdField_b_of_type_Aodk.getCount() > 0) && (this.cLh) && (paramInt != 0))
      {
        if (this.dOd == 0) {
          break;
        }
        lz(true);
        i(this.aoW, this.dOd, 20, 3);
      }
      return;
    }
    lz(false);
    this.uiHandler.sendEmptyMessageDelayed(114, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */