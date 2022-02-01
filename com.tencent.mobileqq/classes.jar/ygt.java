import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class ygt
  implements bliz
{
  private final int jdField_a_of_type_Int;
  private final blir jdField_a_of_type_Blir;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<ygs> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ygt(blir paramblir, CommentEntry paramCommentEntry, int paramInt, ygs paramygs)
  {
    this.jdField_a_of_type_Blir = paramblir;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramygs);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Blir.a(paramInt);
    yuk.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      yuk.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    ygs localygs = (ygs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (ygr.a.equals(paramView)) {
      localygs.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      if (ygr.b.equals(paramView)) {
        localygs.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (ygr.c.equals(paramView)) {
        localygs.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (ygr.d.equals(paramView)) {
        localygs.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (ygr.e.equals(paramView)) {
        localygs.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygt
 * JD-Core Version:    0.7.0.1
 */