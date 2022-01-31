import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class ujw
  implements slx<tag, tah>
{
  ujw(ujv paramujv, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull tag paramtag, @Nullable tah paramtah, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramtah == null))
    {
      urk.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      ujv.a(this.jdField_a_of_type_Ujv, paramErrorMessage);
      return;
    }
    ujv.a(this.jdField_a_of_type_Ujv);
    ujv.a(this.jdField_a_of_type_Ujv).a(paramtah.jdField_a_of_type_JavaUtilList, paramtah.jdField_a_of_type_JavaLangString, paramtah.jdField_a_of_type_Boolean);
    ((uje)sqg.a(11)).a(paramtah.jdField_a_of_type_JavaUtilList);
    boolean bool = ujv.a(paramtah, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    urk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramtah.b), Integer.valueOf(ujv.b(this.jdField_a_of_type_Ujv)), Boolean.valueOf(bool) });
    if ((!paramtah.jdField_a_of_type_Boolean) && (ujv.b(this.jdField_a_of_type_Ujv) < 10) && ((!paramtah.b) || (bool)))
    {
      urk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramtag.b = ujv.a(this.jdField_a_of_type_Ujv).a();
      slv.a().a(paramtag, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      ujv.a(this.jdField_a_of_type_Ujv).c();
    }
    paramtag = ujv.a(this.jdField_a_of_type_Ujv).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    ujv.a(this.jdField_a_of_type_Ujv, paramtag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujw
 * JD-Core Version:    0.7.0.1
 */