import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class wdx
  implements uni<vay, vaz>
{
  wdx(wdw paramwdw, JobContext paramJobContext, wkg paramwkg) {}
  
  public void a(@NonNull vay paramvay, @Nullable vaz paramvaz, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramvaz == null) || (paramErrorMessage.isFail()))
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      wdw.a(this.jdField_a_of_type_Wdw, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Wkg.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((uqo)urr.a(17)).a(paramvaz.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Wkg.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramvaz.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramvaz.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramvaz.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramvay = new wdt(bool1, paramvaz.jdField_a_of_type_JavaUtilList, paramvaz.b, bool2, paramvaz.jdField_a_of_type_JavaLangString);
      wdw.a(this.jdField_a_of_type_Wdw, paramvay);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdx
 * JD-Core Version:    0.7.0.1
 */