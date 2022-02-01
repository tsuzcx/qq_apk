package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator
{
  public static final int ANIMATION_DURATION = 256;
  public static final int ANIMATION_INDEX = 8;
  public static final int COMMAND_DURATION = 32;
  public static final int COMMAND_INDEX = 5;
  private static final boolean DBG = false;
  public static final int DELAY_DURATION = 128;
  public static final int DELAY_INDEX = 7;
  public static final int DRAW_DURATION = 8;
  public static final int DRAW_INDEX = 3;
  public static final int EVERY_DURATION = 511;
  public static final int INPUT_DURATION = 2;
  public static final int INPUT_INDEX = 1;
  private static final int LAST_INDEX = 8;
  public static final int LAYOUT_MEASURE_DURATION = 4;
  public static final int LAYOUT_MEASURE_INDEX = 2;
  public static final int SWAP_DURATION = 64;
  public static final int SWAP_INDEX = 6;
  public static final int SYNC_DURATION = 16;
  public static final int SYNC_INDEX = 4;
  private static final String TAG = "FrameMetrics";
  public static final int TOTAL_DURATION = 1;
  public static final int TOTAL_INDEX = 0;
  private FrameMetricsBaseImpl mInstance;
  
  public FrameMetricsAggregator()
  {
    this(1);
  }
  
  public FrameMetricsAggregator(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mInstance = new FrameMetricsApi24Impl(paramInt);
      return;
    }
    this.mInstance = new FrameMetricsBaseImpl(null);
  }
  
  public void add(@NonNull Activity paramActivity)
  {
    this.mInstance.add(paramActivity);
  }
  
  @Nullable
  public SparseIntArray[] getMetrics()
  {
    return this.mInstance.getMetrics();
  }
  
  @Nullable
  public SparseIntArray[] remove(@NonNull Activity paramActivity)
  {
    return this.mInstance.remove(paramActivity);
  }
  
  @Nullable
  public SparseIntArray[] reset()
  {
    return this.mInstance.reset();
  }
  
  @Nullable
  public SparseIntArray[] stop()
  {
    return this.mInstance.stop();
  }
  
  @RequiresApi(24)
  private static class FrameMetricsApi24Impl
    extends FrameMetricsAggregator.FrameMetricsBaseImpl
  {
    private static final int NANOS_PER_MS = 1000000;
    private static final int NANOS_ROUNDING_VALUE = 500000;
    private static Handler sHandler;
    private static HandlerThread sHandlerThread;
    private ArrayList<WeakReference<Activity>> mActivities = new ArrayList();
    Window.OnFrameMetricsAvailableListener mListener = new Window.OnFrameMetricsAvailableListener()
    {
      public void onFrameMetricsAvailable(Window paramAnonymousWindow, FrameMetrics paramAnonymousFrameMetrics, int paramAnonymousInt)
      {
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x1) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[0], paramAnonymousFrameMetrics.getMetric(8));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x2) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[1], paramAnonymousFrameMetrics.getMetric(1));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x4) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[2], paramAnonymousFrameMetrics.getMetric(3));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x8) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[3], paramAnonymousFrameMetrics.getMetric(4));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x10) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[4], paramAnonymousFrameMetrics.getMetric(5));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x40) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[6], paramAnonymousFrameMetrics.getMetric(7));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x20) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[5], paramAnonymousFrameMetrics.getMetric(6));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x80) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[7], paramAnonymousFrameMetrics.getMetric(0));
        }
        if ((FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 0x100) != 0)
        {
          paramAnonymousWindow = FrameMetricsAggregator.FrameMetricsApi24Impl.this;
          paramAnonymousWindow.addDurationItem(paramAnonymousWindow.mMetrics[8], paramAnonymousFrameMetrics.getMetric(2));
        }
      }
    };
    private SparseIntArray[] mMetrics = new SparseIntArray[9];
    private int mTrackingFlags;
    
    FrameMetricsApi24Impl(int paramInt)
    {
      super();
      this.mTrackingFlags = paramInt;
    }
    
    public void add(Activity paramActivity)
    {
      if (sHandlerThread == null)
      {
        sHandlerThread = new HandlerThread("FrameMetricsAggregator");
        sHandlerThread.start();
        sHandler = new Handler(sHandlerThread.getLooper());
      }
      int i = 0;
      while (i <= 8)
      {
        SparseIntArray[] arrayOfSparseIntArray = this.mMetrics;
        if ((arrayOfSparseIntArray[i] == null) && ((this.mTrackingFlags & 1 << i) != 0)) {
          arrayOfSparseIntArray[i] = new SparseIntArray();
        }
        i += 1;
      }
      paramActivity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
      this.mActivities.add(new WeakReference(paramActivity));
    }
    
    void addDurationItem(SparseIntArray paramSparseIntArray, long paramLong)
    {
      if (paramSparseIntArray != null)
      {
        int i = (int)((500000L + paramLong) / 1000000L);
        if (paramLong >= 0L) {
          paramSparseIntArray.put(i, paramSparseIntArray.get(i) + 1);
        }
      }
    }
    
    public SparseIntArray[] getMetrics()
    {
      return this.mMetrics;
    }
    
    public SparseIntArray[] remove(Activity paramActivity)
    {
      Iterator localIterator = this.mActivities.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramActivity) {
          this.mActivities.remove(localWeakReference);
        }
      }
      paramActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
      return this.mMetrics;
    }
    
    public SparseIntArray[] reset()
    {
      SparseIntArray[] arrayOfSparseIntArray = this.mMetrics;
      this.mMetrics = new SparseIntArray[9];
      return arrayOfSparseIntArray;
    }
    
    public SparseIntArray[] stop()
    {
      int i = this.mActivities.size() - 1;
      while (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.mActivities.get(i);
        Activity localActivity = (Activity)localWeakReference.get();
        if (localWeakReference.get() != null)
        {
          localActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
          this.mActivities.remove(i);
        }
        i -= 1;
      }
      return this.mMetrics;
    }
  }
  
  private static class FrameMetricsBaseImpl
  {
    public void add(Activity paramActivity) {}
    
    public SparseIntArray[] getMetrics()
    {
      return null;
    }
    
    public SparseIntArray[] remove(Activity paramActivity)
    {
      return null;
    }
    
    public SparseIntArray[] reset()
    {
      return null;
    }
    
    public SparseIntArray[] stop()
    {
      return null;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface MetricType {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FrameMetricsAggregator
 * JD-Core Version:    0.7.0.1
 */