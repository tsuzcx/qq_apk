import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionEntity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aktw
  implements Manager
{
  private List<OnlineStatusPermissionEntity> Eq;
  private int ddm = -1;
  private QQAppInterface mApp;
  
  public aktw(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.Eq = new ArrayList();
    db(paramQQAppInterface);
  }
  
  /* Error */
  private OnlineStatusPermissionEntity a(@NonNull OnlineStatusPermissionEntity paramOnlineStatusPermissionEntity, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	aktw:Eq	Ljava/util/List;
    //   6: invokeinterface 44 1 0
    //   11: astore 4
    //   13: aload 4
    //   15: invokeinterface 50 1 0
    //   20: ifeq +87 -> 107
    //   23: aload 4
    //   25: invokeinterface 54 1 0
    //   30: checkcast 56	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity
    //   33: astore_3
    //   34: aload_3
    //   35: getfield 60	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:onlineStateType	J
    //   38: aload_1
    //   39: getfield 60	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:onlineStateType	J
    //   42: lcmp
    //   43: ifne -30 -> 13
    //   46: iload_2
    //   47: ifeq +27 -> 74
    //   50: aload_3
    //   51: aload_1
    //   52: getfield 64	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:allHasPermission	Z
    //   55: putfield 64	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:allHasPermission	Z
    //   58: aload_3
    //   59: aload_1
    //   60: getfield 68	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:permissionList	[B
    //   63: putfield 68	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:permissionList	[B
    //   66: aload_3
    //   67: aload_1
    //   68: getfield 71	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:hasPermissionList	Ljava/util/List;
    //   71: putfield 71	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:hasPermissionList	Ljava/util/List;
    //   74: aload_3
    //   75: astore_1
    //   76: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +24 -> 103
    //   82: ldc 78
    //   84: iconst_2
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: ldc 80
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_3
    //   97: aastore
    //   98: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   101: aload_3
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: areturn
    //   107: aload_0
    //   108: getfield 27	aktw:Eq	Ljava/util/List;
    //   111: aload_1
    //   112: invokeinterface 88 2 0
    //   117: pop
    //   118: goto -15 -> 103
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	aktw
    //   0	126	1	paramOnlineStatusPermissionEntity	OnlineStatusPermissionEntity
    //   0	126	2	paramBoolean	boolean
    //   33	69	3	localOnlineStatusPermissionEntity	OnlineStatusPermissionEntity
    //   11	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	121	finally
    //   13	46	121	finally
    //   50	74	121	finally
    //   76	101	121	finally
    //   107	118	121	finally
  }
  
  private void db(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (this.ddm == -1)
      {
        this.ddm = 0;
        ThreadManagerV2.excute(new OnlineStatusPermissionManager.1(this, paramQQAppInterface), 16, null, true);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  @Nullable
  public OnlineStatusPermissionEntity a(long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " getOnlineStatusPermission onlineStatusType=", Long.valueOf(paramLong), " state= ", Integer.valueOf(this.ddm) });
        }
        int i = this.ddm;
        if (i == 0)
        {
          localObject1 = null;
          return localObject1;
        }
        Object localObject1 = this.Eq.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          OnlineStatusPermissionEntity localOnlineStatusPermissionEntity = (OnlineStatusPermissionEntity)((Iterator)localObject1).next();
          if (localOnlineStatusPermissionEntity.onlineStateType != paramLong) {
            continue;
          }
          localObject1 = localOnlineStatusPermissionEntity;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " getOnlineStatusPermission openIdItem=", localOnlineStatusPermissionEntity });
          localObject1 = localOnlineStatusPermissionEntity;
          continue;
        }
        if (!paramBoolean) {
          break label164;
        }
      }
      finally {}
      akty.a(this.mApp, paramLong);
      label164:
      Object localObject3 = null;
    }
  }
  
  /* Error */
  public void a(@NonNull OnlineStatusPermissionEntity paramOnlineStatusPermissionEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +22 -> 27
    //   8: ldc 78
    //   10: iconst_2
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc 128
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_1
    //   23: aastore
    //   24: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 22	aktw:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   34: invokevirtual 139	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: iconst_1
    //   41: invokespecial 37	aktw:a	(Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity;Z)Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity;
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 143	com/tencent/mobileqq/onlinestatus/OnlineStatusPermissionEntity:getStatus	()I
    //   49: sipush 1000
    //   52: if_icmpne +15 -> 67
    //   55: aload_2
    //   56: aload_1
    //   57: invokevirtual 149	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   60: aload_2
    //   61: invokevirtual 152	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_2
    //   68: aload_1
    //   69: invokevirtual 156	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   72: pop
    //   73: goto -13 -> 60
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	aktw
    //   0	81	1	paramOnlineStatusPermissionEntity	OnlineStatusPermissionEntity
    //   37	31	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    // Exception table:
    //   from	to	target	type
    //   2	27	76	finally
    //   27	60	76	finally
    //   60	64	76	finally
    //   67	73	76	finally
  }
  
  public boolean a(@NonNull OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    OnlineStatusPermissionEntity localOnlineStatusPermissionEntity = a(paramOnlineStatusPermissionItem.getOnlineStateType(), false);
    if (localOnlineStatusPermissionEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (localOnlineStatusPermissionEntity.allHasPermission == paramOnlineStatusPermissionItem.isAllHasPermission()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " hasPermissionChange entity.allHasPermission=", Boolean.valueOf(localOnlineStatusPermissionEntity.allHasPermission), " item.isAllHasPermission=", Boolean.valueOf(paramOnlineStatusPermissionItem.isAllHasPermission()) });
        return true;
        if (localOnlineStatusPermissionEntity.hasPermissionList.size() == paramOnlineStatusPermissionItem.getPermissionUins().size()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusPermissionManager", 2, new Object[] { " hasPermissionChange entity.size=", Integer.valueOf(localOnlineStatusPermissionEntity.hasPermissionList.size()), " item.size=", Integer.valueOf(paramOnlineStatusPermissionItem.getPermissionUins().size()) });
      return true;
      if (localOnlineStatusPermissionEntity.hasPermissionList.containsAll(paramOnlineStatusPermissionItem.getPermissionUins())) {
        return false;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusPermissionManager", 2, " hasPermissionChange entity not contains item all");
    return true;
  }
  
  public void onDestroy()
  {
    try
    {
      this.Eq.clear();
      this.ddm = -1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktw
 * JD-Core Version:    0.7.0.1
 */