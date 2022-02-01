import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xub
  extends wfr<xts, wwl>
{
  public xub(xts paramxts)
  {
    super(paramxts);
  }
  
  public void a(@NonNull xts paramxts, @NonNull wwl paramwwl)
  {
    if ((paramxts.a != null) && (paramwwl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwl.jdField_a_of_type_JavaUtilList.contains(paramxts.a.a)))
    {
      yqp.a(this.TAG, "receive tag info change event. %s", paramwwl.toString());
      paramxts.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwl.class;
  }
  
  public void b(@NonNull xts paramxts, @NonNull wwl paramwwl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xub
 * JD-Core Version:    0.7.0.1
 */