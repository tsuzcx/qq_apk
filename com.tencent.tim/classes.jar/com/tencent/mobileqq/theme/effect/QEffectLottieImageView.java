package com.tencent.mobileqq.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import aohi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SuppressLint({"AppCompatCustomView"})
public class QEffectLottieImageView
  extends DiniFlyAnimationView
  implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener
{
  private String TAG = "QEffectLottieImageView";
  private OnCompositionLoadedListener b = new aohi(this);
  private QEffectData mEffectData;
  private boolean mIsStop;
  protected SensorParams mSensorParams;
  
  public QEffectLottieImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static QEffectData a(String paramString, int paramInt)
  {
    QEffectData localQEffectData = new QEffectData();
    localQEffectData.h = -1.0F;
    localQEffectData.w = -1.0F;
    localQEffectData.resType = 1;
    localQEffectData.type = 3;
    localQEffectData.src = paramString;
    localQEffectData.repeat = paramInt;
    return localQEffectData;
  }
  
  public void complete(Drawable paramDrawable) {}
  
  public void draw(Canvas paramCanvas)
  {
    if (!paramCanvas.isHardwareAccelerated()) {
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean isGravityEnable()
  {
    return (this.mEffectData != null) && (this.mEffectData.gravity);
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.mEffectData = paramQEffectData;
    this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
    if ((paramQEffectData.resType == 3) && (paramQEffectData.resId > 0)) {}
    while ((paramQEffectData.resType != 1) || (paramQEffectData.images == null)) {
      return;
    }
    setImageAssetsFolder(paramQEffectData.images);
    try
    {
      paramContext = new FileInputStream(paramQEffectData.src);
      paramQEffectView = new Bundle();
      paramQEffectView.putString("key", paramQEffectData.images + paramQEffectData.effectId);
      paramQEffectView.putString("path", paramQEffectData.images);
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(getContext(), paramContext, getLottieDrawable(), this.b, paramQEffectView, BaseApplicationImpl.sImageCache);
      setImageAssetDelegate(new a());
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      for (;;)
      {
        QLog.e(this.TAG, 1, "QEffectLottieImageView", paramContext);
      }
    }
  }
  
  public void pause()
  {
    pauseAnimation();
  }
  
  public void play()
  {
    this.mIsStop = false;
  }
  
  public void resume()
  {
    resumeAnimation();
  }
  
  public void stop()
  {
    if ((QLog.isColorLevel()) && (!this.mIsStop)) {
      QLog.i(this.TAG, 1, "lottie stop");
    }
    this.mIsStop = true;
    endAnimation();
  }
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.mSensorParams, paramBoolean);
  }
  
  static class a
    implements ImageAssetDelegate
  {
    public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
    {
      if (BaseApplicationImpl.sImageCache != null) {
        return (Bitmap)BaseApplicationImpl.sImageCache.get(paramLottieImageAsset.getKey());
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.effect.QEffectLottieImageView
 * JD-Core Version:    0.7.0.1
 */