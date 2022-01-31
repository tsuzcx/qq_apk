import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class ucm
  implements slx<szn, szo>
{
  ucm(ucl paramucl, JobContext paramJobContext, uiv paramuiv) {}
  
  public void a(@NonNull szn paramszn, @Nullable szo paramszo, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramszo == null) || (paramErrorMessage.isFail()))
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      ucl.a(this.jdField_a_of_type_Ucl, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Uiv.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((spd)sqg.a(17)).a(paramszo.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Uiv.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramszo.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramszo.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramszo.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramszn = new uci(bool1, paramszo.jdField_a_of_type_JavaUtilList, paramszo.b, bool2, paramszo.jdField_a_of_type_JavaLangString);
      ucl.a(this.jdField_a_of_type_Ucl, paramszn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucm
 * JD-Core Version:    0.7.0.1
 */