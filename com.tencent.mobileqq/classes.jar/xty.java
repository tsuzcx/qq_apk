import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xty
  extends wfr<xts, wmr>
{
  public xty(xts paramxts)
  {
    super(paramxts);
  }
  
  public void a(@NonNull xts paramxts, @NonNull wmr paramwmr)
  {
    if ((paramxts.a != null) && (TextUtils.equals(paramxts.a.b, paramwmr.a)))
    {
      yqp.a(this.TAG, "receive feed info change event. %s.", paramwmr.toString());
      paramxts.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wmr.class;
  }
  
  public void b(@NonNull xts paramxts, @NonNull wmr paramwmr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xty
 * JD-Core Version:    0.7.0.1
 */