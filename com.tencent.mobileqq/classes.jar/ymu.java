import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class ymu
  extends yly<ymt>
{
  public ymu(@Nullable ymc paramymc)
  {
    super(paramymc);
  }
  
  protected JobSegment<ymb, ymt> a()
  {
    return new ymo();
  }
  
  protected JobSegment<Integer, ymb> a(yma paramyma)
  {
    return new ymv(paramyma, this.a);
  }
  
  protected ymt a()
  {
    yme localyme = (yme)wth.a(11);
    List localList = localyme.a();
    ymt localymt = new ymt(new ErrorMessage());
    localymt.jdField_b_of_type_JavaUtilList = localyme.b(localList);
    localymt.jdField_b_of_type_Boolean = true;
    localymt.a = localymt.jdField_b_of_type_JavaUtilList.isEmpty();
    return localymt;
  }
  
  protected ymt a(ErrorMessage paramErrorMessage)
  {
    return new ymt(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((yme)wth.a(11)).a(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymu
 * JD-Core Version:    0.7.0.1
 */