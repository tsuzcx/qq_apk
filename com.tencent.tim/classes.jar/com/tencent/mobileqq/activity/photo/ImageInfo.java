package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import zrj;
import zrr;

public class ImageInfo
  extends zrj
  implements Parcelable
{
  public static final Parcelable.Creator<ImageInfo> CREATOR = new zrr();
  public long Ls;
  public String baG;
  public String baH;
  public String baI;
  public String bigMsgUrl;
  public boolean bsH;
  public boolean bsI;
  public boolean bsJ = true;
  public boolean bsK;
  public boolean bsL;
  public boolean bsM;
  public boolean bsN = true;
  public boolean bsO;
  public boolean bsP;
  public int businessType;
  public int ceE;
  public int ceF = 54;
  public int ceG;
  public int ceH;
  public boolean compressed;
  public int fileSizeFlag;
  public long filesize = -1L;
  public boolean isGif;
  public int issend;
  public int istroop;
  public String msg;
  public String rawMsgUrl;
  public int retryCount;
  public int selectStatus = 2;
  public String selfuin;
  public long time;
  public long uniseq;
  public String url;
  public String urlAtServer;
  public int versionCode = -1;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.bsB)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.bsC) {
        break label362;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.thumbnail);
      if (!this.bsD) {
        break label367;
      }
      paramInt = 1;
      label47:
      paramParcel.writeInt(paramInt);
      if (!this.bsE) {
        break label372;
      }
      paramInt = 1;
      label61:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.filePath);
      paramParcel.writeString(this.toUin);
      paramParcel.writeInt(this.progress);
      if (!this.showProgress) {
        break label377;
      }
      paramInt = 1;
      label99:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.url);
      paramParcel.writeInt(this.ceE);
      paramParcel.writeString(this.urlAtServer);
      paramParcel.writeInt(this.istroop);
      paramParcel.writeInt(this.issend);
      if (!this.bsH) {
        break label382;
      }
      paramInt = 1;
      label153:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.filesize);
      if (!this.bsJ) {
        break label387;
      }
      paramInt = 1;
      label175:
      paramParcel.writeInt(paramInt);
      if (!this.bsK) {
        break label392;
      }
      paramInt = 1;
      label189:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.baG);
      paramParcel.writeLong(this.Ls);
      paramParcel.writeString(this.baH);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.selfuin);
      paramParcel.writeInt(this.versionCode);
      paramParcel.writeInt(this.fileSizeFlag);
      paramParcel.writeInt(this.ceG);
      paramParcel.writeString(this.msg);
      paramParcel.writeInt(this.businessType);
      if (!this.compressed) {
        break label397;
      }
      paramInt = 1;
      label283:
      paramParcel.writeInt(paramInt);
      if (!this.bsP) {
        break label402;
      }
      paramInt = 1;
      label297:
      paramParcel.writeInt(paramInt);
      if (!this.isGif) {
        break label407;
      }
    }
    label387:
    label392:
    label397:
    label402:
    label407:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.uniseq);
      paramParcel.writeString(this.baI);
      paramParcel.writeString(this.bigMsgUrl);
      paramParcel.writeString(this.rawMsgUrl);
      paramParcel.writeInt(this.selectStatus);
      return;
      paramInt = 0;
      break;
      label362:
      paramInt = 0;
      break label25;
      label367:
      paramInt = 0;
      break label47;
      label372:
      paramInt = 0;
      break label61;
      label377:
      paramInt = 0;
      break label99;
      label382:
      paramInt = 0;
      break label153;
      paramInt = 0;
      break label175;
      paramInt = 0;
      break label189;
      paramInt = 0;
      break label283;
      paramInt = 0;
      break label297;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ImageInfo
 * JD-Core Version:    0.7.0.1
 */