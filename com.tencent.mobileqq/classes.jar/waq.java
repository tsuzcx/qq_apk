import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class waq
  extends umf<wah, vcz>
{
  public waq(wah paramwah)
  {
    super(paramwah);
  }
  
  public void a(@NonNull wah paramwah, @NonNull vcz paramvcz)
  {
    if ((paramwah.a != null) && (paramvcz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvcz.jdField_a_of_type_JavaUtilList.contains(paramwah.a.a)))
    {
      wxe.a(this.TAG, "receive tag info change event. %s", paramvcz.toString());
      paramwah.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return vcz.class;
  }
  
  public void b(@NonNull wah paramwah, @NonNull vcz paramvcz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */