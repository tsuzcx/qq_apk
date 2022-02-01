import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wxv
  extends QQUIEventReceiver<wxp, xqa>
{
  public wxv(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull xqa paramxqa)
  {
    if ((paramwxp.a.a().equals(paramxqa.jdField_a_of_type_JavaLangString)) && ((paramxqa.jdField_a_of_type_Xms instanceof xng))) {
      paramwxp.a(((xng)paramxqa.jdField_a_of_type_Xms).a(), paramxqa.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return xqa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxv
 * JD-Core Version:    0.7.0.1
 */