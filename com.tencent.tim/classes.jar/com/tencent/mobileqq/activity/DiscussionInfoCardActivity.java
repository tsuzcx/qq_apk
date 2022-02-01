package com.tencent.mobileqq.activity;

import accc;
import accd;
import accn;
import acdb.a;
import acdt;
import acdu;
import acdv;
import acfd;
import acff;
import acfp;
import ahau;
import alkw;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import apuh;
import apzg;
import aqcx;
import aqdf;
import aqdf.a;
import aqfr;
import aqgv;
import aqgz;
import aqhu;
import aqiw;
import aqjl;
import aqqj;
import arfj;
import arhz;
import ausj;
import auss;
import auvv;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import rpq;
import rwt;
import uuk;
import uul;
import uum;
import uup;
import uuq;
import uur;
import uus;
import uut;
import uuu;
import uuv;
import uuw;
import uux;
import uuy;
import uuz;
import wja;

public class DiscussionInfoCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, aqdf.a
{
  public arhz A;
  private FormSimpleItem A;
  private FormSimpleItem B;
  private FormSimpleItem jdField_C_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_C_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private TextView CX;
  private arhz jdField_D_of_type_Arhz;
  private FormSimpleItem jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private long FU;
  public Dialog L;
  public String Qt;
  accd jdField_a_of_type_Accd = new uut(this);
  accn jdField_a_of_type_Accn = new uup(this);
  private acdu jdField_a_of_type_Acdu;
  acdv jdField_a_of_type_Acdv = new uum(this);
  acfd jdField_a_of_type_Acfd = new uul(this);
  private a jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$a;
  public DiscussionInfo a;
  public FollowImageTextView a;
  protected WXShareHelper.a a;
  private String aCr;
  public String aCs;
  public String aCt;
  public boolean aVB;
  private acdt jdField_b_of_type_Acdt;
  protected ShareActionSheetBuilder b;
  private MyGridView jdField_b_of_type_ComTencentMobileqqWidgetMyGridView;
  private final int bFA = 3;
  private int bFF;
  private int bFG;
  private int bFH;
  private int bFI;
  private int bFJ = 4;
  private final int bFy = 1;
  private final int bFz = 2;
  protected final int bGA = 11;
  protected final int bGB = 0;
  protected final int bGC = 1;
  protected final int bGD = 2;
  protected int bGE;
  private final int bGw = 0;
  private final int bGx = 8;
  private final int bGy = 9;
  protected final int bGz = 10;
  private boolean bO;
  private int cZ;
  private String curUin;
  aqdf d;
  private Intent intent;
  public String mOwnerName;
  public long mValidTime;
  private ImageView pP;
  public MqqHandler q = new uuz(this);
  private List<DiscussionMemberInfo> qA;
  private View sn;
  public View so;
  private FormSimpleItem z;
  
  @SuppressLint({"NewApi"})
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800666F", "0X800666F", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      paramString2 = acfp.m(2131705146) + paramString2 + "】:\n" + paramString1;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString2);
      }
      for (;;)
      {
        QQToast.a(paramQQAppInterface, 2, acfp.m(2131705133), 0).show(paramQQAppInterface.getResources().getDimensionPixelSize(2131299627));
        return;
        paramString1 = (android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard");
        paramString2 = ClipData.newPlainText("discussion_url", paramString2);
        alkw.a(paramString1, paramString2);
        paramString1.setPrimaryClip(paramString2);
      }
    }
    QQToast.a(paramQQAppInterface, 2, acfp.m(2131705154), 0).show(paramQQAppInterface.getResources().getDimensionPixelSize(2131299627));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, arhz paramarhz)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramarhz != null)) {}
    try
    {
      paramarhz.show();
      anot.a(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800666B", "0X800666B", 0, 0, "", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        ThreadManager.post(new DiscussionInfoCardActivity.17(paramLong, paramQQAppInterface, paramString2, str, paramString3, paramString1, paramActivity, paramInt, paramarhz), 5, null, true);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiscussionInfoCardActivity", 2, localException.toString());
        }
      }
      if ((paramarhz != null) && (paramarhz.isShowing())) {
        paramarhz.dismiss();
      }
      QQToast.a(paramActivity, -1, acfp.m(2131705140), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
    ThreadManager.post(new DiscussionInfoCardActivity.18(paramString2, paramActivity, paramString1, String.format(paramActivity.getString(2131692846), new Object[] { paramString3 }), paramQQAppInterface), 5, null, false);
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int j = getResources().getDisplayMetrics().widthPixels;
    int k = (int)(this.mDensity * 20.0F);
    int i = (int)(this.mDensity * 20.0F);
    int m = (int)(66.0F * this.mDensity);
    int n = (int)(50.0F * this.mDensity);
    i = (j - k) / (i + n);
    j = (j - k - i * m - (m - n)) / (i + 1) + (m - n) / 2;
    k = (int)(this.mDensity * 20.0F);
    this.bFF = j;
    this.bFG = j;
    this.bFH = k;
    this.bFI = k;
    this.bFJ = i;
    paramMyGridView.setPadding(this.bFF, this.bFH, this.bFG, this.bFI);
    if (this.sn != null) {
      this.sn.setBackgroundResource(2130839689);
    }
  }
  
  private void bKG()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void bKv()
  {
    anot.a(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_chatRecord", 1, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.curUin);
    localIntent.putExtra("uintype", this.cZ);
    startActivityForResult(localIntent, 1000);
  }
  
  private void bKw()
  {
    anot.a(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("chatbg_intent_frinedUin", this.curUin);
    localIntent.putExtra("uintype", this.cZ);
    localIntent.putExtra("bg_replace_entrance", 62);
    VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.o(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void bKx()
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.curUin);
    localIntent.putExtra("uinname", this.aCr);
    localIntent.putExtra("uintype", this.cZ);
    localIntent.putExtra("isNeedUpdate", this.bO);
    startActivity(localIntent);
  }
  
  private void bNb()
  {
    Object localObject2 = (XListView)View.inflate(this, 2131559464, null);
    try
    {
      ((XListView)localObject2).setBackgroundResource(2130838900);
      ((XListView)localObject2).setDivider(null);
      ((XListView)localObject2).setVerticalScrollBarEnabled(false);
      ((XListView)localObject2).setPadding(0, 0, 0, 0);
      View localView = View.inflate(this, 2131558932, null);
      ((XListView)localObject2).setAdapter(new auvv(localView));
      setContentView((View)localObject2);
      this.jdField_C_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131380009));
      this.sn = localView.findViewById(2131365961);
      this.CX = ((TextView)localView.findViewById(2131371230));
      this.CX.setCompoundDrawables(null, null, null, null);
      this.sn.setClickable(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131371228));
      this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
      this.d = new aqdf(this, this.app);
      this.d.a(this);
      this.pP = ((ImageView)localView.findViewById(2131380383));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView = ((FollowImageTextView)localView.findViewById(2131380362));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextColor(getResources().getColor(2131167307));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setTextSize(1, 23.0F);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxLines(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setMaxWidth((int)aqgz.hK() - rpq.dip2px(this, 88.5F));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageResource(2130844667);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setFollowImageWH(rpq.dip2px(this, 14.0F), rpq.dip2px(this, 15.0F));
      this.jdField_A_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131364458));
      this.B = ((FormSimpleItem)localView.findViewById(2131376837));
      this.jdField_C_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131378080));
      this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131365967));
      this.z = ((FormSimpleItem)localView.findViewById(2131371111));
      this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131365969));
      bNn();
      a(this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView);
      this.jdField_A_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.B.setOnClickListener(this);
      this.jdField_C_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnClickListener(new uuk(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setOnTouchListener(new uuu(this));
      this.pP.setOnClickListener(this);
      this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new uuv(this));
      this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      setTitle(2131691439);
      setLeftViewName(2131690700);
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(this);
      this.rightViewImg.setBackgroundResource(2130840667);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
      {
        aL(1, getString(2131692870));
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView mDiscussionInfo is null,try to get getDiscuss");
        }
        this.jdField_b_of_type_Acdt.hp(this.app.getLongAccountUin());
        finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("DiscussionInfoCardActivity", 1, localThrowable.toString());
      }
      localObject2 = (acff)this.app.getManager(51);
      if ((TextUtils.isEmpty(this.mOwnerName)) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null) && (!((acff)localObject2).isFriend(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
        ((FriendListHandler)this.app.getBusinessHandler(1)).bC(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "", false);
      }
      h(this.aCr);
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "DiscussionInfo.DiscussionFlag:" + this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.DiscussionFlag);
      }
      bNo();
      this.jdField_b_of_type_Acdt = ((acdt)this.app.getBusinessHandler(6));
      boolean bool = this.jdField_b_of_type_Acdt.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      this.jdField_C_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_C_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new uuw(this));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (this.app != null) && (this.app.getCurrentAccountUin() != null)) {
        if ((hg(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)))
        {
          this.z.setOnClickListener(this);
          this.z.setVisibility(0);
        }
      }
      Object localObject1;
      for (;;)
      {
        if (AppSetting.enableTalkBack)
        {
          this.rightViewImg.setContentDescription(getString(2131699738));
          this.z.setContentDescription(acfp.m(2131705156));
          this.jdField_A_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691410));
          this.B.setContentDescription(getString(2131691407));
          this.jdField_C_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719575));
          localObject2 = getString(2131698422);
          this.jdField_C_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
          localObject2 = getString(2131692884);
          this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.isDiscussHrMeeting()) {
          this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        }
        wZ(true);
        this.so = localThrowable.findViewById(2131364643);
        this.so.setOnClickListener(this);
        this.so.setBackgroundResource(2130839689);
        this.so.findViewById(2131369154).setVisibility(4);
        localObject1 = (LinearLayout.LayoutParams)this.so.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = aqcx.dip2px(this, 30.0F);
        this.so.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (TextView)this.so.findViewById(2131379769);
        ((TextView)localObject1).setText(acfp.m(2131705131));
        localObject2 = this.app.b().f(this.curUin, 3000);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          break;
        }
        ((TextView)localObject1).setTextColor(Color.parseColor("#cccccc"));
        return;
        if ((!hg(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin)))
        {
          this.z.setOnClickListener(this);
          this.z.setVisibility(0);
        }
        else
        {
          this.z.setVisibility(8);
          continue;
          this.z.setVisibility(8);
        }
      }
      ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
    }
  }
  
  private void bNc()
  {
    wZ(false);
  }
  
  private void bNf()
  {
    anot.a(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_editName", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.intent = new Intent(this, EditActivity.class);
    this.intent.putExtra("title", 2131692887);
    this.intent.putExtra("limit", 48);
    this.intent.putExtra("action", 102);
    this.intent.putExtra("current", this.aCr);
    this.intent.putExtra("canPostNull", false);
    this.intent.putExtra("multiLine", false);
    startActivityForResult(this.intent, 0);
  }
  
  private void bNg()
  {
    ahau.JH("0X8004E02");
    anot.a(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_file", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    Intent localIntent = new Intent(this, ChatHistoryFileActivity.class);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.curUin);
    localIntent.putExtra("uintype", this.cZ);
    localIntent.putExtra("uinname", this.aCr);
    startActivity(localIntent);
  }
  
  private void bNh()
  {
    anot.a(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_delMber", 0, 0, new String[] { this.curUin });
    Intent localIntent = TroopMemberListActivity.c(this, this.curUin, 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void bNi()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.setMainTitle(2131693291);
    localausj.addButton(getString(2131693290));
    localausj.addCancelButton(2131721058);
    localausj.a(new uur(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_quitgrp", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
  }
  
  private void bNo()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Acdu != null)
    {
      DiscussionMemberInfo localDiscussionMemberInfo = this.jdField_a_of_type_Acdu.a(this.curUin, this.app.getCurrentAccountUin());
      if (localDiscussionMemberInfo == null) {
        break label105;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag:" + localDiscussionMemberInfo.flag);
      }
      if (this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localFormSwitchItem = this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if ((localDiscussionMemberInfo.flag & 0x1) != 0) {
          bool = true;
        }
        localFormSwitchItem.setChecked(bool);
      }
    }
    label105:
    while (this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem == null)
    {
      FormSwitchItem localFormSwitchItem;
      return;
    }
    this.jdField_D_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void h(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setText(paramCharSequence);
    if (AppSetting.enableTalkBack) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setContentDescription(acfp.m(2131705144) + paramCharSequence + acfp.m(2131705155));
    }
  }
  
  private void initView()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.curUin = this.intent.getStringExtra("uin");
    this.aCr = this.intent.getStringExtra("uinname");
    if (this.aCr == null) {
      this.aCr = this.curUin;
    }
    this.cZ = this.intent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Acdu = ((acdu)this.app.getManager(53));
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = this.jdField_a_of_type_Acdu.a(this.curUin);
    bNb();
    setContentBackgroundResource(2130838900);
  }
  
  private void preloadWebProcess()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
    if (localWebProcessManager == null) {}
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.aFT());
      localWebProcessManager.egu();
    } while (!QLog.isColorLevel());
    QLog.d("DiscussionInfoCardActivity", 2, "start preloadWebProcess");
  }
  
  /* Error */
  private void wZ(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1031	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: aload_0
    //   6: invokevirtual 1035	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:getMainLooper	()Landroid/os/Looper;
    //   9: invokevirtual 1040	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   12: if_acmpne +21 -> 33
    //   15: new 1042	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$5
    //   18: dup
    //   19: aload_0
    //   20: iload_1
    //   21: invokespecial 1045	com/tencent/mobileqq/activity/DiscussionInfoCardActivity$5:<init>	(Lcom/tencent/mobileqq/activity/DiscussionInfoCardActivity;Z)V
    //   24: iconst_5
    //   25: aconst_null
    //   26: iconst_0
    //   27: invokestatic 341	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 151	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_a_of_type_Acdu	Lacdu;
    //   37: aload_0
    //   38: getfield 170	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:curUin	Ljava/lang/String;
    //   41: invokevirtual 1048	acdu:z	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 1052	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:fO	(Ljava/util/List;)V
    //   50: iload_1
    //   51: ifeq -21 -> 30
    //   54: new 1054	acdt$c
    //   57: dup
    //   58: invokespecial 1055	acdt$c:<init>	()V
    //   61: astore_3
    //   62: aload_3
    //   63: aload_0
    //   64: getfield 170	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:curUin	Ljava/lang/String;
    //   67: invokestatic 1059	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: putfield 1061	acdt$c:uin	Ljava/lang/String;
    //   73: aload_3
    //   74: aload_2
    //   75: invokeinterface 1064 1 0
    //   80: putfield 1067	acdt$c:memberCount	I
    //   83: aload_0
    //   84: getfield 148	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:jdField_b_of_type_Acdt	Lacdt;
    //   87: aload_3
    //   88: invokevirtual 1070	acdt:a	(Lacdt$c;)V
    //   91: goto -61 -> 30
    //   94: astore_2
    //   95: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -68 -> 30
    //   101: ldc_w 349
    //   104: iconst_2
    //   105: new 218	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 1072
    //   115: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 170	com/tencent/mobileqq/activity/DiscussionInfoCardActivity:curUin	Ljava/lang/String;
    //   122: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload_2
    //   129: invokestatic 1075	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: goto -102 -> 30
    //   135: astore_2
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	DiscussionInfoCardActivity
    //   0	140	1	paramBoolean	boolean
    //   44	31	2	localArrayList	ArrayList
    //   94	35	2	localException	Exception
    //   135	4	2	localObject	Object
    //   61	27	3	localc	acdt.c
    // Exception table:
    //   from	to	target	type
    //   54	91	94	java/lang/Exception
    //   2	30	135	finally
    //   33	50	135	finally
    //   54	91	135	finally
    //   95	132	135	finally
  }
  
  protected void a(b paramb, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramb.pQ == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.d.b(paramb.type, paramb.uin, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = aqhu.G();
        }
        localBitmap = paramBitmap;
        if (!this.d.isPausing())
        {
          this.d.i(paramb.uin, paramb.type, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramb.pQ.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  public void aAL()
  {
    anot.a(this.app, "CliOper", "", this.curUin, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_share", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131720177));
      this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(apzg.a(this, true));
      this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      SharedPreferences localSharedPreferences = getSharedPreferences("qrcode", 0);
      this.mValidTime = localSharedPreferences.getLong("discussionvalidtime" + this.curUin, 0L);
      this.aCs = localSharedPreferences.getString("discussion" + this.curUin, null);
      this.aCt = localSharedPreferences.getString("discussionfullSig" + this.curUin, null);
      if (this.mValidTime - System.currentTimeMillis() / 1000L > 0L)
      {
        i = 1;
        if ((this.aCs == null) || (this.aCt == null) || (i == 0)) {
          break label354;
        }
        this.aVB = true;
        anot.a(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
          continue;
          i = 0;
          continue;
          label354:
          if (QLog.isDevelopLevel()) {
            QLog.d("DiscussionInfoCardActivity", 4, "qrcode url not valid");
          }
          this.aVB = false;
          this.jdField_b_of_type_Acdt.ah(Long.parseLong(this.curUin), true);
        }
      }
    }
  }
  
  public void aL(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  public void bNd()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.aCr = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  protected void bNe()
  {
    anot.a(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_qrcode", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    this.intent = new Intent(getActivity(), QRDisplayActivity.class);
    this.intent.putExtra("title", acfp.m(2131705136));
    this.intent.putExtra("uin", this.curUin);
    this.intent.putExtra("nick", this.aCr);
    this.intent.putExtra("type", 5);
    Object localObject = this.jdField_b_of_type_Acdt.a(this.curUin, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.intent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_Acdv);
    startActivityForResult(this.intent, 10);
  }
  
  protected void bNj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      return;
    }
    aqfr.b("Grp_Dis_set", "Dis_info", "clk_upgrade", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    switch (this.bGE)
    {
    default: 
      return;
    case 0: 
      bNk();
      return;
    case 1: 
      anot.a(this.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "Clk_grptab", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), "", "", "");
      apuh.a(this, TroopInfoActivity.c(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16), 2);
      return;
    }
    Bundle localBundle = TroopInfoActivity.c(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 16);
    localBundle.putInt("D2GType", 1);
    apuh.a(this, localBundle, 2);
  }
  
  protected void bNk()
  {
    ausj localausj = ausj.b(this);
    localausj.addButton(2131692984);
    localausj.addCancelButton(2131721058);
    localausj.a(new uus(this, localausj));
    localausj.show();
  }
  
  protected void bNl()
  {
    if (this.jdField_A_of_type_Arhz == null)
    {
      this.jdField_A_of_type_Arhz = new arhz(this, getTitleBarHeight());
      this.jdField_A_of_type_Arhz.setMessage(2131721482);
    }
    if (!this.jdField_A_of_type_Arhz.isShowing()) {
      this.jdField_A_of_type_Arhz.show();
    }
  }
  
  public void bNm()
  {
    if ((this.jdField_A_of_type_Arhz != null) && (this.jdField_A_of_type_Arhz.isShowing())) {
      this.jdField_A_of_type_Arhz.dismiss();
    }
  }
  
  public void bNn()
  {
    int i = 2131692984;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupUin == 0L))
      {
        this.bGE = 0;
        this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131692984));
      }
      while (AppSetting.enableTalkBack)
      {
        this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(i));
        return;
        TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
        if (localTroopManager == null)
        {
          this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          return;
        }
        if (localTroopManager.b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode)) != null)
        {
          this.bGE = 1;
          this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131692986));
          i = 2131692986;
        }
        else
        {
          this.bGE = 2;
          this.jdField_D_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131692991));
          i = 2131692991;
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscussionInfoCardActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$a == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$a.notifyDataSetChanged();
          return;
          bKx();
          finish();
          return;
          setResult(-1);
          this.bO = true;
          return;
          addObserver(this.jdField_a_of_type_Acdv);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.aCr)));
        if (aqiw.isNetSupport(this))
        {
          this.jdField_b_of_type_Acdt.ad(Long.valueOf(this.curUin).longValue(), (String)localObject);
          h((CharSequence)localObject);
          vp(getString(2131691364));
          this.jdField_D_of_type_Arhz.show();
          return;
        }
        aL(1, getString(2131696348));
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          anot.a(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        }
        Object localObject = wja.a(new Intent(this, SplashActivity.class), null);
        paramIntent = paramIntent.getLongExtra("roomId", 0L) + "";
        ((Intent)localObject).putExtra("uin", paramIntent);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", aqgv.b(this.app, getApplicationContext(), paramIntent));
        ((Intent)localObject).putExtra("isBack2Root", true);
        startActivity((Intent)localObject);
        finish();
        return;
        localObject = wja.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$a == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity$a.notifyDataSetChanged();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.intent = getIntent();
    this.jdField_b_of_type_Acdt = ((acdt)this.app.getBusinessHandler(6));
    addObserver(this.jdField_a_of_type_Acfd);
    addObserver(this.jdField_a_of_type_Acdv);
    addObserver(this.jdField_a_of_type_Accn);
    addObserver(this.jdField_a_of_type_Accd);
    this.app.setHandler(DiscussionInfoCardActivity.class, this.q);
    initView();
    preloadWebProcess();
    aqfr.b("Grp_Dis_set", "Dis_info", "exp", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if ((this.jdField_D_of_type_Arhz != null) && (this.jdField_D_of_type_Arhz.isShowing()) && (!isFinishing()))
      {
        this.jdField_D_of_type_Arhz.dismiss();
        this.jdField_D_of_type_Arhz = null;
      }
      removeObserver(this.jdField_a_of_type_Acfd);
      removeObserver(this.jdField_a_of_type_Acdv);
      removeObserver(this.jdField_a_of_type_Accn);
      removeObserver(this.jdField_a_of_type_Accd);
      this.app.removeHandler(DiscussionInfoCardActivity.class);
      if (this.d != null)
      {
        this.d.destory();
        this.d = null;
      }
      if ((this.L != null) && (this.L.isShowing()) && (this.L.getWindow() != null)) {
        this.L.dismiss();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void doOnPause()
  {
    bKG();
    super.doOnPause();
  }
  
  void fO(List<DiscussionMemberInfo> paramList)
  {
    ArrayList localArrayList;
    Object localObject;
    int j;
    DiscussionMemberInfo localDiscussionMemberInfo1;
    int i;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      localObject = (acff)this.app.getManager(51);
      localObject = null;
      j = 0;
      if (j < paramList.size())
      {
        localDiscussionMemberInfo1 = (DiscussionMemberInfo)paramList.get(j);
        if (localDiscussionMemberInfo1 != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (localDiscussionMemberInfo1.memberUin != null)) {
            if ((hg(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) && (localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin))) {
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      label108:
      if (i != 0)
      {
        localObject = new DiscussionMemberInfo();
        ((DiscussionMemberInfo)localObject).memberUin = localDiscussionMemberInfo1.memberUin;
        ((DiscussionMemberInfo)localObject).memberName = aqgv.a(localDiscussionMemberInfo1, this.app);
      }
      for (;;)
      {
        j += 1;
        break;
        if ((hg(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.inheritOwnerUin)) || (!localDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin))) {
          break label311;
        }
        i = 1;
        break label108;
        DiscussionMemberInfo localDiscussionMemberInfo2 = new DiscussionMemberInfo();
        localDiscussionMemberInfo2.memberUin = localDiscussionMemberInfo1.memberUin;
        localDiscussionMemberInfo2.memberName = aqgv.a(localDiscussionMemberInfo1, this.app);
        localDiscussionMemberInfo2.discussionUin = ChnToSpell.aJ(localDiscussionMemberInfo2.memberName, 1);
        localArrayList.add(localDiscussionMemberInfo2);
      }
      Collections.sort(localArrayList, new acdb.a());
      if (localObject != null) {
        localArrayList.add(0, localObject);
      }
      if ((localArrayList.size() > 0) && (!this.q.hasMessages(0))) {
        this.q.obtainMessage(0, localArrayList).sendToTarget();
      }
      return;
      label311:
      i = 0;
    }
  }
  
  boolean hg(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  public void iJ()
  {
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).longValue();
      accc localaccc = (accc)this.app.getBusinessHandler(22);
      if (localaccc == null) {
        return;
      }
      localaccc.hh(l);
      bNl();
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.FU < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.FU = System.currentTimeMillis();
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        onItemClick(paramView);
        break;
      case 2131380383: 
        bNe();
        break;
      case 2131364458: 
        bKv();
        break;
      case 2131376837: 
        bNg();
        break;
      case 2131378080: 
        bKw();
        break;
      case 2131365969: 
        bNj();
        break;
      case 2131371111: 
        bNh();
        break;
      case 2131369594: 
        localObject = ausj.b(this);
        ((ausj)localObject).addButton(getString(2131698429));
        ((ausj)localObject).addButton(2131691293);
        ((ausj)localObject).addButton(getString(2131698379), 3);
        ((ausj)localObject).addButton(2131721058);
        ((ausj)localObject).a(new uux(this, (ausj)localObject));
        ((ausj)localObject).show();
        aqfr.b("Grp_Dis_set", "Dis_info", "clk_upright", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
        break;
      case 2131364643: 
        localObject = this.app.b().f(this.curUin, 3000);
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          QQToast.a(this, 1, getString(2131721283), 0).show();
        }
        else
        {
          localObject = new arfj(this, this.app, false);
          ((arfj)localObject).a(new uuy(this));
          ((arfj)localObject).show(2);
        }
        break;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof b)))
        {
          localObject = (b)localObject;
          if (paramString != null) {
            break label72;
          }
          a((b)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((b)localObject).uin))
        {
          paramInt1 += 1;
          break;
        }
        ((b)localObject).pQ.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void onItemClick(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    paramView = (String)paramView.getTag(2131379221);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.isDiscussHrMeeting()) && (!((String)localObject).equals(getString(2131695117))));
      if (!((String)localObject).equals(getString(2131695117))) {
        break;
      }
    } while (3000 != this.cZ);
    paramView = new Intent(this, SelectMemberActivity.class);
    localObject = ((acdu)this.app.getManager(53)).n(this.curUin);
    if (localObject != null) {
      paramView.putStringArrayListExtra("param_uins_selected_default", new ArrayList(((Map)localObject).keySet()));
    }
    paramView.putExtra("param_groupcode", this.curUin);
    paramView.putExtra("param_type", 3000);
    paramView.putExtra("param_subtype", 1);
    if (localObject != null) {}
    for (int i = ((Map)localObject).size();; i = 0)
    {
      paramView.putExtra("param_max", 100 - i);
      startActivityForResult(paramView, 2);
      anot.a(this.app, "CliOper", "", "", "0X800629A", "0X800629A", 0, 0, "", "", "", "");
      aqfr.b("Grp_Dis_set", "Dis_info", "clk_invite_new", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      return;
    }
    if (((String)localObject).equals(this.app.getCurrentAccountUin()))
    {
      paramView = new ProfileActivity.AllInOne((String)localObject, 0);
      paramView.bIZ = 5;
      paramView.bJa = 57;
      ProfileActivity.a(this, paramView, 3);
    }
    for (;;)
    {
      aqfr.b("Grp_Dis_set", "Dis_info", "clk_mberHead", 0, 0, new String[] { this.curUin, aqfr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo) });
      return;
      if (!((acff)this.app.getManager(51)).isFriend((String)localObject)) {
        break;
      }
      paramView = new ProfileActivity.AllInOne((String)localObject, 45);
      paramView.nickname = aqgv.d(this.app, (String)localObject, 0);
      if (3000 != this.cZ)
      {
        paramView.aOF = ((String)localObject);
        paramView.bIX = this.cZ;
      }
      paramView.discussUin = this.curUin;
      paramView.bIZ = 5;
      paramView.bJa = 57;
      ProfileActivity.a(this, paramView, 3);
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)localObject, 46);
    if (this.cZ == 3000)
    {
      localAllInOne.pa = 46;
      label468:
      localAllInOne.nickname = paramView;
      localAllInOne.aOF = ((String)localObject);
      localAllInOne.bIX = this.cZ;
      if (3000 != this.cZ) {
        break label655;
      }
      localAllInOne.discussUin = this.curUin;
    }
    for (;;)
    {
      localAllInOne.bIZ = 5;
      localAllInOne.bJa = 57;
      ProfileActivity.a(this, localAllInOne, 3);
      break;
      if (this.cZ == 1000)
      {
        localAllInOne.pa = 22;
        localAllInOne.troopUin = getIntent().getStringExtra("troop_uin");
        break label468;
      }
      if (this.cZ == 1001)
      {
        localAllInOne.pa = 42;
        break label468;
      }
      if (this.cZ == 10002)
      {
        localAllInOne.pa = 86;
        break label468;
      }
      if (this.cZ == 1005)
      {
        localAllInOne.pa = 2;
        break label468;
      }
      if (this.cZ == 1023)
      {
        localAllInOne.pa = 74;
        break label468;
      }
      localAllInOne.pa = 19;
      break label468;
      label655:
      if (1000 == this.cZ) {
        localAllInOne.troopUin = getIntent().getStringExtra("troop_uin");
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.aVB)
    {
      aL(2130840095, acfp.m(2131705151));
      this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        switch (((ShareActionSheetBuilder.b)localObject1).b.action)
        {
        default: 
          break;
        case 1: 
          a(this.app, this.mValidTime, this.aCs, this.aCr);
        }
      }
    }
    bNl();
    Object localObject1 = this.jdField_a_of_type_Acdu.z(this.curUin);
    if (localObject1 != null) {}
    for (int i = ((List)localObject1).size();; i = 0)
    {
      a(this.app, this, 11, this.aCt, this.curUin, this.aCr, i, this.jdField_A_of_type_Arhz);
      break;
      a(this.app, this, this.aCs, this.curUin, this.aCr);
      break;
      i = -1;
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
      for (;;)
      {
        if (i == -1) {
          break label288;
        }
        rwt.ez(1, i);
        break;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      label288:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new uuq(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
      }
      Object localObject2 = this.app;
      if (paramInt == 2)
      {
        localObject1 = "1";
        label333:
        anot.a((QQAppInterface)localObject2, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, (String)localObject1, "", "", "");
        if (paramInt != 2) {
          break label557;
        }
        anot.a(this.app, "CliOper", "", "", "0X800666D", "0X800666D", 0, 0, "", "", "", "");
        label393:
        this.Qt = String.valueOf(System.currentTimeMillis());
        localObject1 = this.jdField_b_of_type_Acdt.a(this.curUin, true);
        if (!(localObject1 instanceof BitmapDrawable)) {
          break label602;
        }
      }
      label557:
      label602:
      for (localObject1 = ((BitmapDrawable)localObject1).getBitmap();; localObject1 = null)
      {
        localObject1 = apzg.R((Bitmap)localObject1);
        localObject2 = WXShareHelper.a();
        String str1 = this.Qt;
        String str2 = ForwardUtils.c(this.app, this.aCr, this.curUin);
        String str3 = acfp.m(2131705134) + aqgv.k(this.app, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin);
        String str4 = this.aCs;
        if (paramInt == 2) {}
        for (i = 0;; i = 1)
        {
          ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
          break;
          localObject1 = "0";
          break label333;
          anot.a(this.app, "CliOper", "", "", "0X800666E", "0X800666E", 0, 0, "", "", "", "");
          break label393;
        }
        bNe();
        break;
      }
    }
  }
  
  public void vp(String paramString)
  {
    this.jdField_D_of_type_Arhz = new arhz(this, getTitleBarHeight());
    this.jdField_D_of_type_Arhz.setContentView(2131562991);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_D_of_type_Arhz.setMessage(getString(2131719519));
      return;
    }
    this.jdField_D_of_type_Arhz.setMessage(paramString);
  }
  
  public class a
    extends BaseAdapter
  {
    private acff e = (acff)DiscussionInfoCardActivity.this.app.getManager(51);
    
    public a() {}
    
    public int getCount()
    {
      if (DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this) == null) {
        return 1;
      }
      return DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this).size() + 1;
    }
    
    public Object getItem(int paramInt)
    {
      if ((DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this) == null) || (paramInt >= DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this).size())) {
        return null;
      }
      return DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      DiscussionInfoCardActivity.b localb;
      TextView localTextView;
      ImageView localImageView;
      Object localObject1;
      if (paramView == null)
      {
        localView = DiscussionInfoCardActivity.this.getLayoutInflater().inflate(2131558933, null);
        localb = new DiscussionInfoCardActivity.b();
        localb.pQ = ((ImageView)localView.findViewById(2131368698));
        localb.nameTV = ((TextView)localView.findViewById(2131372190));
        localView.setTag(localb);
        localView.setVisibility(0);
        localView.setFocusable(false);
        localTextView = localb.nameTV;
        localImageView = localb.pQ;
        if (paramInt != getCount() - 1) {
          break label253;
        }
        localObject1 = DiscussionInfoCardActivity.this.getString(2131695117);
        localTextView.setText((CharSequence)localObject1);
        localTextView.setTextColor(DiscussionInfoCardActivity.this.getResources().getColor(2131167312));
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageResource(2130839348);
        localImageView.setTag(localObject1);
        if ((!DiscussionInfoCardActivity.this.a.isDiscussHrMeeting()) || (!aqjl.mv(DiscussionInfoCardActivity.this.a.mSelfRight))) {
          break label244;
        }
        localImageView.setEnabled(false);
      }
      for (;;)
      {
        if (AppSetting.enableTalkBack) {
          ViewCompat.setImportantForAccessibility(localImageView, 2);
        }
        localImageView.setOnClickListener(DiscussionInfoCardActivity.this);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        localb = (DiscussionInfoCardActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label244:
        localImageView.setEnabled(true);
        continue;
        label253:
        if (paramInt > getCount() - 1)
        {
          localTextView.setText("");
          localImageView.setBackgroundDrawable(null);
          localImageView.setImageDrawable(null);
        }
        else
        {
          localImageView.setImageResource(2130845854);
          localTextView.setTextColor(DiscussionInfoCardActivity.this.getResources().getColor(2131167304));
          String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this).get(paramInt)).memberUin;
          localb.uin = str;
          Object localObject2 = aqgv.m(DiscussionInfoCardActivity.this.app, DiscussionInfoCardActivity.a(DiscussionInfoCardActivity.this), str);
          if (TextUtils.isEmpty(str))
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localTextView.setText((CharSequence)localObject1);
            localImageView.setImageDrawable(aqhu.at());
          }
          else
          {
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              if (this.e != null)
              {
                Friends localFriends = this.e.e(str);
                localObject1 = localObject2;
                if (localFriends != null)
                {
                  localObject1 = localObject2;
                  if (localFriends.isFriend()) {
                    localObject1 = aqgv.s(DiscussionInfoCardActivity.this.app, str);
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = str;
            }
            localTextView.setText((CharSequence)localObject2);
            DiscussionInfoCardActivity.this.a(localb, null, true);
            localImageView.setTag(str);
            localImageView.setTag(2131379221, localObject2);
          }
        }
      }
    }
  }
  
  public static class b
  {
    TextView nameTV;
    ImageView pQ;
    int type = 1;
    String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */