import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARRecordReport.1;
import com.tencent.mobileqq.ar.ARRecord.ARRecordReport.2;
import com.tencent.mobileqq.ar.ARRecord.ARRecordReport.3;
import com.tencent.mobileqq.ar.ARRecord.ARRecordReport.4;
import com.tencent.qphone.base.util.QLog;

public class adcg
{
  private static adcg a;
  
  public static adcg a()
  {
    if (a == null) {
      a = new adcg();
    }
    return a;
  }
  
  public void FU(boolean paramBoolean)
  {
    QLog.d("ARRecordReport", 2, String.format("reportActiveRecordStart inPreRecord=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    ThreadManager.post(new ARRecordReport.2(this, paramBoolean), 5, null, false);
  }
  
  public void Kz(int paramInt)
  {
    QLog.d("ARRecordReport", 2, String.format("reportRecordFail failType=%s", new Object[] { Integer.valueOf(paramInt) }));
    ThreadManager.post(new ARRecordReport.4(this, paramInt), 5, null, false);
  }
  
  public void ac(int paramInt, long paramLong)
  {
    QLog.d("ARRecordReport", 2, String.format("reportRecordSuccess successType=%s videoLength=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    ThreadManager.post(new ARRecordReport.3(this, paramInt, paramLong), 5, null, false);
  }
  
  public void cPX()
  {
    QLog.d("ARRecordReport", 2, "reportPreRecordStart");
    ThreadManager.post(new ARRecordReport.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcg
 * JD-Core Version:    0.7.0.1
 */