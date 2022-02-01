import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class xwz
  implements bkzq
{
  private final int jdField_a_of_type_Int;
  private final bkzi jdField_a_of_type_Bkzi;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<xwy> jdField_a_of_type_JavaLangRefWeakReference;
  
  public xwz(bkzi parambkzi, CommentEntry paramCommentEntry, int paramInt, xwy paramxwy)
  {
    this.jdField_a_of_type_Bkzi = parambkzi;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxwy);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bkzi.a(paramInt);
    ykq.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      ykq.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    xwy localxwy = (xwy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (xwx.a.equals(paramView)) {
      localxwy.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      if (xwx.b.equals(paramView)) {
        localxwy.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (xwx.c.equals(paramView)) {
        localxwy.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (xwx.d.equals(paramView)) {
        localxwy.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (xwx.e.equals(paramView)) {
        localxwy.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwz
 * JD-Core Version:    0.7.0.1
 */