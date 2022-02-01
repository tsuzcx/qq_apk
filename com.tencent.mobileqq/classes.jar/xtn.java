import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xtn
  extends QQUIEventReceiver<xss, wrl>
{
  public xtn(@NonNull xss paramxss)
  {
    super(paramxss);
  }
  
  public void a(@NonNull xss paramxss, @NonNull wrl paramwrl)
  {
    xvv.a(this.TAG, "play video groupId=%s, %s", paramwrl.jdField_a_of_type_Wod, paramwrl.b);
    if ((xss.a(paramxss).equals(paramwrl.jdField_a_of_type_JavaLangString)) && ((paramwrl.jdField_a_of_type_Wod instanceof wns)))
    {
      xnh localxnh = ((wns)paramwrl.jdField_a_of_type_Wod).a;
      if (localxnh != null) {
        paramxss.a(localxnh.jdField_a_of_type_JavaLangString, paramwrl.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wrl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtn
 * JD-Core Version:    0.7.0.1
 */