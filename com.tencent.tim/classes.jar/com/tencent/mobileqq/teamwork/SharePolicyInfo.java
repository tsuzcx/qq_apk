package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anzw;

public class SharePolicyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SharePolicyInfo> CREATOR = new anzw();
  public String cjd;
  public String cje;
  public String cjf;
  public String cjg;
  public String cjh;
  public String cji;
  public String cjj;
  public String cjk;
  public int dNJ;
  public int docType;
  public String folderId;
  public boolean isCreator;
  public String padId;
  public int policy;
  public String share_url;
  public int taskType;
  public String title;
  
  public SharePolicyInfo() {}
  
  public SharePolicyInfo(Parcel paramParcel)
  {
    this.cjd = paramParcel.readString();
    this.cje = paramParcel.readString();
    this.policy = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isCreator = bool;
      this.cjf = paramParcel.readString();
      this.docType = paramParcel.readInt();
      this.cjg = paramParcel.readString();
      this.taskType = paramParcel.readInt();
      this.share_url = paramParcel.readString();
      this.dNJ = paramParcel.readInt();
      this.cjh = paramParcel.readString();
      this.cji = paramParcel.readString();
      this.padId = paramParcel.readString();
      this.cjj = paramParcel.readString();
      this.title = paramParcel.readString();
      this.folderId = paramParcel.readString();
      this.cjk = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cjd);
    paramParcel.writeString(this.cje);
    paramParcel.writeInt(this.policy);
    if (this.isCreator) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.cjf);
      paramParcel.writeInt(this.docType);
      paramParcel.writeString(this.cjg);
      paramParcel.writeInt(this.taskType);
      paramParcel.writeString(this.share_url);
      paramParcel.writeInt(this.dNJ);
      paramParcel.writeString(this.cjh);
      paramParcel.writeString(this.cji);
      paramParcel.writeString(this.padId);
      paramParcel.writeString(this.cjj);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.folderId);
      paramParcel.writeString(this.cjk);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.SharePolicyInfo
 * JD-Core Version:    0.7.0.1
 */