import android.content.Context;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class jkv
{
  Animation N;
  Animation O;
  Animation P;
  public boolean ZO;
  Handler aQ;
  ImageView gU;
  ImageView gV;
  ImageView gW;
  Context mContext;
  Animation.AnimationListener n;
  Animation.AnimationListener o;
  
  public void axA()
  {
    this.ZO = false;
    this.aQ.sendEmptyMessage(10);
    if ((this.gV != null) && (this.gW != null))
    {
      this.gV.clearAnimation();
      this.gW.clearAnimation();
      this.gV.setVisibility(8);
      this.gW.setVisibility(8);
    }
  }
  
  public void axw()
  {
    axy();
    axA();
    this.gU = null;
    this.gV = null;
    this.gW = null;
    this.N = null;
    this.O = null;
    this.P = null;
    this.n = null;
    this.o = null;
    this.aQ = null;
    this.mContext = null;
  }
  
  public void axx()
  {
    if (this.gU != null) {
      this.gU.startAnimation(this.N);
    }
  }
  
  public void axy()
  {
    if (this.gU != null)
    {
      this.gU.setVisibility(8);
      this.gU.clearAnimation();
    }
  }
  
  public void axz()
  {
    this.ZO = true;
    if ((this.gV != null) && (this.gW != null)) {
      this.aQ.sendEmptyMessage(9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkv
 * JD-Core Version:    0.7.0.1
 */