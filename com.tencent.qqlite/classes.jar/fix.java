import android.content.Context;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;

public final class fix
  implements Runnable
{
  public fix(Context paramContext, int paramInt) {}
  
  public void run()
  {
    BadgeUtilImpl.setSamsungBadge(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fix
 * JD-Core Version:    0.7.0.1
 */