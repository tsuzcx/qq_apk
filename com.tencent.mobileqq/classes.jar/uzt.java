import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class uzt
  implements vaa
{
  uzt(uzq paramuzq) {}
  
  public void a(@Nullable uyg paramuyg, Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MsgTabStoryVideoPreloader", 2, "MsgTabVideoPreloaderDataProvider load video info error", paramError);
    }
    this.a.b();
  }
  
  public void a(@Nullable uyg paramuyg, @NonNull List<StoryVideoItem> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "start download video list, list = " + paramList.size() + "\n" + paramList);
      }
      uzq.a(this.a, paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MsgTabStoryVideoPreloader", 2, "can not find first unread video");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzt
 * JD-Core Version:    0.7.0.1
 */