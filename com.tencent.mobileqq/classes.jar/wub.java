import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wub
  extends QQUIEventReceiver<wtu, wqe>
{
  public wub(@NonNull wtu paramwtu)
  {
    super(paramwtu);
  }
  
  public void a(@NonNull wtu paramwtu, @NonNull wqe paramwqe)
  {
    yqp.a(this.TAG, "onEvent, %s", String.valueOf(paramwqe));
    wrs localwrs = paramwtu.a.a(3, "");
    if ((localwrs != null) && (paramwqe.jdField_b_of_type_JavaLangString.equals(localwrs.jdField_e_of_type_JavaLangString)))
    {
      yqp.b(this.TAG, "onEvent, guideInfoNode read");
      paramwtu = new wta();
      paramwtu.jdField_b_of_type_JavaLangString = localwrs.jdField_a_of_type_JavaLangString;
      paramwtu.c = localwrs.jdField_a_of_type_Int;
      paramwtu.d = 5;
      paramwtu.jdField_b_of_type_Long = localwrs.jdField_e_of_type_Long;
      wlb.a().a(paramwtu, null);
      return;
    }
    paramwtu.a.a(paramwqe.jdField_a_of_type_JavaLangString, paramwqe.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return wqe.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wub
 * JD-Core Version:    0.7.0.1
 */