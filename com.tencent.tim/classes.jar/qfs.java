import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;

public class qfs
  implements ViewTreeObserver.OnPreDrawListener
{
  public qfs(StoryPlayerActivity paramStoryPlayerActivity, View paramView) {}
  
  public boolean onPreDraw()
  {
    qii.b((ViewGroup)this.this$0.getRootView(), this.this$0.a, new qft(this));
    this.val$contentView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfs
 * JD-Core Version:    0.7.0.1
 */