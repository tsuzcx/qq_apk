import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.CharJumpAnimView;

public class hka
  implements Runnable
{
  public hka(CharJumpAnimView paramCharJumpAnimView) {}
  
  public void run()
  {
    if (CharJumpAnimView.a(this.a) == 0L)
    {
      if (CharJumpAnimView.a(this.a) != null) {
        CharJumpAnimView.a(this.a).onAnimationStart(null);
      }
      CharJumpAnimView.a(this.a, System.currentTimeMillis());
    }
    this.a.a(CharJumpAnimView.a(this.a), 3500L);
    this.a.invalidate();
    if (this.a.a())
    {
      this.a.postDelayed(this, 20L);
      return;
    }
    if (CharJumpAnimView.a(this.a) != null) {
      CharJumpAnimView.a(this.a).onAnimationEnd(null);
    }
    CharJumpAnimView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hka
 * JD-Core Version:    0.7.0.1
 */