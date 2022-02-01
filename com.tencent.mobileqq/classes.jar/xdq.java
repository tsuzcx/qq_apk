import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xdq
  implements wfk<wtj, wtk>
{
  xdq(xdp paramxdp, xde paramxde) {}
  
  public void a(@NonNull wtj paramwtj, @Nullable wtk paramwtk, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwtk == null))
    {
      ykq.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xde.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Xdp.a.a(paramwtk.jdField_a_of_type_JavaUtilList, paramwtk.jdField_a_of_type_JavaLangString, paramwtk.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xde.a(paramErrorMessage, xcm.b(paramwtk.jdField_a_of_type_JavaUtilList), paramwtk.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdq
 * JD-Core Version:    0.7.0.1
 */