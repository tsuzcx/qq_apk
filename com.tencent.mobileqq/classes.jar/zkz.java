import android.os.SystemClock;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class zkz
  extends SosoInterface.OnLocationListener
{
  public zkz(TroopHandler paramTroopHandler, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString1, long paramLong2, String paramString2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "onLocationFinish, time=" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    if (paramInt != 0) {
      QLog.i("TroopHandler", 1, "getDetailOnlineMemberList, startLocation, errorCode=" + paramInt);
    }
    TroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler, this.jdField_a_of_type_JavaLangString, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkz
 * JD-Core Version:    0.7.0.1
 */