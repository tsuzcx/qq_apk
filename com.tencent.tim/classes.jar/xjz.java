import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.AnimationTextView.a;

class xjz
  implements AnimationTextView.a
{
  xjz(xjx paramxjx) {}
  
  public void R(View paramView)
  {
    wja.bcO = true;
    if (this.this$0.Rk()) {
      return;
    }
    Object localObject = (FragmentActivity)paramView.getContext();
    if (localObject != null) {}
    for (localObject = ((FragmentActivity)localObject).getChatFragment();; localObject = null)
    {
      if (localObject == null)
      {
        ChatActivityUtils.a(this.this$0.app, paramView, (FragmentActivity)this.this$0.mContext);
        return;
      }
      ChatActivityUtils.a(this.this$0.app, paramView, (FragmentActivity)this.this$0.mContext, this.this$0.sessionInfo.cZ);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjz
 * JD-Core Version:    0.7.0.1
 */