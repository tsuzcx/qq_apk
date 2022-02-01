import android.animation.Animator;
import android.view.View;

public final class zjm
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2, 2);
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    zjh localzjh = zjh.a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2);
    if (paramInt3 != paramView.getLayerType()) {
      localzjh.addListener(new zjj(paramView, paramInt3));
    }
    return localzjh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjm
 * JD-Core Version:    0.7.0.1
 */