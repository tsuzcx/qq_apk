import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import java.util.HashMap;

public class ajvy
  implements DialogInterface.OnDismissListener
{
  public ajvy(StoryPlayController paramStoryPlayController, VideoPlayerPagerAdapter.a parama, HashMap paramHashMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.ld != null)
    {
      this.this$0.a.resume();
      if (this.lW.get(Integer.valueOf(this.a.position)) != null) {
        ((ajzo)this.lW.get(Integer.valueOf(this.a.position))).scrollToTop();
      }
    }
    StoryPlayController.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvy
 * JD-Core Version:    0.7.0.1
 */