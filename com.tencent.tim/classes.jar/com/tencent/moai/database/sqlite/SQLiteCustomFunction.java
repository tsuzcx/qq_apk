package com.tencent.moai.database.sqlite;

public final class SQLiteCustomFunction
{
  public final SQLiteDatabase.CustomFunction callback;
  public final String name;
  public final int numArgs;
  
  public SQLiteCustomFunction(String paramString, int paramInt, SQLiteDatabase.CustomFunction paramCustomFunction)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("name must not be null.");
    }
    this.name = paramString;
    this.numArgs = paramInt;
    this.callback = paramCustomFunction;
  }
  
  private long dispatchCallback(String[] paramArrayOfString)
  {
    return this.callback.callback(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteCustomFunction
 * JD-Core Version:    0.7.0.1
 */