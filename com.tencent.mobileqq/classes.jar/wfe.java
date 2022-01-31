import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.lang.ref.WeakReference;

public class wfe
  implements bhqd
{
  private final int jdField_a_of_type_Int;
  private final bhpy jdField_a_of_type_Bhpy;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private WeakReference<wfd> jdField_a_of_type_JavaLangRefWeakReference;
  
  public wfe(bhpy parambhpy, CommentEntry paramCommentEntry, int paramInt, wfd paramwfd)
  {
    this.jdField_a_of_type_Bhpy = parambhpy;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwfd);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bhpy.a(paramInt);
    wsv.a("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on action sheet item click. item is %s.", paramView);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      wsv.e("Q.qqstory.detail.DetailGeneralCommentEventProxy", "callback is null when action sheet item click.");
      return;
    }
    wfd localwfd = (wfd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (wfc.a.equals(paramView)) {
      localwfd.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      if (wfc.b.equals(paramView)) {
        localwfd.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int);
      } else if (wfc.c.equals(paramView)) {
        localwfd.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (wfc.d.equals(paramView)) {
        localwfd.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      } else if (wfc.e.equals(paramView)) {
        localwfd.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfe
 * JD-Core Version:    0.7.0.1
 */