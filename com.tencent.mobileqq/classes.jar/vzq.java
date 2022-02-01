import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vzq
  extends QQUIEventReceiver<vzf, vzp>
{
  public vzq(@NonNull vzf paramvzf)
  {
    super(paramvzf);
  }
  
  public void a(@NonNull vzf paramvzf, @NonNull vzp paramvzp)
  {
    vzf.a(paramvzf, paramvzp.jdField_a_of_type_Wod, paramvzp.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return vzp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzq
 * JD-Core Version:    0.7.0.1
 */