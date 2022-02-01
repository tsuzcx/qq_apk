package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avqp;
import java.util.ArrayList;
import java.util.Map;

public class QZoneShareData
  implements Parcelable
{
  public static final Parcelable.Creator<QZoneShareData> CREATOR = new avqp();
  public ArrayList<String> ER;
  public String action;
  public String appName;
  public long appid;
  public long azQ;
  public String cMX;
  public String cMY;
  public String cMZ;
  public String cNa;
  public String cpM;
  public int exU;
  public String extString;
  public int from;
  public int iUrlInfoFrm;
  public String mSummary;
  public String mTitle;
  public String openId;
  public String pkgname;
  public Map<String, String> qc;
  public String targetUrl;
  public Map<String, String> xcxMapEx;
  
  public QZoneShareData() {}
  
  private QZoneShareData(Parcel paramParcel)
  {
    this.appid = paramParcel.readLong();
    this.openId = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mSummary = paramParcel.readString();
    this.targetUrl = paramParcel.readString();
    this.ER = new ArrayList();
    paramParcel.readStringList(this.ER);
    this.appName = paramParcel.readString();
    this.cMX = paramParcel.readString();
    this.extString = paramParcel.readString();
    this.iUrlInfoFrm = paramParcel.readInt();
    this.from = paramParcel.readInt();
    this.action = paramParcel.readString();
    this.pkgname = paramParcel.readString();
    this.exU = paramParcel.readInt();
    this.cMY = paramParcel.readString();
    this.azQ = paramParcel.readLong();
    this.cpM = paramParcel.readString();
    this.cMZ = paramParcel.readString();
    this.cNa = paramParcel.readString();
    this.qc = paramParcel.readHashMap(Map.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "appid:" + this.appid + " openId:" + this.openId + " mTitle:" + this.mTitle + " mSummary:" + this.mSummary + " targetUrl:" + this.targetUrl + " mImageUrl:" + this.ER.toString() + " appName:" + this.appName + " shareUin:" + this.cMX + " extString:" + this.extString + " from:" + this.from + " action:" + this.action + " pkgname:" + this.pkgname + " iUrlInfoFrm" + this.iUrlInfoFrm + " mWebUrl:" + this.cNa;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.appid);
    paramParcel.writeString(this.openId);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSummary);
    paramParcel.writeString(this.targetUrl);
    paramParcel.writeStringList(this.ER);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.cMX);
    paramParcel.writeString(this.extString);
    paramParcel.writeInt(this.iUrlInfoFrm);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.action);
    paramParcel.writeString(this.pkgname);
    paramParcel.writeInt(this.exU);
    paramParcel.writeString(this.cMY);
    paramParcel.writeLong(this.azQ);
    paramParcel.writeString(this.cpM);
    paramParcel.writeString(this.cMZ);
    paramParcel.writeString(this.cNa);
    paramParcel.writeMap(this.qc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneShareData
 * JD-Core Version:    0.7.0.1
 */