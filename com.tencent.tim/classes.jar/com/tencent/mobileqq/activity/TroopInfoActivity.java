package com.tencent.mobileqq.activity;

import accc;
import accd;
import acfd;
import acff;
import acfp;
import acms;
import acnd;
import aerd;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import ankt;
import anot;
import aofk;
import aoop;
import apqw;
import apru;
import apug;
import apuh;
import apyg;
import apyh;
import aqbn;
import aqdf;
import aqdf.a;
import aqfr;
import aqfs;
import aqha;
import aqha.a;
import aqhu;
import aqiw;
import aqju;
import arhz;
import auvv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerReq;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQBindInfo;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQGroupBind;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import jnl;
import jpp;
import jrs;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import vza;
import vzb;
import vzc;
import vzd;
import vze;
import vzf;
import vzg;
import vzh;
import vzi;
import vzj;
import vzk;
import vzl;
import vzm;
import vzn;
import vzo;
import vzp;
import vzq;
import vzr;
import vzs;
import vzt;
import vzu;
import vzv;
import vzw;
import vzx;
import wja;
import zri;
import zta;
import ztd;
import ztd.b;
import zti;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aqdf.a, ztd.b
{
  public long Hd = -1L;
  public long He = -1L;
  public long Hf;
  public Dialog Z;
  acnd jdField_a_of_type_Acnd = new vzm(this);
  public apru a;
  public TroopInfoData a;
  Observer jdField_a_of_type_JavaUtilObserver = new vzr(this);
  private zta jdField_a_of_type_Zta;
  private ztd jdField_a_of_type_Ztd;
  public String aQv;
  public String aQw = "";
  protected boolean aRf;
  accd b;
  protected FriendListHandler b;
  public TroopInfo b;
  public int bFL;
  protected int bLA = 0;
  public int bLu = -1;
  public int bLv = -1;
  public int bLw = -1;
  public int bLx = -1;
  private int bLy;
  private int bLz;
  public boolean baZ;
  boolean bba = false;
  public boolean bbb;
  protected boolean bbc;
  private boolean bbd;
  acfd c = new vzk(this);
  public acms d;
  protected aqdf d;
  protected Button dc;
  protected LinearLayout dl;
  public boolean fk;
  protected arhz g;
  public Handler handler = new vzj(this);
  private boolean mIsCanceled;
  protected View[] p;
  protected ArrayList<String> pI = new ArrayList();
  public List<Integer> qy;
  protected View rV;
  BroadcastReceiver receiver = new vza(this);
  public View vq;
  protected View vr;
  protected XListView x;
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_b_of_type_Accd = new vzl(this);
  }
  
  private void Aw(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label104;
      }
    }
    label104:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          bWI();
        }
        if ((paramInt & 0x20) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;
          i(6, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
      }
      return;
    }
  }
  
  private void BM(int paramInt)
  {
    boolean bool;
    String str1;
    if (paramInt == 11)
    {
      paramInt = 1;
      if ((!aerd.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
        break label187;
      }
      bool = TroopManager.c.iC(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label179;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!bool) {
        break label161;
      }
      paramInt = 15;
      label75:
      String str2 = VipUtils.a(0, paramInt).toString();
      String str3 = acfp.m(2131715811);
      vzi localvzi = new vzi(this, bool);
      if (!bool) {
        break label167;
      }
      localObject = "0X800A57F";
      label110:
      if (!bool) {
        break label174;
      }
      paramInt = 1;
      label116:
      VipUtils.a(this, str1, str2, str3, localvzi, (String)localObject, paramInt, bool);
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
      paramInt = 0;
      break;
      label161:
      paramInt = 8;
      break label75;
      label167:
      localObject = "0X8009E38";
      break label110;
      label174:
      paramInt = 2;
      break label116;
      label179:
      VipUtils.O(this, bool);
    }
    label187:
    Object localObject = new Bundle();
    if (paramInt == 0)
    {
      bool = true;
      ((Bundle)localObject).putBoolean("IS_COVER", bool);
      ((Bundle)localObject).putBoolean("IS_EDIT", true);
      bw((Bundle)localObject);
      anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label314;
      }
    }
    label314:
    for (localObject = "1";; localObject = "0")
    {
      aqfr.b("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str1, localObject });
      return;
      bool = false;
      break;
    }
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, boolean paramBoolean, String paramString8, long paramLong2, long paramLong3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_loca", paramString7);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString8);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramLong2);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramLong3);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("troop_info_loca", paramString2);
    }
    localBundle.putInt("troop_info_lat", paramInt2);
    localBundle.putInt("troop_info_lon", paramInt3);
    localBundle.putInt("troop_info_cityid", paramInt4);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt);
    localBundle.putString("authSig", paramString2);
    return localBundle;
  }
  
  public static ArrayList<String> a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int j = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    Object localObject = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = apyh.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramContext)) {
        ((ArrayList)localObject).add(paramContext);
      }
      for (int i = 1;; i = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int k = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (j < k)
            {
              if ((i == 0) || (!((String)paramTroopInfoData.troopTags.get(j)).equals(paramContext))) {
                ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(j));
              }
              j += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.name))) {
                break label203;
              }
              if (paramContext.name.equals(acfp.m(2131715809)))
              {
                paramContext = "";
                break;
              }
              paramContext = paramContext.name;
              break;
            }
          }
        }
        return localObject;
      }
      label203:
      paramContext = "";
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(String.format(getString(2131694906), new Object[] { Integer.valueOf(this.bLw) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131721079);
    localTextView3.setText(2131694850);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new vzf(this, localReportDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new vzg(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    CA();
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label244;
        }
      }
      label244:
      for (str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;; str = "")
      {
        anot.a(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str, "5", "", "");
        QQToast.a(this, 1, paramString, 1).show(getTitleBarHeight());
        if (paramBoolean)
        {
          ((acms)this.app.getBusinessHandler(20)).notifyUI(111, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
          finish();
        }
        return;
        switch ((int)paramLong1)
        {
        default: 
          paramString = getString(2131694901);
          break;
        case 1281: 
          paramString = getString(2131694902);
          break;
        case 1282: 
          paramString = getString(2131694903);
          break;
        case 1283: 
          paramString = getString(2131694904);
          break;
        case 1793: 
          paramString = getString(2131694905);
          break;
        }
      }
    }
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      label273:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break label352;
      }
    }
    label352:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa);; str = "")
    {
      anot.a(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, paramString, str, "", "");
      QQToast.a(this, 2, getString(2131694908), 1).show(getTitleBarHeight());
      break;
      paramString = "";
      break label273;
    }
  }
  
  private void aJ(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      int j = 1;
      int i = j;
      if (paramInt == 8)
      {
        i = j;
        if (!apuh.cS(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
          i = 0;
        }
      }
      if ((i != 0) && (apuh.t(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt))) {
        aK(paramInt, paramBoolean);
      }
    }
  }
  
  private void aK(int paramInt, boolean paramBoolean)
  {
    int i = 8;
    View localView;
    if (paramInt < this.p.length)
    {
      localObject = this.p[paramInt];
      if (localObject != null)
      {
        localView = ((View)localObject).findViewById(2131376999);
        if (paramInt != 8) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((View)localObject).findViewById(2131379411);; localObject = ((View)localObject).findViewById(2131365360))
    {
      if (localView != null)
      {
        paramInt = i;
        if (paramBoolean) {
          paramInt = 0;
        }
        localView.setVisibility(paramInt);
      }
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        i = getResources().getDimensionPixelSize(2131298902);
        paramInt = i;
        if (paramBoolean) {
          paramInt = i * 2;
        }
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
      }
      return;
    }
  }
  
  private Drawable ax()
  {
    Object localObject1 = null;
    if (this.jdField_d_of_type_Aqdf != null)
    {
      localObject2 = this.jdField_d_of_type_Aqdf.b(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_d_of_type_Aqdf.isPausing())
        {
          this.jdField_d_of_type_Aqdf.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = aqhu.G();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.app)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  private String b(int paramInt1, int paramInt2, String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId;
      double d1 = paramInt1 / 1000000.0D;
      double d2 = paramInt2 / 1000000.0D;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Double.valueOf(d2), str });
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.troopinfo.troop.location_info", 2, "initCurrentLocationStruct==>locationStruct:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramActivity.toString());
    }
  }
  
  private void b(XListView paramXListView)
  {
    if (paramXListView == null) {
      return;
    }
    this.vq = super.getLayoutInflater().inflate(2131560778, paramXListView, false);
    this.vr = this.vq.findViewById(2131379739);
    ((ImageButton)this.vq.findViewById(2131364677)).setOnClickListener(new vzn(this, paramXListView));
    paramXListView.addHeaderView(this.vq);
    this.vr.setVisibility(8);
  }
  
  private void bKT()
  {
    View localView = this.p[11];
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label111;
      }
      SpannableString localSpannableString = new SpannableString("[Avatar]");
      Drawable localDrawable = ax();
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, ankt.dip2px(32.0F), ankt.dip2px(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(11, 2, localView, getString(2131701823), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        aJ(11, false);
      }
    }
    return;
    label111:
    a(11, 2, localView, getString(2131701823), acfp.m(2131715808), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    aJ(11, true);
  }
  
  private void bWA()
  {
    if ((this.fk) && (this.bFL == 0))
    {
      Object localObject = aqha.a(this, 230);
      ((aqju)localObject).setTitle(null);
      long l2 = this.Hd;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((aqju)localObject).setMessage(getString(2131694910, new Object[] { l1 + "" }));
      ((aqju)localObject).setNegativeButton(getString(2131694860), new vzx(this));
      ((aqju)localObject).setPositiveButton(getString(2131694830), new vzb(this));
      ((aqju)localObject).show();
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (localObject = "0";; localObject = "1")
      {
        anot.a(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject, "", "");
        return;
      }
    }
    bWG();
  }
  
  private void bWE()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, setLastActivityName(), null));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, setLastActivityName(), null), 8);
      return;
    }
    cf(2131721390, 1);
  }
  
  private void bWF()
  {
    Object localObject = this.app.getCurrentAccountUin();
    int i;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin).equals(localObject)) {
      i = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, i);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) {
        ((ProfileActivity.AllInOne)localObject).nickname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick;
      }
      ((ProfileActivity.AllInOne)localObject).troopcode = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      ((ProfileActivity.AllInOne)localObject).troopUin = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      if (i == 21) {
        ((ProfileActivity.AllInOne)localObject).subSourceId = 11;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
      {
        if (((acff)this.app.getManager(51)).isFriend(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          i = 20;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          i = 21;
          continue;
        }
      }
      i = 19;
    }
  }
  
  private void bWI()
  {
    ThreadManager.post(new TroopInfoActivity.23(this), 5, null, true);
  }
  
  private void bWJ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.24(this), 5, null, true);
  }
  
  private void bWK()
  {
    TextView localTextView;
    if (this.vq != null)
    {
      localTextView = (TextView)this.vq.findViewById(2131379450);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label520;
      }
    }
    label520:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
        i = j | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        j = i;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
      }
      else
      {
        j = i | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        i = j | 0x8;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) {
        j = i | 0x10;
      }
      i = j;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        i = j | 0x20;
      }
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (at(i, 32)) {
        if (this.bLv == 2) {
          i = 2131699739;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.vr.setVisibility(0);
          localTextView.setText(i);
          localTextView.setContentDescription(getString(i));
          return;
          if ((this.bLv == 3) && (!bool))
          {
            i = 2131699740;
            localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
            continue;
            if (at(i, 1))
            {
              if (at(i, 2))
              {
                if ((at(i, 4)) || (at(i, 8)) || (at(i, 16)))
                {
                  i = 2131699753;
                  continue;
                }
                i = 2131699752;
                continue;
              }
              if (at(i, 8))
              {
                i = 2131699746;
                continue;
              }
              if (at(i, 4))
              {
                i = 2131699745;
                continue;
              }
              i = 2131699744;
              continue;
            }
            if (at(i, 2))
            {
              if (at(i, 4))
              {
                i = 2131699751;
                continue;
              }
              if ((at(i, 8)) || (at(i, 16)))
              {
                i = 2131699750;
                continue;
              }
              i = 2131699749;
              continue;
            }
            if ((at(i, 8)) && (at(i, 4)))
            {
              i = 2131699741;
              continue;
            }
            if (at(i, 8))
            {
              i = 2131699743;
              continue;
            }
            if (at(i, 4)) {
              i = 2131699742;
            }
          }
        }
        else
        {
          this.vr.setVisibility(8);
          return;
        }
        i = 0;
      }
    }
  }
  
  private void bWL()
  {
    startTitleProgress();
    jrs.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new vzo(this));
  }
  
  private void bWM()
  {
    jrs.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new vzp(this));
  }
  
  private void bWx()
  {
    View localView = this.p[12];
    ArrayList localArrayList = new ArrayList();
    zti.a(localArrayList, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo);
    if (localArrayList.size() == 0)
    {
      a(12, 2, localView, getString(2131721485), acfp.m(2131715812), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      aJ(12, true);
    }
    for (;;)
    {
      localView.setTag(2131721485, Integer.valueOf(localArrayList.size()));
      return;
      String str = apqw.oL(apqw.p(((zri)localArrayList.get(0)).baF, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1));
      URLDrawable localURLDrawable = null;
      Object localObject1 = null;
      int i = ankt.dip2px(30.0F);
      localObject3 = localURLDrawable;
      try
      {
        URL localURL = zti.f(str);
        if (localURL != null)
        {
          localObject3 = localURLDrawable;
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
          localObject3 = localURLDrawable;
          localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject1);
          localObject3 = localURLDrawable;
          localURLDrawable.setTag(new int[] { i, i, 0 });
          localObject3 = localURLDrawable;
          localURLDrawable.setDecodeHandler(aqbn.e);
          localObject1 = localURLDrawable;
          localObject3 = localURLDrawable;
          if (localURLDrawable.getStatus() != 1)
          {
            localObject3 = localURLDrawable;
            localURLDrawable.setURLDrawableListener(new vzu(this));
            localObject1 = localURLDrawable;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = localObject3;
          continue;
          boolean bool = false;
        }
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 == null) {
          break;
        }
        bool = true;
        QLog.i("Q.troopinfo", 2, String.format("updateCoverEntry ud!=null?%b path=%s", new Object[] { Boolean.valueOf(bool), str }));
      }
      localObject3 = null;
      if (localObject1 != null)
      {
        localObject3 = new SpannableString("[Avatar]");
        ((URLDrawable)localObject1).setBounds(0, 0, i, i);
        ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), 0, ((SpannableString)localObject3).length(), 17);
      }
      a(12, 2, localView, getString(2131721485), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      aJ(12, false);
    }
  }
  
  public static Bundle c(String paramString, int paramInt)
  {
    return a(paramString, "", paramInt);
  }
  
  public static void i(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramContext.toString());
    }
  }
  
  private void p(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      paramView = paramView.findViewById(2131376999);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt, false);
        aK(paramInt, false);
      }
    }
  }
  
  private String pb()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2))
    {
      anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131699734);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131699732);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131699733);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131699731);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131699730);
    }
    return "";
  }
  
  public void BK(int paramInt)
  {
    String str = getString(paramInt);
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(str);
    localaqju.setMessage(null);
    localaqju.setPositiveButton(getString(2131694891), new vzc(this, localaqju));
    localaqju.setPositiveButtonContentDescription(getString(2131694891));
    localaqju.setNegativeButton(getString(2131694830), new aqha.a());
    localaqju.setNegativeButtonContentDescription(getString(2131694830));
    localaqju.show();
  }
  
  public void BL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.rV.setVisibility(8);
      this.dc.setVisibility(8);
      return;
    case 13: 
      this.rV.setVisibility(8);
      this.dc.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131694925);
      return;
    }
    this.dc.setText(2131695150);
    this.dc.setTag(Integer.valueOf(14));
    this.rV.setVisibility(0);
    this.dc.setVisibility(0);
  }
  
  public void CA()
  {
    if (this.Z != null)
    {
      if (this.Z.isShowing()) {
        this.Z.dismiss();
      }
      this.Z = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    label48:
    TextView localTextView2;
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView1 = (TextView)paramView.findViewById(2131379769);
        localTextView2 = (TextView)paramView.findViewById(2131369154);
        localView = paramView.findViewById(2131362978);
        paramView = paramString;
        if (paramString == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        if (6 == paramInt1)
        {
          localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
          if (TextUtils.isEmpty(paramCharSequence))
          {
            localTextView2.setVisibility(8);
            label127:
            if (!paramBoolean) {
              break label231;
            }
          }
        }
        break;
      }
    }
    label231:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839682);
      break label48;
      paramView.setBackgroundResource(2130839701);
      break label48;
      paramView.setBackgroundResource(2130839695);
      break label48;
      paramView.setBackgroundResource(2130839689);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new aofk(paramCharSequence, 11, 20));
      break label127;
      localTextView2.setText(paramCharSequence);
      break label127;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131379769);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362978);
    if (paramBoolean)
    {
      paramInt3 = 0;
      label104:
      paramString.setVisibility(paramInt3);
      if (!paramBoolean) {
        break label168;
      }
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
        paramInt3 = 8;
        break label104;
        label168:
        paramView.setTag(null);
        paramView.setOnClickListener(null);
      }
    }
    paramView.setBackgroundResource(2130839682);
    return;
    paramView.setBackgroundResource(2130839701);
    return;
    paramView.setBackgroundResource(2130839695);
    return;
    paramView.setBackgroundResource(2130839689);
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.p.length)) {}
    for (View localView = this.p[paramInt1];; localView = null)
    {
      LinearLayout localLinearLayout;
      Object localObject1;
      Object localObject2;
      if (localView != null)
      {
        localLinearLayout = (LinearLayout)localView.findViewById(2131364819);
        localLinearLayout.removeAllViews();
        localObject1 = (LinearLayout)localView.findViewById(2131379411);
        localObject2 = (TextView)localView.findViewById(2131369154);
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((TextView)localObject2).setText(acfp.m(2131715815));
          aJ(paramInt1, true);
        }
      }
      else
      {
        return;
      }
      aJ(paramInt1, false);
      ((LinearLayout)localObject1).setVisibility(8);
      localLinearLayout.setVisibility(0);
      int j = 0;
      while ((j < paramArrayList.size()) && (j < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(j)))
        {
          j += 1;
        }
        else
        {
          localObject1 = new TextView(this);
          ((TextView)localObject1).setId(2131374487);
          int i = 2130844646;
          if (paramInt2 == 1) {
            i = 2130844647;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(i);
            ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
            ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
            ((TextView)localObject1).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject1).setMaxWidth(wja.dp2px(77.0F, getResources()));
            }
            ((TextView)localObject1).setSingleLine();
            ((TextView)localObject1).setTextColor(getResources().getColor(2131167461));
            ((TextView)localObject1).setPadding(wja.dp2px(6.0F, getResources()), wja.dp2px(2.0F, getResources()), wja.dp2px(8.0F, getResources()), wja.dp2px(2.0F, getResources()));
            ((TextView)localObject1).setGravity(17);
            ((TextView)localObject1).setText((CharSequence)paramArrayList.get(j));
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(5.0F, getResources());
            localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break;
            if (paramInt2 == 2) {
              i = 2130844646;
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131362978);
      if (paramBoolean1)
      {
        localView.setTag(Integer.valueOf(paramInt1));
        localView.setOnClickListener(this);
        paramArrayList.setVisibility(0);
        return;
      }
      localView.setTag(null);
      localView.setOnClickListener(null);
      paramArrayList.setVisibility(8);
      return;
    }
  }
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int i = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject = null;
    if (i == -3000005) {
      this.bLA = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, "onGetGameBindStatus ret=" + i + ", status=" + this.bLA + ", name=" + (String)localObject);
      }
      return;
      if (i == 0)
      {
        paramGCBindGroupSsoServerRsp = paramGCBindGroupSsoServerRsp.bind_info.app_name.get();
        localObject = paramGCBindGroupSsoServerRsp;
        if (!TextUtils.isEmpty(paramGCBindGroupSsoServerRsp))
        {
          this.bLA = 1;
          localObject = paramGCBindGroupSsoServerRsp;
        }
      }
    }
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      if (paramGroupInfo.string_group_name.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
      }
      Object localObject1;
      if (paramGroupInfo.group_geo_info.has())
      {
        localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_group_class_ext.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
      }
      if ((paramGroupInfo.rpt_tag_record.has()) && (paramGroupInfo.rpt_tag_record.size() > 0))
      {
        Object localObject2 = paramGroupInfo.rpt_tag_record.get();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((oidb_0x88d.TagRecord)((Iterator)localObject2).next()).bytes_tag_value.get().toStringUtf8());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = ((List)localObject1);
      }
      if (paramGroupInfo.string_group_finger_memo.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      }
      this.handler.sendEmptyMessage(4);
      this.handler.sendEmptyMessage(6);
      bWI();
    }
  }
  
  boolean at(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public void atg()
  {
    try
    {
      if (this.g == null)
      {
        this.g = new arhz(getActivity(), getTitleBarHeight());
        this.g.setMessage(2131696693);
        this.g.setBackAndSearchFilter(false);
      }
      this.g.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
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
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void bLl()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopLocationModifyActivity.h(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
    }
  }
  
  public void bLn()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      i(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
      aJ(5, false);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
        {
          i(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
          aJ(5, false);
          return;
        }
        i(5, acfp.m(2131715807), true);
        aJ(5, true);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
      {
        i(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, false);
        aJ(5, false);
        return;
      }
    } while (this.p[5] == null);
    this.p[5].setVisibility(8);
  }
  
  public void bWB()
  {
    if (!this.fk)
    {
      this.mIsCanceled = true;
      finish();
      return;
    }
    BK(2131694892);
  }
  
  public void bWC()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
  }
  
  protected void bWD()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = apyh.a(getApplicationContext()).a(this, (String)localObject1);
    localObject1 = "";
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        localIntent.putExtra("subclass", (String)localObject1);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append((String)localObject3 + "\n");
            continue;
            if ((localObject3 == null) || (TextUtils.isEmpty(((apyg)localObject3).name))) {
              break label311;
            }
            if (((apyg)localObject3).name.equals(acfp.m(2131715816)))
            {
              i = 0;
              break;
            }
            localObject1 = ((apyg)localObject3).name;
            i = 1;
            break;
          }
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
      }
      localIntent.putExtra("act_type", 1);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("modifyToSrv", 0);
      startActivityForResult(localIntent, 9);
      return;
      label311:
      i = 0;
    }
  }
  
  public void bWG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.fk)
    {
      finish();
      return;
    }
    anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa), "", "");
    Object localObject2 = (accc)this.app.getBusinessHandler(22);
    if (localObject2 == null)
    {
      finish();
      return;
    }
    long l6;
    try
    {
      l6 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == -1)
      {
        finish();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      finish();
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct;
    int m = 0;
    int k = 0;
    long l1 = 0L;
    long l4 = 0L;
    Object localObject1 = "";
    int i;
    long l2;
    int j;
    long l3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      i = k;
      l2 = l1;
      j = m;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        i = k;
        l2 = l1;
        j = m;
        l3 = l1;
        k = Integer.valueOf(localObject3[0]).intValue();
        i = k;
        l2 = l1;
        j = k;
        l3 = l1;
        l1 = (Double.valueOf(localObject3[1]).doubleValue() * 1000000.0D);
        i = k;
        l2 = l1;
        j = k;
        l3 = l1;
        long l5 = (Double.valueOf(localObject3[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject3[3];
        i = k;
        l2 = l5;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        l1 = l2;
        l2 = l4;
        continue;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        i = j;
        l1 = l3;
        l2 = l4;
        continue;
        k = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) {
          continue;
        }
        j = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) {
          continue;
        }
        j = 2;
        continue;
      }
      dN(getString(2131694907));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        k = 3;
        if (k == -1) {
          break;
        }
        j = 1;
        if (this.Hf == 0L) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == this.Hf) {
          continue;
        }
        j = 3;
        if (((this.bLu == 0) || (1 == this.bLu)) && (k == 3)) {
          anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.aQw, "", "");
        }
        if (((this.bLu == 2) || (this.bLu == 3) || (this.bLu == 4)) && ((k == 0) || (1 == k))) {
          anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.aQw, "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) {
          break label719;
        }
        CA();
        if (this.bLx <= 0) {
          break label631;
        }
        a(l6, k, i, l1, l2, (String)localObject1);
        anot.a(this.app, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, "" + l6, "", "", "");
        return;
      }
      label631:
      if (this.bLw <= 0) {
        break;
      }
      localObject1 = aqha.a(this, 230);
      ((aqju)localObject1).setTitle(null);
      ((aqju)localObject1).setMessage(getString(2131694897, new Object[] { Integer.valueOf(this.bLw) }));
      ((aqju)localObject1).setPositiveButton(getString(2131694860), new aqha.a());
      ((aqju)localObject1).setPositiveButtonContentDescription(getString(2131694860));
      ((aqju)localObject1).show();
      return;
      label719:
      if (((2 == this.bLu) || (4 == this.bLu)) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4)))
      {
        localObject2 = localObject1;
        l4 = l1;
        l3 = l2;
        if (0L == l1)
        {
          localObject2 = localObject1;
          l4 = l1;
          l3 = l2;
          if (0L == l2)
          {
            l4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat;
            l3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
          }
        }
        anot.a(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.aQw, "", "");
        jrs.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, i, l4, l3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, j, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new vzd(this));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.Hf != 0L))
      {
        jrs.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, i, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, j, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new vze(this));
        return;
      }
      ((accc)localObject2).a(l6, k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, i, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      return;
      i = 0;
      l2 = l4;
    }
  }
  
  public void bWH()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    startActivity(localIntent);
  }
  
  public void bWN()
  {
    GCBindGroup.GCBindGroupSsoServerReq localGCBindGroupSsoServerReq = new GCBindGroup.GCBindGroupSsoServerReq();
    localGCBindGroupSsoServerReq.cmd.set("get_appid");
    Object localObject = new GCBindGroup.QQGroupBind();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((GCBindGroup.QQGroupBind)localObject).group_code.set(l);
      localGCBindGroupSsoServerReq.bind_req.set((MessageMicro)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), jnl.class);
      vzq localvzq = new vzq(this);
      localvzq.n = new WeakReference(this.app);
      localvzq.mType = 2;
      ((NewIntent)localObject).setObserver(localvzq);
      ((NewIntent)localObject).putExtra("cmd", "gcbindgroupsso.get_appid");
      ((NewIntent)localObject).putExtra("data", localGCBindGroupSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("Q.troopinfo", 1, "get game bind status failed, troop=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
  }
  
  public void bWy()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new TroopInfoActivity.6(this), 5, null, false);
    }
  }
  
  public void bWz()
  {
    if (((this.Hf != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L)) && (this.bFL == 0))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount <= 0)
      {
        localObject = aqha.a(this, 230);
        ((aqju)localObject).setTitle(null);
        ((aqju)localObject).setMessage(getString(2131699729));
        ((aqju)localObject).setPositiveButton(getString(2131694860), new aqha.a());
        ((aqju)localObject).setPositiveButtonContentDescription(getString(2131694860));
        ((aqju)localObject).show();
        return;
      }
      if (this.fk)
      {
        localObject = pa();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = aqha.a(this, 230);
          ((aqju)localObject).setTitle(null);
          ((aqju)localObject).setMessage(getString(2131699728, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((aqju)localObject).setPositiveButton(getString(2131694860), new vzv(this));
          ((aqju)localObject).setNegativeButton(getString(2131694830), new vzw(this));
          ((aqju)localObject).show();
          return;
        }
        wL((String)localObject);
        return;
      }
      bWG();
      return;
    }
    bWG();
  }
  
  public void bw(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent();
    paramBundle.setClass(this, TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.bFL);
    localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    if (!localBundle.getBoolean("IS_COVER"))
    {
      i = 1;
      if (i == 0) {
        break label186;
      }
    }
    label186:
    for (int i = 260;; i = 258)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(i), localBundle }));
      }
      startActivityForResult(paramBundle, i);
      return;
      i = 0;
      break;
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  protected boolean checkParams()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    for (;;)
    {
      try
      {
        Object localObject = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = ((Bundle)localObject).getString("troop_uin");
        if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) <= 0L) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa = ((Bundle)localObject).getInt("troop_info_from");
        this.bLy = ((Bundle)localObject).getInt("troop_info_report_from", -1);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark = ((Bundle)localObject).getString("param_return_addr");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopface = ((Bundle)localObject).getShort("troop_info_faceid");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = ((Bundle)localObject).getString("troop_info_name");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin = ((Bundle)localObject).getString("troop_info_owner");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = ((Bundle)localObject).getLong("troop_info_classext");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((Bundle)localObject).getString("troop_info_loca");
        this.aQv = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId = ((Bundle)localObject).getInt("troop_info_cityid", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct = b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = aqfs.K(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = aqfs.L(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.bLu = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.bFL = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.bLz = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
        localObject = (TroopManager)this.app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo((TroopInfo)localObject, this.app.getCurrentAccountUin());
            bool1 = true;
          }
        }
      }
      catch (Exception localException2)
      {
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          this.aQw = "0";
          bool2 = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopinfo", 2, String.format("checkParams troopUin: %s, classExt: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt) }));
          }
          return bool2;
          if (QLog.isColorLevel()) {
            QLog.e("Q.troopinfo", 2, "can't find troop info of :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          bool1 = false;
          continue;
        }
        bool2 = bool1;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          continue;
        }
        this.aQw = "1";
        bool2 = bool1;
        continue;
        bool2 = bool1;
      }
      catch (Exception localException1) {}
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopinfo", 2, localException1.toString());
        bool2 = bool1;
      }
    }
  }
  
  protected void dN(String paramString)
  {
    CA();
    arhz localarhz = new arhz(this, getTitleBarHeight());
    localarhz.setMessage(paramString);
    localarhz.setCancelable(false);
    localarhz.setOnDismissListener(new vzh(this));
    this.Z = localarhz;
    this.Z.show();
  }
  
  /* Error */
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 669	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 702
    //   9: iconst_2
    //   10: new 673	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 674	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1908
    //   20: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 1910
    //   30: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 1912
    //   40: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_3
    //   44: invokevirtual 1256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 681	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 705	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iconst_m1
    //   54: iload_2
    //   55: if_icmpne +69 -> 124
    //   58: iload_1
    //   59: lookupswitch	default:+65->124, 5:+460->519, 7:+122->181, 8:+644->703, 9:+823->882, 11:+553->612, 16:+193->252, 257:+938->997
    //   125: sipush 258
    //   128: if_icmpne +923 -> 1051
    //   131: aload_3
    //   132: ifnull +44 -> 176
    //   135: aload_3
    //   136: ldc_w 1914
    //   139: invokevirtual 1918	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   142: astore_3
    //   143: invokestatic 669	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +30 -> 176
    //   149: aload_3
    //   150: ifnonnull +888 -> 1038
    //   153: aconst_null
    //   154: astore_3
    //   155: ldc_w 702
    //   158: iconst_2
    //   159: ldc_w 1920
    //   162: iconst_1
    //   163: anewarray 456	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_3
    //   169: aastore
    //   170: invokestatic 466	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 705	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: invokespecial 708	com/tencent/mobileqq/activity/TroopInfoActivity:bWx	()V
    //   180: return
    //   181: aload_3
    //   182: ifnull -58 -> 124
    //   185: aload_3
    //   186: invokevirtual 1816	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   189: ifnull -65 -> 124
    //   192: aload_3
    //   193: invokevirtual 1816	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   196: astore 9
    //   198: aload_0
    //   199: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   202: aload 9
    //   204: ldc_w 1529
    //   207: invokevirtual 1818	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 1158	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   217: aload 9
    //   219: ldc_w 1535
    //   222: iconst_0
    //   223: invokevirtual 1827	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   226: putfield 1432	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   229: aload_0
    //   230: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   233: aload 9
    //   235: ldc_w 1540
    //   238: iconst_0
    //   239: invokevirtual 1827	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   242: putfield 1438	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   245: aload_0
    //   246: invokevirtual 1922	com/tencent/mobileqq/activity/TroopInfoActivity:bLn	()V
    //   249: goto -125 -> 124
    //   252: aload_3
    //   253: ifnull -129 -> 124
    //   256: aload_3
    //   257: invokevirtual 1816	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   260: ifnull -136 -> 124
    //   263: aload_3
    //   264: invokevirtual 1816	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   267: astore 9
    //   269: aload_0
    //   270: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   273: getfield 1158	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   276: aload 9
    //   278: ldc_w 1529
    //   281: invokevirtual 1818	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokestatic 1928	aqft:equalsWithNullCheck	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   287: ifne +8 -> 295
    //   290: aload_0
    //   291: iconst_1
    //   292: putfield 782	com/tencent/mobileqq/activity/TroopInfoActivity:fk	Z
    //   295: aload_0
    //   296: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   299: aload 9
    //   301: ldc_w 1930
    //   304: invokevirtual 1818	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: putfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   310: invokestatic 669	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +36 -> 349
    //   316: ldc_w 671
    //   319: iconst_2
    //   320: new 673	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 674	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 1932
    //   330: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   337: getfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   340: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 681	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 1753	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_0
    //   350: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   353: getfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   356: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifne +39 -> 398
    //   362: aload_0
    //   363: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   366: getfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   369: ldc_w 1606
    //   372: invokevirtual 1610	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   375: astore 10
    //   377: aload 10
    //   379: arraylength
    //   380: iconst_5
    //   381: if_icmplt +96 -> 477
    //   384: aload_0
    //   385: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   388: aload 10
    //   390: iconst_4
    //   391: aaload
    //   392: invokestatic 1601	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   395: putfield 1652	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   398: aload_0
    //   399: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   402: aload 9
    //   404: ldc_w 1529
    //   407: invokevirtual 1818	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: putfield 1158	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   413: aload_0
    //   414: invokevirtual 1922	com/tencent/mobileqq/activity/TroopInfoActivity:bLn	()V
    //   417: goto -293 -> 124
    //   420: astore 11
    //   422: invokestatic 669	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -27 -> 398
    //   428: ldc_w 702
    //   431: iconst_2
    //   432: new 673	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 674	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 1934
    //   442: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 10
    //   447: iconst_4
    //   448: aaload
    //   449: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 1936
    //   455: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_0
    //   459: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   462: getfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   465: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 681	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 1753	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: goto -76 -> 398
    //   477: invokestatic 669	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq -82 -> 398
    //   483: ldc_w 702
    //   486: iconst_2
    //   487: new 673	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 674	java/lang/StringBuilder:<init>	()V
    //   494: ldc_w 1938
    //   497: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_0
    //   501: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   504: getfield 1604	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   507: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 681	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 1941	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: goto -118 -> 398
    //   519: aload_3
    //   520: ldc_w 1943
    //   523: invokevirtual 1946	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   526: astore 9
    //   528: aload 9
    //   530: aload_0
    //   531: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   534: getfield 176	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   537: invokestatic 1949	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   540: ifne -416 -> 124
    //   543: aload_0
    //   544: iconst_1
    //   545: putfield 782	com/tencent/mobileqq/activity/TroopInfoActivity:fk	Z
    //   548: aload_0
    //   549: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   552: aload 9
    //   554: putfield 176	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   557: aload_0
    //   558: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   561: getfield 176	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   564: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   567: ifne +30 -> 597
    //   570: aload_0
    //   571: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   574: getfield 176	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   577: astore 9
    //   579: aload_0
    //   580: bipush 6
    //   582: aload 9
    //   584: aload_0
    //   585: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   588: invokevirtual 180	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   591: invokevirtual 184	com/tencent/mobileqq/activity/TroopInfoActivity:i	(ILjava/lang/String;Z)V
    //   594: goto -470 -> 124
    //   597: aload_0
    //   598: invokevirtual 595	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   601: ldc_w 1950
    //   604: invokevirtual 1951	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   607: astore 9
    //   609: goto -30 -> 579
    //   612: ldc2_w 1952
    //   615: lstore 7
    //   617: aload_3
    //   618: ldc_w 1955
    //   621: invokevirtual 1946	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   624: invokestatic 1601	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   627: lstore 5
    //   629: aload_0
    //   630: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   633: getfield 167	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   636: lload 5
    //   638: lcmp
    //   639: ifeq -515 -> 124
    //   642: lload 5
    //   644: ldc2_w 1952
    //   647: lcmp
    //   648: ifeq -524 -> 124
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 782	com/tencent/mobileqq/activity/TroopInfoActivity:fk	Z
    //   656: aload_0
    //   657: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   660: lload 5
    //   662: putfield 167	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   665: aload_0
    //   666: invokespecial 170	com/tencent/mobileqq/activity/TroopInfoActivity:bWI	()V
    //   669: goto -545 -> 124
    //   672: astore 9
    //   674: lload 7
    //   676: lstore 5
    //   678: invokestatic 669	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq -52 -> 629
    //   684: ldc_w 702
    //   687: iconst_2
    //   688: aload 9
    //   690: invokevirtual 703	java/lang/Exception:toString	()Ljava/lang/String;
    //   693: invokestatic 705	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: lload 7
    //   698: lstore 5
    //   700: goto -71 -> 629
    //   703: aload_0
    //   704: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   707: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   710: iconst_2
    //   711: if_icmpeq +159 -> 870
    //   714: aload_0
    //   715: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   718: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   721: bipush 6
    //   723: if_icmpeq +147 -> 870
    //   726: aload_0
    //   727: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   730: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   733: bipush 15
    //   735: if_icmpeq +135 -> 870
    //   738: aload_0
    //   739: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   742: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   745: bipush 10
    //   747: if_icmpeq +123 -> 870
    //   750: aload_0
    //   751: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   754: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   757: bipush 11
    //   759: if_icmpeq +111 -> 870
    //   762: aload_0
    //   763: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   766: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   769: bipush 19
    //   771: if_icmpeq +99 -> 870
    //   774: aload_0
    //   775: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   778: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   781: bipush 101
    //   783: if_icmpeq +87 -> 870
    //   786: aload_0
    //   787: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   790: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   793: bipush 102
    //   795: if_icmpeq +75 -> 870
    //   798: aload_0
    //   799: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   802: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   805: bipush 103
    //   807: if_icmpeq +63 -> 870
    //   810: aload_0
    //   811: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   814: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   817: bipush 104
    //   819: if_icmpeq +51 -> 870
    //   822: aload_0
    //   823: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   826: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   829: bipush 105
    //   831: if_icmpeq +39 -> 870
    //   834: aload_0
    //   835: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   838: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   841: bipush 106
    //   843: if_icmpeq +27 -> 870
    //   846: aload_0
    //   847: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   850: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   853: bipush 112
    //   855: if_icmpne +15 -> 870
    //   858: aload_0
    //   859: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   862: getfield 554	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   865: bipush 113
    //   867: if_icmpeq -743 -> 124
    //   870: aload_0
    //   871: iconst_m1
    //   872: invokevirtual 1593	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   875: aload_0
    //   876: invokevirtual 546	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   879: goto -755 -> 124
    //   882: aload_3
    //   883: ldc_w 1579
    //   886: invokevirtual 1946	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   889: astore 10
    //   891: aload 10
    //   893: ifnull -769 -> 124
    //   896: aload 10
    //   898: invokevirtual 1154	java/lang/String:length	()I
    //   901: ifle -777 -> 124
    //   904: new 89	java/util/ArrayList
    //   907: dup
    //   908: invokespecial 90	java/util/ArrayList:<init>	()V
    //   911: astore 9
    //   913: new 1957	org/json/JSONArray
    //   916: dup
    //   917: invokespecial 1958	org/json/JSONArray:<init>	()V
    //   920: pop
    //   921: new 1957	org/json/JSONArray
    //   924: dup
    //   925: aload 10
    //   927: invokespecial 1960	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   930: astore 10
    //   932: iconst_0
    //   933: istore_2
    //   934: aload 10
    //   936: invokevirtual 1961	org/json/JSONArray:length	()I
    //   939: istore 4
    //   941: iload_2
    //   942: iload 4
    //   944: if_icmpge +26 -> 970
    //   947: aload 9
    //   949: aload 10
    //   951: iload_2
    //   952: invokevirtual 1962	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   955: invokeinterface 1479 2 0
    //   960: pop
    //   961: iload_2
    //   962: iconst_1
    //   963: iadd
    //   964: istore_2
    //   965: goto -31 -> 934
    //   968: astore 10
    //   970: aload_0
    //   971: iconst_1
    //   972: putfield 782	com/tencent/mobileqq/activity/TroopInfoActivity:fk	Z
    //   975: aload_0
    //   976: getfield 85	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   979: aload 9
    //   981: putfield 401	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   984: aload_0
    //   985: getfield 124	com/tencent/mobileqq/activity/TroopInfoActivity:handler	Landroid/os/Handler;
    //   988: bipush 6
    //   990: invokevirtual 1490	android/os/Handler:sendEmptyMessage	(I)Z
    //   993: pop
    //   994: goto -870 -> 124
    //   997: aload_0
    //   998: getfield 1964	com/tencent/mobileqq/activity/TroopInfoActivity:bbd	Z
    //   1001: ifeq +20 -> 1021
    //   1004: aload_0
    //   1005: getfield 1966	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Zta	Lzta;
    //   1008: ifnull -884 -> 124
    //   1011: aload_0
    //   1012: getfield 1966	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Zta	Lzta;
    //   1015: invokevirtual 1971	zta:crK	()V
    //   1018: goto -894 -> 124
    //   1021: aload_0
    //   1022: getfield 1973	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Ztd	Lztd;
    //   1025: ifnull -901 -> 124
    //   1028: aload_0
    //   1029: getfield 1973	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Ztd	Lztd;
    //   1032: invokevirtual 1976	ztd:crK	()V
    //   1035: goto -911 -> 124
    //   1038: aload_3
    //   1039: invokeinterface 1980 1 0
    //   1044: invokestatic 1985	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1047: astore_3
    //   1048: goto -893 -> 155
    //   1051: iload_1
    //   1052: sipush 260
    //   1055: if_icmpne -875 -> 180
    //   1058: aload_0
    //   1059: invokespecial 1146	com/tencent/mobileqq/activity/TroopInfoActivity:bKT	()V
    //   1062: return
    //   1063: astore 11
    //   1065: goto -104 -> 961
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1068	0	this	TroopInfoActivity
    //   0	1068	1	paramInt1	int
    //   0	1068	2	paramInt2	int
    //   0	1068	3	paramIntent	Intent
    //   939	6	4	i	int
    //   627	72	5	l1	long
    //   615	82	7	l2	long
    //   196	412	9	localObject1	Object
    //   672	17	9	localException	Exception
    //   911	69	9	localArrayList	ArrayList
    //   375	575	10	localObject2	Object
    //   968	1	10	localJSONException1	org.json.JSONException
    //   420	1	11	localNumberFormatException	NumberFormatException
    //   1063	1	11	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   384	398	420	java/lang/NumberFormatException
    //   617	629	672	java/lang/Exception
    //   921	932	968	org/json/JSONException
    //   934	941	968	org/json/JSONException
    //   947	961	1063	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.bbb = getIntent().getExtras().getBoolean("returnMsgList", false);
      if (!checkParams())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isGameTroop()) {
        bWN();
      }
      this.jdField_d_of_type_Aqdf = new aqdf(this, this.app);
      this.jdField_d_of_type_Aqdf.a(this);
      initUI();
      addObserver(this.jdField_b_of_type_Accd);
      paramBundle = (accc)this.app.getBusinessHandler(22);
      if (paramBundle != null) {
        paramBundle.eC(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.receiver, paramBundle, "com.tencent.tim.msg.permission.pushnotify", null);
      this.bbc = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l));
      }
      jpp.a(this.app, 78);
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      int i = this.bLy;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (paramBundle = "0";; paramBundle = "1")
      {
        anot.a(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(i), paramBundle, "");
        return true;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.bba = true;
    long l = 0L;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    }
    apyh.a(getApplicationContext()).clear();
    removeObserver(this.jdField_a_of_type_Acnd);
    removeObserver(this.c);
    removeObserver(this.jdField_b_of_type_Accd);
    if (this.bbc) {}
    try
    {
      unregisterReceiver(this.receiver);
      this.bbc = false;
      if (this.jdField_a_of_type_Apru != null) {
        this.jdField_a_of_type_Apru.f(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (this.jdField_a_of_type_Ztd != null) {
        this.jdField_a_of_type_Ztd.onDestroy();
      }
      if (this.jdField_a_of_type_Zta != null) {
        this.jdField_a_of_type_Zta.onDestroy();
      }
      if (this.jdField_d_of_type_Aqdf != null) {
        this.jdField_d_of_type_Aqdf.destory();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l));
      }
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.troopinfo", 2, "onDestroy(), unregisterReceiver Exception");
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", new Object[] { Boolean.valueOf(this.bbd), paramIntent, str }));
      }
      if (!this.bbd) {
        break label94;
      }
      if (this.jdField_a_of_type_Zta != null) {
        this.jdField_a_of_type_Zta.ag(str, paramIntent);
      }
    }
    label94:
    while (this.jdField_a_of_type_Ztd == null) {
      return;
    }
    this.jdField_a_of_type_Ztd.ag(str, paramIntent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.aRf)) {
      this.handler.sendEmptyMessage(1);
    }
  }
  
  public void finish()
  {
    CA();
    bWC();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      setResult(-1, getIntent());
    }
    if (this.bbb) {
      bWH();
    }
    super.finish();
    switch (this.bLz)
    {
    default: 
      return;
    case 1: 
      overridePendingTransition(0, 2130771990);
      return;
    }
    overridePendingTransition(0, 2130772028);
  }
  
  public void i(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramString + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.p.length)) {}
    for (View localView1 = this.p[paramInt];; localView1 = null)
    {
      TextView localTextView;
      View localView2;
      if (localView1 != null)
      {
        localTextView = (TextView)localView1.findViewById(2131369154);
        localView2 = localView1.findViewById(2131362978);
        if (paramInt != 6) {
          break label189;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label163;
        }
        localTextView.setVisibility(8);
      }
      for (;;)
      {
        aJ(paramInt, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo));
        if (!paramBoolean) {
          break;
        }
        localView1.setTag(Integer.valueOf(paramInt));
        localView1.setOnClickListener(this);
        localView2.setVisibility(0);
        return;
        label163:
        localTextView.setVisibility(0);
        localTextView.setText(new aofk(paramString, 11, 20));
      }
      label189:
      String str = paramString;
      if (paramInt == 4)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label228;
        }
        str = acfp.m(2131715814);
        aJ(paramInt, true);
      }
      for (;;)
      {
        localTextView.setText(str);
        break;
        label228:
        aJ(paramInt, false);
        str = paramString;
      }
      localView1.setTag(null);
      localView1.setOnClickListener(null);
      localView2.setVisibility(8);
      return;
    }
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.aRf);
    }
    if (this.aRf) {
      return;
    }
    this.aRf = true;
    this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    this.jdField_d_of_type_Acms = ((acms)this.app.getBusinessHandler(20));
    addObserver(this.jdField_a_of_type_Acnd);
    addObserver(this.c);
    addObserver(this.jdField_b_of_type_Accd);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  protected void initUI()
  {
    long l = System.currentTimeMillis();
    View localView = View.inflate(this, 2131561756, null);
    Object localObject1 = (ListView)localView.findViewById(2131364066);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(acfp.m(2131715806));
    ((ArrayList)localObject2).add(acfp.m(2131715805));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.x = ((XListView)localView.findViewById(2131365101));
    this.x.setVerticalScrollBarEnabled(false);
    this.x.setDivider(null);
    this.p = new View[13];
    this.dl = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.dl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.dl.setOrientation(1);
    this.dl.setFocusable(false);
    this.dl.setClickable(false);
    b(this.x);
    localObject1 = new auvv(this.dl);
    this.x.setAdapter((ListAdapter)localObject1);
    this.x.setBackgroundResource(2130838900);
    this.x.setFocusable(false);
    this.x.setClickable(false);
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131721371);
    }
    setTitle((CharSequence)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2131561760, null);
      this.p[7] = localObject1;
      this.dl.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131694807), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
      localObject1 = View.inflate(this, 2131561775, null);
      this.dl.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2131561760, null);
    this.p[11] = localObject1;
    this.dl.addView((View)localObject1);
    bKT();
    ((View)localObject1).setOnClickListener(this);
    localObject1 = View.inflate(this, 2131561760, null);
    this.p[12] = localObject1;
    this.dl.addView((View)localObject1);
    bWx();
    ((View)localObject1).setOnClickListener(this);
    localObject1 = View.inflate(this, 2131561760, null);
    this.p[5] = localObject1;
    this.dl.addView((View)localObject1);
    a(5, 2, (View)localObject1, getString(2131721486), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    bLn();
    localObject1 = View.inflate(this, 2131561760, null);
    this.p[4] = localObject1;
    this.dl.addView((View)localObject1);
    a(4, 2, (View)localObject1, getString(2131721319), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    localObject1 = View.inflate(this, 2131561759, null);
    this.p[8] = localObject1;
    this.dl.addView((View)localObject1);
    a(8, 3, (View)localObject1, getString(2131721321), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
    ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
    localObject1 = View.inflate(this, 2131561775, null);
    this.dl.addView((View)localObject1);
    localObject2 = View.inflate(this, 2131561766, null);
    this.p[6] = localObject2;
    this.dl.addView((View)localObject2);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      a(6, 3, (View)localObject2, getString(2131694965), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
      localObject2 = View.inflate(this, 2131561775, null);
      this.dl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.rV = localView.findViewById(2131363832);
      this.dc = ((Button)localView.findViewById(2131363743));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label857;
      }
      BL(13);
    }
    for (;;)
    {
      this.dc.setOnClickListener(this);
      this.leftView.setOnClickListener(new vzs(this));
      this.rightViewText.setOnClickListener(new vzt(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l));
      }
      return;
      localObject1 = getResources().getString(2131698395);
      break;
      label857:
      BL(14);
    }
  }
  
  public void onBackPressed()
  {
    bWB();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int j;
    if ((localObject1 instanceof Integer)) {
      j = ((Integer)localObject1).intValue();
    }
    Object localObject2;
    switch (j)
    {
    case 3: 
    case 7: 
    case 10: 
    case 13: 
    default: 
    case 4: 
    case 8: 
    case 9: 
    case 5: 
    case 6: 
    case 14: 
    case 2: 
    case 12: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.bLA == 1) {
            QQToast.a(getApplicationContext(), 1, acfp.m(2131715810), 0).show();
          }
          for (;;)
          {
            p(j, paramView);
            break;
            localObject1 = new Intent(getActivity(), TroopClassChoiceActivity.class);
            ((Intent)localObject1).putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
            startActivityForResult((Intent)localObject1, 11);
          }
          bWD();
          p(j, paramView);
          continue;
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", "https://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
          ((Intent)localObject1).putExtra("bid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId);
          startActivityForResult((Intent)localObject1, 17);
          continue;
          bLl();
          p(j, paramView);
          continue;
          localObject1 = new Intent(this, EditInfoActivity.class);
          ((Intent)localObject1).putExtra("edit_type", 1);
          ((Intent)localObject1).putExtra("title", getString(2131694965));
          ((Intent)localObject1).putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
          ((Intent)localObject1).putExtra("max_num", 900);
          ((Intent)localObject1).putExtra("canPostNull", true);
          ((Intent)localObject1).putExtra("support_emotion", true);
          ((Intent)localObject1).putExtra("full_screen", true);
          startActivityForResult((Intent)localObject1, 5);
          report("Grp_moredata", "Clk_brief", "");
          p(j, paramView);
          continue;
          if (!aqiw.isNetSupport(this))
          {
            cf(2131696270, 0);
          }
          else if (this.jdField_d_of_type_Acms != null)
          {
            try
            {
              long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              atg();
              this.jdField_d_of_type_Acms.aA(l, 8390784);
            }
            catch (Exception localException) {}
            if (QLog.isColorLevel())
            {
              QLog.i("Q.troopinfo", 2, localException.toString());
              continue;
              bWF();
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
      localObject2 = paramView.getTag(2131721485);
      if ((localObject2 == null) || (!(localObject2 instanceof Integer))) {
        break;
      }
    }
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      if (i > 0) {
        BM(12);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Apru == null)
        {
          this.jdField_a_of_type_Apru = new apru(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, apug.class, this.jdField_d_of_type_Acms);
          this.jdField_a_of_type_Apru.addObserver(this.jdField_a_of_type_JavaUtilObserver);
        }
        p(j, paramView);
        anot.a(this.app, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
        break;
        if (this.jdField_a_of_type_Ztd == null)
        {
          this.jdField_a_of_type_Ztd = new ztd(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Ztd.a(this);
        }
        this.bbd = false;
        this.jdField_a_of_type_Ztd.crH();
      }
      label678:
      QQAppInterface localQQAppInterface;
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        BM(11);
        p(j, paramView);
        localQQAppInterface = this.app;
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label854;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        anot.a(localQQAppInterface, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, "0", (String)localObject2, "");
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          break label678;
        }
        if (this.jdField_a_of_type_Zta == null)
        {
          this.jdField_a_of_type_Zta = new zta(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Zta.a(this);
        }
        this.bbd = true;
        this.jdField_a_of_type_Zta.crH();
        if (this.jdField_a_of_type_Apru != null) {
          break label678;
        }
        this.jdField_a_of_type_Apru = new apru(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, apug.class, this.jdField_d_of_type_Acms);
        this.jdField_a_of_type_Apru.addObserver(this.jdField_a_of_type_JavaUtilObserver);
        break label678;
        label854:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        bKT();
      }
    }
  }
  
  protected String pa()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131699748);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131699747);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131699734);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131699733);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131699730);
    }
    return "";
  }
  
  protected void report(String paramString1, String paramString2, String paramString3)
  {
    anot.a(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void wL(String paramString)
  {
    QQToast.a(this, paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */