package wf7;

import android.os.Looper;
import android.os.Message;

class db$2
  extends bt
{
  db$2(db paramdb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    ca.startScan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.db.2
 * JD-Core Version:    0.7.0.1
 */