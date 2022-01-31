import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class vif
  extends sly<tak, tbx>
{
  vif(vie paramvie) {}
  
  public void a(@NonNull tak paramtak, @Nullable tbx paramtbx, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtbx != null))
    {
      urk.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramtbx.toString());
      paramtak = paramtbx.jdField_a_of_type_JavaUtilList;
      if (paramtak.contains(vie.a(this.a)))
      {
        int i = paramtak.indexOf(vie.a(this.a));
        vie.a(this.a, (vik)paramtak.get(i));
        vie.a(this.a).clear();
        vie.a(this.a).addAll(paramtak);
        vie.a(this.a, paramtbx.jdField_a_of_type_JavaLangString);
        vie.a(this.a, paramtbx.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      vie.a(this.a).a(paramErrorMessage.errorCode, vie.a(this.a), this.a.a());
      return;
      vie.a(this.a, null);
      break;
      urk.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vif
 * JD-Core Version:    0.7.0.1
 */