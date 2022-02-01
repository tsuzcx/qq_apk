import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;

public class aleh
  implements RecyclerView.OnItemTouchListener
{
  public aleh(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.a.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    this.a.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aleh
 * JD-Core Version:    0.7.0.1
 */