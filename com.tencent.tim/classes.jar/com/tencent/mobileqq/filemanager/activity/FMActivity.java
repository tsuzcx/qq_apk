package com.tencent.mobileqq.filemanager.activity;

import acbn;
import acej;
import acfp;
import acms;
import acnd;
import agbg;
import agbh;
import agbi;
import agbj;
import agbk;
import agfj;
import aghw;
import agil;
import agmz;
import ahbo;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anpc;
import aoaf;
import aqha;
import aqju;
import aqmr;
import avhc;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import wja;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long Yh;
  View CL = null;
  public View O = null;
  public TextView Se = null;
  TextView Sf = null;
  public final String TAG = "FMActivity<FileAssistant>";
  long Yi;
  agfj jdField_a_of_type_Agfj = null;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  a jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$a = null;
  public VerifyPwdView a;
  public QfileTabBarView a;
  private BroadcastReceiver bd;
  int cWA;
  int cWB = -1;
  private int cWC;
  public int cWx = -1;
  int cWy = -1;
  public int cWz;
  public boolean ccG = false;
  boolean ccH = false;
  boolean ccI;
  public LinearLayout iQ = null;
  RelativeLayout kj = null;
  public RelativeLayout kk = null;
  int mCurType;
  private int mEntranceType;
  String mTroopUin = null;
  String mUin;
  public RadioButton q = null;
  public RadioButton r = null;
  public RadioButton s = null;
  TextView titleLeftBtn = null;
  private float x;
  private float y;
  
  public FMActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
  }
  
  private void MJ(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131367039));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    int i;
    if (this.aWg)
    {
      i = 1;
      ((QfileTabBarView)localObject).setWYSubAppId(i);
      if (akI()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setMemory(true);
      }
      deU();
      if ((!akI()) || (paramInt == 5) || (paramInt == 8) || (this.ccC)) {
        break label325;
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131376846));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      if (this.Se != null) {
        this.Se.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
        deW();
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
      deV();
      if (!this.ccH) {
        break label222;
      }
      deX();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 0);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.cWz == 0) && (this.aWg)) {
        this.iQ.setVisibility(0);
      }
    }
    label222:
    do
    {
      return;
      i = 2;
      break;
      if ((this.ccG) || (this.ccH)) {
        break label325;
      }
      this.q.setChecked(true);
      deY();
      localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
      if ((this.cWz == 0) && (this.aWg)) {
        this.iQ.setVisibility(0);
      }
    } while (!this.ccF);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.removeView(this.s);
    return;
    label325:
    if (this.ccI)
    {
      findViewById(2131376846).setVisibility(8);
      findViewById(2131370827).setVisibility(0);
    }
    deM();
    this.bGk = getString(2131693551);
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 0: 
      this.bGk = getString(2131691407);
    case 6: 
    case 7: 
      setTitle(this.bGk);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.r.setSelected(true);
      }
      deX();
      return;
    case 2: 
    case 3: 
      this.bGk = getString(2131693508);
      setTitle(this.bGk);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.s.setSelected(true);
      }
      NP(paramInt);
      return;
    case 1: 
      this.bGk = this.bGl;
      if ((this.cWz == 0) && (this.aWg)) {
        this.iQ.setVisibility(0);
      }
    case 5: 
      if (this.bGl == null) {
        this.bGk = getString(2131693534);
      }
      setTitle(this.bGk);
      if ((this.jdField_a_of_type_AndroidWidgetRadioGroup != null) && (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() == 0)) {
        this.q.setSelected(true);
      }
      deY();
      if ((akI()) && ((this.ccC) || (this.tabType == 5)))
      {
        this.titleLeftBtn = ((TextView)findViewById(2131369579));
        setLeftViewName(2131693605);
        this.titleLeftBtn.setOnClickListener(this);
        if (this.cWA <= 0) {
          break label731;
        }
        this.titleLeftBtn.setVisibility(4);
        this.titleLeftBtn.setOnClickListener(null);
      }
      for (;;)
      {
        localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
        ((SharedPreferences.Editor)localObject).commit();
        if (DX() != 8) {
          break;
        }
        this.titleLeftBtn.setVisibility(4);
        return;
        label731:
        this.titleLeftBtn.setVisibility(0);
      }
    }
    this.bGk = acfp.m(2131706370);
    setTitle(this.bGk);
    this.titleLeftBtn = ((TextView)findViewById(2131369579));
    setLeftViewName(2131690700);
    getRightTextView().setVisibility(8);
    dfe();
  }
  
  private void NN(int paramInt)
  {
    if (!akR())
    {
      if (this.CL.getVisibility() == 0) {
        this.CL.setVisibility(8);
      }
      this.cWC = 0;
      return;
    }
    if (paramInt == 0)
    {
      this.CL.setVisibility(8);
      this.cWC = 0;
      return;
    }
    String str = "";
    switch (paramInt)
    {
    }
    while (!TextUtils.isEmpty(str))
    {
      this.CL.setVisibility(0);
      this.Sf.setText(str);
      return;
      str = getString(2131693574);
      this.cWC = 1;
      continue;
      str = getString(2131693577);
      this.cWC = 3;
      continue;
      str = getString(2131693573);
      this.cWC = 2;
      continue;
      str = getString(2131693576);
      this.cWC = 4;
    }
    this.CL.setVisibility(8);
    this.cWC = 0;
  }
  
  private void NO(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 1) && (paramInt != 2) && (paramInt != 4))
    {
      this.cWB = 10;
      return;
    }
    if ((paramInt == 8) && (jD(8)))
    {
      this.cWB = 10;
      return;
    }
    if ((paramInt == 1) && (jD(1)))
    {
      this.cWB = 12;
      return;
    }
    if ((paramInt == 2) && (jD(2)))
    {
      this.cWB = 13;
      return;
    }
    if ((paramInt == 4) && (jD(4)))
    {
      this.cWB = 9;
      return;
    }
    this.cWB = 10;
  }
  
  private void NP(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    anot.a(this.app, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
    NN(0);
    this.cWC = 3;
    if (3 == paramInt) {
      deL();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.O = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.kk, new agbj(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.ga();
    this.kk.addView(this.O);
    this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private boolean akR()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.mEntranceType != 11)
    {
      bool1 = bool2;
      if (this.mEntranceType != 1)
      {
        bool1 = bool2;
        if (this.mEntranceType != 3)
        {
          bool1 = bool2;
          if (this.mEntranceType != 5)
          {
            bool1 = bool2;
            if (this.mEntranceType != 4) {
              if (this.mEntranceType != 20) {
                break label75;
              }
            }
          }
        }
      }
    }
    label75:
    for (bool1 = bool2;; bool1 = false)
    {
      if (!akL()) {
        return false;
      }
      return bool1;
    }
  }
  
  private void chy()
  {
    acms localacms = (acms)this.app.getBusinessHandler(20);
    if (localacms != null) {}
    try
    {
      localacms.a(Long.parseLong(this.mTroopUin), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FMActivity<FileAssistant>", 2, localException.toString());
    }
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (akI())
    {
      bool1 = bool2;
      if (this.tabType != 5)
      {
        bool1 = bool2;
        if (paramSharedPreferences.getBoolean("last_select_All", false))
        {
          bool1 = bool2;
          if (paramSharedPreferences.getBoolean("last_select_send", false)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void deS()
  {
    aqju localaqju = aqha.a(this, 230);
    localaqju.setMessage(2131699882);
    localaqju.setTitle(2131699885);
    localaqju.setNegativeButton(getString(2131699884), new agbg(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    if (!isFinishing()) {
      localaqju.show();
    }
  }
  
  private void deT()
  {
    this.q = ((RadioButton)findViewById(2131370831));
    this.r = ((RadioButton)findViewById(2131376844));
    this.s = ((RadioButton)findViewById(2131364803));
    String str1 = acbn.SDCARD_ROOT + "/Tencent/MicroMsg/Download/";
    String str2 = acbn.SDCARD_ROOT + "/Tencent/MicroMsg/WeiXin/";
    new File(str1);
    new File(str2);
  }
  
  private void deU()
  {
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from")))
    {
      setLeftViewName(2131693537);
      return;
    }
    if ((this.mUin != null) && (this.mUin.trim().length() != 0) && (this.mCurType != -1))
    {
      setLeftViewName(2131691436);
      return;
    }
    setLeftViewName(2131690700);
  }
  
  private void deV()
  {
    if (acej.aV() > 17.0F)
    {
      float f = getResources().getDisplayMetrics().density;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(55.0F * f), (int)(f * 30.0F));
      this.s.setLayoutParams(localLayoutParams);
      this.s.setTextSize(14.0F);
      this.q.setLayoutParams(localLayoutParams);
      this.q.setTextSize(14.0F);
      this.r.setLayoutParams(localLayoutParams);
      this.r.setTextSize(14.0F);
    }
  }
  
  private void deW()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new agbi(this);
  }
  
  private void deX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.mUin);
    }
    if (this.ccF)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(4, getString(2131693846));
      if (!this.ccF) {
        break label228;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(4);
    }
    for (;;)
    {
      NN(1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.lR == 1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.OW(8);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(3, getString(2131693844));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(4, getString(2131693846));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(21, getString(2131693851));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(5, getString(2131693850));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(6, getString(2131693847));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(7, getString(2131693845));
      break;
      label228:
      if ((this.ccG) && (this.tabType == 0) && (this.cWx >= 3) && (this.cWx <= 7)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWx);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
      }
    }
  }
  
  private void deY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    NN(2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    deZ();
    dfa();
    int i = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1);
    if ((this.ccG) && ((this.tabType == 1) || (i == 1)) && (this.cWx >= 8) && (this.cWx <= 14)) {
      if (this.cWA <= 0) {
        if ((this.cWx == 11) || (this.cWx == 9) || (this.cWx == 10) || (this.cWx == 8) || (this.cWx == 14)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWx);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWB);
      continue;
      if (7 != this.cWy)
      {
        if (this.cWA <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWB);
        }
      }
      else if (this.cWB != -1) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWB);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(9);
      }
    }
  }
  
  private void deZ()
  {
    if (akL())
    {
      if (this.Se == null) {
        this.Se = ((TextView)findViewById(2131370829));
      }
      this.Se.setOnClickListener(this);
      this.Se.setVisibility(0);
      if (this.cWA <= 0)
      {
        this.Se.setVisibility(0);
        deM();
      }
    }
    do
    {
      return;
      this.Se.setVisibility(4);
      this.Se.setOnClickListener(null);
      break;
      C(this);
    } while (this.Se == null);
    this.Se.setVisibility(8);
  }
  
  private void dfa()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    if (this.cWA <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(11, getString(2131693847));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(9, getString(2131693850));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(10, getString(2131693846));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(8, getString(2131693845));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(14, getString(2131693849));
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      if (jD(8))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(10, getString(2131693846));
        localArrayList.add(Integer.valueOf(10));
      }
      if (jD(4))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(9, getString(2131693850));
        localArrayList.add(Integer.valueOf(9));
      }
      if (jD(2))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(13, getString(2131693853));
        localArrayList.add(Integer.valueOf(13));
      }
      if (jD(1))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(12, getString(2131693848));
        localArrayList.add(Integer.valueOf(12));
      }
    } while (localArrayList.size() != 1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.OW(8);
  }
  
  private void dfb()
  {
    if ((this.ccz) || (this.ccB))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.bd == null)
      {
        this.bd = new agbk(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.bd, localIntentFilter);
      }
    }
  }
  
  private void dfc()
  {
    if (this.bd != null)
    {
      this.app.getApp().unregisterReceiver(this.bd);
      this.bd = null;
    }
  }
  
  private void dfd()
  {
    ArrayList localArrayList2 = null;
    Object localObject = agmz.D();
    ArrayList localArrayList1 = localArrayList2;
    if (localObject != null)
    {
      localArrayList1 = localArrayList2;
      if (((Set)localObject).size() > 0)
      {
        localArrayList2 = new ArrayList();
        localObject = ((Set)localObject).iterator();
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArrayList2.add(((FileInfo)((Iterator)localObject).next()).getPath());
        }
      }
    }
    this.app.a().a(this, localArrayList1, 15, 0, true, this.mTroopUin);
  }
  
  private void dfe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    deM();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(111, getString(2131693853));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(119, getString(2131693850));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(110, getString(2131693846));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(118, getString(2131693845));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.k(114, getString(2131693849));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(111);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  public void IM(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int i = 0;
    if (paramBoolean) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int j = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(j - i);
  }
  
  public int[] R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.R();
  }
  
  public void a(agfj paramagfj)
  {
    this.jdField_a_of_type_Agfj = paramagfj;
    if (this.tabType == 8) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectEvent(this.jdField_a_of_type_Agfj);
    }
  }
  
  public ListView b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    }
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.dmS();
      if (paramMotionEvent.getAction() != 0) {
        break label43;
      }
      this.x = paramMotionEvent.getX();
      this.y = paramMotionEvent.getY();
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label43:
      if (paramMotionEvent.getAction() == 2)
      {
        QLog.e("@@@@@", 1, new Object[] { "ev.getY(" + paramMotionEvent.getY() + "),", "y: " + this.y + " ,ev.getX(" + paramMotionEvent.getX() + "),x: " + this.x + "  " + (paramMotionEvent.getY() - this.y) + "," + Math.abs(paramMotionEvent.getX() - this.x) });
        if ((paramMotionEvent.getY() - this.y < -200.0F) && (Math.abs(paramMotionEvent.getX() - this.x) < 200.0F)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.Km(false);
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9999) {
      if (paramIntent != null) {}
    }
    do
    {
      return;
      if (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1)
      {
        setResult(paramInt2, new Intent(paramIntent));
        finish();
      }
      if ((paramInt2 != -1) || (this.mUin == null) || (this.mUin.trim().length() == 0)) {
        break;
      }
    } while (((paramIntent == null) || (paramIntent.getExtras() == null) || ((paramIntent.getBooleanExtra("foward_editbar", false) != true) && (paramIntent.getBooleanExtra("destroy_last_activity", false) != true))) && (paramInt2 != 4));
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
    return;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Yh += 1L;
    this.Yi = Yh;
    agmz.clearSelected();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.tabType = paramBundle.getIntExtra("tab_tab_type", -1);
    this.cWy = paramBundle.getIntExtra("busiType", -1);
    this.mUin = paramBundle.getStringExtra("uin");
    this.mCurType = paramBundle.getIntExtra("uintype", -1);
    this.ccz = paramBundle.getBooleanExtra("from_qlink", false);
    this.aWg = paramBundle.getBooleanExtra("from_aio", false);
    this.cWz = paramBundle.getIntExtra("peerType", -1);
    this.ccI = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.mEntranceType = paramBundle.getIntExtra("qfile_entrance_type_key", 0);
    this.mTroopUin = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.tabType + "],select[" + akI() + "]");
    }
    this.ccA = false;
    if (acbn.bkw.equalsIgnoreCase(this.mTroopUin)) {
      this.ccA = true;
    }
    this.cWA = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.cWA & 0xF) == 0) {
      this.cWA = 0;
    }
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if (d(localSharedPreferences))
    {
      this.ccH = true;
      NO(paramBundle.getIntExtra("smart_device_switch_tab_flag", 0));
      paramBundle = localSharedPreferences.edit();
      paramBundle.putBoolean("last_select_All", false);
      paramBundle.putBoolean("last_select_send", false);
      paramBundle.commit();
      if ((!TextUtils.isEmpty(this.mUin)) && (this.mCurType == -1)) {
        IP(true);
      }
      int i = getResources().getDisplayMetrics().heightPixels;
      if ((!akI()) || (this.tabType == 5) || (this.tabType == 8) || (this.tabType == 6) || (this.ccC)) {
        break label716;
      }
      NM(2131561009);
      ((LinearLayout)findViewById(2131367045)).setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
      if ((ImmersiveUtils.isSupporImmersive() != 1) || (!akL())) {}
    }
    for (;;)
    {
      this.kk = ((RelativeLayout)findViewById(2131371085));
      this.iQ = ((LinearLayout)findViewById(2131374700));
      this.iQ.setOnClickListener(new agbh(this));
      this.CL = findViewById(2131379229);
      this.kj = ((RelativeLayout)findViewById(2131379228));
      this.kj.setOnClickListener(this);
      this.Sf = ((TextView)findViewById(2131377833));
      NN(0);
      if ((!TextUtils.isEmpty(this.mUin)) && (this.mCurType == -1))
      {
        setLeftViewName(2131721490);
        if (this.rightViewText != null) {
          this.rightViewText.setVisibility(8);
        }
      }
      deT();
      MJ(this.tabType);
      this.app.a().dgn();
      dfb();
      this.app.a().a().dgD();
      return true;
      if ((!this.aWg) && (this.tabType != 5) && (!this.ccA) && (paramBundle.getIntExtra("approval_attachment_customid", -1) == -1)) {
        break;
      }
      if (this.tabType == -1) {
        this.tabType = localSharedPreferences.getInt("last_select_tab_type", -1);
      }
      this.cWx = localSharedPreferences.getInt("last_select_tab_view", -1);
      if ((this.tabType == -1) || (this.cWx == -1)) {
        break;
      }
      this.ccG = true;
      break;
      label716:
      setContentView(2131561009);
      ((RelativeLayout)findViewById(2131377498)).setVisibility(8);
      paramBundle = (LinearLayout)findViewById(2131367045);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    this.app.a().aIH();
    this.app.a().dgm();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.finish();
    }
    if (this.Yi == Yh) {
      agmz.clearSelected();
    }
    dfc();
    if (this.ccB)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$a != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$a);
    }
    if (this.jdField_a_of_type_Agfj != null) {
      this.jdField_a_of_type_Agfj.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.mTroopUin != null))
    {
      acms localacms = (acms)this.app.getBusinessHandler(20);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$a = new a();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity$a);
      localacms.Fg(this.mTroopUin);
    }
    super.doOnResume();
  }
  
  public int eA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return super.eA();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.eA();
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.ei(paramArrayList);
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.ej(paramArrayList);
  }
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.ek(paramArrayList);
  }
  
  public void finish()
  {
    super.finish();
    if (akI()) {
      overridePendingTransition(2130771989, 2130771990);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean jD(int paramInt)
  {
    return (this.cWA & paramInt) > 0;
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.m(paramSet);
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    super.onClick(paramView);
    if (!H()) {}
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aM();
      if ((paramView.getId() == 2131370829) || (paramView.getId() == 2131369579))
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(aoaf.cjs, this.ccF);
        ((Intent)localObject).putExtra(aoaf.cjt, this.bGn);
        ((Intent)localObject).putExtra("qrlogin_appid", this.Yg);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041717);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_MyFile_Category", true);
        ((Intent)localObject).putExtra("select_file_support_send_docs_file", this.ccE);
        ((Intent)localObject).putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.amW());
        a().dlZ();
        startActivityForResult((Intent)localObject, paramView.getId());
        overridePendingTransition(2130772288, 2130772291);
      }
      else if (paramView.getId() == 2131377775)
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(aoaf.cjs, this.ccF);
        ((Intent)localObject).putExtra(aoaf.cjt, this.bGn);
        ((Intent)localObject).putExtra("qrlogin_appid", this.Yg);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        a().dmg();
        startActivityForResult((Intent)localObject, paramView.getId());
        anpc.report("tim_mine_tab_file_click_local_file_click_sd_card");
      }
      else if ((paramView.getId() == 2131379228) && (this.cWC != 0))
      {
        localObject = new ArrayList();
        switch (this.cWC)
        {
        }
      }
    }
    for (int j = 16;; j = 17)
    {
      anot.a(null, "dc00898", "", "", "0X800AA90", "0X800AA90", i, 0, "0", "0", "", "");
      Bundle localBundle = new Bundle();
      localBundle.putString("qfile_search_param_ex_params_target_uin", uV());
      localBundle.putInt("qfile_search_param_exparams_peer_type", DW());
      localBundle.putInt("qfile_search_param_exparams_busi_type", DX());
      localBundle.putString("qfile_search_param_exparams_send_uin", uW());
      localBundle.putInt("qfile_search_param_exparams_qlink_state", DZ());
      localBundle.putBoolean("qfile_search_param_exparams_qlink_ap_created", akJ());
      FileSearchActivity.a(this, "", (List)localObject, false, j, "", localBundle);
      break;
      i = 2;
    }
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Agfj != null) {
      this.jdField_a_of_type_Agfj.onRestart();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  public void onResume()
  {
    if (agmz.fN() > 0L) {
      deR();
    }
    if (this.jdField_a_of_type_Agfj != null) {
      this.jdField_a_of_type_Agfj.onResume();
    }
    super.onResume();
  }
  
  public void refreshUI()
  {
    super.refreshUI();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.refreshUI();
  }
  
  protected void resetUI()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.refreshUI();
  }
  
  public void setSortType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null)
    {
      super.setSortType(paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSortType(paramInt);
  }
  
  class a
    extends acnd
  {
    boolean ccJ = false;
    
    a() {}
    
    public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      paramString = new StringBuilder(150);
      paramString.append("onTroopPrivilege").append("| isSuccess = ").append(paramBoolean1).append("| isAdmin = ").append(paramBoolean2).append("| isAllUser_Photo = ").append(paramBoolean3).append("| isAllUser_File = ").append(paramBoolean4);
      if (QLog.isColorLevel()) {
        QLog.i("FMActivity<FileAssistant>", 2, paramString.toString());
      }
      if ((paramBoolean1) && (!paramBoolean4))
      {
        this.ccJ = true;
        FMActivity.a(FMActivity.this);
      }
    }
    
    public void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
    {
      if (!this.ccJ) {}
      label173:
      label231:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.ccJ = false;
            } while (FMActivity.this.mTroopUin == null);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder(150);
              ((StringBuilder)localObject1).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
              QLog.i("FMActivity<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
            }
          } while ((paramInt1 != 2) || (!paramBoolean));
          localObject1 = (TroopManager)FMActivity.this.app.getManager(52);
          paramString = ((TroopManager)localObject1).c(FMActivity.this.mTroopUin);
        } while ((paramString == null) || (aqmr.isEmpty(paramString.troopowneruin)));
        paramString.Administrator = "";
        Object localObject2;
        if (paramList == null)
        {
          paramInt1 = 0;
          paramInt2 = 0;
          if (paramInt2 >= paramInt1) {
            break label314;
          }
          localObject2 = (oidb_0x899.memberlist)paramList.get(paramInt2);
          if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
            break label231;
          }
        }
        for (;;)
        {
          paramInt2 += 1;
          break label173;
          paramInt1 = paramList.size();
          break;
          localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
          if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!paramString.troopowneruin.equals(((String)localObject2).trim()))) {
            paramString.Administrator = (paramString.Administrator + (String)localObject2 + "|");
          }
        }
        ((TroopManager)localObject1).i(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("FMActivity<FileAssistant>", 2, paramString.Administrator);
        }
        if ((paramString.troopPrivilegeFlag & 0x2) == 2L) {
          break;
        }
        paramInt1 = 1;
        paramList = FMActivity.this.app.getCurrentAccountUin();
      } while ((paramString.isTroopAdmin(paramList)) || (paramString.isTroopOwner(paramList)) || (paramInt1 != 0));
      label314:
      paramString = FMActivity.this.app;
      Object localObject1 = FMActivity.this.mTroopUin;
      if (FMActivity.this.aWg) {}
      for (paramList = "0";; paramList = "1")
      {
        anot.a(paramString, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, (String)localObject1, paramList, "", "");
        FMActivity.b(FMActivity.this);
        return;
        paramInt1 = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */