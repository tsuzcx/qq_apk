package com.tencent.mobileqq.activity.richmedia.view;

import aavm;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import aqnm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SensorFrameImageView
  extends URLImageView
  implements Handler.Callback
{
  private static final int clz = aqnm.dpToPx(5.0F);
  private float[] J = new float[3];
  private Sensor a;
  private float[] aV = new float[3];
  private Sensor b;
  private boolean bAu;
  private int clx;
  private int cly;
  private List<String> eK = new ArrayList();
  private Sensor h;
  private float kQ;
  private int mCurrentIndex = -1;
  private URLDrawable mDecoding;
  private int mDirection = 0;
  private Handler mHandler = new Handler(this);
  private float[] mMagneticFieldValues = new float[3];
  private int mMaxIndex;
  private int mMinIndex;
  private SensorEventListener mSensorEventListener = new aavm(this);
  private SensorManager mSensorManager;
  
  public SensorFrameImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SensorFrameImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SensorFrameImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void GD(int paramInt)
  {
    Object localObject;
    if ((this.eK != null) && (this.eK.size() > 0) && (this.eK.size() > paramInt) && (paramInt >= 0))
    {
      localObject = (String)this.eK.get(paramInt);
      QLog.d("SensorFrameImageView", 2, "path =" + (String)localObject);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      if (((URLDrawable)localObject).getStatus() != 1) {
        break label111;
      }
      setImageDrawable((Drawable)localObject);
      this.mCurrentIndex = paramInt;
    }
    label111:
    while (this.mDirection != 0) {
      return;
    }
    setDecodingDrawable((URLDrawable)localObject);
    ((URLDrawable)localObject).startDownload();
  }
  
  private void GE(int paramInt)
  {
    if ((this.eK != null) && (this.eK.size() > 0) && (this.eK.size() > paramInt) && (paramInt >= 0))
    {
      Object localObject = (String)this.eK.get(paramInt);
      QLog.d("SensorFrameImageView", 2, "path =" + (String)localObject);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).startDownload();
      }
    }
  }
  
  private void ali()
  {
    float[] arrayOfFloat1 = new float[3];
    float[] arrayOfFloat2 = new float[9];
    SensorManager.getRotationMatrix(arrayOfFloat2, null, this.J, this.mMagneticFieldValues);
    SensorManager.getOrientation(arrayOfFloat2, arrayOfFloat1);
    this.cly = Math.abs((int)Math.toDegrees(arrayOfFloat1[2]));
    if (this.cly > 20) {
      this.cly = 20;
    }
  }
  
  private void ay(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.clx > 0) && (paramInt1 >= 0) && (paramInt1 < this.clx))
    {
      this.mDirection = paramInt2;
      switch (paramInt2)
      {
      default: 
        return;
      case 1: 
        paramInt3 = paramInt1 + paramInt3;
        paramInt2 = paramInt3;
        if (paramInt3 > this.clx) {
          paramInt2 = this.clx;
        }
        paramInt3 = paramInt1;
        while (paramInt3 < paramInt2)
        {
          GE(paramInt3);
          paramInt3 += 1;
        }
        this.mMinIndex = paramInt1;
        this.mMaxIndex = (paramInt2 - 1);
        czx();
        return;
      }
      paramInt3 = paramInt1 - paramInt3;
      paramInt2 = paramInt3;
      if (paramInt3 < 0) {
        paramInt2 = 0;
      }
      paramInt3 = paramInt1;
      while (paramInt3 > paramInt2)
      {
        GE(paramInt3);
        paramInt3 -= 1;
      }
      this.mMinIndex = paramInt2;
      this.mMaxIndex = paramInt1;
      czx();
      return;
    }
    QLog.d("SensorFrameImageView", 2, "onIndexChanged miss index=" + paramInt1);
  }
  
  private void czw()
  {
    float f = this.aV[1] * 10.0F;
    int i;
    if (Math.abs(f) >= 5.0F)
    {
      i = this.mCurrentIndex;
      if (f <= 0.0F) {
        break label45;
      }
      ay(i + 1, 1, (int)(f / 5.0F));
    }
    label45:
    while (f >= 0.0F) {
      return;
    }
    ay(i - 1, 2, (int)(f * -1.0F / 5.0F));
  }
  
  private void czx()
  {
    czy();
    this.mHandler.sendEmptyMessage(1);
  }
  
  private void czy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1);
    }
  }
  
  public void alg()
  {
    if ((getContext() == null) && (this.clx <= 0)) {}
    do
    {
      do
      {
        return;
        if (this.mSensorManager == null) {
          this.mSensorManager = ((SensorManager)getContext().getSystemService("sensor"));
        }
        if ((this.a == null) && (this.mSensorManager != null)) {
          this.a = this.mSensorManager.getDefaultSensor(1);
        }
        if ((this.b == null) && (this.mSensorManager != null)) {
          this.b = this.mSensorManager.getDefaultSensor(2);
        }
        if ((this.h == null) && (this.mSensorManager != null)) {
          this.h = this.mSensorManager.getDefaultSensor(4);
        }
      } while (this.mSensorManager == null);
      QLog.d("SensorFrameImageView", 2, "register sensor event Listener");
      if (this.a != null) {
        this.mSensorManager.registerListener(this.mSensorEventListener, this.a, 3);
      }
      if (this.b != null) {
        this.mSensorManager.registerListener(this.mSensorEventListener, this.b, 3);
      }
    } while (this.h == null);
    this.mSensorManager.registerListener(this.mSensorEventListener, this.h, 3);
  }
  
  public void alh()
  {
    if (this.mSensorManager != null)
    {
      QLog.d("SensorFrameImageView", 2, "unregister sensor event Listener");
      this.mSensorManager.unregisterListener(this.mSensorEventListener);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.mMinIndex <= this.mMaxIndex)
      {
        if (this.mDirection == 0) {
          GD(this.mMinIndex);
        }
        for (;;)
        {
          if (this.mMinIndex != this.mMaxIndex) {
            break label148;
          }
          czy();
          break;
          int i;
          if ((this.mDirection == 1) && (this.mMinIndex < this.mMaxIndex))
          {
            i = this.mMinIndex + 1;
            this.mMinIndex = i;
            GD(i);
          }
          else if ((this.mDirection == 2) && (this.mMinIndex < this.mMaxIndex))
          {
            i = this.mMaxIndex - 1;
            this.mMaxIndex = i;
            GD(i);
          }
        }
        label148:
        czx();
      }
      else
      {
        czy();
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.mDecoding)
    {
      setImageDrawable(this.mDecoding);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.mDecoding)
    {
      Drawable localDrawable = getDrawable();
      if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
      {
        this.bAu = true;
        setImageDrawable(this.mDecoding);
        this.bAu = false;
        return;
      }
      setImageDrawable(this.mDecoding);
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    float f2;
    do
    {
      for (;;)
      {
        return true;
        this.kQ = f1;
      }
      f2 = f1 - this.kQ;
    } while (Math.abs(f2) < clz);
    this.kQ = f1;
    int j = this.mCurrentIndex;
    int i;
    if ((f2 > 0.0F) && (j > 0)) {
      i = j - 1;
    }
    for (;;)
    {
      QLog.d("SensorFrameImageView", 2, "onTouchEvent index=" + i);
      break;
      i = j;
      if (f2 < 0.0F)
      {
        i = j;
        if (j < this.clx - 1) {
          i = j + 1;
        }
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.bAu) {
      super.requestLayout();
    }
  }
  
  public void setDecodingDrawable(URLDrawable paramURLDrawable)
  {
    if (this.mDecoding != null) {
      this.mDecoding.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.mDecoding = paramURLDrawable;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.mDecoding != null)
    {
      this.mDecoding.setURLDrawableListener(null);
      this.mDecoding = null;
    }
  }
  
  public void setImagePathList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.eK = paramList;
      this.clx = paramList.size();
      this.mCurrentIndex = (this.clx / 2);
      GD(this.mCurrentIndex);
      alg();
      return;
    }
    this.eK.clear();
    this.clx = 0;
    alh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.SensorFrameImageView
 * JD-Core Version:    0.7.0.1
 */