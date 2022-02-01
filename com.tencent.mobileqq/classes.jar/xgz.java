import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class xgz
  implements vqp<xhm, xhn>
{
  xgz(xgy paramxgy, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull xhm paramxhm, @Nullable xhn paramxhn, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramxhn == null) || (paramErrorMessage.isFail()))
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      xgy.a(this.jdField_a_of_type_Xgy, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Xgy.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((vuj)vux.a(15)).a(paramxhn.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramxhm = new xgu(bool, paramxhn.a, paramxhn.b, paramxhn.c);
      try
      {
        xgy.a(this.jdField_a_of_type_Xgy, paramxhm);
        return;
      }
      catch (NullPointerException paramxhm)
      {
        xvv.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramxhm);
        xgy.b(this.jdField_a_of_type_Xgy, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgz
 * JD-Core Version:    0.7.0.1
 */