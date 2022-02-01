package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import oml;
import org.json.JSONObject;

public class WSPushGloryKingModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushGloryKingModel> CREATOR = new oml();
  public String aqv;
  public int bfs;
  
  protected WSPushGloryKingModel() {}
  
  public WSPushGloryKingModel(Parcel paramParcel)
  {
    this.bfs = paramParcel.readInt();
    this.aqv = paramParcel.readString();
  }
  
  protected static WSPushGloryKingModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushGloryKingModel localWSPushGloryKingModel = new WSPushGloryKingModel();
      localWSPushGloryKingModel.bfs = paramJSONObject.optInt("material_type");
      localWSPushGloryKingModel.aqv = paramJSONObject.optString("attach");
      return localWSPushGloryKingModel;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.bfs);
    paramParcel.writeString(this.aqv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushGloryKingModel
 * JD-Core Version:    0.7.0.1
 */