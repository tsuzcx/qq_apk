import android.os.SystemClock;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class acmu
  extends aczc.b
{
  acmu(acms paramacms, String paramString1, long paramLong, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "onLocationFinish, time=" + (l - this.QT) + "ms");
    }
    if (paramInt != 0) {
      QLog.i("TroopHandler", 1, "getDetailOnlineMemberList, startLocation, errorCode=" + paramInt);
    }
    acms.a(this.this$0, this.Uf, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmu
 * JD-Core Version:    0.7.0.1
 */