import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class qhw
  implements prm
{
  qhw(qhr.a parama, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!qhr.b(this.a.a)) {
      qhr.a(this.a.a).b(this.c, this.val$isOpen);
    }
  }
  
  public void aJ(int paramInt, String paramString)
  {
    this.c.status = 0;
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704189), 0).show();
    ram.e("Q.qqstory.player.CommentFloatDialog", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void h(int paramInt, Bundle paramBundle)
  {
    aJ(-1, acfp.m(2131704192));
  }
  
  public void q(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhw
 * JD-Core Version:    0.7.0.1
 */