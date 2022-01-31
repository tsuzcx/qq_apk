package com.tencent.tmassistantsdk.e.c;

public class i
  extends a
{
  private static i a = null;
  
  public static i e()
  {
    try
    {
      if (a == null) {
        a = new i();
      }
      i locali = a;
      return locali;
    }
    finally {}
  }
  
  protected final String[] b(int paramInt)
  {
    if (paramInt > 1) {
      return new String[] { "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );" };
    }
    return null;
  }
  
  protected final String c()
  {
    return "SelfUpdateInfoLogData";
  }
  
  protected final String d()
  {
    return "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.i
 * JD-Core Version:    0.7.0.1
 */