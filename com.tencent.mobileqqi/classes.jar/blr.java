import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.VideoLayerUI;

public class blr
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  int d;
  int e = 0;
  int f = 0;
  int g = 0;
  
  public blr(VideoLayerUI paramVideoLayerUI)
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_d_of_type_Int != 0) {}
    do
    {
      return false;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      default: 
        return false;
      case 0: 
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
        this.b = ((int)paramMotionEvent.getRawY());
        this.c = this.jdField_a_of_type_Int;
        this.jdField_d_of_type_Int = this.b;
        this.g = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramView);
        this.jdField_a_of_type_Boolean = false;
        return false;
      case 2: 
        i = (int)paramMotionEvent.getRawX();
        j = (int)paramMotionEvent.getRawY();
        k = i - this.jdField_a_of_type_Int;
        m = j - this.b;
        if ((!this.jdField_a_of_type_Boolean) && ((Math.abs(k) > 5) || (Math.abs(m) > 5)))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j = true;
        }
        if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j) && (((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c) || (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_d_of_type_Boolean)) || (((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_d_of_type_Boolean)) || ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e))))) {
          paramView.setBackgroundDrawable(null);
        }
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramView, k, m);
        this.jdField_a_of_type_Int = i;
        this.b = j;
        return false;
      }
    } while (!this.jdField_a_of_type_Boolean);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    int k = this.jdField_a_of_type_Int;
    int m = this.b;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramView, i - k, j - m);
    this.e = i;
    this.f = j;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramView, this.g, this.c, this.jdField_d_of_type_Int, this.e, this.f);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blr
 * JD-Core Version:    0.7.0.1
 */