import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class vuy
  extends syr<tnd, toq>
{
  vuy(vux paramvux) {}
  
  public void a(@NonNull tnd paramtnd, @Nullable toq paramtoq, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtoq != null))
    {
      ved.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramtoq.toString());
      paramtnd = paramtoq.jdField_a_of_type_JavaUtilList;
      if (paramtnd.contains(vux.a(this.a)))
      {
        int i = paramtnd.indexOf(vux.a(this.a));
        vux.a(this.a, (vvd)paramtnd.get(i));
        vux.a(this.a).clear();
        vux.a(this.a).addAll(paramtnd);
        vux.a(this.a, paramtoq.jdField_a_of_type_JavaLangString);
        vux.a(this.a, paramtoq.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      vux.a(this.a).a(paramErrorMessage.errorCode, vux.a(this.a), this.a.a());
      return;
      vux.a(this.a, null);
      break;
      ved.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vuy
 * JD-Core Version:    0.7.0.1
 */