import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class ambo
  extends achq
{
  ambo(ambm paramambm) {}
  
  public void a(boolean paramBoolean, long paramLong, achq.a parama)
  {
    if (ambm.a(this.a) == null)
    {
      QLog.d(ambm.TAG, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    ambi localambi = (ambi)ambm.a(this.a).peek();
    if (localambi != null) {
      if ((paramLong == localambi.mUniseq) && (localambi.dBD == 4))
      {
        localambi.dBD = 5;
        ambm.a(this.a).remove(localambi);
        if (localambi.mMsgObserver != null) {
          localambi.mMsgObserver.a(paramBoolean, paramLong, parama);
        }
        if (localambi.a != null) {
          localambi.a.O(paramBoolean, paramLong);
        }
        if (localambi.mNeedCompress) {
          angw.a().removeTask(paramLong);
        }
        ambm.a(this.a).kZ(localambi.mUniseq);
        if (QLog.isColorLevel())
        {
          parama = new StringBuilder();
          parama.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(ambm.a(this.a).size()).append(", mNeedCompress:").append(localambi.mNeedCompress).append(", issuccess:").append(paramBoolean);
          QLog.d(ambm.TAG, 2, parama.toString());
        }
      }
    }
    for (;;)
    {
      ambm.a(this.a);
      return;
      QLog.d(ambm.TAG, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localambi.dBD), ", uniseq:", Long.valueOf(localambi.mUniseq) });
      continue;
      QLog.d(ambm.TAG, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambo
 * JD-Core Version:    0.7.0.1
 */