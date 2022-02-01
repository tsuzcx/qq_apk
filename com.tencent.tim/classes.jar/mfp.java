import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class mfp
  extends aquy
{
  mfp(mfo parammfo, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(aquz paramaquz)
  {
    String str = paramaquz.getParams().getString("refreshId");
    this.this$0.ed.remove("refresh_" + str);
    super.onCancel(paramaquz);
  }
  
  public void onDone(aquz paramaquz)
  {
    String str1 = paramaquz.getParams().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + paramaquz.errCode);
    }
    if (paramaquz.errCode == 0)
    {
      paramaquz = new File(this.agy);
      if (!paramaquz.exists()) {}
    }
    for (;;)
    {
      try
      {
        aqhq.W(paramaquz.getAbsolutePath(), mgh.getResPath(), false);
        this.a.isShown = true;
        aqmj.l(this.this$0.mApp.getApplication().getBaseContext(), this.this$0.mApp.getCurrentAccountUin(), this.a.toJson().toString(), this.val$source);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        paramaquz.delete();
        continue;
      }
      finally
      {
        paramaquz.delete();
      }
      this.this$0.ed.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(aquz paramaquz)
  {
    super.onProgress(paramaquz);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfp
 * JD-Core Version:    0.7.0.1
 */