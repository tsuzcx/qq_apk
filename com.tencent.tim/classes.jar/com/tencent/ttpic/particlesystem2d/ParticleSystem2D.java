package com.tencent.ttpic.particlesystem2d;

import android.content.Context;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;
import java.util.List;

public class ParticleSystem2D
{
  private static final String TAG = ParticleSystem2D.class.getSimpleName();
  private List<ParticleTemplate2D> mClouds = new ArrayList();
  final Context mContext;
  private long mNativeCtx;
  
  public ParticleSystem2D(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNativeCtx = nativeInit();
  }
  
  private void loadFinish()
  {
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; i < this.mClouds.size(); k = m)
    {
      ParticleTemplate2D localParticleTemplate2D = (ParticleTemplate2D)this.mClouds.get(i);
      m = k + localParticleTemplate2D.mMaxCount;
      k = j;
      if (localParticleTemplate2D.mMaxCount > j) {
        k = localParticleTemplate2D.mMaxCount;
      }
      i += 1;
      j = k;
    }
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
  }
  
  public static native int nativeAdvance(long paramLong, Object[] paramArrayOfObject, int paramInt);
  
  public static native int nativeClearParticles(long paramLong, int paramInt);
  
  public static native long nativeEmitAt(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native long nativeInit();
  
  public static native void nativeRegisterTemplate(long paramLong, Object[] paramArrayOfObject);
  
  public static native void nativeRelease(long paramLong);
  
  public static native int nativeReset(long paramLong);
  
  public int advance(ParticleItem[] paramArrayOfParticleItem, int paramInt)
  {
    int k = paramArrayOfParticleItem.length;
    int i = 0;
    while (i < k)
    {
      Particle[] arrayOfParticle = paramArrayOfParticleItem[i].particles;
      int m = arrayOfParticle.length;
      int j = 0;
      while (j < m)
      {
        arrayOfParticle[j].alive = false;
        j += 1;
      }
      i += 1;
    }
    return nativeAdvance(this.mNativeCtx, paramArrayOfParticleItem, paramInt);
  }
  
  public int clearParticles(int paramInt)
  {
    return nativeClearParticles(this.mNativeCtx, paramInt);
  }
  
  public void createParticles(List<StickerItem> paramList)
  {
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = ((StickerItem)paramList.get(i)).transition;
        if (localObject != null)
        {
          localObject = new ParticleTemplate2D(((Transition)localObject).particleCountMax, ((Transition)localObject).emissionRate, ((Transition)localObject).life, ((Transition)localObject).positionX, ((Transition)localObject).positionY, ((Transition)localObject).scale, ((Transition)localObject).rotate, ((Transition)localObject).p0, ((Transition)localObject).p1, ((Transition)localObject).p2);
          if (localObject != null) {
            this.mClouds.add(localObject);
          }
        }
        i += 1;
      }
      loadFinish();
    }
  }
  
  public long emitImmediately(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return nativeEmitAt(this.mNativeCtx, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void release()
  {
    if (this.mNativeCtx != -1L)
    {
      nativeRelease(this.mNativeCtx);
      this.mNativeCtx = -1L;
    }
  }
  
  public int reset()
  {
    return nativeReset(this.mNativeCtx);
  }
  
  class TexCoord
  {
    float[] texCoord = new float[12];
    
    private TexCoord() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particlesystem2d.ParticleSystem2D
 * JD-Core Version:    0.7.0.1
 */