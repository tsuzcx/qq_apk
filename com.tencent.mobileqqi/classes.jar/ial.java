import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QLAndQQStructDef.ReportNbFileFileSendInfo;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkReport;
import cooperation.qlink.QlinkServiceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimerTask;

public class ial
  extends TimerTask
{
  public ial(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ Trans2InvaildTimer run...");
    }
    Object localObject1 = QQProxyForQlink.a(this.a);
    long l1 = MessageCache.a() * 1000L;
    int i;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        long l2 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
        if (l1 - ((Long)((Map.Entry)localObject2).getValue()).longValue() > 480000L)
        {
          FileManagerEntity localFileManagerEntity = QQProxyForQlink.a(this.a).a().a(l2);
          if ((localFileManagerEntity != null) && (localFileManagerEntity.status == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + l2 + "]Trans2InvaildTimer run...  is failed timeout.Failed2Invaild");
            }
            localFileManagerEntity.status = 16;
            QQProxyForQlink.a(this.a).a().c(localFileManagerEntity);
            QQProxyForQlink.a(this.a).a().a(true, 0, null);
            QQProxyForQlink.a(this.a, l2);
          }
        }
        if (l1 - ((Long)((Map.Entry)localObject2).getValue()).longValue() > 480000L)
        {
          localObject2 = QQProxyForQlink.a(this.a).a().a(l2);
          if ((localObject2 != null) && (18 == ((FileManagerEntity)localObject2).status) && (((FileManagerEntity)localObject2).bSend))
          {
            if (QLog.isColorLevel()) {
              QLog.w("QQProxyForQlink", 2, "[QLINK]-QQ [" + l2 + "]Trans2InvaildTimer run...   msg of sending wait be recviced too long. 2 invaild!!!!");
            }
            ((FileManagerEntity)localObject2).status = 16;
            ((FileManagerEntity)localObject2).errCode = -207;
            QQProxyForQlink.a(this.a).a().c((FileManagerEntity)localObject2);
            QQProxyForQlink.a(this.a).a().a(true, 0, null);
            QQProxyForQlink.a(this.a, l2);
            QQProxyForQlink.a(this.a).a().a(l2);
            if (((FileManagerEntity)localObject2).qlmsgSrc != 0) {}
            for (i = ((FileManagerEntity)localObject2).qlmsgSrc;; i = QQProxyForQlink.a(this.a, ((FileManagerEntity)localObject2).nSessionId))
            {
              i = QlinkReport.a(i);
              QQProxyForQlink.b(this.a, ((FileManagerEntity)localObject2).nSessionId);
              QQProxyForQlink.a(this.a, false, new QLAndQQStructDef.ReportNbFileFileSendInfo(false, ((FileManagerEntity)localObject2).errCode, i, ((FileManagerEntity)localObject2).fileSize, ((FileManagerEntity)localObject2).fileName, 0L, 0L, 0L, null, 0, String.valueOf(((FileManagerEntity)localObject2).nSessionId), null, null, null));
              break;
            }
          }
        }
      }
      if (QQProxyForQlink.a(this.a) != 0) {
        break label544;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQProxyForQlink", 2, "[QLINK]-QQ Trans2InvaildTimer run... stop it");
        }
        QQProxyForQlink.a(this.a);
      }
      return;
      i = 1;
      continue;
      label544:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ial
 * JD-Core Version:    0.7.0.1
 */