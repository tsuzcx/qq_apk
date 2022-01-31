import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class ufx
  extends uiy<ujt>
{
  public ufx(@Nullable ujc paramujc)
  {
    super(paramujc);
  }
  
  protected JobSegment<ujb, ujt> a()
  {
    return new ujo();
  }
  
  protected JobSegment<Integer, ujb> a(uja paramuja)
  {
    return new ufy(paramuja);
  }
  
  protected ujt a()
  {
    uje localuje = (uje)sqg.a(11);
    List localList = localuje.c();
    ujt localujt = new ujt(new ErrorMessage());
    localujt.jdField_b_of_type_JavaUtilList = localuje.b(localList);
    localujt.jdField_b_of_type_Boolean = true;
    localujt.a = localujt.jdField_b_of_type_JavaUtilList.isEmpty();
    return localujt;
  }
  
  protected ujt a(ErrorMessage paramErrorMessage)
  {
    return new ujt(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((uje)sqg.a(11)).c(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufx
 * JD-Core Version:    0.7.0.1
 */