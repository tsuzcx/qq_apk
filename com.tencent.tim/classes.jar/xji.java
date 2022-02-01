import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.widget.AnimationTextView.a;

class xji
  implements AnimationTextView.a
{
  xji(xje paramxje) {}
  
  public void R(View paramView)
  {
    if (aine.f(this.a.sessionInfo)) {
      return;
    }
    wja.bcO = true;
    ChatActivityUtils.a(this.a.app, paramView, (FragmentActivity)this.a.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xji
 * JD-Core Version:    0.7.0.1
 */