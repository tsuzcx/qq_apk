import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class fb
  implements Runnable
{
  public fb(ETEngine paramETEngine, int paramInt, ey paramey, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1500L);
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ey.a, this.jdField_a_of_type_Boolean))
      {
        if ((new File(this.jdField_a_of_type_Ey.a).exists()) || (ETEngine.a(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine) == null)) {
          break label136;
        }
        ETEngine.a(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine).a(this.jdField_a_of_type_Int, null);
        if (QLog.isColorLevel()) {
          QLog.d("ETEngine", 2, "load font fail file not exist font id=" + this.jdField_a_of_type_Int);
        }
      }
      for (;;)
      {
        if (ETEngine.a(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine) != null) {
          ETEngine.a(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine).a(false, this.jdField_a_of_type_Boolean);
        }
        return;
        label136:
        if (QLog.isColorLevel()) {
          QLog.d("ETEngine", 2, "load font fail font id=" + this.jdField_a_of_type_Int);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ETEngine", 2, "load font fail" + localThrowable.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fb
 * JD-Core Version:    0.7.0.1
 */