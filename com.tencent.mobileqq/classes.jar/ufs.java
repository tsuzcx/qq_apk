import android.animation.Animator;
import android.text.TextUtils;
import android.view.View;

class ufs
  extends uex
{
  ufs(ufr paramufr) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i = 0;
    super.onAnimationStart(paramAnimator);
    this.a.b.setTranslationY(this.a.b.getHeight());
    this.a.b.setVisibility(0);
    paramAnimator = ufr.a(this.a);
    if (TextUtils.equals(this.a.a(), "focus")) {}
    for (;;)
    {
      paramAnimator.setVisibility(i);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufs
 * JD-Core Version:    0.7.0.1
 */