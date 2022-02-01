import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class yft
  implements wfk<yfv, yfw>
{
  private WeakReference<yfs> a;
  
  public yft(yfs paramyfs)
  {
    this.a = new WeakReference(paramyfs);
  }
  
  public void a(@NonNull yfv paramyfv, @Nullable yfw paramyfw, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    yfs localyfs = (yfs)this.a.get();
    if (localyfs == null) {
      return;
    }
    localyfs.a(paramyfv, paramyfw, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yft
 * JD-Core Version:    0.7.0.1
 */