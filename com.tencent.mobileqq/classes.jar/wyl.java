import android.support.annotation.NonNull;
import android.text.TextUtils;

public class wyl
  extends vll<wyc, vsd>
{
  public wyl(wyc paramwyc)
  {
    super(paramwyc);
  }
  
  public void a(@NonNull wyc paramwyc, @NonNull vsd paramvsd)
  {
    if ((paramwyc.a != null) && (TextUtils.equals(paramwyc.a.b, paramvsd.a)))
    {
      xvv.a(this.TAG, "receive feed info change event. %s.", paramvsd.toString());
      paramwyc.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vsd.class;
  }
  
  public void b(@NonNull wyc paramwyc, @NonNull vsd paramvsd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyl
 * JD-Core Version:    0.7.0.1
 */