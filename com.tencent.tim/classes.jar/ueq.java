import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ueq
  implements View.OnClickListener
{
  public ueq(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.z != null) && (this.this$0.z.isShowing()) && (this.this$0.z.getWindow() != null)) {}
    try
    {
      this.this$0.z.dismiss();
      AddFriendVerifyActivity.a(this.this$0, -1, this.val$msg);
      label58:
      this.this$0.z = null;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ueq
 * JD-Core Version:    0.7.0.1
 */