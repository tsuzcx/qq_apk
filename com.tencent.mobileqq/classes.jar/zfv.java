import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.subscribe.comment.CommentPresenter.5.1;
import com.tencent.qphone.base.util.QLog;

public class zfv
  implements View.OnLayoutChangeListener
{
  zfv(zfs paramzfs) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QLog.d(zfs.a(), 2, "OnLayoutChangeListener scrollToReplyView start mScrollToTargetReply" + zfs.c(this.a));
    if ((zfs.a(this.a) != null) && (zfs.c(this.a))) {
      zfs.a(this.a, new CommentPresenter.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfv
 * JD-Core Version:    0.7.0.1
 */