package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.qphone.base.util.QLog;

public class CircleVideoDrawableView
  extends CircleBubbleImageView
  implements VideoDrawable.OnAudioPlayOnceListener
{
  a a;
  public String cAk;
  public URLDrawable v;
  
  public CircleVideoDrawableView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " onFinish ");
    }
    if (this.a != null) {
      this.a.ehO();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.v)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.v) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = this.v.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable)))
    {
      paramURLDrawable = (VideoDrawable)paramURLDrawable;
      paramURLDrawable.resetAndPlayAudioOnce();
      paramURLDrawable.setOnAudioPlayOnceListener(this);
    }
    if (this.a != null) {
      this.a.ehN();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    if (this.v != null)
    {
      this.v.setURLDrawableListener(null);
      Object localObject = this.v.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof VideoDrawable)))
      {
        localObject = (VideoDrawable)localObject;
        ((VideoDrawable)localObject).stopAudio();
        ((VideoDrawable)localObject).setOnAudioPlayOnceListener(null);
      }
    }
    paramURLDrawable.setURLDrawableListener(this);
    setImageDrawable(paramURLDrawable);
    this.v = paramURLDrawable;
    paramURLDrawable = this.v.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnAudioPlayOnceListener(this);
    }
  }
  
  public void setVideoListener(a parama)
  {
    this.a = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.cAk = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void ehN();
    
    public abstract void ehO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleVideoDrawableView
 * JD-Core Version:    0.7.0.1
 */