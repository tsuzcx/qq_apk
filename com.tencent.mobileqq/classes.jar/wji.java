import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wji
  extends QQUIEventReceiver<wjf, vol>
{
  public wji(@NonNull wjf paramwjf)
  {
    super(paramwjf);
  }
  
  public void a(@NonNull wjf paramwjf, @NonNull vol paramvol)
  {
    wsv.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramvol.jdField_a_of_type_Vld, paramvol.b);
    if ((wjf.a(paramwjf).equals(paramvol.jdField_a_of_type_JavaLangString)) && ((paramvol.jdField_a_of_type_Vld instanceof vlo)))
    {
      wkh localwkh = ((vlo)paramvol.jdField_a_of_type_Vld).a;
      if (localwkh != null) {
        paramwjf.a(localwkh.jdField_a_of_type_JavaLangString, paramvol.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vol.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wji
 * JD-Core Version:    0.7.0.1
 */