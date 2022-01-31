import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener;

public class wym
  implements Runnable
{
  public wym(AvatarPendantActivity.AnimationScrollListener paramAnimationScrollListener) {}
  
  public void run()
  {
    if (this.a.b.r == 0)
    {
      URLDrawable.resume();
      this.a.b.a.a = false;
      this.a.b.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wym
 * JD-Core Version:    0.7.0.1
 */