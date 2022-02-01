import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class ambn
  implements ambp.b
{
  ambn(ambm paramambm) {}
  
  public void aS(long paramLong, int paramInt)
  {
    QLog.d(ambm.TAG, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
  
  public void kW(long paramLong)
  {
    Iterator localIterator = ambm.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      ambi localambi = (ambi)localIterator.next();
      if ((paramLong != localambi.mUniseq) || (!ambm.a(this.a).aN(localambi.H))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(ambm.TAG, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambn
 * JD-Core Version:    0.7.0.1
 */