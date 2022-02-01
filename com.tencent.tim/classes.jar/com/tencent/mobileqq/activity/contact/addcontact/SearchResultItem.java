package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import yox;

public class SearchResultItem
  implements Parcelable
{
  public static final Parcelable.Creator<SearchResultItem> CREATOR = new yox();
  public byte bInContact;
  public byte bIsEnterpriseQQ;
  public byte bIsFriend;
  public byte[] cr;
  public byte[] cs;
  public long lUIN;
  public int source;
  public String strMobile = "";
  public String strNick = "";
  
  public SearchResultItem() {}
  
  public SearchResultItem(Parcel paramParcel)
  {
    this.lUIN = paramParcel.readLong();
    this.source = paramParcel.readInt();
    this.strNick = paramParcel.readString();
    this.strMobile = paramParcel.readString();
    this.bIsFriend = paramParcel.readByte();
    this.bInContact = paramParcel.readByte();
    this.bIsEnterpriseQQ = paramParcel.readByte();
    this.cr = paramParcel.createByteArray();
    this.cs = paramParcel.createByteArray();
  }
  
  public SearchResultItem(AccountSearchPb.record paramrecord)
  {
    if (paramrecord != null)
    {
      this.lUIN = paramrecord.uin.get();
      this.source = paramrecord.source.get();
      this.strNick = paramrecord.name.get();
      this.strMobile = paramrecord.mobile.get();
      this.bIsFriend = ((byte)(int)(paramrecord.relation.get() & 1L));
      this.bInContact = ((byte)(int)(paramrecord.relation.get() & 0x2));
      this.cs = paramrecord.bytes_token.get().toByteArray();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.lUIN);
    paramParcel.writeInt(this.source);
    paramParcel.writeString(this.strNick);
    paramParcel.writeString(this.strMobile);
    paramParcel.writeByte(this.bIsFriend);
    paramParcel.writeByte(this.bInContact);
    paramParcel.writeByte(this.bIsEnterpriseQQ);
    paramParcel.writeByteArray(this.cr);
    paramParcel.writeByteArray(this.cs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem
 * JD-Core Version:    0.7.0.1
 */