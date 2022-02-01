import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerFragment;

public class qfv
  implements ViewTreeObserver.OnPreDrawListener
{
  public qfv(StoryPlayerFragment paramStoryPlayerFragment, View paramView) {}
  
  public boolean onPreDraw()
  {
    qii.b((ViewGroup)this.a.getRootView(), this.a.a, new qfw(this));
    this.val$fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfv
 * JD-Core Version:    0.7.0.1
 */