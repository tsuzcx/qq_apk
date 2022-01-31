import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class vkx
  implements uni<vbr, vbs>
{
  vkx(vkw paramvkw, vlj paramvlj) {}
  
  public void a(@NonNull vbr paramvbr, @Nullable vbs paramvbs, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvbs == null))
    {
      wsv.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Vlj.a(paramErrorMessage, null, false);
      return;
    }
    vkw.a(this.jdField_a_of_type_Vkw);
    this.jdField_a_of_type_Vkw.b.a(paramvbs.jdField_a_of_type_JavaUtilList, paramvbs.jdField_a_of_type_JavaLangString, paramvbs.jdField_a_of_type_Boolean);
    ((wkp)urr.a(11)).a(paramvbs.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = wlg.a(paramvbs, localAtomicBoolean);
    wsv.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramvbs.b), Integer.valueOf(vkw.b(this.jdField_a_of_type_Vkw)), Boolean.valueOf(bool) });
    if ((!paramvbs.jdField_a_of_type_Boolean) && (vkw.b(this.jdField_a_of_type_Vkw) < 10) && ((!paramvbs.b) || (bool)))
    {
      wsv.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramvbr.b = this.jdField_a_of_type_Vkw.b.a();
      ung.a().a(paramvbr, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Vkw.b.c();
    }
    this.jdField_a_of_type_Vlj.a(paramErrorMessage, vkr.b(paramvbs.jdField_a_of_type_JavaUtilList), paramvbs.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkx
 * JD-Core Version:    0.7.0.1
 */