import android.support.annotation.NonNull;
import android.text.TextUtils;

public class xxt
  extends wjm<xxn, wqm>
{
  public xxt(xxn paramxxn)
  {
    super(paramxxn);
  }
  
  public void a(@NonNull xxn paramxxn, @NonNull wqm paramwqm)
  {
    if ((paramxxn.a != null) && (TextUtils.equals(paramxxn.a.b, paramwqm.a)))
    {
      yuk.a(this.TAG, "receive feed info change event. %s.", paramwqm.toString());
      paramxxn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wqm.class;
  }
  
  public void b(@NonNull xxn paramxxn, @NonNull wqm paramwqm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxt
 * JD-Core Version:    0.7.0.1
 */