import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import java.util.List;

public class aueg
  implements Animation.AnimationListener
{
  public static int cZi;
  public static int cZj;
  List<aueg.a> BO;
  View Dk;
  aueg.a a;
  boolean cfW = false;
  int[] lp = new int[1];
  
  public aueg(View paramView)
  {
    this.Dk = paramView;
  }
  
  private void b(aueg.a parama)
  {
    this.a = parama;
    Animation localAnimation = (Animation)parama.dL;
    localAnimation.setDuration(parama.duration);
    localAnimation.setAnimationListener(this);
  }
  
  public void a(aueg.a parama)
  {
    if (this.BO == null) {
      this.BO = new ArrayList();
    }
    synchronized (this.lp)
    {
      this.BO.add(parama);
      b(parama);
      return;
    }
  }
  
  public void dkV()
  {
    if (this.cfW) {}
    for (;;)
    {
      return;
      if (this.BO.size() == 0) {
        continue;
      }
      synchronized (this.lp)
      {
        aueg.a locala = (aueg.a)this.BO.get(0);
        this.BO.remove(0);
        if ((locala == null) || ((locala.bShow == true) && (this.Dk.getVisibility() == 0)) || ((!locala.bShow) && ((this.Dk.getVisibility() == 8) || (this.Dk.getVisibility() == 4)))) {
          continue;
        }
        this.Dk.setAnimation((Animation)locala.dL);
        this.Dk.startAnimation((Animation)locala.dL);
        return;
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.bShow) {
      this.Dk.setVisibility(0);
    }
    for (;;)
    {
      this.cfW = false;
      dkV();
      return;
      this.Dk.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.cfW = true;
  }
  
  public void removeAll()
  {
    synchronized (this.lp)
    {
      this.BO.clear();
      this.Dk.clearAnimation();
      return;
    }
  }
  
  public static class a
  {
    public boolean bShow;
    public Object dL;
    public int duration;
    public int eType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aueg
 * JD-Core Version:    0.7.0.1
 */