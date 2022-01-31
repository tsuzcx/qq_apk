import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vdh
  extends QQUIEventReceiver<vcs, tch>
{
  public vdh(@NonNull vcs paramvcs)
  {
    super(paramvcs);
  }
  
  public void a(@NonNull vcs paramvcs, @NonNull tch paramtch)
  {
    if (paramtch.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      veg.d(this.TAG, "deleted story failed");
      paramvcs.a(5, paramtch.jdField_a_of_type_JavaLangString);
      return;
    }
    paramvcs.a(paramtch.jdField_a_of_type_JavaLangString);
    paramvcs.a(new vab[] { new uzw(uze.a(vcs.a(paramvcs).a.jdField_a_of_type_JavaLangString)), (vab)paramvcs.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return tch.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdh
 * JD-Core Version:    0.7.0.1
 */