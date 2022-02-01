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

public class sce
  implements rxc.a<CertifiedAccountWrite.StDoLikeRsp>
{
  public sce(CommentBottomBar paramCommentBottomBar) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    CommentBottomBar.a(this.b, true);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoLikeRsp == null)) {
      QQToast.a(this.b.getContext(), 1, paramString, 0).show();
    }
    label291:
    label295:
    for (;;)
    {
      return;
      if (paramStDoLikeRsp.like.status.get() == 1)
      {
        i = CommentBottomBar.a(this.b).likeInfo.count.get() + 1;
        if (CommentBottomBar.a(this.b) != null)
        {
          CommentBottomBar.a(this.b).likeInfo.status.set(paramStDoLikeRsp.like.status.get());
          CommentBottomBar.a(this.b).likeInfo.count.set(i);
        }
        rwv.a().a(new PraisedUpdateEvents(CommentBottomBar.a(this.b).id.get(), paramStDoLikeRsp.like.status.get(), i));
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
        paramString.putString("feed_id", CommentBottomBar.a(this.b).id.get());
        paramString.putInt("feed_like_status", paramStDoLikeRsp.like.status.get());
        paramString.putInt("feed_like_num", paramStDoLikeRsp.like.count.get());
        QIPCClientHelper.getInstance().callServer(rwv.aDa, rwv.aDb, paramString, null);
        return;
        i = CommentBottomBar.a(this.b).likeInfo.count.get() - 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sce
 * JD-Core Version:    0.7.0.1
 */