package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bjh;
import bji;
import bjj;
import bjk;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TYPE;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.voip.VoipDialData;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.activity.voip.VoipPhoneNumber;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import java.lang.ref.WeakReference;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  static final String jdField_a_of_type_JavaLangString = "DoubleVideoCtrlUI";
  Button jdField_a_of_type_AndroidWidgetButton = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new bjh(this);
  boolean jdField_a_of_type_Boolean = false;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  Runnable jdField_b_of_type_JavaLangRunnable = new bji(this);
  public boolean b;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_APN_CHANGED.ordinal(), paramInt);
    }
    return 0;
  }
  
  protected void a()
  {
    super.e(2130903347);
    super.a();
    d(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232205));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232207));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232211));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232208));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232209));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232219));
    int i;
    LinearLayout localLinearLayout;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      i = UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localLinearLayout = (LinearLayout)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131232191);
    }
    for (;;)
    {
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232212);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232213);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232215);
      if (i <= 480)
      {
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427673);
        localLayoutParams2.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427673);
        ((ImageView)localObject).setLayoutParams(localLayoutParams1);
        localImageView.setLayoutParams(localLayoutParams1);
        localRelativeLayout.setLayoutParams(localLayoutParams2);
        if (localLinearLayout != null)
        {
          localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427674);
          localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1)
      {
        UITools.a(this.jdField_c_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560158));
        return;
      }
      UITools.a(this.jdField_c_of_type_AndroidWidgetImageButton, this.jdField_a_of_type_AndroidContentResResources.getString(2131560186));
      return;
      localLinearLayout = null;
      i = 0;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
    }
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(View paramView)
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232199: 
      boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().n;
      paramView = this.jdField_a_of_type_ComTencentAvVideoController;
      if (bool2) {
        break;
      }
    case 2131232256: 
    case 2131232205: 
      for (;;)
      {
        DataReport.a(paramView, bool1);
        s();
        W();
        return;
        if (this.jdField_h_of_type_Int - this.jdField_j_of_type_Int > 2)
        {
          this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
          this.jdField_i_of_type_Int = 0;
        }
        this.jdField_i_of_type_Int += 1;
        if (this.jdField_i_of_type_Int <= 5) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(112) });
        this.jdField_i_of_type_Int = 0;
        this.jdField_j_of_type_Int = 0;
        return;
        UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().v) && (this.jdField_a_of_type_ComTencentAvVideoController.a().e())) {
          W();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int != -1) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Boolean = true;
          DataReport.d(this.jdField_a_of_type_ComTencentAvVideoController);
          this.jdField_a_of_type_ComTencentAvVideoController.c(str, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int);
          return;
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int = 0;
        }
        bool1 = false;
      }
    case 2131232200: 
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean)
      {
        bool1 = true;
        paramView.jdField_b_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
          break label473;
        }
        super.g(2131232200);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          UITools.a(this.jdField_d_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131560153));
        }
      }
      for (;;)
      {
        W();
        DataReport.c(this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        bool1 = false;
        break;
        super.h(2131232200);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          UITools.a(this.jdField_d_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131560152));
        }
      }
    case 2131232254: 
      n();
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController);
      return;
    case 2131232201: 
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "qav_bottombar_camera");
      }
      DataReport.n(this.jdField_a_of_type_ComTencentAvVideoController);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "open camera");
        }
        r();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105) });
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int = 2;
        d(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int);
        DataReport.s(this.jdField_a_of_type_ComTencentAvVideoController);
      }
      for (;;)
      {
        W();
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2) {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("DoubleVideoCtrlUI", 2, "remote has video,local close camera");
              }
              q();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
              DataReport.t(this.jdField_a_of_type_ComTencentAvVideoController);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("DoubleVideoCtrlUI", 2, "remote has video,local open camera");
              }
              r();
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105) });
              DataReport.s(this.jdField_a_of_type_ComTencentAvVideoController);
            }
          }
          else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DoubleVideoCtrlUI", 2, "remote has no video,local close camera");
            }
            q();
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int = 1;
            d(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int);
            DataReport.t(this.jdField_a_of_type_ComTencentAvVideoController);
          }
        }
      }
    case 2131232204: 
      DataReport.f(this.jdField_a_of_type_ComTencentAvVideoController);
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      paramView = new Intent(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), VoipDialInterfaceActivity.class);
      VoipPhoneNumber localVoipPhoneNumber = new VoipPhoneNumber(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      paramView.putExtra("dialData", new VoipDialData(localVoipPhoneNumber.jdField_b_of_type_JavaLangString, localVoipPhoneNumber.jdField_a_of_type_JavaLangString));
      paramView.putExtra("callNow", 0);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
      this.jdField_a_of_type_ComTencentAvVideoController.c(str, 0);
      W();
      return;
    case 2131232255: 
      label473:
      DataReport.k(this.jdField_a_of_type_ComTencentAvVideoController);
      paramView = new Intent();
      paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      paramView.setAction("tencent.video.v2q.AddContactsFromC2C");
      paramView.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
      W();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "switchcamera");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107) });
    W();
  }
  
  public void a(String paramString)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString.contains(paramString)))
    {
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int;
      if ((i >= 0) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560257);
      }
      UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165206, -1, null);
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
      }
      if ((i > 0) && (i != 3))
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(i + TipsManager.TYPE.TYPE_AUDIO_FRIEND_MUTE.ordinal() - 1, true);
        }
        DataReport.h(this.jdField_a_of_type_ComTencentAvVideoController);
      }
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int;
      if ((i != 4) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int != 0)) {
        break label199;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_PEER_NOT_DISTURB, true);
    }
    label199:
    do
    {
      do
      {
        do
        {
          return;
        } while (i != 0);
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 0))
        {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_PEER_NOT_DISTURB, true);
          return;
        }
        switch (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int)
        {
        default: 
          return;
        }
      } while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_WELL, true);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_PC, true);
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2) {
      if (this.jdField_k_of_type_Int > 1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
        label38:
        if (!this.jdField_a_of_type_ComTencentAvVideoController.c()) {
          this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().v) {
          break label155;
        }
        super.h(2131232201);
      }
    }
    label155:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      if (!paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.d())
        {
          this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
          break label38;
        }
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
        break label38;
      }
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_AndroidWidgetButton.postDelayed(new bjk(this), 1000L);
      break label38;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) {
        break label192;
      }
      super.g(2131232201);
    } while (this.jdField_k_of_type_Int <= 1);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    return;
    label192:
    super.h(2131232201);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_CALL_PHONE_SELF, true);
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_CALL_PHONE_SELF, false);
          return;
        } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
        str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
        if (!paramBoolean2) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_CALL_PHONE, true);
      return;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_CALL_PHONE, false);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    p();
    return true;
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) {
        super.g(2131232201);
      }
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().c()))
    {
      i = 1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().v) {
        i = 0;
      }
      int j = 1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().m) {
        j = 4;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString, i, j); i != 0; i = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString, i, j, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().d, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoubleVideoCtrlUI", 2, "Video connect fail!");
        }
        if (i == -2)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString, 9);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a()) {
          VideoController.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        this.jdField_a_of_type_Boolean = true;
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        }
        return;
      }
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().e())
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131361910));
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().v)
      {
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean) && (NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().v)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_WIFI, false);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.f())
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC, true);
          }
          super.Q();
          d(true);
          this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject);
          label549:
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232216));
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232218));
            o();
            W();
          }
          super.D();
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int != 1) {
            break label1313;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
          label641:
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b();
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().v) {
            f(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
          }
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
            break label1327;
          }
          super.g(2131232200);
          if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
            UITools.a(this.jdField_d_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131560153));
          }
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1))
      {
        localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232212);
        ImageView localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232213);
        ImageView localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232217);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = new RingAnimator((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (ImageView)localObject, localImageView1, localImageView2);
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.a();
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().e()) {
        a(false);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.post(new bjj(this));
      return;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_NO_MIC, true);
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString) == 5)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NO_RECV_AUDIO_DATA, true);
        }
        DataReport.i(this.jdField_a_of_type_ComTencentAvVideoController);
        break;
      }
      if ((!d()) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_VOICE_LOW, true);
      break;
      if (this.jdField_k_of_type_Int > 1) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      W();
      break;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d())
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().v) {}
        for (i = 2131560197;; i = 2131560127)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(i);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().b())
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().v) && (NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().v))
        {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_WIFI, true);
          DataReport.g(this.jdField_a_of_type_ComTencentAvVideoController);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString))
        {
          this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
          DataReport.e(this.jdField_a_of_type_ComTencentAvVideoController);
        }
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560218);
        break label549;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560214);
        break label549;
      }
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().g())) {
        break label549;
      }
      f(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_l_of_type_Int);
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      break label549;
      label1313:
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      break label641;
      label1327:
      super.h(2131232200);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        UITools.a(this.jdField_d_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131560152));
      }
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NO_RECV_AUDIO_DATA, true);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NO_RECV_AUDIO_DATA, false);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_NO_MIC, false);
      if ((d()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_VOICE_LOW, true);
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.Q();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().b())
      {
        if (!AVReport.a().jdField_a_of_type_Boolean) {
          break label133;
        }
        AVReport.a().j = SystemClock.elapsedRealtime();
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int < 0) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
          break label145;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560257);
        UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165206, -1, null);
        if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
          this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.d();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().e()) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
      }
      return;
      label133:
      AVReport.a().y = SystemClock.elapsedRealtime();
      break;
      label145:
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null) {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.b();
      }
    }
  }
  
  void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (paramInt > 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.d()) {
        this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void d()
  {
    o();
    DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "avSwitch sessionType = " + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232216));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232218));
      o();
      W();
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_NO_CAMERA, false);
      }
    }
    for (;;)
    {
      f(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().v) {
        super.h(2131232201);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
        this.jdField_a_of_type_ComTencentAvVideoController.f(paramInt);
      }
      return;
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().v = false;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (this.jdField_h_of_type_Boolean) {
          W();
        }
        if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_NO_CAMERA, true);
        }
      }
    }
  }
  
  void d(boolean paramBoolean)
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232209)).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232216));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232256));
    this.jdField_f_of_type_AndroidWidgetTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232255));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232218));
      ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232210)).setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvVideoController.c()) {
        break label184;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
    }
    for (;;)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232254);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232210));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label184:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().e())
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString);
        int j = this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString);
        int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
        if ((i >= 16) && (k == 0) && ((j == 4) || (j == 2)))
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
          DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, false);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
          DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController, true);
      }
    }
  }
  
  public void e() {}
  
  public void e(boolean paramBoolean) {}
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(false);
    }
  }
  
  protected void finalize()
  {
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(null);
    super.finalize();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.h();
    super.f(false);
    super.T();
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(null);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232208);
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.g = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_c_of_type_AndroidWidgetButton = null;
    this.jdField_d_of_type_AndroidWidgetButton = null;
    this.jdField_e_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onConnected");
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131361910));
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_WELL.ordinal());
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_PC.ordinal());
    }
    int i;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Int;
      if ((i > 0) && (i != 3)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(i + TipsManager.TYPE.TYPE_AUDIO_FRIEND_MUTE.ordinal() - 1);
      }
      if ((NetworkUtil.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().v)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_WIFI, false);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().n) {
        break label583;
      }
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
        break label619;
      }
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
    }
    for (;;)
    {
      DataReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
      d(true);
      W();
      a(true);
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232198)).setVisibility(0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
      i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      if (this.jdField_a_of_type_ComTencentAvUtilsRingAnimator != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.c();
        this.jdField_a_of_type_ComTencentAvUtilsRingAnimator.e();
      }
      if ((this.jdField_f_of_type_AndroidWidgetButton.isShown()) && (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) && (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null))
      {
        this.jdField_c_of_type_AndroidWidgetImageButton.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        this.jdField_f_of_type_AndroidWidgetButton.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.m);
        if (!this.jdField_a_of_type_ComTencentAvVideoController.c()) {
          this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_NETWORK_BAD.ordinal(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560260));
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 5000L);
      }
      if ((d()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_AUDIO_VOICE_LOW, true);
      }
      return;
      label583:
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      break;
      label619:
      ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoCtrlUI", 2, "onPauseVideo");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) {
      d(1);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_CLOSE_CAMERA, true);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int = 2;
      d(2);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_CLOSE_CAMERA, false);
      }
    }
  }
  
  public void k() {}
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean)
    {
      d(2);
      W();
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int = 2;
      d(2);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_NO_CAMERA, false);
    }
  }
  
  void m()
  {
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232205);
    V();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(localImageButton);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.b();
  }
  
  public void n()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(false) });
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      QQToast.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131560265, 1).b(((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(2131427376));
    }
  }
  
  public void o()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int;
    String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
    String str3 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str2, str3, true, true);
    String str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean)
    {
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str2, str3);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString = str1;
    }
    for (;;)
    {
      if (localBitmap != null) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().b()) {
          d(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        }
        return;
        localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      }
    }
  }
  
  void p()
  {
    if (this.jdField_c_of_type_AndroidWidgetButton == null) {}
    do
    {
      do
      {
        return;
        if (!"DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_JavaLangString)) {
          break;
        }
        super.g(2131232199);
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      UITools.a(this.jdField_c_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131560155));
      return;
      super.h(2131232199);
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    UITools.a(this.jdField_c_of_type_AndroidWidgetButton, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131560156));
  }
  
  void q()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = false;
    super.h(2131232201);
  }
  
  void r()
  {
    if (this.jdField_k_of_type_Int > 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_h_of_type_Boolean = false;
    super.g(2131232201);
  }
  
  void s()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoCtrlUI", 2, "pressHandFreeBtn: mAudioSession is null");
      }
      return;
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfJavaLangString;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().n) && (arrayOfString != null))
    {
      int j = 0;
      int k = 0;
      label64:
      int i = j;
      if (k < arrayOfString.length)
      {
        i = j;
        if (j == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(arrayOfString[k])) {
            break label198;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_WIREDHEADSET");
          i = 1;
        }
      }
      k = 0;
      label107:
      j = i;
      if (k < arrayOfString.length)
      {
        j = i;
        if (i == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(arrayOfString[k])) {
            break label205;
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_BLUETOOTHHEADSET");
          j = 1;
        }
      }
      k = 0;
      for (;;)
      {
        i = j;
        if (k < arrayOfString.length)
        {
          i = j;
          if (j == 0)
          {
            if (!"DEVICE_EARPHONE".equals(arrayOfString[k])) {
              break label212;
            }
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_EARPHONE");
            i = 1;
          }
        }
        j = i;
        if (i == 0) {
          break;
        }
        return;
        label198:
        k += 1;
        break label64;
        label205:
        k += 1;
        break label107;
        label212:
        k += 1;
      }
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b("DEVICE_SPEAKERPHONE");
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().e()))
    {
      if (!this.jdField_h_of_type_Boolean) {
        u();
      }
      return;
    }
    u();
    W();
  }
  
  void u()
  {
    super.u();
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(TipsManager.TYPE.TYPE_VIDEO_REMOTE_NO_CAMERA, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */