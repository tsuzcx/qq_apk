import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xxa
  extends wjm<xwr, wqm>
{
  public xxa(xwr paramxwr)
  {
    super(paramxwr);
  }
  
  public void a(@NonNull xwr paramxwr, @NonNull wqm paramwqm)
  {
    if ((paramxwr.a != null) && (TextUtils.equals(paramxwr.a.b, paramwqm.a)))
    {
      yuk.a(this.TAG, "receive feed info change event. %s.", paramwqm.toString());
      paramxwr.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wqm.class;
  }
  
  public void b(@NonNull xwr paramxwr, @NonNull wqm paramwqm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxa
 * JD-Core Version:    0.7.0.1
 */