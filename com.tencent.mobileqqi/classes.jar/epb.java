import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;

public class epb
  implements Runnable
{
  public static final int a = 60;
  private float jdField_a_of_type_Float;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 9;
  private PointF jdField_b_of_type_AndroidGraphicsPointF;
  private int c = 20;
  private int d;
  
  public epb(DragRelativeLayout paramDragRelativeLayout, PointF paramPointF, RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
    this.jdField_a_of_type_Float = ((float)Math.sqrt(this.jdField_a_of_type_AndroidGraphicsRectF.width() * this.jdField_a_of_type_AndroidGraphicsRectF.width() + this.jdField_a_of_type_AndroidGraphicsRectF.height() * this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    if (this.jdField_a_of_type_Float <= 0.01D)
    {
      this.d = 0;
      return;
    }
    this.c = ((int)(this.c * this.jdField_a_of_type_Float / DragRelativeLayout.b(paramDragRelativeLayout)));
    this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float / DragRelativeLayout.b(paramDragRelativeLayout)));
    this.d = (-this.c);
  }
  
  public PointF a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPointF;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((Math.abs(this.d) < this.jdField_b_of_type_Int) || (this.jdField_b_of_type_Int == 0)) {
      if (DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout) == this)
      {
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, -1);
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout).setVisibility(0);
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, null);
        DragRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.invalidate();
      return;
      this.jdField_b_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_AndroidGraphicsPointF.x + this.d * this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPointF.y = (this.jdField_a_of_type_AndroidGraphicsPointF.y + this.d * this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_Float);
      if (this.d < 0) {
        this.d = (-this.d - this.jdField_b_of_type_Int);
      } else {
        this.d = (-this.d + this.jdField_b_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     epb
 * JD-Core Version:    0.7.0.1
 */