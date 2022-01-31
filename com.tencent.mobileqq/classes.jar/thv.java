import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class thv
  extends QQUIEventReceiver<thk, thu>
{
  public thv(@NonNull thk paramthk)
  {
    super(paramthk);
  }
  
  public void a(@NonNull thk paramthk, @NonNull thu paramthu)
  {
    thk.a(paramthk, paramthu.jdField_a_of_type_Two, paramthu.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return thu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thv
 * JD-Core Version:    0.7.0.1
 */