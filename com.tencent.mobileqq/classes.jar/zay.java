import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zay
  extends wfl<wtw, wvj>
{
  zay(zax paramzax) {}
  
  public void a(@NonNull wtw paramwtw, @Nullable wvj paramwvj, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramwvj != null))
    {
      ykq.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramwvj.toString());
      paramwtw = paramwvj.jdField_a_of_type_JavaUtilList;
      if (paramwtw.contains(zax.a(this.a)))
      {
        int i = paramwtw.indexOf(zax.a(this.a));
        zax.a(this.a, (zbd)paramwtw.get(i));
        zax.a(this.a).clear();
        zax.a(this.a).addAll(paramwtw);
        zax.a(this.a, paramwvj.jdField_a_of_type_JavaLangString);
        zax.a(this.a, paramwvj.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      zax.a(this.a).a(paramErrorMessage.errorCode, zax.a(this.a), this.a.a());
      return;
      zax.a(this.a, null);
      break;
      ykq.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zay
 * JD-Core Version:    0.7.0.1
 */