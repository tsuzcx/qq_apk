import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.opengl.QQGLGestureView;
import com.tencent.av.opengl.gesture.GlViewTouchListener;

public class bib
  implements View.OnTouchListener
{
  public bib(QQGLGestureView paramQQGLGestureView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
      this.a.jdField_a_of_type_AndroidViewView$OnTouchListener.onTouch(paramView, paramMotionEvent);
    }
    if (this.a.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener != null) {
      return this.a.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bib
 * JD-Core Version:    0.7.0.1
 */