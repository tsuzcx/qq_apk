import android.database.Cursor;
import android.database.SQLException;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class akwh
  implements Manager
{
  private akwg a;
  QQAppInterface app;
  private Object bE = new Object();
  protected akvm d;
  
  public akwh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private SQLiteOpenHelper a()
  {
    if (!this.app.getCurrentAccountUin().equals("0")) {
      return a().build(this.app.getCurrentAccountUin());
    }
    return null;
  }
  
  public void P(String paramString, List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSlowTableManager", 2, "insertSlowTable return by non msg");
      }
      return;
    }
    int m = 0;
    int n = 0;
    int i = 0;
    paramString = c().getTransaction();
    int j;
    int k;
    if (paramString != null)
    {
      j = m;
      k = n;
    }
    for (;;)
    {
      try
      {
        paramString.begin();
        j = m;
        k = n;
        Iterator localIterator = paramList.iterator();
        j = i;
        k = i;
        if (localIterator.hasNext())
        {
          j = i;
          k = i;
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          j = i;
          k = i;
          localMessageRecord.setStatus(1000);
          j = i;
          k = i;
          c().persistOrReplace(localMessageRecord);
          j = i;
          k = i;
          if (localMessageRecord.getStatus() == 1001) {
            i += 1;
          }
        }
        else
        {
          if (paramString != null)
          {
            j = i;
            k = i;
            paramString.commit();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        k = j;
        QLog.e("QSlowTableManager", 1, "insert slowtable excep: ", localException);
        return;
      }
      finally
      {
        if (paramString != null) {
          paramString.end();
        }
        QLog.d("QSlowTableManager", 1, "insertSlowTable totalCount:" + paramList.size() + " ,succCount:" + k);
      }
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    if (localSQLiteDatabase == null) {
      QLog.e("QSlowTableManager", 2, "deleteSlowTable db = null!");
    }
    label192:
    do
    {
      return j;
      EntityTransaction localEntityTransaction = c().getTransaction();
      if (localEntityTransaction != null) {
        j = i;
      }
      try
      {
        localEntityTransaction.begin();
        j = i;
        int k = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
        if (localEntityTransaction != null)
        {
          j = k;
          localEntityTransaction.commit();
        }
        i = k;
        if (localEntityTransaction != null)
        {
          localEntityTransaction.end();
          i = k;
        }
      }
      catch (Exception paramArrayOfString)
      {
        for (;;)
        {
          QLog.e("QSlowTableManager", 1, "delete slowtable excep: ", paramArrayOfString);
          i = j;
          if (localEntityTransaction != null)
          {
            localEntityTransaction.end();
            i = j;
          }
        }
      }
      finally
      {
        if (localEntityTransaction == null) {
          break label192;
        }
        localEntityTransaction.end();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QSlowTableManager", 2, "delete slowtable=" + paramString1 + " ,count=" + i + " ,whereClause:" + paramString2);
        return i;
      }
      j = i;
    } while (i <= 0);
    QLog.d("QSlowTableManager", 1, "deleteSlowTable count:" + i);
    return i;
  }
  
  public akwg a()
  {
    String str = this.app.getCurrentUin();
    if (str == null) {
      throw new IllegalStateException("uin is null");
    }
    if (this.a != null) {
      return this.a;
    }
    try
    {
      if (this.a == null)
      {
        this.a = new akwg(str);
        ThreadManager.post(new QSlowTableManager.1(this), 8, null, false);
      }
      return this.a;
    }
    finally {}
  }
  
  public Cursor a(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "querySlowTable db null!");
      }
    }
    Object localObject1;
    do
    {
      return null;
      if (paramString1.indexOf("mr_troop_") == -1) {
        break;
      }
      localObject1 = " where " + paramString2;
      paramString2 = aqir.b(null, paramString1, localSQLiteDatabase, (String)localObject1);
    } while (paramString2 == null);
    for (;;)
    {
      try
      {
        paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.query(paramString1, null, (String)localObject1, null, null, null);
        continue;
      }
      return paramString1;
      if (paramString1.indexOf("mr_grp_") != -1)
      {
        localObject1 = new StringBuilder("select * from ");
        ((StringBuilder)localObject1).append(paramString1);
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          ((StringBuilder)localObject1).append(" where ");
          ((StringBuilder)localObject1).append(paramString2);
        }
        try
        {
          localObject1 = localSQLiteDatabase.rawQuery(((StringBuilder)localObject1).toString(), null);
          paramString2 = (String)localObject1;
        }
        catch (SQLException localSQLException1)
        {
          for (;;)
          {
            paramString2 = localSQLiteDatabase.query(paramString1, null, paramString2, null, null, null);
          }
        }
        paramString1 = paramString2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("gene", 2, "cursor: " + paramString2);
        paramString1 = paramString2;
        continue;
      }
      if (paramString1.indexOf("mr_discusssion_") != -1)
      {
        localObject2 = " where " + paramString2;
        paramString2 = aqir.b(null, paramString1, localSQLiteDatabase, (String)localObject2);
        if (paramString2 == null) {
          break;
        }
        try
        {
          paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          paramString1 = localSQLiteDatabase.query(paramString1, null, (String)localObject2, null, null, null);
        }
        continue;
      }
      Object localObject2 = aqir.a(null, paramString1, localSQLiteDatabase, paramString2, null);
      if (localObject2 != null) {
        try
        {
          localObject2 = localSQLiteDatabase.rawQuery(((StringBuilder)localObject2).toString(), null);
          paramString1 = (String)localObject2;
        }
        catch (SQLException localSQLException2)
        {
          paramString1 = localSQLiteDatabase.query(paramString1, null, paramString2, null, null, null);
        }
      } else {
        paramString1 = null;
      }
    }
  }
  
  public List<MessageRecord> aF(String paramString)
  {
    if (getReadableDatabase() == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "querySlowTable db = null!");
      }
    }
    do
    {
      return null;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QSlowTableManager", 2, "sql = null!");
    return null;
    return c().rawQuery(MessageRecord.class, paramString, null);
  }
  
  public long aq(String paramString)
  {
    long l1 = 0L;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null)
    {
      l3 = l1;
      if (QLog.isColorLevel())
      {
        QLog.e("QSlowTableManager", 2, "queryLastMsgTime db = null!");
        l3 = l1;
      }
    }
    do
    {
      return l3;
      l2 = l1;
      if (aqir.a(paramString, localSQLiteDatabase)) {
        l3 = l1;
      }
      try
      {
        paramString = localSQLiteDatabase.rawQuery("select time from " + paramString + " order by time desc limit 1", null);
        l2 = l1;
        l3 = l1;
        if (paramString.moveToNext())
        {
          l3 = l1;
          l2 = paramString.getLong(0);
        }
        l3 = l2;
        paramString.close();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          l2 = l3;
        }
      }
      l3 = l2;
    } while (!QLog.isColorLevel());
    QLog.d("QSlowTableManager", 2, "queryLastMsgTime maxtime=" + l2);
    return l2;
  }
  
  public long ar(String paramString)
  {
    long l1 = 0L;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null)
    {
      l3 = l1;
      if (QLog.isColorLevel())
      {
        QLog.e("QSlowTableManager", 2, "queryLastMsgTime db = null!");
        l3 = l1;
      }
    }
    do
    {
      return l3;
      l2 = l1;
      if (aqir.a(paramString, localSQLiteDatabase)) {
        l3 = l1;
      }
      try
      {
        paramString = localSQLiteDatabase.rawQuery("select time from " + paramString + " order by time asc limit 1", null);
        l2 = l1;
        l3 = l1;
        if (paramString.moveToNext())
        {
          l3 = l1;
          l2 = paramString.getLong(0);
        }
        l3 = l2;
        paramString.close();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          l2 = l3;
        }
      }
      l3 = l2;
    } while (!QLog.isColorLevel());
    QLog.d("QSlowTableManager", 2, "queryFirstMsgTime maxtime=" + l2);
    return l2;
  }
  
  public int c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String[] arrayOfString = null;
    int j = 0;
    String str2 = MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    String str1;
    if (paramMessageRecord.getId() > 0L)
    {
      str1 = "_id=?";
      arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramMessageRecord.getId());
    }
    for (;;)
    {
      int i = j;
      if (str1 != null)
      {
        i = j;
        if (arrayOfString != null)
        {
          j = a(str2, str1, arrayOfString);
          i = j;
          if (paramBoolean)
          {
            this.app.a().a().Y(paramMessageRecord);
            i = j;
          }
        }
      }
      return i;
      if (paramMessageRecord.uniseq != 0L)
      {
        str1 = "uniseq=?";
        arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(paramMessageRecord.uniseq);
      }
      else
      {
        str1 = null;
      }
    }
  }
  
  public akvm c()
  {
    if ((this.d == null) || (!this.d.isOpen())) {}
    synchronized (this.bE)
    {
      if ((this.d == null) || (!this.d.isOpen())) {
        this.d = ((akvm)a().createMessageRecordEntityManager());
      }
      return this.d;
    }
  }
  
  public int dG(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "getSlowTableCount db = null!");
      }
    }
    while (!aqir.a(paramString, localSQLiteDatabase)) {
      return 0;
    }
    return localSQLiteDatabase.getCount(paramString);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getReadableDatabase();
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getWritableDatabase();
    }
    return null;
  }
  
  public List<MessageRecord> h(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "querySlowTableForList db = null!");
      }
    }
    do
    {
      return null;
      paramString1 = aqir.a(null, paramString1, localSQLiteDatabase, paramString2, null);
      if (paramString1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QSlowTableManager", 2, "sqlStr db = null!");
    return null;
    return c().rawQuery(MessageRecord.class, paramString1.toString(), null);
  }
  
  public void onDestroy()
  {
    if ((this.d != null) && (this.d.isOpen())) {
      this.d.close();
    }
    if (this.a != null) {
      this.a.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwh
 * JD-Core Version:    0.7.0.1
 */