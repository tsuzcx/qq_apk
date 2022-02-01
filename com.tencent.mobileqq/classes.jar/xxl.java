import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;

class xxl
  implements whw
{
  xxl(xxi paramxxi, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, anvx.a(2131713791));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131713788), 0).a();
    ykq.e("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!xxi.a(this.jdField_a_of_type_Xxi).get()) {
      xxi.a(this.jdField_a_of_type_Xxi, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxl
 * JD-Core Version:    0.7.0.1
 */