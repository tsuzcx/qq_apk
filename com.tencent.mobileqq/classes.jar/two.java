import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class two
  extends sgl<twm, sxf>
{
  public two(twm paramtwm)
  {
    super(paramtwm);
  }
  
  public void a(@NonNull twm paramtwm, @NonNull sxf paramsxf)
  {
    if ((twm.a(paramtwm) != null) && (paramsxf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxf.jdField_a_of_type_JavaUtilList.contains(twm.a(paramtwm).a)))
    {
      urk.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramsxf.b.toString());
      paramtwm.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxf.class;
  }
  
  public void b(@NonNull twm paramtwm, @NonNull sxf paramsxf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     two
 * JD-Core Version:    0.7.0.1
 */