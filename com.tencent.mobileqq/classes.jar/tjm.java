import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class tjm
  implements slx<tag, tah>
{
  tjm(tjl paramtjl, tjy paramtjy) {}
  
  public void a(@NonNull tag paramtag, @Nullable tah paramtah, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtah == null))
    {
      urk.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Tjy.a(paramErrorMessage, null, false);
      return;
    }
    tjl.a(this.jdField_a_of_type_Tjl);
    this.jdField_a_of_type_Tjl.b.a(paramtah.jdField_a_of_type_JavaUtilList, paramtah.jdField_a_of_type_JavaLangString, paramtah.jdField_a_of_type_Boolean);
    ((uje)sqg.a(11)).a(paramtah.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = ujv.a(paramtah, localAtomicBoolean);
    urk.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramtah.b), Integer.valueOf(tjl.b(this.jdField_a_of_type_Tjl)), Boolean.valueOf(bool) });
    if ((!paramtah.jdField_a_of_type_Boolean) && (tjl.b(this.jdField_a_of_type_Tjl) < 10) && ((!paramtah.b) || (bool)))
    {
      urk.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramtag.b = this.jdField_a_of_type_Tjl.b.a();
      slv.a().a(paramtag, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Tjl.b.c();
    }
    this.jdField_a_of_type_Tjy.a(paramErrorMessage, tjg.b(paramtah.jdField_a_of_type_JavaUtilList), paramtah.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjm
 * JD-Core Version:    0.7.0.1
 */