import android.support.annotation.NonNull;
import android.text.TextUtils;

public class wze
  extends vll<wyy, vsd>
{
  public wze(wyy paramwyy)
  {
    super(paramwyy);
  }
  
  public void a(@NonNull wyy paramwyy, @NonNull vsd paramvsd)
  {
    if ((paramwyy.a != null) && (TextUtils.equals(paramwyy.a.b, paramvsd.a)))
    {
      xvv.a(this.TAG, "receive feed info change event. %s.", paramvsd.toString());
      paramwyy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vsd.class;
  }
  
  public void b(@NonNull wyy paramwyy, @NonNull vsd paramvsd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wze
 * JD-Core Version:    0.7.0.1
 */