import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ugw
  extends sth<ugn, tah>
{
  public ugw(ugn paramugn)
  {
    super(paramugn);
  }
  
  public void a(@NonNull ugn paramugn, @NonNull tah paramtah)
  {
    if ((paramugn.a != null) && (TextUtils.equals(paramugn.a.b, paramtah.a)))
    {
      veg.a(this.TAG, "receive feed info change event. %s.", paramtah.toString());
      paramugn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tah.class;
  }
  
  public void b(@NonNull ugn paramugn, @NonNull tah paramtah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugw
 * JD-Core Version:    0.7.0.1
 */