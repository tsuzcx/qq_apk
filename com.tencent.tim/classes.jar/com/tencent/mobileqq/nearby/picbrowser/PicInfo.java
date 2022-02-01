package com.tencent.mobileqq.nearby.picbrowser;

import akbu;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PicInfo> CREATOR = new akbu();
  public String bSZ;
  public String bTa;
  public String localPath;
  public int photoId = -1;
  public String thumbUrl;
  public String videoId;
  public String videoLocalPath;
  public String videoUrl;
  
  public PicInfo() {}
  
  public PicInfo(Parcel paramParcel)
  {
    this.photoId = paramParcel.readInt();
    this.bSZ = paramParcel.readString();
    this.thumbUrl = paramParcel.readString();
    this.localPath = paramParcel.readString();
    this.videoUrl = paramParcel.readString();
    this.videoLocalPath = paramParcel.readString();
    this.videoId = paramParcel.readString();
    this.bTa = paramParcel.readString();
  }
  
  public static List<PicInfo> convertFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    for (;;)
    {
      return null;
      localArrayList = new ArrayList();
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          PicInfo localPicInfo = new PicInfo();
          if (localJSONObject.has("photoId")) {
            localPicInfo.photoId = localJSONObject.getInt("photoId");
          }
          if (localJSONObject.has("localPath")) {
            localPicInfo.localPath = localJSONObject.getString("localPath");
          }
          if (localJSONObject.has("thumbUrl")) {
            localPicInfo.thumbUrl = localJSONObject.getString("thumbUrl");
          }
          if (localJSONObject.has("bigPicUrl")) {
            localPicInfo.bSZ = localJSONObject.getString("bigPicUrl");
          }
          if (localJSONObject.has("videoUrl")) {
            localPicInfo.videoUrl = localJSONObject.getString("videoUrl");
          }
          if (localJSONObject.has("videoLocalPath")) {
            localPicInfo.videoLocalPath = localJSONObject.getString("videoLocalPath");
          }
          if (localJSONObject.has("videoId")) {
            localPicInfo.videoId = localJSONObject.getString("videoId");
          }
          localArrayList.add(localPicInfo);
          i += 1;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (JSONException paramString) {}
    }
    QLog.i("Q.nearby_people_card.", 4, "picInfo convertFrom exception : " + paramString.getMessage());
    return null;
    return localArrayList;
  }
  
  public JSONObject ad()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("photoId", this.photoId);
      if (!TextUtils.isEmpty(this.localPath)) {
        localJSONObject.put("localPath", this.localPath);
      }
      if (!TextUtils.isEmpty(this.thumbUrl)) {
        localJSONObject.put("thumbUrl", this.thumbUrl);
      }
      if (!TextUtils.isEmpty(this.bSZ)) {
        localJSONObject.put("bigPicUrl", this.bSZ);
      }
      if (!TextUtils.isEmpty(this.videoUrl)) {
        localJSONObject.put("videoUrl", this.videoUrl);
      }
      if (!TextUtils.isEmpty(this.videoLocalPath)) {
        localJSONObject.put("videoLocalPath", this.videoLocalPath);
      }
      if (!TextUtils.isEmpty(this.videoId)) {
        localJSONObject.put("videoId", this.videoId);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.nearby_people_card.", 4, "picInfo convert2Json exception : " + localJSONException.getMessage());
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("photoId:").append(this.photoId).append(",localPath:").append(this.localPath).append(" ,thumbUrl:").append(this.thumbUrl).append(" ,bigPicUrl:").append(this.bSZ).append(" ,videoUrl:").append(this.videoUrl).append(" ,videoLocalPath:").append(this.videoLocalPath).append(" ,videoId:").append(this.videoId).append(" ,picType:").append(this.bTa);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.photoId);
    paramParcel.writeString(this.bSZ);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.localPath);
    paramParcel.writeString(this.videoUrl);
    paramParcel.writeString(this.videoLocalPath);
    paramParcel.writeString(this.videoId);
    paramParcel.writeString(this.bTa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicInfo
 * JD-Core Version:    0.7.0.1
 */