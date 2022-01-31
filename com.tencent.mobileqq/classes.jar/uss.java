import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;

class uss
  implements syq<tmq, tmr>
{
  uss(usr paramusr, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull tmq paramtmq, @Nullable tmr paramtmr, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtmr == null))
    {
      ved.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      usr.a(this.jdField_a_of_type_Usr, paramErrorMessage);
      return;
    }
    usr.a(this.jdField_a_of_type_Usr).a(paramtmr.jdField_a_of_type_JavaUtilList, paramtmr.jdField_a_of_type_JavaLangString, paramtmr.jdField_a_of_type_Boolean);
    ((uvx)tcz.a(11)).a(paramtmr.jdField_a_of_type_JavaUtilList);
    paramtmq = usr.a(this.jdField_a_of_type_Usr).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    usr.a(this.jdField_a_of_type_Usr, paramtmq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uss
 * JD-Core Version:    0.7.0.1
 */