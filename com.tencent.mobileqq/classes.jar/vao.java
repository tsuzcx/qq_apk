import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vao
  extends QQUIEventReceiver<vai, vsu>
{
  public vao(@NonNull vai paramvai)
  {
    super(paramvai);
  }
  
  public void a(@NonNull vai paramvai, @NonNull vsu paramvsu)
  {
    if ((paramvai.a.a().equals(paramvsu.jdField_a_of_type_JavaLangString)) && ((paramvsu.jdField_a_of_type_Vpm instanceof vqa))) {
      paramvai.a(((vqa)paramvsu.jdField_a_of_type_Vpm).a(), paramvsu.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return vsu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vao
 * JD-Core Version:    0.7.0.1
 */