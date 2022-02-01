package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anzq;
import aoaf;
import com.tencent.qphone.base.util.QLog;

public class DocsGrayTipsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DocsGrayTipsInfo> CREATOR = new anzq();
  public String ciL = "";
  public String ciM = "";
  public String ciN = "";
  public String ciO = "";
  public String ciP = "";
  public String ciQ = "";
  public String ciR = "";
  public String ciS = "";
  public String ciT = "";
  public String ciU = "";
  public String ciV = "";
  public String ciW = "";
  public String ciX = "";
  public String ciY = "";
  public String ciZ = "";
  public String cja = "";
  public String highlightText = "";
  public String type = "";
  public String uin = "";
  public String url = "";
  
  public DocsGrayTipsInfo() {}
  
  public DocsGrayTipsInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.url = paramParcel.readString();
    this.type = paramParcel.readString();
    this.ciL = paramParcel.readString();
    this.ciM = paramParcel.readString();
    this.highlightText = paramParcel.readString();
    this.ciN = paramParcel.readString();
    this.ciO = paramParcel.readString();
    this.ciP = paramParcel.readString();
    this.ciQ = paramParcel.readString();
    this.ciR = paramParcel.readString();
    this.ciS = paramParcel.readString();
    this.ciT = paramParcel.readString();
    this.ciU = paramParcel.readString();
    this.ciV = paramParcel.readString();
    this.ciW = paramParcel.readString();
    this.ciX = paramParcel.readString();
    this.ciY = paramParcel.readString();
    this.ciZ = paramParcel.readString();
    this.cja = paramParcel.readString();
  }
  
  public int[] ab()
  {
    int[] arrayOfInt = new int[2];
    try
    {
      String[] arrayOfString = this.highlightText.split("-");
      arrayOfInt[0] = Integer.valueOf(arrayOfString[0]).intValue();
      arrayOfInt[1] = Integer.valueOf(arrayOfString[1]).intValue();
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      QLog.e(aoaf.cjv, 1, "get height light area exception = " + localException.toString());
    }
    return arrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DocsGrayTipsInfo | uin =" + this.uin + " , url=" + this.url + " , type = " + this.type + " , optType = " + this.ciL + " , authTips =" + this.ciM + " , highlightText =" + this.highlightText + " , setflag =" + this.ciN + " , setPolicy =" + this.ciO + " , setOnly =" + this.ciP + " , sucResult =" + this.ciQ + " , failResult =" + this.ciR + " , netFailResult =" + this.ciS + " , policy = " + this.ciT + " , privilege = " + this.ciU + " , member_num= " + this.ciV + " , remainTime=" + this.ciW + " , setTime= " + this.ciX + " , bNeedSetTime =" + this.ciY + " , tipType =" + this.ciZ + " , tipUrl =" + this.cja;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.ciL);
    paramParcel.writeString(this.ciM);
    paramParcel.writeString(this.highlightText);
    paramParcel.writeString(this.ciN);
    paramParcel.writeString(this.ciO);
    paramParcel.writeString(this.ciP);
    paramParcel.writeString(this.ciQ);
    paramParcel.writeString(this.ciR);
    paramParcel.writeString(this.ciS);
    paramParcel.writeString(this.ciT);
    paramParcel.writeString(this.ciU);
    paramParcel.writeString(this.ciV);
    paramParcel.writeString(this.ciW);
    paramParcel.writeString(this.ciX);
    paramParcel.writeString(this.ciY);
    paramParcel.writeString(this.ciZ);
    paramParcel.writeString(this.cja);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.DocsGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */