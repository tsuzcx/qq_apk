package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import org.extra.tools.LibraryLoadUtils;

public class PAGLayer
{
  public static final int LayerTypeImage = 5;
  public static final int LayerTypeNull = 1;
  public static final int LayerTypePreCompose = 6;
  public static final int LayerTypeShape = 4;
  public static final int LayerTypeSolid = 2;
  public static final int LayerTypeText = 3;
  public static final int LayerTypeUnknown = 0;
  protected long nativeContext;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGLayer(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  private native void getTotalMatrix(float[] paramArrayOfFloat);
  
  private native void matrix(float[] paramArrayOfFloat);
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  private native void setMatrix(float[] paramArrayOfFloat);
  
  public native long currentTime();
  
  public native long duration();
  
  public native int editableIndex();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PAGLayer)) {
        break;
      }
    } while (hashCode() == paramObject.hashCode());
    return false;
    return false;
  }
  
  protected void finalize()
  {
    nativeRelease();
  }
  
  public native float frameRate();
  
  public native RectF getBounds();
  
  public native double getProgress();
  
  public Matrix getTotalMatrix()
  {
    float[] arrayOfFloat = new float[9];
    getTotalMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  public native long globalToLocalTime(long paramLong);
  
  public int hashCode()
  {
    return (int)(this.nativeContext ^ this.nativeContext >>> 32) + 527;
  }
  
  public native boolean hitTestPoint(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public native String layerName();
  
  public native int layerType();
  
  public native long localTimeToGlobal(long paramLong);
  
  public native PAGMarker[] markers();
  
  public Matrix matrix()
  {
    float[] arrayOfFloat = new float[9];
    matrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  public native PAGComposition parent();
  
  public native void resetMatrix();
  
  public native void setCurrentTime(long paramLong);
  
  public void setMatrix(Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      return;
    }
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    setMatrix(arrayOfFloat);
  }
  
  public native void setProgress(double paramDouble);
  
  public native void setStartTime(long paramLong);
  
  public native void setVisible(boolean paramBoolean);
  
  public native long startTime();
  
  public native PAGLayer trackMatteLayer();
  
  public native boolean visible();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGLayer
 * JD-Core Version:    0.7.0.1
 */