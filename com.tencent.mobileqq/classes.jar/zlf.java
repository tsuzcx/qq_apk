import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zlf
  extends woz<xdl, xey>
{
  zlf(zle paramzle) {}
  
  public void a(@NonNull xdl paramxdl, @Nullable xey paramxey, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramxey != null))
    {
      yuk.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramxey.toString());
      paramxdl = paramxey.jdField_a_of_type_JavaUtilList;
      if (paramxdl.contains(zle.a(this.a)))
      {
        int i = paramxdl.indexOf(zle.a(this.a));
        zle.a(this.a, (zlk)paramxdl.get(i));
        zle.a(this.a).clear();
        zle.a(this.a).addAll(paramxdl);
        zle.a(this.a, paramxey.jdField_a_of_type_JavaLangString);
        zle.a(this.a, paramxey.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      zle.a(this.a).a(paramErrorMessage.errorCode, zle.a(this.a), this.a.a());
      return;
      zle.a(this.a, null);
      break;
      yuk.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlf
 * JD-Core Version:    0.7.0.1
 */