package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import biv;
import biw;
import bix;
import biy;
import bjc;
import bjd;
import bje;
import bjf;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.opengl.QQGlRender;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class AVActivity
  extends BaseActivity
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "AVActivity";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  public RelativeLayout a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new bjc(this);
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver = new biy(this);
  public VideoControlUI a;
  public VideoLayerUI a;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public String b;
  boolean b;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  String e;
  public boolean e;
  String f;
  public boolean f;
  int g;
  public String g;
  public boolean g;
  public int h;
  String jdField_h_of_type_JavaLangString = null;
  boolean jdField_h_of_type_Boolean = false;
  public int i;
  String i;
  int j;
  public String j;
  public int k = 0;
  final int l = 0;
  final int m = 1;
  final int n = 2;
  final int o = 3;
  final int p = 4;
  
  public AVActivity()
  {
    this.jdField_g_of_type_Int = 1;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void BtnOnClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "BtnOnClick");
    }
    if ((paramView.getId() == 2131232196) && (this.jdField_a_of_type_AndroidWidgetTextView.isShown()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(false);
      }
    }
    if (!this.jdField_g_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramView);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onCreateUI SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232196));
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)
    {
      localObject = (LinearLayout)super.findViewById(2131232191);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (LinearLayout)localObject);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131232195));
    }
    Object localObject = super.findViewById(2131232190);
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (View)localObject);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new biv(this));
    }
    switch (this.jdField_h_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
      }
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a());
      continue;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a());
      continue;
      this.jdField_a_of_type_ComTencentAvVideoController.q();
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a());
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    this.jdField_e_of_type_Boolean = false;
    finish();
    overridePendingTransition(0, 2130968634);
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "processExtraData");
    }
    Intent localIntent = super.getIntent();
    int i1 = localIntent.getIntExtra("sessionType", 0);
    int i2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int;
    String str2 = localIntent.getStringExtra("Fromwhere");
    if ((str2 != null) && (str2.compareTo("AVNotification") == 0)) {
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AVActivity", 2, "processExtraData-->can not get session type in intent.");
        }
        finish();
      }
      for (;;)
      {
        return;
        Object localObject1 = null;
        String str1 = null;
        Object localObject2;
        if ((i1 == 1) || (i1 == 2))
        {
          localObject1 = localIntent.getStringExtra("uin");
          localObject2 = localObject1;
          if (str2 != null)
          {
            localObject2 = localObject1;
            if (str2.compareTo("AVNotification") == 0)
            {
              if ((i1 != 1) && (i1 != 2)) {
                break label223;
              }
              localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
            }
          }
        }
        for (;;)
        {
          if (localObject2 != null) {
            break label252;
          }
          if (QLog.isColorLevel()) {
            QLog.e("AVActivity", 2, "processExtraData-->can not get uin  in intent.");
          }
          finish();
          return;
          if ((i1 != 3) && (i1 != 4)) {
            break;
          }
          localObject1 = localIntent.getStringExtra("GroupId");
          break;
          label223:
          if (i1 != 3)
          {
            localObject2 = localObject1;
            if (i1 != 4) {}
          }
          else
          {
            localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a);
          }
        }
        label252:
        if ((i2 == 1) || (i2 == 2))
        {
          str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
          localObject1 = str1;
          if (str1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AVActivity", 2, "can not get the original peeruin");
            }
            finish();
          }
        }
        else if ((i2 == 3) || (i2 == 4))
        {
          str1 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a);
          localObject1 = str1;
          if (str1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AVActivity", 2, "can not get the original group uin");
            }
            finish();
          }
        }
        else
        {
          localObject1 = str1;
          if (QLog.isColorLevel())
          {
            QLog.d("AVActivity", 2, "original session type is none");
            localObject1 = str1;
          }
        }
        if (i2 == 0) {
          c();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AVActivity", 2, "mSessionType: " + this.jdField_h_of_type_Int + ", mUinType: " + this.jdField_i_of_type_Int + ", mPeerUin: " + this.jdField_b_of_type_JavaLangString + ", mPeerName: " + this.jdField_c_of_type_JavaLangString + ", mPhoneNum: " + this.jdField_d_of_type_JavaLangString + ", mSelfNation: " + this.jdField_e_of_type_JavaLangString + ", mSelfMobile: " + this.jdField_f_of_type_JavaLangString + ", mIsReceiver:" + this.jdField_a_of_type_Boolean + ", mIsAudioMode: " + this.jdField_b_of_type_Boolean + ", mExtraUin: " + this.jdField_g_of_type_JavaLangString + ", mIsNetworkWell: " + this.jdField_c_of_type_Boolean + ", mIsFriend: " + this.jdField_d_of_type_Boolean + ", mFromWhere: " + this.jdField_h_of_type_JavaLangString);
          return;
          long l1;
          if ((i2 == 3) || (i2 == 4))
          {
            if ((i1 == 1) || (i1 == 2))
            {
              this.jdField_a_of_type_ComTencentAvVideoController.b(Long.valueOf((String)localObject1).longValue());
              c();
              return;
            }
            if ((i1 == 3) || (i1 == 4))
            {
              l1 = Long.valueOf((String)localObject2).longValue();
              this.jdField_a_of_type_ComTencentAvVideoController.a().n = localIntent.getIntExtra("Type", -1);
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long = l1;
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString = ((String)localObject2);
              if (((String)localObject2).compareTo((String)localObject1) == 0) {}
              for (this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int;; this.jdField_h_of_type_Int = i1)
              {
                this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
                this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
                this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean;
                break;
                this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int = i1;
                if ((this.jdField_a_of_type_ComTencentAvVideoController.a().n == 0) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n == 1)) {
                  this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
                }
              }
            }
          }
          else if ((i2 == 1) || (i2 == 2))
          {
            if ((i1 == 1) || (i1 == 2))
            {
              this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int;
              this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
              this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString;
              this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
              this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
              this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
              this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().v;
              this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean;
            }
            else if ((i1 == 3) || (i1 == 4))
            {
              l1 = Long.valueOf((String)localObject2).longValue();
              this.jdField_a_of_type_ComTencentAvVideoController.a().n = localIntent.getIntExtra("Type", -1);
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().n != 3)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AVActivity", 2, "gaudiostatustype is wrong.TYpe= " + this.jdField_a_of_type_ComTencentAvVideoController.a().n);
                }
                finish();
                return;
              }
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long = l1;
              this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString = ((String)localObject2);
              this.jdField_h_of_type_Int = i1;
            }
          }
        }
      }
    }
  }
  
  void c()
  {
    int i1 = 0;
    Intent localIntent = super.getIntent();
    this.jdField_h_of_type_Int = localIntent.getIntExtra("sessionType", 0);
    this.jdField_i_of_type_Int = localIntent.getIntExtra("uinType", 0);
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("name");
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("selfNation");
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("selfMobile");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("toMobile");
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("receive", true);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("isAudioMode", true);
    this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("extraUin");
    String str = localIntent.getStringExtra("extraCode");
    this.jdField_a_of_type_ArrayOfByte = localIntent.getByteArrayExtra("sig");
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("isNetworkWell", false);
    this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("isFriend", false);
    this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("from");
    this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("shutCamera", false);
    if ((this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 4))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = localIntent.getIntExtra("Type", -1);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString = localIntent.getStringExtra("GroupId");
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString).longValue();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
    }
    if (this.jdField_h_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVActivity", 2, "invalid sessionType!!!");
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    if (localIntent.getIntExtra("istatus", 0) == 11) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.d(i1);
      if (!this.jdField_a_of_type_Boolean) {
        break label652;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "uin is empty");
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
      i1 = 1;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int = this.jdField_h_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int = this.jdField_i_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = this.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean = this.jdField_c_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      this.jdField_a_of_type_ComTencentAvVideoController.a().m = this.jdField_d_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Int = this.jdField_h_of_type_Int;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = this.jdField_f_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int = localIntent.getIntExtra("friendTerminal", -1);
      return;
      label652:
      if (this.jdField_i_of_type_Int == 1006)
      {
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "phoneNum is empty");
          }
          this.jdField_e_of_type_Boolean = true;
          finish();
          return;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVActivity", 2, "mPeerUin: " + this.jdField_b_of_type_JavaLangString);
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AVActivity", 2, "Create video failed because uin is empty");
          }
          this.jdField_e_of_type_Boolean = true;
          finish();
          return;
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        }
      }
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new bjd(this, this, 2);
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
  }
  
  public void finish()
  {
    if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.jdField_h_of_type_JavaLangString.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    super.finish();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    }
  }
  
  void h()
  {
    Object localObject;
    if (this.jdField_b_of_type_Boolean) {
      localObject = super.getString(2131560146);
    }
    for (String str = super.getString(2131560147);; str = super.getString(2131560122))
    {
      localObject = DialogUtil.a(this, 230, (String)localObject, str, 2131560061, 2131560060, new biw(this, 0), new biw(this, 1));
      if (!isFinishing()) {
        ((QQCustomDialog)localObject).show();
      }
      return;
      localObject = super.getString(2131560121);
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_h_of_type_Boolean == true) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.n();
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onCreate");
    }
    super.requestWindowFeature(1);
    super.setContentView(2130903345);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    int i1 = LocaleUtil.b(getApplicationContext());
    LocaleUtil.a(getBaseContext(), i1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      paramBundle = super.getString(2131560117) + " 0x00";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "onCreate,VideoAppInterface.PROC_STATUS_CAN_CLOSED");
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    AVReport.a().a(getIntent(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      paramBundle = super.getString(2131560117) + " 0x01";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvVideoController.g();
    this.jdField_a_of_type_ComTencentAvVideoController.d();
    d();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().o) {
      b();
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bix(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction(QQGlRender.SHOW1STFRAME_BROADCAST);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(getApplicationContext());
    this.jdField_g_of_type_Int = 1;
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_g_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onDestroy");
    }
    g();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().o = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramKeyEvent);
    }
    boolean bool1 = bool2;
    switch (paramInt)
    {
    case 24: 
    case 25: 
    default: 
      bool1 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().e())) {
          break;
        }
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 4);
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int < 9);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, paramKeyEvent);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("sessionType", 0);
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2)) {
      if ((i1 == 3) || (i1 == 4))
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        b();
        this.jdField_g_of_type_Int = 1;
        a();
      }
    }
    do
    {
      do
      {
        return;
      } while (((this.jdField_h_of_type_Int != 3) && (this.jdField_h_of_type_Int != 4)) || ((i1 != 3) && (i1 != 4)));
      b();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onPause");
    }
    f();
    this.jdField_g_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, null);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b();
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 5;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onResume");
    }
    long l1;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().o)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.b();
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().e()) {
        break label221;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
      View localView = super.getWindow().getDecorView();
      bje localbje = new bje(this);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) {
        break label216;
      }
      l1 = 200L;
      label142:
      localView.postDelayed(localbje, l1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(false);
      e();
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.a();
      break;
      label216:
      l1 = 0L;
      break label142;
      label221:
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, null);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_h_of_type_Boolean = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_g_of_type_Int = 3;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
    }
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.c();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.v();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
    }
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVActivity", 2, "onStop-->SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 4)) {
        break label218;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().n != 3) {
        break label136;
      }
    }
    label136:
    label218:
    do
    {
      String str;
      Bitmap localBitmap;
      do
      {
        return;
        str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString, null);
        localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString, null, true, true);
      } while (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(str, localBitmap, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_JavaLangString, 44);
      this.jdField_a_of_type_ComTencentAvVideoController.u();
      return;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.f();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AVActivity", 2, "onStop-->Wrong type of SessionType");
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    this.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onUserLeaveHint");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onWindowFocusChanged hasFocus = " + paramBoolean);
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new bjf(this), 500L);
    if (AVReport.a().jdField_a_of_type_Boolean)
    {
      AVReport.a().i = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */