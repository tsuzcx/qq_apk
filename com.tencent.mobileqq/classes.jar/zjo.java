import android.graphics.Rect;
import com.tencent.mobileqq.app.ScreenShot;

public class zjo
  implements Runnable
{
  public zjo(ScreenShot paramScreenShot, zjp paramzjp) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Zjp.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Zjp.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.jdField_a_of_type_Zjp.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjo
 * JD-Core Version:    0.7.0.1
 */