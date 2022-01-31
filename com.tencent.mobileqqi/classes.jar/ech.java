import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.BubbleAnimation;

public class ech
  extends View
{
  public ech(BubbleAnimation paramBubbleAnimation, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((BubbleAnimation.a(this.a).a()) && (BubbleAnimation.b(this.a).a())) {
      BubbleAnimation.a(this.a).post(new eci(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ech
 * JD-Core Version:    0.7.0.1
 */