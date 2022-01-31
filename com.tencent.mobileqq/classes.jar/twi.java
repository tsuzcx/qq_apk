import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class twi
  implements syt<tnc, tnd>
{
  twi(twh paramtwh, twu paramtwu) {}
  
  public void a(@NonNull tnc paramtnc, @Nullable tnd paramtnd, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtnd == null))
    {
      veg.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Twu.a(paramErrorMessage, null, false);
      return;
    }
    twh.a(this.jdField_a_of_type_Twh);
    this.jdField_a_of_type_Twh.b.a(paramtnd.jdField_a_of_type_JavaUtilList, paramtnd.jdField_a_of_type_JavaLangString, paramtnd.jdField_a_of_type_Boolean);
    ((uwa)tdc.a(11)).a(paramtnd.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = uwr.a(paramtnd, localAtomicBoolean);
    veg.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramtnd.b), Integer.valueOf(twh.b(this.jdField_a_of_type_Twh)), Boolean.valueOf(bool) });
    if ((!paramtnd.jdField_a_of_type_Boolean) && (twh.b(this.jdField_a_of_type_Twh) < 10) && ((!paramtnd.b) || (bool)))
    {
      veg.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramtnc.b = this.jdField_a_of_type_Twh.b.a();
      syr.a().a(paramtnc, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Twh.b.c();
    }
    this.jdField_a_of_type_Twu.a(paramErrorMessage, twc.b(paramtnd.jdField_a_of_type_JavaUtilList), paramtnd.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twi
 * JD-Core Version:    0.7.0.1
 */