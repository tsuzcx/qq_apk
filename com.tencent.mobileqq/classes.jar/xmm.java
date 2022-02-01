import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class xmm
  implements woy<xdh, xdi>
{
  xmm(xml paramxml, xmy paramxmy) {}
  
  public void a(@NonNull xdh paramxdh, @Nullable xdi paramxdi, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxdi == null))
    {
      yuk.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xmy.a(paramErrorMessage, null, false);
      return;
    }
    xml.a(this.jdField_a_of_type_Xml);
    this.jdField_a_of_type_Xml.b.a(paramxdi.jdField_a_of_type_JavaUtilList, paramxdi.jdField_a_of_type_JavaLangString, paramxdi.jdField_a_of_type_Boolean);
    ((yme)wth.a(11)).a(paramxdi.jdField_a_of_type_JavaUtilList);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = ymv.a(paramxdi, localAtomicBoolean);
    yuk.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramxdi.b), Integer.valueOf(xml.b(this.jdField_a_of_type_Xml)), Boolean.valueOf(bool) });
    if ((!paramxdi.jdField_a_of_type_Boolean) && (xml.b(this.jdField_a_of_type_Xml) < 10) && ((!paramxdi.b) || (bool)))
    {
      yuk.d("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      paramxdh.b = this.jdField_a_of_type_Xml.b.a();
      wow.a().a(paramxdh, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.jdField_a_of_type_Xml.b.c();
    }
    this.jdField_a_of_type_Xmy.a(paramErrorMessage, xmg.b(paramxdi.jdField_a_of_type_JavaUtilList), paramxdi.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmm
 * JD-Core Version:    0.7.0.1
 */