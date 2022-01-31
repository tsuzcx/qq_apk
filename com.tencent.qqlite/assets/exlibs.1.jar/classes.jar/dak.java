import android.graphics.Bitmap;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import java.util.concurrent.Callable;

public class dak
  implements Callable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public dak(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public Bitmap a()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false, this.jdField_a_of_type_Int);
    QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap == null) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b;
    }
    long l1 = SystemClock.uptimeMillis();
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.jdField_a_of_type_Dag.obtainMessage();
    long l2 = SystemClock.uptimeMillis();
    localMessage.obj = Long.valueOf(Long.valueOf(Math.max(this.jdField_a_of_type_Long - l1, 0L)).longValue() + l2);
    localMessage.sendToTarget();
    return this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dak
 * JD-Core Version:    0.7.0.1
 */