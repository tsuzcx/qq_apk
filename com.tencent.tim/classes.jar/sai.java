import android.os.Handler;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.b;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.c;

public class sai
  implements PopViewAnimationDrawableHelper.c
{
  public sai(PopViewAnimationDrawableHelper paramPopViewAnimationDrawableHelper) {}
  
  public void bxH()
  {
    if (PopViewAnimationDrawableHelper.a(this.a) != null) {
      PopViewAnimationDrawableHelper.a(this.a).onEnd();
    }
    if ((PopViewAnimationDrawableHelper.a(this.a) != null) && (PopViewAnimationDrawableHelper.a(this.a) != null)) {
      PopViewAnimationDrawableHelper.a(this.a).removeCallbacks(PopViewAnimationDrawableHelper.a(this.a));
    }
  }
  
  public void bxI()
  {
    PopViewAnimationDrawableHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sai
 * JD-Core Version:    0.7.0.1
 */