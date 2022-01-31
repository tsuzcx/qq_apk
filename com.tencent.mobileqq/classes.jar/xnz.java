import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class xnz
  extends urs<vge, vhr>
{
  xnz(xny paramxny) {}
  
  public void a(@NonNull vge paramvge, @Nullable vhr paramvhr, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvhr != null))
    {
      wxe.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramvhr.toString());
      paramvge = paramvhr.jdField_a_of_type_JavaUtilList;
      if (paramvge.contains(xny.a(this.a)))
      {
        int i = paramvge.indexOf(xny.a(this.a));
        xny.a(this.a, (xoe)paramvge.get(i));
        xny.a(this.a).clear();
        xny.a(this.a).addAll(paramvge);
        xny.a(this.a, paramvhr.jdField_a_of_type_JavaLangString);
        xny.a(this.a, paramvhr.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      xny.a(this.a).a(paramErrorMessage.errorCode, xny.a(this.a), this.a.a());
      return;
      xny.a(this.a, null);
      break;
      wxe.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnz
 * JD-Core Version:    0.7.0.1
 */