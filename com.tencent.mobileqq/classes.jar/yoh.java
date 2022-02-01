import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yoh
  extends QQUIEventReceiver<ynm, xmf>
{
  public yoh(@NonNull ynm paramynm)
  {
    super(paramynm);
  }
  
  public void a(@NonNull ynm paramynm, @NonNull xmf paramxmf)
  {
    yqp.a(this.TAG, "play video groupId=%s, %s", paramxmf.jdField_a_of_type_Xix, paramxmf.b);
    if ((ynm.a(paramynm).equals(paramxmf.jdField_a_of_type_JavaLangString)) && ((paramxmf.jdField_a_of_type_Xix instanceof xim)))
    {
      yib localyib = ((xim)paramxmf.jdField_a_of_type_Xix).a;
      if (localyib != null) {
        paramynm.a(localyib.jdField_a_of_type_JavaLangString, paramxmf.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xmf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoh
 * JD-Core Version:    0.7.0.1
 */