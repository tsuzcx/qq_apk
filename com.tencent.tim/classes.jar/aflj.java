import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aflj
  extends aquy
{
  aflj(afli paramafli) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    afke localafke = this.this$0.a();
    Bundle localBundle = paramaquz.getParams();
    if (paramaquz.getStatus() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localafke.a(localBundle, paramaquz, bool, paramaquz.errCode, paramaquz.bqw, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    Object localObject = paramaquz.getParams();
    int i = ((Bundle)localObject).getInt(paramaquz.currUrl);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + paramaquz);
    }
    if (paramaquz.errCode != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + paramaquz.errCode);
      if (afke.jj(i)) {
        afke.b.a((EmoticonPackage)localObject, i, -1, paramaquz.errCode);
      }
      aqrm.b("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", paramaquz.errCode + "", "", "", "");
    }
    for (;;)
    {
      return;
      afke localafke = this.this$0.a();
      if (afke.jj(i)) {
        afke.b.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localafke.g(paramaquz);
        return;
        if (i == 7) {
          localafke.f(paramaquz);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflj
 * JD-Core Version:    0.7.0.1
 */