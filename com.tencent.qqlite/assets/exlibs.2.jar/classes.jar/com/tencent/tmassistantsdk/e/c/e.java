package com.tencent.tmassistantsdk.e.c;

public class e
  extends a
{
  private static e a = null;
  
  public static e e()
  {
    try
    {
      if (a == null) {
        a = new e();
      }
      e locale = a;
      return locale;
    }
    finally {}
  }
  
  protected final String[] b(int paramInt)
  {
    return new String[] { "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );" };
  }
  
  protected final String c()
  {
    return "downloadLogData";
  }
  
  protected final String d()
  {
    return "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.c.e
 * JD-Core Version:    0.7.0.1
 */