import android.animation.ValueAnimator;
import android.widget.ProgressBar;

public class zec
{
  public static ValueAnimator a(ProgressBar paramProgressBar, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt }).setDuration(500L);
    localValueAnimator.addUpdateListener(new zed(paramProgressBar));
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zec
 * JD-Core Version:    0.7.0.1
 */