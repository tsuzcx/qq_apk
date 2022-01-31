import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class vvc
  extends syu<tng, tot>
{
  vvc(vva paramvva) {}
  
  public void a(@NonNull tng paramtng, @Nullable tot paramtot, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtot != null))
    {
      veg.a("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramtot.toString());
      vva.a(this.a).addAll(paramtot.jdField_a_of_type_JavaUtilList);
      vva.a(this.a, paramtot.jdField_a_of_type_JavaLangString);
      vva.a(this.a, paramtot.b);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      vva.a(this.a).b(paramErrorMessage.errorCode, vva.a(this.a), this.a.a());
      return;
      veg.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvc
 * JD-Core Version:    0.7.0.1
 */