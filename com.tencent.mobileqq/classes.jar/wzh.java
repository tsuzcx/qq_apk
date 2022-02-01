import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class wzh
  extends vll<wyy, wbw>
{
  public wzh(wyy paramwyy)
  {
    super(paramwyy);
  }
  
  public void a(@NonNull wyy paramwyy, @NonNull wbw paramwbw)
  {
    if ((paramwyy.a != null) && (paramwbw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwbw.jdField_a_of_type_JavaUtilList.contains(paramwyy.a.a)))
    {
      xvv.a(this.TAG, "receive tag info change event. %s", paramwbw.toString());
      paramwyy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wbw.class;
  }
  
  public void b(@NonNull wyy paramwyy, @NonNull wbw paramwbw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzh
 * JD-Core Version:    0.7.0.1
 */