import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class xvs
  implements wfk<wsz, wta>
{
  xvs(xvr paramxvr, JobContext paramJobContext, ycb paramycb) {}
  
  public void a(@NonNull wsz paramwsz, @Nullable wta paramwta, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramwta == null) || (paramErrorMessage.isFail()))
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      xvr.a(this.jdField_a_of_type_Xvr, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Ycb.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((wip)wjs.a(17)).a(paramwta.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ycb.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramwta.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramwta.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramwta.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramwsz = new xvo(bool1, paramwta.jdField_a_of_type_JavaUtilList, paramwta.b, bool2, paramwta.jdField_a_of_type_JavaLangString);
      xvr.a(this.jdField_a_of_type_Xvr, paramwsz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvs
 * JD-Core Version:    0.7.0.1
 */