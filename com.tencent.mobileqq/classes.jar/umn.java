import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class umn
  implements slx<ump, umq>
{
  private WeakReference<umm> a;
  
  public umn(umm paramumm)
  {
    this.a = new WeakReference(paramumm);
  }
  
  public void a(@NonNull ump paramump, @Nullable umq paramumq, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    umm localumm = (umm)this.a.get();
    if (localumm == null) {
      return;
    }
    localumm.a(paramump, paramumq, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umn
 * JD-Core Version:    0.7.0.1
 */