package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avun;
import cooperation.qzone.widget.RedTouchExtendButton.RedInfo;

public class DiscoverTab
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoverTab> CREATOR = new avun();
  public RedTouchExtendButton.RedInfo a;
  public boolean aHE;
  public String cNX;
  public boolean doT;
  public int entranceId;
  public int index;
  public String name;
  public String qbossTrace;
  public String url;
  
  public DiscoverTab() {}
  
  public DiscoverTab(Parcel paramParcel)
  {
    this.entranceId = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    this.index = paramParcel.readInt();
    this.a = ((RedTouchExtendButton.RedInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    this.qbossTrace = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.aHE = bool1;
      if (paramParcel.readInt() != 1) {
        break label108;
      }
    }
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.doT = bool1;
      this.cNX = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.entranceId);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.index);
    paramParcel.writeParcelable(this.a, 0);
    paramParcel.writeString(this.qbossTrace);
    if (this.aHE)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.doT) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cNX);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.DiscoverTab
 * JD-Core Version:    0.7.0.1
 */