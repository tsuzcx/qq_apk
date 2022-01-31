import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class vhn
  implements uni<vau, vcs>
{
  vhn(vhu paramvhu) {}
  
  public void a(@NonNull vau paramvau, @Nullable vcs paramvcs, @NonNull ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new PlayModeUtils.6.1(this, paramvcs, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vhn
 * JD-Core Version:    0.7.0.1
 */