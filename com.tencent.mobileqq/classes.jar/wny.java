import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class wny
  implements uni<woa, wob>
{
  private WeakReference<wnx> a;
  
  public wny(wnx paramwnx)
  {
    this.a = new WeakReference(paramwnx);
  }
  
  public void a(@NonNull woa paramwoa, @Nullable wob paramwob, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    wnx localwnx = (wnx)this.a.get();
    if (localwnx == null) {
      return;
    }
    localwnx.a(paramwoa, paramwob, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wny
 * JD-Core Version:    0.7.0.1
 */