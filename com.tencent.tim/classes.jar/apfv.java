import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1;
import java.util.UUID;

public class apfv
  extends smq.n
{
  apfv(apfu paramapfu) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        do
        {
          return;
          paramString = paramBundle.getString("itemKey");
        } while (paramString == null);
        paramString = UUID.fromString(paramString);
      } while (!paramString.equals(this.a.a()));
      apef.b.i("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.coy + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      apsf localapsf = apef.a(this.a.mTroopUin);
      if (localapsf == null)
      {
        apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.coy + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localapsf.b(paramString);
      if (paramString == null)
      {
        apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.coy + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    apef.b.i("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.coy + "] onReqFeedsResult refreshOneFile");
    smq.a(apef.getApp(), this.a.mTroopUin, paramString.dTg, paramString.mFileId, this.a.a);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfv
 * JD-Core Version:    0.7.0.1
 */