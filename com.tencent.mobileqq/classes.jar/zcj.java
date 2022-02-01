import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class zcj
  implements TopGestureLayout.InterceptTouchEventListener
{
  public zcj(SubScribeSwipeRefreshLayout paramSubScribeSwipeRefreshLayout) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    int j;
    do
    {
      do
      {
        return true;
        i = (int)(paramMotionEvent.getX() + 0.5F);
        j = (int)(paramMotionEvent.getY() + 0.5F);
      } while (SubScribeSwipeRefreshLayout.a(this.a) == null);
      SubScribeSwipeRefreshLayout.a(this.a).getLocalVisibleRect(SubScribeSwipeRefreshLayout.a(this.a));
    } while (!SubScribeSwipeRefreshLayout.a(this.a).contains(i, j));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcj
 * JD-Core Version:    0.7.0.1
 */