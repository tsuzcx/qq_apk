import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework.a;

class aszm
  implements QSecFramework.a
{
  aszm(aszl paramaszl) {}
  
  public int b(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof String)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.Rpt", 2, String.format("Op: %d, Rid: %d, val: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), (String)paramObject1 }));
      }
      this.b.a((int)paramLong1, (int)paramLong2, (String)paramObject1);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszm
 * JD-Core Version:    0.7.0.1
 */