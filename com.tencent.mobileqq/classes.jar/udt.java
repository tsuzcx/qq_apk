import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class udt
  implements begw
{
  private final int jdField_a_of_type_Int;
  private final begr jdField_a_of_type_Begr;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<uds> jdField_a_of_type_JavaLangRefWeakReference;
  
  public udt(begr parambegr, CommentEntry paramCommentEntry, int paramInt, uds paramuds)
  {
    this.jdField_a_of_type_Begr = parambegr;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuds);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Begr.a(paramInt);
    urk.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      urk.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    uds localuds = (uds)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (udr.a.equals(paramView)) {
      localuds.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
      if (udr.b.equals(paramView)) {
        localuds.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (udr.c.equals(paramView)) {
        localuds.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (udr.d.equals(paramView)) {
        localuds.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (udr.e.equals(paramView)) {
        localuds.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udt
 * JD-Core Version:    0.7.0.1
 */