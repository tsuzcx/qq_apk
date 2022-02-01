import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.tim.jump.JumpInterceptFragment;

public class augc
{
  public static boolean cD(Context paramContext)
  {
    gf(paramContext);
    return true;
  }
  
  private static void gf(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("EXTRA_INTERCEPT_QZONE", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicTransFragmentActivity.class, JumpInterceptFragment.class);
  }
  
  public static void j(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = paramActivity.getIntent();
    if (localIntent.getBooleanExtra("EXTRA_INTERCEPT_QZONE", false))
    {
      paramActivity = aqha.a(paramActivity, 230).setMessage(2131696395).setPositiveButton(2131694738, new augd(paramBoolean, paramActivity));
      paramActivity.setCanceledOnTouchOutside(false);
      paramActivity.show();
      localIntent.removeExtra("EXTRA_INTERCEPT_QZONE");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augc
 * JD-Core Version:    0.7.0.1
 */