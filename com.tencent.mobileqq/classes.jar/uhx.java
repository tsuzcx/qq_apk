import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uhx
  extends QQUIEventReceiver<uhu, tna>
{
  public uhx(@NonNull uhu paramuhu)
  {
    super(paramuhu);
  }
  
  public void a(@NonNull uhu paramuhu, @NonNull tna paramtna)
  {
    urk.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramtna.jdField_a_of_type_Tjs, paramtna.b);
    if ((uhu.a(paramuhu).equals(paramtna.jdField_a_of_type_JavaLangString)) && ((paramtna.jdField_a_of_type_Tjs instanceof tkd)))
    {
      uiw localuiw = ((tkd)paramtna.jdField_a_of_type_Tjs).a;
      if (localuiw != null) {
        paramuhu.a(localuiw.jdField_a_of_type_JavaLangString, paramtna.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tna.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */