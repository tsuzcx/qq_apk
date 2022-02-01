import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class vxi
  extends aquy
{
  public vxi(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + paramaquz);
    }
    super.onCancel(paramaquz);
  }
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + paramaquz);
    }
    if (paramaquz.isCancel()) {}
    do
    {
      return;
      if (paramaquz.getStatus() == -1)
      {
        paramaquz = new Message();
        paramaquz.what = 17;
        TextPreviewSettingActivity.a(this.this$0).sendMessage(paramaquz);
        return;
      }
      paramaquz = TextPreviewSettingActivity.a(this.this$0).a(TextPreviewSettingActivity.a(this.this$0));
    } while (paramaquz == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = paramaquz;
    TextPreviewSettingActivity.a(this.this$0).sendMessage(localMessage);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + paramaquz);
    }
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxi
 * JD-Core Version:    0.7.0.1
 */