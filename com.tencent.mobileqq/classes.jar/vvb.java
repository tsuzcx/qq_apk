import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class vvb
  extends syu<tng, tot>
{
  vvb(vva paramvva) {}
  
  public void a(@NonNull tng paramtng, @Nullable tot paramtot, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtot != null))
    {
      veg.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramtot.toString());
      paramtng = paramtot.jdField_a_of_type_JavaUtilList;
      if (paramtng.contains(vva.a(this.a)))
      {
        int i = paramtng.indexOf(vva.a(this.a));
        vva.a(this.a, (vvg)paramtng.get(i));
        vva.a(this.a).clear();
        vva.a(this.a).addAll(paramtng);
        vva.a(this.a, paramtot.jdField_a_of_type_JavaLangString);
        vva.a(this.a, paramtot.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      vva.a(this.a).a(paramErrorMessage.errorCode, vva.a(this.a), this.a.a());
      return;
      vva.a(this.a, null);
      break;
      veg.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvb
 * JD-Core Version:    0.7.0.1
 */