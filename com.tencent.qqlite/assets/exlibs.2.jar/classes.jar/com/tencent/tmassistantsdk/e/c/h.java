package com.tencent.tmassistantsdk.e.c;

public class h
  extends a
{
  private static h a = null;
  
  public static h e()
  {
    try
    {
      if (a == null) {
        a = new h();
      }
      h localh = a;
      return localh;
    }
    finally {}
  }
  
  protected final String[] b(int paramInt)
  {
    if (paramInt > 1) {
      return new String[] { "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );" };
    }
    return null;
  }
  
  protected final String c()
  {
    return "TipsInfoLogData";
  }
  
  protected final String d()
  {
    return "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.h
 * JD-Core Version:    0.7.0.1
 */