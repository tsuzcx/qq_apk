import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zlg
  extends woz<xdl, xey>
{
  zlg(zle paramzle) {}
  
  public void a(@NonNull xdl paramxdl, @Nullable xey paramxey, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramxey != null))
    {
      yuk.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramxey.toString());
      zle.a(this.a).addAll(paramxey.jdField_a_of_type_JavaUtilList);
      zle.a(this.a, paramxey.jdField_a_of_type_JavaLangString);
      zle.a(this.a, paramxey.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      zle.a(this.a).b(paramErrorMessage.errorCode, zle.a(this.a), this.a.a());
      return;
      yuk.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlg
 * JD-Core Version:    0.7.0.1
 */