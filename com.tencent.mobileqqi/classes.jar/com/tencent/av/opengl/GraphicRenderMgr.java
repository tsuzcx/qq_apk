package com.tencent.av.opengl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;

public class GraphicRenderMgr
{
  static boolean soloaded = false;
  
  public GraphicRenderMgr()
  {
    if (!soloaded) {}
    try
    {
      UpdateAvSo.a(BaseApplicationImpl.getContext(), "qav_graphics");
      soloaded = true;
      setViewBackground(2, 2130838263);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public native void clearCache();
  
  public native int getRecvDecoderFrameFunctionptr();
  
  public native int sendCameraFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
  
  native void setBackgroundBitmap(int paramInt, Object paramObject);
  
  native void setBackgroundRGB565Bitmap(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public native void setLocalGlRender(QQGlRender paramQQGlRender);
  
  public native void setPeerGlRender(QQGlRender paramQQGlRender);
  
  public native void setProcessEncodeFrameFunctionPtr(int paramInt);
  
  public void setViewBackground(int paramInt1, int paramInt2)
  {
    Object localObject = BaseApplicationImpl.getContext();
    int i = UITools.a((Context)localObject);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i >= 720)
    {
      localOptions.inSampleSize = 1;
      localOptions.inDither = true;
    }
    for (;;)
    {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      try
      {
        localObject = BitmapFactory.decodeResource(((Context)localObject).getResources(), paramInt2, localOptions);
        setBackgroundBitmap(paramInt1, localObject);
        ((Bitmap)localObject).recycle();
        return;
      }
      catch (Exception localException)
      {
        Log.e("mlzhong", "setBackgroundBitmap Err");
      }
      if (i >= 480)
      {
        localOptions.inSampleSize = 2;
        localOptions.inDither = false;
      }
      else
      {
        localOptions.inSampleSize = 4;
        localOptions.inDither = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.GraphicRenderMgr
 * JD-Core Version:    0.7.0.1
 */