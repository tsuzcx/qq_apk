import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class wnl
  implements wns
{
  wnl(wni paramwni) {}
  
  public void a(@Nullable wly paramwly, Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MsgTabStoryVideoPreloader", 2, "MsgTabVideoPreloaderDataProvider load video info error", paramError);
    }
    this.a.b();
  }
  
  public void a(@Nullable wly paramwly, @NonNull List<StoryVideoItem> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "start download video list, list = " + paramList.size() + "\n" + paramList);
      }
      wni.a(this.a, paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MsgTabStoryVideoPreloader", 2, "can not find first unread video");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnl
 * JD-Core Version:    0.7.0.1
 */