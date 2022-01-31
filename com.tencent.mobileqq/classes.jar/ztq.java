import android.graphics.Rect;
import com.tencent.mobileqq.app.ScreenShot;

public class ztq
  implements Runnable
{
  public ztq(ScreenShot paramScreenShot, ztr paramztr) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Ztr.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Ztr.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.jdField_a_of_type_Ztr.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztq
 * JD-Core Version:    0.7.0.1
 */