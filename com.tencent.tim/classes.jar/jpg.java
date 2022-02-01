import android.content.Intent;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class jpg
  implements jox
{
  jpg(WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = (QQAppInterface)this.bW.get();
    Object localObject;
    if (paramString != null)
    {
      paramString = (aopo)paramString.getManager(193);
      localObject = this.val$downloadUrl;
      if (!BidDownloader.cS(paramInt)) {
        break label172;
      }
    }
    label172:
    for (long l = this.val$fileSize;; l = -1L)
    {
      paramString.be((String)localObject, l);
      QLog.i(jpf.TAG, 1, "finish predown bid=" + this.val$bid + ", code=" + paramInt);
      jpf.mS();
      if (jpf.access$000() == 0)
      {
        paramString = new Intent("com.tencent.process.tmdownloader.exit");
        localObject = new ArrayList();
        ((ArrayList)localObject).add("com.tencent.mobileqq:TMAssistantDownloadSDKService");
        paramString.putStringArrayListExtra("procNameList", (ArrayList)localObject);
        paramString.putExtra("verify", jpf.a((ArrayList)localObject, false));
        if (QLog.isColorLevel()) {
          QLog.d(jpf.TAG, 2, "sendBroadcast to close TMAssistant sdk process");
        }
        BaseApplicationImpl.getContext().sendBroadcast(paramString);
      }
      return;
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpg
 * JD-Core Version:    0.7.0.1
 */