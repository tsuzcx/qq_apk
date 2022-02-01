package com.tencent.mobileqq.activity.contacts.base;

import acep;
import acfp;
import aklk;
import altq;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anlm;
import anot;
import anpc;
import aqho;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import wja;
import yqy;
import ysf;
import ysf.a;
import yzd;
import yze;
import yzf;
import yzp;
import yzr;
import zav;

public class Contacts
  extends acep
  implements Handler.Callback, View.OnClickListener, CommonLoadingView.a, ysf.a
{
  private RedTouch C;
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private yqy jdField_a_of_type_Yqy = new yze(this);
  private yzf jdField_a_of_type_Yzf;
  private zav jdField_a_of_type_Zav;
  private ImmersiveTitleBar2 jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private yzp jdField_b_of_type_Yzp;
  private boolean bpO;
  private aklk f = new yzd(this);
  private RelativeLayout fD;
  private LinearLayout fY;
  private RelativeLayout iq;
  private RelativeLayout ir;
  private boolean mHasInited;
  private TextView mTitle;
  private int mToastOffset;
  private ImageView pW;
  private ImageView uK;
  
  private void aC()
  {
    this.fY = ((LinearLayout)findViewById(2131365259));
    this.fD = ((RelativeLayout)this.fY.findViewById(2131377498));
    this.pW = ((ImageView)this.fY.findViewById(2131369594));
    this.pW.setVisibility(0);
    this.pW.setContentDescription(acfp.m(2131721053));
    this.pW.setOnClickListener(this);
    this.C = new RedTouch(a(), this.pW).a(21).e(10).a();
    this.mTitle = ((TextView)this.fY.findViewById(2131369627));
    this.mTitle.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.fY.findViewById(2131379866));
    this.iq = ((RelativeLayout)this.fY.findViewById(2131378734));
    IphoneTitleBarActivity.setLayerType(this.fD);
    IphoneTitleBarActivity.setLayerType(this.pW);
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.iq, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.fD, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      E(this.iq, false);
      this.fD.setBackgroundResource(2130851105);
    }
  }
  
  private void bpM()
  {
    this.app.registObserver(this.f);
    this.app.addObserver(this.jdField_a_of_type_Yqy);
    ((ysf)this.app.getManager(34)).a(this);
  }
  
  private void bpN()
  {
    this.app.unRegistObserver(this.f);
    this.app.removeObserver(this.jdField_a_of_type_Yqy);
    ((ysf)this.app.getManager(34)).b(this);
  }
  
  private void cne()
  {
    View localView = this.fY.findViewById(2131365239);
    this.jdField_b_of_type_Yzp = new yzp(a(), 2, localView);
    this.ir = ((RelativeLayout)localView.findViewById(2131372284));
    this.jdField_a_of_type_Zav = new zav(this.ir, this.app);
    this.ir.setOnClickListener(this);
    cnh();
  }
  
  private void cnf()
  {
    if (this.C != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.app.getManager(36)).getAppInfoByPath("101200");
      this.C.e(localAppInfo);
    }
  }
  
  private void cnh()
  {
    int k = 0;
    boolean bool = anlm.ayn();
    View localView = this.fY.findViewById(2131365239);
    int j;
    if (localView != null)
    {
      i = wja.dp2px(12.0F, getResources());
      if (this.ir != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.ir.getLayoutParams();
        if (!bool) {
          break label181;
        }
        j = 0;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
      }
      Object localObject = localView.findViewById(2131378485);
      if (localObject != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (bool) {
          i = 0;
        }
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label186;
      }
      i = 2130845862;
      label122:
      localObject = localView.findViewById(2131365992);
      ((View)localObject).setBackgroundResource(i);
      if (!bool) {
        break label193;
      }
      j = 0;
      label145:
      ((View)localObject).setVisibility(j);
      localView = localView.findViewById(2131365993);
      localView.setBackgroundResource(i);
      if (!bool) {
        break label199;
      }
    }
    label181:
    label186:
    label193:
    label199:
    for (int i = k;; i = 8)
    {
      localView.setVisibility(i);
      return;
      j = i;
      break;
      i = 2130845861;
      break label122;
      j = 8;
      break label145;
    }
  }
  
  private void initUI()
  {
    if (this.mToastOffset > 0) {
      return;
    }
    this.mToastOffset = (a().getTitleBarHeight() - (int)aqho.convertDpToPixel(a(), 5.0F));
    this.jdField_a_of_type_Yzf.onCreate();
    this.jdField_a_of_type_Yzf.EP(this.mToastOffset);
    aC();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)this.fY.findViewById(2131365078));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    this.uK = ((ImageView)this.fY.findViewById(2131365260));
    cng();
    cne();
  }
  
  private void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", fromResume = " + paramBoolean);
    }
    List localList;
    zav localzav;
    if (this.jdField_a_of_type_Zav != null)
    {
      localList = ((ysf)this.app.getManager(34)).cR();
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "updateUnreadCount|count = " + paramInt + ", realcount = " + localList.size() + ", fromResume = " + paramBoolean);
      }
      localzav = this.jdField_a_of_type_Zav;
      if (paramBoolean) {
        break label166;
      }
    }
    label166:
    for (boolean bool = true;; bool = false)
    {
      localzav.j(localList, bool, paramBoolean);
      if ((paramInt > 0) && (this.jdField_a_of_type_Yzf != null)) {
        this.jdField_a_of_type_Yzf.cnj();
      }
      return;
    }
  }
  
  public void Az(int paramInt)
  {
    updateUnreadCount(paramInt, false);
  }
  
  public void Bh(boolean paramBoolean)
  {
    this.bpO = paramBoolean;
  }
  
  public boolean PN()
  {
    return this.mHasInited;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(a()).inflate(2131559061, null);
    this.jdField_a_of_type_Yzf = new yzf(a());
    this.jdField_a_of_type_Yzf.u(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void bLU() {}
  
  public void bLV() {}
  
  public void bMe()
  {
    bpN();
    if (this.jdField_a_of_type_Yzf != null) {
      this.jdField_a_of_type_Yzf.bMe();
    }
  }
  
  public void bMf()
  {
    super.bMf();
    if (!this.mHasInited) {}
    while (this.jdField_a_of_type_Yzf == null) {
      return;
    }
    this.jdField_a_of_type_Yzf.bMf();
  }
  
  void cng()
  {
    if (this.jdField_a_of_type_Yzf != null) {
      this.jdField_a_of_type_Yzf.onPostThemeChanged();
    }
    if (this.uK == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "setThemeDiyBgContacts mBgImageView == null");
      }
    }
    View localView;
    do
    {
      return;
      ThemeBackground.applyThemeBg(this.app, this.uK, 3, 2130838901, "-contacts-");
      localView = this.fY.findViewById(2131379046);
    } while (localView == null);
    localView.setBackgroundResource(2130851105);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
      if (!this.mHasInited) {
        onResume(true);
      }
      this.mHasInited = true;
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9529, 300L);
      return true;
    } while (this.jdField_a_of_type_Yzf == null);
    this.jdField_a_of_type_Yzf.cnn();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if (paramInt2 == 0)
      {
        finish();
        this.app.exit(false);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 1000000) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("BindMsgConstant", 2, "bind phone suc requestCode: " + paramInt1 + ", src: " + 12);
      return;
    } while (paramInt1 != 99999);
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
    }
    ((PhoneContactManagerImp)this.app.getManager(11)).aC(true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(a(), AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 1);
      localIntent.putExtra("EntranceId", 3);
      startActivity(localIntent);
      anot.a(this.app, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((altq)this.app.getManager(36)).OS(String.valueOf(101200));
        label139:
        anpc.report("tim_contact_tab_add_friend_click");
        continue;
        this.jdField_a_of_type_Zav.reportClick();
        NewFriendActivity.g(a(), null, 2);
      }
      catch (Exception localException)
      {
        break label139;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    initUI();
    bpM();
    ((ysf)this.app.getManager(34)).clq();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_Yzp != null) {
      this.jdField_b_of_type_Yzp.onDestroy();
    }
    this.jdField_a_of_type_Yzf.onDestroy();
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    bpN();
  }
  
  public void onFirstDraw()
  {
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void onPause()
  {
    ApngImage.pauseByTag(3);
    super.onPause();
    this.jdField_a_of_type_Yzf.onPause();
  }
  
  public void onPostThemeChanged()
  {
    cng();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.iq, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.fD, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      cnh();
      yzr.if.clear();
      return;
      E(this.iq, false);
      this.fD.setBackgroundResource(2130851105);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    this.jdField_a_of_type_Yzf.onResume(paramBoolean);
    updateUnreadCount(((ysf)this.app.getManager(34)).xq(), true);
    if (AppSetting.enableTalkBack)
    {
      this.mTitle.setFocusable(true);
      String str = getString(2131695648);
      this.mTitle.setContentDescription(str);
      a().setTitle(getString(2131695648));
    }
    if (this.jdField_b_of_type_Yzp != null) {
      this.jdField_b_of_type_Yzp.onResume();
    }
    cnf();
    ((altq)this.app.getManager(36)).kP(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.bpO)
    {
      this.bpO = false;
      this.jdField_a_of_type_Yzf.cnk();
    }
  }
  
  public void pE(boolean paramBoolean)
  {
    if (this.app != null)
    {
      bpM();
      this.jdField_a_of_type_Yzf.aJ(this.app);
      if (!"0".equals(this.app.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      cng();
      this.jdField_a_of_type_Zav.onAccountChanged(this.app);
      ((ysf)this.app.getManager(34)).clq();
    } while (this.jdField_b_of_type_Yzp == null);
    this.jdField_b_of_type_Yzp.onAccountChanged(this.app);
  }
  
  public String setLastActivityName()
  {
    return a().getString(2131695648);
  }
  
  public static class a
  {
    public boolean bpP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts
 * JD-Core Version:    0.7.0.1
 */