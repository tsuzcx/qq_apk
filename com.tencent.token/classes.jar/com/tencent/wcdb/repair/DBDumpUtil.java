package com.tencent.wcdb.repair;

public class DBDumpUtil
{
  private static native boolean nativeDumpDB(String paramString1, String paramString2, String paramString3);
  
  private static native boolean nativeIsSqlComplete(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.DBDumpUtil
 * JD-Core Version:    0.7.0.1
 */