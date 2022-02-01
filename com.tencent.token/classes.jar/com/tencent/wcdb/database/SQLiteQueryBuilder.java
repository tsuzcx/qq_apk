package com.tencent.wcdb.database;

import android.text.TextUtils;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteQueryBuilder
{
  private static final String TAG = "WCDB.SQLiteQueryBuilder";
  private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  private boolean mDistinct = false;
  private SQLiteDatabase.CursorFactory mFactory = null;
  private Map<String, String> mProjectionMap = null;
  private boolean mStrict;
  private String mTables = "";
  private StringBuilder mWhereClause = null;
  
  private static void appendClause(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    }
  }
  
  public static void appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (str != null)
      {
        if (i > 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(str);
      }
      i += 1;
    }
    paramStringBuilder.append(' ');
  }
  
  public static String buildQueryString(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!sLimitPattern.matcher(paramString6).matches()))
    {
      paramString1 = new StringBuilder();
      paramString1.append("invalid LIMIT clauses:");
      paramString1.append(paramString6);
      throw new IllegalArgumentException(paramString1.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("SELECT ");
    if (paramBoolean) {
      localStringBuilder.append("DISTINCT ");
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0)) {
      appendColumns(localStringBuilder, paramArrayOfString);
    } else {
      localStringBuilder.append("* ");
    }
    localStringBuilder.append("FROM ");
    localStringBuilder.append(paramString1);
    appendClause(localStringBuilder, " WHERE ", paramString2);
    appendClause(localStringBuilder, " GROUP BY ", paramString3);
    appendClause(localStringBuilder, " HAVING ", paramString4);
    appendClause(localStringBuilder, " ORDER BY ", paramString5);
    appendClause(localStringBuilder, " LIMIT ", paramString6);
    return localStringBuilder.toString();
  }
  
  private String[] computeProjection(String[] paramArrayOfString)
  {
    int j = 0;
    int i = 0;
    Object localObject1;
    Object localObject2;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (this.mProjectionMap != null)
      {
        localObject1 = new String[paramArrayOfString.length];
        j = paramArrayOfString.length;
        while (i < j)
        {
          localObject2 = paramArrayOfString[i];
          String str = (String)this.mProjectionMap.get(localObject2);
          if (str != null)
          {
            localObject1[i] = str;
          }
          else
          {
            if ((this.mStrict) || ((!((String)localObject2).contains(" AS ")) && (!((String)localObject2).contains(" as ")))) {
              break label110;
            }
            localObject1[i] = localObject2;
          }
          i += 1;
          continue;
          label110:
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Invalid column ");
          ((StringBuilder)localObject1).append(paramArrayOfString[i]);
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
        return localObject1;
      }
      return paramArrayOfString;
    }
    paramArrayOfString = this.mProjectionMap;
    if (paramArrayOfString != null)
    {
      localObject1 = paramArrayOfString.entrySet();
      paramArrayOfString = new String[((Set)localObject1).size()];
      localObject1 = ((Set)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((String)((Map.Entry)localObject2).getKey()).equals("_count"))
        {
          paramArrayOfString[i] = ((String)((Map.Entry)localObject2).getValue());
          i += 1;
        }
      }
      return paramArrayOfString;
    }
    return null;
  }
  
  private void validateQuerySql(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    paramSQLiteDatabase.getThreadSession().prepare(paramString, paramSQLiteDatabase.getThreadDefaultConnectionFlags(true), paramCancellationSignal, null);
  }
  
  public void appendWhere(CharSequence paramCharSequence)
  {
    if (this.mWhereClause == null) {
      this.mWhereClause = new StringBuilder(paramCharSequence.length() + 16);
    }
    if (this.mWhereClause.length() == 0) {
      this.mWhereClause.append('(');
    }
    this.mWhereClause.append(paramCharSequence);
  }
  
  public void appendWhereEscapeString(String paramString)
  {
    if (this.mWhereClause == null) {
      this.mWhereClause = new StringBuilder(paramString.length() + 16);
    }
    if (this.mWhereClause.length() == 0) {
      this.mWhereClause.append('(');
    }
    DatabaseUtils.appendEscapedSQLString(this.mWhereClause, paramString);
  }
  
  public String buildQuery(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramArrayOfString = computeProjection(paramArrayOfString);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = this.mWhereClause;
    int i;
    if ((localStringBuilder2 != null) && (localStringBuilder2.length() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localStringBuilder1.append(this.mWhereClause.toString());
      localStringBuilder1.append(')');
    }
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      if (i != 0) {
        localStringBuilder1.append(" AND ");
      }
      localStringBuilder1.append('(');
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(')');
    }
    return buildQueryString(this.mDistinct, this.mTables, paramArrayOfString, localStringBuilder1.toString(), paramString2, paramString3, paramString4, paramString5);
  }
  
  @Deprecated
  public String buildQuery(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return buildQuery(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public String buildUnionQuery(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int j = paramArrayOfString.length;
    String str;
    if (this.mDistinct) {
      str = " UNION ";
    } else {
      str = " UNION ALL ";
    }
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(str);
      }
      localStringBuilder.append(paramArrayOfString[i]);
      i += 1;
    }
    appendClause(localStringBuilder, " ORDER BY ", paramString1);
    appendClause(localStringBuilder, " LIMIT ", paramString2);
    return localStringBuilder.toString();
  }
  
  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int j = paramArrayOfString.length;
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfString[i];
      if (((String)localObject).equals(paramString1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("'");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("' AS ");
        ((StringBuilder)localObject).append(paramString1);
        arrayOfString[i] = ((StringBuilder)localObject).toString();
      }
      else if ((i > paramInt) && (!paramSet.contains(localObject)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NULL AS ");
        localStringBuilder.append((String)localObject);
        arrayOfString[i] = localStringBuilder.toString();
      }
      else
      {
        arrayOfString[i] = localObject;
      }
      i += 1;
    }
    return buildQuery(arrayOfString, paramString3, paramString4, paramString5, null, null);
  }
  
  @Deprecated
  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString1, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString2, String paramString4, String paramString5)
  {
    return buildUnionSubQuery(paramString1, paramArrayOfString1, paramSet, paramInt, paramString2, paramString3, paramString4, paramString5);
  }
  
  public String getTables()
  {
    return this.mTables;
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    return query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, null, null);
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, CancellationSignal paramCancellationSignal)
  {
    if (this.mTables == null) {
      return null;
    }
    if ((this.mStrict) && (paramString1 != null) && (paramString1.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(")");
      validateQuerySql(paramSQLiteDatabase, buildQuery(paramArrayOfString1, localStringBuilder.toString(), paramString2, paramString3, paramString4, paramString5), paramCancellationSignal);
    }
    paramArrayOfString1 = buildQuery(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString1 = new StringBuilder();
    paramString1.append("Performing query: ");
    paramString1.append(paramArrayOfString1);
    Log.d("WCDB.SQLiteQueryBuilder", paramString1.toString());
    return paramSQLiteDatabase.rawQueryWithFactory(this.mFactory, paramArrayOfString1, paramArrayOfString2, SQLiteDatabase.findEditTable(this.mTables), paramCancellationSignal);
  }
  
  public void setCursorFactory(SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    this.mFactory = paramCursorFactory;
  }
  
  public void setDistinct(boolean paramBoolean)
  {
    this.mDistinct = paramBoolean;
  }
  
  public void setProjectionMap(Map<String, String> paramMap)
  {
    this.mProjectionMap = paramMap;
  }
  
  public void setStrict(boolean paramBoolean)
  {
    this.mStrict = paramBoolean;
  }
  
  public void setTables(String paramString)
  {
    this.mTables = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQueryBuilder
 * JD-Core Version:    0.7.0.1
 */