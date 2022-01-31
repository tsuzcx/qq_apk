import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class wig
  implements urr<vfh, vfi>
{
  wig(wif paramwif, JobContext paramJobContext, wop paramwop) {}
  
  public void a(@NonNull vfh paramvfh, @Nullable vfi paramvfi, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramvfi == null) || (paramErrorMessage.isFail()))
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      wif.a(this.jdField_a_of_type_Wif, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Wop.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((uux)uwa.a(17)).a(paramvfi.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Wop.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramvfi.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramvfi.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramvfi.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramvfh = new wic(bool1, paramvfi.jdField_a_of_type_JavaUtilList, paramvfi.b, bool2, paramvfi.jdField_a_of_type_JavaLangString);
      wif.a(this.jdField_a_of_type_Wif, paramvfh);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wig
 * JD-Core Version:    0.7.0.1
 */