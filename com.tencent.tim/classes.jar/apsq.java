import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.6.1;
import java.util.Map;
import java.util.UUID;

public class apsq
  extends smq.n
{
  public apsq(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        paramString = paramBundle.getString("itemKey");
      } while (paramString == null);
      paramString = UUID.fromString(paramString);
      paramBundle = paramBundle.getString("fileId");
      paramString = (apbr)this.this$0.a().nP.get(paramString);
    } while ((paramString == null) || (paramInt1 != 0));
    smq.a(this.this$0.mApp, this.this$0.mTroopUin, paramString.dTg, paramString.mFileId, TroopFileTransferManager.a(this.this$0));
    ThreadManager.executeOnSubThread(new TroopFileTransferManager.6.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsq
 * JD-Core Version:    0.7.0.1
 */