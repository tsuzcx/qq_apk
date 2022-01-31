import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class uwg
  extends QQUIEventReceiver<uvz, usj>
{
  public uwg(@NonNull uvz paramuvz)
  {
    super(paramuvz);
  }
  
  public void a(@NonNull uvz paramuvz, @NonNull usj paramusj)
  {
    wsv.a(this.TAG, "onEvent, %s", String.valueOf(paramusj));
    utx localutx = paramuvz.a.a(3, "");
    if ((localutx != null) && (paramusj.jdField_b_of_type_JavaLangString.equals(localutx.jdField_e_of_type_JavaLangString)))
    {
      wsv.b(this.TAG, "onEvent, guideInfoNode read");
      paramuvz = new uvf();
      paramuvz.jdField_b_of_type_JavaLangString = localutx.jdField_a_of_type_JavaLangString;
      paramuvz.c = localutx.jdField_a_of_type_Int;
      paramuvz.d = 5;
      paramuvz.jdField_b_of_type_Long = localutx.jdField_e_of_type_Long;
      ung.a().a(paramuvz, null);
      return;
    }
    paramuvz.a.a(paramusj.jdField_a_of_type_JavaLangString, paramusj.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return usj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwg
 * JD-Core Version:    0.7.0.1
 */