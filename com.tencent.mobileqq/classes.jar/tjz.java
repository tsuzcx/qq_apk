import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class tjz
  extends tjd
  implements syq<tkb, tkc>
{
  public List<String> a = new ArrayList();
  
  public tjz(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    tkb localtkb = new tkb();
    localtkb.c = 1;
    localtkb.a = this.a;
    syo.a().a(localtkb, this);
  }
  
  public void a(@NonNull tkb paramtkb, @Nullable tkc paramtkc, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtkb = new tka(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramtkc != null) && (paramtkc.a != null))
    {
      paramtkb.a = paramtkc.a;
      b();
    }
    for (;;)
    {
      stb.a().dispatch(paramtkb);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjz
 * JD-Core Version:    0.7.0.1
 */