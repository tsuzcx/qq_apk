package com.tencent.tim.filemanager.activity;

import acbn;
import acms;
import acnd;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import anot;
import aqha;
import aqju;
import aqmr;
import atnv;
import atnw;
import atnx;
import atny;
import atnz;
import atqs;
import atsk;
import atso;
import atwb;
import ault;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.QfileEditBottomBar;
import com.tencent.tim.filemanager.widget.QfileTabBarView;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import com.tencent.tim.timfiletab.fragment.TimFileWebViewFragment;
import com.tencent.tim.timfiletab.fragment.TimFileWebViewFragment.a;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import wja;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener, TimFileWebViewFragment.a
{
  public static ArrayList<String> Eh;
  static long Yh;
  public static final String cHO = BaseApplication.getContext().getString(2131693551);
  public static final String cHP = BaseApplication.getContext().getString(2131693509);
  public static final String cHQ = BaseApplication.getContext().getString(2131693533);
  public static final String cHR = BaseApplication.getContext().getString(2131693508);
  public View KD;
  public View O = null;
  public TextView Se = null;
  public final String TAG = "FMActivity<FileAssistant>";
  long Yi;
  Spinner jdField_a_of_type_AndroidWidgetSpinner = null;
  atqs jdField_a_of_type_Atqs = null;
  a jdField_a_of_type_ComTencentTimFilemanagerActivityFMActivity$a = null;
  public VerifyPwdView a;
  public QfileTabBarView a;
  public TimFileWebViewFragment a;
  public boolean aWg;
  AdapterView.OnItemSelectedListener b = null;
  public int bQb = 0;
  private BroadcastReceiver bd;
  private String cHN;
  int cWA;
  int cWB = -1;
  public int cWx = -1;
  int cWy = -1;
  int cWz;
  public boolean ccG = false;
  boolean ccH = false;
  FrameLayout cr = null;
  public boolean dit;
  public boolean diu;
  private boolean div = true;
  public RelativeLayout kk = null;
  int mCurType;
  View mTitleBar = null;
  String mTroopUin = null;
  String mUin;
  RelativeLayout nz;
  TextView titleLeftBtn = null;
  
  static
  {
    Eh = new ArrayList();
    Eh.add(cHO);
    Eh.add(cHP);
    Eh.add(cHQ);
    Eh.add(cHR);
  }
  
  public FMActivity()
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView = null;
  }
  
  private void MJ(int paramInt)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131367039));
    this.KD = findViewById(2131382161);
    this.mTitleBar = findViewById(2131377498);
    this.cHN = getIntent().getStringExtra("select_file_team_id");
    if (akI()) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setMemory(true);
    }
    if (this.ccz) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setFilterCloudType(5);
    }
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
      setLeftViewName(2131693537);
    }
    Object localObject;
    while ((akI()) && (paramInt != 5) && (paramInt != 9) && (!this.ccC) && (!this.dip) && (!this.diq) && (!this.dir))
    {
      this.jdField_a_of_type_AndroidWidgetSpinner = ((Spinner)findViewById(2131376846));
      euo();
      localObject = new ArrayAdapter(this, 2131559335, 2131379402, Eh);
      this.jdField_a_of_type_AndroidWidgetSpinner.setAdapter((SpinnerAdapter)localObject);
      this.jdField_a_of_type_AndroidWidgetSpinner.setVisibility(0);
      if (this.b == null) {
        deW();
      }
      this.jdField_a_of_type_AndroidWidgetSpinner.setOnItemSelectedListener(this.b);
      if (this.ccH)
      {
        this.jdField_a_of_type_AndroidWidgetSpinner.setSelection(Eh.indexOf(cHO));
        deX();
        localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 0);
        ((SharedPreferences.Editor)localObject).commit();
        return;
        if ((this.mUin != null) && (this.mUin.trim().length() != 0) && (this.mCurType != -1)) {
          setLeftViewName(2131691436);
        } else if (paramInt == 8) {
          setLeftViewName(2131691665);
        } else {
          setLeftViewName(2131690700);
        }
      }
      else if ((!this.ccG) && (!this.ccH))
      {
        this.jdField_a_of_type_AndroidWidgetSpinner.setSelection(Eh.indexOf(cHQ));
        deY();
        localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
        ((SharedPreferences.Editor)localObject).commit();
        return;
      }
    }
    deM();
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return;
    case 0: 
    case 6: 
    case 7: 
      if (paramInt == 0) {
        this.bGk = getString(2131691407);
      }
      for (;;)
      {
        setTitle(this.bGk);
        if ((this.jdField_a_of_type_AndroidWidgetSpinner != null) && (this.jdField_a_of_type_AndroidWidgetSpinner.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidWidgetSpinner.setSelection(Eh.indexOf(cHO));
        }
        deX();
        return;
        if (paramInt == 6) {
          this.bGk = getString(2131693548);
        } else {
          this.bGk = getString(2131693551);
        }
      }
    case 2: 
    case 3: 
      eup();
      this.bGk = getString(2131693508);
      setTitle(this.bGk);
      if ((this.jdField_a_of_type_AndroidWidgetSpinner != null) && (this.jdField_a_of_type_AndroidWidgetSpinner.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidWidgetSpinner.setSelection(Eh.indexOf(cHP));
      }
      if (this.diu) {
        setLeftViewName(2131690700);
      }
      for (;;)
      {
        aaB(paramInt);
        return;
        setLeftViewName(2131691665);
      }
    case 1: 
    case 5: 
      if (this.bGl == null)
      {
        this.bGk = getString(2131693533);
        setTitle(this.bGk);
        if ((this.jdField_a_of_type_AndroidWidgetSpinner != null) && (this.jdField_a_of_type_AndroidWidgetSpinner.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidWidgetSpinner.setSelection(Eh.indexOf(cHQ));
        }
        deY();
        setLeftViewName(2131691665);
        if ((akI()) && ((this.ccC) || (this.tabType == 5)))
        {
          this.titleLeftBtn = ((TextView)findViewById(2131369579));
          setLeftViewName(2131690700);
          this.titleLeftBtn.setOnClickListener(this);
          if (this.cWA <= 0) {
            break label874;
          }
          this.titleLeftBtn.setVisibility(4);
          this.titleLeftBtn.setOnClickListener(null);
        }
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
        this.bGk = this.bGl;
        break label681;
        this.titleLeftBtn.setVisibility(0);
      }
    case 9: 
      label681:
      label874:
      this.bGk = "选择已下载的文件";
      setTitle(this.bGk);
      this.titleLeftBtn = ((TextView)findViewById(2131369579));
      setLeftViewName(2131690700);
      getRightTextView().setVisibility(8);
      dfe();
      return;
    }
    this.bGk = getString(2131693509);
    setTitle(this.bGk);
    if ((this.jdField_a_of_type_AndroidWidgetSpinner != null) && (this.jdField_a_of_type_AndroidWidgetSpinner.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetSpinner.setSelection(Eh.indexOf(cHP));
    }
    eur();
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
  
  private void aaB(int paramInt)
  {
    this.layout.setVisibility(8);
    this.KD.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    if (3 == paramInt) {
      deL();
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.O = this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView.a(this.kk, new atny(this, paramInt));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setTabFileType(2);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setVisibility(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView.ga();
    this.kk.addView(this.O);
    this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
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
  
  private void deS()
  {
    aqju localaqju = aqha.a(this, 230);
    localaqju.setMessage(2131699882);
    localaqju.setTitle(2131699885);
    localaqju.setNegativeButton(getString(2131699884), new atnv(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    if (!isFinishing()) {
      localaqju.show();
    }
  }
  
  private void deW()
  {
    this.b = new atnx(this);
  }
  
  private void deX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    if (this.tabType == 6)
    {
      euq();
      return;
    }
    if (this.leftView != null) {
      this.leftView.setVisibility(8);
    }
    this.KD.setVisibility(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setVisibility(8);
    this.layout.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment = TimFileWebViewFragment.a(ault.a(this.app, EU(), uV(), DW(), this.cHN), this, 2131382161, false, false, "tim_file_web_fragment_edit");
    this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment.a(this);
    getSupportFragmentManager().beginTransaction().show(this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment).commit();
  }
  
  private void deY()
  {
    this.layout.setVisibility(8);
    this.KD.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    label96:
    Object localObject;
    if (akL())
    {
      if (this.Se == null) {
        this.Se = ((TextView)findViewById(2131370829));
      }
      if (this.cWA <= 0)
      {
        this.rightViewText.setVisibility(0);
        this.Se.setOnClickListener(this);
        deM();
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setTabFileType(1);
        if (this.cWA > 0) {
          break label381;
        }
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(10, getString(2131693846));
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(11, getString(2131693847));
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(9, getString(2131693850));
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(8, getString(2131693845));
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(14, getString(2131693849));
        label198:
        localObject = this.app.a().a(1);
        if (localObject != null) {
          this.cWx = ((atsk)localObject).Ox();
        }
        if ((!this.ccG) || ((this.tabType != 1) && (!this.ccA))) {
          break label584;
        }
        if ((this.cWx < 8) || (this.cWx > 14)) {
          break label572;
        }
        if (this.cWA > 0) {
          break label558;
        }
        if ((this.cWx != 11) && (this.cWx != 9) && (this.cWx != 10) && (this.cWx != 8) && (this.cWx != 14)) {
          break label546;
        }
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWx);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.rightViewText.setVisibility(4);
      this.rightViewText.setOnClickListener(null);
      break;
      C(this);
      if (this.Se != null) {
        this.Se.setVisibility(8);
      }
      deL();
      break label96;
      label381:
      localObject = new ArrayList();
      if (jD(8))
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(10, getString(2131693846));
        ((ArrayList)localObject).add(Integer.valueOf(10));
      }
      if (jD(2))
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(13, getString(2131693853));
        ((ArrayList)localObject).add(Integer.valueOf(13));
      }
      if (jD(4))
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(9, getString(2131693850));
        ((ArrayList)localObject).add(Integer.valueOf(9));
      }
      if (jD(1))
      {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(12, getString(2131693848));
        ((ArrayList)localObject).add(Integer.valueOf(12));
      }
      if (((ArrayList)localObject).size() != 1) {
        break label198;
      }
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.OW(8);
      break label198;
      label546:
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      label558:
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWB);
      continue;
      label572:
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
      continue;
      label584:
      if (7 != this.cWy)
      {
        if (this.cWA <= 0) {
          this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(11);
        } else {
          this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWB);
        }
      }
      else if (this.cWB != -1) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWB);
      } else {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(9);
      }
    }
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
        this.bd = new atnz(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.qlink.destory.fmactivity");
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
  
  private void dfe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setSelectedAllMode();
    deM();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(110, getString(2131693846));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(111, getString(2131693847));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(119, getString(2131693850));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(118, getString(2131693845));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(114, getString(2131693849));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(111);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private void eun()
  {
    this.nz = ((RelativeLayout)findViewById(2131377839));
    if (this.tabType == 8) {
      this.nz.setVisibility(0);
    }
    for (;;)
    {
      if (this.nz.getVisibility() == 0)
      {
        this.nz.findViewById(2131363801).setVisibility(8);
        IphoneTitleBarActivity.setLayerType(this.nz);
      }
      EditText localEditText = (EditText)this.nz.findViewById(2131366542);
      localEditText.setFocusableInTouchMode(false);
      localEditText.setCursorVisible(false);
      localEditText.setOnClickListener(this);
      return;
      this.nz.setVisibility(8);
    }
  }
  
  private void euo()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("filterTab");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Eh.remove(str);
        i += 1;
      }
    }
  }
  
  private void eup()
  {
    if ((this.tabType != 3) && (this.tabType != 2))
    {
      QLog.i("FMActivity<FileAssistant>", 2, "top banner only show with weiyun file!");
      return;
    }
    Object localObject = (LinearLayout)findViewById(2131380000);
    View localView = getLayoutInflater().inflate(2131558988, null, false);
    ((LinearLayout)localObject).addView(localView);
    boolean bool = BaseApplication.getContext().getSharedPreferences("CloudWeiYunFile", 0).getBoolean("cloud_weiyun_tip_save", false);
    if (("CloudFileTab".equalsIgnoreCase(getIntent().getStringExtra("from"))) && (!bool)) {
      localView.setVisibility(0);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131364729);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131364728);
      ((TextView)localObject).setText(2131691698);
      localFixSizeImageView.setOnClickListener(new atnw(this, localView));
      return;
      localView.setVisibility(8);
    }
  }
  
  private void euq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initQlinkRecentTabView");
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setUin(this.mUin);
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(3, getString(2131693844));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(4, getString(2131693846));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(5, getString(2131693850));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(6, getString(2131693847));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.k(7, getString(2131693845));
    if ((this.ccG) && (this.tabType == 0) && (this.cWx >= 3) && (this.cWx <= 7)) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(this.cWx);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
    }
  }
  
  private void eur()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    if (this.leftView != null) {
      this.leftView.setVisibility(8);
    }
    this.KD.setVisibility(0);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setVisibility(8);
    this.layout.setVisibility(8);
    this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment = TimFileWebViewFragment.a(ault.b(this.app, EU(), uV(), DW(), this.cHN), this, 2131382161, false, false, "tim_file_web_fragment_edit");
    this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment.a(this);
    getSupportFragmentManager().beginTransaction().show(this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment).commit();
  }
  
  public void IM(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int i = 0;
    if (paramBoolean) {
      i = this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int j = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.setTabFrameHeight(j - i);
  }
  
  public void a(atqs paramatqs)
  {
    this.jdField_a_of_type_Atqs = paramatqs;
    if (this.tabType == 9) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setSelectEvent(this.jdField_a_of_type_Atqs);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (this.mUin != null) && (this.mUin.trim().length() != 0))
    {
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Yh += 1L;
    this.Yi = Yh;
    int i = getIntent().getIntExtra("qfile_selecter_entrance_type", 4);
    if ((i != 4) && (i != 6)) {
      atwb.clearSelected();
    }
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.tabType = paramBundle.getIntExtra("tab_tab_type", -1);
    this.cWy = paramBundle.getIntExtra("busiType", -1);
    this.mUin = paramBundle.getStringExtra("uin");
    this.mCurType = paramBundle.getIntExtra("uintype", -1);
    this.ccz = paramBundle.getBooleanExtra("from_qlink", false);
    this.aWg = paramBundle.getBooleanExtra("from_aio", false);
    if (!this.aWg) {}
    this.dit = paramBundle.getBooleanExtra("from_cloud_file", false);
    this.diu = paramBundle.getBooleanExtra("from_miniapp_space", false);
    this.cWz = paramBundle.getIntExtra("peerType", -1);
    this.cWA = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.cWA & 0xF) == 0) {
      this.cWA = 0;
    }
    Object localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if ((akI()) && (this.tabType != 5) && (((SharedPreferences)localObject).getBoolean("last_select_All", false)) && (((SharedPreferences)localObject).getBoolean("last_select_send", false)))
    {
      this.ccH = true;
      NO(paramBundle.getIntExtra("smart_device_switch_tab_flag", 0));
      paramBundle = ((SharedPreferences)localObject).edit();
      paramBundle.putBoolean("last_select_All", false);
      paramBundle.putBoolean("last_select_send", false);
      paramBundle.commit();
      this.mTroopUin = getIntent().getStringExtra("targetUin");
      if (QLog.isColorLevel()) {
        QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.tabType + "],select[" + akI() + "]");
      }
      if ((!TextUtils.isEmpty(this.mUin)) && (this.mCurType == -1)) {
        IP(true);
      }
      this.ccA = false;
      if (acbn.bkw.equalsIgnoreCase(this.mTroopUin)) {
        this.ccA = true;
      }
      i = getResources().getDisplayMetrics().heightPixels;
      if ((!akI()) || (this.tabType == 5) || (this.tabType == 6) || (this.tabType == 9) || (this.ccC) || (this.dip) || (this.diq) || (this.dir)) {
        break label644;
      }
      NM(2131561009);
      ((LinearLayout)findViewById(2131367045)).setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
      if ((ImmersiveUtils.isSupporImmersive() != 1) || (!akL())) {}
    }
    for (;;)
    {
      this.cr = ((FrameLayout)findViewById(2131379124));
      this.kk = ((RelativeLayout)findViewById(2131371085));
      this.rightViewText.setVisibility(0);
      eun();
      MJ(this.tabType);
      this.app.a().dgn();
      dfb();
      return true;
      if ((!this.aWg) && (!this.dit) && (!this.diu) && (this.tabType != 5) && (paramBundle.getIntExtra("approval_attachment_customid", -1) == -1)) {
        break;
      }
      this.ccG = true;
      break;
      label644:
      setContentView(2131563198);
      paramBundle = (RelativeLayout)findViewById(2131377498);
      localObject = findViewById(2131379788);
      paramBundle.setVisibility(8);
      ((View)localObject).setVisibility(8);
      paramBundle = (LinearLayout)findViewById(2131367045);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.dmJ();
    this.app.a().aIH();
    this.app.a().dgm();
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView.finish();
    }
    if ((this.Yi == Yh) && (this.eqG != 4) && (this.eqG != 6)) {
      atwb.clearSelected();
    }
    dfc();
    if (this.ccB)
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.qlink.selectfileover");
      this.app.getApp().sendBroadcast(localIntent);
    }
    if (akN()) {
      this.app.a().euy();
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityFMActivity$a != null) {
      removeObserver(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFMActivity$a);
    }
    if (this.jdField_a_of_type_Atqs != null) {
      this.jdField_a_of_type_Atqs.onPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.mTroopUin != null))
    {
      ((acms)this.app.getBusinessHandler(20)).Fg(this.mTroopUin);
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityFMActivity$a = new a();
      addObserver(this.jdField_a_of_type_ComTencentTimFilemanagerActivityFMActivity$a);
    }
    super.doOnResume();
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.ei(paramArrayList);
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.ej(paramArrayList);
  }
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.ek(paramArrayList);
  }
  
  public void finish()
  {
    super.finish();
    if ((akI()) && (this.eqG != 4) && (this.eqG != 6)) {
      overridePendingTransition(2130771989, 2130771990);
    }
  }
  
  public void fn(ArrayList<FileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.fn(paramArrayList);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean jD(int paramInt)
  {
    return (this.cWA & paramInt) > 0;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment != null) && (this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment.isVisible()) && (this.KD.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment.biT();
    }
    for (;;)
    {
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131366542) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (H())
      {
        aM();
        Intent localIntent = new Intent(this, FMLocalFileActivity.class);
        localIntent.putExtra("STRING_Show_Music_Category", false);
        localIntent.putExtra("STRING_Show_Video_Category", false);
        localIntent.putExtra("STRING_Show_Apk_Category", false);
        localIntent.putExtra("STRING_Show_Pic_Category", false);
        localIntent.putExtra("STRING_Show_Driver_Category", false);
        localIntent.putExtra("STRING_Show_First_Space", false);
        localIntent.putExtra("from_cloud_file", this.dit);
        localIntent.putExtra("key_from_web_open_native_files_to_import_docs", this.ccF);
        localIntent.putExtra("key_from_web_import_docs_folderid", this.bGn);
        if (getIntent().hasExtra("is_using_cloud_bottom_bar"))
        {
          localIntent.putExtra("is_using_cloud_bottom_bar", getIntent().getBooleanExtra("is_using_cloud_bottom_bar", false));
          if (getIntent().hasExtra("key_parent_dir_name")) {
            localIntent.putExtra("key_parent_dir_name", getIntent().getStringExtra("key_parent_dir_name"));
          }
          if (getIntent().hasExtra("key_parent_dir_key")) {
            localIntent.putExtra("key_parent_dir_key", getIntent().getByteArrayExtra("key_parent_dir_key"));
          }
          localIntent.putExtra("key_bottom_bar_left_action", getIntent().getIntExtra("key_bottom_bar_left_action", 0));
          localIntent.putExtra("key_bottom_bar_right_action", getIntent().getIntExtra("key_bottom_bar_right_action", 0));
        }
        if ((paramView.getId() == 2131370829) || (paramView.getId() == 2131369579))
        {
          onBackEvent();
        }
        else if (paramView.getId() == 2131377775)
        {
          localIntent.putExtra("localSdCardfile", 1408041716);
          localIntent.putExtra("STRING_Show_Download_Category", false);
          startActivityForResult(localIntent, paramView.getId());
        }
        else if (paramView.getId() == 2131369612)
        {
          localIntent.putExtra("localSdCardfile", 1408041717);
          localIntent.putExtra("STRING_Show_Download_Category", false);
          localIntent.putExtra("STRING_Show_MyFile_Category", false);
          localIntent.putExtra("leftViewText", getTitle());
          localIntent.putExtra("from_aio", this.aWg);
          startActivityForResult(localIntent, paramView.getId());
        }
      }
    }
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Atqs != null) {
      this.jdField_a_of_type_Atqs.onRestart();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  public void onResume()
  {
    if (atwb.fN() > 0L) {
      deR();
    }
    if (this.jdField_a_of_type_Atqs != null) {
      this.jdField_a_of_type_Atqs.onResume();
    }
    super.onResume();
  }
  
  public void refreshUI()
  {
    super.refreshUI();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.refreshUI();
  }
  
  protected void resetUI()
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView.refreshUI();
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
        anot.a(paramString, "dc01332", "Grp_files", "", "power", "nopower_upload", 0, 0, (String)localObject1, paramList, "", "");
        FMActivity.b(FMActivity.this);
        return;
        paramInt1 = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */