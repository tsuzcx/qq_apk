import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.1;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class adnp
  extends SosoInterface.a
{
  adnp(adno paramadno, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onConsecutiveFailure errCode=" + paramInt1 + ", failCount=" + paramInt2);
    }
    if (paramInt2 < 3) {
      return;
    }
    ArkAppCenter.a().post(adno.a(this.this$0), new ArkAppEventObserverManager.1.2(this));
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + paramInt);
    }
    ArkAppCenter.a().post(adno.a(this.this$0), new ArkAppEventObserverManager.1.1(this, paramSosoLbsInfo, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnp
 * JD-Core Version:    0.7.0.1
 */