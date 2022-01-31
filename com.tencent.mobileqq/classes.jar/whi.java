import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class whi
  extends wkj<wle>
{
  public whi(@Nullable wkn paramwkn)
  {
    super(paramwkn);
  }
  
  protected JobSegment<wkm, wle> a()
  {
    return new wkz();
  }
  
  protected JobSegment<Integer, wkm> a(wkl paramwkl)
  {
    return new whj(paramwkl);
  }
  
  protected wle a()
  {
    wkp localwkp = (wkp)urr.a(11);
    List localList = localwkp.c();
    wle localwle = new wle(new ErrorMessage());
    localwle.jdField_b_of_type_JavaUtilList = localwkp.b(localList);
    localwle.jdField_b_of_type_Boolean = true;
    localwle.a = localwle.jdField_b_of_type_JavaUtilList.isEmpty();
    return localwle;
  }
  
  protected wle a(ErrorMessage paramErrorMessage)
  {
    return new wle(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((wkp)urr.a(11)).c(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whi
 * JD-Core Version:    0.7.0.1
 */