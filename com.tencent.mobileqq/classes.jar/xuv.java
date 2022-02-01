import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xuv
  extends wfr<xui, wmr>
{
  public xuv(xui paramxui)
  {
    super(paramxui);
  }
  
  public void a(@NonNull xui paramxui, @NonNull wmr paramwmr)
  {
    if ((paramxui.a != null) && (TextUtils.equals(paramxui.a.b, paramwmr.a)))
    {
      yqp.a(this.TAG, "receive feed info change event. %s.", paramwmr.toString());
      paramxui.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wmr.class;
  }
  
  public void b(@NonNull xui paramxui, @NonNull wmr paramwmr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuv
 * JD-Core Version:    0.7.0.1
 */