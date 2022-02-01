import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class too
  extends acxq
{
  private apav jdField_a_of_type_Apav;
  private tom jdField_a_of_type_Tom;
  private volatile boolean aQb;
  private apav jdField_b_of_type_Apav;
  private ton jdField_b_of_type_Ton;
  private apav c;
  private volatile boolean hasInit;
  
  public too(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, tom paramtom)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Tom = paramtom;
    this.jdField_b_of_type_Ton = new ton(paramQQAppInterface, paramProxyManager, paramtom);
    this.jdField_a_of_type_Apav = new apav(paramQQAppInterface, paramProxyManager, paramtom);
    this.jdField_b_of_type_Apav = new apav(paramQQAppInterface, paramProxyManager, paramtom);
    this.c = new apav(paramQQAppInterface, paramProxyManager, paramtom);
  }
  
  public ton b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_b_of_type_Ton;
    case 1: 
      return this.jdField_a_of_type_Apav;
    case 3000: 
      return this.jdField_b_of_type_Apav;
    }
    return this.c;
  }
  
  public void bEx()
  {
    int j = 0;
    if (!this.aQb) {}
    for (;;)
    {
      List localList1;
      anpc.e locale1;
      long l1;
      long l2;
      try
      {
        if (!this.aQb)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMsgProxyContainer", 2, "init_lazy");
          }
          localList1 = ((ProxyManager)this.app.getManager(18)).a().q(true);
          if (localList1 == null) {
            return;
          }
          locale1 = new anpc.e();
          locale1.dKX = 0;
          locale1.cfO = "select";
          locale1.cfP = "launch";
          l1 = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 40)) {
          break label373;
        }
        l2 = System.currentTimeMillis();
        QLog.d("Q.msg.BaseMsgProxyContainer_" + MsgLruCache.TAG, 1, new Object[] { "INIT_LAZY cost: ", Long.valueOf(l2 - l1), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j) });
      }
      catch (Exception localException)
      {
        int m;
        continue;
      }
      this.aQb = true;
      Object localObject1;
      if ((locale1.dKY != 0) && (anpc.ayC()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(locale1.dKX));
        ((HashMap)localObject1).put("param_OptType", locale1.cfO);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(locale1.ant));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(locale1.dKY));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(locale1.dKZ));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(locale1.anu));
        ((HashMap)localObject1).put("param_OptScene", locale1.cfP);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, locale1.dKZ, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label373:
      if (((RecentUser)localList1.get(k)).getType() == 6000)
      {
        m = i;
        i = j;
        j = m;
      }
      else
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (acbn.bkK.equals(((RecentUser)localList1.get(k)).uin))) {
          anze.a().eh(this.app);
        }
        localObject1 = this.jdField_a_of_type_Tom.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        for (;;)
        {
          try
          {
            List localList2 = b(((RecentUser)localList1.get(k)).getType()).c(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), locale2);
            if ((localList2 != null) && (!localList2.isEmpty()))
            {
              this.jdField_a_of_type_Tom.b().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
              int n = localList2.size();
              m = j + 1;
              j = i + n;
              i = m;
            }
          }
          finally
          {
            ((Lock)localObject1).unlock();
          }
          m = i;
          i = j;
          j = m;
          continue;
          return;
        }
      }
      m = k + 1;
      int k = j;
      j = i;
      int i = k;
      k = m;
    }
  }
  
  protected void destory()
  {
    this.jdField_a_of_type_Apav.destory();
    this.jdField_b_of_type_Apav.destory();
    this.jdField_b_of_type_Ton.destory();
    this.c.destory();
    this.jdField_a_of_type_Tom.b().destroy();
  }
  
  protected void init()
  {
    int j = 0;
    if (!this.hasInit) {}
    for (;;)
    {
      long l1;
      List localList1;
      anpc.e locale1;
      int k;
      int i;
      long l3;
      Object localObject1;
      try
      {
        if (!this.hasInit)
        {
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_Apav.init();
          this.jdField_b_of_type_Apav.init();
          this.jdField_b_of_type_Ton.init();
          this.c.init();
          localList1 = ((ProxyManager)this.app.getManager(18)).a().q(true);
          if (localList1 == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMsgProxyContainer", 2, "init listRecent=" + localList1.size());
          }
          locale1 = new anpc.e();
          locale1.dKX = 0;
          locale1.cfO = "select";
          locale1.cfP = "launch";
          l2 = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 15)) {
          break label498;
        }
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.BaseMsgProxyContainer_" + MsgLruCache.TAG, 1, new Object[] { "INIT cost: ", Long.valueOf(l3 - l2), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          break;
        }
      }
      long l2 = System.currentTimeMillis();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_ProxyInitTime", l2 - l1 + "");
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_InitMsgNum", i + "");
      this.hasInit = true;
      if ((locale1.dKY != 0) && (anpc.ayC()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_IsMainThread", String.valueOf(locale1.dKX));
        ((HashMap)localObject1).put("param_OptType", locale1.cfO);
        ((HashMap)localObject1).put("param_OptTotalCost", String.valueOf(locale1.ant));
        ((HashMap)localObject1).put("param_OptCount", String.valueOf(locale1.dKY));
        ((HashMap)localObject1).put("param_OptMsgCount", String.valueOf(locale1.dKZ));
        ((HashMap)localObject1).put("param_OptOneCost", String.valueOf(locale1.anu));
        ((HashMap)localObject1).put("param_OptScene", locale1.cfP);
        ((HashMap)localObject1).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, locale1.dKZ, 0L, (HashMap)localObject1, null, false);
      }
      return;
      label498:
      if (((RecentUser)localList1.get(k)).getType() != 6000)
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (acbn.bkK.equals(((RecentUser)localList1.get(k)).uin))) {
          anze.a().eh(this.app);
        }
        localObject1 = this.jdField_a_of_type_Tom.a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType());
        ((Lock)localObject1).lock();
        try
        {
          List localList2 = b(((RecentUser)localList1.get(k)).getType()).c(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), locale2);
          if ((localList2 != null) && (!localList2.isEmpty()))
          {
            this.jdField_a_of_type_Tom.b().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
            int m = localList2.size();
            j += 1;
            i += m;
            try
            {
              ((Lock)localObject1).unlock();
            }
            catch (Exception localException1) {}
            continue;
          }
        }
        finally
        {
          localException1.unlock();
        }
      }
      else
      {
        k += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     too
 * JD-Core Version:    0.7.0.1
 */