import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class xcs
  implements wfk<wts, wtt>
{
  xcs(xcr paramxcr, xde paramxde) {}
  
  public void a(@NonNull wts paramwts, @Nullable wtt paramwtt, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwtt == null))
    {
      ykq.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xde.a(paramErrorMessage, null, false);
      return;
    }
    xcr.a(this.jdField_a_of_type_Xcr);
    this.jdField_a_of_type_Xcr.b.a(paramwtt.jdField_a_of_type_JavaUtilList, paramwtt.jdField_a_of_type_JavaLangString, paramwtt.jdField_a_of_type_Boolean);
    ((yck)wjs.a(11)).a(paramwtt.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = ydb.a(paramwtt, localAtomicBoolean);
    ykq.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramwtt.b), Integer.valueOf(xcr.b(this.jdField_a_of_type_Xcr)), Boolean.valueOf(bool) });
    if ((!paramwtt.jdField_a_of_type_Boolean) && (xcr.b(this.jdField_a_of_type_Xcr) < 10) && ((!paramwtt.b) || (bool)))
    {
      ykq.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramwts.b = this.jdField_a_of_type_Xcr.b.a();
      wfi.a().a(paramwts, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Xcr.b.c();
    }
    this.jdField_a_of_type_Xde.a(paramErrorMessage, xcm.b(paramwtt.jdField_a_of_type_JavaUtilList), paramwtt.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcs
 * JD-Core Version:    0.7.0.1
 */