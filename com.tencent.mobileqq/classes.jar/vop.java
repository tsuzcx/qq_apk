import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class vop
  implements zwr<QCircleFollowUpdateEvent>
{
  private final Handler a;
  
  private vop(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public ArrayList<Class<QCircleFollowUpdateEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (!(paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) {}
    do
    {
      return;
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      QLog.i("QCircleSpecialFollowMgr", 4, "onReceiveEvent: QCircleFollowUpdateEvent " + paramSimpleBaseEvent.mUserId + " " + paramSimpleBaseEvent.mFollowStatus);
    } while (paramSimpleBaseEvent.mFollowStatus != 0);
    this.a.obtainMessage(1002, paramSimpleBaseEvent.mUserId).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vop
 * JD-Core Version:    0.7.0.1
 */