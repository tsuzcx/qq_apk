import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class uwj
  implements syq<tlq, tlr>
{
  uwj(uwh paramuwh, JobContext paramJobContext, uvu paramuvu) {}
  
  public void a(@NonNull tlq paramtlq, @Nullable tlr arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new tlr(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Uwh)
      {
        uwh.a(this.jdField_a_of_type_Uwh, paramErrorMessage);
        uwh.a(this.jdField_a_of_type_Uwh).remove(paramtlq);
        uwh.a(this.jdField_a_of_type_Uwh, this.jdField_a_of_type_Uvu);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    tbw localtbw = (tbw)tcz.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (tls)localIterator.next();
      localtbw.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localtbw.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwj
 * JD-Core Version:    0.7.0.1
 */