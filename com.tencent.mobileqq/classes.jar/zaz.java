import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zaz
  extends wfl<wtw, wvj>
{
  zaz(zax paramzax) {}
  
  public void a(@NonNull wtw paramwtw, @Nullable wvj paramwvj, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramwvj != null))
    {
      ykq.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramwvj.toString());
      zax.a(this.a).addAll(paramwvj.jdField_a_of_type_JavaUtilList);
      zax.a(this.a, paramwvj.jdField_a_of_type_JavaLangString);
      zax.a(this.a, paramwvj.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      zax.a(this.a).b(paramErrorMessage.errorCode, zax.a(this.a), this.a.a());
      return;
      ykq.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaz
 * JD-Core Version:    0.7.0.1
 */