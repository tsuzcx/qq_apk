import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class uwk
  implements syq<tlt, tlu>
{
  uwk(uwh paramuwh, JobContext paramJobContext, uvu paramuvu) {}
  
  public void a(@NonNull tlt paramtlt, @Nullable tlu arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new tlu(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Uwh)
      {
        uwh.a(this.jdField_a_of_type_Uwh, paramErrorMessage);
        uwh.a(this.jdField_a_of_type_Uwh).remove(paramtlt);
        uwh.a(this.jdField_a_of_type_Uwh, this.jdField_a_of_type_Uvu);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    tcl localtcl = (tcl)tcz.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (tlv)localIterator.next();
      localtcl.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwk
 * JD-Core Version:    0.7.0.1
 */