import com.tencent.av.widget.shimmer.ShimmerTextView;

public class bml
  implements Runnable
{
  public bml(ShimmerTextView paramShimmerTextView) {}
  
  public void run()
  {
    ShimmerTextView localShimmerTextView = this.a;
    localShimmerTextView.a += 1;
    if (this.a.a >= 50) {
      this.a.a = 0;
    }
    this.a.setGradientX(this.a.getWidth() * this.a.a / 50);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bml
 * JD-Core Version:    0.7.0.1
 */