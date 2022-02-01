package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.bottle.model.BottleListCursorAdapterORM;
import com.tencent.qqmail.bottle.orm.CursorAdapterORM;

public class BottleListCursor
  implements CursorAdapterORM<BottleList>
{
  private final BottleListCursorAdapterORM adapterORM;
  final long dbTimestamp;
  final String lastBottleId;
  final long timestamp;
  final int total;
  
  BottleListCursor(long paramLong1, int paramInt, String paramString, long paramLong2, BottleListCursorAdapterORM paramBottleListCursorAdapterORM)
  {
    if (BottleThrowController.isUnsendBottleId(paramString)) {
      throw new IllegalArgumentException("lastBottleId: " + paramString);
    }
    this.timestamp = paramLong1;
    this.total = paramInt;
    this.lastBottleId = paramString;
    this.dbTimestamp = paramLong2;
    this.adapterORM = paramBottleListCursorAdapterORM;
  }
  
  public void close()
  {
    this.adapterORM.close();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof BottleListCursor))) {
        break;
      }
      paramObject = (BottleListCursor)paramObject;
      if (paramObject.dbTimestamp != this.dbTimestamp) {
        return false;
      }
    } while ((paramObject != null) && (this.total == paramObject.total) && (this.adapterORM.getCount() == paramObject.adapterORM.getCount()) && (((this.lastBottleId == null) && (paramObject.lastBottleId == null)) || ((this.lastBottleId != null) && (this.lastBottleId.equals(paramObject.lastBottleId)))));
    return false;
  }
  
  public int getCount()
  {
    return this.adapterORM.getCount();
  }
  
  public BottleList getItem(int paramInt)
  {
    return this.adapterORM.getItem(paramInt);
  }
  
  public BottleList getItem(int paramInt, BottleList paramBottleList)
  {
    return this.adapterORM.getItem(paramInt, paramBottleList);
  }
  
  public int getPosition()
  {
    return this.adapterORM.getPosition();
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public boolean hasMoreItem()
  {
    return this.adapterORM.getCount() < this.total;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListCursor
 * JD-Core Version:    0.7.0.1
 */