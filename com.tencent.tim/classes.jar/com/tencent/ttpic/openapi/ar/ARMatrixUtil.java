package com.tencent.ttpic.openapi.ar;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.ar.sensor.orientationProvider.ImprovedOrientationSensor2Provider;
import com.tencent.ttpic.ar.sensor.orientationProvider.OrientationProvider;
import com.tencent.ttpic.ar.sensor.orientationProvider.SimpleOrientationSensorProvider;
import java.util.HashSet;

public class ARMatrixUtil
{
  private static String[] blackList = { "XIAOMI_Redmi_Note_2" };
  private static HashSet<String> blackSet;
  public static float cameraRightX;
  public static float cameraRightY;
  public static float cameraRightZ;
  public static float cameraUpX;
  public static float cameraUpY;
  public static float cameraUpZ;
  public static float cameraX;
  public static float cameraY;
  public static float cameraZ;
  private static boolean canUseImprovedSensorProvider;
  public static float far;
  public static boolean isFrontCamera;
  private static boolean isInBlackList = false;
  private static boolean isProjectionMatInitialized;
  private static float[] mMVPMatrix;
  private static float[] mProjectionMatrix = new float[16];
  private static float[] mViewMatrix = new float[16];
  public static float near;
  public static float nearRectHeight;
  public static float nearRectWidth;
  public static OrientationProvider orientationProvider;
  private static int renderHeight;
  private static int renderWidth;
  
  static
  {
    mMVPMatrix = new float[16];
    canUseImprovedSensorProvider = true;
    blackSet = new HashSet();
  }
  
  public static float[] calProjectionMatrix(float paramFloat1, float paramFloat2)
  {
    if (!isProjectionMatInitialized)
    {
      nearRectWidth = 56.25F;
      float f4 = renderHeight * 1.0F / renderWidth;
      float f1 = -nearRectWidth / 2.0F;
      float f2 = nearRectWidth / 2.0F;
      float f3 = -nearRectWidth / 2.0F * f4;
      f4 = nearRectWidth / 2.0F * f4;
      nearRectHeight = f4 - f3;
      near = paramFloat1;
      far = paramFloat2;
      Matrix.frustumM(mProjectionMatrix, 0, f1, f2, f3, f4, near, far);
      isProjectionMatInitialized = true;
    }
    return mProjectionMatrix;
  }
  
  public static float[] calViewMatrix()
  {
    Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, 0.0F, cameraX, cameraY, cameraZ, cameraUpX, cameraUpY, cameraUpZ);
    return mViewMatrix;
  }
  
  private static void changeToSimpleOrientationProvider()
  {
    orientationProvider.stop();
    orientationProvider = new SimpleOrientationSensorProvider((SensorManager)AEModule.getContext().getSystemService("sensor"));
    orientationProvider.start();
  }
  
  private static float cos(float paramFloat)
  {
    return (float)Math.cos(paramFloat);
  }
  
  public static float[] getMovedMVPMatrix(float paramFloat1, float paramFloat2)
  {
    calProjectionMatrix(paramFloat1, paramFloat2);
    calViewMatrix();
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    return mMVPMatrix;
  }
  
  private static void getRotation44(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = new float[3];
    int i = 0;
    while (i < 3)
    {
      paramArrayOfFloat1[i] *= 0.01745329F;
      i += 1;
    }
    paramArrayOfFloat2[0] = (cos(arrayOfFloat[0]) * cos(arrayOfFloat[1]) * 1.0F);
    paramArrayOfFloat2[1] = (sin(arrayOfFloat[0]) * cos(arrayOfFloat[1]) * 1.0F);
    paramArrayOfFloat2[2] = (-1.0F * sin(arrayOfFloat[1]));
    paramArrayOfFloat2[4] = ((cos(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * sin(arrayOfFloat[2]) - sin(arrayOfFloat[0]) * cos(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[5] = ((sin(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * sin(arrayOfFloat[2]) + cos(arrayOfFloat[0]) * cos(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[6] = (cos(arrayOfFloat[1]) * sin(arrayOfFloat[2]) * 1.0F);
    paramArrayOfFloat2[8] = ((cos(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * cos(arrayOfFloat[2]) + sin(arrayOfFloat[0]) * sin(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[9] = ((sin(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * cos(arrayOfFloat[2]) - cos(arrayOfFloat[0]) * sin(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[10] = (cos(arrayOfFloat[1]) * cos(arrayOfFloat[2]) * 1.0F);
    paramArrayOfFloat2[15] = 1.0F;
  }
  
  private static boolean hasGyroscope()
  {
    return AEModule.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
  }
  
  private static boolean isSensorDataNaN(float[] paramArrayOfFloat)
  {
    boolean bool = false;
    if ((Float.isNaN(paramArrayOfFloat[0])) || (Float.isNaN(paramArrayOfFloat[1])) || (Float.isNaN(paramArrayOfFloat[2]))) {
      bool = true;
    }
    return bool;
  }
  
  public static void setIsInBlackList(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = blackList;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      blackSet.add(str);
      i += 1;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (blackSet.contains(paramString)) {
        bool1 = true;
      }
    }
    isInBlackList = bool1;
  }
  
  public static void setOrientationVector(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f = paramFloat1;
    if (isFrontCamera) {
      f = -paramFloat1;
    }
    cameraRightX = f;
    paramFloat1 = paramFloat2;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat2;
    }
    cameraRightY = paramFloat1;
    paramFloat1 = paramFloat3;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat3;
    }
    cameraRightZ = paramFloat1;
    paramFloat1 = paramFloat4;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat4;
    }
    cameraX = paramFloat1;
    paramFloat1 = paramFloat5;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat5;
    }
    cameraY = paramFloat1;
    paramFloat1 = paramFloat6;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat6;
    }
    cameraZ = paramFloat1;
    paramFloat1 = cameraRightX;
    paramFloat2 = cameraRightY;
    paramFloat3 = cameraRightZ;
    paramFloat4 = cameraX;
    paramFloat5 = cameraY;
    paramFloat6 = cameraZ;
    float[] arrayOfFloat = vectorNormalization(vectorCrossProduct(new float[] { paramFloat1, paramFloat2, paramFloat3 }, new float[] { paramFloat4, paramFloat5, paramFloat6 }));
    cameraUpX = arrayOfFloat[0];
    cameraUpY = arrayOfFloat[1];
    cameraUpZ = arrayOfFloat[2];
  }
  
  private static float sin(float paramFloat)
  {
    return (float)Math.sin(paramFloat);
  }
  
  public static void startOrientationSensor()
  {
    boolean bool;
    if (orientationProvider == null)
    {
      if ((!hasGyroscope()) || (isInBlackList)) {
        break label60;
      }
      bool = true;
      canUseImprovedSensorProvider = bool;
      if (!canUseImprovedSensorProvider) {
        break label65;
      }
    }
    label60:
    label65:
    for (Object localObject = new ImprovedOrientationSensor2Provider((SensorManager)AEModule.getContext().getSystemService("sensor"));; localObject = new SimpleOrientationSensorProvider((SensorManager)AEModule.getContext().getSystemService("sensor")))
    {
      orientationProvider = (OrientationProvider)localObject;
      orientationProvider.start();
      return;
      bool = false;
      break;
    }
  }
  
  public static void stopOrientationSensor()
  {
    if (orientationProvider != null) {
      orientationProvider.stop();
    }
  }
  
  public static void updateOrientation()
  {
    float[] arrayOfFloat2 = new float[3];
    orientationProvider.getEulerAngles(arrayOfFloat2);
    if ((canUseImprovedSensorProvider) && (isSensorDataNaN(arrayOfFloat2)))
    {
      changeToSimpleOrientationProvider();
      canUseImprovedSensorProvider = false;
      return;
    }
    float[] arrayOfFloat1 = new float[16];
    getRotation44(arrayOfFloat2, arrayOfFloat1);
    arrayOfFloat2 = new float[16];
    Matrix.multiplyMM(arrayOfFloat2, 0, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }, 0, arrayOfFloat1, 0);
    setOrientationVector(arrayOfFloat2[4], arrayOfFloat2[6], arrayOfFloat2[5], -arrayOfFloat2[8], -arrayOfFloat2[10], -arrayOfFloat2[9]);
  }
  
  public static void updateRenderSize(int paramInt1, int paramInt2)
  {
    isProjectionMatInitialized = false;
    renderWidth = paramInt1;
    renderHeight = paramInt2;
  }
  
  private static float[] vectorCrossProduct(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[1] * paramArrayOfFloat2[2] - paramArrayOfFloat1[2] * paramArrayOfFloat2[1], paramArrayOfFloat1[2] * paramArrayOfFloat2[0] - paramArrayOfFloat1[0] * paramArrayOfFloat2[2], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] - paramArrayOfFloat1[1] * paramArrayOfFloat2[0] };
  }
  
  private static float[] vectorNormalization(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    float f = (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1] + paramArrayOfFloat[2] * paramArrayOfFloat[2]);
    if (f > 0.0D)
    {
      paramArrayOfFloat[0] /= f;
      paramArrayOfFloat[1] /= f;
      paramArrayOfFloat[2] /= f;
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ar.ARMatrixUtil
 * JD-Core Version:    0.7.0.1
 */