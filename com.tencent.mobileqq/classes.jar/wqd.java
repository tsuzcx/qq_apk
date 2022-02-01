import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class wqd
  implements wrk
{
  wqd(wqa paramwqa, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, anzj.a(2131703292));
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131703315) + paramInt, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Wqa.e();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.jdField_a_of_type_Wqa.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Wqa.e();
    this.jdField_a_of_type_Wqa.jdField_a_of_type_Wse.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    wqw.a().a();
    this.jdField_a_of_type_Wqa.a(false, null);
    QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131703316), 0).a();
    wqa.a(this.jdField_a_of_type_Wqa.jdField_a_of_type_Int, 2, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */