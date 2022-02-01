import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import dov.com.qq.im.capture.data.LockedCategory;

class axqa
  implements DialogInterface.OnClickListener
{
  axqa(axpz paramaxpz, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.adk(this.this$0.a.mId);
    this.this$0.a = null;
    if (paramInt == 1)
    {
      this.this$0.dvX = true;
      if ((BaseActivity.sTopActivity instanceof SplashActivity))
      {
        paramDialogInterface = (SplashActivity)BaseActivity.sTopActivity;
        Intent localIntent = new Intent();
        localIntent.putExtra("main_tab_id", 8);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("switch_anim", true);
        paramDialogInterface.ch(localIntent);
      }
    }
    else
    {
      return;
    }
    paramDialogInterface = new Intent(BaseActivity.sTopActivity, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", MainFragment.bIk);
    paramDialogInterface.putExtra("fragment_id", 1);
    paramDialogInterface.setFlags(67108864);
    this.val$context.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqa
 * JD-Core Version:    0.7.0.1
 */