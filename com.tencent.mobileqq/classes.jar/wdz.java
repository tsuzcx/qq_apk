import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class wdz
  implements uni<wem, wen>
{
  wdz(wdy paramwdy, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull wem paramwem, @Nullable wen paramwen, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramwen == null) || (paramErrorMessage.isFail()))
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      wdy.a(this.jdField_a_of_type_Wdy, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Wdy.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((urd)urr.a(15)).a(paramwen.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramwem = new wdu(bool, paramwen.a, paramwen.b, paramwen.c);
      try
      {
        wdy.a(this.jdField_a_of_type_Wdy, paramwem);
        return;
      }
      catch (NullPointerException paramwem)
      {
        wsv.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramwem);
        wdy.b(this.jdField_a_of_type_Wdy, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdz
 * JD-Core Version:    0.7.0.1
 */