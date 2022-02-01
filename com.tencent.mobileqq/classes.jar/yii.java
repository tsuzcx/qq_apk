import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yii
  extends QQUIEventReceiver<yhn, xgg>
{
  public yii(@NonNull yhn paramyhn)
  {
    super(paramyhn);
  }
  
  public void a(@NonNull yhn paramyhn, @NonNull xgg paramxgg)
  {
    ykq.a(this.TAG, "play video groupId=%s, %s", paramxgg.jdField_a_of_type_Xcy, paramxgg.b);
    if ((yhn.a(paramyhn).equals(paramxgg.jdField_a_of_type_JavaLangString)) && ((paramxgg.jdField_a_of_type_Xcy instanceof xcn)))
    {
      ycc localycc = ((xcn)paramxgg.jdField_a_of_type_Xcy).a;
      if (localycc != null) {
        paramyhn.a(localycc.jdField_a_of_type_JavaLangString, paramxgg.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xgg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yii
 * JD-Core Version:    0.7.0.1
 */