import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.ShuayishuaConfig;
import com.tencent.mobileqq.olympic.TorchInfo;
import com.tencent.qphone.base.util.QLog;

public class akpw
  extends akpx
{
  public akpw(OlympicManager paramOlympicManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, TorchInfo paramTorchInfo, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      OlympicManager localOlympicManager = this.this$0;
      QLog.i("OlympicManager", 2, "onGetMyTorchInfo.isSuccess=" + paramBoolean + ",errCode=" + paramInt1 + ",errStr=,info=" + paramTorchInfo);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte, TorchInfo paramTorchInfo)
  {
    if (QLog.isColorLevel())
    {
      OlympicManager localOlympicManager = this.this$0;
      QLog.i("OlympicManager", 2, "onCollectTorch.isSuccess=" + paramBoolean + ",errCode=" + paramInt + ",errStr=" + paramString + ",sig=" + paramArrayOfByte + ",info=" + paramTorchInfo);
    }
    OlympicManager.a(this.this$0, false);
    if (paramBoolean)
    {
      OlympicManager.a(this.this$0, paramArrayOfByte);
      if (paramInt == 0)
      {
        anot.a(this.this$0.mApp, "CliOper", "", "", "0X80069C8", "0X80069C8", 0, 0, "", "", "", "");
        this.this$0.Sj(1);
        this.this$0.b(paramTorchInfo);
        OlympicManager.b(this.this$0).obtainMessage(6).sendToTarget();
        OlympicManager.b(this.this$0).obtainMessage(5).sendToTarget();
        paramArrayOfByte = Long.valueOf(-1L);
        paramString = paramArrayOfByte;
        if (OlympicManager.a(this.this$0) != null)
        {
          paramString = paramArrayOfByte;
          if (OlympicManager.a(this.this$0).type == 2) {
            paramString = Long.valueOf(OlympicManager.a(this.this$0).uiBegin);
          }
        }
        OlympicManager.a(this.this$0).obtainMessage(7, paramString).sendToTarget();
      }
    }
    else
    {
      return;
    }
    if (paramInt == 1)
    {
      this.this$0.Sj(1);
      OlympicManager.b(this.this$0).obtainMessage(6).sendToTarget();
      OlympicManager.b(this.this$0).obtainMessage(5).sendToTarget();
      return;
    }
    OlympicManager.b(this.this$0, false);
    OlympicManager.b(this.this$0, null);
    OlympicManager.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpw
 * JD-Core Version:    0.7.0.1
 */