import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ugt
  extends ste<ugk, tae>
{
  public ugt(ugk paramugk)
  {
    super(paramugk);
  }
  
  public void a(@NonNull ugk paramugk, @NonNull tae paramtae)
  {
    if ((paramugk.a != null) && (TextUtils.equals(paramugk.a.b, paramtae.a)))
    {
      ved.a(this.TAG, "receive feed info change event. %s.", paramtae.toString());
      paramugk.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull ugk paramugk, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugt
 * JD-Core Version:    0.7.0.1
 */