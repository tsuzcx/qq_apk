package com.tencent.mobileqq.activity;

import accn;
import acfd;
import acff;
import acfp;
import acgs;
import acle;
import acms;
import acnd;
import acof;
import aevy;
import ahpp;
import aibn;
import ajdo.a;
import ajok;
import amfk;
import amhj;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anlm;
import anot;
import aqiw;
import aqmj;
import aqqb;
import aqrt;
import arhz;
import arib;
import avpw;
import avpw.d;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;
import rpq;
import vkt;
import vku;
import vkv;
import vkw;
import vkx;
import vky;
import vkz;
import vla;
import vlb;
import vlc;
import vld;
import vle;
import wja;
import yux;
import yuy;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements ajdo.a, View.OnClickListener, yux
{
  public TextView Ey;
  TextView Ez;
  public FormSimpleItem P;
  public FormSimpleItem Q;
  private FormSimpleItem R;
  private FormSimpleItem S;
  private FormSimpleItem T;
  private FormSimpleItem U;
  private FormSimpleItem V;
  FormSimpleItem W;
  private acof jdField_a_of_type_Acof;
  ahpp jdField_a_of_type_Ahpp = new vlb(this);
  aibn jdField_a_of_type_Aibn = new vle(this);
  private amfk jdField_a_of_type_Amfk = new vkx(this);
  private amhj jdField_a_of_type_Amhj;
  public CompoundButton.OnCheckedChangeListener a;
  protected arib a;
  public FormSwitchItem al;
  public FormSwitchItem am;
  public FormSwitchItem an;
  public FormSwitchItem ao;
  public FormSwitchItem ap;
  public FormSwitchItem aq;
  public FormSwitchItem ar;
  public FormSwitchItem as;
  public FormSwitchItem at;
  public FormSwitchItem au;
  acgs jdField_b_of_type_Acgs = new vku(this);
  acnd jdField_b_of_type_Acnd = new vlc(this);
  public CompoundButton b;
  private int bIT;
  acfd jdField_c_of_type_Acfd = new vld(this);
  public acms c;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  private accn cardObserver = new vkv(this);
  private CompoundButton jdField_d_of_type_AndroidWidgetCompoundButton;
  private PhoneContactManagerImp jdField_d_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  protected BounceScrollView d;
  private int mSource = -1;
  View tJ;
  View tK;
  private arhz u;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_b_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new vkw(this);
  }
  
  private void Bm(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).show(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void bSd()
  {
    ThreadManager.excute(new PermisionPrivacyActivity.4(this), 16, null, true);
  }
  
  private void bSe() {}
  
  private void bSf()
  {
    if ((isFinishing()) || (this.W.getVisibility() != 0)) {
      return;
    }
    ThreadManager.excute(new PermisionPrivacyActivity.5(this), 16, null, true);
  }
  
  private void bSg()
  {
    if (aqiw.isNetworkAvailable(this)) {
      ((acle)this.app.getBusinessHandler(13)).h(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void bSh()
  {
    Object localObject2 = ((acff)this.app.getManager(51)).b(this.app.getCurrentUin());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = aqrt.a().c(this.app.getCurrentUin(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, rpq.dip2px(this.app.getApp(), 47.0F), rpq.dip2px(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new vky(this));
        this.R.setRightIcon((Drawable)localObject1, rpq.dip2px(this.app.getApp(), 47.0F), rpq.dip2px(this.app.getApp(), 14.0F));
        this.R.setRightText("");
      }
    }
    for (;;)
    {
      this.R.setOnClickListener(new vkz(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.R.setRightText(this.app.getApp().getResources().getString(2131696994));
      this.R.setRightIcon(null);
    }
  }
  
  public static void df(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "gotoFriendSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  private void initUI()
  {
    boolean bool2 = true;
    this.aq = ((FormSwitchItem)findViewById(2131363128));
    this.Ey = ((TextView)findViewById(2131363129));
    boolean bool1 = aqmj.ar(this, this.app.getCurrentAccountUin());
    this.aq.a().setChecked(bool1);
    Object localObject1 = this.Ey;
    int i;
    Object localObject2;
    label218:
    Object localObject3;
    if (bool1)
    {
      i = 2131694507;
      ((TextView)localObject1).setText(i);
      this.aq.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_Acms.cMI();
      this.tK = findViewById(2131375728);
      this.tJ = findViewById(2131374964);
      this.R = ((FormSimpleItem)findViewById(2131373359));
      bSh();
      this.S = ((FormSimpleItem)findViewById(2131374981));
      localObject1 = (acff)this.app.getManager(51);
      this.ar = ((FormSwitchItem)findViewById(2131374996));
      localObject2 = (aevy)this.app.getManager(41);
      if (!((aevy)localObject2).aio()) {
        break label1162;
      }
      this.ar.setChecked(((aevy)localObject2).aim());
      this.ar.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131378199));
      this.jdField_d_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131378732));
      this.am = ((FormSwitchItem)findViewById(2131378288));
      this.am.setChecked(this.app.aR(false));
      this.an = ((FormSwitchItem)findViewById(2131378284));
      this.an.setChecked(this.app.aS(false));
      this.al = ((FormSwitchItem)findViewById(2131372227));
      this.ap = ((FormSwitchItem)findViewById(2131362679));
      this.P = ((FormSimpleItem)findViewById(2131364178));
      this.Q = ((FormSimpleItem)findViewById(2131380197));
      this.ao = ((FormSwitchItem)findViewById(2131372986));
      this.Ez = ((TextView)findViewById(2131372987));
      localObject1 = ((acff)localObject1).c(this.app.getCurrentAccountUin());
      this.ao.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1174;
      }
      this.P.setRightText(acfp.m(2131701654));
      label435:
      if (!((Card)localObject1).troopHonorSwitch) {
        break label1190;
      }
      this.Q.setRightText(acfp.m(2131701654));
      label456:
      this.U = ((FormSimpleItem)findViewById(2131374969));
      this.U.setOnClickListener(this);
      bSd();
      this.V = ((FormSimpleItem)findViewById(2131374970));
      this.V.setOnClickListener(this);
      anot.a(null, "dc00898", "", "", "0X800ACA5", "0X800ACA5", 0, 0, "", "0", "0", "");
      this.W = ((FormSimpleItem)findViewById(2131374965));
      bSe();
      localObject2 = (CardHandler)this.app.getBusinessHandler(2);
      ((CardHandler)localObject2).cHB();
      ((CardHandler)localObject2).cHC();
      this.as = ((FormSwitchItem)findViewById(2131374967));
      localObject3 = this.as;
      if ((this.jdField_a_of_type_Amhj == null) || (!this.jdField_a_of_type_Amhj.avP())) {
        break label1206;
      }
      bool1 = true;
      label613:
      ((FormSwitchItem)localObject3).setChecked(bool1);
      this.tK.setOnClickListener(this);
      this.tJ.setOnClickListener(this);
      xL(this.app.abw());
      this.jdField_d_of_type_AndroidWidgetCompoundButton.setChecked(this.app.aby());
      bool1 = this.app.abx();
      a(this.al.a(), bool1);
      a(this.ap.a(), ((Card)localObject1).strangerInviteMeGroupOpen);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.al.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.ap.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.am.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.an.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.as.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.ao.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.P.setOnClickListener(this);
      this.Q.setOnClickListener(this);
      this.T = ((FormSimpleItem)findViewById(2131363123));
      this.T.setOnClickListener(this);
      this.at = ((FormSwitchItem)super.findViewById(2131371203));
      if (aqmj.aG(getApplication(), this.app.getCurrentAccountUin()) == 1) {}
      localObject3 = (FormSimpleItem)findViewById(2131365564);
      if ((localObject3 == null) || (!aqqb.a().aFv())) {
        break label1211;
      }
      ((FormSimpleItem)localObject3).setLeftText(getResources().getString(2131692358));
      ((FormSimpleItem)localObject3).a().setMaxWidth(wja.dp2px(130.0F, getResources()));
      ((FormSimpleItem)localObject3).setOnClickListener(new vkt(this));
      PermisionPrivacyActivity.2 local2 = new PermisionPrivacyActivity.2(this, (FormSimpleItem)localObject3);
      local2.run();
      ((FormSimpleItem)localObject3).setTag("online_status_callback".hashCode(), local2);
      aqqb.a().aq(local2);
      label966:
      if (AppSetting.enableTalkBack)
      {
        this.tK.setContentDescription(getResources().getString(2131701613));
        this.tJ.setContentDescription(acfp.m(2131709429));
        this.ar.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.am.setContentDescription(acfp.m(2131709424));
        this.an.setContentDescription(acfp.m(2131709422));
        this.al.setContentDescription(getResources().getString(2131696269));
        this.ap.setContentDescription(getResources().getString(2131690289));
        this.as.setContentDescription(acfp.m(2131709423));
        this.ao.setContentDescription(acfp.m(2131709425));
      }
      ((CardHandler)localObject2).cHx();
      this.au = ((FormSwitchItem)findViewById(2131378308));
      localObject2 = this.au;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1226;
      }
    }
    label1162:
    label1174:
    label1190:
    label1206:
    label1211:
    label1226:
    for (bool1 = bool2;; bool1 = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool1);
      this.au.setOnCheckedChangeListener(new vla(this));
      return;
      i = 2131694508;
      break;
      this.ar.setVisibility(8);
      break label218;
      this.P.setRightText(acfp.m(2131701656));
      break label435;
      this.Q.setRightText(acfp.m(2131701656));
      break label456;
      bool1 = false;
      break label613;
      if (localObject3 == null) {
        break label966;
      }
      ((FormSimpleItem)localObject3).setVisibility(8);
      break label966;
    }
  }
  
  private void xK(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new PermisionPrivacyActivity.12(this, paramBoolean));
  }
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, yuy paramyuy)
  {
    paramyuy.AV(paramBoolean);
  }
  
  void bJQ()
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
  
  public void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      bSd();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mSource = getIntent().getIntExtra("kSrouce", -1);
    super.setContentView(2131561689);
    setTitle(2131701650);
    this.jdField_a_of_type_Arib = new arib(this);
    this.jdField_a_of_type_Amhj = ((amhj)this.app.getManager(15));
    this.jdField_a_of_type_Acof = ((acof)this.app.getManager(85));
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.addListener(this.jdField_a_of_type_Amfk);
    }
    this.jdField_d_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_d_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
    this.jdField_c_of_type_Acms = ((acms)this.app.getBusinessHandler(20));
    initUI();
    addObserver(this.jdField_b_of_type_Acgs);
    addObserver(this.jdField_c_of_type_Acfd);
    addObserver(this.jdField_a_of_type_Aibn);
    addObserver(this.cardObserver);
    addObserver(this.jdField_b_of_type_Acnd);
    addObserver(this.jdField_a_of_type_Ahpp);
    this.app.cLE();
    this.app.cLF();
    this.app.aR(true);
    this.app.aS(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bJQ();
    if (this.cardObserver != null) {
      removeObserver(this.cardObserver);
    }
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.removeListener(this.jdField_a_of_type_Amfk);
    }
    removeObserver(this.jdField_b_of_type_Acgs);
    removeObserver(this.jdField_c_of_type_Acfd);
    removeObserver(this.jdField_a_of_type_Aibn);
    removeObserver(this.jdField_b_of_type_Acnd);
    removeObserver(this.jdField_a_of_type_Ahpp);
    if (this.jdField_a_of_type_Arib != null)
    {
      this.jdField_a_of_type_Arib.dismiss();
      this.jdField_a_of_type_Arib = null;
    }
    if (this.jdField_d_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp != null) {
      this.jdField_d_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bSh();
    bSg();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    int i;
    BounceScrollView localBounceScrollView;
    if (paramBoolean)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377758));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        i = this.aq.getTop() - rpq.getWindowScreenHeight(this) / 2;
        localBounceScrollView = this.jdField_d_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (i <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, i);
      this.aq.setBackgroundResource(2130851348);
      ThreadManager.getUIHandler().postDelayed(new PermisionPrivacyActivity.13(this), 1000L);
      return;
      label98:
      i = 0;
    }
  }
  
  public void eH(long paramLong) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      df(this);
      anot.a(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      continue;
      Object localObject = avpw.d.a();
      ((avpw.d)localObject).cMP = this.app.getCurrentAccountUin();
      ((avpw.d)localObject).nickname = this.app.getCurrentNickname();
      avpw.b(this, (avpw.d)localObject, -1);
      anot.a(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      continue;
      anot.a(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
      localObject = ajok.xt();
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject));
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
        localObject = new Intent(this, ShowReactiveActivity.class);
        ((Intent)localObject).putExtra("entry", 1);
        startActivity((Intent)localObject);
        continue;
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        String str = "?mode_color=ffffff";
        localObject = str;
        if (anlm.ayn())
        {
          int i = anlm.Kb();
          localObject = str;
          if (i != 0)
          {
            localObject = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
            localObject = "?mode_color=" + (String)localObject;
          }
        }
        localObject = "https://qun.qq.com/interactive/usersetting" + (String)localObject;
        localIntent.putExtra("url", (String)localObject + "&_wv=3");
        startActivity(localIntent);
        continue;
        AuthorityControlFragment.bx(this);
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.bIT + "", "", "", "");
        PublicFragmentActivity.startForResult(this, ShieldFriendsListFragment.class, 1);
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        startActivity((Intent)localObject);
        anot.a(null, "dc00898", "", "", "0X800ACA6", "0X800ACA6", 0, 0, "", "0", "0", "");
      }
    }
  }
  
  public void sc(int paramInt) {}
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt) {}
  
  public void vl(String paramString)
  {
    if (this.u == null) {
      this.u = new arhz(this, getTitleBarHeight());
    }
    this.u.setCancelable(true);
    this.u.setMessage(paramString);
    this.u.show();
  }
  
  public void xL(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */