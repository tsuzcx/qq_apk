import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class yiz
  implements woy<xcy, xcz>
{
  yiz(yiy paramyiy, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull xcy paramxcy, @Nullable xcz paramxcz, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramxcz == null))
    {
      yuk.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      yiy.a(this.jdField_a_of_type_Yiy, paramErrorMessage);
      return;
    }
    yiy.a(this.jdField_a_of_type_Yiy).a(paramxcz.jdField_a_of_type_JavaUtilList, paramxcz.jdField_a_of_type_JavaLangString, paramxcz.jdField_a_of_type_Boolean);
    ((yme)wth.a(11)).a(paramxcz.jdField_a_of_type_JavaUtilList);
    paramxcy = yiy.a(this.jdField_a_of_type_Yiy).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    yiy.a(this.jdField_a_of_type_Yiy, paramxcy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiz
 * JD-Core Version:    0.7.0.1
 */