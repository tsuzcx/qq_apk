import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wuf
  extends QQUIEventReceiver<wtu, wue>
{
  public wuf(@NonNull wtu paramwtu)
  {
    super(paramwtu);
  }
  
  public void a(@NonNull wtu paramwtu, @NonNull wue paramwue)
  {
    wtu.a(paramwtu, paramwue.jdField_a_of_type_Xix, paramwue.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return wue.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuf
 * JD-Core Version:    0.7.0.1
 */