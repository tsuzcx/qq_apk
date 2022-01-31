import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vbv
  extends QQUIEventReceiver<vba, tzt>
{
  public vbv(@NonNull vba paramvba)
  {
    super(paramvba);
  }
  
  public void a(@NonNull vba paramvba, @NonNull tzt paramtzt)
  {
    ved.a(this.TAG, "play video groupId=%s, %s", paramtzt.jdField_a_of_type_Twl, paramtzt.b);
    if ((vba.a(paramvba).equals(paramtzt.jdField_a_of_type_JavaLangString)) && ((paramtzt.jdField_a_of_type_Twl instanceof twa)))
    {
      uvp localuvp = ((twa)paramtzt.jdField_a_of_type_Twl).a;
      if (localuvp != null) {
        paramvba.a(localuvp.jdField_a_of_type_JavaLangString, paramtzt.b, true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tzt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbv
 * JD-Core Version:    0.7.0.1
 */