import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class uph
  implements syq<upu, upv>
{
  uph(upg paramupg, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull upu paramupu, @Nullable upv paramupv, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramupv == null) || (paramErrorMessage.isFail()))
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      upg.a(this.jdField_a_of_type_Upg, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Upg.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((tcl)tcz.a(15)).a(paramupv.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramupu = new upc(bool, paramupv.a, paramupv.b, paramupv.c);
      try
      {
        upg.a(this.jdField_a_of_type_Upg, paramupu);
        return;
      }
      catch (NullPointerException paramupu)
      {
        ved.c("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "notifyResult error :%s", paramupu);
        upg.b(this.jdField_a_of_type_Upg, new ErrorMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */