import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class uyr
  extends uxv
  implements uni<uyt, uyu>
{
  public List<String> a = new ArrayList();
  
  public uyr(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    uyt localuyt = new uyt();
    localuyt.c = 1;
    localuyt.a = this.a;
    ung.a().a(localuyt, this);
  }
  
  public void a(@NonNull uyt paramuyt, @Nullable uyu paramuyu, @NonNull ErrorMessage paramErrorMessage)
  {
    paramuyt = new uys(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramuyu != null) && (paramuyu.a != null))
    {
      paramuyt.a = paramuyu.a;
      b();
    }
    for (;;)
    {
      uht.a().dispatch(paramuyt);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyr
 * JD-Core Version:    0.7.0.1
 */