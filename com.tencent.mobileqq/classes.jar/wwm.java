import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class wwm
  extends wvq
  implements wld<wwo, wwp>
{
  public List<String> a = new ArrayList();
  
  public wwm(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    wwo localwwo = new wwo();
    localwwo.c = 1;
    localwwo.a = this.a;
    wlb.a().a(localwwo, this);
  }
  
  public void a(@NonNull wwo paramwwo, @Nullable wwp paramwwp, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwwo = new wwn(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramwwp != null) && (paramwwp.a != null))
    {
      paramwwo.a = paramwwp.a;
      b();
    }
    for (;;)
    {
      wfo.a().dispatch(paramwwo);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwm
 * JD-Core Version:    0.7.0.1
 */