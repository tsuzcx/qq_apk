import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class xie
  implements bjoe
{
  private final int jdField_a_of_type_Int;
  private final bjnw jdField_a_of_type_Bjnw;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<xid> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xie(bjnw parambjnw, CommentEntry paramCommentEntry, int paramInt, xid paramxid)
  {
    this.jdField_a_of_type_Bjnw = parambjnw;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxid);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bjnw.a(paramInt);
    xvv.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      xvv.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    xid localxid = (xid)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (xic.a.equals(paramView)) {
      localxid.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      if (xic.b.equals(paramView)) {
        localxid.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (xic.c.equals(paramView)) {
        localxid.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (xic.d.equals(paramView)) {
        localxid.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (xic.e.equals(paramView)) {
        localxid.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xie
 * JD-Core Version:    0.7.0.1
 */