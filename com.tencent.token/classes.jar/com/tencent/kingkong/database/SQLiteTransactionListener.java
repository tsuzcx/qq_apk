package com.tencent.kingkong.database;

public abstract interface SQLiteTransactionListener
{
  public abstract void onBegin();
  
  public abstract void onCommit();
  
  public abstract void onRollback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteTransactionListener
 * JD-Core Version:    0.7.0.1
 */