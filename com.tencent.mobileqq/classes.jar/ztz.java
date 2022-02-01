import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ztz
  implements View.OnClickListener
{
  public ztz(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.getContext())) {
      QQToast.a(this.a.getContext(), anvx.a(2131694258), 0).a();
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztz
 * JD-Core Version:    0.7.0.1
 */