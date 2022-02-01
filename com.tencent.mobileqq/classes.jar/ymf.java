import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class ymf
  extends vqq<wfb, wgo>
{
  ymf(yme paramyme) {}
  
  public void a(@NonNull wfb paramwfb, @Nullable wgo paramwgo, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramwgo != null))
    {
      xvv.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramwgo.toString());
      paramwfb = paramwgo.jdField_a_of_type_JavaUtilList;
      if (paramwfb.contains(yme.a(this.a)))
      {
        int i = paramwfb.indexOf(yme.a(this.a));
        yme.a(this.a, (ymk)paramwfb.get(i));
        yme.a(this.a).clear();
        yme.a(this.a).addAll(paramwfb);
        yme.a(this.a, paramwgo.jdField_a_of_type_JavaLangString);
        yme.a(this.a, paramwgo.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      yme.a(this.a).a(paramErrorMessage.errorCode, yme.a(this.a), this.a.a());
      return;
      yme.a(this.a, null);
      break;
      xvv.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymf
 * JD-Core Version:    0.7.0.1
 */