import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class apsm
  extends smq.l
{
  public apsm(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    try
    {
      paramString1 = (TroopFileTransferManager)TroopFileTransferManager.access$000().get(Long.valueOf(l));
      if (paramString1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      paramString3 = paramBundle.getString("itemKey");
      if (paramString3 == null) {
        return;
      }
      paramBundle = UUID.fromString(paramString3);
      try
      {
        paramString2 = (TroopFileTransferManager.Item)paramString1.nC.get(paramBundle);
        if (paramString2 == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + paramString3);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    if (paramBoolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
      }
      if (paramString2.BusId == 25) {
        label445:
        for (;;)
        {
          try
          {
            awou.nP(paramInt1);
            if (paramInt1 == 0)
            {
              this.this$0.nF.remove(paramBundle);
              if (this.this$0.nF.size() != 0) {
                break label330;
              }
              paramString3 = new apsd.a(paramString2.FileName, this.this$0.mTroopUin, 5, 604);
              this.this$0.a(paramString2, 5, paramString3);
              return;
            }
          }
          finally {}
          this.this$0.nF.put(paramBundle, Integer.valueOf(paramInt1));
          continue;
          label330:
          paramString3 = this.this$0.nF.keySet().iterator();
          do
          {
            if (!paramString3.hasNext()) {
              break;
            }
            paramBundle = (UUID)paramString3.next();
          } while (((Integer)this.this$0.nF.get(paramBundle)).intValue() != 2147483647);
          for (paramInt1 = 0;; paramInt1 = 1)
          {
            if (paramInt1 == 0) {
              break label445;
            }
            paramString3 = new apsd.a(paramString2.FileName, this.this$0.mTroopUin, 5, 605);
            this.this$0.a(paramString2, 5, paramString3);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsm
 * JD-Core Version:    0.7.0.1
 */