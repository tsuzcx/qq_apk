import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class ymg
  extends vqq<wfb, wgo>
{
  ymg(yme paramyme) {}
  
  public void a(@NonNull wfb paramwfb, @Nullable wgo paramwgo, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramwgo != null))
    {
      xvv.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramwgo.toString());
      yme.a(this.a).addAll(paramwgo.jdField_a_of_type_JavaUtilList);
      yme.a(this.a, paramwgo.jdField_a_of_type_JavaLangString);
      yme.a(this.a, paramwgo.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      yme.a(this.a).b(paramErrorMessage.errorCode, yme.a(this.a), this.a.a());
      return;
      xvv.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymg
 * JD-Core Version:    0.7.0.1
 */