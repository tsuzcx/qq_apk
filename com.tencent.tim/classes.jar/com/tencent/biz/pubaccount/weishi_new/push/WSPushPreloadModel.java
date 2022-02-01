package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import omo;
import org.json.JSONObject;

public class WSPushPreloadModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushPreloadModel> CREATOR = new omo();
  public boolean axP;
  public boolean axQ;
  public long zg;
  
  public WSPushPreloadModel() {}
  
  public WSPushPreloadModel(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.axP = bool1;
      this.zg = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label48;
      }
    }
    label48:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.axQ = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static WSPushPreloadModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    WSPushPreloadModel localWSPushPreloadModel = new WSPushPreloadModel();
    localWSPushPreloadModel.axP = paramJSONObject.optBoolean("is_preload_data");
    localWSPushPreloadModel.zg = paramJSONObject.optLong("valid_duration");
    localWSPushPreloadModel.axQ = paramJSONObject.optBoolean("is_preload_out_valid_duration");
    return localWSPushPreloadModel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    if (this.axP)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.zg);
      if (!this.axQ) {
        break label46;
      }
    }
    label46:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel
 * JD-Core Version:    0.7.0.1
 */