import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class wuj
  extends achq
{
  wuj(wuc paramwuc) {}
  
  public void CP(int paramInt)
  {
    if ((wuc.a(this.this$0).cZ == 0) || (wuc.a(this.this$0).cZ == 3000) || (wuc.a(this.this$0).cZ == 1)) {
      wuc.a(this.this$0, paramInt);
    }
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORevokeMsgHelper", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((wuc.a(this.this$0) == null) || (wuc.a(this.this$0) == null) || (!paramBoolean)) {
      return;
    }
    ((abhe)wuc.a(this.this$0).getManager(211)).t(3, wuc.a(this.this$0).aTl, wuc.a(this.this$0).cZ);
  }
  
  public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = wuc.a(this.this$0).a().awx();
    wuc.a(this.this$0).getUIHandler().removeMessages(267387140);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)localIterator.next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + localArrayList.size());
    }
    wuc.a(this.this$0, paramBoolean1, paramBoolean2, bool, localArrayList);
    super.b(paramBoolean1, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuj
 * JD-Core Version:    0.7.0.1
 */