import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public final class hid
  implements Runnable
{
  public hid(Context paramContext, String paramString) {}
  
  public void run()
  {
    BadgeUtils.d(this.jdField_a_of_type_AndroidContentContext, 0);
    boolean bool = QQUtils.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_AndroidContentContext.getString(2131561399) });
    if (QLog.isColorLevel()) {
      QLog.d(QQUtils.b(), 2, "createShortcut " + bool + ", " + QQUtils.a());
    }
    if (bool)
    {
      if (QQUtils.b() < 3) {
        ThreadManager.b().postDelayed(this, 1000L);
      }
      return;
    }
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.setComponent(new ComponentName("com.tencent.mobileqqi", this.jdField_a_of_type_JavaLangString));
    localIntent1.addCategory("android.intent.category.LAUNCHER");
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(2097152);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131561399));
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2130838016));
    localIntent2.putExtra("duplicate", false);
    localIntent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast(localIntent2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hid
 * JD-Core Version:    0.7.0.1
 */