import android.support.annotation.NonNull;
import android.text.TextUtils;

public class uhm
  extends ste<uhg, tae>
{
  public uhm(uhg paramuhg)
  {
    super(paramuhg);
  }
  
  public void a(@NonNull uhg paramuhg, @NonNull tae paramtae)
  {
    if ((paramuhg.a != null) && (TextUtils.equals(paramuhg.a.b, paramtae.a)))
    {
      ved.a(this.TAG, "receive feed info change event. %s.", paramtae.toString());
      paramuhg.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tae.class;
  }
  
  public void b(@NonNull uhg paramuhg, @NonNull tae paramtae) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhm
 * JD-Core Version:    0.7.0.1
 */