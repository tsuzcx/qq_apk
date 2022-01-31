import android.support.annotation.NonNull;
import android.text.TextUtils;

public class vzu
  extends umf<vzl, utf>
{
  public vzu(vzl paramvzl)
  {
    super(paramvzl);
  }
  
  public void a(@NonNull vzl paramvzl, @NonNull utf paramutf)
  {
    if ((paramvzl.a != null) && (TextUtils.equals(paramvzl.a.b, paramutf.a)))
    {
      wxe.a(this.TAG, "receive feed info change event. %s.", paramutf.toString());
      paramvzl.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return utf.class;
  }
  
  public void b(@NonNull vzl paramvzl, @NonNull utf paramutf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzu
 * JD-Core Version:    0.7.0.1
 */