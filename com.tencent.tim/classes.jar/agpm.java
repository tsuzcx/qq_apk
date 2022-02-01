import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;

public abstract interface agpm
{
  public abstract void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo);
  
  public abstract void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete);
  
  public abstract void a(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo);
  
  public abstract void diH();
  
  public abstract void s(long paramLong1, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpm
 * JD-Core Version:    0.7.0.1
 */