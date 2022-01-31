import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;

public class wsh
  implements urr<wsj, wsk>
{
  private WeakReference<wsg> a;
  
  public wsh(wsg paramwsg)
  {
    this.a = new WeakReference(paramwsg);
  }
  
  public void a(@NonNull wsj paramwsj, @Nullable wsk paramwsk, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    wsg localwsg = (wsg)this.a.get();
    if (localwsg == null) {
      return;
    }
    localwsg.a(paramwsj, paramwsk, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsh
 * JD-Core Version:    0.7.0.1
 */