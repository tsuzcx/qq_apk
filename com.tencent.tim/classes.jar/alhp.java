import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

public class alhp
{
  private View Gf;
  private TranslateAnimation H;
  private boolean cxb;
  private final int dtX;
  private final int dtY;
  private int dtZ;
  private int dua;
  private Animation.AnimationListener x = new alhq(this);
  
  public alhp(View paramView)
  {
    if (paramView != null)
    {
      this.Gf = paramView;
      this.dtX = aqcx.dip2px(this.Gf.getContext(), 15.0F);
      this.dtY = ((int)(this.dtX / 1.5D));
      return;
    }
    throw new IllegalArgumentException("Wrapped View shouldn't be null!");
  }
  
  public boolean atD()
  {
    return this.Gf.getAnimation() == this.H;
  }
  
  public void dFX()
  {
    this.cxb = false;
    this.dtZ = 0;
    this.dua = 0;
    for (;;)
    {
      int j = (int)(this.dtY * (Math.random() * 2.0D - 1.0D));
      int i = (int)Math.sqrt(this.dtY * this.dtY - j * j);
      if (Math.random() > 0.5D) {}
      while ((this.dtZ + j) * (this.dtZ + j) + (this.dua + i) * (this.dua + i) <= this.dtX * this.dtX)
      {
        this.H = new TranslateAnimation(this.dtZ, this.dtZ + j, this.dua, this.dua + i);
        this.dtZ = (j + this.dtZ);
        this.dua = (i + this.dua);
        this.H.setDuration(this.dtY * (int)(50.0D + Math.random() * 30.0D));
        this.H.setAnimationListener(this.x);
        this.Gf.startAnimation(this.H);
        return;
        i = -i;
      }
    }
  }
  
  public void dFY()
  {
    this.cxb = true;
    if (atD()) {
      this.Gf.clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhp
 * JD-Core Version:    0.7.0.1
 */