import com.tencent.qphone.base.util.QLog;

class atuj
  extends atsn
{
  atuj(atuh paramatuh) {}
  
  protected void jh(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("FMObserver<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    atul localatul;
    do
    {
      return;
      localatul = this.this$0.a(paramLong);
      if (localatul == null)
      {
        QLog.e("FMObserver<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localatul.dhW();
    } while (!localatul.alI());
    this.this$0.jp(paramLong);
  }
  
  protected void ji(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("FMObserver<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    atul localatul;
    do
    {
      return;
      localatul = this.this$0.a(paramLong);
      if (localatul == null)
      {
        QLog.e("FMObserver<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localatul.dhY();
    } while (!localatul.alI());
    this.this$0.jp(paramLong);
  }
  
  protected void jj(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("FMObserver<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    atul localatul;
    do
    {
      return;
      localatul = this.this$0.a(paramLong);
      if (localatul == null)
      {
        QLog.e("FMObserver<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localatul.dia();
    } while (!localatul.alI());
    this.this$0.jp(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuj
 * JD-Core Version:    0.7.0.1
 */