import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zhk
  extends wle<wzq, xbd>
{
  zhk(zhj paramzhj) {}
  
  public void a(@NonNull wzq paramwzq, @Nullable xbd paramxbd, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramxbd != null))
    {
      yqp.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramxbd.toString());
      paramwzq = paramxbd.jdField_a_of_type_JavaUtilList;
      if (paramwzq.contains(zhj.a(this.a)))
      {
        int i = paramwzq.indexOf(zhj.a(this.a));
        zhj.a(this.a, (zhp)paramwzq.get(i));
        zhj.a(this.a).clear();
        zhj.a(this.a).addAll(paramwzq);
        zhj.a(this.a, paramxbd.jdField_a_of_type_JavaLangString);
        zhj.a(this.a, paramxbd.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      zhj.a(this.a).a(paramErrorMessage.errorCode, zhj.a(this.a), this.a.a());
      return;
      zhj.a(this.a, null);
      break;
      yqp.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhk
 * JD-Core Version:    0.7.0.1
 */