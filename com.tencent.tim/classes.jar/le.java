import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class le
  extends VasQuickUpdateManager.CallBacker
{
  le(ld paramld) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 1000L) && (paramString1.startsWith("signature.item.")))
    {
      paramString2 = paramString1.substring("signature.item.".length(), paramString1.length() - 5);
      if (TextUtils.isDigitsOnly(paramString2))
      {
        paramInt2 = Integer.parseInt(paramString2);
        if (ld.a(this.this$0).containsKey(Integer.valueOf(paramInt2)))
        {
          int i = ((Integer)ld.a(this.this$0).get(Integer.valueOf(paramInt2))).intValue();
          paramString2 = new Bundle();
          paramString2.putInt("id", paramInt2);
          paramString2.putInt("notify_type", 7);
          if (paramInt1 != 0) {
            break label273;
          }
          paramString2 = EIPCResult.createResult(0, paramString2);
          this.this$0.callbackResult(i, paramString2);
          ld.a(this.this$0).remove(Integer.valueOf(paramInt2));
        }
      }
    }
    if (ld.b(this.this$0).containsKey(paramString1))
    {
      paramString2 = new Bundle();
      paramString2.putInt("notify_type", 8);
      paramString2.putLong("bid", paramLong);
      paramString2.putString("scid", paramString1);
      if (paramInt1 != 0) {
        break label285;
      }
    }
    label273:
    label285:
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString2.putInt("download_result", paramInt1);
      paramString2 = EIPCResult.createResult(0, paramString2);
      paramInt1 = ((Integer)ld.b(this.this$0).get(paramString1)).intValue();
      this.this$0.callbackResult(paramInt1, paramString2);
      ld.b(this.this$0).remove(paramString1);
      return;
      paramString2 = EIPCResult.createResult(-102, paramString2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     le
 * JD-Core Version:    0.7.0.1
 */