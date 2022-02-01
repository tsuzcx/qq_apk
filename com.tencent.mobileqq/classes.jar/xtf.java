import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xtf
  extends wfr<xsw, wmr>
{
  public xtf(xsw paramxsw)
  {
    super(paramxsw);
  }
  
  public void a(@NonNull xsw paramxsw, @NonNull wmr paramwmr)
  {
    if ((paramxsw.a != null) && (TextUtils.equals(paramxsw.a.b, paramwmr.a)))
    {
      yqp.a(this.TAG, "receive feed info change event. %s.", paramwmr.toString());
      paramxsw.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wmr.class;
  }
  
  public void b(@NonNull xsw paramxsw, @NonNull wmr paramwmr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtf
 * JD-Core Version:    0.7.0.1
 */