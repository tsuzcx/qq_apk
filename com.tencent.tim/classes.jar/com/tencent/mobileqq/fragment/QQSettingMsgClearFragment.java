package com.tencent.mobileqq.fragment;

import acbn;
import ahau;
import ahop;
import ahoq;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anot;
import arhz;
import ausj;
import ausj.a;
import auss;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.VersionUtils;
import rvx;

public class QQSettingMsgClearFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private static long aaM;
  private View Dv;
  private View Dw;
  private BounceScrollView e;
  public Handler handler = new ahoq(this);
  private long lastClickTime;
  private QQAppInterface mApp;
  public arhz v;
  
  private void initUI()
  {
    this.e = ((BounceScrollView)this.mContentView.findViewById(2131377757));
    this.Dw = this.mContentView.findViewById(2131374963);
    this.Dw.setOnClickListener(this);
    this.mContentView.findViewById(2131365675).setOnClickListener(this);
    this.mContentView.findViewById(2131381382).setOnClickListener(this);
    this.Dv = this.mContentView.findViewById(2131365672);
    this.Dv.setOnClickListener(this);
    this.Dv.setContentDescription(getString(2131692467));
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
  }
  
  public static boolean qH()
  {
    long l = System.currentTimeMillis();
    if (l - aaM <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMsgClearFragment", 2, "click too fast");
      }
      aaM = l;
      return true;
    }
    aaM = l;
    return false;
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
  
  protected int getContentLayoutId()
  {
    return 2131561687;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int j = 0;
    if (paramView.getId() == 2131365675)
    {
      localObject1 = new Intent(this.mApp.getApp(), FMActivity.class);
      ((Intent)localObject1).putExtra("selectMode", true);
      ((Intent)localObject1).putExtra("targetUin", acbn.bkw);
      ((Intent)localObject1).putExtra("tab_tab_type", 8);
      ((Intent)localObject1).putExtra("only_show_local_tab", true);
      ((Intent)localObject1).putExtra("max_select_count", 999999);
      anot.a(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
      startActivityForResult((Intent)localObject1, 1);
      getActivity().overridePendingTransition(2130771991, 2130771992);
      ahau.JH("0x80087C4");
      anot.a(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
      QQSettingMsgHistoryActivity.bUu();
    }
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() == 2131381382)
        {
          localObject1 = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
          ((Intent)localObject1).putExtra("set_display_type", 1);
          getActivity().startActivity((Intent)localObject1);
          anot.a(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
        }
        else
        {
          if (paramView.getId() != 2131374963) {
            break;
          }
          if (!qH())
          {
            localObject1 = new Intent();
            localObject2 = AIOImageProviderService.a(this.mApp.getCurrentUin(), "", 0, null, false);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject2).asBinder()));
            localBundle.putInt("jump", 1);
            ((Intent)localObject1).putExtras(localBundle);
            ((Intent)localObject1).setFlags(805306368);
            anot.a(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
            PublicFragmentActivity.b.startForResult(this, (Intent)localObject1, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
            QQSettingMsgHistoryActivity.bUu();
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
      i = 2131692466;
      j = 2131701633;
      localObject1 = new ahop(this, (ausj)localObject2);
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131701637));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.v != null) && (this.v.isShowing())) {
      showProgressBar(false);
    }
    super.onDestroy();
    QQSettingMsgHistoryActivity.bUu();
    rvx.cJ(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment
 * JD-Core Version:    0.7.0.1
 */