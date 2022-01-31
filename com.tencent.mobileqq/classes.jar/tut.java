import android.support.annotation.NonNull;
import android.text.TextUtils;

public class tut
  extends sgl<tun, snl>
{
  public tut(tun paramtun)
  {
    super(paramtun);
  }
  
  public void a(@NonNull tun paramtun, @NonNull snl paramsnl)
  {
    if ((paramtun.a != null) && (TextUtils.equals(paramtun.a.b, paramsnl.a)))
    {
      urk.a(this.TAG, "receive feed info change event. %s.", paramsnl.toString());
      paramtun.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull tun paramtun, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tut
 * JD-Core Version:    0.7.0.1
 */