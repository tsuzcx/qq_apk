import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class uqm
  implements bfph
{
  private final int jdField_a_of_type_Int;
  private final bfpc jdField_a_of_type_Bfpc;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<uql> jdField_a_of_type_JavaLangRefWeakReference;
  
  public uqm(bfpc parambfpc, CommentEntry paramCommentEntry, int paramInt, uql paramuql)
  {
    this.jdField_a_of_type_Bfpc = parambfpc;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuql);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bfpc.a(paramInt);
    ved.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      ved.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    uql localuql = (uql)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (uqk.a.equals(paramView)) {
      localuql.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
      if (uqk.b.equals(paramView)) {
        localuql.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (uqk.c.equals(paramView)) {
        localuql.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (uqk.d.equals(paramView)) {
        localuql.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (uqk.e.equals(paramView)) {
        localuql.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqm
 * JD-Core Version:    0.7.0.1
 */