import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class zjw
  extends yid<yiy>
{
  public zjw(@Nullable yih paramyih)
  {
    super(paramyih);
  }
  
  protected JobSegment<yig, yiy> a()
  {
    return new yit();
  }
  
  protected JobSegment<Integer, yig> a(yif paramyif)
  {
    return new zjx(paramyif);
  }
  
  protected yiy a()
  {
    yij localyij = (yij)wpm.a(11);
    List localList = localyij.b();
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
    ((yij)wpm.a(11)).b(paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjw
 * JD-Core Version:    0.7.0.1
 */