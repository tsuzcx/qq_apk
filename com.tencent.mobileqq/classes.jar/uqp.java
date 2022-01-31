import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class uqp
  implements bfoq
{
  private final int jdField_a_of_type_Int;
  private final bfol jdField_a_of_type_Bfol;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<uqo> jdField_a_of_type_JavaLangRefWeakReference;
  
  public uqp(bfol parambfol, CommentEntry paramCommentEntry, int paramInt, uqo paramuqo)
  {
    this.jdField_a_of_type_Bfol = parambfol;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuqo);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bfol.a(paramInt);
    veg.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      veg.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    uqo localuqo = (uqo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (uqn.a.equals(paramView)) {
      localuqo.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
      if (uqn.b.equals(paramView)) {
        localuqo.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (uqn.c.equals(paramView)) {
        localuqo.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (uqn.d.equals(paramView)) {
        localuqo.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (uqn.e.equals(paramView)) {
        localuqo.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqp
 * JD-Core Version:    0.7.0.1
 */