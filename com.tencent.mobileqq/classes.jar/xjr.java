import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class xjr
  extends unj<vbv, vdi>
{
  xjr(xjp paramxjp) {}
  
  public void a(@NonNull vbv paramvbv, @Nullable vdi paramvdi, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvdi != null))
    {
      wsv.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramvdi.toString());
      xjp.a(this.a).addAll(paramvdi.jdField_a_of_type_JavaUtilList);
      xjp.a(this.a, paramvdi.jdField_a_of_type_JavaLangString);
      xjp.a(this.a, paramvdi.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      xjp.a(this.a).b(paramErrorMessage.errorCode, xjp.a(this.a), this.a.a());
      return;
      wsv.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjr
 * JD-Core Version:    0.7.0.1
 */