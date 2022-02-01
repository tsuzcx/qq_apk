import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wxw
  extends QQUIEventReceiver<wxp, wtz>
{
  public wxw(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull wtz paramwtz)
  {
    yuk.a(this.TAG, "onEvent, %s", String.valueOf(paramwtz));
    wvn localwvn = paramwxp.a.a(3, "");
    if ((localwvn != null) && (paramwtz.jdField_b_of_type_JavaLangString.equals(localwvn.jdField_e_of_type_JavaLangString)))
    {
      yuk.b(this.TAG, "onEvent, guideInfoNode read");
      paramwxp = new wwv();
      paramwxp.jdField_b_of_type_JavaLangString = localwvn.jdField_a_of_type_JavaLangString;
      paramwxp.c = localwvn.jdField_a_of_type_Int;
      paramwxp.d = 5;
      paramwxp.jdField_b_of_type_Long = localwvn.jdField_e_of_type_Long;
      wow.a().a(paramwxp, null);
      return;
    }
    paramwxp.a.a(paramwtz.jdField_a_of_type_JavaLangString, paramwtz.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return wtz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxw
 * JD-Core Version:    0.7.0.1
 */