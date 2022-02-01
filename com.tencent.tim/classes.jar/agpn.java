import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import java.util.concurrent.Executor;

public abstract class agpn
  implements agpb, IExcitingTransferRecvListener
{
  protected long ZI = -1L;
  protected agpd a;
  public ahaf a;
  private ExcitingTransferDownloadReqInfo a;
  private boolean mIsStop = true;
  
  public agpn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Agpd = a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
  }
  
  protected abstract agpd a(QQAppInterface paramQQAppInterface);
  
  public abstract void b(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo);
  
  public void clearTask()
  {
    try
    {
      this.mIsStop = true;
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.ZI);
      return;
    }
    finally {}
  }
  
  public void dgu()
  {
    try
    {
      this.mIsStop = false;
      ahav.a.getExecutor().execute(new BaseDownloader.1(this));
      return;
    }
    finally {}
  }
  
  public void dgv()
  {
    clearTask();
    this.jdField_a_of_type_Agpd.diF();
  }
  
  public void dgw()
  {
    clearTask();
    this.jdField_a_of_type_Agpd.diG();
  }
  
  public void dgx()
  {
    clearTask();
  }
  
  protected void download()
  {
    this.ZI = ExcitingTransferEngine.getInstance().recvFileEx(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo, agpf.a().b(), this);
  }
  
  public int getActionType()
  {
    return 1;
  }
  
  public boolean isStop()
  {
    try
    {
      boolean bool = this.mIsStop;
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpn
 * JD-Core Version:    0.7.0.1
 */