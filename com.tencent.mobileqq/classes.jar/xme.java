import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class xme
  implements uni<vbw, vbx>
{
  xme(xmd paramxmd, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull vbw paramvbw, @Nullable vbx paramvbx, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvbx == null))
    {
      wsv.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      xmd.a(this.jdField_a_of_type_Xmd, paramErrorMessage);
      return;
    }
    xmd.a(this.jdField_a_of_type_Xmd).a(paramvbx.jdField_a_of_type_JavaUtilList, paramvbx.jdField_a_of_type_JavaLangString, paramvbx.jdField_a_of_type_Boolean);
    ((wkp)urr.a(11)).a(paramvbx.jdField_a_of_type_JavaUtilList);
    paramvbw = xmd.a(this.jdField_a_of_type_Xmd).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    xmd.a(this.jdField_a_of_type_Xmd, paramvbw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */