package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class BaseLibInfo$1
  implements Parcelable.Creator<BaseLibInfo>
{
  public BaseLibInfo createFromParcel(Parcel paramParcel)
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    try
    {
      paramParcel = new BaseLibInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt());
      return paramParcel;
    }
    catch (Throwable paramParcel)
    {
      QMLog.e("BaseLibInfo", "BaseLibInfo createFromParcel exception!", paramParcel);
    }
    return localBaseLibInfo;
  }
  
  public BaseLibInfo[] newArray(int paramInt)
  {
    return new BaseLibInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.BaseLibInfo.1
 * JD-Core Version:    0.7.0.1
 */