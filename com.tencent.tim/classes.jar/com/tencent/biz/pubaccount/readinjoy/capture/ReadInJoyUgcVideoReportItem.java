package com.tencent.biz.pubaccount.readinjoy.capture;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kqk;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyUgcVideoReportItem
  implements Parcelable
{
  public static final Parcelable.Creator<ReadInJoyUgcVideoReportItem> CREATOR = new kqk();
  public int aLj;
  public double aT;
  public String abL;
  public String abM;
  public String abN;
  public String abO;
  public String abP;
  public String abQ;
  public String abR;
  public String msgId;
  public long videoSize;
  
  public ReadInJoyUgcVideoReportItem() {}
  
  public ReadInJoyUgcVideoReportItem(Parcel paramParcel)
  {
    this.aT = paramParcel.readDouble();
    this.msgId = paramParcel.readString();
    this.abL = paramParcel.readString();
    this.abM = paramParcel.readString();
    this.abN = paramParcel.readString();
    this.abO = paramParcel.readString();
    this.abP = paramParcel.readString();
    this.abQ = paramParcel.readString();
    this.videoSize = paramParcel.readLong();
    this.aLj = paramParcel.readInt();
    this.abR = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("op_duration", this.aT);
      localJSONObject.put("msg_id", this.msgId);
      localJSONObject.put("msg_feature", this.abL);
      localJSONObject.put("content_source", this.abM);
      localJSONObject.put("element_type", this.abN);
      localJSONObject.put("element_tag", this.abO);
      localJSONObject.put("element_id", this.abP);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.aT);
    paramParcel.writeString(this.msgId);
    paramParcel.writeString(this.abL);
    paramParcel.writeString(this.abM);
    paramParcel.writeString(this.abN);
    paramParcel.writeString(this.abO);
    paramParcel.writeString(this.abP);
    paramParcel.writeString(this.abQ);
    paramParcel.writeLong(this.videoSize);
    paramParcel.writeInt(this.aLj);
    paramParcel.writeString(this.abR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem
 * JD-Core Version:    0.7.0.1
 */