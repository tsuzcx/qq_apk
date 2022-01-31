import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uuq
  extends QQUIEventReceiver<uun, tzt>
{
  public uuq(@NonNull uun paramuun)
  {
    super(paramuun);
  }
  
  public void a(@NonNull uun paramuun, @NonNull tzt paramtzt)
  {
    ved.a("Q.qqstory.memories.MemoriesVideoListSegment", "play video groupId=%s, %s", paramtzt.jdField_a_of_type_Twl, paramtzt.b);
    if ((uun.a(paramuun).equals(paramtzt.jdField_a_of_type_JavaLangString)) && ((paramtzt.jdField_a_of_type_Twl instanceof tww)))
    {
      uvp localuvp = ((tww)paramtzt.jdField_a_of_type_Twl).a;
      if (localuvp != null) {
        paramuun.a(localuvp.jdField_a_of_type_JavaLangString, paramtzt.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tzt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuq
 * JD-Core Version:    0.7.0.1
 */