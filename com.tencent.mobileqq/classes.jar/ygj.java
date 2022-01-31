import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.subscribe.comment.CommentPresenter.5.1;
import com.tencent.qphone.base.util.QLog;

public class ygj
  implements View.OnLayoutChangeListener
{
  ygj(ygg paramygg) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QLog.d(ygg.a(), 2, "OnLayoutChangeListener scrollToReplyView start mScrollToTargetReply" + ygg.c(this.a));
    if ((ygg.a(this.a) != null) && (ygg.c(this.a))) {
      ygg.a(this.a, new CommentPresenter.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygj
 * JD-Core Version:    0.7.0.1
 */