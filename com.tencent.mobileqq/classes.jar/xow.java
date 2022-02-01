import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xow
  extends wag<xoj, wgy>
{
  public xow(xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull wgy paramwgy)
  {
    if ((paramxoj.a != null) && (TextUtils.equals(paramxoj.a.b, paramwgy.a)))
    {
      ykq.a(this.TAG, "receive feed info change event. %s.", paramwgy.toString());
      paramxoj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wgy.class;
  }
  
  public void b(@NonNull xoj paramxoj, @NonNull wgy paramwgy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xow
 * JD-Core Version:    0.7.0.1
 */