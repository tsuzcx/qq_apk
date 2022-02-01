import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class wbx
  extends wbb
  implements vqp<wbz, wca>
{
  public List<String> a = new ArrayList();
  
  public wbx(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    wbz localwbz = new wbz();
    localwbz.c = 1;
    localwbz.a = this.a;
    vqn.a().a(localwbz, this);
  }
  
  public void a(@NonNull wbz paramwbz, @Nullable wca paramwca, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwbz = new wby(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramwca != null) && (paramwca.a != null))
    {
      paramwbz.a = paramwca.a;
      b();
    }
    for (;;)
    {
      vli.a().dispatch(paramwbz);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbx
 * JD-Core Version:    0.7.0.1
 */