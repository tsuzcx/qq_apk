package com.tencent.token;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.a;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;

public final class ajf
{
  static {}
  
  public static SQLiteDatabase a(Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, SQLiteDatabase.a parama, aij paramaij)
  {
    if (paramString.charAt(0) == File.separatorChar)
    {
      paramContext = new File(paramString.substring(0, paramString.lastIndexOf(File.separatorChar)));
      paramString = new File(paramContext, paramString.substring(paramString.lastIndexOf(File.separatorChar)));
    }
    else
    {
      if (paramContext == null) {
        break label289;
      }
      paramContext = paramContext.getApplicationInfo().dataDir;
      if (paramContext != null) {
        paramContext = new File(paramContext);
      } else {
        paramContext = null;
      }
      File localFile = new File(paramContext, "databases");
      paramContext = localFile;
      if (localFile.getPath().equals("databases")) {
        paramContext = new File("/data/system");
      }
      if (paramString.indexOf(File.separatorChar) >= 0) {
        break label254;
      }
      paramString = new File(paramContext, paramString);
    }
    if ((!paramContext.isDirectory()) && (paramContext.mkdir())) {
      FileUtils.setPermissions(paramContext.getPath(), 505, -1, -1);
    }
    if ((paramInt & 0x8) != 0) {
      i = 805306368;
    } else {
      i = 268435456;
    }
    paramContext = SQLiteDatabase.a(paramString.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, parama, i, paramaij);
    paramString = paramString.getPath();
    int i = 432;
    if ((paramInt & 0x1) != 0) {
      i = 436;
    }
    int j = i;
    if ((paramInt & 0x2) != 0) {
      j = i | 0x2;
    }
    FileUtils.setPermissions(paramString, j, -1, -1);
    return paramContext;
    label254:
    paramContext = new StringBuilder("File ");
    paramContext.append(paramString);
    paramContext.append(" contains a path separator");
    throw new IllegalArgumentException(paramContext.toString());
    label289:
    throw new RuntimeException("Not supported in system context");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajf
 * JD-Core Version:    0.7.0.1
 */