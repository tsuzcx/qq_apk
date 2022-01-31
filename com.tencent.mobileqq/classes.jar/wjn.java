import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class wjn
  implements bhuk
{
  private final int jdField_a_of_type_Int;
  private final bhuf jdField_a_of_type_Bhuf;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<wjm> jdField_a_of_type_JavaLangRefWeakReference;
  
  public wjn(bhuf parambhuf, CommentEntry paramCommentEntry, int paramInt, wjm paramwjm)
  {
    this.jdField_a_of_type_Bhuf = parambhuf;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwjm);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bhuf.a(paramInt);
    wxe.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      wxe.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    wjm localwjm = (wjm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (wjl.a.equals(paramView)) {
      localwjm.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
      if (wjl.b.equals(paramView)) {
        localwjm.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (wjl.c.equals(paramView)) {
        localwjm.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (wjl.d.equals(paramView)) {
        localwjm.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (wjl.e.equals(paramView)) {
        localwjm.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjn
 * JD-Core Version:    0.7.0.1
 */