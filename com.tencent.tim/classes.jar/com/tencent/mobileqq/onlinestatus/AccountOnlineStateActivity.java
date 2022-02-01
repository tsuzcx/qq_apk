package com.tencent.mobileqq.onlinestatus;

import accn;
import acff;
import akro;
import akrp;
import akrq;
import akrr;
import akrs;
import akrt;
import akru;
import aksl;
import aksl.a;
import aktg;
import akth;
import akti;
import aktk;
import aktm;
import akto;
import aktp;
import aktr;
import aktw;
import aktx;
import akty;
import akua;
import akua.a;
import akue;
import akun;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqgv;
import aqiw;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class AccountOnlineStateActivity
  extends IphoneTitleBarFragment
  implements aksl.a, akua.a, View.OnClickListener, OnlineStatusPagerAdapter.a
{
  private ImageView BW;
  private ImageView BX;
  private View Fx;
  private View Fy;
  private View Fz;
  private TextView WE;
  private TextView WF;
  private accn jdField_a_of_type_Accn = new akrq(this);
  private aksl jdField_a_of_type_Aksl;
  private akth jdField_a_of_type_Akth = new akru(this);
  private aktr jdField_a_of_type_Aktr = new akrt(this);
  private aktx jdField_a_of_type_Aktx = new akrs(this);
  private akua jdField_a_of_type_Akua;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new akrr(this);
  private FormSimpleItem aI;
  private long ael;
  private AutoReplyText jdField_b_of_type_ComTencentMobileqqDataAutoReplyText;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private boolean cuq;
  private LinearLayout jN;
  private volatile FragmentActivity mActivity;
  private QQAppInterface mApp;
  
  private void Ne(boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Aksl != null)
    {
      localArrayList = this.jdField_a_of_type_Aksl.dn();
      if (this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText == null) {
        break label68;
      }
    }
    label68:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;; i = 0)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText != null) {
        j = this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;
      }
      ((CardHandler)this.mApp.getBusinessHandler(2)).a(localArrayList, i, j, paramBoolean);
      return;
    }
  }
  
  private boolean a(akto paramakto, AppRuntime.Status paramStatus)
  {
    return (paramStatus == this.mApp.getOnlineStatus()) && (akti.a().k(this.mApp) == paramakto.id);
  }
  
  private void bw(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmitted online status " + paramBoolean + ", retCode = " + paramInt);
    }
    if (this.mActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.mActivity, 2, 2131720448, 1).show();
      this.mActivity.setResult(-1);
      this.mActivity.finish();
      return;
    }
    QQToast.a(this.mActivity, 1, 2131720446, 1).show();
  }
  
  private void dDi()
  {
    this.jN = ((LinearLayout)this.mContentView.findViewById(2131370844));
    this.aI = ((FormSimpleItem)this.mContentView.findViewById(2131361928));
    this.aI.setOnClickListener(this);
    this.BW = ((ImageView)this.mContentView.findViewById(2131378292));
    this.BX = ((ImageView)this.mContentView.findViewById(2131378309));
    this.Fx = ((FormSimpleItem)this.mContentView.findViewById(2131361931));
    this.Fy = this.mContentView.findViewById(2131369470);
    this.Fz = this.mContentView.findViewById(2131378310);
    this.WF = ((TextView)this.mContentView.findViewById(2131361930));
    this.WE = ((TextView)this.mContentView.findViewById(2131361929));
    this.Fx.setOnClickListener(this);
    this.Fy.setOnClickListener(this);
    ku(this.ael);
  }
  
  private void dDj()
  {
    if (this.aI == null) {
      return;
    }
    Object localObject = ((acff)this.mApp.getManager(51)).d(this.mApp.getCurrentUin());
    if (!TextUtils.isEmpty(((Friends)localObject).poiName)) {
      this.aI.setLeftText(((Friends)localObject).poiName);
    }
    for (;;)
    {
      if (((Friends)localObject).poiUpdateTime > 0L)
      {
        localObject = aktp.j(NetConnInfoCenter.getServerTime(), ((Friends)localObject).poiUpdateTime);
        this.aI.setRightText((CharSequence)localObject);
      }
      this.jN.setVisibility(0);
      return;
      this.aI.setLeftText("我的位置");
    }
  }
  
  private void dDk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmit online status " + this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    if (this.mActivity == null) {
      return;
    }
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      QQToast.a(this.mActivity, 1, 2131720447, 1).show();
      return;
    }
    if (this.jdField_a_of_type_Aksl.asJ()) {
      Ne(true);
    }
    for (;;)
    {
      aktm.a(this.mApp, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.ael);
      aktm.a(this.mApp, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.ael, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      return;
      Object localObject1 = this.jdField_a_of_type_Akua.a();
      Object localObject2 = akti.a().a((akto)localObject1);
      if ((localObject2 != null) && (!a((akto)localObject1, (AppRuntime.Status)localObject2)))
      {
        if (((akto)localObject1).id == -1L)
        {
          localObject1 = (akun)this.mApp.getBusinessHandler(174);
          localObject2 = ((aktp)this.mApp.getManager(369)).a();
          ((akun)localObject1).a(2, akti.a().a((akue)localObject2, false), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
        }
        else
        {
          this.mApp.a((AppRuntime.Status)localObject2, ((akto)localObject1).id);
          this.cuq = true;
        }
      }
      else
      {
        localObject2 = (aktw)this.mApp.getManager(370);
        if ((((akto)localObject1).id == -1L) && (((aktw)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem)))
        {
          akty.a(this.mApp, -1L, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
          return;
        }
        bw(true, 0);
      }
    }
  }
  
  private void dDl()
  {
    List localList = ((aktg)this.mApp.getManager(319)).fM();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_Aksl != null)) {
      this.jdField_a_of_type_Aksl.lK(localList);
    }
    ThreadManager.getSubThreadHandler().post(new AccountOnlineStateActivity.3(this));
  }
  
  private void initUI()
  {
    setRightButton(2131721079, new akro(this));
    setTitle(this.mActivity.getString(2131720459));
    LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130839642));
    Object localObject = getResources().getDrawable(2130845617);
    this.jdField_a_of_type_Akua = new akua(this.mActivity, localLinearLayout, this, 7);
    this.jdField_a_of_type_Akua.dDv();
    this.jdField_a_of_type_Aksl = new aksl(this.mApp, this.mActivity, (Drawable)localObject);
    this.jdField_a_of_type_Aksl.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.ael = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.mApp.getOnlineStatus();
      this.ael = akti.a().k(this.mApp);
    }
    this.jdField_a_of_type_Akua.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.ael, this);
    localObject = (ListView)this.mContentView.findViewById(2131361938);
    if ((localObject instanceof SwipListView))
    {
      ((SwipListView)localObject).setDragEnable(true);
      ((SwipListView)localObject).setRightIconMenuListener(new akrp(this));
    }
    ((ListView)localObject).addHeaderView(localLinearLayout);
    ((ListView)localObject).setAdapter(this.jdField_a_of_type_Aksl);
    ((ListView)localObject).setDividerHeight(0);
    if (getActivity().getIntent().getBooleanExtra("KEY_HAS_LEFT_BUTTON_TEXT", false)) {
      setLeftButton(2131721058, null);
    }
    dDi();
  }
  
  TopGestureLayout a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if ((paramView instanceof TopGestureLayout)) {
        return (TopGestureLayout)paramView;
      }
    }
    return null;
  }
  
  public void a(akto paramakto)
  {
    if (paramakto != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = akti.a().a(paramakto);
      this.ael = paramakto.id;
    }
    this.jdField_a_of_type_Aksl.setShow(aktk.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
  }
  
  public void a(akto paramakto1, akto paramakto2)
  {
    if (paramakto2 != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = akti.a().a(paramakto2);
      this.ael = paramakto2.id;
    }
    this.jdField_a_of_type_Aksl.setShow(aktk.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
    if (this.jN != null) {
      ku(this.ael);
    }
  }
  
  public void a(AutoReplyText paramAutoReplyText)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "text is added, text = " + paramAutoReplyText);
    }
  }
  
  public void a(AutoReplyText paramAutoReplyText1, AutoReplyText paramAutoReplyText2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText1 + " is checked, lastChecked is " + paramAutoReplyText2);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText1;
    this.jdField_b_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText2;
  }
  
  public void a(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is delete");
    }
    anot.a(this.mApp, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void b(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is click");
    }
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      aktm.dB(this.mApp);
    }
    if (this.mActivity != null) {
      AutoReplyEditActivity.a(this.mActivity, 325, paramAutoReplyText);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mActivity != null)
    {
      this.mApp = this.mActivity.app;
      initUI();
      dDl();
      this.mApp.addObserver(this.jdField_a_of_type_Accn);
      this.mApp.registObserver(this.jdField_a_of_type_Akth);
      this.mApp.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.mApp.addObserver(this.jdField_a_of_type_Aktr);
      this.mApp.registObserver(this.jdField_a_of_type_Aktx);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558449;
  }
  
  public void ku(long paramLong)
  {
    int j = 0;
    if ((this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online) && (paramLong == -1L))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)getActivity().getIntent().getSerializableExtra("online_status_permission_item"));
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
        {
          localObject = ((aktw)this.mApp.getManager(370)).a(paramLong, false);
          if (localObject == null) {
            break label187;
          }
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(paramLong, ((OnlineStatusPermissionEntity)localObject).allHasPermission, ((OnlineStatusPermissionEntity)localObject).hasPermissionList);
        }
      }
      dDj();
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission())
      {
        this.BW.setVisibility(0);
        this.BX.setVisibility(8);
        this.Fz.setVisibility(8);
      }
      for (;;)
      {
        localObject = this.BX;
        int i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        ((aktp)this.mApp.getManager(369)).x(getActivity());
        label187:
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(paramLong, true, null);
          break;
          this.BW.setVisibility(8);
          this.BX.setVisibility(0);
          this.Fz.setVisibility(0);
        } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins() == null);
        localObject = new SpannableStringBuilder();
        i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size())
        {
          Long localLong = (Long)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().get(i);
          ((SpannableStringBuilder)localObject).append(aqgv.D(this.mApp, String.valueOf(localLong)));
          if (i != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() - 1) {
            ((SpannableStringBuilder)localObject).append("、");
          }
          i += 1;
        }
        this.WE.setText(((SpannableStringBuilder)localObject).toString());
        localObject = getResources().getDrawable(2130839512);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        this.WF.setCompoundDrawables(null, null, (Drawable)localObject, null);
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() > 0) {
          this.WF.setText("（" + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() + "人）");
        } else {
          this.WF.setText("");
        }
      }
    }
    this.jN.setVisibility(8);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 != 325) {
              break;
            }
          } while (paramInt2 != 325);
          AutoReplyText localAutoReplyText = (AutoReplyText)paramIntent.getParcelableExtra("AutoReplyEditActivity:text");
          if (localAutoReplyText != null)
          {
            this.jdField_a_of_type_Aksl.b(localAutoReplyText);
            this.jdField_a_of_type_Aksl.nR(localAutoReplyText.getTextId());
          }
        } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.mActivity == null));
        QQToast.a(this.mActivity, 2, 2131690686, 1).show();
        return;
      } while (paramInt1 != 100);
      paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.mActivity, this.mActivity.app, false);
    } while (paramIntent == null);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramIntent;
    ku(this.ael);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aksl.asJ()) {
      if (aqiw.isNetworkAvailable(this.mActivity)) {
        Ne(false);
      }
    }
    for (;;)
    {
      super.onBackEvent();
      return true;
      QLog.d("AccountOnlineStateActivity", 2, "onBackEvent network is not available");
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onBackEvent auto reply list not changed!");
      }
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "account_online_status_show_all!");
      }
      if (this.BW.getVisibility() != 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) && (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateActivity", 2, "account_online_status_show_all! mOnlinePermission is part");
          }
          this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(this.ael, true, null);
        ku(this.ael);
        continue;
        Object localObject = ((aktp)this.mApp.getManager(369)).a();
        if (localObject != null) {
          ((akue)localObject).mUpdateTime = NetConnInfoCenter.getServerTime();
        }
        for (;;)
        {
          OnlineStatusLocationFragment.a(getActivity(), this.mApp.getCurrentAccountUin(), this.mApp.getCurrentNickname(), (akue)localObject);
          anot.a(null, "dc00898", "", "", "0X800AE79", "0X800AE79", 3, 0, "", "", "", "");
          break;
          localObject = new akue(0.0D, 0.0D, "暂时无法获取地址");
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountOnlineStateActivity", 2, "account_online_status_show_part!");
        }
        if (this.BX.getVisibility() != 0)
        {
          if (QLog.isColorLevel()) {
            if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
              break label327;
            }
          }
          label327:
          for (localObject = "null";; localObject = " not null")
          {
            QLog.d("AccountOnlineStateActivity", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
            if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
              break label334;
            }
            OnlineStatusPermissionChecker.a(this.mApp, this.mActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
            break;
          }
          label334:
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
          ku(this.ael);
        }
        else
        {
          OnlineStatusPermissionChecker.a(this.mApp, this.mActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.removeObserver(this.jdField_a_of_type_Accn);
    this.mApp.unRegistObserver(this.jdField_a_of_type_Akth);
    this.mApp.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.mApp.removeObserver(this.jdField_a_of_type_Aktr);
    this.mApp.unRegistObserver(this.jdField_a_of_type_Aktx);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.mActivity = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity
 * JD-Core Version:    0.7.0.1
 */