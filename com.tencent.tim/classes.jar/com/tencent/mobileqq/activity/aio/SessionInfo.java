package com.tencent.mobileqq.activity.aio;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import wkj;
import wmx;

public class SessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SessionInfo> CREATOR = new wmx();
  public long Ib = -1L;
  public long Ic;
  public long Ie;
  public String Vx;
  public wkj a;
  public String aTl;
  public String aTm;
  public String aTn;
  public String aTo;
  public String aTp = "";
  public String aTq;
  private String aTr;
  private String aTs;
  public int bPt = 3999;
  public int bPu;
  public int bPv;
  public boolean beA;
  public boolean beB;
  public boolean beq;
  public boolean ber;
  public boolean bes;
  public boolean bet;
  public boolean beu;
  public boolean bev;
  public boolean bew;
  public boolean bex;
  public boolean bey;
  public boolean bez;
  public int cN;
  public int cZ;
  public int entrance = 0;
  public boolean isBarrageMsg;
  public boolean isNightMode;
  private Bundle mExtras;
  public String phoneNum;
  public int topicId;
  public String troopUin;
  
  public SessionInfo() {}
  
  public SessionInfo(Parcel paramParcel)
  {
    this.cZ = paramParcel.readInt();
    this.aTl = paramParcel.readString();
    this.troopUin = paramParcel.readString();
    this.aTn = paramParcel.readString();
    this.phoneNum = paramParcel.readString();
    this.bPt = paramParcel.readInt();
    this.aTs = paramParcel.readString();
    this.aTr = paramParcel.readString();
    this.mExtras = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String pj()
  {
    return this.aTs;
  }
  
  public String pk()
  {
    return this.aTr;
  }
  
  public void reset()
  {
    this.beA = false;
    this.aTq = null;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.mExtras = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cZ);
    paramParcel.writeString(this.aTl);
    paramParcel.writeString(this.troopUin);
    paramParcel.writeString(this.aTn);
    paramParcel.writeString(this.phoneNum);
    paramParcel.writeInt(this.bPt);
    paramParcel.writeString(this.aTs);
    paramParcel.writeString(this.aTr);
    paramParcel.writeBundle(this.mExtras);
  }
  
  public void xw(String paramString)
  {
    this.aTs = paramString;
  }
  
  public void xx(String paramString)
  {
    this.aTr = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SessionInfo
 * JD-Core Version:    0.7.0.1
 */