import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xmi
  extends QQUIEventReceiver<xmf, wrl>
{
  public xmi(@NonNull xmf paramxmf)
  {
    super(paramxmf);
  }
  
  public void a(@NonNull xmf paramxmf, @NonNull wrl paramwrl)
  {
    xvv.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramwrl.jdField_a_of_type_Wod, paramwrl.b);
    if ((xmf.a(paramxmf).equals(paramwrl.jdField_a_of_type_JavaLangString)) && ((paramwrl.jdField_a_of_type_Wod instanceof woo)))
    {
      xnh localxnh = ((woo)paramwrl.jdField_a_of_type_Wod).a;
      if (localxnh != null) {
        paramxmf.a(localxnh.jdField_a_of_type_JavaLangString, paramwrl.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wrl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmi
 * JD-Core Version:    0.7.0.1
 */