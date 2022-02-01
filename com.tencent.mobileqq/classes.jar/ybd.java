import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ybd
  extends QQUIEventReceiver<yba, xgg>
{
  public ybd(@NonNull yba paramyba)
  {
    super(paramyba);
  }
  
  public void a(@NonNull yba paramyba, @NonNull xgg paramxgg)
  {
    ykq.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramxgg.jdField_a_of_type_Xcy, paramxgg.b);
    if ((yba.a(paramyba).equals(paramxgg.jdField_a_of_type_JavaLangString)) && ((paramxgg.jdField_a_of_type_Xcy instanceof xdj)))
    {
      ycc localycc = ((xdj)paramxgg.jdField_a_of_type_Xcy).a;
      if (localycc != null) {
        paramyba.a(localycc.jdField_a_of_type_JavaLangString, paramxgg.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xgg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybd
 * JD-Core Version:    0.7.0.1
 */