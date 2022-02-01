import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import com.tencent.qphone.base.util.QLog;

public class adus
{
  private aduz a;
  private boolean isStarted;
  private Context mContext;
  private SensorManager mSensorManager;
  private int mType = 2;
  
  public adus(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
    try
    {
      this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("ARSensorManager", 1, "ARSensorManager getSystemService error:" + paramContext.getMessage());
      this.mSensorManager = null;
    }
  }
  
  public aduz a(int paramInt, SensorManager paramSensorManager, adus.a parama)
  {
    if (paramSensorManager == null) {
      return null;
    }
    if (paramInt == 1) {
      if (0 != 0) {
        break label515;
      }
    }
    for (;;)
    {
      Object localObject7;
      label89:
      Object localObject3;
      try
      {
        localObject1 = new adve(this.mContext, paramInt, paramSensorManager, parama);
        localObject7 = localObject1;
        if (localObject1 != null) {}
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound2)
      {
        try
        {
          localObject7 = new advc(this.mContext, paramInt, paramSensorManager, parama);
          localObject1 = localObject7;
          if (localObject7 != null) {}
        }
        catch (OrientationProviderNotFound localOrientationProviderNotFound2)
        {
          try
          {
            Object localObject1 = new adux(this.mContext, paramInt, paramSensorManager, parama);
            if (localObject1 != null) {
              break label485;
            }
            paramSensorManager = "null";
            QLog.d("ARSensorManager", 1, "getProvider:" + paramSensorManager);
            return localObject1;
            localOrientationProviderNotFound1 = localOrientationProviderNotFound1;
            Object localObject2 = null;
            continue;
            localOrientationProviderNotFound2 = localOrientationProviderNotFound2;
            localObject7 = null;
          }
          catch (OrientationProviderNotFound paramSensorManager)
          {
            localObject3 = null;
            continue;
          }
        }
      }
      if (paramInt == 0) {
        if (0 != 0) {
          break label509;
        }
      }
      for (;;)
      {
        try
        {
          localObject7 = new advb(this.mContext, paramInt, paramSensorManager, parama);
          localObject3 = localObject7;
          if (localObject7 != null) {}
        }
        catch (OrientationProviderNotFound localOrientationProviderNotFound5)
        {
          try
          {
            localObject3 = new advc(this.mContext, paramInt, paramSensorManager, parama);
            localObject7 = localObject3;
            if (localObject3 != null) {}
          }
          catch (OrientationProviderNotFound localOrientationProviderNotFound5)
          {
            try
            {
              localObject7 = new adve(this.mContext, paramInt, paramSensorManager, parama);
              localObject8 = localObject7;
              if (localObject7 != null) {}
            }
            catch (OrientationProviderNotFound localOrientationProviderNotFound5)
            {
              try
              {
                for (;;)
                {
                  localObject8 = new aduw(this.mContext, paramInt, paramSensorManager, parama);
                  localObject3 = localObject8;
                  if (localObject8 != null) {
                    break;
                  }
                  try
                  {
                    localObject3 = new aduy(this.mContext, paramInt, paramSensorManager, parama);
                  }
                  catch (OrientationProviderNotFound paramSensorManager)
                  {
                    localObject3 = null;
                  }
                }
                break;
                localOrientationProviderNotFound3 = localOrientationProviderNotFound3;
                localObject7 = null;
                continue;
                localOrientationProviderNotFound4 = localOrientationProviderNotFound4;
                Object localObject4 = null;
                continue;
                localOrientationProviderNotFound5 = localOrientationProviderNotFound5;
                localObject7 = null;
              }
              catch (OrientationProviderNotFound localOrientationProviderNotFound6)
              {
                Object localObject8 = null;
                continue;
              }
            }
          }
        }
        if ((paramInt == 2) || (paramInt == 3)) {
          if (0 != 0) {
            break label503;
          }
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject7 = new advc(this.mContext, paramInt, paramSensorManager, parama);
              localObject5 = localObject7;
              if (localObject7 != null) {}
            }
            catch (OrientationProviderNotFound localOrientationProviderNotFound8)
            {
              try
              {
                localObject5 = new adve(this.mContext, paramInt, paramSensorManager, parama);
                localObject7 = localObject5;
                if (localObject5 != null) {}
              }
              catch (OrientationProviderNotFound localOrientationProviderNotFound8)
              {
                try
                {
                  for (;;)
                  {
                    localObject7 = new aduw(this.mContext, paramInt, paramSensorManager, parama);
                    Object localObject5 = localObject7;
                    if (localObject7 != null) {
                      break;
                    }
                    try
                    {
                      localObject5 = new adux(this.mContext, paramInt, paramSensorManager, parama);
                    }
                    catch (OrientationProviderNotFound paramSensorManager)
                    {
                      localObject5 = null;
                    }
                  }
                  break;
                  localOrientationProviderNotFound7 = localOrientationProviderNotFound7;
                  localObject7 = null;
                  continue;
                  localOrientationProviderNotFound8 = localOrientationProviderNotFound8;
                  Object localObject6 = null;
                }
                catch (OrientationProviderNotFound localOrientationProviderNotFound9)
                {
                  localObject7 = null;
                  continue;
                }
              }
            }
            if (((paramInt != 4) && (paramInt != 5)) || (0 != 0)) {
              break label497;
            }
            try
            {
              localadvd = new advd(this.mContext, paramInt, paramSensorManager, parama);
            }
            catch (OrientationProviderNotFound paramSensorManager)
            {
              localadvd = null;
            }
          }
          break;
          label485:
          paramSensorManager = localadvd.getClass().getSimpleName();
          break label89;
          label497:
          localadvd = null;
          break;
          label503:
          localObject7 = null;
        }
        label509:
        localObject7 = null;
      }
      label515:
      advd localadvd = null;
    }
  }
  
  public boolean a(adus.a parama)
  {
    if (!this.isStarted)
    {
      this.a = a(this.mType, this.mSensorManager, parama);
      if (this.a == null) {
        break label48;
      }
      this.a.start();
    }
    label48:
    for (this.isStarted = true;; this.isStarted = false) {
      return this.isStarted;
    }
  }
  
  public boolean a(adus.a parama, int paramInt)
  {
    if (!this.isStarted)
    {
      this.a = a(this.mType, this.mSensorManager, parama);
      if (this.a == null) {
        break label78;
      }
      int i = paramInt;
      if (paramInt != 2)
      {
        i = paramInt;
        if (paramInt != 1)
        {
          i = paramInt;
          if (paramInt != 0)
          {
            i = paramInt;
            if (paramInt != 3) {
              i = 2;
            }
          }
        }
      }
      this.a.start(i);
    }
    label78:
    for (this.isStarted = true;; this.isStarted = false) {
      return this.isStarted;
    }
  }
  
  public boolean afD()
  {
    if (this.mSensorManager == null) {
      return false;
    }
    Object localObject = this.mSensorManager;
    int i;
    if (this.mType == 5)
    {
      i = 15;
      localObject = ((SensorManager)localObject).getDefaultSensor(i);
      if ((this.mSensorManager.getDefaultSensor(4) == null) || (localObject == null)) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i = 11;
      break;
    }
  }
  
  public boolean available()
  {
    return (iP(2)) && ((iP(1)) || (iP(4)));
  }
  
  public boolean iP(int paramInt)
  {
    if (this.mSensorManager == null) {}
    while (this.mSensorManager.getDefaultSensor(paramInt) == null) {
      return false;
    }
    return true;
  }
  
  public void stop()
  {
    if (this.isStarted)
    {
      this.isStarted = false;
      if (this.a != null) {
        this.a.stop();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onRotationUpdateOriginal(float[] paramArrayOfFloat);
    
    public abstract void onRotationUpdateQuaternion(float[] paramArrayOfFloat);
    
    public abstract void onSensorSupport(int paramInt, boolean paramBoolean);
    
    public abstract void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
    
    public abstract void updateAzimuth(float paramFloat);
    
    public abstract void updateGyroscope(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
    
    public abstract void updatePitch(float paramFloat);
    
    public abstract void updateRoll(float paramFloat);
    
    public abstract void updateRotation(float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void updateSensor(float paramFloat1, float paramFloat2, float paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adus
 * JD-Core Version:    0.7.0.1
 */