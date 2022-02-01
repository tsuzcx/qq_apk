import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import java.util.concurrent.ConcurrentHashMap;

public class avfq
  extends aquy
{
  public avfq(PhotoPlusManager paramPhotoPlusManager, String paramString1, String paramString2, String paramString3) {}
  
  public void onCancel(aquz paramaquz)
  {
    PhotoPlusManager.a(this.this$0).remove(this.val$outputPath);
  }
  
  public void onDone(aquz paramaquz)
  {
    PhotoPlusManager.a(this.this$0).remove(this.val$outputPath);
    if (paramaquz.getStatus() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[onDone] download finished " + this.val$url);
      }
      if (TextUtils.isEmpty(this.val$md5)) {
        this.this$0.sv(this.val$outputPath);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      paramaquz = alab.getFileMD5String(this.val$outputPath);
      if (this.val$md5.equalsIgnoreCase(paramaquz))
      {
        this.this$0.sv(this.val$outputPath);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[onDone] checkMd5 failed: " + this.val$outputPath);
      }
      aqhq.deleteFile(this.val$outputPath);
      return;
    }
    QLog.d("PhotoPlusManager", 2, "[onDone] downloadFile failed: " + paramaquz.errMsg + " code=" + paramaquz.errCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfq
 * JD-Core Version:    0.7.0.1
 */