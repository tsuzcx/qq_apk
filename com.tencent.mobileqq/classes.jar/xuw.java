import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xuw
  extends QQUIEventReceiver<xuh, vuc>
{
  public xuw(@NonNull xuh paramxuh)
  {
    super(paramxuh);
  }
  
  public void a(@NonNull xuh paramxuh, @NonNull vuc paramvuc)
  {
    if (paramvuc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      xvv.d(this.TAG, "deleted story failed");
      paramxuh.a(5, paramvuc.jdField_a_of_type_JavaLangString);
      return;
    }
    paramxuh.a(paramvuc.jdField_a_of_type_JavaLangString);
    paramxuh.a(new xrq[] { new xrl(xqt.a(xuh.a(paramxuh).a.jdField_a_of_type_JavaLangString)), (xrq)paramxuh.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return vuc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuw
 * JD-Core Version:    0.7.0.1
 */