import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xzo
  extends wjm<xzm, xag>
{
  public xzo(xzm paramxzm)
  {
    super(paramxzm);
  }
  
  public void a(@NonNull xzm paramxzm, @NonNull xag paramxag)
  {
    if ((xzm.a(paramxzm) != null) && (paramxag.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxag.jdField_a_of_type_JavaUtilList.contains(xzm.a(paramxzm).a)))
    {
      yuk.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramxag.b.toString());
      paramxzm.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xag.class;
  }
  
  public void b(@NonNull xzm paramxzm, @NonNull xag paramxag) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzo
 * JD-Core Version:    0.7.0.1
 */