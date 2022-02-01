package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.faceBeauty.FaceDetect;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.List;

public class TTpicBitmapFaceDetect
  extends FaceDetect
{
  private volatile boolean inited;
  private long mNativeObjPtr;
  
  public TTpicBitmapFaceDetect()
  {
    if (!FeatureManager.Features.FACE_DETECT.init()) {
      return;
    }
    nativeConstructor();
    this.inited = true;
  }
  
  private void detectParam(Bitmap paramBitmap, boolean paramBoolean, Rect paramRect, Point paramPoint1, Point paramPoint2)
  {
    this.mDetectedFace = false;
    this.mFaceParams.clear();
    this.faceCount = 0;
    if ((!this.inited) || (!BitmapUtils.isLegal(paramBitmap))) {
      return;
    }
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    int i;
    if (m > n)
    {
      i = m;
      i /= 512;
      if (i >= 1) {
        break label1035;
      }
      i = 1;
    }
    label1029:
    label1035:
    for (;;)
    {
      Bitmap localBitmap;
      int j;
      try
      {
        localBitmap = Bitmap.createBitmap(m / i, n / i, Bitmap.Config.ARGB_8888);
        new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(0, 0, m, n), new Rect(0, 0, m / i, n / i), null);
        if (!paramBoolean) {
          break label1009;
        }
        if (paramRect == null)
        {
          paramBitmap = nativeDetectBitmapByEyes(localBitmap, paramPoint1.x / i, paramPoint1.y / i, paramPoint2.x / i, paramPoint2.y / i);
          this.faceCount = size(paramBitmap);
          j = 0;
          if (j >= this.faceCount) {
            break label1029;
          }
          paramPoint1 = paramBitmap[j];
          this.mDetectedFace = true;
          paramRect = new FaceParam();
          paramPoint2 = new Rect();
          paramRect.mFace = paramPoint2;
          paramPoint2.left = (paramPoint1.x * i);
          paramPoint2.top = (paramPoint1.y * i);
          paramPoint2.right = (paramPoint1.x * i + paramPoint1.w * i);
          paramPoint2.bottom = (paramPoint1.y * i + paramPoint1.h * i);
          if (paramPoint2.left < 0) {
            paramPoint2.left = 0;
          }
          if (paramPoint2.top < 0) {
            paramPoint2.top = 0;
          }
          if (paramPoint2.right > m) {
            paramPoint2.right = m;
          }
          if (paramPoint2.bottom > n) {
            paramPoint2.bottom = n;
          }
          int k = (int)(paramPoint1.h * i * 0.16D);
          int i1 = (int)(k * 2.0D);
          paramPoint2 = new Rect();
          paramRect.mLeftEye = paramPoint2;
          paramPoint2.left = (paramPoint1.leftEyeX * i - i1 / 2);
          paramPoint2.right = (paramPoint2.left + i1);
          paramPoint2.top = (paramPoint1.leftEyeY * i - k / 2);
          paramPoint2.bottom = (paramPoint2.top + k);
          paramRect.mLeftEyeCenter = new Point(paramPoint1.leftEyeX * i, paramPoint1.leftEyeY * i);
          Rect localRect1 = new Rect();
          paramRect.mRightEye = localRect1;
          localRect1.left = (paramPoint1.rightEyeX * i - i1 / 2);
          localRect1.right = (i1 + localRect1.left);
          localRect1.top = (paramPoint1.rightEyeY * i - k / 2);
          localRect1.bottom = (k + localRect1.top);
          paramRect.mRightEyeCenter = new Point(paramPoint1.rightEyeX * i, paramPoint1.rightEyeY * i);
          Rect localRect2 = new Rect();
          paramRect.mEye = localRect2;
          localRect2.left = paramPoint2.left;
          localRect2.top = paramPoint2.top;
          localRect2.right = localRect1.right;
          localRect2.bottom = localRect1.bottom;
          if (localRect2.left < 0) {
            localRect2.left = 0;
          }
          if (localRect2.top < 0) {
            localRect2.top = 0;
          }
          if (localRect2.right > m) {
            localRect2.right = m;
          }
          if (localRect2.bottom > n) {
            localRect2.bottom = n;
          }
          k = (int)(paramPoint1.w * i * 0.4D);
          i1 = (int)(paramPoint1.h * i * 0.16D);
          paramPoint2 = new Rect();
          paramRect.mMouth = paramPoint2;
          paramPoint2.left = (paramPoint1.mouthX * i - k / 2);
          paramPoint2.top = (paramPoint1.mouthY * i - i1 / 2);
          paramPoint2.right = (paramPoint2.left + k);
          paramPoint2.bottom = (paramPoint2.top + i1);
          paramRect.width = m;
          paramRect.height = n;
          this.mFaceParams.add(paramRect);
          if (this.mGetFaceGender) {
            this.mFemale.add(Boolean.valueOf(true));
          }
          if (!this.mGetFaceFeatures) {
            break label1020;
          }
          paramPoint1 = nativeGetFeatures(j);
          paramRect.mFaceOutline = paramPoint1;
          i1 = size(paramPoint1);
          k = 0;
          if (k >= i1) {
            break label1020;
          }
          paramPoint1[k][0] *= i;
          paramPoint1[k][1] *= i;
          k += 1;
          continue;
          i = n;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
        return;
      }
      paramBitmap = nativeDetectBitmapByFace(localBitmap, paramRect.left / i, paramRect.top / i, paramRect.width() / i, paramRect.height() / i);
      continue;
      label1009:
      paramBitmap = nativeDetectBitmap(localBitmap, false);
      continue;
      label1020:
      j += 1;
      continue;
      localBitmap.recycle();
      return;
    }
  }
  
  private native boolean nativeConstructor();
  
  private native void nativeDestructor();
  
  private native TTImageFeature[] nativeDetectBitmap(Bitmap paramBitmap, boolean paramBoolean);
  
  private native TTImageFeature[] nativeDetectBitmapByEyes(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native TTImageFeature[] nativeDetectBitmapByFace(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native float[] nativeGetAngles(int paramInt);
  
  private native int[][] nativeGetFeatures(int paramInt);
  
  private native int[][] nativeGetShapePoints(int paramInt);
  
  private native int nativeInit(String paramString);
  
  public void destroy()
  {
    if (this.inited)
    {
      nativeDestructor();
      this.inited = false;
    }
  }
  
  public void detectFaceByManual(Bitmap paramBitmap, Point paramPoint1, Point paramPoint2)
  {
    detectParam(paramBitmap, true, null, paramPoint1, paramPoint2);
  }
  
  public void detectFaceByManual(Bitmap paramBitmap, Rect paramRect, Point paramPoint1, Point paramPoint2)
  {
    detectParam(paramBitmap, true, paramRect, paramPoint1, paramPoint2);
  }
  
  public void doDetectFace(Bitmap paramBitmap)
  {
    detectParam(paramBitmap, false, null, null, null);
  }
  
  public void doInitial() {}
  
  public void doRelease() {}
  
  public float[] getFaceAngles(int paramInt)
  {
    float[] arrayOfFloat = nativeGetAngles(paramInt);
    paramInt = 0;
    while (paramInt < arrayOfFloat.length)
    {
      arrayOfFloat[paramInt] = ((float)(arrayOfFloat[paramInt] * 3.141592653589793D / 180.0D));
      paramInt += 1;
    }
    return arrayOfFloat;
  }
  
  public int size(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    return paramArrayOfObject.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.TTpicBitmapFaceDetect
 * JD-Core Version:    0.7.0.1
 */