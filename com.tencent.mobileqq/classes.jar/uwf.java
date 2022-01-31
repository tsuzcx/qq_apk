import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uwf
  extends QQUIEventReceiver<uvz, vol>
{
  public uwf(@NonNull uvz paramuvz)
  {
    super(paramuvz);
  }
  
  public void a(@NonNull uvz paramuvz, @NonNull vol paramvol)
  {
    if ((paramuvz.a.a().equals(paramvol.jdField_a_of_type_JavaLangString)) && ((paramvol.jdField_a_of_type_Vld instanceof vlr))) {
      paramuvz.a(((vlr)paramvol.jdField_a_of_type_Vld).a(), paramvol.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return vol.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwf
 * JD-Core Version:    0.7.0.1
 */