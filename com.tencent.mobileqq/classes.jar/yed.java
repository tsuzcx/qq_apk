import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class yed
  implements ymp
{
  yed(ydw paramydw, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(ydw.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((ydw.n(this.jdField_a_of_type_Ydw) != null) && (paramInt == 1))
    {
      if (ymo.a().a(ydw.o(this.jdField_a_of_type_Ydw), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Ydw.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Ydw.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Ydw.i();
      }
    }
    label90:
    while ((ymo.a().a(ydw.p(this.jdField_a_of_type_Ydw), "subscribe_sp_key_show_follow_guide") != 0) || (ybu.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Ydw.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yed
 * JD-Core Version:    0.7.0.1
 */