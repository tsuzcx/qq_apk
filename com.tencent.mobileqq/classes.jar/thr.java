import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class thr
  extends QQUIEventReceiver<thk, tdu>
{
  public thr(@NonNull thk paramthk)
  {
    super(paramthk);
  }
  
  public void a(@NonNull thk paramthk, @NonNull tdu paramtdu)
  {
    veg.a(this.TAG, "onEvent, %s", String.valueOf(paramtdu));
    tfi localtfi = paramthk.a.a(3, "");
    if ((localtfi != null) && (paramtdu.jdField_b_of_type_JavaLangString.equals(localtfi.jdField_e_of_type_JavaLangString)))
    {
      veg.b(this.TAG, "onEvent, guideInfoNode read");
      paramthk = new tgq();
      paramthk.jdField_b_of_type_JavaLangString = localtfi.jdField_a_of_type_JavaLangString;
      paramthk.c = localtfi.jdField_a_of_type_Int;
      paramthk.d = 5;
      paramthk.jdField_b_of_type_Long = localtfi.jdField_e_of_type_Long;
      syr.a().a(paramthk, null);
      return;
    }
    paramthk.a.a(paramtdu.jdField_a_of_type_JavaLangString, paramtdu.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return tdu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thr
 * JD-Core Version:    0.7.0.1
 */