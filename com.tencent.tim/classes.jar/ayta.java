import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import java.util.List;

public class ayta
  extends ppv.c<pzj, qar>
{
  ayta(aysy paramaysy) {}
  
  public void a(@NonNull pzj parampzj, @Nullable qar paramqar, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramqar != null))
    {
      ram.b("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramqar.toString());
      aysy.a(this.a).addAll(paramqar.nD);
      aysy.a(this.a, paramqar.avr);
      aysy.a(this.a, paramqar.blG);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      aysy.a(this.a).c(paramErrorMessage.errorCode, aysy.a(this.a), this.a.isEnd());
      return;
      ram.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayta
 * JD-Core Version:    0.7.0.1
 */