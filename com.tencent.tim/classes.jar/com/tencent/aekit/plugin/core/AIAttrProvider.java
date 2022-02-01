package com.tencent.aekit.plugin.core;

import android.util.Log;

public class AIAttrProvider
{
  private static final int DETECT_WAIT_TIMEOUT = 500;
  private static final String TAG = "AIAttrProvider";
  private AIDataSet aiDataSet;
  private Object mFaceAttr;
  private float[] mRotationMatrix = new float[16];
  
  public AIAttrProvider(AIDataSet paramAIDataSet)
  {
    this.aiDataSet = paramAIDataSet;
  }
  
  public void clear()
  {
    this.mFaceAttr = null;
    this.aiDataSet.clear();
    this.aiDataSet = null;
  }
  
  public Object getAvailableData(String paramString)
  {
    if (this.aiDataSet == null) {}
    do
    {
      return null;
      paramString = this.aiDataSet.getAIData(paramString);
    } while (paramString == null);
    for (;;)
    {
      synchronized (paramString.getLock())
      {
        if (paramString.getAttr() != null)
        {
          paramString = paramString.getAttr();
          return paramString;
        }
      }
      paramString = paramString.getLastAttr();
    }
  }
  
  public Object getFaceAttr()
  {
    return this.mFaceAttr;
  }
  
  public Object getRealtimeData(String paramString)
  {
    ??? = null;
    if (this.aiDataSet == null) {
      if (paramString.equals(AEDetectorType.FACE.value)) {
        ??? = this.mFaceAttr;
      }
    }
    AIData localAIData;
    do
    {
      return ???;
      localAIData = this.aiDataSet.getAIData(paramString);
    } while (localAIData == null);
    synchronized (localAIData.getLock())
    {
      for (;;)
      {
        Object localObject2 = localAIData.getAttr();
        if (localObject2 == null) {
          try
          {
            localAIData.getLock().wait(500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.e("AIAttrProvider", paramString + "getRealtimeData failed : " + localInterruptedException.getMessage());
          }
        }
      }
    }
    if ((localAIData.getAttr() == null) && (paramString.equals(AEDetectorType.FACE.value))) {
      return this.mFaceAttr;
    }
    return localAIData.getAttr();
  }
  
  public float[] getRotationMatrix()
  {
    return this.mRotationMatrix;
  }
  
  public void setFaceAttr(Object paramObject)
  {
    this.mFaceAttr = paramObject;
  }
  
  public void setRotationMatrix(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mRotationMatrix, 0, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIAttrProvider
 * JD-Core Version:    0.7.0.1
 */