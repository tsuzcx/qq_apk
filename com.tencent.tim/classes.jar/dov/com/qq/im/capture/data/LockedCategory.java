package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axqh;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class LockedCategory
  implements Parcelable
{
  public static final Parcelable.Creator<LockedCategory> CREATOR = new axqh();
  public String cVJ;
  private String cVK;
  public String cye;
  public boolean dwb = true;
  public boolean dwc;
  public String mId;
  public int mType;
  
  public LockedCategory(Parcel paramParcel)
  {
    this.mId = paramParcel.readString();
    this.cVJ = paramParcel.readString();
    this.cye = paramParcel.readString();
    this.cVK = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.dwb = bool;
      return;
      bool = false;
    }
  }
  
  public LockedCategory(JSONObject paramJSONObject)
  {
    this.mId = paramJSONObject.optString("comboId");
    this.cVJ = paramJSONObject.optString("introduceUrl");
    this.cye = paramJSONObject.optString("backgroundUrl");
    this.cVK = paramJSONObject.optString("expire_date");
    this.mType = paramJSONObject.optInt("unlock_type", 1);
    this.dwb = true;
  }
  
  public boolean aPx()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    try
    {
      boolean bool = new Date(NetConnInfoCenter.getServerTimeMillis()).after(localSimpleDateFormat.parse(this.cVK.toString()));
      if (!bool) {
        break label41;
      }
    }
    catch (ParseException localParseException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LockedCategory", 2, localParseException, new Object[0]);
    }
    return true;
    label41:
    return false;
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LockedCategory").append(":").append(this.mId).append(",");
    localStringBuilder.append(this.mType).append(",").append(this.cVK).append(",").append(this.cVJ).append(",");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    paramParcel.writeString(this.cVJ);
    paramParcel.writeString(this.cye);
    paramParcel.writeString(this.cVK);
    if (this.dwb) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.LockedCategory
 * JD-Core Version:    0.7.0.1
 */