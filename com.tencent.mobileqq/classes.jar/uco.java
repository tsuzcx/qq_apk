import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class uco
  implements slx<udb, udc>
{
  uco(ucn paramucn, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull udb paramudb, @Nullable udc paramudc, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramudc == null) || (paramErrorMessage.isFail()))
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      ucn.a(this.jdField_a_of_type_Ucn, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Ucn.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((sps)sqg.a(15)).a(paramudc.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramudb = new ucj(bool, paramudc.a, paramudc.b, paramudc.c);
      try
      {
        ucn.a(this.jdField_a_of_type_Ucn, paramudb);
        return;
      }
      catch (NullPointerException paramudb)
      {
        urk.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramudb);
        ucn.b(this.jdField_a_of_type_Ucn, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uco
 * JD-Core Version:    0.7.0.1
 */