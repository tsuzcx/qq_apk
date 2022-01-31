import android.support.annotation.NonNull;
import android.text.TextUtils;

public class vwe
  extends uhw<vvy, uow>
{
  public vwe(vvy paramvvy)
  {
    super(paramvvy);
  }
  
  public void a(@NonNull vvy paramvvy, @NonNull uow paramuow)
  {
    if ((paramvvy.a != null) && (TextUtils.equals(paramvvy.a.b, paramuow.a)))
    {
      wsv.a(this.TAG, "receive feed info change event. %s.", paramuow.toString());
      paramvvy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull vvy paramvvy, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwe
 * JD-Core Version:    0.7.0.1
 */