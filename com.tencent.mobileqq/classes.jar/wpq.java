import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

class wpq
  implements urr<vga, vgb>
{
  wpq(wpp paramwpp, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull vga paramvga, @Nullable vgb paramvgb, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramvgb == null))
    {
      wxe.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      wpp.a(this.jdField_a_of_type_Wpp, paramErrorMessage);
      return;
    }
    wpp.a(this.jdField_a_of_type_Wpp);
    wpp.a(this.jdField_a_of_type_Wpp).a(paramvgb.jdField_a_of_type_JavaUtilList, paramvgb.jdField_a_of_type_JavaLangString, paramvgb.jdField_a_of_type_Boolean);
    ((woy)uwa.a(11)).a(paramvgb.jdField_a_of_type_JavaUtilList);
    boolean bool = wpp.a(paramvgb, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    wxe.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramvgb.b), Integer.valueOf(wpp.b(this.jdField_a_of_type_Wpp)), Boolean.valueOf(bool) });
    if ((!paramvgb.jdField_a_of_type_Boolean) && (wpp.b(this.jdField_a_of_type_Wpp) < 10) && ((!paramvgb.b) || (bool)))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramvga.b = wpp.a(this.jdField_a_of_type_Wpp).a();
      urp.a().a(paramvga, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      wpp.a(this.jdField_a_of_type_Wpp).c();
    }
    paramvga = wpp.a(this.jdField_a_of_type_Wpp).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    wpp.a(this.jdField_a_of_type_Wpp, paramvga);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpq
 * JD-Core Version:    0.7.0.1
 */