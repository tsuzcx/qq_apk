package com.tencent.tmassistantsdk.internal.c.a;

public class a
  extends com.tencent.tmassistant.common.a.a
{
  protected static a a = null;
  
  public static a e()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public String b()
  {
    return "BusinessInfoLogTable";
  }
  
  public String[] b(int paramInt)
  {
    if (paramInt > 1) {
      return new String[] { c() };
    }
    return null;
  }
  
  public String c()
  {
    return "CREATE TABLE if not exists BusinessInfoLogTable( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
  
  public String d()
  {
    return "INSERT INTO BusinessInfoLogTable logData = ?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.c.a.a
 * JD-Core Version:    0.7.0.1
 */