import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class wii
  implements urr<wiv, wiw>
{
  wii(wih paramwih, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull wiv paramwiv, @Nullable wiw paramwiw, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramwiw == null) || (paramErrorMessage.isFail()))
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      wih.a(this.jdField_a_of_type_Wih, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Wih.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((uvm)uwa.a(15)).a(paramwiw.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramwiv = new wid(bool, paramwiw.a, paramwiw.b, paramwiw.c);
      try
      {
        wih.a(this.jdField_a_of_type_Wih, paramwiv);
        return;
      }
      catch (NullPointerException paramwiv)
      {
        wxe.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramwiv);
        wih.b(this.jdField_a_of_type_Wih, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wii
 * JD-Core Version:    0.7.0.1
 */