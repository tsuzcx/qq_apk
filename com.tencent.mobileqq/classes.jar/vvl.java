import android.support.annotation.NonNull;
import android.text.TextUtils;

public class vvl
  extends uhw<vvc, uow>
{
  public vvl(vvc paramvvc)
  {
    super(paramvvc);
  }
  
  public void a(@NonNull vvc paramvvc, @NonNull uow paramuow)
  {
    if ((paramvvc.a != null) && (TextUtils.equals(paramvvc.a.b, paramuow.a)))
    {
      wsv.a(this.TAG, "receive feed info change event. %s.", paramuow.toString());
      paramvvc.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
  
  public void b(@NonNull vvc paramvvc, @NonNull uow paramuow) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvl
 * JD-Core Version:    0.7.0.1
 */