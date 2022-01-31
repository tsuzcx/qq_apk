import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class wgt
  implements wxx<CertifiedAccountWrite.StDoLikeRsp>
{
  wgt(wgs paramwgs) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    RelativeFeedItemView.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView, true);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoLikeRsp == null))
    {
      bbmy.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.getContext(), 1, paramString, 0).a();
      return;
    }
    String str = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    if (paramStDoLikeRsp.like.status.get() == 1) {}
    for (paramString = "like";; paramString = "cancel_like")
    {
      wye.a(str, "auth_feeds", paramString, 0, 0, new String[] { "", RelativeFeedItemView.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView) + "", this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
      wcj.a().a(new PraisedUpdateEvents(this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), paramStDoLikeRsp.like.status.get()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgt
 * JD-Core Version:    0.7.0.1
 */