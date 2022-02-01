import android.view.MotionEvent;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class uog
  implements TopGestureLayout.InterceptTouchEventListener
{
  public uog(ServiceAccountFolderActivity paramServiceAccountFolderActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (ServiceAccountFolderActivity.a(this.a) != null)
    {
      float f = paramMotionEvent.getY();
      if ((f > ServiceAccountFolderActivity.a(this.a).getTop()) && (f < ServiceAccountFolderActivity.a(this.a).getBottom())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uog
 * JD-Core Version:    0.7.0.1
 */