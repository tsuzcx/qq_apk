import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class wqs
  extends wpw
  implements wfk<wqu, wqv>
{
  public List<String> a = new ArrayList();
  
  public wqs(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    wqu localwqu = new wqu();
    localwqu.c = 1;
    localwqu.a = this.a;
    wfi.a().a(localwqu, this);
  }
  
  public void a(@NonNull wqu paramwqu, @Nullable wqv paramwqv, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwqu = new wqt(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramwqv != null) && (paramwqv.a != null))
    {
      paramwqu.a = paramwqv.a;
      b();
    }
    for (;;)
    {
      wad.a().dispatch(paramwqu);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqs
 * JD-Core Version:    0.7.0.1
 */