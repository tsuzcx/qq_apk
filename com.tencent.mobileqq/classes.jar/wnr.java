import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wnr
  extends QQUIEventReceiver<wno, vsu>
{
  public wnr(@NonNull wno paramwno)
  {
    super(paramwno);
  }
  
  public void a(@NonNull wno paramwno, @NonNull vsu paramvsu)
  {
    wxe.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramvsu.jdField_a_of_type_Vpm, paramvsu.b);
    if ((wno.a(paramwno).equals(paramvsu.jdField_a_of_type_JavaLangString)) && ((paramvsu.jdField_a_of_type_Vpm instanceof vpx)))
    {
      woq localwoq = ((vpx)paramvsu.jdField_a_of_type_Vpm).a;
      if (localwoq != null) {
        paramwno.a(localwoq.jdField_a_of_type_JavaLangString, paramvsu.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vsu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnr
 * JD-Core Version:    0.7.0.1
 */