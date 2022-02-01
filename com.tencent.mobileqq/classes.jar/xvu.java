import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class xvu
  implements wfk<xwh, xwi>
{
  xvu(xvt paramxvt, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull xwh paramxwh, @Nullable xwi paramxwi, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramxwi == null) || (paramErrorMessage.isFail()))
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      xvt.a(this.jdField_a_of_type_Xvt, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Xvt.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((wje)wjs.a(15)).a(paramxwi.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramxwh = new xvp(bool, paramxwi.a, paramxwi.b, paramxwi.c);
      try
      {
        xvt.a(this.jdField_a_of_type_Xvt, paramxwh);
        return;
      }
      catch (NullPointerException paramxwh)
      {
        ykq.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramxwh);
        xvt.b(this.jdField_a_of_type_Xvt, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvu
 * JD-Core Version:    0.7.0.1
 */