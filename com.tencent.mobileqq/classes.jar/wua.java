import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wua
  extends QQUIEventReceiver<wtu, xmf>
{
  public wua(@NonNull wtu paramwtu)
  {
    super(paramwtu);
  }
  
  public void a(@NonNull wtu paramwtu, @NonNull xmf paramxmf)
  {
    if ((paramwtu.a.a().equals(paramxmf.jdField_a_of_type_JavaLangString)) && ((paramxmf.jdField_a_of_type_Xix instanceof xjl))) {
      paramwtu.a(((xjl)paramxmf.jdField_a_of_type_Xix).a(), paramxmf.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return xmf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wua
 * JD-Core Version:    0.7.0.1
 */