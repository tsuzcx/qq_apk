import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xec
  implements wfk<wtx, wty>
{
  xec(xeb paramxeb, xde paramxde) {}
  
  public void a(@NonNull wtx paramwtx, @Nullable wty paramwty, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwty == null))
    {
      ykq.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xde.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Xeb.a.a(paramwty.jdField_a_of_type_JavaUtilList, paramwty.jdField_a_of_type_JavaLangString, paramwty.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xde.a(paramErrorMessage, xcm.b(paramwty.jdField_a_of_type_JavaUtilList), paramwty.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xec
 * JD-Core Version:    0.7.0.1
 */