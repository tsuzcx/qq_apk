import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class uwi
  implements syq<tlw, tlx>
{
  uwi(uwh paramuwh, JobContext paramJobContext, uvu paramuvu) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable tlx arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    tlx localtlx = ???;
    if (??? == null) {
      localtlx = new tlx(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Uwh)
    {
      uwh.a(this.jdField_a_of_type_Uwh, localtlx);
      uwh.a(this.jdField_a_of_type_Uwh).remove(paramtlw);
      uwh.a(this.jdField_a_of_type_Uwh, this.jdField_a_of_type_Uvu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwi
 * JD-Core Version:    0.7.0.1
 */