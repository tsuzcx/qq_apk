import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class thn
  extends QQUIEventReceiver<thh, tzt>
{
  public thn(@NonNull thh paramthh)
  {
    super(paramthh);
  }
  
  public void a(@NonNull thh paramthh, @NonNull tzt paramtzt)
  {
    if ((paramthh.a.a().equals(paramtzt.jdField_a_of_type_JavaLangString)) && ((paramtzt.jdField_a_of_type_Twl instanceof twz))) {
      paramthh.a(((twz)paramtzt.jdField_a_of_type_Twl).a(), paramtzt.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return tzt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thn
 * JD-Core Version:    0.7.0.1
 */