package com.tencent.mobileqq.app.proxy;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.TroopInfo;
import fkq;

public class TroopInfoProxy
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new fkq();
  public static final int a = 0;
  public static final int b = 64;
  public static final int c = 65;
  public static final int d = 66;
  public static final int e = 67;
  public static final int f = 68;
  public static final int g = 69;
  public static final int h = 70;
  public static final int i = 71;
  public static final int j = 97;
  public static final int k = 98;
  public static final int l = 99;
  public static final int m = 100;
  public static final int n = 101;
  public static final int o = 102;
  public static final int p = 103;
  public static final int q = 104;
  public static final int r = 105;
  public static final int s = 106;
  public static final int t = 107;
  public static final int u = 108;
  private TroopInfo a;
  
  public TroopInfoProxy(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public static String a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 96: 
    default: 
      return null;
    case 65: 
      return BaseApplicationImpl.getContext().getString(2131559200);
    case 64: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 71: 
      return BaseApplicationImpl.getContext().getString(2131559200);
    case 97: 
      return BaseApplicationImpl.getContext().getString(2131559201);
    case 70: 
    case 98: 
      return BaseApplicationImpl.getContext().getString(2131559202);
    case 99: 
    case 100: 
      return BaseApplicationImpl.getContext().getString(2131559200);
    case 101: 
    case 102: 
    case 103: 
      return BaseApplicationImpl.getContext().getString(2131559203);
    case 104: 
      return BaseApplicationImpl.getContext().getString(2131559204);
    case 105: 
      return BaseApplicationImpl.getContext().getString(2131559205);
    case 106: 
      return BaseApplicationImpl.getContext().getString(2131559206);
    case 107: 
      return BaseApplicationImpl.getContext().getString(2131559200);
    }
    return BaseApplicationImpl.getContext().getString(2131559207);
  }
  
  public TroopInfo a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.uin);
    paramParcel.writeLong(this.a.timeSec);
    paramParcel.writeString(this.a.troopuin);
    paramParcel.writeString(this.a.troopcode);
    paramParcel.writeString(this.a.troopowneruin);
    paramParcel.writeString(this.a.troopname);
    paramParcel.writeInt(this.a.troopface);
    paramParcel.writeString(this.a.troopmemo);
    paramParcel.writeString(this.a.fingertroopmemo);
    paramParcel.writeInt(this.a.troopmask);
    paramParcel.writeInt(this.a.trooptype);
    paramParcel.writeLong(this.a.troopCreateTime);
    paramParcel.writeLong(this.a.dwGroupFlag);
    paramParcel.writeInt(this.a.troopmask);
    paramParcel.writeInt(this.a.cGroupOption);
    paramParcel.writeInt(this.a.wMemberMax);
    paramParcel.writeInt(this.a.wSpecialClass);
    paramParcel.writeInt(this.a.cGroupLevel);
    paramParcel.writeInt(this.a.wMemberNum);
    paramParcel.writeString(this.a.Administrator);
    paramParcel.writeLong(this.a.dwGroupClassExt);
    paramParcel.writeLong(this.a.dwGroupFlagExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.TroopInfoProxy
 * JD-Core Version:    0.7.0.1
 */