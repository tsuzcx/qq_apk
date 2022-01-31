package com.tencent.av.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bjl;
import bjm;
import bjn;
import bjp;
import bjq;
import bjw;
import bjx;
import bjy;
import bjz;
import bka;
import bkb;
import bke;
import bkf;
import bkg;
import bkh;
import bki;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MultiVideoCtrlLayerUI
  extends VideoControlUI
{
  static int jdField_a_of_type_Int = 6;
  static final String jdField_a_of_type_JavaLangString = "MultiVideoCtrlLayerUI";
  public long a;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public ImageButton a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  public bjq a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new bjn(this);
  public MultiVideoEnterPage a;
  public MultiVideoMembersHolderUI a;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new bjm(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  public QQCustomDialog a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public long[] a;
  public int b;
  public long b;
  public Button b;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton = null;
  public TextView b;
  public Runnable b;
  public String b;
  boolean jdField_b_of_type_Boolean = true;
  public int c;
  long jdField_c_of_type_Long = 0L;
  public TextView c;
  public Runnable c;
  String jdField_c_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public boolean c;
  final int jdField_d_of_type_Int = 0;
  public long d;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  final int jdField_e_of_type_Int = 1;
  public TextView e;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  boolean jdField_e_of_type_Boolean = false;
  final int jdField_f_of_type_Int = 2;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  Runnable g;
  Runnable h;
  Runnable i;
  public Runnable j;
  
  public MultiVideoCtrlLayerUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_h_of_type_JavaLangRunnable = null;
    this.jdField_i_of_type_JavaLangRunnable = new bjy(this);
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Bjq = new bjq(this);
    this.jdField_d_of_type_Long = Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue();
  }
  
  private void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "showOrHidenStopRemoteVideoBtn");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      l = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long;
      if (l != 0L)
      {
        k = 0;
        if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (l == ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_Long)
          {
            if ((!((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_c_of_type_Boolean) || (!((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_b_of_type_Boolean)) {
              break label143;
            }
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ReportController.b(null, "CliOper", "", "", "0X8004428", "0X8004428", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            k += 1;
            break;
            label143:
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("MultiVideoCtrlLayerUI", 2, "showStopRemoteVideoBtn-->RemoteUin is 0");
      }
    }
    while (!QLog.isColorLevel())
    {
      long l;
      int k;
      return;
    }
    QLog.e("MultiVideoCtrlLayerUI", 2, "showStopRemoteVideoBtn-->mVideoControl is null");
  }
  
  private void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_b_of_type_Long), Boolean.valueOf(paramBoolean) });
  }
  
  void A()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiVideoCtrlLayerUI", 2, "On PressCameraBtn");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Bjq.jdField_a_of_type_JavaLangRunnable = this.jdField_i_of_type_JavaLangRunnable;
      this.jdField_a_of_type_Bjq.run();
      ReportController.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
      return;
    }
    B();
    y();
    ReportController.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
  }
  
  public void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "goOffStage");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.w();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false, null);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    M();
  }
  
  void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "pressMuteBtn");
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.g();
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {}
    for (long l = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long; bool; l = this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, true);
      super.h(2131232200);
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Open_microphone", 0, 0, "", "", "", "");
      UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560163));
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(l, false);
    super.g(2131232200);
    ReportController.b(null, "CliOper", "", "", "Multi_call", "Turnoff_microphone", 0, 0, "", "", "", "");
    UITools.a(this.jdField_d_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560164));
  }
  
  void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "initTRAE");
    }
    super.D();
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b();
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
  }
  
  void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "enterGAudio_onQueryState");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      D();
      q();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public void F()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long;
    }
  }
  
  void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "quitGAudioDialog");
    }
    bjw localbjw1 = new bjw(this, 0);
    bjw localbjw2 = new bjw(this, 1);
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localContext, 230, null, ((Activity)localContext).getString(2131560198), 2131560061, 2131560230, localbjw1, localbjw2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  void H()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int == 9)
    {
      int k = 0;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() > 0L) {
        k = 3000;
      }
      if (this.jdField_d_of_type_JavaLangRunnable == null) {
        this.jdField_d_of_type_JavaLangRunnable = new bke(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, k);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.l);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.l, 3000L);
  }
  
  void I()
  {
    if (this.jdField_j_of_type_JavaLangRunnable == null) {
      this.jdField_j_of_type_JavaLangRunnable = new bjx(this);
    }
    if (this.jdField_j_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  void J()
  {
    if (this.jdField_j_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
    }
    this.jdField_j_of_type_JavaLangRunnable = null;
  }
  
  void K()
  {
    String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131561569);
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 2000)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232209);
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null)
      {
        QQToast.a(localContext, str, 2000).b(localRelativeLayout.getHeight());
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public void L()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "resumeRemoteAndLocalVideo-->mVideoControl is null");
      }
    }
    label292:
    label297:
    label327:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoCtrlLayerUI", 2, "resumeRemoteAndLocalVideo-->mVideoController.mGAudioInRoom =" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI", 2, "resumeRemoteAndLocalVideo -->needResumeCamera=" + this.jdField_a_of_type_ComTencentAvVideoController.a().s + " remoteUin=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long + " videosrctype=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().s)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().s = false;
        if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
          z();
        }
      }
      else
      {
        y();
        localObject = null;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
        if ((localObject == null) || (!((VideoController.GAudioFriends)localObject).jdField_c_of_type_Boolean)) {
          break label327;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 0L) {
          break label297;
        }
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (a(false, true, true, false)) {
          break label292;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        ((SessionInfo)localObject).p = bool1;
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MultiVideoCtrlLayerUI", 2, "onEnterRoomSuc-->go on stage fail,can not find the session");
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!a(false, true, true, true)) {}
      for (;;)
      {
        ((SessionInfo)localObject).p = bool1;
        return;
        bool1 = false;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 0L) && (NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
      {
        if (a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int))
        {
          a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int, false);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int = 0;
      }
    } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().p);
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!a(true, true, true, true)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((SessionInfo)localObject).p = bool1;
      return;
    }
  }
  
  public void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "switchUIMode, sessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int);
    }
    W();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4)
    {
      super.f(false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(false);
      this.jdField_e_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      return;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_h_of_type_Boolean = true;
      super.f(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.setVisibility(0);
      }
      this.jdField_e_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (Build.VERSION.SDK_INT >= 11)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiVideoCtrlLayerUI", 2, "onApnChanged" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_APN_CHANGED.ordinal(), paramInt);
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage.a(paramInt);
    }
    return 0;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, paramString, String.valueOf(this.jdField_a_of_type_Long));
  }
  
  @TargetApi(8)
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "initUI");
    }
    super.e(2130903348);
    super.a();
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage = new MultiVideoEnterPage((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPage.a();
    Object localObject;
    label130:
    label324:
    int n;
    label432:
    int m;
    int k;
    if (Build.VERSION.SDK_INT >= 8)
    {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_b_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label791;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232254));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232255));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232256));
      this.jdField_f_of_type_AndroidWidgetTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject = new bkg(this);
      this.jdField_a_of_type_AndroidWidgetTextView.post((Runnable)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232197));
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232205));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232206));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232207));
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232205));
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        z();
      }
      if (this.jdField_b_of_type_JavaLangString == null) {
        break label809;
      }
      a(4, this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232220));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI = ((MultiVideoMembersHolderUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232221));
      this.b = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI;
      x();
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        break label820;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((AVActivity)localObject).findViewById(2131232191));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject).findViewById(2131232194));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject).findViewById(2131232196));
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a() != 1) {
        break label838;
      }
      n = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427652);
      m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427654);
      k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427676);
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = n;
      localLayoutParams1.height = m;
      localLayoutParams2.topMargin = k;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.setLayoutParams(localLayoutParams1);
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams2);
      if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.g())) {
        super.g(2131232200);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int == 9)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131560219);
        a(4, this.jdField_b_of_type_JavaLangString);
        H();
      }
      if (this.jdField_b_of_type_Int != 3)
      {
        super.f(true);
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().o)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long, false);
          super.g(2131232200);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().p = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean;
        this.jdField_a_of_type_ComTencentAvVideoController.a().s = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
        super.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean, true);
        this.jdField_d_of_type_Boolean = true;
      }
      return;
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      break;
      label791:
      if (!QLog.isColorLevel()) {
        break label130;
      }
      QLog.e("MultiVideoCtrlLayerUI", 2, "mEnterPageView is null");
      break label130;
      label809:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label324;
      label820:
      if (!QLog.isColorLevel()) {
        break label432;
      }
      QLog.e("MultiVideoCtrlLayerUI", 2, "initUI-->can not get AVActivity");
      break label432;
      label838:
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a() == 0)
      {
        n = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427651);
        m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427653);
        k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427675);
      }
      else
      {
        k = 0;
        m = 0;
        n = 0;
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, String paramString, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "drawUI");
    }
    if (paramInt1 == 0) {
      if (paramLong != this.jdField_d_of_type_Long)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() > 1L)) {
          UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165201, 0, null);
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == paramLong)) {}
      }
    }
    label878:
    label894:
    do
    {
      do
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_SWITCH_TO_MULTI_WAITING_TIPS.ordinal());
        for (;;)
        {
          if ((paramInt1 == 0) || (paramInt1 == 1)) {
            if (this.jdField_a_of_type_ComTencentAvVideoController == null)
            {
              return;
              if (paramInt1 == 1)
              {
                if (paramLong != this.jdField_d_of_type_Long) {
                  UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165202, 0, null);
                }
                if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
                  this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_SWITCH_TO_MULTI_WAITING_TIPS.ordinal());
                }
              }
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int == 9)
            {
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131560195);
              a(4, this.jdField_b_of_type_JavaLangString);
              if (this.l != null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.l);
              }
              if ((paramInt2 != 11) && (paramInt2 != 10)) {
                break label1256;
              }
              if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI == null) {
                break label1240;
              }
              paramString = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI;
              if (paramInt2 != 10) {
                break label1234;
              }
            }
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramString.a(paramLong, paramBoolean);
          return;
          if (paramInt1 == 0)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int != 9)
            {
              Q();
              this.jdField_a_of_type_ComTencentAvVideoController.a(true);
            }
            if ((paramLong != this.jdField_d_of_type_Long) && (paramBoolean)) {
              a(paramString, 2131560191, paramInt1, paramLong);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MultiVideoCtrlLayerUI", 2, "GAudio member enter");
            break;
          }
          if (paramInt1 != 1) {
            break;
          }
          this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_AndroidContentResResources.getString(2131560194));
          H();
          a(paramInt1, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(paramLong));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiVideoCtrlLayerUI", 2, "GAudio member leave");
          break;
          if (paramInt1 == 68)
          {
            float f1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427662);
            String str = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString, this.jdField_a_of_type_AndroidWidgetTextView, f1);
            if (this.jdField_g_of_type_Int == 1) {}
            for (paramString = this.jdField_a_of_type_AndroidContentResResources.getString(2131560211);; paramString = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131560210), new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) }))
            {
              this.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_AndroidContentResResources.getString(2131560209) + str + paramString);
              H();
              a(paramInt1, this.jdField_b_of_type_JavaLangString);
              break;
            }
          }
          if (paramInt1 == 82)
          {
            H();
            a(paramInt1, this.jdField_b_of_type_JavaLangString);
            break;
          }
          if ((paramInt1 == 5) || (paramInt1 == 6))
          {
            if ((paramInt1 == 6) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == paramLong) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiVideoCtrlLayerUI", 2, "RemoteVideo(Camera) has close by remote user.Uin = " + paramLong);
              }
              w();
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal());
            }
            if (paramInt1 == 5)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiVideoCtrlLayerUI", 2, "RemoteVideo(Camera) has come.Uin = " + paramLong);
              }
              if ((paramLong != this.jdField_d_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().q)) {
                a(paramString, true);
              }
              if (paramLong != this.jdField_d_of_type_Long) {
                ReportController.b(null, "CliOper", "", "", "0X8004420", "0X8004420", 0, 0, "", "", "", "");
              }
            }
            if (this.jdField_e_of_type_AndroidWidgetButton != null)
            {
              if ((this.jdField_a_of_type_ComTencentAvVideoController.d() < jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean)) {
                break label878;
              }
              if (this.jdField_e_of_type_AndroidWidgetButton.isClickable()) {
                z();
              }
            }
            for (;;)
            {
              if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != paramLong)) {
                break label894;
              }
              X();
              break;
              if (!this.jdField_e_of_type_AndroidWidgetButton.isClickable()) {
                d(false);
              }
            }
            break;
          }
          if ((paramInt1 == 7) || (paramInt1 == 8))
          {
            if ((paramInt1 == 8) && (paramLong == this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int == 2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiVideoCtrlLayerUI", 2, "RemoteVideo(Screen) has close by remote user.Uin = " + paramLong);
              }
              w();
              this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal());
            }
            if (paramInt1 == 7)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiVideoCtrlLayerUI", 2, "RemoteVideo(Screen) has come.Uin = " + paramLong);
              }
              if ((paramLong != this.jdField_d_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().q)) {
                a(paramString, false);
              }
              if (paramLong != this.jdField_d_of_type_Long) {
                ReportController.b(null, "CliOper", "", "", "0X800441F", "0X800441F", 0, 0, "", "", "", "");
              }
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != paramLong)) {
              break;
            }
            X();
            break;
          }
          if ((paramInt1 != 97) && (paramInt1 != 98)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("MultiVideoCtrlLayerUI", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          }
          if (!this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal())) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO_FAIL, true);
          ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoCtrlLayerUI", 2, "drawUI-->mMemberUI is null");
      return;
    } while (paramInt2 == -1);
    label1234:
    label1240:
    label1256:
    d(paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "setTitle");
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (this.jdField_g_of_type_Boolean) {
      this.i = true;
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "sendVideoMsgBroadcast-->discussionId=" + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.AddVideoMsg");
        localIntent.putExtra("uinType", 3000);
        localIntent.putExtra("msgType", 13);
        localIntent.putExtra("isVideoMsg", false);
        localIntent.putExtra("friendUin", Long.toString(paramLong));
        localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        localIntent.putExtra("isSender", true);
        localIntent.putExtra("isRead", true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "refreshUI");
    }
    if (paramLong == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "refreshUI-->uin == 0");
      }
    }
    do
    {
      return;
      Object localObject2 = a(String.valueOf(paramLong));
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 9) {
          localObject1 = ((String)localObject2).substring(0, 8) + "...";
        }
      }
      localObject1 = new bkb(this, paramInt1, paramLong, (String)localObject1, paramBoolean, paramInt2);
      localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 != null)
      {
        ((AVActivity)localObject2).runOnUiThread((Runnable)localObject1);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUI", 2, "refreshUI-->Can not get AVActivity");
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onNewIntent");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int != 3)
    {
      if (this.jdField_c_of_type_Boolean == true) {
        E();
      }
    }
    else {
      return;
    }
    q();
  }
  
  public void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131232256: 
    case 2131232254: 
    case 2131232255: 
    case 2131232205: 
    case 2131232200: 
    case 2131232199: 
    case 2131232201: 
    case 2131232248: 
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (this.jdField_h_of_type_Int - this.jdField_j_of_type_Int > 2)
              {
                this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
                this.jdField_i_of_type_Int = 0;
              }
              this.jdField_i_of_type_Int += 1;
              if (this.jdField_i_of_type_Int > 5)
              {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(112) });
                this.jdField_i_of_type_Int = 0;
                this.jdField_j_of_type_Int = 0;
                return;
                if (this.jdField_c_of_type_Boolean)
                {
                  if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
                    this.jdField_a_of_type_ComTencentAvVideoController.l = false;
                  }
                  ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_icon_chatmember", 0, 0, "", "", "", "");
                  if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4)
                  {
                    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) {
                      break label346;
                    }
                    ReportController.b(null, "CliOper", "", "", "0X80041B9", "0X80041B9", 0, 0, "", "", "", "");
                    QQToast.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131560265, 1).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427376));
                  }
                }
                for (;;)
                {
                  if (this.jdField_b_of_type_Int != 3) {
                    break label375;
                  }
                  g(true);
                  return;
                  ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_back", 0, 0, "", "", "", "");
                  break;
                  ReportController.b(null, "CliOper", "", "", "0X80041BC", "0X80041BC", 0, 0, "", "", "", "");
                }
                g(false);
                return;
                if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)) >= 50) {
                  K();
                }
                for (;;)
                {
                  if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4) {
                    W();
                  }
                  ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_invite", 0, 0, "", "", "", "");
                  return;
                  paramView = new Intent();
                  paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
                  paramView.setAction("tencent.video.v2q.AddContactsToDiscuss");
                  paramView.putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
                }
                if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int == 9) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().w)) {
                  ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_logout_waiting", 0, 0, "", "", "", "");
                }
                ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_end", 0, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
                  this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
                }
                for (;;)
                {
                  super.R();
                  g(true);
                  return;
                  this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_Long);
                }
                C();
                if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4)
                {
                  W();
                  return;
                  try
                  {
                    s();
                    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4)
                    {
                      W();
                      return;
                    }
                  }
                  catch (Exception paramView) {}
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("MultiVideoCtrlLayerUI", 2, "pressHandFreeBtn-->Here catch a exception-->info=" + paramView.getMessage());
          return;
          A();
        } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 4);
        W();
        return;
        if ((this.jdField_b_of_type_Int != 3) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
          break label880;
        }
        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoCtrlLayerUI", 2, "R.id.qav_bottombar_camera-->can not get context");
      return;
      if (!NetworkUtil.e(paramView))
      {
        QQToast.a(paramView, 2131562452, 1).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427376));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int < 7))
      {
        QQToast.a(paramView, 2131560199, 1).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427376));
        return;
      }
      E();
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Clk_join_chatmember", 0, 0, "", "", "", "");
      return;
    case 2131232206: 
      label346:
      label375:
      w();
      label880:
      ReportController.b(null, "CliOper", "", "", "0X80041B6", "0X80041B6", 0, 0, "", "", "", "");
      W();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(107) });
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4) {
      W();
    }
    paramView = (Button)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131232207);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean = false;
      UITools.a(paramView, this.jdField_a_of_type_AndroidContentResResources.getString(2131560172));
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean = true;
    UITools.a(paramView, this.jdField_a_of_type_AndroidContentResResources.getString(2131560171));
  }
  
  public void a(String paramString) {}
  
  void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    float f1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427662);
    paramString = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString, this.jdField_a_of_type_AndroidWidgetTextView, f1);
    this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt1));
    H();
    a(paramInt2, this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(paramLong));
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "setVideoCome-->name is null");
      }
    }
    for (;;)
    {
      return;
      paramString = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString, this.jdField_d_of_type_AndroidWidgetTextView, 2.131428E+009F);
      if (paramBoolean) {}
      for (paramString = paramString + this.jdField_a_of_type_AndroidContentResResources.getString(2131560192); this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null; paramString = paramString + this.jdField_a_of_type_AndroidContentResResources.getString(2131560193))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_OPEN_CAMERA_OR_SCREEN.ordinal(), paramString, 3000L, true);
        return;
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "setWaitingTextState-->bShow=" + paramBoolean);
    }
    if (this.jdField_f_of_type_JavaLangRunnable == null) {
      this.jdField_f_of_type_JavaLangRunnable = new bki(this);
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_f_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    ((bki)this.jdField_f_of_type_JavaLangRunnable).a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
  }
  
  boolean a()
  {
    if (!NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI", 2, "hasAutoCheckAbility-->is not wificonnected");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.i() != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoCtrlLayerUI", 2, "hasAutoCheckAbility-->videoAbility is not support,Ability=" + this.jdField_a_of_type_ComTencentAvVideoController.i());
      }
      return false;
    }
    return true;
  }
  
  boolean a(int paramInt)
  {
    y();
    int k;
    int m;
    label28:
    Object localObject;
    if (paramInt == 2)
    {
      k = 0;
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
      m = 0;
      if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label112;
      }
      localObject = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(m);
      if (((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long != l) {
        break label114;
      }
    }
    label112:
    label114:
    while (((k == 0) || (!((VideoController.GAudioFriends)localObject).jdField_b_of_type_Boolean)) && ((k != 0) || (!((VideoController.GAudioFriends)localObject).jdField_c_of_type_Boolean)))
    {
      m += 1;
      break label28;
      if (paramInt == 1)
      {
        k = 1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "autoCheckVideo-->Wrong Type of SRC.SRC=" + paramInt);
      }
      return false;
    }
    if (a(((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long, paramInt, false))
    {
      localObject = new bkf(this, ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long, paramInt);
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null) {
        localAVActivity.runOnUiThread((Runnable)localObject);
      }
    }
    else
    {
      if (paramInt != 2) {
        break label243;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004421", "0X8004421", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoCtrlLayerUI", 2, "autoCheckVideo-->can not get AVActivity");
      break;
      label243:
      ReportController.b(null, "CliOper", "", "", "0X8004422", "0X8004422", 0, 0, "", "", "", "");
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return true;
      p();
      return true;
    } while ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 4));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X80041BA", "0X80041BA", 0, 0, "", "", "", "");
      return true;
    }
    ReportController.b(null, "CliOper", "", "", "0X80041BD", "0X80041BD", 0, 0, "", "", "", "");
    return true;
  }
  
  boolean a(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    y();
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      VideoController.GAudioFriends localGAudioFriends;
      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (localGAudioFriends.jdField_a_of_type_Long != paramLong) {
          break label84;
        }
        if ((paramInt == 1) && (localGAudioFriends.jdField_b_of_type_Boolean)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      if ((paramInt == 2) && (localGAudioFriends.jdField_c_of_type_Boolean)) {
        return true;
      }
      label84:
      k += 1;
    }
  }
  
  public boolean a(long paramLong, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "requestGVideo-->uin=" + paramLong + " type=" + paramInt + " isUIThread=" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), paramInt))
      {
        this.jdField_c_of_type_Int = paramInt;
        if (!paramBoolean)
        {
          bka localbka = new bka(this, TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal(), false);
          AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localAVActivity != null)
          {
            localAVActivity.runOnUiThread(localbka);
            paramBoolean = true;
          }
        }
      }
    }
    do
    {
      do
      {
        return paramBoolean;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MultiVideoCtrlLayerUI", 2, "requestGVideo-->can not get AVActivity");
        break;
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO, false);
        break;
        paramBoolean = bool;
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoCtrlLayerUI", 2, "requestGVideo--> Request Failed");
      return false;
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUI", 2, "requestGVideo--> Request Failed.");
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "autoCheckVideo-->needCheckCamera=" + paramBoolean1 + " needChenckShareSrc=" + paramBoolean2 + " needCheckNet=" + paramBoolean3 + " needCheckVideoAbility=" + paramBoolean4);
    }
    if ((paramBoolean3) && (!NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))) {
      return false;
    }
    if ((paramBoolean4) && (!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.i() != 2)) {
      return false;
    }
    if (paramBoolean2) {}
    for (paramBoolean2 = c();; paramBoolean2 = false)
    {
      paramBoolean3 = paramBoolean2;
      if (paramBoolean1)
      {
        paramBoolean3 = paramBoolean2;
        if (!paramBoolean2) {
          paramBoolean3 = b();
        }
      }
      X();
      return paramBoolean3;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "MultiVideoCtrlLayerUI OnCreate");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onCreate-->mType=" + this.jdField_b_of_type_Int + " mIntentGroupId=" + this.jdField_b_of_type_Long);
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_Int == 3)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUI", 2, "onCreate-->discussid is null");
        }
        g(true);
        return;
      }
      c(this.jdField_a_of_type_ComTencentAvVideoController.a().j);
      this.jdField_c_of_type_Boolean = true;
      Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        break label356;
      }
      localObject = ((AVActivity)localObject).getIntent();
      if (localObject == null) {
        break label338;
      }
      localObject = ((Intent)localObject).getStringExtra("Fromwhere");
      if ((localObject != null) && (((String)localObject).equals("AVNotification"))) {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "System_bar_back", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int != 3)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().o) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean)) {
          this.jdField_c_of_type_JavaLangString = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
        }
        D();
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().o) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      a();
      return;
      q();
      break;
      label338:
      if (QLog.isColorLevel())
      {
        QLog.e("MultiVideoCtrlLayerUI", 2, "onCreate-->can not get the intent");
        continue;
        label356:
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUI", 2, "onCreate-->can not get the activity");
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void b(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      return;
    case 90: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(270.0F);
      return;
    case 180: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(0.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(90.0F);
  }
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  boolean b()
  {
    return a(1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onStart");
    }
    if (this.jdField_b_of_type_Int != 3)
    {
      I();
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.c();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label96;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.v();
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        a(this.jdField_a_of_type_Long);
      }
      return;
      label96:
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "onStart-->mVideoControl is null");
      }
    }
  }
  
  void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "getRoomMemberList-->Discuss id=" + paramString);
    }
    paramString = Long.valueOf(paramString);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.b(2, paramString.longValue());
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  boolean c()
  {
    return a(2);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onResume");
    }
    if ((this.jdField_b_of_type_Int == 3) && (QLog.isColorLevel())) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onResume-->Type = TYPE_GAUDIO_STATUS_QUERY");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      r();
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4)) {
      r();
    }
    if (this.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.jdField_e_of_type_JavaLangRunnable = new bjz(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "notifyDataChanged-->Type=" + paramInt);
    }
    y();
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 12))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 1) || (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long != this.jdField_d_of_type_Long)) {
        break label102;
      }
      a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a(this.jdField_a_of_type_JavaUtilArrayList, paramInt);
      return;
      label102:
      a(false);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "enableCameraBtn-->iconPress=" + paramBoolean);
    }
    if (this.jdField_e_of_type_AndroidWidgetButton != null)
    {
      this.jdField_e_of_type_AndroidWidgetButton.setClickable(true);
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
      if (paramBoolean)
      {
        UITools.a(this.jdField_e_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560151));
        this.jdField_e_of_type_AndroidWidgetButton.setSelected(true);
      }
    }
    else
    {
      return;
    }
    UITools.a(this.jdField_e_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560150));
    this.jdField_e_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.e();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().s = true;
        B();
      }
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_JavaLangRunnable == null) {
      this.jdField_g_of_type_JavaLangRunnable = new bkh(this);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_g_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onStop");
    }
    if (this.jdField_b_of_type_Int != 3)
    {
      J();
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false);
      }
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "onDestroy");
    }
    super.g();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.h();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    super.T();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_g_of_type_JavaLangRunnable = null;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    super.f(false);
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI = null;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
  }
  
  public void h() {}
  
  public void k() {}
  
  public void l() {}
  
  public void o() {}
  
  void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "setHFBtnStatus");
    }
    if ((this.jdField_c_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "setHFBtnStatus-->mhandfreeBtn or videocontrol is null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiVideoCtrlLayerUI", 2, "setHFBtnStatus-->deviceName is null");
    return;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().i.equals("DEVICE_SPEAKERPHONE"))
    {
      super.g(2131232199);
      return;
    }
    super.h(2131232199);
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "processExtraData-->mType=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int + " IntentGroupId=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long + " isInRoom=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean + " mRoomDiscussionId=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == null)
    {
      QLog.e("MultiVideoCtrlLayerUI", 2, "get the invalid uin,finish activity!");
      g(true);
      return;
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int;
    if (this.jdField_b_of_type_Int == 3)
    {
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_ArrayOfLong = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong;
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)
    {
      super.f(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long != this.jdField_b_of_type_Long)
      {
        G();
        this.i = false;
        Q();
      }
    }
    for (;;)
    {
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(l));
      return;
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      r();
      break;
      v();
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new bjp(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "pressHandFreeBtn");
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfJavaLangString;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_n_of_type_Boolean) && (arrayOfString != null))
    {
      int m = 0;
      int n = 0;
      label49:
      int k = m;
      if (n < arrayOfString.length)
      {
        k = m;
        if (m == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(arrayOfString[n])) {
            break label209;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_WIREDHEADSET");
          k = 1;
        }
      }
      n = 0;
      label92:
      m = k;
      if (n < arrayOfString.length)
      {
        m = k;
        if (k == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(arrayOfString[n])) {
            break label216;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_BLUETOOTHHEADSET");
          m = 1;
        }
      }
      n = 0;
      for (;;)
      {
        k = m;
        if (n < arrayOfString.length)
        {
          k = m;
          if (m == 0)
          {
            if (!"DEVICE_EARPHONE".equals(arrayOfString[n])) {
              break label223;
            }
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_EARPHONE");
            ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_ear", 0, 0, "", "", "", "");
            k = 1;
          }
        }
        m = k;
        if (k == 0) {
          break;
        }
        return;
        label209:
        n += 1;
        break label49;
        label216:
        n += 1;
        break label92;
        label223:
        n += 1;
      }
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_SPEAKERPHONE");
    ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_voice", 0, 0, "", "", "", "");
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "showToolBars");
    }
    u();
    W();
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "createOrEnterGAudio mType: " + this.jdField_b_of_type_Int + ".DiscussionID=" + this.jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_Long == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoCtrlLayerUI", 2, "createOrEnterGAudio-->mGroupId == 0");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131560197);
      if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        a(4, this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_ArrayOfLong == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiVideoCtrlLayerUI", 2, "createOrEnterGAudio uinList is null");
          }
          g(true);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfLong);
        this.jdField_f_of_type_Boolean = true;
        return;
      }
    } while (this.jdField_b_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfLong);
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "closeRemoteVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.e();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_REQUEST_REMOTE_VIDEO.ordinal());
    }
    M();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new bjl(this), 150L);
  }
  
  void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "initViewList");
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.setOnMemberClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
    d(12);
  }
  
  void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "refreshGAFList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentAvVideoController.a().clone());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUI", 2, "refreshGAFList-->mVideoContrl is null");
  }
  
  public void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "disableCameraBtn");
    }
    if (this.jdField_e_of_type_AndroidWidgetButton != null)
    {
      this.jdField_e_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      UITools.a(this.jdField_e_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560154));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI
 * JD-Core Version:    0.7.0.1
 */