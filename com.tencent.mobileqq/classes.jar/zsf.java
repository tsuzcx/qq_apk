import android.os.Message;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zsf
  implements INetInfoHandler
{
  private zsf(QQAppInterface paramQQAppInterface) {}
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if (1 == paramInt) {
      this.a.E();
    }
    while (2 != paramInt) {
      return;
    }
    this.a.F();
  }
  
  public void onNetMobile2None()
  {
    a(3, "onNetMobile2None");
    ReportLog.a("Network", "onNetMobile2None()");
    MqqHandler localMqqHandler = this.a.getHandler(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, QQAppInterface.a(this.a).getString(2131433023)).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(28, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().a();
    this.a.getHttpCommunicatort().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.i(this.a) != null) {
      QQAppInterface.j(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(2, "onNetMobile2Wifi");
    ReportLog.a("Network", "onNetMobile2Wifi()");
    MqqHandler localMqqHandler = this.a.getHandler(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().a();
    this.a.getHttpCommunicatort().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.g(this.a) != null) {
      QQAppInterface.h(this.a).onNetMobile2Wifi(paramString);
    }
    this.a.a();
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    ReadInJoyUtils.a(this.a);
    paramString = this.a.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetMobile2Wifi");
      }
      paramString.obtainMessage(5).sendToTarget();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1, "onNetNone2Mobile");
    ReportLog.a("Network", "onNetNone2Mobile()");
    MqqHandler localMqqHandler = this.a.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().a();
    this.a.getHttpCommunicatort().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.a(this.a) != null) {
      QQAppInterface.b(this.a).onNetNone2Mobile(paramString);
    }
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    paramString = this.a.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    NowVideoController.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2, "onNetNone2Wifi");
    ReportLog.a("Network", "onNetNone2Wifi()");
    MqqHandler localMqqHandler = this.a.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().a();
    this.a.getHttpCommunicatort().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.e(this.a) != null) {
      QQAppInterface.f(this.a).onNetNone2Wifi(paramString);
    }
    this.a.a();
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    ReadInJoyUtils.a(this.a);
    paramString = this.a.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Wifi");
      }
      paramString.obtainMessage(5).sendToTarget();
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(1, "onNetWifi2Mobile");
    Object localObject = PresendPicMgrService.a();
    if (localObject != null) {
      ((PresendPicMgrService)localObject).b();
    }
    ReportLog.a("Network", "onNetWifi2Mobile()");
    localObject = this.a.getHandler(FileManagerNotifyCenter.class);
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    localObject = this.a.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10001, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().a();
    this.a.getHttpCommunicatort().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.c(this.a) != null) {
      QQAppInterface.d(this.a).onNetWifi2Mobile(paramString);
    }
    paramString = (EarlyDownloadManager)this.a.getManager(76);
    if (paramString != null) {
      paramString.a();
    }
    paramString = this.a.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetWifi2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    NowVideoController.a().b();
  }
  
  public void onNetWifi2None()
  {
    a(3, "onNetWifi2None");
    ReportLog.a("Network", "onNetWifi2None()");
    MqqHandler localMqqHandler = this.a.getHandler(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, QQAppInterface.b(this.a).getString(2131433023)).sendToTarget();
    }
    localMqqHandler = this.a.getHandler(ChatHistoryForC2C.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(28, null).sendToTarget();
    }
    FMTSrvAddrProvider.a().a();
    SosoSrvAddrProvider.a().a();
    this.a.getHttpCommunicatort().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.k(this.a) != null) {
      QQAppInterface.l(this.a).onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsf
 * JD-Core Version:    0.7.0.1
 */