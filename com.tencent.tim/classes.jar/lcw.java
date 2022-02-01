import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class lcw
  extends lcs
{
  private Activity activity;
  private boolean needShow;
  
  public lcw(@NotNull lct paramlct, Activity paramActivity)
  {
    super(paramlct, "RIJLockScreenPopupStep");
    this.activity = paramActivity;
  }
  
  private boolean BP()
  {
    if (this.activity != null)
    {
      Intent localIntent = this.activity.getIntent();
      if ((localIntent != null) && (localIntent.hasExtra("launch_from")) && (localIntent.hasExtra("kan_dian_lock_screen_flag")) && (localIntent.getIntExtra("launch_from", 0) == 9))
      {
        ReadInJoyLockScreenJumpDelegate.o(this.activity, localIntent);
        localIntent.removeExtra("kan_dian_lock_screen_flag");
        QLog.i("RIJDailyPopupStep", 1, "RIJLockScreenPopupStep handleLockScreenJump!");
        return true;
      }
    }
    return false;
  }
  
  protected void aKn()
  {
    nn(this.needShow);
  }
  
  protected void aKo()
  {
    this.needShow = BP();
    nn(this.needShow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcw
 * JD-Core Version:    0.7.0.1
 */