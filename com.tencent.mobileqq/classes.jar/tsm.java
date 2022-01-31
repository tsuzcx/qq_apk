import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class tsm
  extends DownloadListener
{
  public tsm(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onCancel| task:" + paramDownloadTask);
    }
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {}
    do
    {
      return;
      if (paramDownloadTask.a() == -1)
      {
        paramDownloadTask = new Message();
        paramDownloadTask.what = 17;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramDownloadTask);
        return;
      }
      paramDownloadTask = this.a.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.a.d);
    } while (paramDownloadTask == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = paramDownloadTask;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "fontNameDownloadListener.onStart| task:" + paramDownloadTask);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsm
 * JD-Core Version:    0.7.0.1
 */