import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class vzm
  extends QQUIEventReceiver<vzf, vvp>
{
  public vzm(@NonNull vzf paramvzf)
  {
    super(paramvzf);
  }
  
  public void a(@NonNull vzf paramvzf, @NonNull vvp paramvvp)
  {
    xvv.a(this.TAG, "onEvent, %s", String.valueOf(paramvvp));
    vxd localvxd = paramvzf.a.a(3, "");
    if ((localvxd != null) && (paramvvp.jdField_b_of_type_JavaLangString.equals(localvxd.jdField_e_of_type_JavaLangString)))
    {
      xvv.b(this.TAG, "onEvent, guideInfoNode read");
      paramvzf = new vyl();
      paramvzf.jdField_b_of_type_JavaLangString = localvxd.jdField_a_of_type_JavaLangString;
      paramvzf.c = localvxd.jdField_a_of_type_Int;
      paramvzf.d = 5;
      paramvzf.jdField_b_of_type_Long = localvxd.jdField_e_of_type_Long;
      vqn.a().a(paramvzf, null);
      return;
    }
    paramvzf.a.a(paramvvp.jdField_a_of_type_JavaLangString, paramvvp.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return vvp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzm
 * JD-Core Version:    0.7.0.1
 */