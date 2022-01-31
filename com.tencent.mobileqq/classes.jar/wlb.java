import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class wlb
  implements wtk
{
  wlb(wku paramwku, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(wku.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((wku.n(this.jdField_a_of_type_Wku) != null) && (paramInt == 1))
    {
      if (wtj.a().a(wku.o(this.jdField_a_of_type_Wku), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Wku.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Wku.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Wku.f();
      }
    }
    label90:
    while ((wtj.a().a(wku.p(this.jdField_a_of_type_Wku), "subscribe_sp_key_show_follow_guide") != 0) || (wit.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Wku.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlb
 * JD-Core Version:    0.7.0.1
 */