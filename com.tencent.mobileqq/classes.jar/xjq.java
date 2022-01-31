import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class xjq
  extends unj<vbv, vdi>
{
  xjq(xjp paramxjp) {}
  
  public void a(@NonNull vbv paramvbv, @Nullable vdi paramvdi, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramvdi != null))
    {
      wsv.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramvdi.toString());
      paramvbv = paramvdi.jdField_a_of_type_JavaUtilList;
      if (paramvbv.contains(xjp.a(this.a)))
      {
        int i = paramvbv.indexOf(xjp.a(this.a));
        xjp.a(this.a, (xjv)paramvbv.get(i));
        xjp.a(this.a).clear();
        xjp.a(this.a).addAll(paramvbv);
        xjp.a(this.a, paramvdi.jdField_a_of_type_JavaLangString);
        xjp.a(this.a, paramvdi.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      xjp.a(this.a).a(paramErrorMessage.errorCode, xjp.a(this.a), this.a.a());
      return;
      xjp.a(this.a, null);
      break;
      wsv.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjq
 * JD-Core Version:    0.7.0.1
 */