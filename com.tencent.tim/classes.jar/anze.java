import android.content.SharedPreferences;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.1;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.2;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.3;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class anze
{
  private static volatile anze a;
  private final String TAG = anze.class.getName();
  private String aDd;
  private long aof = -1L;
  private long aog = -1L;
  private boolean cKO;
  private MessageHandler d;
  private int dNC = -1;
  private int dND = -1;
  private structmsg.StructMsg e;
  private Object fb = new Object();
  private HashMap<Long, structmsg.StructMsg> nI = new HashMap();
  private HashMap<Long, Long> nJ = new HashMap();
  
  public static anze a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anze();
      }
      return a;
    }
    finally {}
  }
  
  private int ad(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_Group_system_msg", 0);
    }
    return i;
  }
  
  private int ae(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_Group_suspicious_msg", 0);
    }
    return i;
  }
  
  public String G(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getString("group_display", "");
    }
    return "";
  }
  
  public void N(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.dNC = paramInt;
    paramQQAppInterface.execute(new GroupSystemMsgController.1(this, paramQQAppInterface, paramInt));
  }
  
  public void O(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.dND = paramInt;
    paramQQAppInterface.execute(new GroupSystemMsgController.2(this, paramQQAppInterface, paramInt));
  }
  
  public structmsg.StructMsg a()
  {
    return this.e;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.nI != null) {
      localStructMsg = (structmsg.StructMsg)this.nI.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.fb;
    long l = 0L;
    try
    {
      if (this.nJ.containsKey(Long.valueOf(paramLong1))) {
        l = ((Long)this.nJ.get(Long.valueOf(paramLong1))).longValue();
      }
      if (l >= paramLong2) {
        return;
      }
      this.nJ.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "addSystemMsgOldData " + paramLong1 + " " + paramLong2);
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      if (paramQQAppInterface == null) {
        return;
      }
    }
    finally {}
    GroupSystemMsgOldData localGroupSystemMsgOldData = new GroupSystemMsgOldData();
    localGroupSystemMsgOldData.uin = paramLong1;
    localGroupSystemMsgOldData.msgtime = paramLong2;
    paramQQAppInterface.persistOrReplace(localGroupSystemMsgOldData);
    paramQQAppInterface.close();
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.nI != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "putStructMsgToMap key=" + paramLong);
      }
      this.nI.put(paramLong, paramStructMsg);
    }
  }
  
  public void aM(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.execute(new GroupSystemMsgController.3(this, paramQQAppInterface, paramString));
  }
  
  public int af(QQAppInterface paramQQAppInterface)
  {
    if (this.dNC == -1) {
      this.dNC = ad(paramQQAppInterface);
    }
    return this.dNC;
  }
  
  public int ag(QQAppInterface paramQQAppInterface)
  {
    if (this.dND == -1) {
      this.dND = ae(paramQQAppInterface);
    }
    return this.dND;
  }
  
  public void c(structmsg.StructMsg paramStructMsg)
  {
    this.e = paramStructMsg;
  }
  
  public void c(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.cKO = paramBoolean;
    this.aDd = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface.execute(new GroupSystemMsgController.4(this, paramQQAppInterface, paramBoolean));
  }
  
  public void dTX()
  {
    this.dNC = -1;
    this.d = null;
    try
    {
      a = null;
      return;
    }
    finally {}
  }
  
  public void dTY()
  {
    if (this.nI != null) {
      this.nI.clear();
    }
  }
  
  public void eh(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.query(GroupSystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GroupSystemMsgOldData localGroupSystemMsgOldData = (GroupSystemMsgOldData)((Iterator)localObject).next();
        this.nJ.put(Long.valueOf(localGroupSystemMsgOldData.uin), Long.valueOf(localGroupSystemMsgOldData.msgtime));
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "initSystemMsgOldData " + localGroupSystemMsgOldData.uin + " " + localGroupSystemMsgOldData.msgtime);
        }
      }
    }
    paramQQAppInterface.close();
  }
  
  public long he()
  {
    return this.aog;
  }
  
  public long hf()
  {
    return this.aof;
  }
  
  public void lB(long paramLong)
  {
    this.aog = paramLong;
  }
  
  public void lC(long paramLong)
  {
    this.aof = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anze
 * JD-Core Version:    0.7.0.1
 */