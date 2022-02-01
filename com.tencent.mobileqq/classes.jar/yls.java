import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class yls
  implements wld<ylu, ylv>
{
  private WeakReference<ylr> a;
  
  public yls(ylr paramylr)
  {
    this.a = new WeakReference(paramylr);
  }
  
  public void a(@NonNull ylu paramylu, @Nullable ylv paramylv, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    ylr localylr = (ylr)this.a.get();
    if (localylr == null) {
      return;
    }
    localylr.a(paramylu, paramylv, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yls
 * JD-Core Version:    0.7.0.1
 */