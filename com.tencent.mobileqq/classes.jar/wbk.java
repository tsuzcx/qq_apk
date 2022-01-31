import android.support.annotation.NonNull;
import android.text.TextUtils;

public class wbk
  extends umf<wax, utf>
{
  public wbk(wax paramwax)
  {
    super(paramwax);
  }
  
  public void a(@NonNull wax paramwax, @NonNull utf paramutf)
  {
    if ((paramwax.a != null) && (TextUtils.equals(paramwax.a.b, paramutf.a)))
    {
      wxe.a(this.TAG, "receive feed info change event. %s.", paramutf.toString());
      paramwax.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull wax paramwax, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbk
 * JD-Core Version:    0.7.0.1
 */