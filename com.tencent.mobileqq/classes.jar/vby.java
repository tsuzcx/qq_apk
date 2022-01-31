import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vby
  extends QQUIEventReceiver<vbd, tzw>
{
  public vby(@NonNull vbd paramvbd)
  {
    super(paramvbd);
  }
  
  public void a(@NonNull vbd paramvbd, @NonNull tzw paramtzw)
  {
    veg.a(this.TAG, "play video groupId=%s, %s", paramtzw.jdField_a_of_type_Two, paramtzw.b);
    if ((vbd.a(paramvbd).equals(paramtzw.jdField_a_of_type_JavaLangString)) && ((paramtzw.jdField_a_of_type_Two instanceof twd)))
    {
      uvs localuvs = ((twd)paramtzw.jdField_a_of_type_Two).a;
      if (localuvs != null) {
        paramvbd.a(localuvs.jdField_a_of_type_JavaLangString, paramtzw.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vby
 * JD-Core Version:    0.7.0.1
 */