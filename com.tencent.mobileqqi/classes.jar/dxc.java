import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.BubbleAnimation;

public class dxc
  extends View
{
  public dxc(BubbleAnimation paramBubbleAnimation, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((BubbleAnimation.a(this.a).a()) && (BubbleAnimation.b(this.a).a())) {
      BubbleAnimation.a(this.a).post(new dxd(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dxc
 * JD-Core Version:    0.7.0.1
 */