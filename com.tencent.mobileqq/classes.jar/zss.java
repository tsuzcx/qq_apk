import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class zss
  implements zzt
{
  zss(zsl paramzsl, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(zsl.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((zsl.n(this.jdField_a_of_type_Zsl) != null) && (paramInt == 1))
    {
      if (zzs.a().a(zsl.o(this.jdField_a_of_type_Zsl), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Zsl.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Zsl.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Zsl.h();
      }
    }
    label90:
    while ((zzs.a().a(zsl.p(this.jdField_a_of_type_Zsl), "subscribe_sp_key_show_follow_guide") != 0) || (zqn.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Zsl.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zss
 * JD-Core Version:    0.7.0.1
 */