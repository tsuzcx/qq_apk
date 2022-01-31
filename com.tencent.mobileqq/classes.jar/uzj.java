import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class uzj
  implements syt<uzl, uzm>
{
  private WeakReference<uzi> a;
  
  public uzj(uzi paramuzi)
  {
    this.a = new WeakReference(paramuzi);
  }
  
  public void a(@NonNull uzl paramuzl, @Nullable uzm paramuzm, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    uzi localuzi = (uzi)this.a.get();
    if (localuzi == null) {
      return;
    }
    localuzi.a(paramuzl, paramuzm, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzj
 * JD-Core Version:    0.7.0.1
 */