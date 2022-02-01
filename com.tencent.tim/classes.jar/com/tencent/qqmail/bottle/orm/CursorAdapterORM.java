package com.tencent.qqmail.bottle.orm;

public abstract interface CursorAdapterORM<T>
{
  public static final boolean CHECK_IN_SAME_THREAD = true;
  
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract T getItem(int paramInt);
  
  public abstract T getItem(int paramInt, T paramT);
  
  public abstract int getPosition();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.orm.CursorAdapterORM
 * JD-Core Version:    0.7.0.1
 */