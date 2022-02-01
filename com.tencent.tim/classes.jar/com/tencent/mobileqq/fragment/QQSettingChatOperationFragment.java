package com.tencent.mobileqq.fragment;

import acbn;
import acfd;
import acfp;
import achs;
import aclh;
import acqh;
import acxw;
import ahok;
import ahol;
import ahom;
import ahon;
import ahoo;
import ahyv;
import ahzs;
import aizp;
import amjb;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anot;
import aoop;
import aqiw;
import aqqj;
import aqrb;
import arfj;
import arhz;
import ausj;
import ausj.a;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rvx;
import tbc;
import tog;
import wvo;
import yhf;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private View Dt;
  private View Du;
  private TextView Tv;
  private aclh a = new ahom(this);
  private FormSimpleItem aF;
  private FormSwitchItem bk;
  acfd c = new ahon(this);
  private String currentUin = "";
  private BounceScrollView e;
  public Handler handler = new ahoo(this);
  private long lastClickTime;
  private QQAppInterface mApp;
  private TextView qA;
  private arhz u;
  public arhz v;
  
  private int Fe()
  {
    Object localObject = HiddenChatFragment.i(this.mApp.a().a().ei(), aizp.a().m(this.mApp));
    int j;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      j = 0;
      return j;
    }
    localObject = ((List)localObject).iterator();
    RecentUser localRecentUser;
    for (int i = 0;; i = this.mApp.a().A(localRecentUser.uin, localRecentUser.getType()) + i)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localRecentUser = (RecentUser)((Iterator)localObject).next();
    }
  }
  
  private static void aK(QQAppInterface paramQQAppInterface)
  {
    if (aoop.aW != null)
    {
      deleteFiles(aoop.aW.getAbsolutePath());
      if ((paramQQAppInterface.getApp() instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl.getApplication();
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.getApplication();
          BaseApplicationImpl.sImageCache.evictAll();
        }
      }
    }
  }
  
  public static void aU(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < CardHandler.w.size())
    {
      deleteFiles(CardHandler.bnU + ((Integer)CardHandler.w.get(i)).intValue() + "/");
      i += 1;
    }
    deleteFiles(CardHandler.bnU + "background" + "/");
    deleteFiles(acbn.SDCARD_PATH + "temp" + "/");
    deleteFiles(CardHandler.bnU + "temp" + "/");
    deleteFiles(CardHandler.bnU + "HDAvatar" + "/");
    deleteFiles(acbn.bni);
    deleteFiles(CardHandler.bnU + "voice" + "/");
    deleteFiles(tbc.ob() + "/");
    deleteFiles(acbn.bnt);
    deleteFiles(ahyv.bMr);
    deleteFiles(ahzs.bMy);
    deleteFiles(amjb.yR());
  }
  
  private void bKs()
  {
    if (getActivity() == null) {
      QLog.e("QQSettingChatOperationFragment", 1, "syncMessageRoamFlag: activity is null");
    }
    int i;
    do
    {
      return;
      i = this.mApp.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.mApp.getCurrentAccountUin(), 0);
      Object localObject = null;
      switch (i)
      {
      }
      while (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.aF.setRightText((CharSequence)localObject);
        return;
        localObject = getResources().getString(2131717266);
        continue;
        localObject = getResources().getString(2131717264);
        continue;
        localObject = getResources().getString(2131717265);
        continue;
        localObject = getResources().getString(2131717267);
        continue;
        localObject = getResources().getString(2131717284);
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + i);
  }
  
  static void bUx()
  {
    deleteFiles(acbn.SDCARD_PATH + "photo/");
  }
  
  private void bUy()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("set_display_type"))) {}
    for (int i = localIntent.getIntExtra("set_display_type", 0);; i = 0)
    {
      if (i == 2)
      {
        this.bk.setVisibility(8);
        this.aF.setVisibility(8);
        this.qA.setVisibility(8);
        return;
      }
      this.bk.setVisibility(0);
      this.qA.setVisibility(0);
      return;
    }
  }
  
  private void cBb()
  {
    try
    {
      this.mApp.b().bEC();
      this.mApp.b().bEE();
      this.mApp.b().bEF();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static void deleteFiles(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void dpi()
  {
    if (!acqh.e(this.mApp.getCurrentUin(), getActivity()))
    {
      this.Tv.setVisibility(8);
      return;
    }
    int i = Fe();
    if (i > 99)
    {
      this.Tv.setText("99+");
      this.Tv.setVisibility(0);
      return;
    }
    if (i > 0)
    {
      this.Tv.setText(i + "");
      this.Tv.setVisibility(0);
      return;
    }
    this.Tv.setVisibility(8);
  }
  
  private void dpl()
  {
    deleteFiles(acbn.SDCARD_PATH + this.currentUin + "/" + "ptt/");
  }
  
  private void initUI()
  {
    this.e = ((BounceScrollView)this.mContentView.findViewById(2131377757));
    this.currentUin = this.mApp.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131368519);
    this.Tv = ((TextView)((View)localObject).findViewById(2131381284));
    this.Tv.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.bk = ((FormSwitchItem)this.mContentView.findViewById(2131374971));
    localObject = this.bk;
    if (this.mApp.AK() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      this.bk.setOnCheckedChangeListener(this);
      this.aF = ((FormSimpleItem)this.mContentView.findViewById(2131371312));
      this.aF.setRightTextColor(2);
      this.aF.setOnClickListener(this);
      this.qA = ((TextView)this.mContentView.findViewById(2131379585));
      this.Dt = this.mContentView.findViewById(2131365676);
      this.Du = this.mContentView.findViewById(2131365673);
      this.Dt.setOnClickListener(this);
      this.Du.setOnClickListener(this);
      this.Dt.setContentDescription(getString(2131692490));
      this.Du.setContentDescription(getString(2131692463));
      this.mApp.addObserver(this.c);
      this.mApp.addObserver(this.a);
      this.mApp.b().addObserver(this);
      bUy();
      if (VersionUtils.isGingerBread()) {
        this.e.setOverScrollMode(0);
      }
      if (this.v == null)
      {
        this.v = new arhz(getActivity(), getActivity().getTitleBarHeight());
        this.v.setMessage(getString(2131691516));
        this.v.setCanceledOnTouchOutside(true);
        this.v.setBackAndSearchFilter(true);
        this.v.showTipImageView(false);
        this.v.showProgerss(true);
      }
      return;
    }
  }
  
  private void showProgressBar(boolean paramBoolean)
  {
    if (this.v != null)
    {
      if ((!paramBoolean) || (this.v.isShowing())) {
        break label29;
      }
      this.v.show();
    }
    label29:
    while ((paramBoolean) || (!this.v.isShowing())) {
      return;
    }
    this.v.dismiss();
  }
  
  public void bJQ()
  {
    try
    {
      if (this.u != null)
      {
        this.u.dismiss();
        this.u.cancel();
        this.u = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.mApp != null) {
        initUI();
      }
    }
  }
  
  void dpj()
  {
    this.mApp.b().bEE();
    aU(this.currentUin, true);
    dpl();
    bUx();
    cBb();
    aK(this.mApp);
    dpk();
    yhf.cip();
    MqqHandler localMqqHandler = this.mApp.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void dpk()
  {
    achs localachs = (achs)this.mApp.getManager(92);
    localachs.cKG();
    localachs.cKx();
  }
  
  protected int getContentLayoutId()
  {
    return 2131562972;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    wvo.b(getActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!aqiw.isNetSupport(this.mApp.getApplication().getApplicationContext()))
    {
      QQToast.a(getActivity().getApplicationContext(), 2131696272, 1).show();
      this.bk.setOnCheckedChangeListener(null);
      localObject = this.bk;
      if (this.mApp.AK() == 1) {
        bool = true;
      }
      ((FormSwitchItem)localObject).setChecked(bool);
      this.bk.setOnCheckedChangeListener(this);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.mApp;
    if (paramBoolean)
    {
      i = 1;
      label104:
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      vl(getActivity().getApplication().getResources().getString(2131719578));
      if (!paramBoolean) {
        break label177;
      }
    }
    label177:
    for (int i = j;; i = 0)
    {
      this.mApp.JD(i);
      break;
      i = 0;
      break label104;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int j = 0;
    if (paramView.getId() == 2131371312)
    {
      localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
      localObject1 = aqqj.getUrl("vipRoamChatCell");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        QLog.e("QQSettingChatOperationFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
      }
    }
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (((String)localObject1).contains("?")) {}
        for (localObject1 = (String)localObject1 + "&ADTAG=msgRoam";; localObject1 = (String)localObject1 + "?ADTAG=msgRoam")
        {
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          startActivity((Intent)localObject2);
          VipUtils.a(this.mApp, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
          break;
        }
        if (paramView.getId() == 2131368519)
        {
          HiddenChatFragment.b(getActivity(), 1, 0, new Intent());
        }
        else
        {
          if (paramView.getId() != 2131365673) {
            break;
          }
          l1 = System.currentTimeMillis();
          l2 = this.lastClickTime;
          if ((getActivity().isFinishing()) || (l1 - l2 >= 500L))
          {
            this.lastClickTime = l1;
            localObject1 = new arfj(getActivity(), this.mApp, false);
            ((arfj)localObject1).a(new ahok(this));
            ((arfj)localObject1).setTitleText(acfp.m(2131712146));
            ((arfj)localObject1).setContentText(acfp.m(2131712135));
            ((arfj)localObject1).show(4);
          }
        }
      }
      l1 = System.currentTimeMillis();
      l2 = this.lastClickTime;
    } while ((!getActivity().isFinishing()) && (l1 - l2 < 500L));
    this.lastClickTime = l1;
    Object localObject2 = (ausj)auss.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ((ausj)localObject2).addButton(i, 3);
      ((ausj)localObject2).addCancelButton(getString(2131721058));
      ((ausj)localObject2).a((ausj.a)localObject1);
      ((ausj)localObject2).setMainTitle(j);
      ((ausj)localObject2).show();
      break;
      i = 2131692490;
      j = 2131691515;
      localObject1 = new ahol(this, (ausj)localObject2);
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689519));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.v != null) && (this.v.isShowing())) {
      showProgressBar(false);
    }
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.c);
      this.mApp.removeObserver(this.a);
      this.mApp.b().deleteObserver(this);
    }
    this.handler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.bUu();
    rvx.cJ(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    dpi();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.mApp != null)
    {
      bKs();
      ((aqrb)this.mApp.getBusinessHandler(71)).a(new String[] { this.mApp.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!acqh.e(this.mApp.getCurrentUin(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!wvo.a(paramObservable.frienduin, paramObservable.istroop, this.mApp));
    this.handler.sendEmptyMessage(2);
  }
  
  void vl(String paramString)
  {
    if (this.u == null) {
      this.u = new arhz(getActivity(), getActivity().getTitleBarHeight());
    }
    this.u.setCancelable(true);
    this.u.setMessage(paramString);
    this.u.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */