package com.tencent.qqpimsecure.wificore.api.connect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class WifiConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WifiConfig> CREATOR = new WifiConfig.1();
  protected ArrayList<Psk> eA;
  protected ArrayList<Eap> eB;
  public boolean eC = false;
  public int eD = -1;
  public int eE = 0;
  public int eF = 0;
  public int eG = 0;
  public String eH = "";
  private int eI = -1;
  public int eJ = -1;
  public boolean eK = false;
  public int eL = -1;
  public int eM = -1;
  public int en = -1;
  public int eq = -1;
  public String ey = "";
  public int ez = -1;
  
  public WifiConfig() {}
  
  public WifiConfig(Parcel paramParcel)
  {
    this.ey = paramParcel.readString();
    this.eA = paramParcel.readArrayList(Psk.class.getClassLoader());
    this.eB = paramParcel.readArrayList(Eap.class.getClassLoader());
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.eC = bool;
      this.ez = paramParcel.readInt();
      this.eD = paramParcel.readInt();
      this.eE = paramParcel.readInt();
      this.eH = paramParcel.readString();
      this.eG = paramParcel.readInt();
      this.eF = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public Psk a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    if (this.eA == null) {
      this.eA = new ArrayList();
    }
    paramString = new Psk(paramString, paramBoolean, paramInt1, paramInt2);
    this.eA.add(paramString);
    return paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WifiConfig [mSsid=" + this.ey + ", mSecurity=" + this.ez + " mWifiType=" + this.eE + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ey);
    paramParcel.writeList(this.eA);
    paramParcel.writeList(this.eB);
    if (this.eC) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.ez);
      paramParcel.writeInt(this.eD);
      paramParcel.writeInt(this.eE);
      paramParcel.writeString(this.eH);
      paramParcel.writeInt(this.eG);
      paramParcel.writeInt(this.eF);
      return;
    }
  }
  
  public static class Eap
    implements Parcelable
  {
    public static final Parcelable.Creator<WifiConfig.Psk> CREATOR = new WifiConfig.Eap.1();
    protected String eN;
    protected String eO;
    protected boolean eP;
    public int eQ;
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof Eap))) {}
      do
      {
        return false;
        paramObject = (Eap)paramObject;
      } while ((paramObject.eP != this.eP) || (paramObject.eN.compareTo(this.eN) != 0) || (paramObject.eO.compareTo(this.eO) != 0));
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.eN);
      paramParcel.writeString(this.eO);
      if (this.eP) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.eQ);
        return;
      }
    }
  }
  
  public static class Psk
    implements Parcelable
  {
    public static final Parcelable.Creator<Psk> CREATOR = new WifiConfig.Psk.1();
    protected boolean eP = false;
    public int eQ = 0;
    protected String eR;
    public int eS = 0;
    public int eT = 0;
    
    public Psk(Parcel paramParcel)
    {
      this.eR = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.eP = bool;
        this.eQ = paramParcel.readInt();
        this.eS = paramParcel.readInt();
        this.eT = paramParcel.readInt();
        return;
        bool = false;
      }
    }
    
    public Psk(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.eR = paramString;
      this.eP = paramBoolean;
      this.eS = paramInt1;
      this.eT = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof Psk))) {}
      do
      {
        return false;
        paramObject = (Psk)paramObject;
      } while ((paramObject.eP != this.eP) || (paramObject.eR.compareTo(this.eR) != 0));
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.eR);
      if (this.eP) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.eQ);
        paramParcel.writeInt(this.eS);
        paramParcel.writeInt(this.eT);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.WifiConfig
 * JD-Core Version:    0.7.0.1
 */