import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public class apds
  extends acxq
{
  public apds(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = TableBuilder.getValidField(paramEntity.getClass());
    int j = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = (Field)localList.get(i);
        String str = ((Field)localObject1).getName();
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        try
        {
          localObject1 = ((Field)localObject1).get(paramEntity);
          if ((localObject1 instanceof Integer))
          {
            localContentValues.put(str, (Integer)localObject1);
            i += 1;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject3 = null;
            continue;
            if ((localObject3 instanceof Long)) {
              localContentValues.put(str, (Long)localObject3);
            } else if ((localObject3 instanceof String)) {
              localContentValues.put(str, (String)localObject3);
            } else if ((localObject3 instanceof byte[])) {
              localContentValues.put(str, (byte[])localObject3);
            } else if ((localObject3 instanceof Short)) {
              localContentValues.put(str, (Short)localObject3);
            } else if ((localObject3 instanceof Boolean)) {
              localContentValues.put(str, (Boolean)localObject3);
            } else if ((localObject3 instanceof Double)) {
              localContentValues.put(str, (Double)localObject3);
            } else if ((localObject3 instanceof Float)) {
              localContentValues.put(str, (Float)localObject3);
            } else if ((localObject3 instanceof Byte)) {
              localContentValues.put(str, (Byte)localObject3);
            }
          }
        }
      }
    }
    return localContentValues;
  }
  
  public void a(long paramLong, UUID paramUUID)
  {
    if (paramUUID == null) {
      return;
    }
    apef.b.i("TroopFileDataBaseProxy", apef.b.USR, "[" + paramUUID.toString() + "] deleteItem");
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    localObject = ((TroopFileTansferItemEntity)localObject).getTableName();
    String str = paramUUID.toString();
    paramUUID = new apdv(this, paramUUID);
    a((String)localObject, "_sId=?", new String[] { str }, paramUUID);
  }
  
  public void a(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
  {
    if ((paramTroopFileTansferItemEntity == null) || (paramTroopFileTansferItemEntity.Id == null)) {
      return;
    }
    apef.b.i("TroopFileDataBaseProxy", apef.b.USR, "[" + paramTroopFileTansferItemEntity.Id.toString() + "] updateItem transStatus[" + paramTroopFileTansferItemEntity.Status + "] FilePath[" + paramTroopFileTansferItemEntity.FilePath + "]");
    int i = paramTroopFileTansferItemEntity.Status;
    switch (paramTroopFileTansferItemEntity.Status)
    {
    }
    for (;;)
    {
      paramTroopFileTansferItemEntity.preupdate();
      ContentValues localContentValues = a(paramTroopFileTansferItemEntity);
      localContentValues.put("Status", Integer.valueOf(i));
      localContentValues.put("_sStatus", apbr.a.name(i));
      String str1 = paramTroopFileTansferItemEntity.getTableName();
      String str2 = paramTroopFileTansferItemEntity.Id.toString();
      paramTroopFileTansferItemEntity = new apdu(this, paramTroopFileTansferItemEntity);
      a(str1, localContentValues, "_sId=?", new String[] { str2 }, paramTroopFileTansferItemEntity);
      return;
      i = 3;
      continue;
      i = 10;
    }
  }
  
  public void a(TroopFileTansferItemEntity paramTroopFileTansferItemEntity, ProxyListener paramProxyListener)
  {
    apef.b.i("TroopFileDataBaseProxy", apef.b.USR, "[" + paramTroopFileTansferItemEntity.Id.toString() + "] addItem status[" + paramTroopFileTansferItemEntity.getStatus() + "]");
    paramProxyListener = new apdt(this, paramTroopFileTansferItemEntity);
    if (paramTroopFileTansferItemEntity.getStatus() == 1000)
    {
      this.a.addMsgQueue(String.valueOf(0), 0, paramTroopFileTansferItemEntity.getTableName(), paramTroopFileTansferItemEntity, 0, paramProxyListener);
      return;
    }
    if (paramTroopFileTansferItemEntity.getStatus() == 1001)
    {
      this.a.addMsgQueue(String.valueOf(0), 0, paramTroopFileTansferItemEntity.getTableName(), paramTroopFileTansferItemEntity, 1, paramProxyListener);
      return;
    }
    apef.b.e("TroopFileDataBaseProxy", apef.b.USR, "Item status[" + String.valueOf(paramTroopFileTansferItemEntity.getStatus()) + "] is wrong");
  }
  
  protected void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  protected void destory() {}
  
  protected void init() {}
  
  public List<TroopFileTansferItemEntity> j(long paramLong)
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    TroopFileTansferItemEntity localTroopFileTansferItemEntity = new TroopFileTansferItemEntity();
    localTroopFileTansferItemEntity.troopuin = paramLong;
    return localEntityManager.rawQuery(TroopFileTansferItemEntity.class, "select * from " + localTroopFileTansferItemEntity.getTableName() + " where troopuin = ?", new String[] { "" + paramLong });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apds
 * JD-Core Version:    0.7.0.1
 */