import android.support.annotation.NonNull;
import android.text.TextUtils;

public class uij
  extends ste<uhw, tae>
{
  public uij(uhw paramuhw)
  {
    super(paramuhw);
  }
  
  public void a(@NonNull uhw paramuhw, @NonNull tae paramtae)
  {
    if ((paramuhw.a != null) && (TextUtils.equals(paramuhw.a.b, paramtae.a)))
    {
      ved.a(this.TAG, "receive feed info change event. %s.", paramtae.toString());
      paramuhw.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull uhw paramuhw, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uij
 * JD-Core Version:    0.7.0.1
 */