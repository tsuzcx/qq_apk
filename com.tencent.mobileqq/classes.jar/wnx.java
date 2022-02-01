import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class wnx
  implements vqp<wex, wey>
{
  wnx(wnw paramwnw, woj paramwoj) {}
  
  public void a(@NonNull wex paramwex, @Nullable wey paramwey, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwey == null))
    {
      xvv.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Woj.a(paramErrorMessage, null, false);
      return;
    }
    wnw.a(this.jdField_a_of_type_Wnw);
    this.jdField_a_of_type_Wnw.b.a(paramwey.jdField_a_of_type_JavaUtilList, paramwey.jdField_a_of_type_JavaLangString, paramwey.jdField_a_of_type_Boolean);
    ((xnp)vux.a(11)).a(paramwey.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = xog.a(paramwey, localAtomicBoolean);
    xvv.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramwey.b), Integer.valueOf(wnw.b(this.jdField_a_of_type_Wnw)), Boolean.valueOf(bool) });
    if ((!paramwey.jdField_a_of_type_Boolean) && (wnw.b(this.jdField_a_of_type_Wnw) < 10) && ((!paramwey.b) || (bool)))
    {
      xvv.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramwex.b = this.jdField_a_of_type_Wnw.b.a();
      vqn.a().a(paramwex, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Wnw.b.c();
    }
    this.jdField_a_of_type_Woj.a(paramErrorMessage, wnr.b(paramwey.jdField_a_of_type_JavaUtilList), paramwey.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnx
 * JD-Core Version:    0.7.0.1
 */