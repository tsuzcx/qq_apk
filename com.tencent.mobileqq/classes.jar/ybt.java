import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class ybt
  implements wld<ycg, ych>
{
  ybt(ybs paramybs, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull ycg paramycg, @Nullable ych paramych, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramych == null) || (paramErrorMessage.isFail()))
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      ybs.a(this.jdField_a_of_type_Ybs, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Ybs.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((woy)wpm.a(15)).a(paramych.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramycg = new ybo(bool, paramych.a, paramych.b, paramych.c);
      try
      {
        ybs.a(this.jdField_a_of_type_Ybs, paramycg);
        return;
      }
      catch (NullPointerException paramycg)
      {
        yqp.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramycg);
        ybs.b(this.jdField_a_of_type_Ybs, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybt
 * JD-Core Version:    0.7.0.1
 */