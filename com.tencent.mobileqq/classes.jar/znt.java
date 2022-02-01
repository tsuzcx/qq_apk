import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class znt
  implements woy<xdm, xdn>
{
  znt(zns paramzns, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull xdm paramxdm, @Nullable xdn paramxdn, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramxdn == null))
    {
      yuk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      zns.a(this.jdField_a_of_type_Zns, paramErrorMessage);
      return;
    }
    zns.a(this.jdField_a_of_type_Zns).a(paramxdn.jdField_a_of_type_JavaUtilList, paramxdn.jdField_a_of_type_JavaLangString, paramxdn.jdField_a_of_type_Boolean);
    ((yme)wth.a(11)).a(paramxdn.jdField_a_of_type_JavaUtilList);
    paramxdm = zns.a(this.jdField_a_of_type_Zns).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    zns.a(this.jdField_a_of_type_Zns, paramxdm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znt
 * JD-Core Version:    0.7.0.1
 */