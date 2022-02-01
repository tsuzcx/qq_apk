import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xoc
  extends wag<xnt, wqr>
{
  public xoc(xnt paramxnt)
  {
    super(paramxnt);
  }
  
  public void a(@NonNull xnt paramxnt, @NonNull wqr paramwqr)
  {
    if ((paramxnt.a != null) && (paramwqr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqr.jdField_a_of_type_JavaUtilList.contains(paramxnt.a.a)))
    {
      ykq.a(this.TAG, "receive tag info change event. %s", paramwqr.toString());
      paramxnt.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wqr.class;
  }
  
  public void b(@NonNull xnt paramxnt, @NonNull wqr paramwqr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoc
 * JD-Core Version:    0.7.0.1
 */