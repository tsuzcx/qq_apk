import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class ihs
{
  public static String TAG = "AvAddFriendService";
  boolean PG = false;
  acfd a = new iht(this);
  int amf = 0;
  achq b = new ihu(this);
  public HashMap<String, ihs.a> cx = new HashMap();
  QQAppInterface mApp = null;
  
  public ihs(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "AvAddFriendLogic");
    }
    this.mApp = paramQQAppInterface;
    this.mApp.addObserver(this.b);
    this.mApp.addObserver(this.a);
  }
  
  private void W(String paramString, int paramInt)
  {
    if (!this.cx.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "setRelationStatus no uin in map:" + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setRelationStatus :" + paramString + ",status" + paramInt);
    }
    ((ihs.a)this.cx.get(paramString)).amh = paramInt;
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      anzd.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      anzd.a().lC(l);
      anzd.a().lB(paramLong);
    }
  }
  
  private boolean c(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (paramString.equals(this.mApp.getCurrentAccountUin())) {
      return false;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        acff localacff = (acff)this.mApp.getManager(51);
        if (localacff != null)
        {
          paramString = localacff.e(paramString);
          if ((paramString == null) || (paramString.groupid < 0)) {
            break;
          }
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      paramString = null;
    }
    return true;
  }
  
  private void i(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.cx.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "setRelationStatus no uin in map:" + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setRelationStatus :" + paramString + ",status" + paramInt1 + ",safeStatus:" + paramInt2);
    }
    ((ihs.a)this.cx.get(paramString)).amh = paramInt1;
    ((ihs.a)this.cx.get(paramString)).amh = paramInt2;
  }
  
  private void iu(String paramString)
  {
    if (this.mApp.getBusinessHandler(1) != null) {
      ((FriendListHandler)this.mApp.getBusinessHandler(1)).j(paramString, this.amf, 0, "");
    }
  }
  
  public int ai(String paramString)
  {
    if (!this.cx.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getRelationStatus no uin in map:" + paramString);
      }
      return 0;
    }
    return ((ihs.a)this.cx.get(paramString)).amh;
  }
  
  public boolean d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "addFriend uin is null");
      }
      return false;
    }
    this.amf = paramInt;
    if (((acff)this.mApp.getManager(51)).isFriend(paramString))
    {
      locala = new ihs.a();
      this.cx.put(paramString, locala);
      W(paramString, 4);
      ir(paramString);
      return true;
    }
    if (!c(1, paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "addFriend uin" + paramString);
    }
    ihs.a locala = new ihs.a();
    this.cx.put(paramString, locala);
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).l("OidbSvc.0x476_147", Long.parseLong(paramString), 147);
    return true;
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "finalize");
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  void ir(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.AddfrindMsg");
    localIntent.putExtra("peerUin", paramString);
    if (this.mApp != null) {
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void is(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.cx.clear();
    }
    while (!this.cx.containsKey(paramString)) {
      return;
    }
    this.cx.remove(paramString);
  }
  
  public void it(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "acceptAddFriend uin is null");
      }
    }
    label514:
    do
    {
      List localList;
      structmsg.StructMsg localStructMsg;
      do
      {
        do
        {
          return;
          new ArrayList();
          localList = this.mApp.b().k(acbn.bkJ, 0);
          localStructMsg = null;
          if (localList != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(TAG, 2, "systemMsgList is null");
        return;
        if ((localList.size() <= 0) || ((localList.get(0) instanceof MessageForSystemMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "systemMsgList error");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "answerAddFriend systemMsgList size" + localList.size());
      }
      int i = localList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localStructMsg = ((MessageForSystemMsg)localList.get(i)).getSystemMsg();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(localStructMsg.req_uin.get()) + "friendUin=" + paramString);
          }
          if (!paramString.equals(String.valueOf(localStructMsg.req_uin.get()))) {}
        }
        else
        {
          if ((localStructMsg == null) || (!paramString.equals(String.valueOf(localStructMsg.req_uin.get())))) {
            break label514;
          }
          i = localStructMsg.msg_type.get();
          long l1 = localStructMsg.msg_seq.get();
          long l2 = localStructMsg.req_uin.get();
          int j = localStructMsg.msg.sub_type.get();
          int k = localStructMsg.msg.src_id.get();
          int m = localStructMsg.msg.sub_src_id.get();
          int n = localStructMsg.msg.group_msg_type.get();
          paramString = localStructMsg.msg.actions.get();
          if ((paramString == null) || (paramString.size() >= 0)) {
            break;
          }
          paramString = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramString.get(0)).action_info.get();
          paramString.remark.set("");
          paramString.group_id.set(0);
          this.mApp.a().a().a(i, l1, l2, j, k, m, n, paramString, 0, localStructMsg, false);
          a(localStructMsg, localStructMsg.msg_seq.get());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(TAG, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(localStructMsg.req_uin.get()));
          return;
        }
        i -= 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "AvAddFriendLogic onDestory");
    }
    this.cx.clear();
    this.mApp.removeObserver(this.b);
    this.mApp.removeObserver(this.a);
    this.mApp = null;
  }
  
  class a
  {
    public int amg = 0;
    public int amh = 0;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ihs
 * JD-Core Version:    0.7.0.1
 */