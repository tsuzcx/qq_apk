import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class afkh
  extends aquy
{
  afkh(afke paramafke, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(aquz paramaquz)
  {
    try
    {
      super.onDone(paramaquz);
      Bundle localBundle = paramaquz.getParams();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.this$0.fi.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (paramaquz.getStatus() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = paramaquz.aua;
        long l2 = paramaquz.atZ;
        this.this$0.a(localBundle, paramaquz, bool, paramaquz.errCode, paramaquz.bqw, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception paramaquz)
    {
      QLog.e(this.this$0.TAG, 1, "onDone failed", paramaquz);
    }
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramaquz.getParams();
        i = ((Bundle)localObject).getInt(paramaquz.currUrl);
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + paramaquz);
        }
        afke.b.e(localEmoticonPackage, (int)paramaquz.maxSize, (int)paramaquz.atU);
        if (i == 9)
        {
          localObject = ((Bundle)localObject).getString(paramaquz.currUrl + "emoticonId");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localEmoticonPackage != null)) {
            afke.a(this.this$0, localEmoticonPackage.epId, (String)localObject, paramaquz.errCode);
          }
        }
        if (paramaquz.errCode != 0)
        {
          QLog.e(this.this$0.TAG, 1, "onDoneFile : ondone error , reportCode = " + paramaquz.errCode);
          if (afke.jj(i)) {
            afke.b.a(localEmoticonPackage, i, -1, paramaquz.errCode);
          }
          aqrm.b("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", paramaquz.errCode + "", "", "", "");
          return;
        }
        if (afke.jj(i))
        {
          afke.b.a(localEmoticonPackage, i, 0, 0);
          if ((localEmoticonPackage.jobType != 3) && (localEmoticonPackage.jobType != 5)) {
            break;
          }
          this.this$0.g(paramaquz);
          return;
        }
      }
      catch (Exception paramaquz)
      {
        QLog.e(this.this$0.TAG, 1, "onDoneFile failed", paramaquz);
        return;
      }
      if (i == 7) {
        this.this$0.f(paramaquz);
      }
    }
  }
  
  public boolean onStart(aquz paramaquz)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramaquz.getParams().getSerializable("emoticonPackage");
    afke.b.e(localEmoticonPackage);
    super.onStart(paramaquz);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkh
 * JD-Core Version:    0.7.0.1
 */