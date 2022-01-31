import com.tencent.av.opengl.QQGLGestureView;
import com.tencent.av.opengl.gesture.GlViewTouchListener;
import com.tencent.av.opengl.gesture.MoveAnimationListener;

public class bie
  implements MoveAnimationListener
{
  public bie(GlViewTouchListener paramGlViewTouchListener, QQGLGestureView paramQQGLGestureView) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.setPosition(paramFloat1, paramFloat2);
    this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bie
 * JD-Core Version:    0.7.0.1
 */