import android.support.annotation.NonNull;
import android.text.TextUtils;

public class uhp
  extends sth<uhj, tah>
{
  public uhp(uhj paramuhj)
  {
    super(paramuhj);
  }
  
  public void a(@NonNull uhj paramuhj, @NonNull tah paramtah)
  {
    if ((paramuhj.a != null) && (TextUtils.equals(paramuhj.a.b, paramtah.a)))
    {
      veg.a(this.TAG, "receive feed info change event. %s.", paramtah.toString());
      paramuhj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tah.class;
  }
  
  public void b(@NonNull uhj paramuhj, @NonNull tah paramtah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */