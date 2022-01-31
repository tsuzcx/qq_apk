import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class vig
  extends sly<tak, tbx>
{
  vig(vie paramvie) {}
  
  public void a(@NonNull tak paramtak, @Nullable tbx paramtbx, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtbx != null))
    {
      urk.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramtbx.toString());
      vie.a(this.a).addAll(paramtbx.jdField_a_of_type_JavaUtilList);
      vie.a(this.a, paramtbx.jdField_a_of_type_JavaLangString);
      vie.a(this.a, paramtbx.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      vie.a(this.a).b(paramErrorMessage.errorCode, vie.a(this.a), this.a.a());
      return;
      urk.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vig
 * JD-Core Version:    0.7.0.1
 */