import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class xzl
  implements xzn
{
  public xzl(EncodeVideoTask paramEncodeVideoTask) {}
  
  public void a(int paramInt)
  {
    if (EncodeVideoTask.a(this.a) != null) {
      EncodeVideoTask.a(this.a).a(paramInt);
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "generate files|onNext file: " + paramString);
    }
    if (EncodeVideoTask.a(this.a))
    {
      b(paramPublishVideoEntry, paramString);
      return;
    }
    if ((paramPublishVideoEntry != null) && (!TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) && (FileUtils.b(paramPublishVideoEntry.doodlePath)))
    {
      EncodeVideoTask.a(paramString, paramPublishVideoEntry, EncodeVideoTask.a(this.a));
      return;
    }
    b(paramPublishVideoEntry, paramString);
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    ThreadManager.postImmediately(new xzm(this, paramPublishVideoEntry, paramString), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzl
 * JD-Core Version:    0.7.0.1
 */