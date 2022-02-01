import android.view.MotionEvent;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class nyb
  implements TopGestureLayout.InterceptTouchEventListener
{
  public nyb(ServiceAccountFolderActivity paramServiceAccountFolderActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (ServiceAccountFolderActivity.a(this.this$0) != null)
    {
      float f = paramMotionEvent.getY();
      if ((f > ServiceAccountFolderActivity.a(this.this$0).getTop()) && (f < ServiceAccountFolderActivity.a(this.this$0).getBottom())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyb
 * JD-Core Version:    0.7.0.1
 */