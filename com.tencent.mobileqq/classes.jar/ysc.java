import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ysc
  extends QQUIEventReceiver<yrh, xqa>
{
  public ysc(@NonNull yrh paramyrh)
  {
    super(paramyrh);
  }
  
  public void a(@NonNull yrh paramyrh, @NonNull xqa paramxqa)
  {
    yuk.a(this.TAG, "play video groupId=%s, %s", paramxqa.jdField_a_of_type_Xms, paramxqa.b);
    if ((yrh.a(paramyrh).equals(paramxqa.jdField_a_of_type_JavaLangString)) && ((paramxqa.jdField_a_of_type_Xms instanceof xmh)))
    {
      ylw localylw = ((xmh)paramxqa.jdField_a_of_type_Xms).a;
      if (localylw != null) {
        paramyrh.a(localylw.jdField_a_of_type_JavaLangString, paramxqa.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xqa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysc
 * JD-Core Version:    0.7.0.1
 */