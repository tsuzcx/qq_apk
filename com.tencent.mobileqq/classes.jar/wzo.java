import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class wzo
  implements wfk<wsv, wut>
{
  wzo(wzv paramwzv) {}
  
  public void a(@NonNull wsv paramwsv, @Nullable wut paramwut, @NonNull ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new PlayModeUtils.6.1(this, paramwut, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzo
 * JD-Core Version:    0.7.0.1
 */