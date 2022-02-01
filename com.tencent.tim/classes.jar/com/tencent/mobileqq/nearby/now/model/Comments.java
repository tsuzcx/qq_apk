package com.tencent.mobileqq.nearby.now.model;

import ajwf;
import ajwg;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Comments
  implements Parcelable
{
  public static final Parcelable.Creator<Comments> CREATOR = new ajwf();
  public List<Comment> DG = new ArrayList();
  public long adn;
  public List<Comment> commentList = new ArrayList();
  public boolean isEnd;
  
  public Comments() {}
  
  public Comments(Parcel paramParcel)
  {
    this.adn = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isEnd = bool;
      paramParcel.readTypedList(this.commentList, Comment.CREATOR);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.adn);
    if (this.isEnd) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeTypedList(this.commentList);
      return;
    }
  }
  
  public static class Comment
    implements Parcelable
  {
    public static final Parcelable.Creator<Comment> CREATOR = new ajwg();
    public MedalInfo a;
    public long ado;
    public long adp;
    public String bSx;
    public String bSy;
    public String content;
    public int dll;
    public String headUrl;
    public long id;
    public String name;
    public long nowId;
    public int nowUserType;
    public long timestamp;
    public int type;
    public long uid;
    
    public Comment() {}
    
    public Comment(Parcel paramParcel)
    {
      this.a = ((MedalInfo)paramParcel.readParcelable(MedalInfo.class.getClassLoader()));
      this.id = paramParcel.readLong();
      this.content = paramParcel.readString();
      this.timestamp = paramParcel.readLong();
      this.type = paramParcel.readInt();
      this.uid = paramParcel.readLong();
      this.name = paramParcel.readString();
      this.headUrl = paramParcel.readString();
      this.nowUserType = paramParcel.readInt();
      this.nowId = paramParcel.readLong();
      this.ado = paramParcel.readLong();
      this.bSx = paramParcel.readString();
      this.bSy = paramParcel.readString();
      this.dll = paramParcel.readInt();
      this.adp = paramParcel.readLong();
    }
    
    public int describeContents()
    {
      return hashCode();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Comment))
      {
        paramObject = (Comment)paramObject;
        bool1 = bool2;
        if (this.id == paramObject.id) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return super.hashCode();
    }
    
    public String toString()
    {
      return super.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.a, paramInt);
      paramParcel.writeLong(this.id);
      paramParcel.writeString(this.content);
      paramParcel.writeLong(this.timestamp);
      paramParcel.writeLong(this.uid);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.headUrl);
      paramParcel.writeInt(this.nowUserType);
      paramParcel.writeLong(this.nowId);
      paramParcel.writeLong(this.ado);
      paramParcel.writeString(this.bSx);
      paramParcel.writeString(this.bSy);
      paramParcel.writeInt(this.dll);
      paramParcel.writeLong(this.adp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.Comments
 * JD-Core Version:    0.7.0.1
 */