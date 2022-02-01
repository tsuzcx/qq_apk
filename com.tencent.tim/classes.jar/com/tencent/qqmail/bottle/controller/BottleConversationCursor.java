package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.bottle.model.BottleConversationCursorAdapterORM;
import com.tencent.qqmail.bottle.orm.CursorAdapterORM;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;

public class BottleConversationCursor
  implements CursorAdapterORM<BottleConversation>
{
  private final BottleConversationCursorAdapterORM adapterORM;
  final String bottleId;
  final String city;
  final boolean convOverdue;
  final long dbTimestamp;
  final int distance;
  final String lastMsgId;
  final String lastOtherMsgId;
  final long svnTime;
  final int totalInConversation;
  final String uin;
  final int unreadInList;
  
  BottleConversationCursor(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, long paramLong2, String paramString4, String paramString5, BottleConversationCursorAdapterORM paramBottleConversationCursorAdapterORM)
  {
    if (BottleThrowController.isUnsendMsgId(paramString3)) {
      throw new DevRuntimeException("lastMsgId: " + paramString3);
    }
    this.bottleId = paramString1;
    this.svnTime = paramLong1;
    this.unreadInList = paramInt1;
    this.totalInConversation = paramInt2;
    this.distance = paramInt3;
    this.city = paramString2;
    this.lastMsgId = paramString3;
    this.convOverdue = paramBoolean;
    this.dbTimestamp = paramLong2;
    this.lastOtherMsgId = paramString4;
    this.uin = paramString5;
    this.adapterORM = paramBottleConversationCursorAdapterORM;
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
      if ((paramObject == null) || (!(paramObject instanceof BottleConversationCursor))) {
        break;
      }
      paramObject = (BottleConversationCursor)paramObject;
      if (paramObject.dbTimestamp != this.dbTimestamp) {
        return false;
      }
    } while ((this.bottleId.equals(paramObject.bottleId)) && (this.totalInConversation == paramObject.totalInConversation) && (this.adapterORM.getCount() == paramObject.adapterORM.getCount()) && (((this.lastMsgId == null) && (paramObject.lastMsgId == null)) || ((this.lastMsgId != null) && (this.lastMsgId.equals(paramObject.lastMsgId)))));
    return false;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public int getCount()
  {
    return this.adapterORM.getCount();
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public BottleConversation getItem(int paramInt)
  {
    return this.adapterORM.getItem(paramInt);
  }
  
  public BottleConversation getItem(int paramInt, BottleConversation paramBottleConversation)
  {
    return this.adapterORM.getItem(paramInt, paramBottleConversation);
  }
  
  public String getLastOtherMsgId()
  {
    return this.lastOtherMsgId;
  }
  
  public int getPosition()
  {
    return this.adapterORM.getPosition();
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public boolean hasMoreItem()
  {
    return this.adapterORM.getCount() < this.totalInConversation;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationCursor
 * JD-Core Version:    0.7.0.1
 */