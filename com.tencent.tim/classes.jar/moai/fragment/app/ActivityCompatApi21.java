package moai.fragment.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.Map;

@TargetApi(21)
@RequiresApi(21)
class ActivityCompatApi21
{
  private static SharedElementCallback createCallback(SharedElementCallback21 paramSharedElementCallback21)
  {
    SharedElementCallbackImpl localSharedElementCallbackImpl = null;
    if (paramSharedElementCallback21 != null) {
      localSharedElementCallbackImpl = new SharedElementCallbackImpl(paramSharedElementCallback21);
    }
    return localSharedElementCallbackImpl;
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    paramActivity.finishAfterTransition();
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    paramActivity.postponeEnterTransition();
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback21 paramSharedElementCallback21)
  {
    paramActivity.setEnterSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback21 paramSharedElementCallback21)
  {
    paramActivity.setExitSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    paramActivity.startPostponedEnterTransition();
  }
  
  public static abstract class SharedElementCallback21
  {
    public abstract Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF);
    
    public abstract View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable);
    
    public abstract void onMapSharedElements(List<String> paramList, Map<String, View> paramMap);
    
    public abstract void onRejectSharedElements(List<View> paramList);
    
    public abstract void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2);
    
    public abstract void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2);
  }
  
  static class SharedElementCallbackImpl
    extends SharedElementCallback
  {
    private ActivityCompatApi21.SharedElementCallback21 mCallback;
    
    public SharedElementCallbackImpl(ActivityCompatApi21.SharedElementCallback21 paramSharedElementCallback21)
    {
      this.mCallback = paramSharedElementCallback21;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      this.mCallback.onMapSharedElements(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List<View> paramList)
    {
      this.mCallback.onRejectSharedElements(paramList);
    }
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.ActivityCompatApi21
 * JD-Core Version:    0.7.0.1
 */