package com.tencent.wcdb.database;

public final class SQLiteCustomFunction
{
  public final SQLiteDatabase.CustomFunction callback;
  public final String name;
  public final int numArgs;
  
  public SQLiteCustomFunction(String paramString, int paramInt, SQLiteDatabase.CustomFunction paramCustomFunction)
  {
    if (paramString != null)
    {
      this.name = paramString;
      this.numArgs = paramInt;
      this.callback = paramCustomFunction;
      return;
    }
    throw new IllegalArgumentException("name must not be null.");
  }
  
  private void dispatchCallback(String[] paramArrayOfString)
  {
    this.callback.callback(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCustomFunction
 * JD-Core Version:    0.7.0.1
 */