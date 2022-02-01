package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avvj;
import java.util.ArrayList;

public class WeishiShareDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiShareDataInfo> CREATOR = new avvj();
  public ArrayList<WeishiPictureUrl> Fc;
  public String sSummary;
  public String sTitle;
  
  public WeishiShareDataInfo(Parcel paramParcel)
  {
    this.sTitle = paramParcel.readString();
    this.sSummary = paramParcel.readString();
    this.Fc = new ArrayList();
    paramParcel.readTypedList(this.Fc, WeishiPictureUrl.CREATOR);
  }
  
  public WeishiShareDataInfo(String paramString1, String paramString2, ArrayList<WeishiPictureUrl> paramArrayList)
  {
    this.sTitle = paramString1;
    this.sSummary = paramString2;
    this.Fc = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sTitle);
    paramParcel.writeString(this.sSummary);
    paramParcel.writeTypedList(this.Fc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.WeishiShareDataInfo
 * JD-Core Version:    0.7.0.1
 */