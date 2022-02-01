package com.tencent.qqmail.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qqmail.download.ImageDownloadManager;

public class LoadingDrawable
  extends AnimationDrawable
{
  private int PAINT_COLOR = -8224126;
  private Resources mResources;
  private int mSize;
  private View mView;
  
  public LoadingDrawable(Resources paramResources, View paramView, int paramInt)
  {
    this.mResources = paramResources;
    this.mSize = paramInt;
    this.mView = paramView;
    setOneShot(false);
    paramInt = i;
    while (paramInt < 12)
    {
      addFrame(getLoadingBitmap(paramInt * 30), 50);
      paramInt += 1;
    }
  }
  
  private Drawable getLoadingBitmap(int paramInt)
  {
    Object localObject3 = "QMLoading:" + this.mSize + ":" + paramInt + ":" + this.PAINT_COLOR;
    Object localObject2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = Bitmap.createBitmap(this.mSize, this.mSize, Bitmap.Config.ARGB_8888);
      ImageDownloadManager.shareInstance().addMemoryCache((String)localObject3, (Bitmap)localObject1);
      int i = this.mSize / 12;
      int j = this.mSize / 6;
      localObject2 = new Paint();
      ((Paint)localObject2).setAntiAlias(true);
      ((Paint)localObject2).setColor(this.PAINT_COLOR);
      ((Paint)localObject2).setStrokeWidth(i);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      localObject3 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject3).rotate(paramInt, this.mSize / 2, this.mSize / 2);
      ((Canvas)localObject3).translate(this.mSize / 2, this.mSize / 2);
      paramInt = 0;
      while (paramInt < 12)
      {
        ((Canvas)localObject3).rotate(30.0F);
        ((Paint)localObject2).setAlpha((int)((paramInt + 1) * 255 / 12.0F));
        ((Canvas)localObject3).translate(0.0F, -this.mSize / 2 + i / 2);
        ((Canvas)localObject3).drawLine(0.0F, 0.0F, 0.0F, j, (Paint)localObject2);
        ((Canvas)localObject3).translate(0.0F, this.mSize / 2 - i / 2);
        paramInt += 1;
      }
    }
    localObject1 = new BitmapDrawable(this.mResources, (Bitmap)localObject1);
    ((BitmapDrawable)localObject1).setCallback(this.mView);
    return localObject1;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
  }
  
  public void start()
  {
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.LoadingDrawable
 * JD-Core Version:    0.7.0.1
 */