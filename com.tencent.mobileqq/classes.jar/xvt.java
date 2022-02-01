import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xvt
  extends wfr<xvr, wwl>
{
  public xvt(xvr paramxvr)
  {
    super(paramxvr);
  }
  
  public void a(@NonNull xvr paramxvr, @NonNull wwl paramwwl)
  {
    if ((xvr.a(paramxvr) != null) && (paramwwl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwl.jdField_a_of_type_JavaUtilList.contains(xvr.a(paramxvr).a)))
    {
      yqp.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramwwl.b.toString());
      paramxvr.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwl.class;
  }
  
  public void b(@NonNull xvr paramxvr, @NonNull wwl paramwwl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvt
 * JD-Core Version:    0.7.0.1
 */