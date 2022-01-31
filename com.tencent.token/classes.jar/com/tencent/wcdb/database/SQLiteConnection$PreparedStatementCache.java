package com.tencent.wcdb.database;

import android.util.Printer;
import com.tencent.wcdb.support.LruCache;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class SQLiteConnection$PreparedStatementCache
  extends LruCache
{
  public SQLiteConnection$PreparedStatementCache(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    super(paramInt);
  }
  
  public void dump(Printer paramPrinter)
  {
    paramPrinter.println("  Prepared statement cache:");
    Object localObject1 = snapshot();
    if (!((Map)localObject1).isEmpty())
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        SQLiteConnection.PreparedStatement localPreparedStatement = (SQLiteConnection.PreparedStatement)((Map.Entry)localObject2).getValue();
        if (SQLiteConnection.PreparedStatement.access$500(localPreparedStatement))
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          paramPrinter.println("    " + i + ": statementPtr=0x" + Long.toHexString(localPreparedStatement.getPtr()) + ", numParameters=" + SQLiteConnection.PreparedStatement.access$200(localPreparedStatement) + ", type=" + SQLiteConnection.PreparedStatement.access$100(localPreparedStatement) + ", readOnly=" + SQLiteConnection.PreparedStatement.access$300(localPreparedStatement) + ", sql=\"" + SQLiteConnection.access$1500((String)localObject2) + "\"");
        }
        i += 1;
      }
    }
    paramPrinter.println("    <none>");
  }
  
  protected void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
  {
    SQLiteConnection.PreparedStatement.access$502(paramPreparedStatement1, false);
    if (!SQLiteConnection.PreparedStatement.access$400(paramPreparedStatement1)) {
      SQLiteConnection.access$1400(this.this$0, paramPreparedStatement1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.PreparedStatementCache
 * JD-Core Version:    0.7.0.1
 */