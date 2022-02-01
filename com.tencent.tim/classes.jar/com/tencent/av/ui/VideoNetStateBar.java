package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iid;
import iiv;
import iwu;
import java.lang.ref.WeakReference;
import jfl;

public class VideoNetStateBar
{
  String RM = null;
  String RN = null;
  boolean YK = false;
  boolean YL = false;
  boolean YM = false;
  boolean YN = false;
  boolean YO = false;
  private boolean YP;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  iid jdField_a_of_type_Iid = new jfl(this);
  int ayv = 0;
  int ayw = 0;
  Runnable cj = null;
  ImageView gN = null;
  ImageView gO = null;
  ImageView gP = null;
  View ip = null;
  VideoAppInterface mApp = null;
  WeakReference<Context> mContext = null;
  private int mCurRotate;
  Resources mRes = null;
  WeakReference<ViewGroup> mRootView = null;
  TextView ng = null;
  long pg = -1L;
  
  public VideoNetStateBar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "VideoNetStateBar");
    }
    this.mContext = new WeakReference(paramAVActivity);
    this.mApp = paramVideoAppInterface;
    this.mRootView = new WeakReference(paramViewGroup);
    this.mRes = paramAVActivity.getResources();
    if (this.mApp != null) {
      this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    }
  }
  
  public void avF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDoubleConnected");
    }
    this.ayw = 3;
    this.pg = System.currentTimeMillis();
    avK();
  }
  
  public void avG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onMultiConnected");
    }
    this.ayw = 3;
    avK();
    avH();
  }
  
  void avH()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if ((localiiv != null) && ((localiiv.amI == 3) || (localiiv.amI == 4))) {
        avI();
      }
    }
  }
  
  void avI()
  {
    if (this.mApp == null) {}
    do
    {
      return;
      if (this.cj == null) {
        this.cj = new GroupNetLevelRunnable();
      }
    } while ((this.cj == null) || (this.mApp.getHandler() == null));
    this.mApp.getHandler().removeCallbacks(this.cj);
    this.mApp.getHandler().postDelayed(this.cj, 2000L);
  }
  
  void avJ()
  {
    if (this.mApp == null) {
      return;
    }
    if ((this.cj != null) && (this.mApp.getHandler() != null)) {
      this.mApp.getHandler().removeCallbacks(this.cj);
    }
    this.cj = null;
    this.YO = false;
  }
  
  void avK()
  {
    int k = 1;
    if ((this.gN == null) || (this.gO == null) || (this.gP == null)) {}
    label23:
    label118:
    do
    {
      do
      {
        int i;
        do
        {
          break label23;
          do
          {
            return;
          } while (this.mRes == null);
          i = this.ayw;
        } while (i == 0);
        int j = this.ayv;
        String str;
        if (!TextUtils.isEmpty(this.RM))
        {
          str = this.RM;
          nn(0);
          if (!this.YN) {
            break label396;
          }
          str = this.mRes.getString(2131697936);
          this.gN.setImageResource(2130843070);
          this.gP.setImageResource(2130843070);
          this.gO.setImageResource(2130843070);
          if (i != 1) {
            break label544;
          }
          i = 1;
          this.RN = null;
          if ((!this.YN) && (i == 0)) {
            break label554;
          }
          j = k;
          if (System.currentTimeMillis() - this.pg <= 3000L)
          {
            if (!this.YN) {
              break label549;
            }
            j = k;
          }
          if (j != 0) {
            iwu.a(this.mApp, 3001, str);
          }
        }
        for (;;)
        {
          if (!this.YK) {
            break label584;
          }
          if ((!this.YN) && (i == 0)) {
            break label567;
          }
          if (this.ip != null) {
            this.ip.setVisibility(0);
          }
          avL();
          return;
          switch (i)
          {
          default: 
            if (j == 2) {
              str = this.mRes.getString(2131697939);
            }
            break;
          case 1: 
            if (j == 2)
            {
              str = this.mRes.getString(2131697938);
              break;
            }
            if (j == 1)
            {
              str = this.mRes.getString(2131697941);
              break;
            }
            str = this.mRes.getString(2131697934);
            break;
          case 2: 
            if (j == 2)
            {
              str = this.mRes.getString(2131697940);
              break;
            }
            if (j == 1)
            {
              str = this.mRes.getString(2131697943);
              break;
            }
            str = this.mRes.getString(2131697937);
            break;
            if (j == 1)
            {
              str = this.mRes.getString(2131697942);
              break;
            }
            str = this.mRes.getString(2131697935);
            break;
            switch (i)
            {
            default: 
              this.gN.setImageResource(2130843066);
              this.gP.setImageResource(2130843066);
              this.gO.setImageResource(2130843066);
              break;
            case 1: 
              this.gN.setImageResource(2130843064);
              this.gP.setImageResource(2130843064);
              this.gO.setImageResource(2130843064);
              break;
            case 2: 
              this.gN.setImageResource(2130843068);
              this.gP.setImageResource(2130843068);
              this.gO.setImageResource(2130843068);
              break;
            case 3: 
              this.gN.setImageResource(2130843066);
              this.gP.setImageResource(2130843066);
              this.gO.setImageResource(2130843066);
              break;
              i = 0;
              break label118;
              j = 0;
              break label160;
              iwu.a(this.mApp, 3001);
            }
            break;
          }
        }
      } while (this.ip == null);
      this.ip.setVisibility(8);
      return;
    } while (this.ip == null);
    label160:
    label549:
    label554:
    label567:
    label584:
    this.ip.setVisibility(8);
    label396:
    label544:
    return;
  }
  
  void avL()
  {
    iiv localiiv;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (localiiv != null)
      {
        if ((!localiiv.Qw) && (localiiv.amI != 1) && (localiiv.amI != 2)) {
          break label67;
        }
        anot.a(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
      }
    }
    label67:
    while ((localiiv.amI != 3) && (localiiv.amI != 4)) {
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
  }
  
  public void f(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int j = 3;
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("VideoNetStateBar", 4, String.format("setNetLevel, emNetLevel[%s], selfNetLevel[%s], peerNetLevel[%s], strDetail[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    }
    if (paramInt2 == paramInt3) {
      paramInt2 = j;
    }
    for (;;)
    {
      if ((this.ayw == paramInt1) && (paramInt2 == this.ayv))
      {
        paramInt3 = i;
        if (TextUtils.equals(this.RM, paramString)) {}
      }
      else
      {
        this.ayw = paramInt1;
        this.ayv = paramInt2;
        this.RM = paramString;
        paramInt3 = 1;
      }
      if (paramInt3 != 0) {
        avK();
      }
      return;
      if (paramInt2 > 0) {
        paramInt2 = 1;
      } else if (paramInt3 > 0) {
        paramInt2 = 2;
      } else {
        paramInt2 = 0;
      }
    }
  }
  
  void initUI()
  {
    if ((this.mRootView != null) && (this.mRootView.get() != null))
    {
      this.gN = ((ImageView)((ViewGroup)this.mRootView.get()).findViewById(2131374142));
      this.gO = ((ImageView)((ViewGroup)this.mRootView.get()).findViewById(2131374143));
      this.ip = ((ViewGroup)this.mRootView.get()).findViewById(2131374144);
      this.gP = ((ImageView)((ViewGroup)this.mRootView.get()).findViewById(2131374141));
      this.ng = ((TextView)((ViewGroup)this.mRootView.get()).findViewById(2131365770));
      nm(0);
      if (AudioHelper.jY(0) == 1) {
        this.ip.setBackgroundColor(-822034433);
      }
    }
  }
  
  public void kH(boolean paramBoolean)
  {
    if (this.YK != paramBoolean)
    {
      this.YK = paramBoolean;
      avK();
    }
  }
  
  public void kI(boolean paramBoolean)
  {
    this.YL = paramBoolean;
    if (this.YL) {
      xd();
    }
    avK();
  }
  
  public void kJ(boolean paramBoolean)
  {
    this.YM = paramBoolean;
    if (this.YM) {
      xd();
    }
    avK();
  }
  
  public void kK(boolean paramBoolean)
  {
    this.YN = paramBoolean;
    avK();
  }
  
  public void kL(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView;
      if (this.mRootView.get() == null)
      {
        localView = null;
        if (localView == null) {
          break label48;
        }
      }
      label48:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.YP = paramBoolean;
        return;
        localView = ((ViewGroup)this.mRootView.get()).findViewById(2131374145);
        break;
      }
    }
    this.YP = false;
  }
  
  public void kp(String paramString)
  {
    if (this.ng != null) {
      this.ng.setText(paramString);
    }
  }
  
  public void nl(int paramInt)
  {
    if (this.gO != null) {
      this.gO.setVisibility(8);
    }
  }
  
  void nm(int paramInt)
  {
    if (this.gP != null) {
      this.gP.setVisibility(8);
    }
  }
  
  void nn(int paramInt)
  {
    if (this.gN != null) {
      this.gN.setVisibility(8);
    }
  }
  
  public void no(int paramInt)
  {
    if (this.ip == null) {}
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    do
    {
      return;
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ip.getLayoutParams();
    } while (localMarginLayoutParams == null);
    localMarginLayoutParams.topMargin = paramInt;
    this.ip.setLayoutParams(localMarginLayoutParams);
  }
  
  public void np(int paramInt)
  {
    if (!this.YP) {
      break label7;
    }
    label7:
    label32:
    View localView;
    ViewGroup.LayoutParams localLayoutParams;
    label176:
    label178:
    label196:
    for (;;)
    {
      return;
      if ((paramInt != this.mCurRotate) && (this.ip != null))
      {
        Context localContext;
        if (this.mContext == null)
        {
          localContext = null;
          if (localContext == null) {
            break label176;
          }
          if (this.mRootView.get() != null) {
            break label178;
          }
        }
        for (localView = null;; localView = ((ViewGroup)this.mRootView.get()).findViewById(2131374145))
        {
          if (localView == null) {
            break label196;
          }
          localLayoutParams = this.ip.getLayoutParams();
          if (localLayoutParams == null) {
            break;
          }
          this.mCurRotate = paramInt;
          if ((this.mCurRotate != 90) && (this.mCurRotate != 270)) {
            break label213;
          }
          paramInt = localContext.getResources().getDisplayMetrics().widthPixels - localContext.getResources().getDimensionPixelSize(2131298259);
          localLayoutParams.width = paramInt;
          localLayoutParams.height = paramInt;
          this.ip.setLayoutParams(localLayoutParams);
          this.ip.setRotation(90.0F);
          if (this.mCurRotate != 270) {
            break label198;
          }
          localView.setScaleY(1.0F);
          localView.setScaleX(1.0F);
          return;
          localContext = (Context)this.mContext.get();
          break label32;
          break label7;
        }
      }
    }
    label198:
    localView.setScaleY(-1.0F);
    localView.setScaleX(-1.0F);
    return;
    label213:
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    this.ip.setLayoutParams(localLayoutParams);
    this.ip.setRotation(0.0F);
    if (this.mCurRotate == 0)
    {
      localView.setScaleY(1.0F);
      localView.setScaleX(1.0F);
      return;
    }
    localView.setScaleY(-1.0F);
    localView.setScaleX(-1.0F);
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreate");
    }
    avJ();
    this.YK = false;
    this.YL = false;
    this.YM = false;
    this.ayw = 0;
    this.ayv = 0;
    this.RM = null;
    this.RN = null;
    this.pg = -1L;
    initUI();
    if ((this.mApp != null) && (this.jdField_a_of_type_Iid != null)) {
      this.mApp.addObserver(this.jdField_a_of_type_Iid);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (localiiv != null)
      {
        if (localiiv.Qk)
        {
          localiiv.Qk = false;
          if ((localiiv.amI == 1) || (localiiv.amI == 2) || (localiiv.amI == 3) || (localiiv.amI == 4))
          {
            this.ayw = localiiv.amS;
            this.ayv = localiiv.amT;
          }
        }
        this.YL = localiiv.PV;
        this.YM = localiiv.PW;
      }
    }
    avK();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (localiiv != null)
      {
        localiiv.amT = this.ayv;
        localiiv.amS = this.ayw;
        localiiv.Qk = true;
      }
    }
    if ((this.mApp != null) && (this.jdField_a_of_type_Iid != null)) {
      this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
    }
    avJ();
    this.mContext = null;
    this.mApp = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.mRes = null;
    this.gN = null;
    this.gO = null;
    this.ip = null;
    this.gP = null;
    this.ng = null;
    this.jdField_a_of_type_Iid = null;
    this.mRootView = null;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  boolean xd()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    iiv localiiv;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      bool1 = bool2;
      if (localiiv != null)
      {
        if ((!this.YM) || ((localiiv.amI != 1) && (localiiv.amI != 2))) {
          break label78;
        }
        anot.a(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
        bool1 = true;
      }
    }
    label78:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.YL);
      if (localiiv.amI == 3) {
        break;
      }
      bool1 = bool2;
    } while (localiiv.amI != 4);
    anot.a(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
    return true;
  }
  
  public boolean xe()
  {
    return this.YO;
  }
  
  class GroupNetLevelRunnable
    implements Runnable
  {
    GroupNetLevelRunnable() {}
    
    public void run()
    {
      if (VideoNetStateBar.this.a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoNetStateBar", 2, "mVideoController == null");
        }
        return;
      }
      int i = VideoNetStateBar.this.a.kC();
      VideoNetStateBar.this.YO = true;
      switch (i)
      {
      }
      for (;;)
      {
        VideoNetStateBar.this.ayv = 1;
        if (QLog.isColorLevel()) {
          QLog.d("VideoNetStateBar", 2, String.format("getGAudioNetLevel[%s], mCurNetLevel[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(VideoNetStateBar.this.ayw) }));
        }
        if ((VideoNetStateBar.this.cj == null) || (VideoNetStateBar.this.mApp == null) || (VideoNetStateBar.this.mApp.getHandler() == null)) {
          break;
        }
        VideoNetStateBar.this.mApp.getHandler().postDelayed(VideoNetStateBar.this.cj, 2000L);
        return;
        VideoNetStateBar.this.ayw = 3;
        continue;
        VideoNetStateBar.this.ayw = 2;
        continue;
        VideoNetStateBar.this.ayw = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar
 * JD-Core Version:    0.7.0.1
 */