import com.tencent.biz.pubaccount.readinjoy.view.RainView;
import com.tencent.biz.pubaccount.readinjoy.view.RainView.a;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class ndf
  implements anyb.a
{
  public ndf(RainView paramRainView, anyu paramanyu) {}
  
  public void aVH()
  {
    this.b.c(this.a);
    if ((RainView.a(this.b).incrementAndGet() == RainView.access$100() * RainView.access$200() * RainView.b(this.b).get()) && (RainView.a(this.b) != null))
    {
      RainView.a(this.b).set(0);
      RainView.b(this.b).set(0);
      RainView.a(this.b).onAnimationEnd();
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndf
 * JD-Core Version:    0.7.0.1
 */