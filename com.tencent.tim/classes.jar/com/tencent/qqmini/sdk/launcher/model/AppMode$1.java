package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AppMode$1
  implements Parcelable.Creator<AppMode>
{
  public AppMode createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMode localAppMode = new AppMode();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localAppMode.interMode = bool1;
      if (paramParcel.readInt() != 1) {
        break label179;
      }
      bool1 = true;
      label37:
      localAppMode.authoritySilent = bool1;
      if (paramParcel.readInt() != 1) {
        break label184;
      }
      bool1 = true;
      label53:
      localAppMode.keepOffPullList = bool1;
      if (paramParcel.readInt() != 1) {
        break label189;
      }
      bool1 = true;
      label69:
      localAppMode.closeTopRightCapsule = bool1;
      if (paramParcel.readInt() != 1) {
        break label194;
      }
      bool1 = true;
      label85:
      localAppMode.openNativeApi = bool1;
      if (paramParcel.readInt() != 1) {
        break label199;
      }
      bool1 = true;
      label101:
      localAppMode.hideAppSearch = bool1;
      if (paramParcel.readInt() != 1) {
        break label204;
      }
      bool1 = true;
      label117:
      localAppMode.isAppStore = bool1;
      if (paramParcel.readInt() != 1) {
        break label209;
      }
      bool1 = true;
      label133:
      localAppMode.isWangKa = bool1;
      if (paramParcel.readInt() != 1) {
        break label214;
      }
      bool1 = true;
      label149:
      localAppMode.interLoading = bool1;
      if (paramParcel.readInt() != 1) {
        break label219;
      }
    }
    label179:
    label184:
    label189:
    label194:
    label199:
    label204:
    label209:
    label214:
    label219:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAppMode.isLimitedAccess = bool1;
      return localAppMode;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
      bool1 = false;
      break label53;
      bool1 = false;
      break label69;
      bool1 = false;
      break label85;
      bool1 = false;
      break label101;
      bool1 = false;
      break label117;
      bool1 = false;
      break label133;
      bool1 = false;
      break label149;
    }
  }
  
  public AppMode[] newArray(int paramInt)
  {
    return new AppMode[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppMode.1
 * JD-Core Version:    0.7.0.1
 */