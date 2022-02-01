import com.tencent.qphone.base.util.QLog;

public class adap
{
  private static adap a;
  
  public static adap a()
  {
    if (a == null) {
      a = new adap();
    }
    return a;
  }
  
  public void ah(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_选图_启动累计耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong2 - paramLong1) }));
    }
  }
  
  public void ai(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("QR_识别_启动累计耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong2 - paramLong1) }));
    }
  }
  
  public void iu(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_选图_单帧耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void iv(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_识别_单帧耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void iw(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_追踪_单帧耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void ix(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("人脸_特征提取_单帧耗时 time cost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void iy(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("人脸_追踪_单帧耗时 time cost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adap
 * JD-Core Version:    0.7.0.1
 */