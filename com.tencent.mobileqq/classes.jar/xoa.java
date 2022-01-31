import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class xoa
  extends urs<vge, vhr>
{
  xoa(xny paramxny) {}
  
  public void a(@NonNull vge paramvge, @Nullable vhr paramvhr, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvhr != null))
    {
      wxe.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramvhr.toString());
      xny.a(this.a).addAll(paramvhr.jdField_a_of_type_JavaUtilList);
      xny.a(this.a, paramvhr.jdField_a_of_type_JavaLangString);
      xny.a(this.a, paramvhr.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      xny.a(this.a).b(paramErrorMessage.errorCode, xny.a(this.a), this.a.a());
      return;
      wxe.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoa
 * JD-Core Version:    0.7.0.1
 */