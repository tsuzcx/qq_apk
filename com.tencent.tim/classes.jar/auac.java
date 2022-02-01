import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class auac
  implements INetEventHandler
{
  auac(auaa paramauaa) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (AppNetConnInfo.isWifiConn())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel[MPFile]", 2, "网络切换到Wifi网络");
      }
      QQToast.a(this.a.mContext, 2131696014, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auac
 * JD-Core Version:    0.7.0.1
 */