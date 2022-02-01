package com.tencent.mobileqq.troop.data;

import acfp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import apay;
import org.json.JSONObject;
import ram;

public class TroopBarPOI
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarPOI> CREATOR = new apay();
  public final String Tr;
  public final String cnF;
  public final String cnG;
  public final int latitude;
  public final int longitude;
  public final String name;
  public final String uid;
  
  public TroopBarPOI(TroopBarPOI paramTroopBarPOI)
  {
    this.uid = paramTroopBarPOI.uid;
    this.cnF = paramTroopBarPOI.cnF;
    this.name = paramTroopBarPOI.name;
    this.longitude = paramTroopBarPOI.longitude;
    this.Tr = paramTroopBarPOI.Tr;
    this.latitude = paramTroopBarPOI.latitude;
    this.cnG = paramTroopBarPOI.cnG;
  }
  
  public TroopBarPOI(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.uid = paramString1;
    this.cnF = paramString2;
    this.name = paramString3;
    this.longitude = paramInt1;
    this.Tr = paramString4;
    this.latitude = paramInt2;
    this.cnG = paramString5;
  }
  
  public TroopBarPOI(JSONObject paramJSONObject)
  {
    this.uid = paramJSONObject.optString("uid", "");
    this.cnF = paramJSONObject.optString("catalog", "");
    this.name = paramJSONObject.optString("name", "");
    this.longitude = ((int)(paramJSONObject.optDouble("longitude", -1.0D) * 1000000.0D));
    this.Tr = paramJSONObject.optString("addr", "");
    this.latitude = ((int)(paramJSONObject.optDouble("latitude", -1.0D) * 1000000.0D));
    this.cnG = paramJSONObject.optString("dist", "");
  }
  
  public static String oB(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("TroopBarPOI", "location is null while spliting location!");
      return null;
    }
    String[] arrayOfString = paramString.split("·");
    if (arrayOfString.length == 1) {
      paramString = arrayOfString[0];
    }
    for (;;)
    {
      ram.d("TroopBarPOI", "location name is %s.", paramString);
      return paramString;
      paramString = localObject;
      if (arrayOfString.length > 1) {
        paramString = arrayOfString[1];
      }
    }
  }
  
  public static String oC(String paramString)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("TroopBarPOI", "location is null while spliting location!");
      return null;
    }
    Object localObject2 = paramString.split("·");
    if (localObject2.length == 1)
    {
      localObject2 = localObject2[0];
      localObject1 = localObject2;
      if (((String)localObject2).endsWith(acfp.m(2131715579))) {
        localObject1 = paramString.substring(0, paramString.length() - 1);
      }
    }
    for (;;)
    {
      ram.d("TroopBarPOI", "location name is %s.", localObject1);
      return localObject1;
      if (localObject2.length > 1) {
        localObject1 = localObject2[0];
      }
    }
  }
  
  public String AU()
  {
    if (TextUtils.isEmpty(this.name))
    {
      ram.e("TroopBarPOI", "name is empty while get location string!");
      return null;
    }
    if (TextUtils.isEmpty(this.cnF))
    {
      ram.w("TroopBarPOI", "catelog is empty while get location string!");
      return this.name;
    }
    String str2 = this.cnF;
    String str1 = str2;
    if (str2.endsWith(acfp.m(2131715605))) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    return str1 + "·" + this.name;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof TroopBarPOI))
    {
      paramObject = (TroopBarPOI)paramObject;
      bool1 = bool2;
      if (TextUtils.equals(paramObject.name, this.name))
      {
        bool1 = bool2;
        if (TextUtils.equals(paramObject.Tr, this.Tr)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.cnF);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.longitude);
    paramParcel.writeString(this.Tr);
    paramParcel.writeInt(this.latitude);
    paramParcel.writeString(this.cnG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPOI
 * JD-Core Version:    0.7.0.1
 */