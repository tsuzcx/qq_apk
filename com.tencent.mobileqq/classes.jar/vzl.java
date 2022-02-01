import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vzl
  extends QQUIEventReceiver<vzf, wrl>
{
  public vzl(@NonNull vzf paramvzf)
  {
    super(paramvzf);
  }
  
  public void a(@NonNull vzf paramvzf, @NonNull wrl paramwrl)
  {
    if ((paramvzf.a.a().equals(paramwrl.jdField_a_of_type_JavaLangString)) && ((paramwrl.jdField_a_of_type_Wod instanceof wor))) {
      paramvzf.a(((wor)paramwrl.jdField_a_of_type_Wod).a(), paramwrl.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return wrl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzl
 * JD-Core Version:    0.7.0.1
 */