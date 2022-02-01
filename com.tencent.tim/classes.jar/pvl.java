import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pvl
  implements pvm.a
{
  pvl(pvi parampvi) {}
  
  public void a(@Nullable puh parampuh, Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MsgTabStoryVideoPreloader", 2, "MsgTabVideoPreloaderDataProvider load video info error", paramError);
    }
    this.b.bmX();
  }
  
  public void a(@Nullable puh parampuh, @NonNull List<StoryVideoItem> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "start download video list, list = " + paramList.size() + "\n" + paramList);
      }
      pvi.a(this.b, paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MsgTabStoryVideoPreloader", 2, "can not find first unread video");
    }
    this.b.bmX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvl
 * JD-Core Version:    0.7.0.1
 */