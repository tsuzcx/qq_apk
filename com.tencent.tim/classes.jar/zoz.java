import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class zoz
  extends aquy
{
  public zoz(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + paramaquz.getStatus() + ",errCode=" + paramaquz.errCode);
    }
    int i = paramaquz.key.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramaquz.key;
      if (!aqgm.csT.equals(str)) {
        break label290;
      }
      if ((paramaquz.errCode != 0) || (paramaquz.httpCode != 200)) {
        break label237;
      }
      str = aqgm.csU + "/icon.zip";
      localFile = new File(aqgm.csV);
      if (aqva.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + paramaquz.httpCode + ", url: " + paramaquz.key);
      }
      aqhq.cn(aqgm.csU);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = paramaquz.key.substring(0, i);
      break;
      AvatarPendantActivity.c(this.this$0);
      this.this$0.aY.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + paramaquz.httpCode + ", url: " + paramaquz.key);
      }
      aqhq.cn(aqgm.csU);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + paramaquz.key + ",errCode:" + paramaquz.errCode + ",httpCode:" + paramaquz.httpCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoz
 * JD-Core Version:    0.7.0.1
 */