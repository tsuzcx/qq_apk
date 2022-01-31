import android.graphics.Rect;
import com.tencent.mobileqq.app.ScreenShot;

public class zmu
  implements Runnable
{
  public zmu(ScreenShot paramScreenShot, zmv paramzmv) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Zmv.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Zmv.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.jdField_a_of_type_Zmv.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmu
 * JD-Core Version:    0.7.0.1
 */