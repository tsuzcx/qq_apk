import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class wci
  extends umf<wcg, vcz>
{
  public wci(wcg paramwcg)
  {
    super(paramwcg);
  }
  
  public void a(@NonNull wcg paramwcg, @NonNull vcz paramvcz)
  {
    if ((wcg.a(paramwcg) != null) && (paramvcz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvcz.jdField_a_of_type_JavaUtilList.contains(wcg.a(paramwcg).a)))
    {
      wxe.a("WeiShiFlowBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramvcz.b.toString());
      paramwcg.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vcz.class;
  }
  
  public void b(@NonNull wcg paramwcg, @NonNull vcz paramvcz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wci
 * JD-Core Version:    0.7.0.1
 */