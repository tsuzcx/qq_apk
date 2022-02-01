import android.animation.Animator;
import android.view.View;

public final class rtr
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    rtp localrtp = rtp.a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2);
    if (paramInt3 != paramView.getLayerType()) {
      localrtp.addListener(new rtp.a(paramView, paramInt3));
    }
    return localrtp;
  }
  
  public static Animator createCircularReveal(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtr
 * JD-Core Version:    0.7.0.1
 */