import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xxk
  extends wjm<xxj, xag>
{
  public xxk(xxj paramxxj)
  {
    super(paramxxj);
  }
  
  public void a(@NonNull xxj paramxxj, @NonNull xag paramxag)
  {
    if ((xxj.a(paramxxj) != null) && (paramxag.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxag.jdField_a_of_type_JavaUtilList.contains(xxj.a(paramxxj).a)))
    {
      yuk.a("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", paramxag.b.toString());
      paramxxj.a.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xag.class;
  }
  
  public void b(@NonNull xxj paramxxj, @NonNull xag paramxag) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxk
 * JD-Core Version:    0.7.0.1
 */