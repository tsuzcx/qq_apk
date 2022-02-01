package com.tencent.tim.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aujy;
import java.util.List;

public class ReSendCmd
  implements Parcelable
{
  public static final Parcelable.Creator<com.tencent.mobileqq.teamwork.ReSendCmd> CREATOR = new aujy();
  public List<String> GP;
  public String cjb = "";
  String cjc = "";
  public int cmd;
  public int dNF;
  public int dNG;
  public int dNH;
  public int dNI = 0;
  public boolean djb;
  public boolean djc;
  int domainId;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.ReSendCmd
 * JD-Core Version:    0.7.0.1
 */