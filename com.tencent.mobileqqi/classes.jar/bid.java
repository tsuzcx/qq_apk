import com.tencent.av.opengl.gesture.GlViewTouchListener;
import com.tencent.av.opengl.gesture.ZoomAnimationListener;

public class bid
  implements ZoomAnimationListener
{
  public bid(GlViewTouchListener paramGlViewTouchListener) {}
  
  public void a()
  {
    this.a.b = false;
    this.a.c();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 <= this.a.h) && (paramFloat1 >= this.a.i)) {
      this.a.a(paramFloat1, paramFloat2, paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bid
 * JD-Core Version:    0.7.0.1
 */