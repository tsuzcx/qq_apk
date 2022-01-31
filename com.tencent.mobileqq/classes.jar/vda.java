import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class vda
  extends vce
  implements urr<vdc, vdd>
{
  public List<String> a = new ArrayList();
  
  public vda(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    vdc localvdc = new vdc();
    localvdc.c = 1;
    localvdc.a = this.a;
    urp.a().a(localvdc, this);
  }
  
  public void a(@NonNull vdc paramvdc, @Nullable vdd paramvdd, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvdc = new vdb(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramvdd != null) && (paramvdd.a != null))
    {
      paramvdc.a = paramvdd.a;
      b();
    }
    for (;;)
    {
      umc.a().dispatch(paramvdc);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vda
 * JD-Core Version:    0.7.0.1
 */