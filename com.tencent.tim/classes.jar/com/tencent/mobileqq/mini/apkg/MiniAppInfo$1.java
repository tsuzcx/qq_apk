package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import java.util.ArrayList;

final class MiniAppInfo$1
  implements Parcelable.Creator<MiniAppInfo>
{
  public MiniAppInfo createFromParcel(Parcel paramParcel)
  {
    localMiniAppInfo = new MiniAppInfo();
    try
    {
      localMiniAppInfo.appId = paramParcel.readString();
      localMiniAppInfo.name = paramParcel.readString();
      localMiniAppInfo.iconUrl = paramParcel.readString();
      localMiniAppInfo.downloadUrl = paramParcel.readString();
      localMiniAppInfo.topType = paramParcel.readInt();
      localMiniAppInfo.version = paramParcel.readString();
      localMiniAppInfo.versionId = paramParcel.readString();
      localMiniAppInfo.desc = paramParcel.readString();
      localMiniAppInfo.verType = paramParcel.readInt();
      localMiniAppInfo.timestamp = paramParcel.readLong();
      localMiniAppInfo.baselibMiniVersion = paramParcel.readString();
      localMiniAppInfo.subpkgs = paramParcel.createTypedArrayList(SubPkgInfo.CREATOR);
      localMiniAppInfo.firstPage = ((FirstPageInfo)paramParcel.readParcelable(FirstPageInfo.class.getClassLoader()));
      localMiniAppInfo.engineType = paramParcel.readInt();
      localMiniAppInfo.whiteList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.whiteList);
      localMiniAppInfo.blackList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.blackList);
      localMiniAppInfo.secondApiRightInfoList = paramParcel.createTypedArrayList(SecondApiRightInfo.CREATOR);
      localMiniAppInfo.debugInfo = ((DebugInfo)paramParcel.readParcelable(DebugInfo.class.getClassLoader()));
      localMiniAppInfo.fileSize = paramParcel.readInt();
      localMiniAppInfo.requestDomainList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.requestDomainList);
      localMiniAppInfo.socketDomainList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.socketDomainList);
      localMiniAppInfo.downloadFileDomainList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.downloadFileDomainList);
      localMiniAppInfo.uploadFileDomainList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.uploadFileDomainList);
      localMiniAppInfo.businessDomainList = new ArrayList();
      paramParcel.readStringList(localMiniAppInfo.businessDomainList);
      paramParcel.readStringList(localMiniAppInfo.udpIpList);
      localMiniAppInfo.developerDesc = paramParcel.readString();
      localMiniAppInfo.extraData = paramParcel.readString();
      localMiniAppInfo.recommend = paramParcel.readInt();
      localMiniAppInfo.reportData = paramParcel.readString();
      localMiniAppInfo.appMode = ((AppMode)paramParcel.readParcelable(AppMode.class.getClassLoader()));
      localMiniAppInfo.openId = paramParcel.readString();
      localMiniAppInfo.tinyId = paramParcel.readLong();
      localMiniAppInfo.skipDomainCheck = paramParcel.readInt();
      localMiniAppInfo.position = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool = true;
        localMiniAppInfo.isSupportBlueBar = bool;
        if (paramParcel.readInt() != 1) {
          break label678;
        }
        bool = true;
        label411:
        localMiniAppInfo.isSupportOffline = bool;
        localMiniAppInfo.recommendAppIconUrl = paramParcel.readString();
        localMiniAppInfo.extendData = paramParcel.readString();
        localMiniAppInfo.clearAuths = paramParcel.readInt();
        localMiniAppInfo.commonExt = paramParcel.createByteArray();
        localMiniAppInfo.extConfigInfoList = paramParcel.createTypedArrayList(ExtConfigInfo.CREATOR);
        localMiniAppInfo.appStoreAnimPicUrl = paramParcel.readString();
        localMiniAppInfo.motionPics = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.motionPics);
        localMiniAppInfo.usrFileSizeLimit = paramParcel.readLong();
        localMiniAppInfo.preCacheList = paramParcel.createTypedArrayList(PreCacheInfo.CREATOR);
        localMiniAppInfo.versionUpdateTime = paramParcel.readInt();
        localMiniAppInfo.noNeedRealRecommend = paramParcel.readInt();
        localMiniAppInfo.miniGamePluginInfo = ((MiniGamePluginInfo)paramParcel.readParcelable(MiniGamePluginInfo.class.getClassLoader()));
        MiniAppInfo.access$002(localMiniAppInfo, paramParcel.readInt());
        localMiniAppInfo.qualifications = new ArrayList();
        paramParcel.readStringList(localMiniAppInfo.qualifications);
        localMiniAppInfo.shareId = paramParcel.readString();
        localMiniAppInfo.via = paramParcel.readString();
        localMiniAppInfo.amsAdInfo = paramParcel.readString();
        localMiniAppInfo.apngUrl = paramParcel.readString();
        localMiniAppInfo.ide_scene = paramParcel.readString();
        localMiniAppInfo.ide_extraAppid = paramParcel.readString();
        localMiniAppInfo.ide_extraData = paramParcel.readString();
        localMiniAppInfo.tianshuAdId = paramParcel.readInt();
        localMiniAppInfo.resourcePreCacheInfo = paramParcel.createTypedArrayList(ResourcePreCacheInfo.CREATOR);
        if (paramParcel.readInt() != 1) {
          break label683;
        }
      }
      label678:
      label683:
      for (boolean bool = true;; bool = false)
      {
        localMiniAppInfo.enableLoadingAd = bool;
        localMiniAppInfo.deviceOrientation = paramParcel.readInt();
        localMiniAppInfo.showStatusBar = paramParcel.readInt();
        return localMiniAppInfo;
        bool = false;
        break;
        bool = false;
        break label411;
      }
      return localMiniAppInfo;
    }
    catch (Throwable paramParcel)
    {
      QLog.e("[mini] MiniAppInfo", 1, "createFromParcel exception!", paramParcel);
    }
  }
  
  public MiniAppInfo[] newArray(int paramInt)
  {
    return new MiniAppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppInfo.1
 * JD-Core Version:    0.7.0.1
 */