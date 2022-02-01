package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anzv;
import java.util.ArrayList;
import java.util.List;

public class ReSendCmd
  implements Parcelable
{
  public static final Parcelable.Creator<ReSendCmd> CREATOR = new anzv();
  List<String> GP;
  public String cjb = "";
  String cjc = "";
  public int cmd;
  int dNF;
  int dNG;
  public int dNH;
  int dNI = 0;
  int domainId;
  
  public ReSendCmd() {}
  
  public ReSendCmd(Parcel paramParcel)
  {
    this.cmd = paramParcel.readInt();
    this.dNF = paramParcel.readInt();
    this.dNG = paramParcel.readInt();
    this.dNH = paramParcel.readInt();
    this.cjb = paramParcel.readString();
    this.domainId = paramParcel.readInt();
    this.cjc = paramParcel.readString();
    if (this.GP == null) {
      this.GP = new ArrayList();
    }
    paramParcel.readStringList(this.GP);
    this.dNI = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("urlSrcType : ").append(this.dNI).append(" | padUrl : ").append(this.cjb);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cmd);
    paramParcel.writeInt(this.dNF);
    paramParcel.writeInt(this.dNG);
    paramParcel.writeInt(this.dNH);
    paramParcel.writeString(this.cjb);
    paramParcel.writeInt(this.domainId);
    paramParcel.writeString(this.cjc);
    paramParcel.writeStringList(this.GP);
    paramParcel.writeInt(this.dNI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.ReSendCmd
 * JD-Core Version:    0.7.0.1
 */