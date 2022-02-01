package com.tencent.mobileqq.troop.fragment;

import accc;
import acfp;
import acms;
import acnd;
import aerd;
import aldh;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aofk;
import aofr;
import apgf;
import apgg;
import apgh;
import aqdf;
import aqdf.a;
import aqfr;
import aqhu;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import rpq;
import sxx;
import zta;
import ztd;
import ztd.b;

public class TroopMoreDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, aqdf.a, ztd.b
{
  ImageView Eq;
  ImageView Er;
  acnd jdField_a_of_type_Acnd = new apgg(this);
  ExpandableTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView;
  public TroopMoreDetailView a;
  public TroopInfoData a;
  private ztd jdField_a_of_type_Ztd;
  boolean aUo;
  TextView aaA;
  TextView aaw;
  TextView aax;
  TextView aay;
  TextView aaz;
  int bFL;
  protected aqdf d;
  public boolean mIsDestroyed = false;
  public String mTroopUin;
  
  private void RF(boolean paramBoolean)
  {
    Object localObject1 = aerd.c();
    if ((paramBoolean) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean = TroopManager.c.iC(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
      {
        localObject2 = getActivity();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (paramBoolean)
        {
          i = 15;
          String str2 = VipUtils.a(0, i).toString();
          String str3 = acfp.m(2131716016);
          apgh localapgh = new apgh(this, paramBoolean);
          if (!paramBoolean) {
            break label167;
          }
          localObject1 = "0X800A57F";
          label114:
          if (!paramBoolean) {
            break label173;
          }
          i = 1;
          label120:
          VipUtils.a((Context)localObject2, str1, str2, str3, localapgh, (String)localObject1, i, paramBoolean);
        }
      }
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
        return;
        i = 8;
        break;
        label167:
        localObject1 = "0X8009E38";
        break label114;
        label173:
        i = 2;
        break label120;
        VipUtils.O(getActivity(), paramBoolean);
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", false);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean);
    if (!paramBoolean)
    {
      localObject2 = sxx.getViewRect(this.Eq);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    bw((Bundle)localObject1);
    anot.a(getQQAppInterface(), "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      aqfr.b("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private void aDR()
  {
    this.Eq = ((ImageView)findViewById(2131368375));
    this.aaw = ((TextView)findViewById(2131380362));
    this.aax = ((TextView)findViewById(2131380409));
    this.Er = ((ImageView)findViewById(2131380238));
    this.aay = ((TextView)findViewById(2131380327));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)findViewById(2131380300));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = ((TroopMoreDetailView)findViewById(2131380361));
    this.aaz = ((TextView)findViewById(2131380406));
    this.aaA = ((TextView)findViewById(2131380370));
  }
  
  private Drawable ax()
  {
    Object localObject1 = null;
    if (this.d != null)
    {
      localObject2 = this.d.b(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.d.isPausing())
        {
          this.d.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = aqhu.G();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(getQQAppInterface())) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  private void bKT()
  {
    Drawable localDrawable = ax();
    this.Eq.setImageDrawable(localDrawable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
      this.Eq.setOnClickListener(this);
    }
  }
  
  private void dZq()
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getQQAppInterface();
      } while (localObject == null);
      localObject = (acms)((QQAppInterface)localObject).getBusinessHandler(20);
    } while (localObject == null);
    ((acms)localObject).a(1, accc.Z(this.mTroopUin), 0L, 2, 11, 0, false);
  }
  
  private <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private String getDateString(long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = getResources().getString(2131698360) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  private QQAppInterface getQQAppInterface()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity.getAppInterface() instanceof QQAppInterface))) {
      return (QQAppInterface)localFragmentActivity.getAppInterface();
    }
    return null;
  }
  
  private void initUI()
  {
    setTitle(acfp.m(2131716021));
    bKT();
    this.aaw.setMaxLines(20);
    this.aaw.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
    this.aaw.setEllipsize(TextUtils.TruncateAt.END);
    aldh.m(this.aaw, acfp.m(2131716024));
    this.aax.setText(this.mTroopUin);
    aldh.m(this.aax, acfp.m(2131716025));
    String str2 = getDateString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new aofk(str1, 11, 15));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.ab().setEditableFactory(aofr.a);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.ab().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new apgf(this));
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 2L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 1L))
      {
        this.Er.setVisibility(0);
        this.Er.setOnClickListener(this);
        i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {
          i = 0;
        }
        if ((i <= 0) || (this.aUo)) {
          break label432;
        }
        str1 = String.format(getResources().getString(2131694962), new Object[] { Integer.valueOf(i) });
        this.aay.setText(str1);
        this.aay.setContentDescription(str1);
        this.aay.setVisibility(0);
        this.aay.setOnClickListener(this);
        label356:
        if (!this.aUo) {
          break label444;
        }
        this.aaz.setVisibility(8);
        this.aaA.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.initView();
      return;
      this.Er.setVisibility(8);
      break;
      this.Er.setVisibility(8);
      break;
      label432:
      this.aay.setVisibility(8);
      break label356;
      label444:
      this.aaz.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
      {
        this.aaz.setVisibility(8);
        label472:
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
          break label658;
        }
      }
      label658:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label663;
        }
        this.aaA.setVisibility(0);
        this.aaA.setText(getResources().getString(2131694963));
        this.aaA.setContentDescription(getResources().getString(2131694963));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
        {
          this.aaz.setVisibility(8);
          break label472;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
        {
          this.aaz.setText(getString(2131698511));
          break label472;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
        {
          this.aaz.setText(getString(2131698511));
          break label472;
        }
        this.aaz.setVisibility(8);
        break label472;
      }
      label663:
      this.aaA.setVisibility(8);
    }
  }
  
  public void bw(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent();
    paramBundle.setClass(getActivity(), TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.bFL);
    localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    boolean bool = localBundle.getBoolean("IS_EDIT");
    int i;
    if (!localBundle.getBoolean("IS_COVER"))
    {
      i = 1;
      if (i == 0) {
        break label218;
      }
      if (!bool) {
        break label211;
      }
      i = 260;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(i), localBundle }));
      }
      startActivityForResult(paramBundle, i);
      return;
      i = 0;
      break;
      label211:
      i = 261;
      continue;
      label218:
      if (bool) {
        i = 258;
      } else {
        i = 259;
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity();
    if (paramLayoutInflater == null) {}
    while (!(paramLayoutInflater.getAppInterface() instanceof QQAppInterface)) {
      return;
    }
    paramLayoutInflater.addObserver(this.jdField_a_of_type_Acnd);
    aDR();
    initUI();
    dZq();
  }
  
  public int getContentLayoutId()
  {
    return 2131560851;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.aUo = paramBundle.getBoolean("key_qidian_private_troop", false);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = ((TroopInfoData)paramBundle.getSerializable("key_troop_info_data"));
    this.bFL = paramBundle.getInt("troop_auth_submit_time", 0);
    this.mTroopUin = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    paramBundle = getActivity();
    if (paramBundle == null) {
      return;
    }
    this.d = new aqdf(paramBundle, paramBundle.getAppInterface());
    this.d.a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    case 98: 
    case 99: 
    default: 
      return;
    }
    bKT();
  }
  
  public void onClick(View paramView)
  {
    if (rpq.isFastDoubleClick()) {}
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = getActivity();
      if (localObject1 != null)
      {
        localObject2 = (QQAppInterface)((FragmentActivity)localObject1).getAppInterface();
        if (localObject2 != null) {
          switch (paramView.getId())
          {
          }
        }
      }
    }
    label96:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
    {
      RF(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label266;
      }
      localObject1 = "0";
    }
    for (;;)
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, "0", (String)localObject1, "");
      break;
      localObject2 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.mTroopUin });
      localObject1 = new Intent((Context)localObject1, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      super.startActivity((Intent)localObject1);
      break;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break label96;
      }
      if (this.jdField_a_of_type_Ztd == null)
      {
        this.jdField_a_of_type_Ztd = new zta(getActivity(), getActivity(), (QQAppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_Ztd.a(this);
      }
      this.jdField_a_of_type_Ztd.crH();
      break label96;
      label266:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        bKT();
      }
    }
  }
  
  public void onDestroyView()
  {
    this.mIsDestroyed = true;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.removeObserver(this.jdField_a_of_type_Acnd);
    if (this.d != null) {
      this.d.destory();
    }
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.onDestroy();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Ztd != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopMoreDetailFragment", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Ztd.ag(str, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment
 * JD-Core Version:    0.7.0.1
 */