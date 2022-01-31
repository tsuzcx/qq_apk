import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class vap
  extends QQUIEventReceiver<vai, uws>
{
  public vap(@NonNull vai paramvai)
  {
    super(paramvai);
  }
  
  public void a(@NonNull vai paramvai, @NonNull uws paramuws)
  {
    wxe.a(this.TAG, "onEvent, %s", String.valueOf(paramuws));
    uyg localuyg = paramvai.a.a(3, "");
    if ((localuyg != null) && (paramuws.jdField_b_of_type_JavaLangString.equals(localuyg.jdField_e_of_type_JavaLangString)))
    {
      wxe.b(this.TAG, "onEvent, guideInfoNode read");
      paramvai = new uzo();
      paramvai.jdField_b_of_type_JavaLangString = localuyg.jdField_a_of_type_JavaLangString;
      paramvai.c = localuyg.jdField_a_of_type_Int;
      paramvai.d = 5;
      paramvai.jdField_b_of_type_Long = localuyg.jdField_e_of_type_Long;
      urp.a().a(paramvai, null);
      return;
    }
    paramvai.a.a(paramuws.jdField_a_of_type_JavaLangString, paramuws.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return uws.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vap
 * JD-Core Version:    0.7.0.1
 */