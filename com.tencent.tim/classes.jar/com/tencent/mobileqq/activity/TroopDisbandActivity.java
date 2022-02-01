package com.tencent.mobileqq.activity;

import acfd;
import acfp;
import acms;
import acnd;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import anot;
import anov;
import aqdj;
import aqha;
import aqhu;
import aqiw;
import aqju;
import arib;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import vyq;
import vyr;
import vys;
import vyt;
import vyu;
import vyx;

public class TroopDisbandActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected TextView FX;
  protected TextView FY;
  protected TextView FZ;
  public long Ha;
  public long Hb;
  acnd a;
  public arib a;
  public a a;
  public String aKI;
  public TroopInfo b;
  public int bFL;
  public int bFO;
  protected int bLt;
  protected int bwf;
  private acfd c = new vyx(this);
  protected Button dE;
  protected Button dF;
  protected GridView j;
  protected String mFrom = "";
  public String mSelfUin;
  public String mTroopName;
  public String mTroopUin;
  public ArrayList<String> pG;
  protected ImageView rr;
  protected View vn;
  protected View vo;
  
  public TroopDisbandActivity()
  {
    this.jdField_a_of_type_Acnd = new vyu(this);
  }
  
  private void Ad()
  {
    this.FX = ((TextView)findViewById(2131380354));
    this.rr = ((ImageView)findViewById(2131380253));
    this.vn = findViewById(2131380255);
    this.FY = ((TextView)findViewById(2131380254));
    this.vo = findViewById(2131380251);
    this.j = ((GridView)findViewById(2131380252));
    this.j.setFocusable(false);
    this.j.setClickable(false);
    this.j.setEnabled(false);
    this.FZ = ((TextView)findViewById(2131380256));
    this.dE = ((Button)findViewById(2131380404));
    this.dE.setOnClickListener(this);
    this.dF = ((Button)findViewById(2131380250));
    this.dF.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$a = new a();
    this.j.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$a);
    this.bLt = (getResources().getDimensionPixelSize(2131297548) * 2);
    this.bLt += this.vo.getPaddingLeft() + this.vo.getPaddingRight();
    this.bLt += getResources().getDimensionPixelSize(2131299673) * 2;
    this.bwf = getResources().getDimensionPixelSize(2131299671);
    bWv();
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TroopManager)localObject).b(this.mTroopUin))
    {
      this.b = ((TroopInfo)localObject);
      a(this.b, true);
      return;
    }
  }
  
  private void bKX()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    String str = acfp.m(2131715644);
    localTextView1.setText(getString(2131691982, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131721079);
    localTextView3.setText(2131721058);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new vyq(this, localReportDialog));
    localTextView3.setOnClickListener(new vyr(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void bKY()
  {
    String str1 = getString(2131692811);
    String str2 = getString(2131691981);
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(str1);
    localaqju.setMessage(str2);
    localaqju.setPositiveButton(getString(2131691980), new vys(this, localaqju));
    localaqju.setPositiveButtonContentDescription(getString(2131692241));
    localaqju.setNegativeButton(getString(2131721058), new vyt(this));
    localaqju.setNegativeButtonContentDescription(getString(2131692240));
    localaqju.show();
    anot.a(this.app, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
  }
  
  public void a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    this.b = paramTroopInfo;
    if (this.b != null)
    {
      this.aKI = this.b.troopcode;
      this.mTroopName = this.b.getTroopName();
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "initTroopTips groupInfo mTroopUin =" + this.mTroopUin + ", wMemberNum=" + this.b.wMemberNum + ", troopCreateTime = " + this.b.troopCreateTime);
      }
      this.FY.setText(String.format(getString(2131721327), new Object[] { Integer.valueOf(this.b.wMemberNum) }));
      if (this.b.wMemberNum <= 1)
      {
        this.FZ.setText(2131721334);
        this.FX.setText(2131721329);
        this.rr.setVisibility(8);
        this.vn.setClickable(false);
        this.vo.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$a.bWw();
        this.dE.setVisibility(8);
        return;
      }
      this.rr.setVisibility(0);
      if (AppSetting.enableTalkBack) {
        this.vo.setClickable(false);
      }
      for (;;)
      {
        this.vn.setOnClickListener(this);
        this.FZ.setText(2131721333);
        this.FX.setText(2131721328);
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$a.ga(this.b.getSomeMemberUins());
        ThreadManager.post(new TroopDisbandActivity.1(this), 5, null, true);
        return;
        this.vo.setOnClickListener(this);
      }
    }
    this.FY.setText("");
    this.FZ.setText("");
    this.rr.setVisibility(8);
    this.vn.setClickable(false);
  }
  
  protected void bWv()
  {
    int i = 125;
    int m = getResources().getDisplayMetrics().widthPixels;
    int k = (m - this.bLt - this.bwf * 5) / 6;
    if (k > 125) {}
    for (;;)
    {
      this.j.setColumnWidth(i);
      ViewGroup.LayoutParams localLayoutParams = this.j.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + 4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$a.BJ(i);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|width = " + m + ", columnWidth = " + i);
        QLog.i("Q.troopdisband.disband", 2, "initListItemSize|list.width = " + this.j.getWidth() + ", list.height = " + this.j.getHeight());
      }
      return;
      i = k;
    }
  }
  
  protected void checkParams()
  {
    Bundle localBundle = getIntent().getExtras();
    this.mTroopUin = localBundle.getString("troop_uin");
    this.aKI = localBundle.getString("troop_code");
    this.mTroopName = localBundle.getString("uinname");
    this.Ha = localBundle.getLong("TROOP_INFO_FLAG_EXT");
    this.bFL = localBundle.getInt("troop_auth_submit_time");
    this.mFrom = localBundle.getString("from");
    try
    {
      long l = Long.parseLong(this.mTroopUin);
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.disband", 2, "troopuin = " + l + " is illegal");
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.disband", 2, localException.toString());
        }
        finish();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onCreate intent params mTroopUin= " + this.mTroopUin + ", mTroopName=" + this.mTroopName + ", mTroopCode= " + this.aKI);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewB(2131561754);
    setTitle(2131717262);
    checkParams();
    this.Hb = 0L;
    this.pG = new ArrayList();
    this.mSelfUin = this.app.getCurrentAccountUin();
    addObserver(this.jdField_a_of_type_Acnd);
    addObserver(this.c);
    Ad();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Acnd);
    removeObserver(this.c);
    if (this.jdField_a_of_type_Arib != null)
    {
      this.jdField_a_of_type_Arib.dismiss();
      this.jdField_a_of_type_Arib = null;
    }
    super.doOnDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if ((paramInt1 == 0) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, "onActivityResult|REQUEST_FOR_TROOP_TRANSFER|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if (!bool) {
        break label127;
      }
      localIntent = new Intent();
      localIntent.putExtra("fin_tip_msg", str);
      localIntent.putExtra("uin", paramIntent);
      setResult(paramInt2, localIntent);
      finish();
    }
    label127:
    while (TextUtils.isEmpty(str))
    {
      Intent localIntent;
      return;
    }
    if (this.jdField_a_of_type_Arib == null) {
      this.jdField_a_of_type_Arib = new arib(this);
    }
    this.jdField_a_of_type_Arib.aa(1, str, 1500);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131380251: 
    case 2131380255: 
      if (this.b != null) {}
      for (String str = this.b.troopuin;; localObject = this.mTroopUin)
      {
        for (;;)
        {
          startActivity(TroopMemberListActivity.c(this, str, 4));
          try
          {
            anot.a(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, str, "1", "0", "");
          }
          catch (Exception localException1) {}
        }
        break;
      }
    case 2131380404: 
      if ((this.b == null) || (this.b.wMemberNum > 1)) {
        break;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (this.jdField_a_of_type_Arib == null) {
        this.jdField_a_of_type_Arib = new arib(this);
      }
      if ((i != 0) && (aqiw.isNetSupport(this)))
      {
        localObject = (acms)this.app.getBusinessHandler(20);
        if (localObject != null) {
          if ((this.bFO & 0x2) != 0) {}
        }
      }
      for (;;)
      {
        try
        {
          long l = Long.parseLong(this.mTroopUin);
          this.bFO |= 0x2;
          this.Hb = 0L;
          this.pG.clear();
          ((acms)localObject).a(l, this.Hb, 4, 0, 0);
          this.jdField_a_of_type_Arib.aq(0, 2131721325, 1000);
          anot.a(this.app, "CliOper", "", "", "Grp", "Clk_transgrp", 0, 0, "", "", "", "");
          if (!"troopMemberCardMoreInfoPage".equals(this.mFrom)) {
            break;
          }
          new anov(this.app).a("dc00899").b("Grp_mem_card").c("more").d("transfer_clk").a(new String[] { this.mTroopUin }).report();
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.troopdisband.disband", 2, localException2.toString());
          continue;
        }
        this.jdField_a_of_type_Arib.aq(2, 2131721326, 1500);
        continue;
        if (i != 0) {
          this.jdField_a_of_type_Arib.aq(2, 2131696348, 1500);
        } else {
          this.jdField_a_of_type_Arib.aq(2, 2131721330, 1500);
        }
      }
      if (((this.Ha & 0x800) != 0L) || (this.bFL != 0)) {
        bKX();
      }
      for (;;)
      {
        if (!"troopMemberCardMoreInfoPage".equals(this.mFrom)) {
          break label541;
        }
        new anov(this.app).a("dc00899").b("Grp_mem_card").c("more").d("dissolve_clk").a(new String[] { this.mTroopUin }).report();
        break;
        bKY();
      }
      label541:
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    bWv();
  }
  
  public class a
    extends BaseAdapter
  {
    protected int mItemSize;
    protected List<String> mList = new ArrayList();
    
    public a()
    {
      this.mList.add("0");
    }
    
    public void BJ(int paramInt)
    {
      this.mItemSize = paramInt;
    }
    
    public void bWw()
    {
      if ((this.mList.size() == 1) && (this.mList.contains(TroopDisbandActivity.this.mSelfUin))) {
        return;
      }
      this.mList.clear();
      this.mList.add(TroopDisbandActivity.this.mSelfUin);
      notifyDataSetChanged();
    }
    
    public void ga(List<String> paramList)
    {
      if (paramList != null) {}
      for (int i = paramList.size();; i = 0)
      {
        if (i > 0)
        {
          this.mList.clear();
          this.mList.addAll(paramList);
          notifyDataSetChanged();
        }
        return;
      }
    }
    
    public int getCount()
    {
      int i = this.mList.size();
      if (i > 6) {
        return 6;
      }
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      Object localObject2;
      if (paramView == null)
      {
        localObject1 = new ImageView(TroopDisbandActivity.this);
        ((ImageView)localObject1).setLayoutParams(new AbsListView.LayoutParams(this.mItemSize, this.mItemSize));
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((ImageView)localObject1).setAdjustViewBounds(true);
        paramView = (View)localObject1;
        localObject2 = (String)getItem(paramInt);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("0"))) {
          break label156;
        }
        paramView.setImageDrawable(aqhu.at());
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject1 = (ImageView)paramView;
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.mItemSize;
          ((ViewGroup.LayoutParams)localObject2).height = this.mItemSize;
        }
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        break;
        label156:
        paramView.setImageDrawable(aqdj.a(TroopDisbandActivity.this.app, (String)localObject2, (byte)1));
      }
    }
    
    public boolean hr(String paramString)
    {
      return this.mList.contains(paramString);
    }
    
    public void setData(List<oidb_0x899.memberlist> paramList)
    {
      int i;
      int j;
      label26:
      Object localObject;
      if (paramList != null)
      {
        i = paramList.size();
        if (i <= 0) {
          return;
        }
        this.mList.clear();
        j = 0;
        if (j >= i) {
          break label113;
        }
        localObject = (oidb_0x899.memberlist)paramList.get(j);
        if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {
          break label71;
        }
      }
      for (;;)
      {
        j += 1;
        break label26;
        i = 0;
        break;
        label71:
        localObject = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
        if (!this.mList.contains(localObject)) {
          this.mList.add(localObject);
        }
      }
      label113:
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity
 * JD-Core Version:    0.7.0.1
 */