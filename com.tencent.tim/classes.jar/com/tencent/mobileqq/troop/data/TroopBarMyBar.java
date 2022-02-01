package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apax;

public class TroopBarMyBar
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarMyBar> CREATOR = new apax();
  public String bid;
  public String cnE;
  public int dSJ;
  public int dSK;
  public int dSL;
  public int dSM;
  public int dSN;
  public int dSO;
  public int dSP;
  public int dSQ;
  public int dSR;
  public int flag;
  public String intro;
  public int level;
  public String name;
  public String pic;
  
  public TroopBarMyBar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, int paramInt8, int paramInt9, String paramString2, String paramString3, int paramInt10, String paramString4, int paramInt11, String paramString5)
  {
    this.dSJ = paramInt1;
    this.dSK = paramInt2;
    this.dSL = paramInt3;
    this.level = paramInt4;
    this.flag = paramInt5;
    this.dSM = paramInt6;
    this.dSN = paramInt7;
    this.name = paramString1;
    this.dSO = paramInt8;
    this.dSP = paramInt9;
    this.pic = paramString2;
    this.bid = paramString3;
    this.dSQ = paramInt10;
    this.intro = paramString4;
    this.dSR = paramInt11;
    this.cnE = paramString5;
  }
  
  public TroopBarMyBar(long paramLong, String paramString)
  {
    this.bid = String.valueOf(paramLong);
    this.name = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopBarMyBar)) {
      return ((TroopBarMyBar)paramObject).bid.equals(this.bid);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dSJ);
    paramParcel.writeInt(this.dSK);
    paramParcel.writeInt(this.dSL);
    paramParcel.writeInt(this.level);
    paramParcel.writeInt(this.flag);
    paramParcel.writeInt(this.dSM);
    paramParcel.writeInt(this.dSN);
    if (this.name == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeInt(this.dSO);
      paramParcel.writeInt(this.dSP);
      if (this.pic != null) {
        break label172;
      }
      str = "";
      label97:
      paramParcel.writeString(str);
      if (this.bid != null) {
        break label180;
      }
      str = "";
      label112:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.dSQ);
      if (this.intro != null) {
        break label188;
      }
      str = "";
      label135:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.dSR);
      if (this.cnE != null) {
        break label196;
      }
    }
    label172:
    label180:
    label188:
    label196:
    for (String str = "";; str = this.cnE)
    {
      paramParcel.writeString(str);
      return;
      str = this.name;
      break;
      str = this.pic;
      break label97;
      str = this.bid;
      break label112;
      str = this.intro;
      break label135;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarMyBar
 * JD-Core Version:    0.7.0.1
 */