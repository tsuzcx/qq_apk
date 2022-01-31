import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class uon
  implements upu
{
  uon(uok paramuok, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, alpo.a(2131704776));
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131704799) + paramInt, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Uok.e();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.jdField_a_of_type_Uok.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Uok.e();
    this.jdField_a_of_type_Uok.jdField_a_of_type_Uqo.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    upg.a().a();
    this.jdField_a_of_type_Uok.a(false, null);
    QQToast.a(BaseApplication.getContext(), 2, alpo.a(2131704800), 0).a();
    uok.a(this.jdField_a_of_type_Uok.jdField_a_of_type_Int, 2, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uon
 * JD-Core Version:    0.7.0.1
 */