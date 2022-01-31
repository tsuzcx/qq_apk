import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class wlt
  implements urr<vfr, vfs>
{
  wlt(wls paramwls, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull vfr paramvfr, @Nullable vfs paramvfs, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvfs == null))
    {
      wxe.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      wls.a(this.jdField_a_of_type_Wls, paramErrorMessage);
      return;
    }
    wls.a(this.jdField_a_of_type_Wls).a(paramvfs.jdField_a_of_type_JavaUtilList, paramvfs.jdField_a_of_type_JavaLangString, paramvfs.jdField_a_of_type_Boolean);
    ((woy)uwa.a(11)).a(paramvfs.jdField_a_of_type_JavaUtilList);
    paramvfr = wls.a(this.jdField_a_of_type_Wls).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    wls.a(this.jdField_a_of_type_Wls, paramvfr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlt
 * JD-Core Version:    0.7.0.1
 */