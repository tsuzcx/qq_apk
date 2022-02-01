import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xyq
  extends wjm<xyd, wqm>
{
  public xyq(xyd paramxyd)
  {
    super(paramxyd);
  }
  
  public void a(@NonNull xyd paramxyd, @NonNull wqm paramwqm)
  {
    if ((paramxyd.a != null) && (TextUtils.equals(paramxyd.a.b, paramwqm.a)))
    {
      yuk.a(this.TAG, "receive feed info change event. %s.", paramwqm.toString());
      paramxyd.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wqm.class;
  }
  
  public void b(@NonNull xyd paramxyd, @NonNull wqm paramwqm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyq
 * JD-Core Version:    0.7.0.1
 */