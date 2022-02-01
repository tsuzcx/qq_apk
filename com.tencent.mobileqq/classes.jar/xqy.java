import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class xqy
  implements vqp<xra, xrb>
{
  private WeakReference<xqx> a;
  
  public xqy(xqx paramxqx)
  {
    this.a = new WeakReference(paramxqx);
  }
  
  public void a(@NonNull xra paramxra, @Nullable xrb paramxrb, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    xqx localxqx = (xqx)this.a.get();
    if (localxqx == null) {
      return;
    }
    localxqx.a(paramxra, paramxrb, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqy
 * JD-Core Version:    0.7.0.1
 */