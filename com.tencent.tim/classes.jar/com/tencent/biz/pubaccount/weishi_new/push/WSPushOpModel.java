package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import omn;
import org.json.JSONObject;

public class WSPushOpModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushOpModel> CREATOR = new omn();
  public int aSO;
  public String aqw;
  
  protected WSPushOpModel() {}
  
  public WSPushOpModel(Parcel paramParcel)
  {
    this.aSO = paramParcel.readInt();
    this.aqw = paramParcel.readString();
  }
  
  protected static WSPushOpModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushOpModel localWSPushOpModel = new WSPushOpModel();
      localWSPushOpModel.aqw = paramJSONObject.optString("op_id");
      localWSPushOpModel.aSO = paramJSONObject.optInt("op_type");
      return localWSPushOpModel;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aSO);
    paramParcel.writeString(this.aqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushOpModel
 * JD-Core Version:    0.7.0.1
 */