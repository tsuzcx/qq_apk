import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import android.os.Bundle;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;

public class ybc
  implements yvn<CertifiedAccountWrite.StDoLikeRsp>
{
  public ybc(CommentBottomBar paramCommentBottomBar) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    CommentBottomBar.a(this.a, true);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoLikeRsp == null)) {
      QQToast.a(this.a.getContext(), 1, paramString, 0).a();
    }
    label291:
    label295:
    for (;;)
    {
      return;
      if (paramStDoLikeRsp.like.status.get() == 1)
      {
        i = CommentBottomBar.a(this.a).likeInfo.count.get() + 1;
        if (CommentBottomBar.a(this.a) != null)
        {
          CommentBottomBar.a(this.a).likeInfo.status.set(paramStDoLikeRsp.like.status.get());
          CommentBottomBar.a(this.a).likeInfo.count.set(i);
        }
        yej.a().a(new PraisedUpdateEvents(CommentBottomBar.a(this.a).id.get(), paramStDoLikeRsp.like.status.get(), i));
        if (BaseApplicationImpl.sProcessId != 1) {
          break label291;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label295;
        }
        paramString = new Bundle();
        paramString.putString("feed_id", CommentBottomBar.a(this.a).id.get());
        paramString.putInt("feed_like_status", paramStDoLikeRsp.like.status.get());
        paramString.putInt("feed_like_num", paramStDoLikeRsp.like.count.get());
        QIPCClientHelper.getInstance().callServer(yej.a, yej.b, paramString, null);
        return;
        i = CommentBottomBar.a(this.a).likeInfo.count.get() - 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybc
 * JD-Core Version:    0.7.0.1
 */