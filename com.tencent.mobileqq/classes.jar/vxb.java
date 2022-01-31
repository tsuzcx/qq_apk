import android.support.annotation.NonNull;
import android.text.TextUtils;

public class vxb
  extends uhw<vwo, uow>
{
  public vxb(vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull uow paramuow)
  {
    if ((paramvwo.a != null) && (TextUtils.equals(paramvwo.a.b, paramuow.a)))
    {
      wsv.a(this.TAG, "receive feed info change event. %s.", paramuow.toString());
      paramvwo.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull vwo paramvwo, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxb
 * JD-Core Version:    0.7.0.1
 */