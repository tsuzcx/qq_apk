import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xxw
  extends wjm<xxn, xag>
{
  public xxw(xxn paramxxn)
  {
    super(paramxxn);
  }
  
  public void a(@NonNull xxn paramxxn, @NonNull xag paramxag)
  {
    if ((paramxxn.a != null) && (paramxag.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxag.jdField_a_of_type_JavaUtilList.contains(paramxxn.a.a)))
    {
      yuk.a(this.TAG, "receive tag info change event. %s", paramxag.toString());
      paramxxn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xag.class;
  }
  
  public void b(@NonNull xxn paramxxn, @NonNull xag paramxag) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxw
 * JD-Core Version:    0.7.0.1
 */