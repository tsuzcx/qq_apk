import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wuw
  extends QQUIEventReceiver<wub, vsu>
{
  public wuw(@NonNull wub paramwub)
  {
    super(paramwub);
  }
  
  public void a(@NonNull wub paramwub, @NonNull vsu paramvsu)
  {
    wxe.a(this.TAG, "play video groupId=%s, %s", paramvsu.jdField_a_of_type_Vpm, paramvsu.b);
    if ((wub.a(paramwub).equals(paramvsu.jdField_a_of_type_JavaLangString)) && ((paramvsu.jdField_a_of_type_Vpm instanceof vpb)))
    {
      woq localwoq = ((vpb)paramvsu.jdField_a_of_type_Vpm).a;
      if (localwoq != null) {
        paramwub.a(localwoq.jdField_a_of_type_JavaLangString, paramvsu.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vsu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuw
 * JD-Core Version:    0.7.0.1
 */