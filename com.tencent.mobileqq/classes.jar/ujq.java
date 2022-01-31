import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class ujq
  implements slx<syx, syy>
{
  ujq(ujo paramujo, JobContext paramJobContext, ujb paramujb) {}
  
  public void a(@NonNull syx paramsyx, @Nullable syy arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new syy(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Ujo)
      {
        ujo.a(this.jdField_a_of_type_Ujo, paramErrorMessage);
        ujo.a(this.jdField_a_of_type_Ujo).remove(paramsyx);
        ujo.a(this.jdField_a_of_type_Ujo, this.jdField_a_of_type_Ujb);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    spd localspd = (spd)sqg.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (syz)localIterator.next();
      localspd.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localspd.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujq
 * JD-Core Version:    0.7.0.1
 */