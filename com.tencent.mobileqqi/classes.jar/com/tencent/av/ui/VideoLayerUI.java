package com.tencent.av.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import blh;
import bli;
import blj;
import blk;
import bll;
import blm;
import bln;
import blo;
import blp;
import blq;
import blr;
import bls;
import blt;
import blu;
import blv;
import bly;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.opengl.QQGlRender;
import com.tencent.av.opengl.QQGlView;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.thread.FutureListener;
import com.tencent.av.widget.RotateLayout;
import com.tencent.av.widget.RotateLayout.LayoutParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class VideoLayerUI
{
  static final String jdField_a_of_type_JavaLangString = "VideoLayerUI";
  static final String jdField_b_of_type_JavaLangString = "cameracfg";
  static final int l = 3000;
  static final int m = 3000;
  int jdField_a_of_type_Int = 0;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  public Context a;
  public Handler a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new bll(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new blq(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new blr(this);
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public bly a;
  public VideoController a;
  public VideoAppInterface a;
  public VcCamera a;
  QQGlRender jdField_a_of_type_ComTencentAvOpenglQQGlRender = null;
  public RotateLayout a;
  Runnable jdField_a_of_type_JavaLangRunnable = new blm(this);
  public List a;
  public boolean a;
  public int b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public bly b;
  QQGlRender jdField_b_of_type_ComTencentAvOpenglQQGlRender = null;
  Runnable jdField_b_of_type_JavaLangRunnable = new bln(this);
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  Runnable c;
  public boolean c;
  public int d;
  Runnable d;
  public boolean d;
  int e;
  public Runnable e;
  public boolean e;
  int f;
  public Runnable f;
  public boolean f;
  public int g;
  public boolean g;
  int jdField_h_of_type_Int = 0;
  boolean jdField_h_of_type_Boolean = false;
  public int i;
  public boolean i;
  int j;
  public boolean j;
  int k;
  public boolean k;
  public boolean l = false;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvCameraVcCamera = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_Bly = null;
    this.jdField_b_of_type_Bly = null;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = new blo(this);
    this.jdField_d_of_type_JavaLangRunnable = new blp(this);
    this.jdField_g_of_type_Int = 3;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_e_of_type_JavaLangRunnable = new blv(this);
    this.jdField_f_of_type_JavaLangRunnable = new bls(this);
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvCameraVcCamera = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvCameraVcCamera.f();
    if (this.jdField_a_of_type_Int > 0)
    {
      paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getSharedPreferences("cameracfg", 0);
      int n = paramVideoAppInterface.getInt("frontCameraRotation", 0);
      int i1 = paramVideoAppInterface.getInt("backCameraRotation", 0);
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true, n);
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false, i1);
    }
    if ("GT-I9308D".equals(Build.MODEL)) {
      this.jdField_k_of_type_Boolean = true;
    }
    f();
    g();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(View paramView)
  {
    int i1 = 0;
    Rect localRect = a();
    int i2 = localRect.centerX();
    int i3 = localRect.centerY();
    int i4 = (paramView.getLeft() + paramView.getRight()) / 2;
    int i5 = (paramView.getTop() + paramView.getBottom()) / 2;
    int n;
    if ((i4 < i2) && (i5 < i3)) {
      n = 1;
    }
    do
    {
      do
      {
        return n;
        if ((i4 < i2) && (i5 > i3)) {
          return 4;
        }
        if ((i4 > i2) && (i5 < i3)) {
          return 2;
        }
        n = i1;
      } while (i4 <= i2);
      n = i1;
    } while (i5 <= i3);
    return 3;
  }
  
  public int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427638);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427639);
    VideoLayerUI.MoveDistanceLevel localMoveDistanceLevel1 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Min;
    localMoveDistanceLevel1 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Min;
    VideoLayerUI.MoveDistanceLevel localMoveDistanceLevel2;
    if (paramInt4 - paramInt2 > n)
    {
      localMoveDistanceLevel1 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive;
      if (paramInt5 - paramInt3 <= i1) {
        break label113;
      }
      localMoveDistanceLevel2 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive;
    }
    for (;;)
    {
      paramInt2 = a(paramView);
      if (paramInt2 != 3) {
        break label191;
      }
      if (paramInt1 != 1) {
        break label140;
      }
      return 3;
      if (paramInt4 - paramInt2 < -n)
      {
        localMoveDistanceLevel1 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative;
        break;
      }
      localMoveDistanceLevel1 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Min;
      break;
      label113:
      if (paramInt5 - paramInt3 < -i1) {
        localMoveDistanceLevel2 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative;
      } else {
        localMoveDistanceLevel2 = VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Min;
      }
    }
    label140:
    if (paramInt1 == 2) {
      return 3;
    }
    if (paramInt1 == 4) {
      return 3;
    }
    if (paramInt1 == 3)
    {
      if (localMoveDistanceLevel1 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative)
      {
        if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative) {
          return 1;
        }
        return 4;
      }
      if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative) {
        return 2;
      }
      return 3;
      label191:
      if (paramInt2 == 2)
      {
        if (paramInt1 == 1) {
          return 2;
        }
        if (paramInt1 == 3) {
          return 2;
        }
        if (paramInt1 == 4) {
          return 2;
        }
        if (paramInt1 == 2)
        {
          if (localMoveDistanceLevel1 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative)
          {
            if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive) {
              return 4;
            }
            return 1;
          }
          if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive) {
            return 3;
          }
          return 2;
        }
      }
      else if (paramInt2 == 1)
      {
        if (paramInt1 == 2) {
          return 1;
        }
        if (paramInt1 == 3) {
          return 1;
        }
        if (paramInt1 == 4) {
          return 1;
        }
        if (paramInt1 == 1)
        {
          if (localMoveDistanceLevel1 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive)
          {
            if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive) {
              return 3;
            }
            return 2;
          }
          if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive) {
            return 4;
          }
          return 1;
        }
      }
      else if (paramInt2 == 4)
      {
        if (paramInt1 == 1) {
          return 4;
        }
        if (paramInt1 == 2) {
          return 4;
        }
        if (paramInt1 == 3) {
          return 4;
        }
        if (paramInt1 == 4)
        {
          if (localMoveDistanceLevel1 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Positive)
          {
            if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative) {
              return 2;
            }
            return 3;
          }
          if (localMoveDistanceLevel2 == VideoLayerUI.MoveDistanceLevel.e_MoveDistance_Negative) {
            return 1;
          }
          return 4;
        }
      }
    }
    return 1;
  }
  
  Rect a()
  {
    return new Rect(0, 0, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight());
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_f_of_type_Boolean);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_g_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.onStarted();
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.onStarted();
      if (this.jdField_k_of_type_Boolean)
      {
        o();
        n();
      }
      d();
      return;
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_g_of_type_Boolean);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_f_of_type_Boolean);
    }
  }
  
  public void a(int paramInt)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_f_of_type_Int = paramInt;
    }
    while ((paramInt == this.jdField_e_of_type_Int) && (paramInt != this.jdField_f_of_type_Int)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramInt != this.jdField_e_of_type_Int) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4))
    {
      int i1 = 1;
      int n = i1;
      if (paramInt == 0)
      {
        n = i1;
        if (this.jdField_e_of_type_Int == -1) {
          n = 0;
        }
      }
      if (n != 0)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int != 2) {
          break label317;
        }
        if ((paramInt != 90) && (paramInt != 270)) {
          break label281;
        }
        ReportController.b(null, "CliOper", "", "", "0X800442B", "0X800442B", 0, 0, "", "", "", "");
      }
    }
    label149:
    if ((this.jdField_b_of_type_Bly != null) && (this.jdField_e_of_type_Int != paramInt))
    {
      if (this.jdField_a_of_type_Bly.jdField_a_of_type_Int != 0) {
        break label416;
      }
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.flushQueueAll();
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_f_of_type_Int = paramInt;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(0);
        this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(0);
        this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(0);
        b(0, this.jdField_b_of_type_Int);
        d(0);
        this.jdField_i_of_type_Int = 0;
        return;
        label281:
        ReportController.b(null, "CliOper", "", "", "0X800442C", "0X800442C", 0, 0, "", "", "", "");
        break label149;
        label317:
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int != 1) {
          break label149;
        }
        if ((paramInt == 90) || (paramInt == 270))
        {
          ReportController.b(null, "CliOper", "", "", "0X8004429", "0X8004429", 0, 0, "", "", "", "");
          break label149;
        }
        ReportController.b(null, "CliOper", "", "", "0X800442A", "0X800442A", 0, 0, "", "", "", "");
        break label149;
        label416:
        this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.flushQueueAll();
      }
    }
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(90);
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.b()) {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(270);
        this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(90);
      }
    }
    for (;;)
    {
      b(90, this.jdField_b_of_type_Int);
      d(90);
      this.jdField_i_of_type_Int = 90;
      return;
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(90);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(270);
      continue;
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(270);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(270);
    }
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(180);
    this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(180);
    this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(180);
    b(180, this.jdField_b_of_type_Int);
    d(180);
    this.jdField_i_of_type_Int = 180;
    return;
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(270);
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.b()) {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(90);
        this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(270);
      }
    }
    for (;;)
    {
      b(270, this.jdField_b_of_type_Int);
      d(270);
      this.jdField_i_of_type_Int = 270;
      return;
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(270);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(90);
      continue;
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(90);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.setGlRotation(90);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    d();
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!this.jdField_d_of_type_Boolean);
    j();
  }
  
  public void a(Handler.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "switchCamera");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(new blk(this, paramCallback));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      p();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = a();
    int n = ((Rect)localObject).width() - paramView.getWidth() - 0;
    int i1 = ((Rect)localObject).height() - paramView.getHeight();
    localObject = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin += paramInt1;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin += paramInt2;
    if (((ViewGroup.MarginLayoutParams)localObject).leftMargin < 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin >= 0) {
        break label120;
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
    }
    for (;;)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      if (((ViewGroup.MarginLayoutParams)localObject).leftMargin <= n) {
        break;
      }
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = n;
      break;
      label120:
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin > i1) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = i1;
      }
    }
  }
  
  void a(QQGlRender paramQQGlRender1, QQGlRender paramQQGlRender2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b(null);
        this.jdField_a_of_type_ComTencentAvVideoController.a(null);
        if (paramQQGlRender1 == this.jdField_a_of_type_ComTencentAvOpenglQQGlRender)
        {
          this.jdField_a_of_type_Bly.a(0);
          this.jdField_b_of_type_Bly.a(1);
          if (paramBoolean)
          {
            paramQQGlRender1.flushQueueAll();
            paramQQGlRender2.flushQueueAll();
            int n = paramQQGlRender2.getGlRotation();
            paramQQGlRender2.setGlRotation(paramQQGlRender1.getGlRotation());
            paramQQGlRender1.setGlRotation(n);
            paramQQGlRender1.SetDisplayMode(false, this.jdField_f_of_type_Boolean);
            paramQQGlRender2.SetDisplayMode(false, this.jdField_g_of_type_Boolean);
            this.jdField_a_of_type_ComTencentAvVideoController.b(paramQQGlRender1);
            this.jdField_a_of_type_ComTencentAvVideoController.a(paramQQGlRender2);
            paramQQGlRender1.notifyupdateui(0, 75);
          }
        }
        else
        {
          if (paramQQGlRender1 != this.jdField_b_of_type_ComTencentAvOpenglQQGlRender) {
            continue;
          }
          this.jdField_a_of_type_Bly.a(1);
          this.jdField_b_of_type_Bly.a(0);
          continue;
        }
        paramQQGlRender1.flushQueue();
      }
      finally {}
      paramQQGlRender2.flushQueue();
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && ((this.jdField_d_of_type_Int != 0) || (this.jdField_c_of_type_Int != 0)) && ((this.jdField_e_of_type_Int == 90) || (this.jdField_e_of_type_Int == 270))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      p();
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown())
    {
      if (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 3000L)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
        b(paramRecvMsg);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 3000L);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 3000L);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecvMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
    b(paramRecvMsg);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 3000L);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setLocalMute isLocalMute: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    d();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QQGlView localQQGlView = (QQGlView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232280);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131232279);
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)localRelativeLayout.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)localQQGlView.getLayoutParams();
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Bly.jdField_a_of_type_Int == 0) {
        localQQGlView.a().showBackground(true);
      }
      localQQGlView.setVisibility(8);
      localRelativeLayout.setVisibility(8);
      return;
    }
    localMarginLayoutParams1.width = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427628);
    localMarginLayoutParams1.height = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427629);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427630);
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427631);
    if (this.jdField_d_of_type_Int == 0) {
      n = i1;
    }
    Rect localRect = a();
    switch (paramInt)
    {
    }
    for (;;)
    {
      localRelativeLayout.setLayoutParams(localMarginLayoutParams1);
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427632);
      localMarginLayoutParams2.topMargin = paramInt;
      localMarginLayoutParams2.leftMargin = paramInt;
      localMarginLayoutParams2.rightMargin = paramInt;
      localMarginLayoutParams2.bottomMargin = paramInt;
      localQQGlView.setLayoutParams(localMarginLayoutParams2);
      localQQGlView.setVisibility(0);
      localRelativeLayout.setVisibility(0);
      localQQGlView.a(true);
      if (this.jdField_b_of_type_Bly.jdField_a_of_type_Int != 0) {
        break;
      }
      localQQGlView.a().showBackground(false);
      return;
      localMarginLayoutParams1.leftMargin = i1;
      localMarginLayoutParams1.topMargin = (this.jdField_c_of_type_Int + n);
      if (this.jdField_d_of_type_Int != 0)
      {
        localMarginLayoutParams1.topMargin = (localRect.height() - localMarginLayoutParams1.height - n - this.jdField_d_of_type_Int);
        continue;
        localMarginLayoutParams1.leftMargin = (localRect.width() - localMarginLayoutParams1.width - i1);
        localMarginLayoutParams1.topMargin = (n + this.jdField_c_of_type_Int);
        if (this.jdField_d_of_type_Int != 0)
        {
          localMarginLayoutParams1.topMargin = (localRect.height() - localMarginLayoutParams1.height - i1 - this.jdField_d_of_type_Int);
          continue;
          localMarginLayoutParams1.leftMargin = i1;
          localMarginLayoutParams1.topMargin = (localRect.height() - localMarginLayoutParams1.height - n - this.jdField_d_of_type_Int);
          continue;
          localMarginLayoutParams1.leftMargin = (localRect.width() - localMarginLayoutParams1.width - i1);
          localMarginLayoutParams1.topMargin = (localRect.height() - localMarginLayoutParams1.height - n - this.jdField_d_of_type_Int);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Handler.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setLocalHasVideo isLocalHasVideo: " + paramBoolean + ", mIsRemoteHasVideo: " + this.jdField_e_of_type_Boolean + ", mIsLocalHasVideo: " + this.jdField_d_of_type_Boolean + ", mIsLocalFront: " + this.jdField_c_of_type_Boolean);
    }
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      a(bool, new blh(this, paramCallback));
      if ((!paramBoolean) || (this.jdField_d_of_type_Boolean)) {
        break label170;
      }
      if (this.jdField_e_of_type_Boolean) {
        break label142;
      }
      a(this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, true);
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      d();
      return;
      bool = false;
      break;
      label142:
      if (this.jdField_e_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
        this.jdField_c_of_type_Boolean = true;
        continue;
        label170:
        if ((!paramBoolean) && (this.jdField_d_of_type_Boolean)) {
          if (this.jdField_e_of_type_Boolean)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
            }
            else
            {
              a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
              this.jdField_c_of_type_Boolean = true;
            }
          }
          else if (!this.jdField_e_of_type_Boolean)
          {
            a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, FutureListener paramFutureListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "pauseVideo pause = " + paramBoolean + " , listener = " + paramFutureListener);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangRunnable, paramFutureListener);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_JavaLangRunnable);
    }
    do
    {
      return;
      if (this.jdField_i_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoLayerUI", 2, "mSurfaceholder == null");
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangRunnable, paramFutureListener);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.flushQueueAll();
      return;
    }
    this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.flushQueueAll();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "isFrontCamera");
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      return this.jdField_a_of_type_ComTencentAvCameraVcCamera.b();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglQQGlRender != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.onStoped();
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.flushQueue();
    }
    if (this.jdField_b_of_type_ComTencentAvOpenglQQGlRender != null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.onStoped();
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.flushQueue();
    }
    if (this.jdField_k_of_type_Boolean) {
      o();
    }
  }
  
  public void b(int paramInt)
  {
    int i3 = 0;
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131232279);
    Object localObject1 = (ViewGroup.MarginLayoutParams)((RelativeLayout)localObject2).getLayoutParams();
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427630);
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427631);
    if (this.jdField_d_of_type_Int == 0) {
      n = i1;
    }
    int i6 = ((RelativeLayout)localObject2).getWidth();
    int i5 = ((RelativeLayout)localObject2).getHeight();
    localObject2 = a();
    int i2;
    switch (paramInt)
    {
    default: 
      i2 = 0;
      i1 = 0;
      n = 0;
    }
    for (;;)
    {
      localObject1 = new blt(this, paramInt, n, i1, i2, i3);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject1, 1L);
      return;
      i3 = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
      int i4 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
      i2 = i1;
      i1 = i3;
      i3 = n;
      n = i1;
      i1 = i4;
      continue;
      i3 = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
      i2 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
      i4 = ((Rect)localObject2).width() - i1 - i6;
      i1 = i3;
      i3 = n;
      n = i1;
      i1 = i2;
      i2 = i4;
      continue;
      i4 = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
      i2 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
      i3 = ((Rect)localObject2).width();
      int i7 = ((Rect)localObject2).height();
      i3 = i3 - i1 - i6;
      i1 = i4;
      i4 = i7 - n - i5;
      n = i1;
      i1 = i2;
      i2 = i3;
      i3 = i4;
      continue;
      i4 = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
      i3 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
      i6 = ((Rect)localObject2).height();
      i2 = i1;
      i1 = i4;
      i4 = i6 - n - i5;
      n = i1;
      i1 = i3;
      i3 = i4;
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt1 == 180)) {
      if ((paramInt2 == 0) || (paramInt2 == 2)) {
        this.jdField_f_of_type_Boolean = false;
      }
    }
    while (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_f_of_type_Boolean);
      this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_g_of_type_Boolean);
      return;
      this.jdField_f_of_type_Boolean = true;
      continue;
      if ((paramInt2 == 0) || (paramInt2 == 2)) {
        this.jdField_f_of_type_Boolean = true;
      } else {
        this.jdField_f_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_g_of_type_Boolean);
    this.jdField_b_of_type_ComTencentAvOpenglQQGlRender.SetDisplayMode(false, this.jdField_f_of_type_Boolean);
  }
  
  public void b(RecvMsg paramRecvMsg)
  {
    String str1 = paramRecvMsg.d();
    String str2 = paramRecvMsg.b();
    String str3 = paramRecvMsg.c();
    paramRecvMsg = paramRecvMsg.e();
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "showRecvMsg friendUin: " + str1 + ", senderUin: " + str2 + ", senderName: " + str3 + ", msg: " + paramRecvMsg);
    }
    d(this.jdField_i_of_type_Int);
    g(true);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str3);
    }
    if ((paramRecvMsg != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      paramRecvMsg = new QQText(paramRecvMsg, 11);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecvMsg);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setRemoteMute isRemoteMute: " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    d();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null)
    {
      SurfaceHolder localSurfaceHolder = ((SurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232281)).getHolder();
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(localSurfaceHolder);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      p();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "setRemoteHasVideo isRemoteHasVideo: " + paramBoolean + ", mIsRemoteHasVideo: " + this.jdField_e_of_type_Boolean + ", mIsLocalHasVideo: " + this.jdField_d_of_type_Boolean + ", mIsLocalFront: " + this.jdField_c_of_type_Boolean);
    }
    if ((paramBoolean) && (!this.jdField_e_of_type_Boolean)) {
      if (!this.jdField_d_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      d();
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
        this.jdField_c_of_type_Boolean = true;
        continue;
        if ((!paramBoolean) && (this.jdField_e_of_type_Boolean)) {
          if (!this.jdField_d_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = true;
            a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
          }
          else if (this.jdField_d_of_type_Boolean)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              a(this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, true);
              this.jdField_c_of_type_Boolean = false;
            }
            else
            {
              a(this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, true);
            }
          }
        }
      }
    }
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "refreshUI mIsRemoteHasVideo: " + this.jdField_e_of_type_Boolean + ", mIsLocalHasVideo: " + this.jdField_d_of_type_Boolean + ", mIsLocalFront: " + this.jdField_c_of_type_Boolean);
    }
    a(this.jdField_f_of_type_Int);
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      a(false, this.jdField_g_of_type_Int);
      e(false);
    }
    for (;;)
    {
      d(this.jdField_i_of_type_Int);
      e();
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        a(true, this.jdField_g_of_type_Int);
        e(false);
      }
      else if (this.jdField_e_of_type_Boolean)
      {
        a(true, this.jdField_g_of_type_Int);
        e(false);
      }
      else
      {
        a(true, this.jdField_g_of_type_Int);
        e(true);
      }
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && ((this.jdField_d_of_type_Int != 0) || (this.jdField_c_of_type_Int != 0)) && ((this.jdField_e_of_type_Int == 90) || (this.jdField_e_of_type_Int == 270)))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      return;
    }
    Object localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131232279);
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427630);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427631);
    int i4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427635);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427633);
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427634);
    if (this.jdField_d_of_type_Int == 0)
    {
      n = i2;
      i1 = i3;
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      if ((this.jdField_d_of_type_Int != 0) || (this.jdField_c_of_type_Int != 0)) {
        paramInt = 0;
      }
      int i5 = this.jdField_g_of_type_Int;
      if (paramInt == 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        if (i5 == 4)
        {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = (((RelativeLayout)localObject1).getWidth() + i3 + i4);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (n + this.jdField_d_of_type_Int);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject2).jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        n = a().width() - ((RelativeLayout)localObject1).getWidth() - i3 - i2 - i4;
        paramInt = n;
        if (n > this.jdField_k_of_type_Int) {
          paramInt = this.jdField_k_of_type_Int;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
        return;
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
        if ((i5 == 1) && (this.jdField_d_of_type_Int != 0)) {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = (((RelativeLayout)localObject1).getWidth() + i3 + i4);
        }
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (n + this.jdField_d_of_type_Int);
        continue;
        if (paramInt == 90)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          if (i5 == 3)
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = i2;
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (((RelativeLayout)localObject1).getHeight() + i1 + i4 + this.jdField_d_of_type_Int);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = i2;
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (n + this.jdField_d_of_type_Int);
          }
        }
        else if (paramInt == 180)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          if (i5 == 2)
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = (((RelativeLayout)localObject1).getWidth() + i3 + i4);
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (n + this.jdField_c_of_type_Int);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = i2;
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (n + this.jdField_c_of_type_Int);
          }
        }
        else if (paramInt == 270)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
          if (i5 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (((RelativeLayout)localObject1).getHeight() + i1 + i4 + this.jdField_c_of_type_Int);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (n + this.jdField_c_of_type_Int);
          }
        }
      }
    }
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
    {
      if ((this.jdField_d_of_type_Int != 0) || (this.jdField_c_of_type_Int != 0)) {
        paramInt = 0;
      }
      if (paramInt == 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_d_of_type_Int + n);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject1).jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        n = a().width() - i2 * 2;
        paramInt = n;
        if (n > this.jdField_k_of_type_Int) {
          paramInt = this.jdField_k_of_type_Int;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
        return;
        if (paramInt == 90)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i2;
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_d_of_type_Int + n);
        }
        else if (paramInt == 180)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = i2;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (this.jdField_c_of_type_Int + n);
        }
        else if (paramInt == 270)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (this.jdField_c_of_type_Int + n);
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_d_of_type_Int + n);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RotateLayout.LayoutParams)localObject1).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    n = a().width() - i2 * 2;
    paramInt = n;
    if (n > this.jdField_k_of_type_Int) {
      paramInt = this.jdField_k_of_type_Int;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    e();
  }
  
  void e()
  {
    QQGlView localQQGlView = (QQGlView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232274);
    if (localQQGlView == null) {
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        localQQGlView.a(this.jdField_h_of_type_Boolean);
        return;
      }
      localQQGlView.a(false);
      return;
    }
    localQQGlView.a(this.jdField_h_of_type_Boolean);
  }
  
  void e(boolean paramBoolean)
  {
    QQGlRender localQQGlRender = ((QQGlView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232274)).a();
    if (paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localQQGlRender.showBackground(paramBoolean);
      return;
    }
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "initQQGlView");
    }
    QQGlView localQQGlView = (QQGlView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232274);
    this.jdField_a_of_type_Bly = new bly(this, 0);
    this.jdField_a_of_type_ComTencentAvOpenglQQGlRender = new QQGlRender(localQQGlView, this.jdField_a_of_type_Bly, 1);
    localQQGlView.setRenderer(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender);
    localQQGlView.setRenderMode(0);
    Object localObject = (QQGlView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232280);
    this.jdField_b_of_type_Bly = new bly(this, 1);
    this.jdField_b_of_type_ComTencentAvOpenglQQGlRender = new QQGlRender((QQGlView)localObject, this.jdField_b_of_type_Bly, 1);
    ((QQGlView)localObject).setRenderer(this.jdField_b_of_type_ComTencentAvOpenglQQGlRender);
    ((QQGlView)localObject).setRenderMode(0);
    ((QQGlView)localObject).setZOrderMediaOverlay(true);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131232279);
    ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((View)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    localQQGlView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      p();
    }
    TextView localTextView;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int n = 0;; n = 8)
    {
      localTextView.setVisibility(n);
      return;
    }
  }
  
  void g()
  {
    SurfaceView localSurfaceView = (SurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232281);
    SurfaceHolder localSurfaceHolder = localSurfaceView.getHolder();
    localSurfaceHolder.addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    localSurfaceHolder.setType(3);
    localSurfaceView.setZOrderMediaOverlay(true);
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "showMsgbox: show = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new blu(this));
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
        return;
      }
    } while (!paramBoolean);
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f1 = ((Transformation)localObject).getAlpha();
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
    localObject = new AlphaAnimation(f1, 1.0F);
    ((AlphaAnimation)localObject).setDuration(1000L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setTag(Long.valueOf(System.currentTimeMillis()));
  }
  
  public void h()
  {
    SurfaceView localSurfaceView = (SurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232281);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localSurfaceView.getLayoutParams();
    localMarginLayoutParams.leftMargin = -3000;
    localSurfaceView.setLayoutParams(localMarginLayoutParams);
  }
  
  public void i()
  {
    boolean bool;
    if (!this.jdField_c_of_type_Boolean)
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (!this.jdField_c_of_type_Boolean) {
        break label98;
      }
      a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, true);
      label34:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int == 4)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label114;
        }
        ReportController.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      d();
      return;
      bool = false;
      break;
      label98:
      a(this.jdField_b_of_type_ComTencentAvOpenglQQGlRender, this.jdField_a_of_type_ComTencentAvOpenglQQGlRender, true);
      break label34;
      label114:
      ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
    }
  }
  
  void j()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    k();
    if (this.jdField_k_of_type_Boolean) {
      o();
    }
    ActionSheet localActionSheet = ActionSheet.b(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.c(2131560116);
    localActionSheet.a(new bli(this));
    localActionSheet.setOnDismissListener(new blj(this));
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.f(150);
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.l = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k()
  {
    if ((!this.l) || ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label31:
      this.l = false;
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) && (this.jdField_a_of_type_Int > 0))
    {
      if ((this.jdField_a_of_type_Int == 1) || (!this.jdField_a_of_type_ComTencentAvCameraVcCamera.b()))
      {
        n = this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false) + 90;
        i1 = n % 360 / 90;
        this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false, n);
        this.jdField_a_of_type_ComTencentAvVideoController.a(2, i1);
      }
    }
    else {
      return;
    }
    int n = this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true) + 90;
    int i1 = n % 360 / 90;
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true, n);
    this.jdField_a_of_type_ComTencentAvVideoController.a(1, i1);
  }
  
  public void m()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getSharedPreferences("cameracfg", 0).edit();
    int n = this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true);
    int i1 = this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false);
    localEditor.putInt("frontCameraRotation", n);
    localEditor.putInt("backCameraRotation", i1);
    localEditor.commit();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetButton.setText("Click back to Video Chat");
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-7829368);
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2010;
    localLayoutParams.format = 1;
    localLayoutParams.flags = 296;
    localLayoutParams.width = 1;
    localLayoutParams.height = 1;
    localLayoutParams.gravity = 48;
    localWindowManager.addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
  }
  
  void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidWidgetButton);
      this.jdField_a_of_type_AndroidWidgetButton = null;
    }
  }
  
  void p()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131232275));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131232276));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232277));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232278));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_j_of_type_Int = ((int)localResources.getDimension(2131427681));
      this.jdField_k_of_type_Int = ((int)localResources.getDimension(2131427682));
      int n = (int)(localResources.getDimension(2131427461) + localResources.getDimension(2131427467));
      int i1 = (int)(localResources.getDimension(2131427459) + localResources.getDimension(2131427465));
      int i2 = (int)(localResources.getDimension(2131427462) + localResources.getDimension(2131427468));
      float f1 = localResources.getDimension(2131427460);
      int i3 = (int)(localResources.getDimension(2131427466) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(n, i1, i2, i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_j_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_k_of_type_Int);
    }
  }
  
  void q()
  {
    if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout != null) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 10000L)) {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */