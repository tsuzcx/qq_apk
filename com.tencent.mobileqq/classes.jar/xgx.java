import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class xgx
  implements vqp<wee, wef>
{
  xgx(xgw paramxgw, JobContext paramJobContext, xng paramxng) {}
  
  public void a(@NonNull wee paramwee, @Nullable wef paramwef, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramwef == null) || (paramErrorMessage.isFail()))
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      xgw.a(this.jdField_a_of_type_Xgw, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Xng.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((vtu)vux.a(17)).a(paramwef.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Xng.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramwef.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramwef.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramwef.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramwee = new xgt(bool1, paramwef.jdField_a_of_type_JavaUtilList, paramwef.b, bool2, paramwef.jdField_a_of_type_JavaLangString);
      xgw.a(this.jdField_a_of_type_Xgw, paramwee);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgx
 * JD-Core Version:    0.7.0.1
 */