package com.tencent.mobileqq.activity;

import acfd;
import acfp;
import achq;
import acmf;
import ajqp;
import akti;
import aktr;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anxj;
import anxk;
import anxr;
import aqcl;
import aqdf;
import aqdf.a;
import aqeu;
import aqgv;
import aqgx;
import aqha;
import aqht;
import aqju;
import arhz;
import arjo;
import ausj;
import ausj.a;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import jqs;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import tog;
import ucc;
import ucd;
import uce;
import ucf;
import uch;
import uci;
import ucj;
import uck;
import ucl;
import ucm;
import ucn;
import uco;
import ucp;
import ucq;
import ucr;
import uct;
import ucu;
import ucv;
import ucw;
import ucx;
import ucy;
import ucz;
import uda;
import udb;
import udc;
import udd;
import ude;
import wja;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public TextView BA;
  ausj P = null;
  private acmf jdField_a_of_type_Acmf = new ucq(this);
  private aktr jdField_a_of_type_Aktr = new ucy(this);
  private c jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$c = new c();
  private RotateSwitchImageView jdField_a_of_type_ComTencentMobileqqWidgetRotateSwitchImageView;
  public SimpleAccount a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ucx(this);
  private String aKz;
  private boolean aQR;
  private boolean aQS;
  private boolean aQT;
  public boolean aQU = true;
  public boolean aQV;
  public boolean aQW = true;
  Animation al;
  Animation am;
  private Card jdField_b_of_type_ComTencentMobileqqDataCard;
  AccountObserver jdField_b_of_type_MqqObserverAccountObserver = new ucm(this);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new ucl(this);
  private aqdf.a c = new ucz(this);
  private View.OnClickListener cT = new ucc(this);
  View.OnClickListener cU = new uch(this);
  View.OnClickListener cV = new uci(this);
  private View.OnClickListener cW = new ucj(this);
  private View.OnClickListener cX = new uck(this);
  private aqdf d;
  float density;
  private HashMap<String, Bitmap> eA = new HashMap();
  public LinearLayout fJ;
  public boolean fk = false;
  acfd jdField_g_of_type_Acfd = new ucp(this);
  private arhz jdField_g_of_type_Arhz;
  private HashMap<String, String> gw = new HashMap();
  FormSwitchItem i;
  FormSimpleItem m;
  private achq mMsgObserver = new ucr(this);
  private FormSimpleItem n;
  private float oR;
  private float of;
  DialogInterface.OnDismissListener onDismissListener;
  private View.OnTouchListener p = new ucf(this);
  Dialog pd;
  private ImageView pg;
  private ImageView ph;
  public List<SimpleAccount> qg;
  private View ri;
  private View rj;
  aqju v;
  public Dialog x;
  public Dialog y;
  
  public AccountManageActivity()
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.destroy();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int j = aqeu.J(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    aqeu.z(paramActivity, paramQQAppInterface.getCurrentAccountUin(), j + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.isPlaying())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  private void aM(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.aKz, this.app.jm(this.aKz), new b(paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.aKz);
    }
    if (paramBoolean) {
      ajqp.ML(paramString);
    }
  }
  
  private void bFj()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_b_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L) {
        FriendProfileCardActivity.lQQMasterLogindays = this.jdField_b_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
      }
    }
    for (Object localObject = String.format(getString(2131695586), new Object[0]);; localObject = String.format(getString(2131695586), new Object[0]))
    {
      if (this.x == null) {
        break label135;
      }
      localTextView = (TextView)this.x.findViewById(2131365863);
      if (localTextView != null)
      {
        localTextView.requestFocus();
        localTextView.setText((CharSequence)localObject);
        localTextView.setContentDescription((CharSequence)localObject);
      }
      this.x.show();
      return;
      FriendProfileCardActivity.lQQMasterLogindays = 30L;
      break;
    }
    label135:
    this.x = new ReportDialog(this, 2131756467);
    this.x.setContentView(2131559127);
    TextView localTextView = (TextView)this.x.findViewById(2131365867);
    if (localTextView != null) {
      localTextView.setText(getString(2131695581));
    }
    localTextView = (TextView)this.x.findViewById(2131365863);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    localObject = (TextView)this.x.findViewById(2131365852);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131721058);
      ((TextView)localObject).setOnClickListener(new ucd(this));
    }
    localObject = (TextView)this.x.findViewById(2131365858);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131695583);
      ((TextView)localObject).setOnClickListener(new uce(this));
    }
    this.x.show();
  }
  
  private void bFk()
  {
    this.pd = new ReportDialog(this, 2131756467);
    this.pd.setContentView(2131558460);
    ((TextView)this.pd.findViewById(2131365863)).setText(getString(2131692539));
    this.pd.setCancelable(false);
  }
  
  private void bFl()
  {
    this.fJ.removeAllViews();
    if (this.qg == null) {
      return;
    }
    int j = 0;
    if (j < this.qg.size())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "bindAccountListView i=" + j + ", account=" + this.qg.get(j));
      }
      View localView;
      if (this.qg.get(j) == null)
      {
        localView = getLayoutInflater().inflate(2131558442, this.fJ, false);
        this.BA = ((TextView)localView.findViewById(2131372285));
        localView.setOnClickListener(this.cV);
        localView.setTag(null);
        this.fJ.addView(localView);
      }
      for (;;)
      {
        j += 1;
        break;
        localView = getLayoutInflater().inflate(2131558443, this.fJ, false);
        localView.setTag(Integer.valueOf(j));
        ((ImageView)localView.findViewById(2131368698)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.cU);
        localView.setOnTouchListener(this.p);
        if ((localView instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localView).setBGType(2);
        }
        ((Button)localView.findViewById(2131365671)).setOnClickListener(this.cX);
        ((RotateSwitchImageView)localView.findViewById(2131365700)).setOnClickListener(this.cW);
        this.fJ.addView(localView);
      }
    }
    bFn();
  }
  
  private void bFn()
  {
    if ((this.fJ == null) || (this.fJ.getChildCount() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "updateAccountListView accountListLinearLayout is null or size is 0.");
      }
    }
    QQAppInterface localQQAppInterface;
    int j;
    label83:
    View localView;
    Object localObject;
    int k;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int i1 = this.fJ.getChildCount();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView account size=" + i1);
        }
        localQQAppInterface = this.app;
        j = 0;
        if (j >= i1) {
          break;
        }
        localView = this.fJ.getChildAt(j);
        localObject = localView.getTag();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView i=" + j + ", view tag=" + localObject);
        }
      } while (localObject == null);
      k = ((Integer)localObject).intValue();
      localSimpleAccount = (SimpleAccount)this.qg.get(k);
    } while (localSimpleAccount == null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368698);
    String str1 = localSimpleAccount.getUin();
    ImageView localImageView2 = (ImageView)localView.findViewById(2131364570);
    localImageView2.clearAnimation();
    if ((str1 != null) && (str1.length() > 0) && (str1.equals(this.app.getCurrentAccountUin())) && (!this.fk))
    {
      localImageView2.setVisibility(0);
      label262:
      ((TextView)localView.findViewById(2131361874)).setText(str1);
      TextView localTextView = (TextView)localView.findViewById(2131372190);
      if ((this.gw.containsKey(str1)) && (!TextUtils.isEmpty((CharSequence)this.gw.get(str1)))) {
        break label438;
      }
      String str2 = BaseApplicationImpl.sApplication.getProperty(Constants.PropertiesKey.nickName.toString() + str1);
      localObject = str2;
      if (TextUtils.isEmpty(str2)) {
        localObject = str1;
      }
      label369:
      localTextView.setText((CharSequence)localObject);
      ThreadManager.postImmediately(new AccountManageActivity.14(this, localQQAppInterface, str1, localSimpleAccount, (String)localObject, localTextView, localImageView1), null, true);
      if (AppSetting.enableTalkBack)
      {
        if (!this.fk) {
          break label455;
        }
        localView.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      j += 1;
      break label83;
      break;
      localImageView2.setVisibility(8);
      break label262;
      label438:
      localObject = (String)this.gw.get(str1);
      break label369;
      label455:
      if (localImageView2.getVisibility() == 0) {}
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          break label506;
        }
        localView.setContentDescription((String)localObject + acfp.m(2131701974));
        break;
      }
      label506:
      localView.setContentDescription((String)localObject + acfp.m(2131701970));
    }
  }
  
  private void bFp()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.app.getCurrentAccountUin());
    startActivityForResult(localIntent, 9876);
  }
  
  private void bFq()
  {
    AppRuntime.Status localStatus = this.app.getOnlineStatus();
    this.m.setRightText(i());
    this.m.setTag(localStatus);
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, String.format("updateOnlineStatus: %s", new Object[] { localStatus }));
    }
  }
  
  private void bFt()
  {
    if (this.al == null)
    {
      this.al = AnimationUtils.loadAnimation(this, 2130771985);
      this.al.setFillAfter(true);
    }
    if (this.am == null)
    {
      this.am = AnimationUtils.loadAnimation(this, 2130771986);
      this.am.setFillAfter(true);
    }
  }
  
  private View f(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131378161);
    }
    return null;
  }
  
  private View g(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131372193);
    }
    return null;
  }
  
  private CharSequence i()
  {
    Object localObject2 = this.app.getOnlineStatus();
    long l = akti.a().k(this.app);
    Object localObject1 = akti.a().a(l, (AppRuntime.Status)localObject2);
    localObject2 = akti.a().a(l, (AppRuntime.Status)localObject2, 1);
    if (localObject2 == null) {
      return localObject1;
    }
    Rect localRect = ((Drawable)localObject2).getBounds();
    if ((localRect.left == 0) && (localRect.right == 0) && (localRect.top == 0) && (localRect.bottom == 0))
    {
      int j = wja.dp2px(16.0F, getResources());
      ((Drawable)localObject2).setBounds(0, 0, j, j);
    }
    localObject2 = new arjo((Drawable)localObject2);
    ((arjo)localObject2).setRightMargin(wja.dp2px(8.0F, getResources()));
    localObject1 = new SpannableString("[online]" + (String)localObject1);
    ((SpannableString)localObject1).setSpan(localObject2, 0, "[online]".length(), 17);
    return localObject1;
  }
  
  private void initAccountList()
  {
    Object localObject2;
    if (this.qg == null)
    {
      this.qg = new ArrayList();
      getAppRuntime().getApplication().refreAccountList();
      localObject2 = getAppRuntime().getApplication().getAllAccounts();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initAccountList list=").append(localObject2).append(", size=");
        if (localObject2 == null) {
          break label217;
        }
        localObject1 = Integer.valueOf(((List)localObject2).size());
        label84:
        QLog.i("AccountManageActivity", 2, localObject1);
      }
      if (localObject2 != null) {
        this.qg.addAll((Collection)localObject2);
      }
      if (this.qg != null) {
        this.qg.add(null);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("initAccountList accountList=").append(this.qg).append(", size=");
        if (this.qg == null) {
          break label224;
        }
      }
    }
    label217:
    label224:
    for (Object localObject1 = Integer.valueOf(this.qg.size());; localObject1 = "null")
    {
      QLog.i("AccountManageActivity", 2, localObject1);
      bFl();
      return;
      this.qg.clear();
      break;
      localObject1 = "null";
      break label84;
    }
  }
  
  private void vF(boolean paramBoolean)
  {
    Object localObject3 = (anxr)this.app.getManager(61);
    int i2 = ((anxr)localObject3).Kx();
    Object localObject1 = (TipsBar)findViewById(2131378932);
    ((TipsBar)localObject1).setBackgroundColor(getResources().getColor(2131167278));
    ((TipsBar)localObject1).setTipsIcon(getResources().getDrawable(2130851484));
    ((TipsBar)localObject1).getTextView().setTextColor(getResources().getColorStateList(2131167311));
    if (((TipsBar)localObject1).cC() != null) {
      ((TipsBar)localObject1).cC().setVisibility(8);
    }
    int k = 0;
    int i1 = 0;
    int j;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      j = i1;
      if (!this.aQT)
      {
        j = i1;
        if (i2 == 0)
        {
          if (!aqgx.a().aCB()) {
            break label674;
          }
          if (!this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(5000)) {
            break label649;
          }
          j = i1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (i2 <= 0) {
          break label679;
        }
        bool = true;
        label180:
        QLog.d("AccountManageActivity", 2, bool);
      }
      k = j;
      if (i2 == 0)
      {
        ThreadManager.post(new AccountManageActivity.9(this), 8, null, false);
        k = j;
      }
    }
    if ((k == 0) && (i2 == 1)) {
      if (aqgx.a().ro(this.app.getCurrentAccountUin())) {
        j = k;
      }
    }
    for (;;)
    {
      switch (j)
      {
      default: 
        label249:
        if (((TipsBar)localObject1).getVisibility() != 8) {
          ((TipsBar)localObject1).setVisibility(8);
        }
        label293:
        if (((TipsBar)localObject1).getVisibility() == 0) {
          ((TipsBar)localObject1).setOnClickListener(this.cT);
        }
        localObject1 = null;
        localObject2 = null;
        if (i2 == 1)
        {
          SubAccountInfo localSubAccountInfo = ((anxr)localObject3).a("sub.uin.default");
          localObject1 = localObject2;
          if (localSubAccountInfo != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
            {
              localObject2 = localSubAccountInfo.subname;
              localObject3 = aqgv.c(this.app, localSubAccountInfo.subuin, true);
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(localSubAccountInfo.subname))
                {
                  localObject1 = localObject2;
                  if (((String)localObject3).equals(localSubAccountInfo.subname)) {}
                }
                else
                {
                  localSubAccountInfo.subname = ((String)localObject3);
                  localObject1 = localObject3;
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localSubAccountInfo != null) {
              localObject2 = localSubAccountInfo.subuin;
            }
          }
          if (localSubAccountInfo != null) {
            h(this.ph, localSubAccountInfo.subuin);
          }
          this.ph.setVisibility(0);
          this.pg.setVisibility(8);
          label489:
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.getCurrentAccountUin()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.aQT).append(" account2BindedNum=").append(i2).append(" final action=").append(j).append(" sAccountName=");
            if (((String)localObject1).length() != 0) {
              break label1069;
            }
            localObject2 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject2);
        if (AppSetting.enableTalkBack) {
          this.n.setContentDescription("关联QQ号" + (String)localObject1);
        }
        return;
        label649:
        if (this.v != null)
        {
          j = i1;
          if (this.v.isShowing()) {
            break;
          }
        }
        j = 2;
        break;
        label674:
        j = 1;
        break;
        label679:
        bool = false;
        break label180;
        if ((this.qg == null) || (this.qg.size() < 4)) {
          break label1149;
        }
        j = 3;
        break label249;
        aqgx.a().SB(true);
        bFr();
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((TipsBar)localObject1).getVisibility() == 8) {
          break label293;
        }
        ((TipsBar)localObject1).setVisibility(8);
        break label293;
        anot.a(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((TipsBar)localObject1).setTag("0X8004001");
        localObject2 = getString(2131720524);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.enableTalkBack) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0) {
          ((TipsBar)localObject1).setVisibility(0);
        }
        bFr();
        break label293;
        ((TipsBar)localObject1).setTag("0X8004456");
        localObject2 = getString(2131720574);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.enableTalkBack) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0)
        {
          anot.a(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((TipsBar)localObject1).setVisibility(0);
        }
        bFr();
        break label293;
        if (i2 > 1)
        {
          localObject2 = i2 + acfp.m(2131701971);
          localObject1 = ((anxr)localObject3).dK();
          if (((ArrayList)localObject1).size() == 2)
          {
            h(this.ph, (String)((ArrayList)localObject1).get(0));
            this.ph.setVisibility(0);
            h(this.pg, (String)((ArrayList)localObject1).get(1));
            this.pg.setVisibility(0);
          }
          break label489;
        }
        this.pg.setVisibility(8);
        this.ph.setVisibility(8);
        localObject2 = localObject1;
        break label489;
        label1069:
        if ((((String)localObject1).length() == 1) || (((String)localObject1).length() == 2)) {
          localObject2 = localObject1;
        } else if (((String)localObject1).length() > 2) {
          localObject2 = ((String)localObject1).substring(0, 2) + "|" + ((String)localObject1).length();
        } else {
          localObject2 = localObject1;
        }
      }
      label1149:
      j = k;
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131756467);
    localReportDialog.setContentView(2131559304);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365867);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365863);
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label149;
        }
        paramString1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365852);
      if (paramString1 != null) {
        paramString1.setText(2131721058);
      }
      paramString1 = (TextView)localReportDialog.findViewById(2131365858);
      if (paramString1 != null) {
        paramString1.setText(2131721079);
      }
      localReportDialog.setOnDismissListener(paramOnDismissListener);
      return localReportDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label149:
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
  }
  
  public void atg()
  {
    try
    {
      if (this.jdField_g_of_type_Arhz == null)
      {
        this.jdField_g_of_type_Arhz = new arhz(getActivity(), getTitleBarHeight());
        this.jdField_g_of_type_Arhz.setMessage(2131696678);
        this.jdField_g_of_type_Arhz.setBackAndSearchFilter(false);
      }
      this.jdField_g_of_type_Arhz.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void ath()
  {
    try
    {
      if ((this.jdField_g_of_type_Arhz != null) && (this.jdField_g_of_type_Arhz.isShowing())) {
        this.jdField_g_of_type_Arhz.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void bFm()
  {
    if ((this.fJ == null) || (this.fJ.getChildCount() <= 0)) {
      return;
    }
    int k = this.fJ.getChildCount();
    int j = 0;
    label28:
    Object localObject2;
    if (j < k)
    {
      localObject2 = this.fJ.getChildAt(j);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    ImageView localImageView1;
    ImageView localImageView2;
    RelativeLayout localRelativeLayout;
    RotateSwitchImageView localRotateSwitchImageView;
    for (;;)
    {
      j += 1;
      break label28;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131364570);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131368698);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131372193);
      localRotateSwitchImageView = (RotateSwitchImageView)((View)localObject2).findViewById(2131365700);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131378162);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.fk) {
        break label247;
      }
      if (localImageView1.getVisibility() == 0) {
        p(localImageView1, 2130771981, 5);
      }
      localRotateSwitchImageView.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localRotateSwitchImageView.setImageResource(2130850669);
      p(localRotateSwitchImageView, 2130771982, 4);
      p((View)localObject2, 2130771982, 4);
      p(localImageView2, 2130771986, 0);
      p(localRelativeLayout, 2130771986, 0);
    }
    label247:
    localRotateSwitchImageView.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int i1 = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.qg.get(i1);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.getCurrentAccountUin()))) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView1.getVisibility() == 0) {
        p(localImageView1, 2130771982, 4);
      }
      p(localRotateSwitchImageView, 2130771981, 5);
      p((View)localObject2, 2130771981, 5);
      p(localImageView2, 2130771985, 1);
      p(localRelativeLayout, 2130771985, 1);
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  void bFo()
  {
    if ((this.fJ == null) || (this.fJ.getChildCount() <= 0)) {}
    int j;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int k = this.fJ.getChildCount();
        j = 0;
        if (j >= k) {
          break;
        }
        localObject1 = this.fJ.getChildAt(j);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int i1 = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.qg.get(i1);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131364570);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin())) && (!this.fk)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  public void bFr()
  {
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(5000);
    if ((this.v == null) || (this.v.isShowing())) {}
    try
    {
      this.v.dismiss();
      label34:
      this.v = null;
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
  
  public void bFs()
  {
    bFr();
    this.v = aqha.a(this, 230).setTitle(getString(2131720542)).setMessage(getString(2131720503));
    this.v.setPositiveButton(getString(2131720597), new ucn(this));
    this.v.setNegativeButton(getString(2131721058), new uco(this));
    try
    {
      this.v.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bFu()
  {
    bFv();
    if (this.onDismissListener == null) {
      this.onDismissListener = new uct(this).a();
    }
    Dialog localDialog = a(getString(2131695589), null, this.onDismissListener);
    Object localObject = (TextView)localDialog.findViewById(2131365858);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new ucu(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365852);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new ucw(this));
    }
    localObject = getString(2131718627);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.aQW = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountManageActivity", 4, "init CheckBox:receiveMsgWhenExitPerfExist:" + bool + ", bReceiveMsgOnExit:" + this.aQW);
    }
    localObject = (CheckBox)localDialog.findViewById(2131364575);
    if ((bool) && (this.aQW)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.aQW);
    this.y = localDialog;
    this.y.show();
  }
  
  public void bFv()
  {
    if ((this.y == null) || (this.y.isShowing())) {}
    try
    {
      this.y.dismiss();
      label24:
      this.y = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void deleteAccount(int paramInt, boolean paramBoolean)
  {
    Object localObject = (SimpleAccount)this.qg.get(paramInt);
    if (localObject == null)
    {
      this.pd.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject).getUin();
    String str2 = this.app.getCurrentAccountUin();
    this.aKz = str1;
    if (str1.equals(str2)) {
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    aM(this.aKz, paramBoolean);
    aqht.UE(str1);
    jqs.aE(getBaseContext(), str2);
    this.qg.remove(localObject);
    anxr localanxr = (anxr)this.app.getManager(61);
    if ((localanxr != null) && (localanxr.pJ(str1)))
    {
      anxk.a(this.app, (byte)0, str1);
      localanxr.RC(str1);
      localanxr.R(str1, null, true);
      localanxr.am(str1, 2);
      anxk.G(this.app, str1, 7);
      int j = 1 - this.app.a().A(str1, 7000);
      if (j != 0) {
        this.app.a().G(str1, 7000, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "deleteAccount() hint need to verify,msg num=1, subUin=" + str1);
      }
    }
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (((SimpleAccount)localObject).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject).getUin(), "delAccount");
        }
      }
    }
    ThreadManager.post(new AccountManageActivity.19(this, str1, paramBoolean, paramInt), 8, null, true);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 1000) && (paramInt1 != 9876)) {
        break label24;
      }
      initAccountList();
    }
    label24:
    while ((paramInt1 != 0) || (paramIntent == null)) {
      return;
    }
    bFq();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558444);
    setTitle(2131701599);
    this.density = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838900);
    initUI();
    initAccountList();
    addObserver(this.jdField_g_of_type_Acfd);
    addObserver(this.jdField_a_of_type_Acmf);
    addObserver(this.mMsgObserver);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.app.addObserver(this.jdField_a_of_type_Aktr);
    this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
    ThreadManager.post(new AccountManageActivity.1(this), 5, null, true);
    this.d = new aqdf(this, this.app);
    this.d.a(this.c);
    sendBroadcast(new Intent("before_account_change"));
    anot.a(this.app, "dc00898", "", "", "0X800AC37", "0X800AC37", 0, 0, "", "", "", "");
    anot.a(this.app, "dc00898", "", "", "0X800735C", "0X800735C", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeHandler(getClass());
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    removeObserver(this.jdField_g_of_type_Acfd);
    removeObserver(this.jdField_a_of_type_Acmf);
    removeObserver(this.mMsgObserver);
    this.app.removeObserver(this.jdField_a_of_type_Aktr);
    if (this.pd.isShowing()) {
      this.pd.dismiss();
    }
    bFr();
    if ((this.x != null) && (this.x.isShowing()))
    {
      this.x.dismiss();
      this.x = null;
    }
    if (this.d != null)
    {
      this.d.a(null);
      this.c = null;
      this.d.destory();
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    vF(false);
    bFn();
    ath();
  }
  
  public void h(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = this.d.b(1, paramString);
    if (localBitmap == null) {
      this.d.i(paramString, 1, false);
    }
    for (;;)
    {
      paramImageView.setTag(paramString);
      return;
      paramImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void initUI()
  {
    bFt();
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131721064);
    localTextView.setOnClickListener(new ucv(this));
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131559124, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.mDensity));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131721066);
    this.rightHighLView.setOnClickListener(new uda(this));
    this.fJ = ((LinearLayout)findViewById(2131361877));
    this.m = ((FormSimpleItem)findViewById(2131372637));
    bFq();
    this.m.setOnClickListener(new udb(this));
    this.ri = findViewById(2131370910);
    this.ri.setVisibility(0);
    this.ri.setOnClickListener(new udc(this));
    this.rj = findViewById(2131375398);
    this.ri.setVisibility(0);
    this.rj.setOnClickListener(new udd(this));
    this.n = ((FormSimpleItem)findViewById(2131378927));
    this.n.setOnClickListener(this.cT);
    this.pg = ((ImageView)findViewById(2131378912));
    this.pg.setBackgroundResource(2130851486);
    this.ph = ((ImageView)findViewById(2131378913));
    this.ph.setBackgroundResource(2130851486);
    bFk();
    localObject = getResources().getDisplayMetrics();
    this.of = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.oR = (this.of - 110.0F * this.mDensity);
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    this.i = ((FormSwitchItem)findViewById(2131364011));
    this.i.setOnCheckedChangeListener(new ude(this));
    this.i.setChecked(bool);
    if (AppSetting.enableTalkBack)
    {
      localTextView.setContentDescription(acfp.m(2131701973));
      this.rightHighLView.setContentDescription(acfp.m(2131701972));
      this.ri.setContentDescription(getString(2131695581));
      this.rj.setContentDescription("退出QQ");
      this.n.setContentDescription("关联QQ号");
      aqcl.Q(findViewById(2131361918), false);
    }
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.aQR)
    {
      this.aQR = false;
      bFn();
    }
    for (;;)
    {
      addObserver(this.jdField_g_of_type_Acfd);
      addObserver(this.jdField_a_of_type_Acmf);
      addObserver(this.mMsgObserver);
      this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      ThreadManager.postImmediately(new AccountManageActivity.23(this), null, true);
      anxj.k(this.app, this);
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.24(this), 500L);
      boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
      if (this.i == null) {
        break;
      }
      this.i.setChecked(bool);
      return;
      initAccountList();
    }
    QLog.e("AccountManageActivity", 2, "subAccountNotifySwitch is null");
  }
  
  public void onAccoutChangeFailed()
  {
    ath();
    this.aQR = false;
    bFp();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.aQS = false;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    vF(false);
  }
  
  void p(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.density, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new a(paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.density, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  void uO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void vG(boolean paramBoolean)
  {
    if ((this.fJ == null) || (this.fJ.getChildCount() <= 0)) {
      return;
    }
    int k = this.fJ.getChildCount();
    int j = 0;
    label28:
    View localView;
    if (j < k)
    {
      localView = this.fJ.getChildAt(j);
      if (localView.getTag() != null) {
        break label108;
      }
      if (!paramBoolean) {
        break label82;
      }
      localView.setOnClickListener(null);
      localView.setBackgroundResource(2130851356);
      localView.setEnabled(false);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      label82:
      localView.setOnClickListener(this.cV);
      localView.setBackgroundResource(2130839689);
      localView.setEnabled(true);
      continue;
      label108:
      ImageView localImageView = (ImageView)localView.findViewById(2131364570);
      Object localObject = (TextView)localView.findViewById(2131372190);
      if ((localView instanceof FormItemRelativeLayout))
      {
        localObject = (FormItemRelativeLayout)localView;
        if (paramBoolean) {
          break label197;
        }
      }
      label197:
      for (boolean bool = true;; bool = false)
      {
        ((FormItemRelativeLayout)localObject).setNeedFocusBg(bool);
        ((FormItemRelativeLayout)localView).setBGType(2);
        if (j != 0) {
          break label223;
        }
        if (!paramBoolean) {
          break label203;
        }
        localView.setOnClickListener(null);
        localImageView.setImageResource(2130845617);
        break;
      }
      label203:
      localView.setOnClickListener(this.cU);
      localImageView.setImageResource(2130845617);
      continue;
      label223:
      if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localImageView.setImageResource(2130845617);
      }
      else
      {
        localView.setOnClickListener(this.cU);
        localImageView.setImageResource(2130845617);
      }
    }
  }
  
  public void zG(int paramInt)
  {
    Object localObject = (SimpleAccount)this.qg.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.P = ((ausj)auss.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968576);
      int j = 0;
      while (j < arrayOfString.length)
      {
        this.P.addButton(arrayOfString[j], 1);
        j += 1;
      }
      this.P.addCancelButton(2131721058);
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$c.setPos(paramInt);
      this.P.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$c);
      localObject = getString(2131691520).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.P.setMainTitle((CharSequence)localObject);
    } while (this.P.isShowing());
    this.P.show();
  }
  
  class a
    implements Animation.AnimationListener
  {
    int bDt = -1;
    View rl;
    
    public a(View paramView, int paramInt)
    {
      this.rl = paramView;
      this.bDt = paramInt;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.rl == null) {
        return;
      }
      switch (this.bDt)
      {
      case 2: 
      case 3: 
      default: 
        return;
      case 0: 
        paramAnimation = (RelativeLayout.LayoutParams)this.rl.getLayoutParams();
        paramAnimation.leftMargin += (int)(AccountManageActivity.this.density * 34.0F);
        this.rl.setLayoutParams(paramAnimation);
        this.rl.setTag("right");
      }
      for (;;)
      {
        this.rl.clearAnimation();
        return;
        paramAnimation = (RelativeLayout.LayoutParams)this.rl.getLayoutParams();
        paramAnimation.leftMargin -= (int)(AccountManageActivity.this.density * 34.0F);
        this.rl.setLayoutParams(paramAnimation);
        this.rl.setTag("left");
        continue;
        this.rl.setVisibility(0);
        if (this.rl.getId() == 2131364570)
        {
          AccountManageActivity.this.bFo();
          continue;
          this.rl.setVisibility(4);
        }
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      paramAnimation = (String)this.rl.getTag();
      if ((this.bDt == 1) && (paramAnimation.equals("left")))
      {
        this.rl.clearAnimation();
        this.bDt = 6;
      }
      if ((this.bDt == 0) && (paramAnimation.equals("right")))
      {
        this.rl.clearAnimation();
        this.bDt = 6;
      }
    }
  }
  
  class b
    extends AccountObserver
  {
    private String aKC;
    private boolean aQZ;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.aKC = paramString;
      this.aQZ = paramBoolean;
    }
    
    public void onDeleteAccount(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "DelHistoryAccountObserver onDeleteAccount isSuccess " + paramBoolean + ",peerUin:" + this.aKC + ",isDeleteHistory:" + this.aQZ);
      }
      Object localObject = AccountManageActivity.this;
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        localObject = ((AccountManageActivity)localObject).getSharedPreferences("Last_Login", i);
        if ((paramBoolean) && (localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(this.aKC)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("Switch_Account", 2, "delete Last_Login");
          }
        }
        if ((paramBoolean) && (this.aQZ)) {
          AccountManageActivity.this.uO(this.aKC);
        }
        return;
      }
    }
  }
  
  class c
    implements ausj.a
  {
    int bDu = -1;
    
    c() {}
    
    public void OnClick(View paramView, int paramInt)
    {
      if (AccountManageActivity.this.isFinishing()) {}
      for (;;)
      {
        return;
        if (AccountManageActivity.this.P != null) {
          AccountManageActivity.this.P.dismiss();
        }
        switch (paramInt)
        {
        default: 
        case 0: 
          try
          {
            AccountManageActivity.this.pd.show();
            if (this.bDu < 0) {
              continue;
            }
            AccountManageActivity.this.deleteAccount(this.bDu, false);
            return;
          }
          catch (Throwable paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
              QLog.i("AccountManageActivity", 1, "MyOnButtonClickListener 0 error" + paramView.getMessage());
            }
          }
        case 1: 
          try
          {
            AccountManageActivity.this.pd.show();
            if (this.bDu < 0) {
              continue;
            }
            AccountManageActivity.this.deleteAccount(this.bDu, true);
            return;
          }
          catch (Throwable paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
              QLog.i("AccountManageActivity", 1, "MyOnButtonClickListener 1 error" + paramView.getMessage());
            }
          }
        }
      }
    }
    
    public void setPos(int paramInt)
    {
      this.bDu = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */