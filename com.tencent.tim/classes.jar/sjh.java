import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

class sjh
  implements rxc.a<CertifiedAccountWrite.StDoLikeRsp>
{
  sjh(sjg paramsjg) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    RelativeFeedItemView.a(this.a.a, true);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoLikeRsp == null))
    {
      QQToast.a(this.a.a.getContext(), 1, paramString, 0).show();
      return;
    }
    int i;
    String str;
    if (paramStDoLikeRsp.like.status.get() == 1)
    {
      i = this.a.e.likeInfo.count.get() + 1;
      str = this.a.e.poster.id.get();
      if (paramStDoLikeRsp.like.status.get() != 1) {
        break label270;
      }
    }
    label270:
    for (paramString = "like";; paramString = "cancel_like")
    {
      sqn.b(str, "auth_feeds", paramString, 0, 0, new String[] { "", RelativeFeedItemView.a(this.a.a) + "", this.a.e.poster.nick.get(), this.a.e.title.get() });
      rwv.a().a(new PraisedUpdateEvents(this.a.e.id.get(), paramStDoLikeRsp.like.status.get(), i));
      return;
      i = this.a.e.likeInfo.count.get() - 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */