import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.subscribe.comment.CommentPresenter.5.1;
import com.tencent.qphone.base.util.QLog;

public class scz
  implements View.OnLayoutChangeListener
{
  scz(scw paramscw) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QLog.d(scw.access$700(), 2, "OnLayoutChangeListener scrollToReplyView start mScrollToTargetReply" + scw.c(this.this$0));
    if ((scw.a(this.this$0) != null) && (scw.c(this.this$0))) {
      scw.a(this.this$0, new CommentPresenter.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scz
 * JD-Core Version:    0.7.0.1
 */