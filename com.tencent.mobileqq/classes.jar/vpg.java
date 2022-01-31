import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class vpg
  implements urr<vga, vgb>
{
  vpg(vpf paramvpf, vps paramvps) {}
  
  public void a(@NonNull vga paramvga, @Nullable vgb paramvgb, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvgb == null))
    {
      wxe.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Vps.a(paramErrorMessage, null, false);
      return;
    }
    vpf.a(this.jdField_a_of_type_Vpf);
    this.jdField_a_of_type_Vpf.b.a(paramvgb.jdField_a_of_type_JavaUtilList, paramvgb.jdField_a_of_type_JavaLangString, paramvgb.jdField_a_of_type_Boolean);
    ((woy)uwa.a(11)).a(paramvgb.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = wpp.a(paramvgb, localAtomicBoolean);
    wxe.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramvgb.b), Integer.valueOf(vpf.b(this.jdField_a_of_type_Vpf)), Boolean.valueOf(bool) });
    if ((!paramvgb.jdField_a_of_type_Boolean) && (vpf.b(this.jdField_a_of_type_Vpf) < 10) && ((!paramvgb.b) || (bool)))
    {
      wxe.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramvga.b = this.jdField_a_of_type_Vpf.b.a();
      urp.a().a(paramvga, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Vpf.b.c();
    }
    this.jdField_a_of_type_Vps.a(paramErrorMessage, vpa.b(paramvgb.jdField_a_of_type_JavaUtilList), paramvgb.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpg
 * JD-Core Version:    0.7.0.1
 */