package com.tencent.mobileqq.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import aqqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.impls.QEffectImageView;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

@SuppressLint({"AppCompatCustomView"})
public class QEffectApngImageView
  extends QEffectImageView
{
  private final String TAG = "QEffectApngImageView";
  private a a;
  
  public QEffectApngImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static a a(int[] paramArrayOfInt, String paramString)
  {
    a locala = new a();
    locala.ot = paramArrayOfInt;
    locala.name = paramString;
    locala.urlStr = paramString;
    return locala;
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.mEffectData = paramQEffectData;
    if (this.mEffectData != null) {
      this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
    }
    if (QEffectUtils.isEmpty(paramQEffectData.src))
    {
      Log.e("QEffectApngImageView", " load data.src is null ");
      return;
    }
    paramContext = paramQEffectView.getExtOptions(paramQEffectData.type);
    if ((paramContext != null) && ((paramContext instanceof a))) {
      this.a = ((a)paramQEffectView.getExtOptions(paramQEffectData.type));
    }
    for (;;)
    {
      paramContext = new Bundle();
      paramContext.putBoolean("key_double_bitmap", true);
      paramContext = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), paramQEffectData.src, this.a.urlStr, this.a.eS, this.a.ot, this.a.name, paramContext);
      if (paramContext != null) {
        break;
      }
      Log.e("QEffectApngImageView", " load apng is null" + paramQEffectData.repeat);
      return;
      this.a = new a();
      this.a.urlStr = String.valueOf(paramQEffectData.effectId);
      this.a.name = String.valueOf(paramQEffectData.effectId);
      this.a.ot = new int[] { paramQEffectData.effectId };
    }
    if ((paramContext.getCurrDrawable() instanceof ApngDrawable)) {
      ((ApngDrawable)paramContext.getCurrDrawable()).getImage().apngLoop = paramQEffectData.repeat;
    }
    complete(paramContext);
  }
  
  public void pause()
  {
    int[] arrayOfInt = this.a.ot;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      ApngImage.pauseByTag(arrayOfInt[i]);
      i += 1;
    }
  }
  
  public void resume()
  {
    int[] arrayOfInt = this.a.ot;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      ApngImage.playByTag(arrayOfInt[i]);
      i += 1;
    }
  }
  
  public static class a
  {
    public Drawable eS;
    public String name;
    public int[] ot;
    public String urlStr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.effect.QEffectApngImageView
 * JD-Core Version:    0.7.0.1
 */