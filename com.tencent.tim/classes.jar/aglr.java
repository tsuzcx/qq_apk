import com.tencent.qphone.base.util.QLog;

class aglr
  extends aghq
{
  aglr(aglp paramaglp) {}
  
  protected void jh(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    aglt localaglt;
    do
    {
      return;
      localaglt = this.this$0.a(paramLong);
      if (localaglt == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localaglt.dhW();
    } while (!localaglt.alI());
    this.this$0.jp(paramLong);
  }
  
  protected void ji(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    aglt localaglt;
    do
    {
      return;
      localaglt = this.this$0.a(paramLong);
      if (localaglt == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localaglt.dhY();
    } while (!localaglt.alI());
    this.this$0.jp(paramLong);
  }
  
  protected void jj(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    aglt localaglt;
    do
    {
      return;
      localaglt = this.this$0.a(paramLong);
      if (localaglt == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localaglt.dia();
    } while (!localaglt.alI());
    this.this$0.jp(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aglr
 * JD-Core Version:    0.7.0.1
 */