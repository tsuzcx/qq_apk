import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ykx
  extends QQUIEventReceiver<yku, xqa>
{
  public ykx(@NonNull yku paramyku)
  {
    super(paramyku);
  }
  
  public void a(@NonNull yku paramyku, @NonNull xqa paramxqa)
  {
    yuk.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramxqa.jdField_a_of_type_Xms, paramxqa.b);
    if ((yku.a(paramyku).equals(paramxqa.jdField_a_of_type_JavaLangString)) && ((paramxqa.jdField_a_of_type_Xms instanceof xnd)))
    {
      ylw localylw = ((xnd)paramxqa.jdField_a_of_type_Xms).a;
      if (localylw != null) {
        paramyku.a(localylw.jdField_a_of_type_JavaLangString, paramxqa.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xqa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykx
 * JD-Core Version:    0.7.0.1
 */