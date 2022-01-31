package android.support.v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
class ActivityCompat$SharedElementCallback21Impl
  extends android.app.SharedElementCallback
{
  protected SharedElementCallback mCallback;
  
  ActivityCompat$SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
  {
    this.mCallback = paramSharedElementCallback;
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
  }
  
  public void onMapSharedElements(List paramList, Map paramMap)
  {
    this.mCallback.onMapSharedElements(paramList, paramMap);
  }
  
  public void onRejectSharedElements(List paramList)
  {
    this.mCallback.onRejectSharedElements(paramList);
  }
  
  public void onSharedElementEnd(List paramList1, List paramList2, List paramList3)
  {
    this.mCallback.onSharedElementEnd(paramList1, paramList2, paramList3);
  }
  
  public void onSharedElementStart(List paramList1, List paramList2, List paramList3)
  {
    this.mCallback.onSharedElementStart(paramList1, paramList2, paramList3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat.SharedElementCallback21Impl
 * JD-Core Version:    0.7.0.1
 */