import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;

public class ffa
  implements INetInfoHandler
{
  public ffa(QQAppInterface paramQQAppInterface) {}
  
  private void a()
  {
    NetworkCenter.a().b();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if (1 == paramInt) {
      this.a.I();
    }
    while (2 != paramInt) {
      return;
    }
    this.a.J();
  }
  
  public void onNetMobile2None()
  {
    a(3, "onNetMobile2None");
    ReportLog.a("Network", "onNetMobile2None()");
    Handler localHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, QQAppInterface.a(this.a).getString(2131562452)).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi()
  {
    a(2, "onNetMobile2Wifi");
    ReportLog.a("Network", "onNetMobile2Wifi()");
    Handler localHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetMobile2Wifi();
    }
  }
  
  public void onNetNone2Mobile()
  {
    a(1, "onNetNone2Mobile");
    ReportLog.a("Network", "onNetNone2Mobile()");
    Handler localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(ChatHistory.class);
    if (localHandler != null) {
      localHandler.obtainMessage(6, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(2);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetNone2Mobile();
    }
  }
  
  public void onNetNone2Wifi()
  {
    a(2, "onNetNone2Wifi");
    ReportLog.a("Network", "onNetNone2Wifi()");
    Handler localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(ChatHistory.class);
    if (localHandler != null) {
      localHandler.obtainMessage(6, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetNone2Wifi();
    }
  }
  
  public void onNetWifi2Mobile()
  {
    a(1, "onNetWifi2Mobile");
    ReportLog.a("Network", "onNetWifi2Mobile()");
    Handler localHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(2);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetWifi2Mobile();
    }
  }
  
  public void onNetWifi2None()
  {
    a(3, "onNetWifi2None");
    ReportLog.a("Network", "onNetWifi2None()");
    Handler localHandler = this.a.a(FileManagerNotifyCenter.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, null).sendToTarget();
    }
    localHandler = this.a.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(10001, QQAppInterface.b(this.a).getString(2131562452)).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    QQAppInterface.a(this.a);
    this.a.a().a(1);
    a();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.a(this.a).onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffa
 * JD-Core Version:    0.7.0.1
 */