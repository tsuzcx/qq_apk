import android.view.animation.Animation;

class sxl
  extends auqs.a
{
  sxl(sxi paramsxi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a().onExitAnimationEnd();
    this.a.a.a().resetAnimationDuring();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.a().onExitAnimationStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxl
 * JD-Core Version:    0.7.0.1
 */