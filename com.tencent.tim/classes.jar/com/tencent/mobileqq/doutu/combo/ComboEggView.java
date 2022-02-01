package com.tencent.mobileqq.doutu.combo;

import afed;
import afee;
import afef;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqdj;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class ComboEggView
  extends RelativeLayout
  implements CustomFrameAnimationDrawable.a
{
  public static final float[] cw = { 0.2786667F, 0.1706667F, 0.1706667F, 0.09066667F };
  public static final int[] kV = { 8, 18, 88, 888 };
  private MqqHandler G;
  public afed a;
  private afef a;
  CustomFrameAnimationDrawable d;
  ImageView gL;
  ImageView mAnimationView;
  private QQAppInterface mApp;
  
  public ComboEggView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void M(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      if (this.d != null)
      {
        this.d.stop();
        this.d.clear();
      }
      paramViewGroup.removeView(this);
    }
    this.G.removeCallbacksAndMessages(null);
  }
  
  public void a(afef paramafef, QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.gL = ((ImageView)findViewById(2131362390));
    this.mAnimationView = ((ImageView)findViewById(2131362389));
    this.G = new MqqHandler(ThreadManager.getFileThreadLooper());
    this.jdField_a_of_type_Afef = paramafef;
    this.jdField_a_of_type_Afed = new afed(null, 0);
  }
  
  public boolean a(afed paramafed)
  {
    this.jdField_a_of_type_Afed = paramafed;
    int i = 0;
    if (i < kV.length) {
      if (paramafed.cQE != kV[i]) {}
    }
    for (;;)
    {
      if (i == -1) {}
      for (;;)
      {
        return false;
        i += 1;
        break;
        if ((!TextUtils.isEmpty(paramafed.uin)) && (this.gL.getVisibility() == 0)) {
          this.gL.setImageDrawable(aqdj.a(this.mApp, 1, paramafed.uin));
        }
        int j = getContext().getResources().getDisplayMetrics().widthPixels;
        int k = getContext().getResources().getDisplayMetrics().heightPixels;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.gL.getLayoutParams();
        float f = j;
        localLayoutParams.setMargins((int)(cw[i] * f), 0, 0, 0);
        localLayoutParams.width = ((int)(j * 0.1573333F));
        localLayoutParams.height = ((int)(j * 0.1573333F));
        File[] arrayOfFile = afee.a(paramafed.cQE);
        if (arrayOfFile != null)
        {
          paramafed = new BitmapFactory.Options();
          paramafed.inSampleSize = 1;
          paramafed.inMutable = true;
          String str = arrayOfFile[0].getAbsolutePath();
          localLayoutParams = null;
          try
          {
            paramafed = aqhu.d(str, paramafed);
            if (paramafed != null)
            {
              this.d = new CustomFrameAnimationDrawable(BaseApplicationImpl.getContext().getResources(), paramafed, this.G);
              i = 1;
              while (i < arrayOfFile.length)
              {
                this.d.u(i - 1, 77, arrayOfFile[i].getAbsolutePath());
                i += 1;
              }
            }
          }
          catch (OutOfMemoryError paramafed)
          {
            for (;;)
            {
              paramafed = localLayoutParams;
              if (QLog.isColorLevel())
              {
                QLog.d("ComboUIManager", 2, " ComboEggView play first bmp oom");
                paramafed = localLayoutParams;
              }
            }
          }
        }
      }
      return true;
      i = -1;
    }
  }
  
  public void onEnd()
  {
    if (this.jdField_a_of_type_Afef != null)
    {
      this.d.clear();
      this.jdField_a_of_type_Afef.a(this);
    }
    this.G.removeCallbacksAndMessages(null);
  }
  
  public void pI()
  {
    this.d.cdJ();
    this.d.a(this);
    this.mAnimationView.setImageDrawable(this.d);
    this.d.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboEggView
 * JD-Core Version:    0.7.0.1
 */