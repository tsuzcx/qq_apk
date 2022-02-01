import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xng
  extends wag<xmx, wgy>
{
  public xng(xmx paramxmx)
  {
    super(paramxmx);
  }
  
  public void a(@NonNull xmx paramxmx, @NonNull wgy paramwgy)
  {
    if ((paramxmx.a != null) && (TextUtils.equals(paramxmx.a.b, paramwgy.a)))
    {
      ykq.a(this.TAG, "receive feed info change event. %s.", paramwgy.toString());
      paramxmx.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull xmx paramxmx, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xng
 * JD-Core Version:    0.7.0.1
 */