import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xnz
  extends wag<xnt, wgy>
{
  public xnz(xnt paramxnt)
  {
    super(paramxnt);
  }
  
  public void a(@NonNull xnt paramxnt, @NonNull wgy paramwgy)
  {
    if ((paramxnt.a != null) && (TextUtils.equals(paramxnt.a.b, paramwgy.a)))
    {
      ykq.a(this.TAG, "receive feed info change event. %s.", paramwgy.toString());
      paramxnt.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull xnt paramxnt, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnz
 * JD-Core Version:    0.7.0.1
 */