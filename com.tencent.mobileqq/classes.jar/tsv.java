import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class tsv
  implements syq<tmc, toa>
{
  tsv(ttc paramttc) {}
  
  public void a(@NonNull tmc paramtmc, @Nullable toa paramtoa, @NonNull ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new PlayModeUtils.6.1(this, paramtoa, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsv
 * JD-Core Version:    0.7.0.1
 */