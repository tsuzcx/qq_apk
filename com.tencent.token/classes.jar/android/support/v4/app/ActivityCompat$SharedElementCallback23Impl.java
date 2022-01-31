package android.support.v4.app;

import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.support.annotation.RequiresApi;
import java.util.List;

@RequiresApi(23)
class ActivityCompat$SharedElementCallback23Impl
  extends ActivityCompat.SharedElementCallback21Impl
{
  ActivityCompat$SharedElementCallback23Impl(SharedElementCallback paramSharedElementCallback)
  {
    super(paramSharedElementCallback);
  }
  
  public void onSharedElementsArrived(List paramList1, List paramList2, SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
  {
    this.mCallback.onSharedElementsArrived(paramList1, paramList2, new ActivityCompat.SharedElementCallback23Impl.1(this, paramOnSharedElementsReadyListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat.SharedElementCallback23Impl
 * JD-Core Version:    0.7.0.1
 */