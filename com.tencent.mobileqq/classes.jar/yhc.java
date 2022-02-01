import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yhc
  extends QQUIEventReceiver<ygz, xmf>
{
  public yhc(@NonNull ygz paramygz)
  {
    super(paramygz);
  }
  
  public void a(@NonNull ygz paramygz, @NonNull xmf paramxmf)
  {
    yqp.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramxmf.jdField_a_of_type_Xix, paramxmf.b);
    if ((ygz.a(paramygz).equals(paramxmf.jdField_a_of_type_JavaLangString)) && ((paramxmf.jdField_a_of_type_Xix instanceof xji)))
    {
      yib localyib = ((xji)paramxmf.jdField_a_of_type_Xix).a;
      if (localyib != null) {
        paramygz.a(localyib.jdField_a_of_type_JavaLangString, paramxmf.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xmf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhc
 * JD-Core Version:    0.7.0.1
 */