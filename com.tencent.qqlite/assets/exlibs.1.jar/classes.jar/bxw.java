import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryCollector;

public class bxw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private bxw(AIOGalleryCollector paramAIOGalleryCollector) {}
  
  private void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int += 1;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      if (this.jdField_b_of_type_Int > 1) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Boolean = true;
      this.c = false;
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = Math.max((SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / 1000L, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void c()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      this.jdField_a_of_type_Int += 1;
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bxw
 * JD-Core Version:    0.7.0.1
 */