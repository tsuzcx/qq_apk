import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class upk
  implements syt<upx, upy>
{
  upk(upj paramupj, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull upx paramupx, @Nullable upy paramupy, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramupy == null) || (paramErrorMessage.isFail()))
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      upj.a(this.jdField_a_of_type_Upj, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Upj.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((tco)tdc.a(15)).a(paramupy.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramupx = new upf(bool, paramupy.a, paramupy.b, paramupy.c);
      try
      {
        upj.a(this.jdField_a_of_type_Upj, paramupx);
        return;
      }
      catch (NullPointerException paramupx)
      {
        veg.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramupx);
        upj.b(this.jdField_a_of_type_Upj, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upk
 * JD-Core Version:    0.7.0.1
 */