import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

final class yqr
  implements wld<yqs, wla>
{
  public void a(@NonNull yqs paramyqs, @Nullable wla paramwla, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail()) {
      yqp.b("Q.qqstory.MonitorReport", "send monitor fail %s", paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqr
 * JD-Core Version:    0.7.0.1
 */