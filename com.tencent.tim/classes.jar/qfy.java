import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerFragment;

public class qfy
  implements View.OnKeyListener
{
  public qfy(StoryPlayerFragment paramStoryPlayerFragment) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (paramKeyEvent.getAction() == 1) {
        this.a.finish();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfy
 * JD-Core Version:    0.7.0.1
 */