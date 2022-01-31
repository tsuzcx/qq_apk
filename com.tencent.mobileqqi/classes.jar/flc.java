import android.graphics.Bitmap;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import java.util.concurrent.Callable;

public class flc
  implements Callable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public flc(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public Bitmap a()
  {
    Process.setThreadPriority(10);
    QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, false, this.jdField_a_of_type_Int));
    QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, this.jdField_a_of_type_Int);
    if ((QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable) == null) && (this.jdField_a_of_type_Int == 0)) {
      QQAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, QQAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable));
    }
    long l1 = SystemClock.uptimeMillis();
    Message localMessage = QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable).obtainMessage();
    long l2 = SystemClock.uptimeMillis();
    localMessage.obj = Long.valueOf(Long.valueOf(Math.max(this.jdField_a_of_type_Long - l1, 0L)).longValue() + l2);
    localMessage.sendToTarget();
    return QQAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flc
 * JD-Core Version:    0.7.0.1
 */