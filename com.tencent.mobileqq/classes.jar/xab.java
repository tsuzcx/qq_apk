import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xab
  extends vll<wzo, vsd>
{
  public xab(wzo paramwzo)
  {
    super(paramwzo);
  }
  
  public void a(@NonNull wzo paramwzo, @NonNull vsd paramvsd)
  {
    if ((paramwzo.a != null) && (TextUtils.equals(paramwzo.a.b, paramvsd.a)))
    {
      xvv.a(this.TAG, "receive feed info change event. %s.", paramvsd.toString());
      paramwzo.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vsd.class;
  }
  
  public void b(@NonNull wzo paramwzo, @NonNull vsd paramvsd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xab
 * JD-Core Version:    0.7.0.1
 */