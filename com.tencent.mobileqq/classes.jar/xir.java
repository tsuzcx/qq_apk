import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class xir
  implements wld<wzm, wzn>
{
  xir(xiq paramxiq, xjd paramxjd) {}
  
  public void a(@NonNull wzm paramwzm, @Nullable wzn paramwzn, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwzn == null))
    {
      yqp.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xjd.a(paramErrorMessage, null, false);
      return;
    }
    xiq.a(this.jdField_a_of_type_Xiq);
    this.jdField_a_of_type_Xiq.b.a(paramwzn.jdField_a_of_type_JavaUtilList, paramwzn.jdField_a_of_type_JavaLangString, paramwzn.jdField_a_of_type_Boolean);
    ((yij)wpm.a(11)).a(paramwzn.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = yja.a(paramwzn, localAtomicBoolean);
    yqp.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramwzn.b), Integer.valueOf(xiq.b(this.jdField_a_of_type_Xiq)), Boolean.valueOf(bool) });
    if ((!paramwzn.jdField_a_of_type_Boolean) && (xiq.b(this.jdField_a_of_type_Xiq) < 10) && ((!paramwzn.b) || (bool)))
    {
      yqp.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramwzm.b = this.jdField_a_of_type_Xiq.b.a();
      wlb.a().a(paramwzm, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Xiq.b.c();
    }
    this.jdField_a_of_type_Xjd.a(paramErrorMessage, xil.b(paramwzn.jdField_a_of_type_JavaUtilList), paramwzn.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xir
 * JD-Core Version:    0.7.0.1
 */