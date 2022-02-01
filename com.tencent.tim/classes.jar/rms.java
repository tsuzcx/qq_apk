import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class rms
  extends ppv.c<pzj, qar>
{
  rms(rmr paramrmr) {}
  
  public void a(@NonNull pzj parampzj, @Nullable qar paramqar, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramqar != null))
    {
      ram.b("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramqar.toString());
      parampzj = paramqar.nD;
      if (parampzj.contains(rmr.a(this.a)))
      {
        int i = parampzj.indexOf(rmr.a(this.a));
        rmr.a(this.a, (rmw)parampzj.get(i));
        rmr.a(this.a).clear();
        rmr.a(this.a).addAll(parampzj);
        rmr.a(this.a, paramqar.avr);
        rmr.a(this.a, paramqar.blG);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this));
      }
    }
    for (;;)
    {
      rmr.a(this.a).b(paramErrorMessage.errorCode, rmr.a(this.a), this.a.isEnd());
      return;
      rmr.a(this.a, null);
      break;
      ram.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rms
 * JD-Core Version:    0.7.0.1
 */