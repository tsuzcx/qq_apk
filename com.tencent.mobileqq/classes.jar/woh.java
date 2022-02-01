import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class woh
  extends QQUIEventReceiver<woa, wkk>
{
  public woh(@NonNull woa paramwoa)
  {
    super(paramwoa);
  }
  
  public void a(@NonNull woa paramwoa, @NonNull wkk paramwkk)
  {
    ykq.a(this.TAG, "onEvent, %s", String.valueOf(paramwkk));
    wly localwly = paramwoa.a.a(3, "");
    if ((localwly != null) && (paramwkk.jdField_b_of_type_JavaLangString.equals(localwly.jdField_e_of_type_JavaLangString)))
    {
      ykq.b(this.TAG, "onEvent, guideInfoNode read");
      paramwoa = new wng();
      paramwoa.jdField_b_of_type_JavaLangString = localwly.jdField_a_of_type_JavaLangString;
      paramwoa.c = localwly.jdField_a_of_type_Int;
      paramwoa.d = 5;
      paramwoa.jdField_b_of_type_Long = localwly.jdField_e_of_type_Long;
      wfi.a().a(paramwoa, null);
      return;
    }
    paramwoa.a.a(paramwkk.jdField_a_of_type_JavaLangString, paramwkk.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return wkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woh
 * JD-Core Version:    0.7.0.1
 */