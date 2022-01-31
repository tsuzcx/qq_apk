import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class thq
  extends QQUIEventReceiver<thk, tzw>
{
  public thq(@NonNull thk paramthk)
  {
    super(paramthk);
  }
  
  public void a(@NonNull thk paramthk, @NonNull tzw paramtzw)
  {
    if ((paramthk.a.a().equals(paramtzw.jdField_a_of_type_JavaLangString)) && ((paramtzw.jdField_a_of_type_Two instanceof txc))) {
      paramthk.a(((txc)paramtzw.jdField_a_of_type_Two).a(), paramtzw.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return tzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thq
 * JD-Core Version:    0.7.0.1
 */