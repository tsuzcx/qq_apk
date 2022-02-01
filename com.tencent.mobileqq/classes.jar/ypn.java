import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class ypn
  implements woy<ypp, ypq>
{
  private WeakReference<ypm> a;
  
  public ypn(ypm paramypm)
  {
    this.a = new WeakReference(paramypm);
  }
  
  public void a(@NonNull ypp paramypp, @Nullable ypq paramypq, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    ypm localypm = (ypm)this.a.get();
    if (localypm == null) {
      return;
    }
    localypm.a(paramypp, paramypq, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypn
 * JD-Core Version:    0.7.0.1
 */