import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.BaseApplication;

class txz
  implements tbc
{
  txz(txy paramtxy, CommentEntry paramCommentEntry, boolean paramBoolean) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, ajya.a(2131702180));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131702177), 0).a();
    ved.e("Q.qqstory.player.CommentFloatDialog", "delete comment failed. errorCode = %d, errorMsg=%s.", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    if (!txt.b(this.jdField_a_of_type_Txy.a)) {
      txt.a(this.jdField_a_of_type_Txy.a).a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txz
 * JD-Core Version:    0.7.0.1
 */