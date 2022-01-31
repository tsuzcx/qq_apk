import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class vjb
  extends DownloadListener
{
  public vjb(ThumbItemBuilder paramThumbItemBuilder, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + paramDownloadTask);
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {}
    do
    {
      return;
      paramDownloadTask.a().getInt("type");
    } while (paramDownloadTask.a() == -1);
    paramDownloadTask = new Message();
    paramDownloadTask.what = ThumbItemBuilder.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + paramDownloadTask);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjb
 * JD-Core Version:    0.7.0.1
 */