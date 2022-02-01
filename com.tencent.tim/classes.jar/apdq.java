import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apdq
  extends VasQuickUpdateManager.CallBacker
{
  apdq(apdj paramapdj) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_")) && (paramInt1 == 0))
    {
      paramInt1 = apdj.eL(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + paramInt1);
      }
      if (paramInt1 > 0)
      {
        paramString1 = (apdj.a)this.this$0.dB.get(paramInt1);
        this.this$0.dB.remove(paramInt1);
        if (paramString1 == null) {
          break label154;
        }
        if (aptj.E(new File(apdj.cou + paramInt1))) {
          this.this$0.mHandler.post(new TroopEnterEffectController.4.1(this, paramInt1, paramString1));
        }
      }
    }
    return;
    label154:
    QLog.e("TroopEnterEffect.Controller", 1, "mResDownloadCallback effectData = null id = " + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdq
 * JD-Core Version:    0.7.0.1
 */