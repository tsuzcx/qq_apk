import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wqn
  extends QQUIEventReceiver<wps, vol>
{
  public wqn(@NonNull wps paramwps)
  {
    super(paramwps);
  }
  
  public void a(@NonNull wps paramwps, @NonNull vol paramvol)
  {
    wsv.a(this.TAG, "play video groupId=%s, %s", paramvol.jdField_a_of_type_Vld, paramvol.b);
    if ((wps.a(paramwps).equals(paramvol.jdField_a_of_type_JavaLangString)) && ((paramvol.jdField_a_of_type_Vld instanceof vks)))
    {
      wkh localwkh = ((vks)paramvol.jdField_a_of_type_Vld).a;
      if (localwkh != null) {
        paramwps.a(localwkh.jdField_a_of_type_JavaLangString, paramvol.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vol.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */