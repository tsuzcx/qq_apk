import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;

public class xlo
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 9;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 20;
  private PointF jdField_b_of_type_AndroidGraphicsPointF;
  private int c;
  
  public xlo(DragFrameLayout paramDragFrameLayout, PointF paramPointF, RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
    this.jdField_a_of_type_Float = ((float)Math.sqrt(this.jdField_a_of_type_AndroidGraphicsRectF.width() * this.jdField_a_of_type_AndroidGraphicsRectF.width() + this.jdField_a_of_type_AndroidGraphicsRectF.height() * this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    if (this.jdField_a_of_type_Float <= 0.01D)
    {
      this.c = 0;
      return;
    }
    this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float / DragFrameLayout.b(paramDragFrameLayout)));
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * this.jdField_a_of_type_Float / DragFrameLayout.b(paramDragFrameLayout)));
    this.c = (-this.jdField_b_of_type_Int);
  }
  
  public PointF a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPointF;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((Math.abs(this.c) < this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Int == 0)) {
      if (DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout) == this)
      {
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, -1);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout).setVisibility(0);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, null);
        DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.invalidate();
      return;
      this.jdField_b_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_AndroidGraphicsPointF.x + this.c * this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPointF.y = (this.jdField_a_of_type_AndroidGraphicsPointF.y + this.c * this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_Float);
      if (this.c < 0) {
        this.c = (-this.c - this.jdField_a_of_type_Int);
      } else {
        this.c = (-this.c + this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlo
 * JD-Core Version:    0.7.0.1
 */