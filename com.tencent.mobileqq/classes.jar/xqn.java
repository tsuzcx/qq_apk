import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class xqn
  implements urr<vgf, vgg>
{
  xqn(xqm paramxqm, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull vgf paramvgf, @Nullable vgg paramvgg, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvgg == null))
    {
      wxe.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      xqm.a(this.jdField_a_of_type_Xqm, paramErrorMessage);
      return;
    }
    xqm.a(this.jdField_a_of_type_Xqm).a(paramvgg.jdField_a_of_type_JavaUtilList, paramvgg.jdField_a_of_type_JavaLangString, paramvgg.jdField_a_of_type_Boolean);
    ((woy)uwa.a(11)).a(paramvgg.jdField_a_of_type_JavaUtilList);
    paramvgf = xqm.a(this.jdField_a_of_type_Xqm).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    xqm.a(this.jdField_a_of_type_Xqm, paramvgf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqn
 * JD-Core Version:    0.7.0.1
 */