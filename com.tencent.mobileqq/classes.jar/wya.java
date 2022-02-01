import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wya
  extends QQUIEventReceiver<wxp, wxz>
{
  public wya(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull wxz paramwxz)
  {
    wxp.a(paramwxp, paramwxz.jdField_a_of_type_Xms, paramwxz.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return wxz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wya
 * JD-Core Version:    0.7.0.1
 */