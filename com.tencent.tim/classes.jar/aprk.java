import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class aprk
{
  public static boolean a(QQAppInterface paramQQAppInterface, Map<UUID, ? extends Entity> paramMap, long paramLong)
  {
    if (paramMap == null) {
      QLog.e("SerializableManager", 4, "bad Entity Param");
    }
    Object localObject;
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      localObject = new TroopFileTansferItemEntity();
      ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    } while (!paramQQAppInterface.drop(((TroopFileTansferItemEntity)localObject).getTableName()));
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Entity)paramMap.next();
      ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
      ((Entity)localObject).setStatus(1000);
      paramQQAppInterface.persist((Entity)localObject);
    }
    return true;
  }
  
  public static List<TroopFileTansferItemEntity> b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    TroopFileTansferItemEntity localTroopFileTansferItemEntity = new TroopFileTansferItemEntity();
    localTroopFileTansferItemEntity.troopuin = paramLong;
    return paramQQAppInterface.rawQuery(TroopFileTansferItemEntity.class, "select * from " + localTroopFileTansferItemEntity.getTableName() + " where troopuin = ?", new String[] { "" + paramLong });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprk
 * JD-Core Version:    0.7.0.1
 */