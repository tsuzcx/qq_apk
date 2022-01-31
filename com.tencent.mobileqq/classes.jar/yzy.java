import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentView;

public class yzy
  implements View.OnTouchListener
{
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new yzz(this);
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
  private GdtCanvasPictureComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData;
  
  public yzy(GdtCanvasMultiPictureComponentView paramGdtCanvasMultiPictureComponentView, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData = paramGdtCanvasPictureComponentData;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzy
 * JD-Core Version:    0.7.0.1
 */