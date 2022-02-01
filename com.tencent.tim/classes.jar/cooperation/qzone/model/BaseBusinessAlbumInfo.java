package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseBusinessAlbumInfo
  implements Parcelable, Cloneable
{
  public String Hl;
  public long aAs;
  public long aAt;
  public int ahT;
  public int allow_share;
  public String cNU;
  public boolean doR;
  public boolean doS = true;
  public int eyD;
  public int eyE;
  public int eyF;
  public String mAlbumId;
  public int mAlbumType;
  public String mTitle;
  public int mTotal;
  public long mUin;
  public int opmask;
  public int sortType;
  
  public BaseBusinessAlbumInfo() {}
  
  public BaseBusinessAlbumInfo(String paramString)
  {
    this.mAlbumId = paramString;
  }
  
  public BaseBusinessAlbumInfo a()
  {
    BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo(this.mAlbumId);
    localBaseBusinessAlbumInfo.a(this);
    return localBaseBusinessAlbumInfo;
  }
  
  public void a(BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    if (paramBaseBusinessAlbumInfo == null) {
      return;
    }
    this.mAlbumId = paramBaseBusinessAlbumInfo.mAlbumId;
    this.mUin = paramBaseBusinessAlbumInfo.mUin;
    this.mTitle = paramBaseBusinessAlbumInfo.mTitle;
    this.Hl = paramBaseBusinessAlbumInfo.Hl;
    this.mTotal = paramBaseBusinessAlbumInfo.mTotal;
    this.ahT = paramBaseBusinessAlbumInfo.ahT;
    this.aAs = paramBaseBusinessAlbumInfo.aAs;
    this.mAlbumType = paramBaseBusinessAlbumInfo.mAlbumType;
    this.aAt = paramBaseBusinessAlbumInfo.aAt;
    this.eyD = paramBaseBusinessAlbumInfo.eyD;
    this.doR = paramBaseBusinessAlbumInfo.doR;
    this.opmask = paramBaseBusinessAlbumInfo.opmask;
    this.allow_share = paramBaseBusinessAlbumInfo.allow_share;
    this.cNU = paramBaseBusinessAlbumInfo.cNU;
    this.eyE = paramBaseBusinessAlbumInfo.eyE;
    this.eyF = paramBaseBusinessAlbumInfo.eyF;
    this.sortType = paramBaseBusinessAlbumInfo.sortType;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (BaseBusinessAlbumInfo)paramObject;
        if (this.mAlbumId != null) {
          break;
        }
      } while (paramObject.mAlbumId == null);
      return false;
    } while (this.mAlbumId.equals(paramObject.mAlbumId));
    return false;
  }
  
  public String getId()
  {
    return this.mAlbumId;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int hashCode()
  {
    if (this.mAlbumId == null) {}
    for (int i = 0;; i = this.mAlbumId.hashCode()) {
      return i + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mUin);
    paramParcel.writeString(this.mAlbumId);
    paramParcel.writeInt(this.ahT);
    paramParcel.writeInt(this.mTotal);
    paramParcel.writeString(this.Hl);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeLong(this.aAs);
    paramParcel.writeInt(this.mAlbumType);
    paramParcel.writeLong(this.aAt);
    paramParcel.writeInt(this.eyD);
    if (this.doR) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.opmask);
      paramParcel.writeInt(this.allow_share);
      paramParcel.writeString(this.cNU);
      paramParcel.writeInt(this.eyE);
      paramParcel.writeInt(this.eyF);
      paramParcel.writeInt(this.sortType);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.BaseBusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */