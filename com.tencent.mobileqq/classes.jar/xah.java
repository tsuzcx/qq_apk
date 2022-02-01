import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class xah
  extends wzl
  implements woy<xaj, xak>
{
  public List<String> a = new ArrayList();
  
  public xah(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    xaj localxaj = new xaj();
    localxaj.c = 1;
    localxaj.a = this.a;
    wow.a().a(localxaj, this);
  }
  
  public void a(@NonNull xaj paramxaj, @Nullable xak paramxak, @NonNull ErrorMessage paramErrorMessage)
  {
    paramxaj = new xai(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramxak != null) && (paramxak.a != null))
    {
      paramxaj.a = paramxak.a;
      b();
    }
    for (;;)
    {
      wjj.a().dispatch(paramxaj);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xah
 * JD-Core Version:    0.7.0.1
 */