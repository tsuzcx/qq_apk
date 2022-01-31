import android.support.annotation.NonNull;
import android.text.TextUtils;

public class uim
  extends sth<uhz, tah>
{
  public uim(uhz paramuhz)
  {
    super(paramuhz);
  }
  
  public void a(@NonNull uhz paramuhz, @NonNull tah paramtah)
  {
    if ((paramuhz.a != null) && (TextUtils.equals(paramuhz.a.b, paramtah.a)))
    {
      veg.a(this.TAG, "receive feed info change event. %s.", paramtah.toString());
      paramuhz.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tah.class;
  }
  
  public void b(@NonNull uhz paramuhz, @NonNull tah paramtah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uim
 * JD-Core Version:    0.7.0.1
 */