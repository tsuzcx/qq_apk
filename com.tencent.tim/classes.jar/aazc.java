import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class aazc
  implements aaza.a
{
  aazc(aaza paramaaza) {}
  
  public void a(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong)
  {
    if ((paramInt == 0) && (paramPublishVideoEntry != null) && (paramString2 != null)) {
      aaza.a(this.a).c(paramPublishVideoEntry, paramString2);
    }
    for (;;)
    {
      ThreadManager.excute(new EncodeVideoTask.2.2(this, paramInt, paramPublishVideoEntry, paramLong), 64, null, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, new Object[] { "composite error, fakeVid:", aaza.e(this.a), ", errorCode:", Integer.valueOf(paramInt), ", errorMsg:", paramString1 });
      }
      aaza.a(this.a).onError(paramInt);
    }
  }
  
  public void c(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "generate files|onNext file: " + paramString);
    }
    if (aaza.b(this.a))
    {
      d(paramPublishVideoEntry, paramString);
      return;
    }
    if ((paramPublishVideoEntry != null) && (!TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) && (aqhq.fileExistsAndNotEmpty(paramPublishVideoEntry.doodlePath)))
    {
      aaza.b(paramString, paramPublishVideoEntry, aaza.a(this.a));
      return;
    }
    d(paramPublishVideoEntry, paramString);
  }
  
  public void d(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    ThreadManager.excute(new EncodeVideoTask.2.1(this, paramString, paramPublishVideoEntry), 64, null, true);
  }
  
  public void onError(int paramInt)
  {
    if (aaza.a(this.a) != null) {
      aaza.a(this.a).onError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazc
 * JD-Core Version:    0.7.0.1
 */