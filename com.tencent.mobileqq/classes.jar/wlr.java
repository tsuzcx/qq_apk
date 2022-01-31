import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class wlr
  extends wos<wpn>
{
  public wlr(@Nullable wow paramwow)
  {
    super(paramwow);
  }
  
  protected JobSegment<wov, wpn> a()
  {
    return new wpi();
  }
  
  protected JobSegment<Integer, wov> a(wou paramwou)
  {
    return new wls(paramwou);
  }
  
  protected wpn a()
  {
    woy localwoy = (woy)uwa.a(11);
    List localList = localwoy.c();
    wpn localwpn = new wpn(new ErrorMessage());
    localwpn.jdField_b_of_type_JavaUtilList = localwoy.b(localList);
    localwpn.jdField_b_of_type_Boolean = true;
    localwpn.a = localwpn.jdField_b_of_type_JavaUtilList.isEmpty();
    return localwpn;
  }
  
  protected wpn a(ErrorMessage paramErrorMessage)
  {
    return new wpn(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((woy)uwa.a(11)).c(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlr
 * JD-Core Version:    0.7.0.1
 */