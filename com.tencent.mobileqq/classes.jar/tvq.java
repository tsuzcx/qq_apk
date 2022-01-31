import android.support.annotation.NonNull;
import android.text.TextUtils;

public class tvq
  extends sgl<tvd, snl>
{
  public tvq(tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull snl paramsnl)
  {
    if ((paramtvd.a != null) && (TextUtils.equals(paramtvd.a.b, paramsnl.a)))
    {
      urk.a(this.TAG, "receive feed info change event. %s.", paramsnl.toString());
      paramtvd.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return snl.class;
  }
  
  public void b(@NonNull tvd paramtvd, @NonNull snl paramsnl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvq
 * JD-Core Version:    0.7.0.1
 */