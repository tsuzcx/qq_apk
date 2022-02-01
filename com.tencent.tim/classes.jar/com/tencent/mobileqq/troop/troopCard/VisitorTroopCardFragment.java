package com.tencent.mobileqq.troop.troopCard;

import acfp;
import acms;
import acnd;
import aerd;
import afsi;
import afyk;
import aldh;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anlm;
import anov;
import aofk;
import aofr;
import apoq;
import apoq.a;
import apos;
import appf;
import appg;
import apph;
import appi;
import appj;
import appk;
import appl;
import appm;
import appn;
import appq;
import appr;
import apps;
import appt;
import appu;
import appv;
import appw;
import appx;
import apqe;
import apqz;
import apuh;
import aqfr;
import aqiw;
import aqju;
import arhz;
import arib;
import ausi;
import ausj;
import auss;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.DecimalFormat;
import java.util.List;
import jpp;
import mqq.util.WeakReference;
import rar;
import rpq;
import sxx;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import wja;
import yxe;
import zri;
import zti;

public class VisitorTroopCardFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, appf
{
  public AlphaAnimation A;
  public AlphaAnimation B;
  private Intent C;
  protected ImageView EH;
  protected ImageView EI;
  private View IM;
  private apos jdField_a_of_type_Apos;
  private appx jdField_a_of_type_Appx;
  private arib jdField_a_of_type_Arib;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
  private AvatarWallViewPagerAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
  protected ExpandableTextView a;
  public TroopMoreDetailView a;
  public TroopInfoData a;
  protected QQBlurView a;
  protected String aMm;
  private boolean aRf;
  private boolean aUo;
  protected boolean aUv;
  private boolean aUy;
  private boolean aUz = true;
  protected TextView aaZ;
  protected TextView aaw;
  protected TextView aax;
  protected TextView aay;
  protected TextView aba;
  public QQAppInterface app;
  private long arR;
  protected String authKey;
  protected String authSig;
  protected acnd b;
  public TroopInfo b;
  protected int bFK;
  private int bFN = 2;
  protected int bFP = -1;
  public int bGV;
  public boolean cRT;
  private int dVk;
  public int dVl;
  protected Button dd;
  protected LinearLayout dl;
  public ImmersiveTitleBar2 e;
  protected arhz g;
  public RelativeLayout gt;
  protected Button hq;
  private boolean mIsDestroyed;
  public boolean mIsInit = true;
  private XListView mListView;
  protected View mN;
  protected BroadcastReceiver mReceiver = new appg(this);
  protected View mRootView;
  public TextView mTitleTv;
  private String mTroopUin;
  protected ImageView pJ;
  protected View rV;
  public aqju x;
  protected TextView xt;
  protected Animation.AnimationListener y = new appt(this);
  
  public VisitorTroopCardFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  }
  
  private void Qq()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    if (!aBr()) {
      localausj.a(new ausi(getString(2131698429), 9, 0), 5);
    }
    localausj.a(new ausi(auss.n(getActivity(), 2131718824), 10, 0), 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new appi(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void RZ(boolean paramBoolean)
  {
    String str2 = " ";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        }
      }
    }
    this.aax.setVisibility(0);
    this.aax.setText(str1);
    this.aax.setClickable(false);
  }
  
  private void Tw(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.17(this, paramString));
  }
  
  private void ZM()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.aUz) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if ((this.aUz) || (bool)) {}
    for (int i = 2131167301;; i = 2131166970)
    {
      int k = getResources().getColor(i);
      int j = 2130844509;
      i = j;
      if (this.aUz)
      {
        i = j;
        if (!bool) {
          i = 2130840663;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130851758);
      localDrawable.setColorFilter(k, PorterDuff.Mode.SRC_ATOP);
      this.mTitleTv.setTextColor(k);
      this.xt.setTextColor(k);
      this.xt.setBackgroundDrawable(localDrawable);
      this.pJ.setImageResource(i);
      this.pJ.setColorFilter(k);
      wz(this.aUz);
      return;
    }
  }
  
  private boolean aBr()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
  }
  
  @TargetApi(19)
  private void aH()
  {
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iD(this.mListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YI(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.bg(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YK(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new appv(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130851351)).getBitmap());
      localBitmapDrawable.setAlpha(220);
      this.rV.setBackground(localBitmapDrawable);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void bKT()
  {
    if (this.jdField_a_of_type_Appx == null) {}
    do
    {
      return;
      Drawable localDrawable = this.jdField_a_of_type_Appx.q(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.EH.setImageDrawable(localDrawable);
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()));
    this.EH.setOnClickListener(this);
  }
  
  private void bKW()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null)
    {
      localObject = null;
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label106;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && ((this.jdField_a_of_type_Appx == null) || (this.jdField_a_of_type_Appx.bFL == 0))) {
        break label99;
      }
      bKX();
    }
    for (;;)
    {
      apqe.I(21, new Object());
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label99:
      bKY();
      continue;
      label106:
      localObject = ausj.b(getActivity());
      ((ausj)localObject).setMainTitle(2131691988);
      ((ausj)localObject).addButton(2131693282, 3);
      ((ausj)localObject).a(new appj(this, (ausj)localObject));
      ((ausj)localObject).addCancelButton(getString(2131721058));
      ((ausj)localObject).show();
    }
  }
  
  private void bKX()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    String str = acfp.m(2131703749);
    localTextView1.setText(getString(2131691982, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131721079);
    localTextView3.setText(2131721058);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new appl(this, localReportDialog));
    localTextView3.setOnClickListener(new appm(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bKY()
  {
    String str = getString(2131691981);
    ausj localausj = ausj.b(getActivity());
    localausj.setMainTitle(str);
    localausj.addButton(getString(2131691980), 3);
    localausj.addCancelButton(getString(2131721058));
    localausj.a(new appk(this, localausj));
    localausj.show();
  }
  
  private void bLb()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      String str = String.format(getResources().getString(2131694962), new Object[] { Integer.valueOf(i) });
      this.aay.setText(str);
      this.aay.setContentDescription(str);
      this.aay.setVisibility(0);
    }
    for (;;)
    {
      if (this.aUo) {
        this.aay.setVisibility(8);
      }
      this.aay.setOnClickListener(this);
      return;
      this.aay.setVisibility(8);
    }
  }
  
  private void bLc()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131703747);
    }
    this.aaw.setVisibility(0);
    this.aaw.setText(str1);
    this.aaw.setClickable(false);
    if (AppSetting.enableTalkBack) {
      this.aaw.setContentDescription(acfp.m(2131703735) + str1);
    }
  }
  
  private void bLr()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView == null) {
      return;
    }
    String str2 = apuh.l(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new aofk(str1, 11, 16));
  }
  
  private void bLu()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      this.EI.setVisibility(0);
      return;
    }
    this.EI.setVisibility(8);
  }
  
  private void bLx()
  {
    if ((this.C == null) && (getActivity().getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.C = new Intent();
      this.C.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.C;
    Intent localIntent1 = localIntent2;
    if (this.aUy)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.aUy = false;
    }
    getActivity().setResult(-1, localIntent1);
  }
  
  private void bOs()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.a(new ausi(acfp.m(2131703746), 7, 0), 5);
    localausj.a(new ausi(acfp.m(2131703752), 8, 0), 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new apph(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void cz(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    Object localObject1 = aerd.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean1 = TroopManager.c.iC(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int i;
      if (paramBoolean1)
      {
        i = 15;
        localObject1 = VipUtils.a(0, i);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label191;
        }
        FragmentActivity localFragmentActivity = getActivity();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (localObject1 == null) {
          break label175;
        }
        localObject1 = ((SpannableString)localObject1).toString();
        label103:
        String str2 = acfp.m(2131716016);
        appn localappn = new appn(this, paramBoolean1);
        if (!paramBoolean1) {
          break label183;
        }
        localObject2 = "0X800A57F";
        label131:
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
        VipUtils.a(localFragmentActivity, str1, (String)localObject1, str2, localappn, (String)localObject2, i, paramBoolean1);
      }
      for (;;)
      {
        apqe.I(1, new Object());
        return;
        i = 8;
        break;
        label175:
        localObject1 = "";
        break label103;
        label183:
        localObject2 = "0X8009E38";
        break label131;
        label191:
        VipUtils.O(getActivity(), paramBoolean1);
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", paramBoolean1);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean2);
    if (!paramBoolean2)
    {
      localObject2 = sxx.getViewRect(this.EH);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    if (this.jdField_a_of_type_Appx != null) {
      this.jdField_a_of_type_Appx.b((Bundle)localObject1, aBr());
    }
    apqe.I(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (aBr()) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      aqfr.b("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private void dUn()
  {
    this.rV.setVisibility(0);
    this.hq = ((Button)this.mRootView.findViewById(2131363743));
    this.hq.setVisibility(0);
    this.dd = ((Button)this.mRootView.findViewById(2131378208));
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (int i = 1; this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember; i = 0)
    {
      this.hq.setText(2131694812);
      this.hq.setTag(Integer.valueOf(4));
      this.hq.setOnClickListener(this);
      this.dd.setVisibility(0);
      this.dd.setOnClickListener(this);
      return;
    }
    if (i != 0)
    {
      this.hq.setText(getString(2131694884, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.hq.setTag(Integer.valueOf(3));
      this.hq.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.hq.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.aMm))
    {
      this.hq.setText(2131695151);
      this.hq.setTag(Integer.valueOf(5));
      this.hq.setOnClickListener(this);
      this.hq.getBackground().setColorFilter(null);
      return;
    }
    if (this.bFK == 2) {
      apqe.I(18, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    this.hq.setText(2131695150);
    this.hq.setTag(Integer.valueOf(6));
    this.hq.setOnClickListener(this);
    this.hq.getBackground().setColorFilter(null);
    apuh.e(true, this.hq);
  }
  
  private void ds(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = apuh.a(paramBundle, getActivity());
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, getActivity());
    apuh.dWD = paramBundle.getInt("exposureSource", 99);
    this.bFP = paramBundle.getInt("filter_id", -1);
    this.bFK = paramBundle.getInt("D2GType");
    this.aUv = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.aMm = getActivity().getIntent().getStringExtra("is_from_game");
    this.authKey = paramBundle.getString("authKey");
    this.authSig = paramBundle.getString("authSig");
    this.cRT = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.aUo = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop;
    this.mTroopUin = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    this.jdField_a_of_type_Appx = new appx();
    this.jdField_a_of_type_Appx.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_Appx.bc(paramBundle, str1, str2);
  }
  
  private void ebc()
  {
    if (this.mTitleTv != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130839651);
      this.mTitleTv.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.mTitleTv.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298469));
      ((Animatable)localDrawable).start();
    }
    if (!aqiw.isNetworkAvailable(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131696272), 1).show(getActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    initAnimation();
    this.mListView.setOnScrollListener(new appq(this));
    this.xt.setOnClickListener(this);
    this.pJ.setOnClickListener(this);
  }
  
  @SuppressLint({"NewApi"})
  private void ebd()
  {
    Object localObject = View.inflate(getActivity(), 2131560063, null);
    this.IM = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131381985));
    ebf();
    this.dl.addView((View)localObject);
    eba();
    localObject = View.inflate(getActivity(), 2131560836, null);
    this.EI = ((ImageView)((View)localObject).findViewById(2131374327));
    this.aba = ((TextView)((View)localObject).findViewById(2131380370));
    bLu();
    this.aaZ = ((TextView)((View)localObject).findViewById(2131380406));
    ebe();
    this.aay = ((TextView)((View)localObject).findViewById(2131380327));
    bLb();
    this.dl.addView((View)localObject);
    this.EH = ((ImageView)((View)localObject).findViewById(2131368375));
    ((View)localObject).setContentDescription(getResources().getString(2131701823));
    if (anlm.ayn()) {
      ((View)localObject).setBackground(null);
    }
    bKT();
    this.aaw = ((TextView)((View)localObject).findViewById(2131380362));
    bLc();
    aldh.m(this.aaw, acfp.m(2131716024));
    this.aax = ((TextView)((View)localObject).findViewById(2131380409));
    RZ(true);
    aldh.a(this.aax, this.aax.getText().toString(), acfp.m(2131692333), new appr(this));
    localObject = apuh.l(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      localObject = (String)localObject + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)View.inflate(getActivity(), 2131560841, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new aofk((CharSequence)localObject, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.ab().setEditableFactory(aofr.a);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.ab().setMovementMethod(LinkMovementMethod.getInstance());
      int i = wja.dp2px(12.0F, getResources());
      int j = wja.dp2px(15.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setBackgroundResource(2130851428);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new apps(this));
      this.dl.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setPadding(i, j, i, j);
      localObject = View.inflate(getActivity(), 2131561775, null);
      ((View)localObject).setBackgroundResource(2130851773);
      this.dl.addView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = new TroopMoreDetailView(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(true);
      this.dl.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView);
      return;
    }
  }
  
  private void ebe()
  {
    int j = 8;
    if (this.aUo)
    {
      this.aaZ.setVisibility(8);
      this.aba.setVisibility(8);
      return;
    }
    this.aaZ.setOnClickListener(this);
    this.aaZ.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
    {
      this.aaZ.setVisibility(8);
      if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
        break label367;
      }
    }
    label367:
    for (int i = 1;; i = 0)
    {
      Object localObject = this.aba;
      if (i != 0) {
        j = 0;
      }
      ((TextView)localObject).setVisibility(j);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (i == 0)) {
        break label372;
      }
      this.hq.setText(getString(2131694884, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.hq.setTag(Integer.valueOf(3));
      this.hq.setOnClickListener(this);
      this.hq.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
      {
        this.aaZ.setVisibility(8);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        localObject = "（" + getString(2131698511) + "）";
        this.aaZ.setText((CharSequence)localObject);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        localObject = "（" + getString(2131698511) + "）";
        this.aaZ.setText((CharSequence)localObject);
        break;
      }
      this.aaZ.setVisibility(8);
      return;
    }
    label372:
    this.hq.getBackground().setColorFilter(null);
  }
  
  private void ebf()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, rpq.dip2px(getActivity(), 212.0F), this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new appu(this));
  }
  
  private void ebg()
  {
    apuh.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, apuh.dWD, this.bFP, 2);
    if (!aqiw.isNetSupport(getActivity())) {
      apuh.c(getActivity(), getActivity().getTitleBarHeight(), 2131696270, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Appx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
    return;
    this.jdField_a_of_type_Appx.gm(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      apqe.I(14, new Object());
    }
    aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  private void initAnimation()
  {
    this.bGV = 30;
    this.A = new AlphaAnimation(0.0F, 1.0F);
    this.A.setDuration(300L);
    this.A.setInterpolator(getActivity(), 17432581);
    this.A.setAnimationListener(this.y);
    this.B = new AlphaAnimation(1.0F, 0.0F);
    this.B.setDuration(300L);
    this.B.setInterpolator(getActivity(), 17432581);
    this.B.setAnimationListener(this.y);
  }
  
  private void initTitle()
  {
    this.mN = this.mRootView.findViewById(2131379845);
    this.gt = ((RelativeLayout)this.mRootView.findViewById(2131379791));
    this.gt.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131691439));
    this.gt.setFocusable(true);
    this.mTitleTv = ((TextView)this.mRootView.findViewById(2131369627));
    this.mTitleTv.setText(getResources().getString(2131691439));
    this.xt = ((TextView)this.mRootView.findViewById(2131369579));
    this.xt.setContentDescription(getString(2131696673) + getString(2131691029));
    this.pJ = ((ImageView)this.mRootView.findViewById(2131369594));
    this.pJ.setContentDescription(getString(2131692129));
  }
  
  private void initUI()
  {
    View localView = View.inflate(getActivity(), 2131563330, null);
    this.e = ((ImmersiveTitleBar2)localView.findViewById(2131379866));
    this.rV = localView.findViewById(2131363832);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363636));
    this.mListView = ((XListView)localView.findViewById(2131365101));
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.setDivider(null);
    int i = this.mListView.getPaddingLeft();
    int j = this.mListView.getPaddingLeft();
    int k = getResources().getDimensionPixelOffset(2131297318);
    this.mListView.setPadding(i, 0, j, k);
    this.dl = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.dl.setLayoutParams(localLayoutParams);
    this.dl.setOrientation(1);
    ebh();
    getActivity().setContentView(localView);
    this.mRootView = localView;
    this.mRootView.setBackgroundResource(2130838900);
    initTitle();
    ebd();
    aH();
    dUn();
  }
  
  private void k(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 4)
    {
      wy(false);
      if (this.bFK == 2) {
        apqe.I(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      paramInt = getActivity().getIntent().getIntExtra("extra_share_group_from", 0);
      if (paramInt != 0) {
        rar.a("story_grp", "clk_msg", paramInt, 0, new String[0]);
      }
      aqfr.b("Grp_set_new", "grpData_visitor", "clk_sendMsg", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        paramInt = 1;
        apqe.I(5, new Object[] { Integer.valueOf(paramInt), apuh.LG() + "" });
      }
    }
    label402:
    label414:
    do
    {
      long l;
      do
      {
        do
        {
          return;
          paramInt = 2;
          break;
          if (paramInt == 3)
          {
            apqe.I(7, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            yxe.bm(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
          }
          if (paramInt == 5)
          {
            apuh.a(paramQQAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_Appx.d);
            apqe.I(8, new Object());
            aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
          }
        } while (paramInt != 6);
        l = System.currentTimeMillis();
      } while (l - this.arR <= 1000L);
      this.arR = l;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (paramInt = 1;; paramInt = 2)
      {
        apqe.I(10, new Object[] { Integer.valueOf(paramInt), apuh.LG() + "" });
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
          break label414;
        }
        if (!afsi.me(paramQQAppInterface.getCurrentAccountUin())) {
          break label402;
        }
        paramQQAppInterface = afyk.b(getActivity());
        if (getActivity().isFinishing()) {
          break;
        }
        paramQQAppInterface.show();
        apqe.I(11, new Object());
        return;
      }
      apqe.I(12, new Object());
      apuh.e(false, null);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
      for (String str1 = "1";; str1 = "0")
      {
        apqe.I(13, new Object[] { str2, str1 });
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.authKey))) {
          break label512;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
          break;
        }
        Ax(1);
        return;
      }
      bLs();
      return;
      if (TextUtils.isEmpty(this.authSig)) {
        break label586;
      }
      ((acms)paramQQAppInterface.getBusinessHandler(20)).j(Long.valueOf(this.mTroopUin).longValue(), Long.valueOf(paramQQAppInterface.getCurrentUin()).longValue(), this.authSig);
    } while (this.jdField_b_of_type_Acnd != null);
    label512:
    this.jdField_b_of_type_Acnd = new appw(this);
    paramQQAppInterface.addObserver(this.jdField_b_of_type_Acnd);
    return;
    label586:
    ebg();
  }
  
  private void o(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
    {
      View localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      bool1 = bool2;
      if (paramAbsListView.getHeight() >= localView.getBottom()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "checkReachListBottomAndLoadMoreRecommList, reachBottom = " + bool1);
    }
    if (bool1) {
      this.jdField_a_of_type_Apos.cmh();
    }
  }
  
  private void vq(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (this.dVl == 1))
    {
      bLs();
      return;
    }
    vr(paramString);
  }
  
  private void vr(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.bFK == 1) || (this.bFK == 2)) {
        i = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, getResources().getString(2131691439), this.authKey, this.authSig, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131691439), this.authKey, this.authSig, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    cf(2131721390, 0);
  }
  
  private void wz(boolean paramBoolean)
  {
    int k = 1;
    int i;
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.gF().size() > 0))
    {
      i = 1;
      j = k;
      if (!paramBoolean)
      {
        if (i != 0) {
          break label97;
        }
        j = k;
      }
      label41:
      if (j == 0) {
        break label102;
      }
      this.gt.setVisibility(0);
      this.e.setVisibility(0);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
      if (j != 0) {
        anlm.a(this.e, getActivity().getWindow());
      }
      return;
      i = 0;
      break;
      label97:
      j = 0;
      break label41;
      label102:
      this.gt.setVisibility(4);
      this.e.setVisibility(4);
    }
  }
  
  public void Ax(int paramInt)
  {
    this.bFN = paramInt;
    apqz.p(getActivity(), this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  public void Tu(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      bKT();
    }
  }
  
  public void Tv(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.eco();
    }
  }
  
  public void V(boolean paramBoolean, List<zri> paramList)
  {
    if (paramBoolean) {
      bKT();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.ax(paramList))) {
      return;
    }
    bKT();
    eba();
  }
  
  public void atg()
  {
    try
    {
      if (this.g == null)
      {
        this.g = new arhz(getActivity(), getActivity().getTitleBarHeight());
        this.g.setMessage(2131696693);
        this.g.setBackAndSearchFilter(false);
      }
      this.g.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("VisitorTroopCardFragment.Activity", 2, localException.toString());
    }
  }
  
  public void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing())) {
        this.g.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("VisitorTroopCardFragment.Activity", 2, localException.toString());
    }
  }
  
  public void b(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool = true;
    int i;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.coverFrom(paramGroupInfo);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName)) {
        bLc();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        bKT();
      }
      if (QLog.isColorLevel())
      {
        i = paramGroupInfo.uint32_group_flagext3.get();
        StringBuilder localStringBuilder = new StringBuilder().append("ChatSettingForToop_handle88dResp, troopUin=");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
          break label379;
        }
        str = "";
        QLog.d(".troop.qidian_private_troop", 2, str + ", flagExt3=" + i + ", isQidianPrivateTroop=" + TroopInfo.isQidianPrivateTroop(i));
      }
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.coverFrom(paramGroupInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        if (!this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) {
          this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.newTroopName = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        }
        this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.oldTroopName = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
      }
      this.aUo = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
      if (this.aUo)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label391;
        }
        i = 1;
        label231:
        new anov(this.app).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(i) }).report();
      }
      ebe();
      if ((this.aUo) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        break label426;
      }
    }
    for (;;)
    {
      RZ(bool);
      bLr();
      bLb();
      bLu();
      eba();
      apuh.a(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.initView();
      }
      return;
      label379:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      break;
      label391:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        i = 2;
        break label231;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
      {
        i = 3;
        break label231;
      }
      i = 4;
      break label231;
      label426:
      bool = false;
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    ath();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      if (!paramBoolean) {
        break;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VisitorTroopCardFragment.Activity", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption = 2;
          this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.setOnlyTroopMemberInviteOption(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOnlyTroopMemberInvite = false;
      }
    } while (!getActivity().isResume());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      Ax(2);
      return;
    }
    vq(null);
    return;
    cf(2131719483, 1);
  }
  
  public void bLs()
  {
    if (this.jdField_a_of_type_Appx != null)
    {
      atg();
      this.jdField_a_of_type_Appx.hX(this.authKey, this.authSig);
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    apuh.c(getActivity(), getActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() == null) || (getActivity().app == null)) {
      return;
    }
    this.app = getActivity().app;
    hideTitleBar();
    ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    ds(getActivity().getIntent().getExtras());
    initUI();
    apuh.R(this.app);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (paramLayoutInflater = "0";; paramLayoutInflater = "1")
    {
      apqe.I(17, new Object[] { paramViewGroup, paramLayoutInflater });
      aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      jpp.a(this.app, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getActivity().registerReceiver(this.mReceiver, paramLayoutInflater);
      return;
    }
  }
  
  public void eE(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.authKey))))
    {
      ath();
      apuh.t(getActivity(), paramInt2);
    }
    while ((!getActivity().isResume()) || ((paramInt1 != 2) && (paramInt1 != 9))) {
      return;
    }
    if (this.jdField_a_of_type_Arib == null) {
      this.jdField_a_of_type_Arib = new arib(getActivity());
    }
    this.jdField_a_of_type_Arib.aq(2, 2131693293, 1500);
    getActivity().finish();
  }
  
  public void eba()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.gF();
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, "updateTroopAvatarWall size=" + localList.size());
    }
    LinearLayout.LayoutParams localLayoutParams;
    int k;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.IM.getLayoutParams();
      k = getResources().getDisplayMetrics().widthPixels;
      if (localList.size() <= 0) {
        break label154;
      }
      j = 1;
      if (localList.size() <= 0) {
        break label159;
      }
      i = zti.fD(k);
    }
    for (;;)
    {
      label104:
      localLayoutParams.width = k;
      localLayoutParams.height = i;
      this.IM.setLayoutParams(localLayoutParams);
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(0);
        if (this.aUz) {
          this.aUz = false;
        }
      }
      for (;;)
      {
        ZM();
        return;
        label154:
        j = 0;
        break;
        label159:
        if (this.mN == null) {
          break label210;
        }
        this.mN.measure(0, 0);
        i = this.mN.getMeasuredHeight();
        break label104;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(8);
        if (!this.aUz) {
          this.aUz = true;
        }
      }
      label210:
      i = 0;
    }
  }
  
  public void ebb()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.18(this));
  }
  
  void ebh()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    Object localObject1;
    boolean bool1;
    label66:
    label81:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      localObject1 = "1";
      apqe.I(15, new Object[] { localObject2, localObject1 });
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember;
      localObject1 = apoq.a();
      if ((bool2) && (!((apoq.a)localObject1).cRR)) {
        break label341;
      }
      bool1 = true;
      if (TextUtils.isEmpty(((apoq.a)localObject1).title)) {
        break label346;
      }
      localObject1 = ((apoq.a)localObject1).title;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "checkAndInitRecommendList,hasJoinedTroop = " + bool2 + ",displayOrNot = " + bool1 + ",recoomTips = " + (String)localObject1);
      }
      if (this.jdField_a_of_type_Apos == null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break label353;
        }
      }
    }
    label341:
    label346:
    label353:
    for (localObject2 = "1";; localObject2 = "2")
    {
      apqe.I(16, new Object[] { str, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131167276));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(wja.dp2px(16.0F, getResources()), wja.dp2px(13.0F, getResources()), 0, wja.dp2px(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      this.mListView.addHeaderView(this.dl);
      localObject1 = View.inflate(getActivity(), 2131561775, null);
      ((View)localObject1).setBackgroundResource(2130851773);
      this.jdField_a_of_type_Apos = new apos(this.app, getActivity(), this.mListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
      return;
      localObject1 = "2";
      break;
      bool1 = false;
      break label66;
      localObject1 = "相关推荐";
      break label81;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131563330;
  }
  
  public void i(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    if ((this.mIsDestroyed) || (!TextUtils.equals(this.mTroopUin, String.valueOf(paramLong)))) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.mY(paramList);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    try
    {
      paramActivity.requestWindowFeature(1);
      return;
    }
    catch (AndroidRuntimeException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
    case 260: 
    case 258: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          bKT();
          return;
          eba();
        } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
        this.C = paramIntent;
        return;
      } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false)));
      this.aUy = true;
      return;
    }
    x(paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    bLx();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (rpq.isFastDoubleClick()) {}
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363743: 
        k(((Integer)paramView.getTag()).intValue(), this.app);
        break;
      case 2131380238: 
        localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.mTroopUin });
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        super.startActivity((Intent)localObject2);
        break;
      case 2131368375: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
          cz(false, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
        for (;;)
        {
          apqe.I(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) });
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_Appx != null)) {
            this.jdField_a_of_type_Appx.crH();
          }
        }
      case 2131369579: 
        bLx();
        getActivity().finish();
        break;
      case 2131369594: 
        Qq();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (aBr()) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          aqfr.b("Grp_set_new", "grpData_visitor", "clk_upright", 0, 0, new String[] { localObject2, localObject1 });
          break;
        }
      case 2131381985: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          bOs();
        } else {
          cz(true, false);
        }
        break;
      }
    }
    apuh.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (i = 1;; i = 2)
    {
      apqe.I(19, new Object[] { Integer.valueOf(i), apuh.LG() + "" });
      break;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
    for (;;)
    {
      localObject1 = new Intent(getActivity(), PublicAccountBrowser.class);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("hideRightButton", true);
      ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i);
      startActivity((Intent)localObject1);
      apqe.I(20, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      jpp.a(this.app, 72);
      break;
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.mReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
      }
      this.mIsDestroyed = true;
      if (this.jdField_a_of_type_Appx != null)
      {
        this.jdField_a_of_type_Appx.detachView();
        this.jdField_a_of_type_Appx = null;
      }
      if (this.jdField_a_of_type_Apos != null) {
        this.jdField_a_of_type_Apos.onDetach();
      }
      this.x = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VisitorTroopCardFragment.Activity", 2, "doOnDestroy unregisterReceiver, e:" + localException.getMessage());
        }
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Appx != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Appx.hW(str, paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    String str2;
    if (this.mIsInit)
    {
      this.mIsInit = false;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label76;
      }
    }
    label76:
    for (String str1 = "1";; str1 = "0")
    {
      aqfr.b("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str2, str1 });
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
      ZM();
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Appx != null)
    {
      this.jdField_a_of_type_Appx.aC(null, false);
      this.jdField_a_of_type_Appx.Tx(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.baF();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.stopRoll();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.aRf))
    {
      this.aRf = true;
      ebc();
    }
  }
  
  public void q(int paramInt1, int paramInt2, String paramString)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.authKey))))
    {
      ath();
      if (this.jdField_a_of_type_Arib == null) {
        this.jdField_a_of_type_Arib = new arib(getActivity());
      }
      switch (paramInt2)
      {
      case -1: 
      default: 
        this.jdField_a_of_type_Arib.aq(2, 2131695144, 1500);
      }
    }
    label361:
    do
    {
      for (;;)
      {
        return;
        ((acms)this.app.getBusinessHandler(20)).ad(Long.parseLong(paramString), Long.parseLong(this.app.getAccount()));
        return;
        this.jdField_a_of_type_Arib.aq(2, 2131695145, 1500);
        getActivity().finish();
        wy(true);
        TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
        if (localTroopManager != null)
        {
          localTroopManager.l(localTroopManager.b(paramString));
          return;
          this.jdField_a_of_type_Arib.aq(2, 2131721390, 1500);
          return;
          if (getActivity().isResume())
          {
            if (paramInt1 != 3) {
              break;
            }
            if (paramInt2 == 0)
            {
              paramString = (TroopManager)this.app.getManager(52);
              if (paramString == null) {}
              for (paramString = null;; paramString = paramString.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
              {
                if ((paramString == null) || (paramString.wMemberNum == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                  break label361;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.app.getCurrentAccountUin(), getResources());
                if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.Ub(acfp.m(2131703770) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + acfp.m(2131703772));
                return;
              }
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    getActivity().setResult(-1, paramString);
    getActivity().finish();
  }
  
  public void showToast(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQToast.a(getActivity(), getString(2131698308), 1).show(getActivity().getTitleBarHeight());
  }
  
  public void uV(String paramString)
  {
    Tw(paramString);
  }
  
  public void uX(String paramString)
  {
    if (!getActivity().isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(getActivity(), 2, 2131718833, 1).show(getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      getActivity().finish();
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      startActivity(localIntent);
      getActivity().overridePendingTransition(2130772009, 2130772002);
    }
  }
  
  public void wy(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(getActivity(), ChatActivity.class);; localIntent = new Intent(getActivity(), SplashActivity.class))
    {
      wja.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      if ((paramBoolean) && (this.aUv))
      {
        localIntent.putExtra("fromThirdAppByOpenSDK", true);
        if ((getActivity().getIntent() != null) && (getActivity().getIntent().getExtras() != null))
        {
          localIntent.putExtra("appid", getActivity().getIntent().getExtras().getString("appid"));
          localIntent.putExtra("pkg_name", getActivity().getIntent().getExtras().getString("pkg_name"));
          localIntent.putExtra("app_name", getActivity().getIntent().getExtras().getString("app_name"));
          localIntent.putExtra("action", getActivity().getIntent().getExtras().getInt("pkg_name"));
        }
      }
      startActivity(localIntent);
      return;
    }
  }
  
  protected void x(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      aqfr.b("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = wja.a(new Intent(getActivity(), SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.app, getActivity(), paramIntent, (Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */