import android.graphics.Bitmap;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

public class daf
  implements Runnable
{
  public daf(QQAnimationDrawable paramQQAnimationDrawable) {}
  
  public void run()
  {
    this.a.jdField_b_of_type_Boolean = true;
    Process.setThreadPriority(10);
    Object localObject = this.a;
    QQAnimationDrawable localQQAnimationDrawable = this.a;
    Bitmap localBitmap = this.a.a(true, 0);
    localQQAnimationDrawable.jdField_b_of_type_AndroidGraphicsBitmap = localBitmap;
    ((QQAnimationDrawable)localObject).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    QQAnimationDrawable.a(this.a, 1);
    if (this.a.jdField_a_of_type_Boolean)
    {
      localObject = this.a.jdField_a_of_type_Dag.obtainMessage();
      ((Message)localObject).obj = Integer.valueOf(0);
      ((Message)localObject).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     daf
 * JD-Core Version:    0.7.0.1
 */