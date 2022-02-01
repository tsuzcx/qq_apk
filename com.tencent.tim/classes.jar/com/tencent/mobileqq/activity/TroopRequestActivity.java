package com.tencent.mobileqq.activity;

import acbn;
import accn;
import acdu;
import acfd;
import acff;
import acfp;
import achq;
import acmc;
import acms;
import acnd;
import acrp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import anot;
import anze;
import aprz;
import apuh;
import aqdf;
import aqdf.a;
import aqep;
import aqeu;
import aqfr;
import aqgv;
import aqmu;
import arhz;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jjh;
import jnm;
import obt;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.MsgPayGroupExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import wcp;
import wcq;
import wcr;
import wcs;
import wct;
import wcu;
import wcv;
import wcw;
import wcx;
import wcy;
import wcz;
import wda;
import wdb;
import wdc;
import wdd;
import wde;
import wdf;
import wdg;
import wdh;
import wdi;
import wdj;
import wdk;
import yxe;
import yxe.a;

public class TroopRequestActivity
  extends IphoneTitleBarActivity
  implements acbn, aqdf.a
{
  protected static long Hv;
  public static long Hw;
  public static final boolean aRi = AppSetting.enableTalkBack;
  public static int bMf = 10;
  public static int bMi;
  public static final int bMj;
  public static final int bMk;
  public static final int bMl;
  public static final int bMm;
  protected TextView BR;
  protected TextView GA;
  protected TextView GB;
  protected TextView GC;
  protected TextView GD;
  protected TextView GE;
  public TextView GF;
  protected TextView GG;
  private TextView GH;
  protected TextView GI;
  protected TextView GJ;
  public TextView GK;
  TextView GL;
  TextView GM;
  protected TextView Gv;
  private TextView Gw;
  private TextView Gx;
  protected TextView Gy;
  public TextView Gz;
  protected long Hu;
  public short J;
  protected achq a;
  public structmsg.StructMsg a;
  public yxe.a a;
  private LinearLayout[] a;
  public String aKI;
  protected String aRA;
  protected String aRB;
  public String aRC;
  public String aRD;
  protected String aRE;
  public String aRF;
  public String aRG = "";
  public String aRH = "";
  protected String aRu;
  protected String aRv;
  protected String aRw;
  protected String aRx;
  private String aRy;
  public String aRz;
  protected URLImageView ae;
  acmc b = new wda(this);
  public int bMg;
  protected int bMh;
  protected int bMn;
  public int bMo = 0;
  public Handler bP = new wcp(this);
  public boolean bbF;
  protected boolean bbG;
  public boolean bbH;
  accn jdField_c_of_type_Accn = new wcs(this);
  acfd jdField_c_of_type_Acfd = new wct(this);
  protected AnimationTextView c;
  public Button cS;
  View.OnClickListener cZ = new wdi(this);
  protected SpannableStringBuilder d;
  protected aqdf d;
  View.OnClickListener dA = new wcw(this);
  View.OnClickListener dB = new wcx(this);
  View.OnClickListener dC = new wcy(this);
  private View.OnClickListener dD = new wde(this);
  public Button dH;
  View.OnClickListener da = new wdh(this);
  View.OnClickListener dy = new wcu(this);
  View.OnClickListener dz = new wcv(this);
  public acms e;
  protected acnd g;
  protected arhz g;
  private RelativeLayout[] g;
  private LinearLayout gG;
  private LinearLayout gH;
  private LinearLayout gI;
  protected LinearLayout gJ;
  public LinearLayout gK;
  public LinearLayout gL;
  protected String mFrom;
  protected TextView mNickNameView;
  public String mPicUrl;
  protected String mTroopName;
  protected String mTroopUin;
  protected String mUserName;
  public String mUserUin;
  protected ImageView rw;
  protected ImageView rx;
  private ImageView ry;
  private View vE;
  protected View vF;
  protected View vG;
  
  static
  {
    int i = bMi;
    bMi = i + 1;
    bMj = i;
    i = bMi;
    bMi = i + 1;
    bMk = i;
    i = bMi;
    bMi = i + 1;
    bMl = i;
    i = bMi;
    bMi = i + 1;
    bMm = i;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[bMi];
    this.jdField_g_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[bMi - 1];
    this.jdField_g_of_type_Acnd = new wcq(this);
    this.jdField_a_of_type_Achq = new wcr(this);
    this.jdField_a_of_type_Yxe$a = new wdd(this);
  }
  
  private boolean QR()
  {
    boolean bool2 = false;
    long l1 = anze.a().hf();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = anze.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() < 0)
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get()).blacklist.set(true);
          this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get(), 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    aprz.a(this.app, paramLong, new wdb(this), localBundle);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, yxe.a parama)
  {
    if ((paramQQAppInterface == null) || (parama == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    yxe.a(paramString, paramStructMsg);
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(paramQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(14);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    jnm.a(paramQQAppInterface, new wdc(paramString, paramContext, parama, paramStructMsg), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
  }
  
  public static String aX(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l);
    if (localTime1.year == localTime2.year) {
      return aqmu.a(paramLong, true, "MM-dd");
    }
    return aqmu.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void bWE()
  {
    startActivityForResult(AddFriendLogicActivity.a(this, this.aKI, this.mTroopName, this.J, 10014, this.aRC, this.aRD, null, null, null), 0);
  }
  
  private boolean cW(int paramInt)
  {
    boolean bool2 = false;
    long l1 = anze.a().hf();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = anze.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (paramInt < localList.size())
        {
          this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void h(Card paramCard)
  {
    if (this.bMg == 82) {}
    do
    {
      do
      {
        return;
        if (paramCard != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateSimpleInfo card is null!");
      return;
    } while ((this.GK == null) || (this.GL == null));
    this.GK.setVisibility(0);
    this.GL.setVisibility(0);
    Object localObject1 = "";
    label152:
    Object localObject2;
    boolean bool1;
    if (paramCard.shGender == 0)
    {
      localObject1 = getString(2131695654);
      this.GK.setText((CharSequence)localObject1);
      if (paramCard.age <= 0) {
        break label579;
      }
      localObject1 = paramCard.age + getString(2131720665);
      this.GL.setText((CharSequence)localObject1);
      this.GL.setContentDescription((CharSequence)localObject1);
      this.GL.setVisibility(0);
      localObject2 = "";
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131717022))) {
          localObject1 = paramCard.strCountry;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramCard.strProvince)) {
        localObject2 = (String)localObject1 + " " + paramCard.strProvince;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCity)) {
        localObject1 = (String)localObject2 + " " + paramCard.strCity;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.GM.setText((CharSequence)localObject1);
        this.GM.setContentDescription((CharSequence)localObject1);
        this.GM.setVisibility(0);
      }
      localObject1 = new SpannableStringBuilder();
      if ((this.bMg != 1) && (this.bMg != 22) && (this.bMg != 60)) {
        break label620;
      }
      localObject2 = getResources();
      if (paramCard.bSuperVipOpen != 1) {
        break label609;
      }
      bool1 = true;
      label370:
      if (paramCard.bQQVipOpen != 1) {
        break label614;
      }
    }
    label579:
    label609:
    label614:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i = paramCard.iQQVipLevel;
      TextView localTextView = (TextView)this.gI.findViewById(2131377179);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i + ",QQLevel=" + paramCard.iQQLevel);
      }
      if ((bool1) || (bool2)) {
        ((SpannableStringBuilder)localObject1).append(aqeu.a(localTextView, (Resources)localObject2, bool1, bool2, Math.max(i, 1)));
      }
      if (paramCard.iQQLevel >= 0) {
        ((SpannableStringBuilder)localObject1).append(aqep.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetAnimationTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.gI.setVisibility(0);
      return;
      if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131693477);
        break;
      }
      this.GK.setVisibility(8);
      break;
      this.GL.setText("");
      this.GL.setContentDescription("");
      this.GL.setVisibility(8);
      break label152;
      bool1 = false;
      break label370;
    }
    label620:
    this.gI.setVisibility(8);
  }
  
  private void init()
  {
    long l = anze.a().hf();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = anze.a().a(Long.valueOf(l));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    int i;
    if (QLog.isColorLevel())
    {
      l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      QLog.d(".troop.qidian_private_troop", 2, "TroopRequestActivity init: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131380323);
    localLinearLayout.setVisibility(8);
    this.jdField_d_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_d_of_type_Aqdf.a(this);
    this.bMg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.aKI = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.aRy = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.aRz = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.aRA = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    label298:
    Object localObject1;
    label600:
    int j;
    if (this.aRA.startsWith(getString(2131720701)))
    {
      this.aRA = this.aRA.replace(getString(2131720701), "");
      setLeftViewName(2131692100);
      setTitle(cw(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      this.vF = findViewById(2131380314);
      this.vG = ((LinearLayout)findViewById(2131380315));
      this.Gy = ((TextView)findViewById(2131380311));
      this.rw = ((ImageView)findViewById(2131380319));
      this.mNickNameView = ((TextView)findViewById(2131380322));
      this.GK = ((TextView)findViewById(2131380320));
      this.GL = ((TextView)findViewById(2131380317));
      this.GM = ((TextView)findViewById(2131380318));
      this.Gz = ((TextView)findViewById(2131380308));
      this.ae = ((URLImageView)findViewById(2131380316));
      this.Gw = ((TextView)findViewById(2131380313));
      this.Gx = ((TextView)findViewById(2131380310));
      this.dH = ((Button)findViewById(2131362353));
      this.cS = ((Button)findViewById(2131377045));
      this.gL = ((LinearLayout)findViewById(2131380312));
      this.GA = ((TextView)findViewById(2131380309));
      this.GA.setOnClickListener(this.dC);
      this.rx = ((ImageView)findViewById(2131380306));
      localObject1 = jjh.e(BaseApplication.getContext(), 2130839512);
      if (localObject1 == null) {
        break label853;
      }
      this.rx.setImageDrawable((Drawable)localObject1);
      this.gG = ((LinearLayout)findViewById(2131380307));
      this.gH = ((LinearLayout)findViewById(2131377172));
      this.gI = ((LinearLayout)findViewById(2131377178));
      this.gJ = ((LinearLayout)findViewById(2131377170));
      this.gK = ((LinearLayout)findViewById(2131377175));
      localObject1 = (TextView)this.gK.findViewById(2131377177);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(obt.a(this.app, getApplicationContext()));
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[bMj] = this.gH;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[bMk] = this.gI;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[bMl] = this.gJ;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[bMm] = this.gK;
      int k = this.gG.getChildCount();
      j = 0;
      i = 0;
      label766:
      if (j >= k) {
        break label866;
      }
      if (!(this.gG.getChildAt(j) instanceof RelativeLayout)) {
        break label2271;
      }
      this.jdField_g_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)this.gG.getChildAt(j));
      i += 1;
    }
    label853:
    label2261:
    label2266:
    label2271:
    for (;;)
    {
      j += 1;
      break label766;
      if (!this.aRA.startsWith(getString(2131720684))) {
        break label298;
      }
      this.aRA = this.aRA.replace(getString(2131720684), "");
      break label298;
      this.rx.setImageResource(2130839512);
      break label600;
      label866:
      this.GB = ((TextView)findViewById(2131377174));
      this.GC = ((TextView)findViewById(2131377173));
      this.GF = ((TextView)findViewById(2131377176));
      this.jdField_c_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131377179));
      this.GD = ((TextView)findViewById(2131377171));
      this.GE = ((TextView)findViewById(2131373780));
      this.GG = ((TextView)findViewById(2131365762));
      this.aRB = getIntent().getExtras().getString("troopMsgDealInfo");
      this.vE = findViewById(2131382120);
      this.GH = ((TextView)findViewById(2131382121));
      this.ry = ((ImageView)findViewById(2131364705));
      initData();
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() >= 2)) {
        if (this.bMg == 82)
        {
          this.rightViewText.setVisibility(0);
          this.rightViewText.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.rightViewText.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.rightViewText.setEnabled(true);
          this.dH.setVisibility(0);
          this.dH.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).detail_name.get());
          localObject2 = (LinearLayout.LayoutParams)this.dH.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
          this.dH.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.dH.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(1)).detail_name.get());
          localLinearLayout.setVisibility(0);
          if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.aRy)) || (TextUtils.equals(String.valueOf(90000000L), this.aRz)))) {
            this.Gz.setVisibility(8);
          }
          this.Gv = ((TextView)findViewById(2131380305));
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
            break label2188;
          }
          this.cS.setTextAppearance(this, 2131755278);
          this.cS.setBackgroundResource(2130839541);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.bMg != 1) && (this.bMg != 22))) {
            break label2176;
          }
          this.Gv.setVisibility(0);
          this.Gv.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          this.Gv.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          if ((localObject1 != null) && (((List)localObject1).size() == 1)) {
            this.Gz.setOnClickListener(this.dB);
          }
          this.dH.setOnClickListener(this.dB);
          this.cS.setOnClickListener(this.dB);
          this.rightViewText.setOnClickListener(this.dB);
          this.GJ = ((TextView)findViewById(2131361951));
          this.GI = ((TextView)findViewById(2131361950));
          this.BR = ((TextView)findViewById(2131378251));
          this.GJ.setOnClickListener(this.cZ);
          this.BR.setOnClickListener(this.da);
          super.getString(2131720221);
          super.getString(2131689651);
          this.GJ.setVisibility(8);
          this.GI.setVisibility(8);
          this.BR.setVisibility(8);
          this.aRG = "";
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
            break label2266;
          }
          if ((this.bMg != 1) && (this.bMg != 22)) {
            break label2221;
          }
          this.aRG = this.aRz;
          this.aRH = "1";
          this.bMn = 2131719660;
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.GJ.setVisibility(0);
          this.GI.setVisibility(0);
          this.BR.setVisibility(0);
        }
        if (((this.bMg != 1) && (this.bMg != 22) && (this.bMg != 60)) || (!QLog.isColorLevel())) {
          break;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.has()))
        {
          i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
          label1772:
          if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.has())) {
            break label2261;
          }
        }
        for (j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();; j = -1)
        {
          QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.bMg) }));
          return;
          i = 0;
          if (i < ((List)localObject1).size())
          {
            localObject2 = ((structmsg.SystemMsgAction)((List)localObject1).get(i)).detail_name.get();
            if (i != 0) {
              break label1932;
            }
            this.cS.setVisibility(0);
            this.cS.setText((CharSequence)localObject2);
            this.cS.setContentDescription((CharSequence)localObject2);
          }
          for (;;)
          {
            localLinearLayout.setVisibility(0);
            i += 1;
            break label1859;
            break;
            if (i == 1)
            {
              this.dH.setVisibility(0);
              this.dH.setText((CharSequence)localObject2);
              this.dH.setContentDescription((CharSequence)localObject2);
            }
            else if (i == 2)
            {
              this.rightViewText.setVisibility(0);
              this.rightViewText.setText((CharSequence)localObject2);
              this.rightViewText.setContentDescription((CharSequence)localObject2);
              this.rightViewText.setEnabled(true);
            }
          }
          if ((localObject1 != null) && (((List)localObject1).size() == 1))
          {
            this.Gz.setVisibility(0);
            this.Gz.setTextAppearance(this, 2131755275);
            this.Gz.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
            this.Gz.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
            this.Gz.setBackgroundResource(2130839524);
            this.Gz.setVisibility(0);
            break;
          }
          if ((this.Gz == null) || (TextUtils.isEmpty(this.aRB))) {
            break;
          }
          this.Gz.setTextAppearance(getApplicationContext(), 2131756684);
          this.Gz.setText(this.aRB);
          this.Gz.setContentDescription(this.aRB);
          this.Gz.setVisibility(0);
          break;
          this.Gv.setVisibility(8);
          break label1438;
          this.dH.setTextAppearance(this, 2131755275);
          this.dH.setBackgroundResource(2130839524);
          this.Gv.setVisibility(8);
          break label1438;
          if (this.bMg != 2) {
            break label2266;
          }
          this.aRG = this.aRy;
          this.aRH = "0";
          this.bMn = 2131721388;
          i = 1;
          break label1669;
          i = -1;
          break label1772;
        }
        i = 0;
      }
    }
  }
  
  public SpannableStringBuilder a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    String str;
    if (paramBoolean2)
    {
      i = paramString1.indexOf(paramString3);
      if (i > 0)
      {
        str = paramString1.substring(paramString3.length() + i, paramString1.length());
        paramString1 = paramString1.substring(0, i + paramString3.length());
      }
    }
    for (;;)
    {
      Matcher localMatcher = Pattern.compile(paramString3).matcher(paramString1);
      if (!localMatcher.find()) {
        return null;
      }
      paramBoolean2 = paramString3.equals(getString(2131720693));
      paramString3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString3);
      i = (int)(paramString3.density * 17.0F);
      paramString3 = new StringBuilder(paramString1);
      paramString3.insert(localMatcher.end(), " " + paramString2);
      paramString3 = new SpannableStringBuilder(paramString3.toString());
      int j = localMatcher.end() + " ".length();
      boolean bool = paramString1.contains(acfp.m(2131716098));
      if (paramBoolean1)
      {
        paramString1 = new NumberSpan(bool, paramString2, paramString4, paramBoolean2);
        if (paramString2.length() + j > paramString3.length())
        {
          i = paramString3.length();
          paramString3.setSpan(paramString1, j, i, 33);
        }
      }
      else
      {
        if (localMatcher.end() <= paramString3.length()) {
          break label292;
        }
      }
      label292:
      for (i = paramString3.length();; i = localMatcher.end())
      {
        paramString3.delete(localMatcher.start(), i);
        paramString3.append(str);
        return paramString3;
        i = paramString2.length() + j;
        break;
      }
      str = "";
    }
  }
  
  public SpannableStringBuilder a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return null;
    }
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
    {
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      if ((i == 16) || (i == 3)) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      String str;
      if (paramString.contains(getString(2131720701)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720701), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131720684)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720684), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131720685)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720685), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131720693)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720693), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
      }
      return new SpannableStringBuilder(paramString);
    }
  }
  
  public void aL(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).show(getTitleBarHeight());
    finish();
  }
  
  public void atg()
  {
    try
    {
      if (this.jdField_g_of_type_Arhz == null)
      {
        this.jdField_g_of_type_Arhz = new arhz(getActivity(), getTitleBarHeight());
        this.jdField_g_of_type_Arhz.setMessage(2131696693);
        this.jdField_g_of_type_Arhz.setBackAndSearchFilter(false);
      }
      this.jdField_g_of_type_Arhz.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
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
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  public void bFN()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(getString(2131691293), 3);
    localausj.a(new wdk(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public void bFO()
  {
    ausj localausj = (ausj)auss.a(this, null);
    String str = "";
    if (this.bMn != 0) {
      str = getString(this.bMn);
    }
    localausj.setMainTitle(str);
    localausj.addButton(getString(2131720220), 3);
    localausj.a(new wdj(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public void bXp()
  {
    label125:
    Object localObject1;
    if ((this.bMg == 10) || (this.bMg == 12) || (this.bMg == 2))
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.has())
      {
        this.mUserUin = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
        this.aRz = this.mUserUin;
      }
      if ((this.bMg != 12) && (this.bMg != 35) && (this.bMg != 10) && (this.bMg != 2)) {
        break label749;
      }
      this.mUserName = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      if ((this.bMg == 2) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      }
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        label212:
        this.mUserName = ((String)localObject1);
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8()))) {
          this.mPicUrl = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 83)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
          {
            this.Gw.setVisibility(0);
            this.jdField_d_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
          }
          this.Gy.setVisibility(8);
          label353:
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.has()) {
            this.aRx = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.has()) {
            this.Hu = Long.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get()).longValue();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.has()) {
            this.mTroopUin = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.has()) {
            this.mTroopName = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
          }
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) && (this.bMg != 10)) {
            this.mFrom = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.has()) {
            this.bMh = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.has())
          {
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
            if ((!((String)localObject1).contains("%action_uin%")) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.has())) {
              break label1045;
            }
            this.aRu = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get() != null) {
        this.aRE = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("decodeData reqUin: %s, warningTips: %s", new Object[] { this.mUserUin, this.aRE }));
      }
      return;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.has()) {
        break;
      }
      this.mUserUin = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      break;
      label749:
      this.mUserName = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
      break label125;
      localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      break label212;
      TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
      if (localTroopManager == null) {
        break label212;
      }
      String str1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
      String str2 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      localObject1 = localTroopManager.jr(str1);
      Object localObject2 = aqgv.a(this.app, str2, str1, (String)localObject1, true, null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label212;
      }
      localObject1 = localTroopManager.getTroopMemberName(str1, str2);
      break label212;
      localObject2 = (acdu)this.app.getManager(53);
      if (localObject2 == null) {
        break label212;
      }
      localObject2 = ((acdu)localObject2).a(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
      if (localObject2 == null) {
        break label212;
      }
      localObject1 = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
      break label212;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.has()) {
        break label353;
      }
      this.Gw.setVisibility(0);
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (hv((String)localObject1))
      {
        this.jdField_d_of_type_AndroidTextSpannableStringBuilder = a((String)localObject1, true, true);
        this.Gw.setMovementMethod(LinkMovementMethod.getInstance());
        break label353;
      }
      this.jdField_d_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      break label353;
      label1045:
      if ((((String)localObject1).contains("%actor_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.has()))
      {
        this.aRu = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        this.aRy = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get());
      }
      else if ((((String)localObject1).contains("%req_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has()))
      {
        this.aRu = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      }
    }
  }
  
  public void bXq()
  {
    Object localObject = yxe.a(this.jdField_d_of_type_Aqdf, this.mUserUin, 1);
    this.rw.setBackgroundDrawable((Drawable)localObject);
    if ((this.bMg == 10) || (this.bMg == 12)) {
      this.aRw = (this.mUserName + getString(2131698748));
    }
    for (;;)
    {
      localObject = this.dz;
      this.vF.setOnClickListener((View.OnClickListener)localObject);
      if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2))
      {
        this.vF.setOnClickListener(null);
        ((ImageView)findViewById(2131380306)).setVisibility(4);
      }
      this.rw.setContentDescription(this.aRw);
      if (!TextUtils.isEmpty(this.mUserName)) {
        this.mNickNameView.setText(this.mUserName);
      }
      try
      {
        if (this.app != null)
        {
          localObject = (acff)this.app.getManager(51);
          if (localObject != null) {
            ThreadManager.post(new TroopRequestActivity.1(this, (acff)localObject), 8, null, true);
          }
        }
        if (!TextUtils.isEmpty(this.mPicUrl)) {
          this.ae.setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        try
        {
          do
          {
            for (;;)
            {
              localObject = URLDrawable.getDrawable(this.mPicUrl);
              this.ae.setImageDrawable((Drawable)localObject);
              this.ae.setOnClickListener(new wcz(this));
              this.ae.setContentDescription(acfp.m(2131716095));
              if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextSpannableStringBuilder)) {
                break label693;
              }
              this.Gw.setText(this.jdField_d_of_type_AndroidTextSpannableStringBuilder);
              if (this.bMg == 80)
              {
                this.Gw.setMaxLines(3);
                this.Gw.setSingleLine(false);
              }
              if (!TextUtils.isEmpty(this.aRx)) {
                break label705;
              }
              this.Gx.setVisibility(8);
              if (this.Hu != 0L)
              {
                localObject = aX(this.Hu * 1000L);
                this.Gy.setText((CharSequence)localObject);
              }
              if (TextUtils.isEmpty(this.aRu)) {
                break label727;
              }
              localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get().split("：");
              if (localObject.length > 0)
              {
                this.GB.setText(localObject[0]);
                this.GB.setContentDescription(localObject[0] + this.aRu);
                this.GB.setFocusable(true);
              }
              this.GC.setText(this.aRu);
              this.GC.setOnClickListener(this.dA);
              this.gH.setVisibility(0);
              if ((this.bMg != 1) && (this.bMg != 22) && (this.bMg != 60)) {
                break label739;
              }
              this.gI.setVisibility(0);
              if ((TextUtils.isEmpty(this.mFrom)) || (this.bMg == 2)) {
                break label751;
              }
              this.gJ.setVisibility(0);
              this.GD.setText(this.mFrom);
              if (TextUtils.isEmpty(this.aRE)) {
                break label763;
              }
              this.GH.setText(this.aRE);
              this.vE.setVisibility(0);
              this.ry.setOnClickListener(this.dD);
              return;
              this.aRw = (this.mUserName + getString(2131698749));
              break;
              this.mNickNameView.setText(this.mUserUin);
            }
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, localIllegalArgumentException.toString());
            }
            this.ae.setVisibility(8);
            continue;
            label693:
            this.Gw.setText("");
            continue;
            label705:
            this.Gx.setText(this.aRx);
            this.Gx.setVisibility(0);
            continue;
            label727:
            this.gH.setVisibility(8);
            continue;
            label739:
            this.gI.setVisibility(8);
            continue;
            label751:
            this.gJ.setVisibility(8);
          }
          label763:
          this.vE.setVisibility(8);
        }
      }
    }
  }
  
  public void bXr()
  {
    Object localObject = yxe.a(this.jdField_d_of_type_Aqdf, this.mTroopUin, 4);
    this.rw.setBackgroundDrawable((Drawable)localObject);
    this.aRw = (this.mTroopName + getString(2131698750));
    if (this.bMg == 8)
    {
      this.vF.setEnabled(false);
      this.rx.setVisibility(8);
      this.rw.setContentDescription(this.aRw);
      if (!TextUtils.isEmpty(this.mTroopName)) {
        break label865;
      }
      this.mNickNameView.setText(this.aKI);
      label112:
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null) {
        break label1206;
      }
    }
    label177:
    label1206:
    for (localObject = ((TroopManager)localObject).b(String.valueOf(this.aKI));; localObject = null)
    {
      if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
      {
        ThreadManager.post(new TroopRequestActivity.3(this, (TroopInfo)localObject), 8, null, true);
        if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextSpannableStringBuilder)) {
          break label900;
        }
        this.Gw.setText(this.jdField_d_of_type_AndroidTextSpannableStringBuilder);
        label198:
        if (this.bMg == 80)
        {
          this.Gw.setMaxLines(3);
          this.Gw.setSingleLine(false);
        }
        if (!TextUtils.isEmpty(this.aRx)) {
          break label912;
        }
        this.Gx.setVisibility(8);
        label242:
        if (this.Hu != 0L)
        {
          localObject = aX(this.Hu * 1000L);
          this.Gy.setText((CharSequence)localObject);
        }
        if (TextUtils.isEmpty(this.aRu)) {
          break label963;
        }
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
        String[] arrayOfString = ((String)localObject).split("：");
        if (arrayOfString.length > 0)
        {
          this.GB.setText(arrayOfString[0]);
          this.GB.setContentDescription(arrayOfString[0] + this.aRu);
          this.GB.setFocusable(true);
        }
        this.GC.setText(this.aRu);
        if (!((String)localObject).contains(getString(2131720684))) {
          break label934;
        }
        this.GC.setOnClickListener(this.dA);
        this.gH.setVisibility(0);
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
        {
          int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
          if ((i == 7) || (i == 11) || (i == 3) || (i == 16) || (i == 15)) {
            this.GC.setOnClickListener(null);
          }
        }
        label480:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 82) {
          break label1040;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.size() == 0) || (TextUtils.isEmpty(this.aRB))) {
          break label975;
        }
        this.GE.setVisibility(0);
        this.GE.setText(this.aRB);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label987;
        }
        this.GF.setText((CharSequence)localObject);
        this.gK.setVisibility(0);
        label583:
        this.GF.setOnClickListener(new wdg(this));
        anot.a(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
          break label1061;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.has())
        {
          localObject = (structmsg.MsgPayGroupExt)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.get();
          long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
          long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
          localObject = acfp.m(2131716097) + aqmu.a(this, l1 * 1000L, true) + "\n" + acfp.m(2131716096) + aqmu.a(this, l2 * 1000L, true);
          this.GG.setVisibility(0);
          this.GG.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        bXs();
        if (TextUtils.isEmpty(this.aRE)) {
          break label1196;
        }
        this.GH.setText(this.aRE);
        this.vE.setVisibility(0);
        this.ry.setOnClickListener(this.dD);
        return;
        this.vF.setOnClickListener(this.dy);
        break;
        label865:
        this.mNickNameView.setText(this.mTroopName);
        break label112;
        if (this.e == null) {
          break label177;
        }
        this.e.EU(this.aKI);
        break label177;
        this.Gw.setText("");
        break label198;
        this.Gx.setText(this.aRx);
        this.Gx.setVisibility(0);
        break label242;
        if (!((String)localObject).contains(getString(2131720701))) {
          break label401;
        }
        this.GC.setOnClickListener(this.dz);
        break label401;
        label963:
        this.gH.setVisibility(8);
        break label480;
        label975:
        this.GE.setVisibility(8);
        break label543;
        label987:
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.gK.setVisibility(8);
        aprz.c(this.app, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new wdf(this));
        break label583;
        this.gK.setVisibility(8);
        this.GE.setVisibility(8);
        break label655;
        if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.aRy)) || (TextUtils.equals(String.valueOf(90000000L), this.aRz))))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
          {
            this.GG.setVisibility(0);
            this.GG.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
          }
          this.GC.setTextColor(-16777216);
          this.GC.setOnClickListener(null);
        }
      }
      this.vE.setVisibility(8);
      return;
    }
  }
  
  public void bXs()
  {
    int i = 0;
    int j = 0;
    if (i < bMi)
    {
      int k = j;
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i] != null)
      {
        k = j;
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i].getVisibility() != 8)
        {
          this.gG.setVisibility(0);
          k = 1;
        }
      }
      if (i > 0)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[(i - 1)].getVisibility() != 8) {
          break label90;
        }
        this.jdField_g_of_type_ArrayOfAndroidWidgetRelativeLayout[(i - 1)].setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        label90:
        this.jdField_g_of_type_ArrayOfAndroidWidgetRelativeLayout[(i - 1)].setVisibility(0);
      }
    }
    if (j != 0)
    {
      this.gG.setVisibility(0);
      return;
    }
    this.gG.setVisibility(8);
  }
  
  public String cw(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = getString(2131698519);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), str }));
      }
      return str;
      str = getString(2131698524);
      continue;
      str = getString(2131698523);
      continue;
      str = getString(2131698526);
      continue;
      str = getString(2131698521);
      continue;
      str = getString(2131698522);
      continue;
      str = getString(2131698530);
      continue;
      str = getString(2131698518);
      continue;
      str = getString(2131698527);
      continue;
      str = getString(2131698528);
      continue;
      str = getString(2131698529);
      continue;
      str = getString(2131698507);
      continue;
      str = getString(2131698525);
      continue;
      str = getString(2131698531);
      continue;
      str = getString(2131698520);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0) {
        break label21;
      }
      ath();
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label21:
      if (paramInt1 != 1005) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560857);
    setContentBackgroundResource(2130838900);
    this.e = ((acms)this.app.getBusinessHandler(20));
    init();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.dH.setVisibility(8);
      this.cS.setVisibility(8);
    }
    this.bbG = getIntent().getBooleanExtra("troop_invitee_is_friend", false);
    this.bbH = getIntent().getBooleanExtra("troop_suspicious_request", false);
    if ((this.gL != null) && (this.bbG)) {
      this.gL.setVisibility(0);
    }
    for (;;)
    {
      this.bMo = getIntent().getIntExtra("troopfromtab", 0);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "isShowStrangerTips == " + this.bbG);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.bP != null) {
      this.bP.removeCallbacksAndMessages(null);
    }
    if (this.bMg == 82) {
      this.app.removeObserver(this.jdField_a_of_type_Achq);
    }
    if (this.jdField_d_of_type_Aqdf != null) {
      this.jdField_d_of_type_Aqdf.a(null);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    this.app.addObserver(this.jdField_g_of_type_Acnd);
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_c_of_type_Accn);
    this.app.addObserver(this.jdField_c_of_type_Acfd);
    this.app.addObserver(this.b);
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    this.app.removeObserver(this.jdField_g_of_type_Acnd);
    this.app.removeObserver(this.jdField_c_of_type_Accn);
    this.app.removeObserver(this.jdField_c_of_type_Acfd);
    this.app.removeObserver(this.b);
    if (this.bMg != 82) {
      this.app.removeObserver(this.jdField_a_of_type_Achq);
    }
    super.doOnStop();
  }
  
  boolean hv(String paramString)
  {
    return (paramString.contains(getString(2131720701))) || (paramString.contains(getString(2131720685))) || (paramString.contains(getString(2131720693))) || (paramString.contains(getString(2131720684)));
  }
  
  public void initData()
  {
    bXp();
    switch (this.bMg)
    {
    }
    for (;;)
    {
      bXs();
      return;
      bXq();
      continue;
      bXr();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.Gw.setVisibility(0);
      if (hv(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.Gw.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.Gw.setText(paramString);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label136;
      }
    }
    for (;;)
    {
      if (this.bMg == 11) {}
      return;
      this.Gw.setText("");
      break;
      label136:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        new StringBuilder().append(getResources().getString(2131720694)).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()).toString();
      }
    }
  }
  
  public void setButtonEnabled(boolean paramBoolean)
  {
    if (this.dH != null) {
      this.dH.setEnabled(paramBoolean);
    }
    if (this.cS != null) {
      this.cS.setEnabled(paramBoolean);
    }
  }
  
  class NumberSpan
    extends URLSpan
  {
    boolean aCH;
    boolean bbI;
    String uin;
    
    public NumberSpan(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
    {
      super();
      this.uin = paramString2;
      this.aCH = paramBoolean2;
      this.bbI = paramBoolean1;
    }
    
    public void onClick(View paramView)
    {
      long l = System.currentTimeMillis();
      if ((l - TroopRequestActivity.Hv > 0L) && (l - TroopRequestActivity.Hv < 800L)) {
        return;
      }
      TroopRequestActivity.Hv = l;
      getURL();
      int i = TroopRequestActivity.this.a.msg.group_msg_type.get();
      Object localObject;
      if (this.aCH)
      {
        localObject = TroopInfoActivity.c(TroopRequestActivity.this.aKI, 4);
        ((Bundle)localObject).putInt("t_s_f", 1001);
        QQAppInterface localQQAppInterface;
        String str;
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          localQQAppInterface = TroopRequestActivity.this.app;
          str = TroopRequestActivity.this.a.msg.group_code.get() + "";
          if (i == 0) {
            break label194;
          }
        }
        label194:
        for (paramView = "0";; paramView = "1")
        {
          anot.a(localQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, paramView, "", "");
          apuh.a(TroopRequestActivity.this, (Bundle)localObject, 2);
          return;
          i = 0;
          break;
        }
      }
      if (((acff)TroopRequestActivity.this.app.getManager(51)).isFriend(this.uin))
      {
        localObject = new ProfileActivity.AllInOne(this.uin, 1);
        paramView = "";
        if (this.bbI)
        {
          if (i != 11) {
            break label479;
          }
          paramView = "0";
        }
      }
      for (;;)
      {
        anot.a(TroopRequestActivity.this.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, TroopRequestActivity.this.a.msg.group_code.get() + "", paramView, "", "");
        aqfr.b("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { TroopRequestActivity.this.a.msg.group_code.get() + "", paramView });
        ProfileActivity.b(TroopRequestActivity.this, (ProfileActivity.AllInOne)localObject);
        return;
        if ((TroopRequestActivity.this.a.msg.group_msg_type.get() == 2) && (TroopRequestActivity.this.a.msg.sub_type.get() == 3))
        {
          localObject = new ProfileActivity.AllInOne(this.uin, 26);
          ((ProfileActivity.AllInOne)localObject).bIW = 1;
          break;
        }
        localObject = new ProfileActivity.AllInOne(this.uin, 24);
        apuh.a(TroopRequestActivity.this.a, (ProfileActivity.AllInOne)localObject);
        break;
        label479:
        if ((i == 3) || (i == 15) || (i == 16)) {
          paramView = "1";
        } else if ((i == 6) || (i == 7)) {
          paramView = "2";
        } else {
          paramView = "3";
        }
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(-14697741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */