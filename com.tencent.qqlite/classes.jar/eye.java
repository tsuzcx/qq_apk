import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public final class eye
  implements Runnable
{
  public eye(Context paramContext, String paramString) {}
  
  public void run()
  {
    BadgeUtils.a(this.jdField_a_of_type_AndroidContentContext, 0);
    boolean bool = ShortcutUtils.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_AndroidContentContext.getString(2131362794) });
    if (QLog.isColorLevel()) {
      QLog.d(ShortcutUtils.a(), 2, "createShortcut " + bool + ", " + ShortcutUtils.a());
    }
    if (bool)
    {
      if (ShortcutUtils.b() < 3) {
        ThreadManager.b().postDelayed(this, 1000L);
      }
      return;
    }
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.setClassName(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    localIntent1.addCategory("android.intent.category.LAUNCHER");
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(2097152);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362794));
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2130838065));
    localIntent2.putExtra("duplicate", false);
    localIntent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast(localIntent2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eye
 * JD-Core Version:    0.7.0.1
 */