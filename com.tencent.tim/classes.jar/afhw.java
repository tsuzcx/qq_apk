import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class afhw
  extends aook
{
  afhw(afhv paramafhv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (aoko)paramMessage.obj;
    if ((localObject == null) || (((aoko)localObject).commandId != this.this$0.CR())) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 1002: 
          case 1006: 
          case 1007: 
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FavroamingManager", 2, "start uploadFace favEmoticon");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + ((aoko)localObject).serverPath);
        }
      } while (this.this$0.bk.incrementAndGet() < this.this$0.cQY);
      this.this$0.cZE();
      return;
      if (afhv.a(this.this$0) == null)
      {
        QLog.e("FavroamingManager", 1, "app is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "STATUS_SEND_AND_SAVE_FINISHED resId=" + ((aoko)localObject).serverPath);
      }
      paramMessage = ((afhu)this.this$0.a()).a(((aoko)localObject).serverPath);
      localObject = (acef)afhv.b(this.this$0).getBusinessHandler(72);
    } while ((localObject == null) || (paramMessage == null) || (paramMessage.isMarkFace));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage);
    ((acef)localObject).Q(localArrayList, 1);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + ((aoko)localObject).serverPath);
    if (afhv.c(this.this$0) != null) {}
    for (int i = aqiw.getNetworkType(afhv.d(this.this$0).getApplication());; i = -1)
    {
      aqrm.b("emotionType", "emotionActionFav", "4", "", "", i + "", ((aoko)localObject).serverPath, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + ((aoko)localObject).serverPath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhw
 * JD-Core Version:    0.7.0.1
 */