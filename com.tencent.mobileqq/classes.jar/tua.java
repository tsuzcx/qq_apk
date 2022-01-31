import android.support.annotation.NonNull;
import android.text.TextUtils;

public class tua
  extends sgl<ttr, snl>
{
  public tua(ttr paramttr)
  {
    super(paramttr);
  }
  
  public void a(@NonNull ttr paramttr, @NonNull snl paramsnl)
  {
    if ((paramttr.a != null) && (TextUtils.equals(paramttr.a.b, paramsnl.a)))
    {
      urk.a(this.TAG, "receive feed info change event. %s.", paramsnl.toString());
      paramttr.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull ttr paramttr, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tua
 * JD-Core Version:    0.7.0.1
 */