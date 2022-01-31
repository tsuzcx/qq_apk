import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import com.tencent.av.opengl.QQGLGestureView;
import com.tencent.av.opengl.gesture.GlViewTouchListener;

public class bif
  extends GestureDetector.SimpleOnGestureListener
{
  public bif(GlViewTouchListener paramGlViewTouchListener, QQGLGestureView paramQQGLGestureView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a(paramMotionEvent);
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.b) && (this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a != null))
    {
      this.jdField_a_of_type_ComTencentAvOpenglGestureGlViewTouchListener.a.onClick(this.jdField_a_of_type_ComTencentAvOpenglQQGLGestureView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bif
 * JD-Core Version:    0.7.0.1
 */