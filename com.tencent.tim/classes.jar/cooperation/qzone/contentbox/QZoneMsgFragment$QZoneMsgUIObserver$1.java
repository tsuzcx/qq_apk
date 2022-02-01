package cooperation.qzone.contentbox;

import android.os.Handler;
import avtk;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.provider.LocalPhotoGroupData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class QZoneMsgFragment$QZoneMsgUIObserver$1
  implements Runnable
{
  QZoneMsgFragment$QZoneMsgUIObserver$1(QZoneMsgFragment.a parama, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    MQMsg localMQMsg;
    Object localObject;
    if ((this.a.ArkNes_vec != null) && (this.a.ArkNes_vec.size() != 0))
    {
      localMQMsg = (MQMsg)this.a.ArkNes_vec.get(0);
      if (localMQMsg.msgType == 9)
      {
        localObject = LocalPhotoGroupData.getLocalPhotoGroupDataFromSp(localMQMsg.pushTime);
        if (QZoneMsgFragment.a(this.b.this$0) != null) {
          if (localObject == null) {
            QZoneMsgFragment.a(this.b.this$0).saveSp(localMQMsg.pushTime);
          }
        }
        for (;;)
        {
          if (QZoneMsgFragment.a(this.b.this$0) == null) {
            break label421;
          }
          localMQMsg.uniKey = QZoneMsgFragment.a(this.b.this$0).unikey;
          localMQMsg.eventTitle = QZoneMsgFragment.a(this.b.this$0).title;
          localMQMsg.capTime = QZoneMsgFragment.a(this.b.this$0).capTime;
          if (localMQMsg.msgBody.photolist == null) {
            localMQMsg.msgBody.photolist = new ArrayList();
          }
          if (localMQMsg.msgBody == null)
          {
            localMQMsg.msgBody = new MQMsgBody();
            localMQMsg.msgBody.photolist.clear();
          }
          if (QZoneMsgFragment.a(this.b.this$0).pathList == null) {
            break label429;
          }
          int i = 0;
          while (i < QZoneMsgFragment.a(this.b.this$0).pathList.size())
          {
            localObject = new MQPhotoCell();
            ((MQPhotoCell)localObject).coverUrl = ((String)QZoneMsgFragment.a(this.b.this$0).pathList.get(i));
            localMQMsg.msgBody.photolist.add(localObject);
            i += 1;
          }
          QZoneMsgFragment.a(this.b.this$0, (LocalPhotoGroupData)localObject);
          continue;
          QZoneMsgFragment.a(this.b.this$0, (LocalPhotoGroupData)localObject);
        }
      }
    }
    for (;;)
    {
      if (localMQMsg == null)
      {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "rsp.ArkNes_vec.get(0) == null");
        label336:
        if ((!QZoneMsgFragment.b(this.b.this$0)) || (localMQMsg == null)) {
          break label665;
        }
        if ((localMQMsg.msgType != 9) || (QZoneMsgFragment.a(this.b.this$0) != null)) {
          break label638;
        }
        this.b.this$0.a.fs(new ArrayList());
      }
      for (;;)
      {
        QZoneMsgFragment.a(this.b.this$0).postDelayed(new QZoneMsgFragment.QZoneMsgUIObserver.1.1(this), 500L);
        return;
        label421:
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "mLocalPhotoGroupData == null");
        label429:
        break;
        if (!QLog.isColorLevel()) {
          break label336;
        }
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsgs: MQMsg{\nmsgType='" + localMQMsg.msgType + '\'' + '\n' + ", title=" + localMQMsg.title + '\'' + '\n' + ", eventTitle='" + localMQMsg.eventTitle + '\'' + '\n' + ", uniKey='" + localMQMsg.uniKey + '\'' + '\n' + '}');
        if ((localMQMsg.msgBody != null) && (localMQMsg.msgBody.photolist != null))
        {
          localObject = localMQMsg.msgBody.photolist.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MQPhotoCell localMQPhotoCell = (MQPhotoCell)((Iterator)localObject).next();
            QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: cell.coverUrl=" + localMQPhotoCell.coverUrl);
          }
          break label336;
        }
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: mqMsg.msgBody.photolist==null");
        break label336;
        label638:
        this.b.this$0.a.fs(new ArrayList(Collections.singletonList(localMQMsg)));
        continue;
        label665:
        this.b.this$0.a.a(localMQMsg);
      }
      localMQMsg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.QZoneMsgUIObserver.1
 * JD-Core Version:    0.7.0.1
 */