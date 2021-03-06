package com.enrique.stackblur;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class NativeBlurProcess
  implements BlurProcess
{
  static
  {
    System.loadLibrary("blur");
  }
  
  private static native void functionToBlur(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public Bitmap blur(Bitmap paramBitmap, float paramFloat)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    int j = StackBlurManager.EXECUTOR_THREADS;
    ArrayList localArrayList1 = new ArrayList(j);
    ArrayList localArrayList2 = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList1.add(new NativeTask(paramBitmap, (int)paramFloat, j, i, 1));
      localArrayList2.add(new NativeTask(paramBitmap, (int)paramFloat, j, i, 2));
      i += 1;
    }
    try
    {
      StackBlurManager.EXECUTOR.invokeAll(localArrayList1);
      try
      {
        StackBlurManager.EXECUTOR.invokeAll(localArrayList2);
        return paramBitmap;
      }
      catch (InterruptedException localInterruptedException1)
      {
        return paramBitmap;
      }
      return paramBitmap;
    }
    catch (InterruptedException localInterruptedException2) {}
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  static class NativeTask
    implements Callable<Void>
  {
    private final Bitmap _bitmapOut;
    private final int _coreIndex;
    private final int _radius;
    private final int _round;
    private final int _totalCores;
    
    public NativeTask(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this._bitmapOut = paramBitmap;
      this._radius = paramInt1;
      this._totalCores = paramInt2;
      this._coreIndex = paramInt3;
      this._round = paramInt4;
    }
    
    public Void call()
      throws Exception
    {
      NativeBlurProcess.functionToBlur(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.enrique.stackblur.NativeBlurProcess
 * JD-Core Version:    0.7.0.1
 */