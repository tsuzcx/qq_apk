import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xpu
  extends wag<xps, wqr>
{
  public xpu(xps paramxps)
  {
    super(paramxps);
  }
  
  public void a(@NonNull xps paramxps, @NonNull wqr paramwqr)
  {
    if ((xps.a(paramxps) != null) && (paramwqr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqr.jdField_a_of_type_JavaUtilList.contains(xps.a(paramxps).a)))
    {
      ykq.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramwqr.b.toString());
      paramxps.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wqr.class;
  }
  
  public void b(@NonNull xps paramxps, @NonNull wqr paramwqr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpu
 * JD-Core Version:    0.7.0.1
 */