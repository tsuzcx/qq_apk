import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class vxm
  implements syq<tne, tnf>
{
  vxm(vxl paramvxl, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull tne paramtne, @Nullable tnf paramtnf, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtnf == null))
    {
      ved.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      vxl.a(this.jdField_a_of_type_Vxl, paramErrorMessage);
      return;
    }
    vxl.a(this.jdField_a_of_type_Vxl).a(paramtnf.jdField_a_of_type_JavaUtilList, paramtnf.jdField_a_of_type_JavaLangString, paramtnf.jdField_a_of_type_Boolean);
    ((uvx)tcz.a(11)).a(paramtnf.jdField_a_of_type_JavaUtilList);
    paramtne = vxl.a(this.jdField_a_of_type_Vxl).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    vxl.a(this.jdField_a_of_type_Vxl, paramtne);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxm
 * JD-Core Version:    0.7.0.1
 */