import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class xzd
  extends yce<ycz>
{
  public xzd(@Nullable yci paramyci)
  {
    super(paramyci);
  }
  
  protected JobSegment<ych, ycz> a()
  {
    return new ycu();
  }
  
  protected JobSegment<Integer, ych> a(ycg paramycg)
  {
    return new xze(paramycg);
  }
  
  protected ycz a()
  {
    yck localyck = (yck)wjs.a(11);
    List localList = localyck.c();
    ycz localycz = new ycz(new ErrorMessage());
    localycz.jdField_b_of_type_JavaUtilList = localyck.b(localList);
    localycz.jdField_b_of_type_Boolean = true;
    localycz.a = localycz.jdField_b_of_type_JavaUtilList.isEmpty();
    return localycz;
  }
  
  protected ycz a(ErrorMessage paramErrorMessage)
  {
    return new ycz(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((yck)wjs.a(11)).c(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzd
 * JD-Core Version:    0.7.0.1
 */