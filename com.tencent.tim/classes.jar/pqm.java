import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pqm
  implements prm
{
  pqm(pqj parampqj, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.b.lK.remove(this.val$itemIndex);
    this.b.notifyDataSetChanged();
    this.b.a.e(this.c);
    pqy.a().bmw();
    this.b.a(false, null);
    QQToast.a(BaseApplication.getContext(), 2, acfp.m(2131706147), 0).show();
    pqj.b(this.b.mFeedType, 2, this.c.feedId, this.c.commentId);
  }
  
  public void aJ(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706146) + paramInt, 0).show();
    this.c.status = 0;
    this.b.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void h(int paramInt, Bundle paramBundle)
  {
    aJ(-1, acfp.m(2131706123));
  }
  
  public void q(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqm
 * JD-Core Version:    0.7.0.1
 */