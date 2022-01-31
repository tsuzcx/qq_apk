import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;

class uqy
  implements tbc
{
  uqy(uqv paramuqv, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, ajya.a(2131714418));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131714415), 0).a();
    ved.e("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!uqv.a(this.jdField_a_of_type_Uqv).get()) {
      uqv.a(this.jdField_a_of_type_Uqv, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqy
 * JD-Core Version:    0.7.0.1
 */