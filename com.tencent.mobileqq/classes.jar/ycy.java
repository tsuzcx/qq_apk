import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class ycy
  implements bkhw
{
  private final int jdField_a_of_type_Int;
  private final bkho jdField_a_of_type_Bkho;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<ycx> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ycy(bkho parambkho, CommentEntry paramCommentEntry, int paramInt, ycx paramycx)
  {
    this.jdField_a_of_type_Bkho = parambkho;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramycx);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bkho.a(paramInt);
    yqp.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      yqp.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    ycx localycx = (ycx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (ycw.a.equals(paramView)) {
      localycx.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      if (ycw.b.equals(paramView)) {
        localycx.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (ycw.c.equals(paramView)) {
        localycx.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (ycw.d.equals(paramView)) {
        localycx.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (ycw.e.equals(paramView)) {
        localycx.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycy
 * JD-Core Version:    0.7.0.1
 */