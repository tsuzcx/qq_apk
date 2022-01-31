package cooperation.qqfav.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;

public class QfavJumpActivity
  extends BaseActivity
{
  private static final String a = "sTARGET_PACKAGE_NAME";
  private static final String b = "sTARGET_CLASS_NAME";
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramIntent);
    localIntent.setClassName("com.tencent.mobileqqi", "cooperation.qqfav.widget.QfavJumpActivity");
    localIntent.putExtra("sTARGET_CLASS_NAME", paramIntent.getComponent().getClassName());
    localIntent.putExtra("sTARGET_PACKAGE_NAME", paramIntent.getComponent().getPackageName());
    paramActivity.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    paramBundle = localIntent.getStringExtra("sTARGET_CLASS_NAME");
    String str = localIntent.getStringExtra("sTARGET_PACKAGE_NAME");
    localIntent.removeExtra("sTARGET_PACKAGE_NAME");
    localIntent.removeExtra("sTARGET_CLASS_NAME");
    if ("cooperation.qqfav.widget.LocationDetailActivity".equals(paramBundle)) {
      new QQMapActivityProxy(this.b.getAccount());
    }
    localIntent = new Intent(localIntent);
    localIntent.setClassName(str, paramBundle);
    startActivity(localIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity
 * JD-Core Version:    0.7.0.1
 */