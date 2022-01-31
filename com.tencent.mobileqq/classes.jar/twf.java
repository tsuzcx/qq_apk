import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class twf
  implements syq<tmz, tna>
{
  twf(twe paramtwe, twr paramtwr) {}
  
  public void a(@NonNull tmz paramtmz, @Nullable tna paramtna, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtna == null))
    {
      ved.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Twr.a(paramErrorMessage, null, false);
      return;
    }
    twe.a(this.jdField_a_of_type_Twe);
    this.jdField_a_of_type_Twe.b.a(paramtna.jdField_a_of_type_JavaUtilList, paramtna.jdField_a_of_type_JavaLangString, paramtna.jdField_a_of_type_Boolean);
    ((uvx)tcz.a(11)).a(paramtna.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = uwo.a(paramtna, localAtomicBoolean);
    ved.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramtna.b), Integer.valueOf(twe.b(this.jdField_a_of_type_Twe)), Boolean.valueOf(bool) });
    if ((!paramtna.jdField_a_of_type_Boolean) && (twe.b(this.jdField_a_of_type_Twe) < 10) && ((!paramtna.b) || (bool)))
    {
      ved.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramtmz.b = this.jdField_a_of_type_Twe.b.a();
      syo.a().a(paramtmz, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Twe.b.c();
    }
    this.jdField_a_of_type_Twr.a(paramErrorMessage, tvz.b(paramtna.jdField_a_of_type_JavaUtilList), paramtna.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twf
 * JD-Core Version:    0.7.0.1
 */