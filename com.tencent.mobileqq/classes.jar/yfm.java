import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class yfm
  implements woy<xco, xcp>
{
  yfm(yfl paramyfl, JobContext paramJobContext, ylv paramylv) {}
  
  public void a(@NonNull xco paramxco, @Nullable xcp paramxcp, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramxcp == null) || (paramErrorMessage.isFail()))
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      yfl.a(this.jdField_a_of_type_Yfl, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Ylv.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((wse)wth.a(17)).a(paramxcp.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ylv.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramxcp.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramxcp.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramxcp.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramxco = new yfi(bool1, paramxcp.jdField_a_of_type_JavaUtilList, paramxcp.b, bool2, paramxcp.jdField_a_of_type_JavaLangString);
      yfl.a(this.jdField_a_of_type_Yfl, paramxco);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfm
 * JD-Core Version:    0.7.0.1
 */