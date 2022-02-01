import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zhl
  extends wle<wzq, xbd>
{
  zhl(zhj paramzhj) {}
  
  public void a(@NonNull wzq paramwzq, @Nullable xbd paramxbd, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramxbd != null))
    {
      yqp.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramxbd.toString());
      zhj.a(this.a).addAll(paramxbd.jdField_a_of_type_JavaUtilList);
      zhj.a(this.a, paramxbd.jdField_a_of_type_JavaLangString);
      zhj.a(this.a, paramxbd.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      zhj.a(this.a).b(paramErrorMessage.errorCode, zhj.a(this.a), this.a.a());
      return;
      yqp.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhl
 * JD-Core Version:    0.7.0.1
 */