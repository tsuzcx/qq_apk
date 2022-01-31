import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class wlh
  implements uni<vbr, vbs>
{
  wlh(wlg paramwlg, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull vbr paramvbr, @Nullable vbs paramvbs, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvbs == null))
    {
      wsv.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      wlg.a(this.jdField_a_of_type_Wlg, paramErrorMessage);
      return;
    }
    wlg.a(this.jdField_a_of_type_Wlg);
    wlg.a(this.jdField_a_of_type_Wlg).a(paramvbs.jdField_a_of_type_JavaUtilList, paramvbs.jdField_a_of_type_JavaLangString, paramvbs.jdField_a_of_type_Boolean);
    ((wkp)urr.a(11)).a(paramvbs.jdField_a_of_type_JavaUtilList);
    boolean bool = wlg.a(paramvbs, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    wsv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramvbs.b), Integer.valueOf(wlg.b(this.jdField_a_of_type_Wlg)), Boolean.valueOf(bool) });
    if ((!paramvbs.jdField_a_of_type_Boolean) && (wlg.b(this.jdField_a_of_type_Wlg) < 10) && ((!paramvbs.b) || (bool)))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramvbr.b = wlg.a(this.jdField_a_of_type_Wlg).a();
      ung.a().a(paramvbr, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      wlg.a(this.jdField_a_of_type_Wlg).c();
    }
    paramvbr = wlg.a(this.jdField_a_of_type_Wlg).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    wlg.a(this.jdField_a_of_type_Wlg, paramvbr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlh
 * JD-Core Version:    0.7.0.1
 */