import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class yfo
  implements woy<ygb, ygc>
{
  yfo(yfn paramyfn, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull ygb paramygb, @Nullable ygc paramygc, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramygc == null) || (paramErrorMessage.isFail()))
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      yfn.a(this.jdField_a_of_type_Yfn, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Yfn.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((wst)wth.a(15)).a(paramygc.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramygb = new yfj(bool, paramygc.a, paramygc.b, paramygc.c);
      try
      {
        yfn.a(this.jdField_a_of_type_Yfn, paramygb);
        return;
      }
      catch (NullPointerException paramygb)
      {
        yuk.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramygb);
        yfn.b(this.jdField_a_of_type_Yfn, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfo
 * JD-Core Version:    0.7.0.1
 */