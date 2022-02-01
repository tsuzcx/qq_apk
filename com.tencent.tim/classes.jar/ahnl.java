import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class ahnl
  extends ajdu
{
  public ahnl(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void Kt(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! is success");
    }
    for (;;)
    {
      super.Kt(paramBoolean);
      return;
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! confirm token is failed!");
    }
  }
  
  public void Ku(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! is success");
    }
    for (;;)
    {
      super.Ku(paramBoolean);
      return;
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! reject qr is failed!");
    }
  }
  
  public void a(boolean paramBoolean, ajev paramajev)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.this$0, paramajev);
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! qrStateResponse = " + MsgBackupSettingFragment.a(this.this$0));
    }
    for (;;)
    {
      super.a(paramBoolean, paramajev);
      return;
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! query qr state is failed!");
    }
  }
  
  public void bn(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof ajer)))
    {
      MsgBackupSettingFragment.a = (ajer)paramObject;
      QLog.d("MsgBackup", 1, "onGetQrResponse called! qrResponse = " + MsgBackupSettingFragment.a);
    }
    for (;;)
    {
      super.bn(paramBoolean, paramObject);
      return;
      QLog.d("MsgBackup", 1, "onGetQrResponse called! request qrCode is failed!");
    }
  }
  
  public void bo(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.this$0, (ajeo)paramObject);
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! qrConfirmReponse = " + MsgBackupSettingFragment.a(this.this$0));
    }
    for (;;)
    {
      super.bo(paramBoolean, paramObject);
      return;
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! confirm qrCode is failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnl
 * JD-Core Version:    0.7.0.1
 */