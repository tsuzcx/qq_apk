import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class vxz
  extends uhw<vxx, uyq>
{
  public vxz(vxx paramvxx)
  {
    super(paramvxx);
  }
  
  public void a(@NonNull vxx paramvxx, @NonNull uyq paramuyq)
  {
    if ((vxx.a(paramvxx) != null) && (paramuyq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyq.jdField_a_of_type_JavaUtilList.contains(vxx.a(paramvxx).a)))
    {
      wsv.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramuyq.b.toString());
      paramvxx.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uyq.class;
  }
  
  public void b(@NonNull vxx paramvxx, @NonNull uyq paramuyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxz
 * JD-Core Version:    0.7.0.1
 */