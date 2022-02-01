import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class afkf
  extends aquy
{
  afkf(afke paramafke, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(aquz paramaquz)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = paramaquz.getParams();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.this$0.TAG, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + paramaquz.getStatus());
      }
      if (paramaquz.getStatus() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = afkp.a(this.this$0.mApp, paramaquz, bool);
      if (str != null)
      {
        QLog.e(this.this$0.TAG, 1, "jsonDownloadListener : parse json error : = " + str);
        this.this$0.a(localEmoticonPackage, 11008, 0L, paramaquz.bqw);
        return;
      }
    }
    catch (Exception paramaquz)
    {
      QLog.e(this.this$0.TAG, 1, "json download fail", paramaquz);
      return;
    }
    afke.b.b(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.this$0.TAG, 1, "jsonDownloadListener : ondone error , reportCode = " + paramaquz.errCode);
    afke.b.b(localEmoticonPackage, -1, localBundle);
    aqrm.b("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", paramaquz.errCode + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkf
 * JD-Core Version:    0.7.0.1
 */