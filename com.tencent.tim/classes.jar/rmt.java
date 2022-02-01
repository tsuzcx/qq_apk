import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class rmt
  extends ppv.c<pzj, qar>
{
  rmt(rmr paramrmr) {}
  
  public void a(@NonNull pzj parampzj, @Nullable qar paramqar, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("EditVideoTagPresenter", "loadMore onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramqar != null))
    {
      ram.b("EditVideoTagPresenter", "loadMore onCmdRespond, refresh success:[%s]", paramqar.toString());
      rmr.a(this.a).addAll(paramqar.nD);
      rmr.a(this.a, paramqar.avr);
      rmr.a(this.a, paramqar.blG);
      ThreadManager.executeOnSubThread(new EditVideoTagPresenter.2.1(this));
    }
    for (;;)
    {
      rmr.a(this.a).c(paramErrorMessage.errorCode, rmr.a(this.a), this.a.isEnd());
      return;
      ram.e("EditVideoTagPresenter", "loadMore onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmt
 * JD-Core Version:    0.7.0.1
 */