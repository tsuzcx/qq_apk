import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class ujh
  extends ste<ujf, tjy>
{
  public ujh(ujf paramujf)
  {
    super(paramujf);
  }
  
  public void a(@NonNull ujf paramujf, @NonNull tjy paramtjy)
  {
    if ((ujf.a(paramujf) != null) && (paramtjy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjy.jdField_a_of_type_JavaUtilList.contains(ujf.a(paramujf).a)))
    {
      ved.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramtjy.b.toString());
      paramujf.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tjy.class;
  }
  
  public void b(@NonNull ujf paramujf, @NonNull tjy paramtjy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujh
 * JD-Core Version:    0.7.0.1
 */