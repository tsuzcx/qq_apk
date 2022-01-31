import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class tkc
  extends tjg
  implements syt<tke, tkf>
{
  public List<String> a = new ArrayList();
  
  public tkc(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    tke localtke = new tke();
    localtke.c = 1;
    localtke.a = this.a;
    syr.a().a(localtke, this);
  }
  
  public void a(@NonNull tke paramtke, @Nullable tkf paramtkf, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtke = new tkd(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramtkf != null) && (paramtkf.a != null))
    {
      paramtke.a = paramtkf.a;
      b();
    }
    for (;;)
    {
      ste.a().dispatch(paramtke);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkc
 * JD-Core Version:    0.7.0.1
 */