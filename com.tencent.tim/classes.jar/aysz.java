import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class aysz
  extends ppv.c<pzj, qar>
{
  aysz(aysy paramaysy) {}
  
  public void a(@NonNull pzj parampzj, @Nullable qar paramqar, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramqar != null))
    {
      ram.b("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramqar.toString());
      parampzj = paramqar.nD;
      if (parampzj.contains(aysy.a(this.a)))
      {
        int i = parampzj.indexOf(aysy.a(this.a));
        aysy.a(this.a, (rmw)parampzj.get(i));
        aysy.a(this.a).clear();
        aysy.a(this.a).addAll(parampzj);
        parampzj = new ArrayList(aysy.a(this.a));
        aysy.a(this.a, paramqar.avr);
        aysy.a(this.a, paramqar.blG);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, parampzj));
      }
    }
    for (;;)
    {
      aysy.a(this.a).b(paramErrorMessage.errorCode, aysy.a(this.a), this.a.isEnd());
      return;
      aysy.a(this.a, null);
      break;
      ram.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysz
 * JD-Core Version:    0.7.0.1
 */