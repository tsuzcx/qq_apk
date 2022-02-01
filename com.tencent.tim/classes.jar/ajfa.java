import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class ajfa
  extends ajdu
{
  public ajfa(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void Kt(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmTokenResponse:  isSuccess: " + paramBoolean);
    }
    super.Kt(paramBoolean);
  }
  
  public void Ku(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onRejectQRResponse:  isSuccess: " + paramBoolean);
    }
    super.Ku(paramBoolean);
  }
  
  public void a(boolean paramBoolean, ajev paramajev)
  {
    if (paramBoolean) {
      this.this$0.a(paramajev);
    }
    super.a(paramBoolean, paramajev);
  }
  
  public void bn(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    Object localObject;
    if ((paramBoolean) && ((paramObject instanceof ajer)))
    {
      localObject = (ajer)paramObject;
      this.this$0.a((ajer)localObject);
    }
    for (;;)
    {
      super.bn(paramBoolean, paramObject);
      return;
      if ((paramObject instanceof Integer))
      {
        localObject = (Integer)paramObject;
        this.this$0.m((Integer)localObject);
      }
    }
  }
  
  public void bo(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    this.this$0.bC(paramBoolean, paramObject);
    super.bo(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfa
 * JD-Core Version:    0.7.0.1
 */