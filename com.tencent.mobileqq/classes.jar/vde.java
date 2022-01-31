import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vde
  extends QQUIEventReceiver<vcp, tce>
{
  public vde(@NonNull vcp paramvcp)
  {
    super(paramvcp);
  }
  
  public void a(@NonNull vcp paramvcp, @NonNull tce paramtce)
  {
    if (paramtce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      ved.d(this.TAG, "deleted story failed");
      paramvcp.a(5, paramtce.jdField_a_of_type_JavaLangString);
      return;
    }
    paramvcp.a(paramtce.jdField_a_of_type_JavaLangString);
    paramvcp.a(new uzy[] { new uzt(uzb.a(vcp.a(paramvcp).a.jdField_a_of_type_JavaLangString)), (uzy)paramvcp.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return tce.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */