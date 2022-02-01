import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class msd
{
  public static final String TAG = "Q.readinjoy.video." + msd.class.getSimpleName();
  private volatile msd.b a;
  private WeakReference<Context> mContextRef;
  private int mCurrentOrientation = 1;
  private volatile OrientationEventListener mEventListener;
  private Object mLock = new Object();
  private HashMap<Integer, Long> mOrientationEventMap;
  private boolean mRotateSettingSwitch;
  
  public msd(Activity paramActivity, msd.a parama)
  {
    this.mContextRef = new WeakReference(paramActivity);
    this.mOrientationEventMap = new HashMap();
    synchronized (this.mLock)
    {
      this.mEventListener = new mse(this, paramActivity, new WeakReference(parama));
      ThreadManager.executeOnSubThread(new OrientationDetector.2(this, paramActivity));
      return;
    }
  }
  
  private boolean innerCheckCanDetectOrientation(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      this.mOrientationEventMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
      Iterator localIterator = this.mOrientationEventMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
      } while ((((Integer)localEntry.getKey()).intValue() == paramInt) || (l - ((Long)localEntry.getValue()).longValue() >= 200L));
      return false;
      if ((paramInt >= 250) && (paramInt <= 290)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
    return true;
  }
  
  private void innerEnable(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new OrientationDetector.3(this, paramBoolean));
  }
  
  public void destory()
  {
    innerEnable(false);
    synchronized (this.mLock)
    {
      this.mEventListener = null;
      if (this.a != null)
      {
        this.a.unregisterObserver();
        this.a = null;
      }
      return;
    }
  }
  
  public boolean enable(boolean paramBoolean)
  {
    if (this.mEventListener == null) {}
    do
    {
      return false;
      if (!paramBoolean) {
        break;
      }
      if (this.mRotateSettingSwitch)
      {
        innerEnable(true);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.w(TAG, 2, "mRotateSettingSwitch is false : enable failure");
    return false;
    innerEnable(false);
    return true;
  }
  
  public Context getContext()
  {
    if (this.mContextRef != null) {
      return (Context)this.mContextRef.get();
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void onOrientationChanged(int paramInt);
  }
  
  public class b
    extends ContentObserver
  {
    public b(Handler paramHandler)
    {
      super();
    }
    
    public ContentResolver getContentResolver()
    {
      if (msd.this.getContext() != null) {
        return msd.this.getContext().getContentResolver();
      }
      return null;
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      if (msd.this.getContext() == null) {}
      for (;;)
      {
        return;
        int i = Settings.System.getInt(msd.this.getContext().getContentResolver(), "accelerometer_rotation", -1);
        if (i == 1)
        {
          msd.a(msd.this, true);
          msd.this.enable(true);
        }
        while (QLog.isColorLevel())
        {
          QLog.d(msd.TAG, 2, "RotationObserver.onChange() : rotateState=" + i);
          return;
          msd.a(msd.this, false);
          msd.this.enable(false);
        }
      }
    }
    
    public void registerObserver()
    {
      if (getContentResolver() != null) {
        getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
      }
    }
    
    public void unregisterObserver()
    {
      if (getContentResolver() != null) {
        getContentResolver().unregisterContentObserver(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msd
 * JD-Core Version:    0.7.0.1
 */