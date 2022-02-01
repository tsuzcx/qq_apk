package com.tencent.tim.todo.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aupm;
import aupu;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class TodoInfo
  extends Entity
  implements Parcelable, aupm
{
  public static final int CREATE_FROM_LIST = 0;
  public static final int CREATE_FROM_TEXT_MESSAGE = 2;
  public static final int CREATE_FROM_TODO_MESSAGE = 1;
  public static final Parcelable.Creator<TodoInfo> CREATOR = new aupu();
  public static final int STATE_DONE = 2;
  public static final int STATE_UNDONE = 1;
  public int appid;
  public long c2cTempUin;
  public int c2cTempUinType;
  public String content;
  public long createTime;
  public long creatorUin;
  public long finishTime;
  public long fromUin;
  public int fromUinType;
  @notColumn
  public int istroop;
  public int msgRandom;
  public int msgSeq;
  public int msgTime;
  public String numStr;
  public long remindTime;
  public String scheduleId;
  public int status = 1;
  @unique
  public String todoId;
  @notColumn
  public long uniseq;
  public long updateTime;
  
  public TodoInfo() {}
  
  public TodoInfo(Parcel paramParcel)
  {
    this.todoId = paramParcel.readString();
    this.appid = paramParcel.readInt();
    this.creatorUin = paramParcel.readLong();
    this.content = paramParcel.readString();
    this.remindTime = paramParcel.readLong();
    this.scheduleId = paramParcel.readString();
    this.createTime = paramParcel.readLong();
    this.updateTime = paramParcel.readLong();
    this.finishTime = paramParcel.readLong();
    this.status = paramParcel.readInt();
    this.fromUin = paramParcel.readLong();
    this.fromUinType = paramParcel.readInt();
    this.msgSeq = paramParcel.readInt();
    this.msgTime = paramParcel.readInt();
    this.msgRandom = paramParcel.readInt();
    this.istroop = paramParcel.readInt();
    this.uniseq = paramParcel.readLong();
    this.c2cTempUinType = paramParcel.readInt();
    this.c2cTempUin = paramParcel.readLong();
    this.numStr = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof TodoInfo))) {
      return false;
    }
    return this.todoId.equals(((TodoInfo)paramObject).todoId);
  }
  
  public int getViewType()
  {
    if (this.status == 2) {
      return 0;
    }
    return 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.todoId);
    paramParcel.writeInt(this.appid);
    paramParcel.writeLong(this.creatorUin);
    paramParcel.writeString(this.content);
    paramParcel.writeLong(this.remindTime);
    paramParcel.writeString(this.scheduleId);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeLong(this.updateTime);
    paramParcel.writeLong(this.finishTime);
    paramParcel.writeInt(this.status);
    paramParcel.writeLong(this.fromUin);
    paramParcel.writeInt(this.fromUinType);
    paramParcel.writeInt(this.msgSeq);
    paramParcel.writeInt(this.msgTime);
    paramParcel.writeInt(this.msgRandom);
    paramParcel.writeInt(this.istroop);
    paramParcel.writeLong(this.uniseq);
    paramParcel.writeInt(this.c2cTempUinType);
    paramParcel.writeLong(this.c2cTempUin);
    paramParcel.writeString(this.numStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.data.TodoInfo
 * JD-Core Version:    0.7.0.1
 */