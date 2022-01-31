import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class vml
  implements View.OnTouchListener
{
  private final int jdField_a_of_type_Int = 10;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  vml(vmj paramvmj) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.b = ((int)f);
        this.jdField_a_of_type_Boolean = false;
        return false;
      } while (Math.abs(f - this.b) <= 10.0F);
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vml
 * JD-Core Version:    0.7.0.1
 */