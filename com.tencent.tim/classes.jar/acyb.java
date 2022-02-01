import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class acyb
  extends acyd
{
  public acyb(QQAppInterface paramQQAppInterface, acyc paramacyc)
  {
    super(paramQQAppInterface, paramacyc);
    this.bKo = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, EntityManager paramEntityManager)
  {
    localObject = null;
    try
    {
      if (this.cAr > 0)
      {
        i = paramSQLiteDatabase.delete(FTSNewTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.cAr) });
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.d("Q.fts.troop.operator.new", 2, "delete " + FTSNewTroopSync.class.getSimpleName() + " row=" + i);
        }
      }
      paramEntityManager = paramEntityManager.query(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.cAr) }, null, null, null, "300");
      if (paramEntityManager == null) {
        break label291;
      }
      paramSQLiteDatabase = new ArrayList(paramEntityManager.size());
      try
      {
        paramEntityManager = paramEntityManager.iterator();
        while (paramEntityManager.hasNext()) {
          paramSQLiteDatabase.add(((FTSNewTroopSync)paramEntityManager.next()).transTroopSync());
        }
        QLog.e("Q.fts.troop.operator.new", 1, paramEntityManager, new Object[0]);
      }
      catch (Throwable paramEntityManager) {}
    }
    catch (Throwable paramEntityManager)
    {
      for (;;)
      {
        int i;
        paramSQLiteDatabase = localObject;
        continue;
        paramSQLiteDatabase = null;
      }
    }
    paramEntityManager = new HashMap();
    paramEntityManager.put("type", "2");
    anpc.a(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actGetOptFailed", true, 0L, 0L, paramEntityManager, null);
    paramEntityManager = paramSQLiteDatabase;
    label225:
    return paramEntityManager;
    paramEntityManager = paramSQLiteDatabase;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        paramEntityManager = new StringBuilder().append("getOptSyncList size:");
        if (paramSQLiteDatabase == null) {
          break label279;
        }
        i = paramSQLiteDatabase.size();
        QLog.d("Q.fts.troop.operator.new", 2, i);
        return paramSQLiteDatabase;
      }
      catch (Throwable paramEntityManager) {}
      break;
      label279:
      i = 0;
    }
  }
  
  protected String rY()
  {
    return "NewTroopCursor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyb
 * JD-Core Version:    0.7.0.1
 */