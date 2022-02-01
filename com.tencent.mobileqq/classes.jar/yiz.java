import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class yiz
  extends yid<yiy>
{
  public yiz(@Nullable yih paramyih)
  {
    super(paramyih);
  }
  
  protected JobSegment<yig, yiy> a()
  {
    return new yit();
  }
  
  protected JobSegment<Integer, yig> a(yif paramyif)
  {
    return new yja(paramyif, this.a);
  }
  
  protected yiy a()
  {
    yij localyij = (yij)wpm.a(11);
    List localList = localyij.a();
    yiy localyiy = new yiy(new ErrorMessage());
    localyiy.jdField_b_of_type_JavaUtilList = localyij.b(localList);
    localyiy.jdField_b_of_type_Boolean = true;
    localyiy.a = localyiy.jdField_b_of_type_JavaUtilList.isEmpty();
    return localyiy;
  }
  
  protected yiy a(ErrorMessage paramErrorMessage)
  {
    return new yiy(paramErrorMessage);
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    ((yij)wpm.a(11)).a(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiz
 * JD-Core Version:    0.7.0.1
 */