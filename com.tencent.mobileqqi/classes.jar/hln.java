import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;

public class hln
  implements Runnable
{
  public hln(WebAppActivity paramWebAppActivity, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    LogUtility.c("WebAppActivity", "has shortcut " + this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.c() + " | " + this.jdField_a_of_type_JavaLangString + " | " + this.b);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.a(this.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent.putExtra("duplicate", false);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", this.b);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Common.a())
    {
      String str = this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.a(this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.i);
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = BitmapFactory.decodeFile(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.a();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        LogUtility.c("WebAppActivity", "created bitmap from default");
        localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.getResources(), 2130838184);
      }
    }
    localIntent.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)localObject2);
    localObject1 = new Intent("com.tencent.open.startwebapp");
    ((Intent)localObject1).setFlags(335544320);
    ((Intent)localObject1).putExtras(this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.a());
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject1);
    LogUtility.c("WebAppActivity", "send shortcut broadcast");
    this.jdField_a_of_type_ComTencentOpenApplistWebAppActivity.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hln
 * JD-Core Version:    0.7.0.1
 */