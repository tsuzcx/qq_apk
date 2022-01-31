import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class uzg
  implements syq<uzi, uzj>
{
  private WeakReference<uzf> a;
  
  public uzg(uzf paramuzf)
  {
    this.a = new WeakReference(paramuzf);
  }
  
  public void a(@NonNull uzi paramuzi, @Nullable uzj paramuzj, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    uzf localuzf = (uzf)this.a.get();
    if (localuzf == null) {
      return;
    }
    localuzf.a(paramuzi, paramuzj, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzg
 * JD-Core Version:    0.7.0.1
 */