import android.animation.Animator;
import android.view.View;

public final class zvi
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2, 2);
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    zvd localzvd = zvd.a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2);
    if (paramInt3 != paramView.getLayerType()) {
      localzvd.addListener(new zvf(paramView, paramInt3));
    }
    return localzvd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvi
 * JD-Core Version:    0.7.0.1
 */