import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class ymw
  implements woy<xdh, xdi>
{
  ymw(ymv paramymv, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull xdh paramxdh, @Nullable xdi paramxdi, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramxdi == null))
    {
      yuk.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      ymv.a(this.jdField_a_of_type_Ymv, paramErrorMessage);
      return;
    }
    ymv.a(this.jdField_a_of_type_Ymv);
    ymv.a(this.jdField_a_of_type_Ymv).a(paramxdi.jdField_a_of_type_JavaUtilList, paramxdi.jdField_a_of_type_JavaLangString, paramxdi.jdField_a_of_type_Boolean);
    ((yme)wth.a(11)).a(paramxdi.jdField_a_of_type_JavaUtilList);
    boolean bool = ymv.a(paramxdi, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    yuk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramxdi.b), Integer.valueOf(ymv.b(this.jdField_a_of_type_Ymv)), Boolean.valueOf(bool) });
    if ((!paramxdi.jdField_a_of_type_Boolean) && (ymv.b(this.jdField_a_of_type_Ymv) < 10) && ((!paramxdi.b) || (bool)))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramxdh.b = ymv.a(this.jdField_a_of_type_Ymv).a();
      wow.a().a(paramxdh, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      ymv.a(this.jdField_a_of_type_Ymv).c();
    }
    paramxdh = ymv.a(this.jdField_a_of_type_Ymv).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    ymv.a(this.jdField_a_of_type_Ymv, paramxdh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymw
 * JD-Core Version:    0.7.0.1
 */