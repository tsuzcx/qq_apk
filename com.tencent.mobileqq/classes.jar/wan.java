import android.support.annotation.NonNull;
import android.text.TextUtils;

public class wan
  extends umf<wah, utf>
{
  public wan(wah paramwah)
  {
    super(paramwah);
  }
  
  public void a(@NonNull wah paramwah, @NonNull utf paramutf)
  {
    if ((paramwah.a != null) && (TextUtils.equals(paramwah.a.b, paramutf.a)))
    {
      wxe.a(this.TAG, "receive feed info change event. %s.", paramutf.toString());
      paramwah.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull wah paramwah, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wan
 * JD-Core Version:    0.7.0.1
 */