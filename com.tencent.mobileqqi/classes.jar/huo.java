import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public final class huo
  implements Runnable
{
  public huo(int paramInt, Context paramContext) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    try
    {
      if (BadgeUtils.a() == null)
      {
        localObject = Uri.parse("content://com.sec.badge/apps");
        if (this.jdField_a_of_type_AndroidContentContext.getContentResolver().query((Uri)localObject, null, null, null, null) == null)
        {
          BadgeUtils.a(Boolean.valueOf(false));
          return;
        }
        BadgeUtils.a(Boolean.valueOf(true));
      }
      if (!BadgeUtils.a().booleanValue()) {
        return;
      }
      localObject = BadgeUtils.a(this.jdField_a_of_type_AndroidContentContext);
      if (localObject == null) {
        return;
      }
      if (i <= 99) {
        break label147;
      }
      i = 99;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      Intent localIntent;
      while (QLog.isColorLevel())
      {
        QLog.d("BadgeUtil", 2, "samsung badge get a  crash");
        return;
      }
    }
    localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
    localIntent.putExtra("badge_count", i);
    localIntent.putExtra("badge_count_package_name", this.jdField_a_of_type_AndroidContentContext.getPackageName());
    localIntent.putExtra("badge_count_class_name", (String)localObject);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return;
    label147:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     huo
 * JD-Core Version:    0.7.0.1
 */