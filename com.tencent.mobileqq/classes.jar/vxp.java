import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class vxp
  implements syt<tnh, tni>
{
  vxp(vxo paramvxo, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull tnh paramtnh, @Nullable tni paramtni, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtni == null))
    {
      veg.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      vxo.a(this.jdField_a_of_type_Vxo, paramErrorMessage);
      return;
    }
    vxo.a(this.jdField_a_of_type_Vxo).a(paramtni.jdField_a_of_type_JavaUtilList, paramtni.jdField_a_of_type_JavaLangString, paramtni.jdField_a_of_type_Boolean);
    ((uwa)tdc.a(11)).a(paramtni.jdField_a_of_type_JavaUtilList);
    paramtnh = vxo.a(this.jdField_a_of_type_Vxo).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    vxo.a(this.jdField_a_of_type_Vxo, paramtnh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxp
 * JD-Core Version:    0.7.0.1
 */