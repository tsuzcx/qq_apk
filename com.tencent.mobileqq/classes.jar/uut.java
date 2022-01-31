import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uut
  extends QQUIEventReceiver<uuq, tzw>
{
  public uut(@NonNull uuq paramuuq)
  {
    super(paramuuq);
  }
  
  public void a(@NonNull uuq paramuuq, @NonNull tzw paramtzw)
  {
    veg.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramtzw.jdField_a_of_type_Two, paramtzw.b);
    if ((uuq.a(paramuuq).equals(paramtzw.jdField_a_of_type_JavaLangString)) && ((paramtzw.jdField_a_of_type_Two instanceof twz)))
    {
      uvs localuvs = ((twz)paramtzw.jdField_a_of_type_Two).a;
      if (localuvs != null) {
        paramuuq.a(localuvs.jdField_a_of_type_JavaLangString, paramtzw.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uut
 * JD-Core Version:    0.7.0.1
 */