package com.tencent.av.utils;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import bmh;
import bmi;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TipsManager
{
  static final String jdField_a_of_type_JavaLangString = "TipsManager";
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public ProgressBar a;
  public TextView a;
  public VideoAppInterface a;
  TipsManager.TYPE jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = false;
  TipsManager.TYPE b;
  public String b;
  public boolean b;
  public TipsManager.TYPE c;
  public boolean c;
  boolean d = false;
  public boolean e = false;
  
  public TipsManager(VideoAppInterface paramVideoAppInterface, LinearLayout paramLinearLayout)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
    this.jdField_c_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131232194));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131232192));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131232193));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new bmi(this);
  }
  
  public TipsManager(VideoAppInterface paramVideoAppInterface, TextView paramTextView, ProgressBar paramProgressBar)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
    this.jdField_c_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetProgressBar = paramProgressBar;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new bmh(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "recoverTips");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      c(this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal());
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showComingCall type = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() <= paramInt)
    {
      if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() > TipsManager.TYPE.TYPE_NONE.ordinal()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() <= TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC.ordinal()))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE;
      }
      c(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showApnTips type = " + paramInt1);
    }
    this.jdField_a_of_type_Int = paramInt2;
    if ((paramInt1 == TipsManager.TYPE.TYPE_APN_CHANGED.ordinal()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() <= paramInt1))
    {
      if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() > TipsManager.TYPE.TYPE_NONE.ordinal()) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() <= TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC.ordinal()))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE;
      }
      c(paramInt1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showNetTips-->Type=" + paramInt + " Str=" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() <= paramInt)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.values()[paramInt];
      this.jdField_b_of_type_JavaLangString = paramString;
      if (this.jdField_b_of_type_JavaLangString == null) {
        break label121;
      }
      c(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "showNetTips type = " + paramInt + " # msg = " + this.jdField_b_of_type_JavaLangString);
      }
    }
    return;
    label121:
    b();
  }
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTips-->Str =" + paramString + " type=" + paramInt + " period=" + paramLong + " flag=" + paramBoolean);
    }
    if (paramInt < this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "showTips-->Type<mCurrentType,mCurrentType=" + this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    b();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.values()[paramInt];
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(TipsManager.TYPE.values()[paramInt], paramBoolean);
  }
  
  public void a(TipsManager.TYPE paramTYPE)
  {
    this.jdField_c_of_type_ComTencentAvUtilsTipsManager$TYPE = paramTYPE;
    this.e = true;
  }
  
  public void a(TipsManager.TYPE paramTYPE, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showStatusTips type = " + paramTYPE);
    }
    if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() != paramTYPE.ordinal()) || (this.jdField_a_of_type_Boolean != paramBoolean))
    {
      if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE == TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC) && (this.jdField_a_of_type_Boolean) && (paramTYPE != TipsManager.TYPE.TYPE_SWITCH_TO_MULTI_REMOTE) && (paramTYPE != TipsManager.TYPE.TYPE_SWITCH_TO_MULTI_LOCAL) && (paramTYPE != TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE;
      }
      if (paramTYPE.ordinal() >= this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal())
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        c(paramTYPE.ordinal());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE == TipsManager.TYPE.TYPE_NONE) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_c_of_type_Boolean)) {
      a(TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC, true);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE == TipsManager.TYPE.TYPE_AUDIO_CLOSE_MIC)) {
      b();
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE == TipsManager.TYPE.TYPE_VIDEO_REMOTE_NO_CAMERA)) {
      b();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean1)
      {
        i = 0;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!paramBoolean2) {
        break label61;
      }
    }
    label61:
    for (int i = j;; i = 8)
    {
      ((ProgressBar)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "remove tip Type=" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() == paramInt)
    {
      b();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "removeTips");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    a(false, true);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showLowerTips type = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal() <= paramInt) {
      c(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  void c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560145);
      a(false, true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    case 2: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560144);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      a(false, true);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560143);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    a(false, true);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  void c(int paramInt)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.values()[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTips mCurrentType = " + this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    label216:
    boolean bool1;
    switch (bmj.a[this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE.ordinal()])
    {
    default: 
      b();
      bool1 = true;
      bool2 = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_b_of_type_JavaLangString != null) {
        a(bool1, bool2);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560277);
        bool1 = true;
        bool2 = false;
      }
      else
      {
        b();
        bool1 = true;
        bool2 = false;
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560077);
          bool1 = true;
          bool2 = false;
        }
        else
        {
          b();
          bool1 = true;
          bool2 = false;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560078);
            if (!this.d) {
              break label216;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
            bool1 = true;
            bool2 = false;
            continue;
          }
          b();
          bool1 = true;
          bool2 = false;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560081);
            bool2 = false;
            bool1 = false;
          }
          else
          {
            b();
            bool2 = false;
            bool1 = false;
            continue;
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560082);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
              bool1 = true;
              bool2 = false;
            }
            else
            {
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560083);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
              bool2 = false;
              bool1 = false;
              continue;
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560074);
                bool2 = false;
                bool1 = false;
              }
              else
              {
                b();
                bool2 = false;
                bool1 = false;
                continue;
                if (this.jdField_a_of_type_Boolean)
                {
                  this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560075);
                  bool2 = false;
                  bool1 = false;
                }
                else
                {
                  b();
                  bool2 = false;
                  bool1 = false;
                  continue;
                  if (this.jdField_a_of_type_Boolean)
                  {
                    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
                    if (localVideoController.b(localVideoController.a().a) == 5)
                    {
                      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560080);
                      this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE;
                      if (this.d) {
                        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                      }
                    }
                    for (;;)
                    {
                      bool1 = true;
                      bool2 = false;
                      break;
                      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560261);
                    }
                  }
                  b();
                  this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
                  bool1 = true;
                  bool2 = false;
                  continue;
                  if (this.jdField_a_of_type_Boolean)
                  {
                    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560079);
                    this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE;
                    if (!this.d) {
                      break label216;
                    }
                    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                    bool1 = true;
                    bool2 = false;
                    continue;
                  }
                  b();
                  this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
                  bool1 = true;
                  bool2 = false;
                  continue;
                  this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560274);
                  this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                  bool1 = true;
                  bool2 = false;
                  continue;
                  if (this.jdField_a_of_type_Boolean)
                  {
                    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560086);
                    this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = this.jdField_a_of_type_ComTencentAvUtilsTipsManager$TYPE;
                    if (!this.d) {
                      break label216;
                    }
                    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                    bool1 = true;
                    bool2 = false;
                    continue;
                  }
                  this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560087);
                  this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                  this.jdField_b_of_type_ComTencentAvUtilsTipsManager$TYPE = TipsManager.TYPE.TYPE_NONE;
                  bool2 = false;
                  bool1 = false;
                  continue;
                  if (this.jdField_a_of_type_Boolean)
                  {
                    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560088);
                    bool1 = true;
                    bool2 = false;
                  }
                  else
                  {
                    a();
                    bool1 = true;
                    bool2 = false;
                    continue;
                    if (this.jdField_a_of_type_Boolean)
                    {
                      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560089);
                      bool1 = true;
                      bool2 = false;
                    }
                    else
                    {
                      a();
                      bool1 = true;
                      bool2 = false;
                      continue;
                      c();
                      bool1 = false;
                      continue;
                      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
                      bool1 = true;
                      bool2 = false;
                      continue;
                      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
                      bool1 = true;
                      bool2 = false;
                      continue;
                      if (this.jdField_a_of_type_Boolean)
                      {
                        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560246);
                        bool2 = false;
                        bool1 = false;
                      }
                      else
                      {
                        b();
                        bool2 = false;
                        bool1 = false;
                        continue;
                        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560102);
                        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                        bool1 = true;
                        bool2 = false;
                        continue;
                        if (this.jdField_a_of_type_Boolean)
                        {
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560076);
                          bool2 = false;
                          bool1 = false;
                        }
                        else
                        {
                          b();
                          bool2 = false;
                          bool1 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560258);
                          bool1 = true;
                          bool2 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560267);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                          bool1 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560266);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                          bool1 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560259);
                          bool1 = true;
                          bool2 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560268);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
                          bool1 = true;
                          bool2 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560269);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560268);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                          bool1 = true;
                          bool2 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560196);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
                          bool1 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560084);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                          bool1 = true;
                          bool2 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560085);
                          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
                          bool1 = true;
                          bool2 = false;
                          continue;
                          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131560275);
                          bool2 = false;
                          bool1 = false;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TipsManager
 * JD-Core Version:    0.7.0.1
 */