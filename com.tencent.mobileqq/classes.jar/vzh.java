import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkTipsManager;

public class vzh
  implements View.OnClickListener
{
  public vzh(ArkTipsBar paramArkTipsBar) {}
  
  public void onClick(View paramView)
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      paramView = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramView != null)
      {
        paramView = paramView.a();
        if (paramView != null) {
          paramView.a(ArkTipsBar.a(this.a));
        }
      }
      ArkTipsManager.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzh
 * JD-Core Version:    0.7.0.1
 */