import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class zdn
  implements zko
{
  zdn(zdg paramzdg, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(zdg.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((zdg.n(this.jdField_a_of_type_Zdg) != null) && (paramInt == 1))
    {
      if (zkn.a().a(zdg.o(this.jdField_a_of_type_Zdg), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Zdg.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Zdg.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Zdg.h();
      }
    }
    label90:
    while ((zkn.a().a(zdg.p(this.jdField_a_of_type_Zdg), "subscribe_sp_key_show_follow_guide") != 0) || (zbi.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Zdg.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdn
 * JD-Core Version:    0.7.0.1
 */