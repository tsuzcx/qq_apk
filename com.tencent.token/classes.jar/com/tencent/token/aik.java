package com.tencent.token;

import android.content.OperationApplicationException;
import android.os.Parcel;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.text.Collator;

public final class aik
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static Collator b = null;
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }
  
  public static int a(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Byte))) {
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public static int a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("_id")) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.a(paramString);
    try
    {
      long l = paramSQLiteDatabase.g();
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public static final void a(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int i = j;
    if (j == -128)
    {
      if (paramParcel.readInt() == 0) {
        Log.a("WCDB.DatabaseUtils", "Unexpected zero-sized Parcel reply header.");
      }
      i = 0;
    }
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    switch (i)
    {
    case 10: 
    default: 
      paramParcel.readException(i, str);
      return;
    case 11: 
      throw new OperationCanceledException(str);
    case 9: 
      throw new SQLiteException(str);
    case 8: 
      throw new SQLiteDiskIOException(str);
    case 7: 
      throw new SQLiteFullException(str);
    case 6: 
      throw new SQLiteDatabaseCorruptException(str);
    case 5: 
      throw new SQLiteConstraintException(str);
    case 4: 
      throw new SQLiteAbortException(str);
    case 3: 
      throw new UnsupportedOperationException(str);
    }
    throw new IllegalArgumentException(str);
  }
  
  public static final void a(Parcel paramParcel, Exception paramException)
  {
    int i;
    int j;
    if ((paramException instanceof FileNotFoundException))
    {
      i = 1;
      j = 0;
    }
    else if ((paramException instanceof IllegalArgumentException))
    {
      i = 2;
      j = 1;
    }
    else if ((paramException instanceof UnsupportedOperationException))
    {
      i = 3;
      j = 1;
    }
    else if ((paramException instanceof SQLiteAbortException))
    {
      i = 4;
      j = 1;
    }
    else if ((paramException instanceof SQLiteConstraintException))
    {
      i = 5;
      j = 1;
    }
    else if ((paramException instanceof SQLiteDatabaseCorruptException))
    {
      i = 6;
      j = 1;
    }
    else if ((paramException instanceof SQLiteFullException))
    {
      i = 7;
      j = 1;
    }
    else if ((paramException instanceof SQLiteDiskIOException))
    {
      i = 8;
      j = 1;
    }
    else if ((paramException instanceof SQLiteException))
    {
      i = 9;
      j = 1;
    }
    else if ((paramException instanceof OperationApplicationException))
    {
      i = 10;
      j = 1;
    }
    else
    {
      if (!(paramException instanceof OperationCanceledException)) {
        break label190;
      }
      i = 11;
      j = 0;
    }
    paramParcel.writeInt(i);
    paramParcel.writeString(paramException.getMessage());
    if (j != 0) {
      Log.a("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
    }
    return;
    label190:
    paramParcel.writeException(paramException);
    Log.a("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
        i += 1;
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int b(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() < 3) {
      return 99;
    }
    int m = 0;
    int j = 0;
    int i = 0;
    while (j < 3)
    {
      int n = paramString.charAt(j);
      int k;
      if ((n >= 97) && (n <= 122))
      {
        k = n - 97 + 65;
      }
      else
      {
        k = n;
        if (n >= 128)
        {
          i = m;
          break;
        }
      }
      i |= (k & 0x7F) << j * 8;
      j += 1;
    }
    switch (i)
    {
    default: 
      return 99;
    case 5526593: 
      return 3;
    case 5001042: 
      return 6;
    case 4998483: 
      return 1;
    case 4670786: 
      return 4;
    case 4543043: 
    case 5198404: 
    case 5524545: 
      return 8;
    case 4477013: 
    case 4998468: 
    case 5260626: 
    case 5459529: 
      return 2;
    case 4476485: 
    case 5066563: 
      return 5;
    case 4280912: 
      return 7;
    }
    return 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aik
 * JD-Core Version:    0.7.0.1
 */