import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

final class wxg
  implements urr<wxh, uro>
{
  public void a(@NonNull wxh paramwxh, @Nullable uro paramuro, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail()) {
      wxe.b("Q.qqstory.MonitorReport", "send monitor fail %s", paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxg
 * JD-Core Version:    0.7.0.1
 */