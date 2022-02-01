package com.tencent.mobileqq.troop.widget;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import apuh;
import apwd;
import apyg;
import apyh;
import aqdj;
import aqfr;
import aqiw;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import jnl;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import rpq;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.troop.activity.troopactivity.ActSSOReq;
import tencent.im.troop.activity.troopactivity.ActSSORsp;
import tencent.im.troop.activity.troopactivity.Activity;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;
import wja;

public class TroopMoreDetailView
  extends LinearLayout
  implements View.OnClickListener
{
  ArrayList<String> CB = new ArrayList();
  ConcurrentLinkedQueue<ShowTagTask> N = new ConcurrentLinkedQueue();
  a jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$a;
  b jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$b;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  TroopInfo b;
  boolean cSO;
  AtomicInteger cg = new AtomicInteger(0);
  String crI = "";
  DisplayMetrics mDisplayMetrics;
  View[] p;
  List<ImageView> qz;
  
  public TroopMoreDetailView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TroopMoreDetailView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TroopMoreDetailView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @RequiresApi(api=21)
  public TroopMoreDetailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void a(troopactivity.GroupInfoCardResp paramGroupInfoCardResp)
  {
    if (paramGroupInfoCardResp == null) {}
    int i;
    Object localObject1;
    do
    {
      return;
      i = paramGroupInfoCardResp.activitys.size();
      localObject1 = paramGroupInfoCardResp.group_act_url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.crI = c((String)localObject1, 0L, 0);
      }
      localObject1 = this.p[3];
    } while (localObject1 == null);
    View localView = ((View)localObject1).findViewById(2131380199);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131362049);
    if (i > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      b(3, 0, localView, getContext().getString(2131698536), getContext().getString(2131699435), true);
      localTextView.setText(str + "\n" + (String)localObject2);
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      i = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getContext().getString(2131699434), new Object[] { Integer.valueOf(i) });
      b(3, 0, localView, getContext().getString(2131698536), paramGroupInfoCardResp, true);
      ((View)localObject1).setVisibility(0);
      localTextView.setVisibility(8);
      return;
    }
    ((View)localObject1).setVisibility(8);
    localTextView.setVisibility(8);
  }
  
  private void bKU()
  {
    if (!aqiw.isNetworkAvailable(getContext())) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localQQAppInterface = getQQAppInterface();
      } while (localQQAppInterface == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$b = new b(this);
      c(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$b);
    } while (!this.cSO);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$a = new a(this);
    d(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$a);
  }
  
  private String c(String paramString, long paramLong, int paramInt)
  {
    if (getActivity() == null) {
      return "";
    }
    Object localObject = getQQAppInterface();
    if (localObject == null) {
      return "";
    }
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      localObject = "0";
      localObject = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$CLIENTVER$", "android3.4.4").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject);
      if (!this.cSO) {
        break label208;
      }
    }
    label208:
    for (paramString = "2";; paramString = "1")
    {
      return ((String)localObject).replace("$ENTERSOURCE$", paramString).replace("$GNAME$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + "").replace("$GUIN$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        localObject = "1";
        break;
      }
      localObject = "2";
      break;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      troop_member_distribute.ReqBody localReqBody = new troop_member_distribute.ReqBody();
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      paramString = new NewIntent(paramQQAppInterface.getApp(), jnl.class);
      paramString.putExtra("cmd", "group_member_statistic.get_group_member_statistic");
      paramString.putExtra("data", localReqBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramString);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    troopactivity.ActSSOReq localActSSOReq = new troopactivity.ActSSOReq();
    localActSSOReq.cmd.set(1);
    localActSSOReq.group_code.set(Long.parseLong(paramString));
    paramString = new NewIntent(paramQQAppInterface.getApp(), jnl.class);
    paramString.putExtra("cmd", "qqact.actvitylist");
    paramString.putExtra("data", localActSSOReq.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void ecp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMoreDetailView", 2, String.format("runNextShowTagTask %s / %s", new Object[] { Integer.valueOf(this.cg.get()), Integer.valueOf(this.N.size()) }));
    }
    if (this.cg.get() < 3)
    {
      ShowTagTask localShowTagTask = (ShowTagTask)this.N.poll();
      if (localShowTagTask != null)
      {
        this.cg.incrementAndGet();
        ThreadManager.post(localShowTagTask, 8, null, true);
      }
    }
  }
  
  private Activity getActivity()
  {
    Context localContext = getContext();
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    return null;
  }
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void init()
  {
    setOrientation(1);
  }
  
  public void Ub(String paramString)
  {
    if (this.p[4] != null)
    {
      TextView localTextView = (TextView)this.p[4].findViewById(2131369154);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
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
      label49:
      paramString.setVisibility(paramInt3);
      if (!paramBoolean) {
        break label112;
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
        break label49;
        label112:
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
  
  protected void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMoreDetailView", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.p.length)) {}
    for (View localView = this.p[paramInt1];; localView = null)
    {
      if (localView != null)
      {
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break label98;
        }
        localView.setVisibility(8);
      }
      label98:
      int k;
      int m;
      int n;
      LinearLayout localLinearLayout;
      do
      {
        return;
        localView.setVisibility(0);
        k = wja.dp2px(5.0F, getResources());
        m = wja.dp2px(2.0F, getResources());
        n = wja.dp2px(77.0F, getResources());
        localLinearLayout = (LinearLayout)localView.findViewById(2131364819);
        localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), m, localLinearLayout.getPaddingRight(), localLinearLayout.getPaddingBottom());
        localLinearLayout.removeAllViews();
      } while (paramArrayList == null);
      int j = 0;
      while ((j < paramArrayList.size()) && (j < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(j)))
        {
          j += 1;
        }
        else
        {
          TextView localTextView = new TextView(getContext());
          localTextView.setId(2131374487);
          int i = 2130844646;
          if (paramInt2 == 1) {
            i = 2130844647;
          }
          for (;;)
          {
            Object localObject = getResources().getDrawable(i);
            ProfileActivity.a(getQQAppInterface(), (Drawable)localObject);
            localTextView.setBackgroundDrawable((Drawable)localObject);
            localTextView.setTextSize(1, 12.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(n);
            }
            localTextView.setSingleLine();
            localTextView.setTextColor(getResources().getColor(2131167461));
            localTextView.setPadding(k, m, k, m);
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(j));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            localObject = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject).leftMargin = k;
            localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
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
  
  protected void b(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    label48:
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView1 = (TextView)paramView.findViewById(2131379769);
        TextView localTextView2 = (TextView)paramView.findViewById(2131369154);
        localView = paramView.findViewById(2131362978);
        paramView = paramString1;
        if (paramString1 == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        localTextView2.setText(paramString2);
        if (!paramBoolean) {
          break;
        }
      }
    }
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
    }
  }
  
  public void bLg()
  {
    if (rpq.isFastDoubleClick()) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = getActivity();
    } while (localActivity == null);
    Intent localIntent = TroopMemberListActivity.c(localActivity, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    localActivity.startActivityForResult(localIntent, 100);
  }
  
  protected void eA(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131380355;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131380356;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131380357;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131380358;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131380359;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131380360;
    tmp38_32;
    this.qz = new ArrayList(6);
    int j = Math.min(arrayOfInt.length, 6);
    int i = 0;
    while (i < j)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(arrayOfInt[i]);
      this.qz.add(localImageView);
      i += 1;
    }
  }
  
  public void eco()
  {
    this.N.offer(new ShowTagTask(this));
    ecp();
  }
  
  public void initView()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    this.mDisplayMetrics = new DisplayMetrics();
    ((Activity)localObject).getWindowManager().getDefaultDisplay().getMetrics(this.mDisplayMetrics);
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      i = 1;
      this.p = new View[7];
      localObject = View.inflate(getContext(), 2131561759, null);
      if (i == 0) {
        break label488;
      }
      j = 1;
      label82:
      a(0, j, (View)localObject, getContext().getString(2131721321), null, true, 1);
      this.p[0] = localObject;
      addView((View)localObject);
      eco();
      localObject = View.inflate(getContext(), 2131561760, null);
      b(1, 2, (View)localObject, acfp.m(2131716027), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, true);
      this.p[1] = localObject;
      addView((View)localObject);
      if (i == 0) {
        break label493;
      }
    }
    label488:
    label493:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      localObject = View.inflate(getContext(), 2131560874, null);
      b(3, 3, (View)localObject, acfp.m(2131716023), "", true);
      this.p[3] = localObject;
      new LinearLayout.LayoutParams(-1, -2).setMargins(0, rpq.dip2px(getContext(), 10.0F), 0, 0);
      addView((View)localObject);
      ((View)localObject).setVisibility(8);
      addView(View.inflate(getContext(), 2131561775, null));
      localObject = View.inflate(getContext(), 2131561769, null);
      this.p[4] = localObject;
      addView((View)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + acfp.m(2131716020);
      b(4, 3, (View)localObject, acfp.m(2131716022), str, true);
      localObject = View.inflate(getContext(), 2131560087, null);
      this.p[5] = localObject;
      ((View)localObject).setBackgroundResource(2130839689);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setTag(Integer.valueOf(5));
      ((View)localObject).setOnClickListener(this);
      ((View)localObject).setVisibility(8);
      addView((View)localObject);
      addView(View.inflate(getContext(), 2131561775, null));
      localObject = View.inflate(getContext(), 2131561776, null);
      this.p[6] = localObject;
      this.p[6].setBackgroundResource(2130839689);
      ((View)localObject).setTag(Integer.valueOf(6));
      ((View)localObject).setOnClickListener(this);
      eA((View)localObject);
      addView((View)localObject);
      ((TextView)((View)localObject).findViewById(2131371234)).setText(acfp.m(2131716028));
      bKU();
      return;
      i = 0;
      break;
      j = 3;
      break label82;
    }
  }
  
  public void mY(List<oidb_0x899.memberlist> paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = paramList.size();
    this.CB.clear();
    int i = 0;
    if (i < j)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(i);
      if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
      for (;;)
      {
        i += 1;
        break;
        long l = localmemberlist.uint64_member_uin.get();
        this.CB.add(String.valueOf(l));
      }
    }
    ThreadManager.getUIHandler().post(new UpdateTroopMembersFaceTask(this));
  }
  
  public void onClick(View paramView)
  {
    if (rpq.isFastDoubleClick()) {}
    Activity localActivity;
    label155:
    label584:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            localActivity = getActivity();
            if (localActivity != null)
            {
              localObject = paramView.getTag();
              if ((localObject instanceof Integer)) {
                switch (((Integer)localObject).intValue())
                {
                case 2: 
                default: 
                  break;
                case 0: 
                  ThreadManager.post(new JumpTagDetailTask(this), 8, null, true);
                  if (this.cSO)
                  {
                    aqfr.b("Grp_set_new", "grpData_visitor", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    if (!(localActivity instanceof ChatSettingForTroop)) {
                      continue;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
                      break label264;
                    }
                  }
                  for (i = 1;; i = 2)
                  {
                    anot.a(null, "dc00898", "", "", "0X800A528", "0X800A528", i, 0, apuh.LG() + "", "", "", "");
                    break;
                    aqfr.b("Grp_set_new", "moreData", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    break label155;
                  }
                case 3: 
                  if (!TextUtils.isEmpty(this.crI))
                  {
                    localObject = new Intent(localActivity, QQBrowserActivity.class);
                    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
                    ((Intent)localObject).putExtra("url", this.crI);
                    localActivity.startActivity((Intent)localObject);
                  }
                  break;
                case 1: 
                  localObject = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                  Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
                  localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
                  localIntent.putExtra("url", (String)localObject);
                  localActivity.startActivity(localIntent);
                  if (this.cSO) {
                    aqfr.b("Grp_set_new", "grpData_visitor", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                  } else {
                    aqfr.b("Grp_set_new", "moreData", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                  }
                  break;
                }
              }
            }
          }
          localObject = new Intent(getContext(), PublicAccountBrowser.class);
          ((Intent)localObject).putExtra("url", "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          getContext().startActivity((Intent)localObject);
          if (!this.cSO) {
            break;
          }
          aqfr.b("Grp_set_new", "grpData_visitor", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        } while (!(localActivity instanceof ChatSettingForTroop));
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
        for (i = 1;; i = 2)
        {
          anot.a(null, "dc00898", "", "", "0X800A529", "0X800A529", i, 0, apuh.LG() + "", "", "", "");
          break;
          aqfr.b("Grp_set_new", "moreData", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          break label584;
        }
        if (this.cSO) {
          aqfr.b("Grp_set_new", "grpData_visitor", "clk_manaList", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        }
      } while (this.CB.isEmpty());
      Object localObject = new Intent(localActivity, TroopAdminList.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      ((Intent)localObject).putStringArrayListExtra("troop_info_memo", this.CB);
      if (localActivity.getIntent() != null) {
        ((Intent)localObject).putExtra("t_s_f", localActivity.getIntent().getIntExtra("t_s_f", -1));
      }
      localActivity.startActivity((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format("DATA_TAG_TROOP_ADMIN_LIST, [uin:%s, code:%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode }));
      }
    } while (!(localActivity instanceof ChatSettingForTroop));
    label264:
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A52A", "0X800A52A", i, 0, apuh.LG() + "", "", "", "");
      break;
    }
  }
  
  public void setGuestVisitor(boolean paramBoolean)
  {
    this.cSO = paramBoolean;
  }
  
  public void setTroopInfo(TroopInfo paramTroopInfo)
  {
    this.b = paramTroopInfo;
    paramTroopInfo = getQQAppInterface();
    if (paramTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.b, paramTroopInfo.getCurrentAccountUin());
  }
  
  public void setTroopInfoData(TroopInfoData paramTroopInfoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
  }
  
  static class JumpTagDetailTask
    implements Runnable
  {
    private final WeakReference<TroopMoreDetailView> weakReference;
    
    public JumpTagDetailTask(TroopMoreDetailView paramTroopMoreDetailView)
    {
      this.weakReference = new WeakReference(paramTroopMoreDetailView);
    }
    
    public void run()
    {
      int j = 0;
      TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.weakReference.get();
      if (localTroopMoreDetailView == null) {}
      Activity localActivity;
      QQAppInterface localQQAppInterface;
      do
      {
        do
        {
          return;
          localActivity = TroopMoreDetailView.a(localTroopMoreDetailView);
        } while (localActivity == null);
        localQQAppInterface = TroopMoreDetailView.a(localTroopMoreDetailView);
      } while (localQQAppInterface == null);
      Object localObject1 = Long.toString(localTroopMoreDetailView.a.dwGroupClassExt);
      apyg localapyg = apyh.a(localActivity).a(localActivity, (String)localObject1);
      List localList = localTroopMoreDetailView.a.troopTags;
      Intent localIntent = new Intent(localActivity, TroopTagViewActivity.class);
      localIntent.putExtra("troopuin", localTroopMoreDetailView.a.troopUin);
      localIntent.putExtra("isAdmin", false);
      Object localObject2 = "";
      int i;
      if (!TextUtils.isEmpty(localTroopMoreDetailView.a.mTroopClassExtText))
      {
        localObject1 = localTroopMoreDetailView.a.mTroopClassExtText;
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          localIntent.putExtra("subclass", (String)localObject1);
        }
        if ((localList == null) || (localList.size() <= 0)) {
          break label305;
        }
        localObject1 = new StringBuilder();
        localObject2 = localList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append("\n");
        }
        localObject1 = localObject2;
        i = j;
        if (localapyg != null)
        {
          localObject1 = localObject2;
          i = j;
          if (!TextUtils.isEmpty(localapyg.name))
          {
            localObject1 = localObject2;
            i = j;
            if (!acfp.m(2131716018).equals(localapyg.name))
            {
              localObject1 = localapyg.name;
              i = 1;
            }
          }
        }
      }
      ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      localIntent.putExtra("tags", ((StringBuilder)localObject1).toString());
      label305:
      localIntent.putExtra("act_type", 1);
      localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
      if (localTroopMoreDetailView.a.isOwnerOrAdim())
      {
        localActivity.startActivityForResult(localIntent, 98);
        return;
      }
      localActivity.startActivity(localIntent);
    }
  }
  
  class ShowTagTask
    implements Runnable
  {
    private final WeakReference<TroopMoreDetailView> weakReference;
    
    public ShowTagTask(TroopMoreDetailView paramTroopMoreDetailView)
    {
      this.weakReference = new WeakReference(paramTroopMoreDetailView);
    }
    
    public void run()
    {
      TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.weakReference.get();
      if (localTroopMoreDetailView == null) {}
      while (localTroopMoreDetailView.getContext() == null) {
        return;
      }
      ArrayList localArrayList = TroopInfoActivity.a(localTroopMoreDetailView.getContext(), localTroopMoreDetailView.a);
      ThreadManager.getUIHandler().post(new TroopMoreDetailView.ShowTagTask.1(this, localTroopMoreDetailView, localArrayList));
      TroopMoreDetailView.this.cg.decrementAndGet();
      TroopMoreDetailView.a(TroopMoreDetailView.this);
    }
  }
  
  public static class UpdateTroopMembersFaceTask
    implements Runnable
  {
    private final WeakReference<TroopMoreDetailView> weakReference;
    
    public UpdateTroopMembersFaceTask(TroopMoreDetailView paramTroopMoreDetailView)
    {
      this.weakReference = new WeakReference(paramTroopMoreDetailView);
    }
    
    public void run()
    {
      int i = 6;
      TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.weakReference.get();
      if (localTroopMoreDetailView == null) {}
      Object localObject1;
      QQAppInterface localQQAppInterface;
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = TroopMoreDetailView.a(localTroopMoreDetailView);
          } while (localObject1 == null);
          localQQAppInterface = TroopMoreDetailView.a(localTroopMoreDetailView);
        } while ((localQQAppInterface == null) || (localTroopMoreDetailView.p == null));
        localObject3 = localTroopMoreDetailView.p[6];
      } while (localObject3 == null);
      int k = localTroopMoreDetailView.CB.size();
      if (k == 0)
      {
        ((View)localObject3).setVisibility(8);
        return;
      }
      ((LinearLayout)((View)localObject3).findViewById(2131366633)).setVisibility(0);
      Object localObject2 = (TextView)((View)localObject3).findViewById(2131371230);
      ((TextView)localObject2).setText(acfp.m(2131716026) + k + acfp.m(2131716019));
      Object localObject3 = (TextView)((View)localObject3).findViewById(2131371234);
      int j = (localTroopMoreDetailView.mDisplayMetrics.widthPixels - ((TextView)localObject3).getMeasuredWidth() - rpq.dip2px((Context)localObject1, 27.0F) - ((TextView)localObject2).getMeasuredWidth() - rpq.dip2px((Context)localObject1, 24.0F)) / rpq.dip2px((Context)localObject1, 52.0F);
      if (j > 6) {}
      for (;;)
      {
        j = 0;
        label215:
        if (j < i - 1)
        {
          localObject1 = (ImageView)localTroopMoreDetailView.qz.get(j);
          if (j >= k) {
            break label347;
          }
          localObject2 = (String)localTroopMoreDetailView.CB.get(j);
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setBackgroundDrawable(aqdj.a(localQQAppInterface, 1, (String)localObject2, 3));
          ((ImageView)localObject1).setTag(localObject2);
          ((ImageView)localObject1).setOnClickListener(new apwd(this, localTroopMoreDetailView));
          if (AppSetting.enableTalkBack)
          {
            ((ImageView)localObject1).setContentDescription(acfp.m(2131716017) + (j + 1));
            ViewCompat.setImportantForAccessibility((View)localObject1, 1);
          }
        }
        for (;;)
        {
          j += 1;
          break label215;
          break;
          label347:
          ((ImageView)localObject1).setVisibility(8);
        }
        i = j;
      }
    }
  }
  
  static class a
    implements BusinessObserver
  {
    private final WeakReference<TroopMoreDetailView> weakReference;
    
    public a(TroopMoreDetailView paramTroopMoreDetailView)
    {
      this.weakReference = new WeakReference(paramTroopMoreDetailView);
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.weakReference.get();
      if (localTroopMoreDetailView == null) {}
      label99:
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (!paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: !isSuccess || mTroopInfoData == null");
              }
            }
            else {
              try
              {
                paramBundle = paramBundle.getByteArray("data");
                if (paramBundle != null) {
                  break label99;
                }
                if (QLog.isColorLevel())
                {
                  QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: data == null");
                  return;
                }
              }
              catch (InvalidProtocolBufferMicroException paramBundle) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: InvalidProtocolBufferMicroException:" + paramBundle.getMessage());
        return;
        localObject = new troopactivity.ActSSORsp();
        ((troopactivity.ActSSORsp)localObject).mergeFrom(paramBundle);
        if (((troopactivity.ActSSORsp)localObject).err_code.get() == 10000) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: errorcode:" + ((troopactivity.ActSSORsp)localObject).err_code.get() + ", msg:" + ((troopactivity.ActSSORsp)localObject).err_msg.get());
      return;
      paramBundle = ((troopactivity.ActSSORsp)localObject).body.get().toByteArray();
      Object localObject = new troopactivity.GroupInfoCardResp();
      ((troopactivity.GroupInfoCardResp)localObject).mergeFrom(paramBundle);
      TroopMoreDetailView.a(localTroopMoreDetailView, (troopactivity.GroupInfoCardResp)localObject);
    }
  }
  
  static class b
    implements BusinessObserver
  {
    private final WeakReference<TroopMoreDetailView> weakReference;
    
    public b(TroopMoreDetailView paramTroopMoreDetailView)
    {
      this.weakReference = new WeakReference(paramTroopMoreDetailView);
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.weakReference.get();
      if (localTroopMoreDetailView == null) {}
      Object localObject2;
      Context localContext;
      int j;
      label141:
      View localView;
      StringBuffer localStringBuffer;
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject1 = TroopMoreDetailView.a(localTroopMoreDetailView);
            if ((localObject1 != null) && (paramBoolean))
            {
              localObject2 = paramBundle.getByteArray("data");
              if (localObject2 != null)
              {
                localContext = localTroopMoreDetailView.getContext();
                if (localContext != null) {
                  try
                  {
                    paramBundle = new troop_member_distribute.RspBody();
                    paramBundle.mergeFrom((byte[])localObject2);
                    if (paramBundle.uint32_result.get() == 0)
                    {
                      localObject2 = paramBundle.rpt_msg_statistic.get();
                      j = paramBundle.uint32_group_member.get();
                      if (j != 0) {
                        break label141;
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.d("TroopMoreDetailView", 2, "mGetTroopMemberDistributeObserver.onReceive: memberCount should not be 0!");
                        return;
                      }
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramBundle) {}
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("TroopMoreDetailView", 2, paramBundle, new Object[0]);
        return;
        localView = localTroopMoreDetailView.p[5];
        localStringBuffer = new StringBuffer(localTroopMoreDetailView.getResources().getString(2131721422));
      } while ((localView == null) || (((List)localObject2).size() < 4));
      localView.setVisibility(0);
      if (localTroopMoreDetailView.p[4] != null) {
        localTroopMoreDetailView.p[4].setBackgroundResource(2130839689);
      }
      localStringBuffer.append(",本群共").append(j).append("人");
      paramBundle = localView.findViewById(2131380337);
      paramBoolean = ThemeUtil.isInNightMode((AppRuntime)localObject1);
      int i = 0;
      label300:
      Object localObject3;
      RoundProgressBar localRoundProgressBar;
      if (i < ((List)localObject2).size())
      {
        paramInt = Color.parseColor("#ffffff00");
        switch (i)
        {
        case 0: 
          localObject3 = (troop_member_distribute.OStatisticInfo)((List)localObject2).get(i);
          localRoundProgressBar = (RoundProgressBar)paramBundle.findViewById(2131377583);
          localRoundProgressBar.setTextColor(localContext.getResources().getColor(2131167307));
          if (!paramBoolean) {
            break;
          }
        }
      }
      for (Object localObject1 = "#FF1F1F1F";; localObject1 = "#FFDDDDDD")
      {
        localRoundProgressBar.setCircleColor(Color.parseColor((String)localObject1));
        localRoundProgressBar.setRoundWidth(wja.dp2px(2.0F, localTroopMoreDetailView.getResources()));
        localRoundProgressBar.setTextSize(34.0F);
        localRoundProgressBar.setCircleProgressColor(paramInt);
        paramInt = ((troop_member_distribute.OStatisticInfo)localObject3).uint32_count.get() * 100 / j;
        localRoundProgressBar.setProgress(paramInt);
        localObject1 = (TextView)paramBundle.findViewById(2131379769);
        localObject3 = ((troop_member_distribute.OStatisticInfo)localObject3).bytes_desc.get().toStringUtf8();
        ((TextView)localObject1).setText((CharSequence)localObject3);
        localObject1 = ((String)localObject3).split("-");
        localStringBuffer.append(", 百分之").append(paramInt).append("为").append(localObject1[0]);
        i += 1;
        break;
        localObject1 = localView.findViewById(2131380337);
        if (paramBoolean)
        {
          paramBundle = "#FF371657";
          label496:
          paramInt = Color.parseColor(paramBundle);
          paramBundle = (Bundle)localObject1;
          break label300;
          localObject1 = localView.findViewById(2131380338);
          if (!paramBoolean) {
            break label606;
          }
          paramBundle = "#FF17470A";
          label523:
          paramInt = Color.parseColor(paramBundle);
          paramBundle = (Bundle)localObject1;
          break label300;
          localObject1 = localView.findViewById(2131380339);
          if (!paramBoolean) {
            break label613;
          }
          paramBundle = "#FF074861";
          label550:
          paramInt = Color.parseColor(paramBundle);
          paramBundle = (Bundle)localObject1;
          break label300;
          localObject1 = localView.findViewById(2131380340);
          if (!paramBoolean) {
            break label620;
          }
        }
        label606:
        label613:
        label620:
        for (paramBundle = "#FF615400";; paramBundle = "#ffff8400")
        {
          paramInt = Color.parseColor(paramBundle);
          paramBundle = (Bundle)localObject1;
          break;
          localView.setContentDescription(localStringBuffer);
          return;
          break;
          paramBundle = "#ff771bf4";
          break label496;
          paramBundle = "#ff0eddb8";
          break label523;
          paramBundle = "#ff0d8aff";
          break label550;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopMoreDetailView
 * JD-Core Version:    0.7.0.1
 */