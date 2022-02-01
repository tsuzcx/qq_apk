package com.tencent.cloudfile;

import java.util.List;

public class CloudFileSDK
{
  private static final String TAG = "CloudFileSDK";
  private static volatile CloudFileSDK instance = null;
  private volatile boolean started;
  
  private native void StopAllUpload(int paramInt);
  
  public static CloudFileSDK getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new CloudFileSDK();
      }
      return instance;
    }
    finally {}
  }
  
  private native void nativeAddHistoryInfo(CloudHistoryInfo paramCloudHistoryInfo, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeAirCopyToOtherBiz(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte3, String paramString, AirCopyExtInfo paramAirCopyExtInfo, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeAutoAirCopyReportData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo, int paramInt);
  
  private native void nativeAutoAirCopyToRecentFolder(int paramInt, FileInfo paramFileInfo, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeBatchAddHistoryInfo(List<CloudHistoryInfo> paramList, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeBatchCheckFileExistInAIORecentFolder(List<CloudAIORecentFileExt> paramList, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeBatchDeleteHistorys(List<Long> paramList, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCancelSearch(long paramLong, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCancelSearchHistory(long paramLong, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCheckFileExistInAIORecentFolder(CloudAIORecentFileExt paramCloudAIORecentFileExt, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCheckPreviewFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCopyTMCFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCreateFolder(byte[] paramArrayOfByte, String paramString, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeCreateFolderForTeam(String paramString1, String paramString2, String paramString3, CloudFileCallback paramCloudFileCallback);
  
  private native CloudUploadFile nativeCreateUploadTask(byte[] paramArrayOfByte, FileInfo paramFileInfo);
  
  private native CloudUploadFile nativeCreateUploadTaskForAutoUpload(FileInfo paramFileInfo);
  
  private native CloudUploadFile nativeCreateUploadTaskForOnline(byte[] paramArrayOfByte, CloudOnlineFileExt paramCloudOnlineFileExt);
  
  private native CloudUploadFile nativeCreateUploadTaskForTeam(String paramString, byte[] paramArrayOfByte, FileInfo paramFileInfo);
  
  private native void nativeDeleteFolderFile(List<BatchRequest> paramList, int paramInt, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeDeleteHistroy(long paramLong, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeDeleteUploadFile(List<Long> paramList);
  
  private native String nativeEncodeFileNameForAirCopy(String paramString1, String paramString2, long paramLong);
  
  private native void nativeFetchDirFileList(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchDirFileListTyped(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt2, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchDownloadedListFromAIORecent(CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchFeedGridThumList(int paramInt1, int paramInt2, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchFeedsList(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchFeedsListTyped(int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchGridThumList(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchHistoryList(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchSpace(CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchUploadFileList(CloudFileCallback paramCloudFileCallback);
  
  private native void nativeFetchUserInfo(CloudFileCallback paramCloudFileCallback);
  
  private native void nativeGetAllItemCount(CloudFileCallback paramCloudFileCallback);
  
  private native CloudDir nativeGetAutoForwardFolderKey(String paramString);
  
  private native void nativeGetCloudItemById(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeGetDownLoadUrl(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, CloudFileCallback paramCloudFileCallback);
  
  private native String nativeGetErrorMsgOf(int paramInt);
  
  private native void nativeGetItemCountInDir(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeGetLatestSortTime(CloudFileCallback paramCloudFileCallback);
  
  private native void nativeGetThumbList(byte[] paramArrayOfByte, List<byte[]> paramList, int paramInt);
  
  private native void nativeIsTeamFileDownloaded(String paramString1, String paramString2, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeManualAirCopyReportData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo, int paramInt1, int paramInt2, long paramLong, int paramInt3);
  
  private native void nativeMoveFolderFile(List<BatchRequest> paramList, byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeNotifyAirCopySuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo);
  
  private native void nativeRecvResponse(int paramInt, byte[] paramArrayOfByte, long paramLong);
  
  private native void nativeRefreshDirFileList(byte[] paramArrayOfByte, int paramInt, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeRefreshDirFileListTyped(int paramInt1, byte[] paramArrayOfByte, int paramInt2, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeRefreshFeedsList(int paramInt, boolean paramBoolean, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeRefreshFeedsListTyped(int paramInt1, int paramInt2, boolean paramBoolean, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeRegisterContext(CloudFileCallbackCenter paramCloudFileCallbackCenter, CloudFileContext paramCloudFileContext);
  
  private native void nativeRenameFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeRenameFolder(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, CloudFileCallback paramCloudFileCallback);
  
  private native long nativeSearchFileList(CloudSearchReq paramCloudSearchReq, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeSearchHistory(String paramString, int paramInt, long paramLong, CloudFileCallback paramCloudFileCallback);
  
  private native void nativeSetAutoAddHistoryForTimeCloud(boolean paramBoolean);
  
  private native void nativeSetDownloadSucStatus(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, boolean paramBoolean);
  
  private native void nativeSetTeamDownloadSucStatus(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  private native void nativeStart();
  
  private native void nativeStartDownloadFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString);
  
  private native void nativeStartDownloadTeamFile(String paramString1, String paramString2, String paramString3);
  
  private native void nativeStartFetchAllCloudList();
  
  private native void nativeStartUploadFile(List<Long> paramList);
  
  private native void nativeStop();
  
  private native void nativeStopDownloadFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  private native void nativeStopDownloadTeamFile(String paramString1, String paramString2, int paramInt);
  
  private native void nativeStopUploadFile(List<Long> paramList, int paramInt);
  
  private native void nativeUpdateOnlineInfo(CloudOnlineFileExt paramCloudOnlineFileExt);
  
  public native void IsDirKeyMatchedUploadDirKeyList(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback);
  
  public void addRecentHsitoryInfo(CloudHistoryInfo paramCloudHistoryInfo, CloudFileCallback paramCloudFileCallback)
  {
    nativeAddHistoryInfo(paramCloudHistoryInfo, paramCloudFileCallback);
  }
  
  public void airCopyToOtherBiz(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte3, String paramString, AirCopyExtInfo paramAirCopyExtInfo, CloudFileCallback paramCloudFileCallback)
  {
    nativeAirCopyToOtherBiz(paramArrayOfByte1, paramArrayOfByte2, paramInt, paramLong1, paramLong2, paramArrayOfByte3, paramString, paramAirCopyExtInfo, paramCloudFileCallback);
  }
  
  public void autoAirCopyReportData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo, int paramInt)
  {
    nativeAutoAirCopyReportData(paramArrayOfByte1, paramArrayOfByte2, paramFileInfo, paramInt);
  }
  
  public void autoAirCopyToRecentFolder(int paramInt, FileInfo paramFileInfo, CloudFileCallback paramCloudFileCallback)
  {
    nativeAutoAirCopyToRecentFolder(paramInt, paramFileInfo, paramCloudFileCallback);
  }
  
  public void batchAddRecentHistoryInfo(List<CloudHistoryInfo> paramList, CloudFileCallback paramCloudFileCallback)
  {
    nativeBatchAddHistoryInfo(paramList, paramCloudFileCallback);
  }
  
  public void batchCheckFileExistInAIORecentFolder(List<CloudAIORecentFileExt> paramList, CloudFileCallback paramCloudFileCallback)
  {
    nativeBatchCheckFileExistInAIORecentFolder(paramList, paramCloudFileCallback);
  }
  
  public void batchDeleteRecentHistory(List<Long> paramList, CloudFileCallback paramCloudFileCallback)
  {
    nativeBatchDeleteHistorys(paramList, paramCloudFileCallback);
  }
  
  public void cancelSearch(long paramLong, CloudFileCallback paramCloudFileCallback)
  {
    nativeCancelSearch(paramLong, paramCloudFileCallback);
  }
  
  public void cancelSearchRecentHistory(long paramLong, CloudFileCallback paramCloudFileCallback)
  {
    nativeCancelSearchHistory(paramLong, paramCloudFileCallback);
  }
  
  public void checkFileExistInAIORecentFolder(CloudAIORecentFileExt paramCloudAIORecentFileExt, CloudFileCallback paramCloudFileCallback)
  {
    nativeCheckFileExistInAIORecentFolder(paramCloudAIORecentFileExt, paramCloudFileCallback);
  }
  
  public void checkPreviewFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, CloudFileCallback paramCloudFileCallback)
  {
    nativeCheckPreviewFile(paramArrayOfByte1, paramArrayOfByte2, paramCloudFileCallback);
  }
  
  public void copyTMCFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, CloudFileCallback paramCloudFileCallback)
  {
    nativeCopyTMCFile(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt, paramCloudFileCallback);
  }
  
  public void createFolder(byte[] paramArrayOfByte, String paramString, CloudFileCallback paramCloudFileCallback)
  {
    nativeCreateFolder(paramArrayOfByte, paramString, paramCloudFileCallback);
  }
  
  public void createFolderForTeam(String paramString1, String paramString2, String paramString3, CloudFileCallback paramCloudFileCallback)
  {
    nativeCreateFolderForTeam(paramString1, paramString2, paramString3, paramCloudFileCallback);
  }
  
  public CloudUploadFile createUploadTask(byte[] paramArrayOfByte, FileInfo paramFileInfo)
  {
    return nativeCreateUploadTask(paramArrayOfByte, paramFileInfo);
  }
  
  public CloudUploadFile createUploadTaskForAutoUpload(FileInfo paramFileInfo)
  {
    return nativeCreateUploadTaskForAutoUpload(paramFileInfo);
  }
  
  public CloudUploadFile createUploadTaskForOnline(byte[] paramArrayOfByte, CloudOnlineFileExt paramCloudOnlineFileExt)
  {
    return nativeCreateUploadTaskForOnline(paramArrayOfByte, paramCloudOnlineFileExt);
  }
  
  public CloudUploadFile createUploadTaskForTeam(String paramString, byte[] paramArrayOfByte, FileInfo paramFileInfo)
  {
    return nativeCreateUploadTaskForTeam(paramString, paramArrayOfByte, paramFileInfo);
  }
  
  public void deleteFolderFile(List<BatchRequest> paramList, int paramInt, CloudFileCallback paramCloudFileCallback)
  {
    nativeDeleteFolderFile(paramList, paramInt, paramCloudFileCallback);
  }
  
  public void deleteRecentHistory(long paramLong, CloudFileCallback paramCloudFileCallback)
  {
    nativeDeleteHistroy(paramLong, paramCloudFileCallback);
  }
  
  public void deleteUploadFile(List<Long> paramList)
  {
    nativeDeleteUploadFile(paramList);
  }
  
  public String encodeFileNameForAirCopy(String paramString1, String paramString2, long paramLong)
  {
    return nativeEncodeFileNameForAirCopy(paramString1, paramString2, paramLong);
  }
  
  public void fetchDirFileList(int paramInt1, byte[] paramArrayOfByte, CloudBase paramCloudBase, boolean paramBoolean, int paramInt2, CloudFileCallback paramCloudFileCallback)
  {
    Object localObject = paramCloudBase;
    if (paramCloudBase == null) {
      localObject = new CloudFile();
    }
    nativeFetchDirFileListTyped(paramInt1, paramArrayOfByte, ((CloudBase)localObject).cloudId, paramBoolean, ((CloudBase)localObject).sortSeq, ((CloudBase)localObject).sortTime, paramInt2, paramCloudFileCallback);
  }
  
  public void fetchDirFileList(byte[] paramArrayOfByte, CloudBase paramCloudBase, boolean paramBoolean, int paramInt, CloudFileCallback paramCloudFileCallback)
  {
    Object localObject = paramCloudBase;
    if (paramCloudBase == null) {
      localObject = new CloudFile();
    }
    nativeFetchDirFileList(paramArrayOfByte, ((CloudBase)localObject).cloudId, paramBoolean, ((CloudBase)localObject).sortSeq, ((CloudBase)localObject).sortTime, paramInt, paramCloudFileCallback);
  }
  
  public void fetchDownloadedListFromAIORecent(CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchDownloadedListFromAIORecent(paramCloudFileCallback);
  }
  
  public void fetchFeedGridThumList(int paramInt1, int paramInt2, CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchFeedGridThumList(paramInt1, paramInt2, paramCloudFileCallback);
  }
  
  public void fetchFeedsList(int paramInt1, CloudBase paramCloudBase, int paramInt2, boolean paramBoolean, CloudFileCallback paramCloudFileCallback)
  {
    Object localObject = paramCloudBase;
    if (paramCloudBase == null) {
      localObject = new CloudFile();
    }
    nativeFetchFeedsListTyped(paramInt1, ((CloudBase)localObject).sortSeq, ((CloudBase)localObject).sortTime, paramInt2, paramBoolean, paramCloudFileCallback);
  }
  
  public void fetchFeedsList(CloudBase paramCloudBase, int paramInt, boolean paramBoolean, CloudFileCallback paramCloudFileCallback)
  {
    Object localObject = paramCloudBase;
    if (paramCloudBase == null) {
      localObject = new CloudFile();
    }
    nativeFetchFeedsList(((CloudBase)localObject).sortSeq, ((CloudBase)localObject).sortTime, paramInt, paramBoolean, paramCloudFileCallback);
  }
  
  public void fetchGridThumList(byte[] paramArrayOfByte, int paramInt1, int paramInt2, CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchGridThumList(paramArrayOfByte, paramInt1, paramInt2, paramCloudFileCallback);
  }
  
  public void fetchRecentHistoryList(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchHistoryList(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramCloudFileCallback);
  }
  
  public void fetchSpace(CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchSpace(paramCloudFileCallback);
  }
  
  public void fetchUploadFileList(CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchUploadFileList(paramCloudFileCallback);
  }
  
  public void fetchUserInfo(CloudFileCallback paramCloudFileCallback)
  {
    nativeFetchUserInfo(paramCloudFileCallback);
  }
  
  public void getAllItemCount(CloudFileCallback paramCloudFileCallback)
  {
    nativeGetAllItemCount(paramCloudFileCallback);
  }
  
  public CloudDir getAutoForwardFolderKey(String paramString)
  {
    return nativeGetAutoForwardFolderKey(paramString);
  }
  
  public void getCloudItemById(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback)
  {
    nativeGetCloudItemById(paramArrayOfByte, paramCloudFileCallback);
  }
  
  public void getDownLoadUrl(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, CloudFileCallback paramCloudFileCallback)
  {
    nativeGetDownLoadUrl(paramArrayOfByte1, paramArrayOfByte2, paramCloudFileCallback);
  }
  
  public String getErrorMsgOf(int paramInt)
  {
    return nativeGetErrorMsgOf(paramInt);
  }
  
  public void getItemCountInDir(byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback)
  {
    nativeGetItemCountInDir(paramArrayOfByte, paramCloudFileCallback);
  }
  
  public void getLatestSortTime(CloudFileCallback paramCloudFileCallback)
  {
    nativeGetLatestSortTime(paramCloudFileCallback);
  }
  
  public void getThumbList(byte[] paramArrayOfByte, List<byte[]> paramList, int paramInt)
  {
    nativeGetThumbList(paramArrayOfByte, paramList, paramInt);
  }
  
  public void isTeamFileDownloaded(String paramString1, String paramString2, CloudFileCallback paramCloudFileCallback)
  {
    nativeIsTeamFileDownloaded(paramString1, paramString2, paramCloudFileCallback);
  }
  
  public void manualAirCopyReportData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    nativeManualAirCopyReportData(paramArrayOfByte1, paramArrayOfByte2, paramFileInfo, paramInt1, paramInt2, paramLong, paramInt3);
  }
  
  public void moveFolderFile(List<BatchRequest> paramList, byte[] paramArrayOfByte, CloudFileCallback paramCloudFileCallback)
  {
    nativeMoveFolderFile(paramList, paramArrayOfByte, paramCloudFileCallback);
  }
  
  public void notifyAirCopySuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, FileInfo paramFileInfo)
  {
    nativeNotifyAirCopySuccess(paramArrayOfByte1, paramArrayOfByte2, paramFileInfo);
  }
  
  public void recvResponse(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    nativeRecvResponse(paramInt, paramArrayOfByte, paramLong);
  }
  
  public void refreshDirFileList(int paramInt1, byte[] paramArrayOfByte, int paramInt2, CloudFileCallback paramCloudFileCallback)
  {
    nativeRefreshDirFileListTyped(paramInt1, paramArrayOfByte, paramInt2, paramCloudFileCallback);
  }
  
  public void refreshDirFileList(byte[] paramArrayOfByte, int paramInt, CloudFileCallback paramCloudFileCallback)
  {
    nativeRefreshDirFileList(paramArrayOfByte, paramInt, paramCloudFileCallback);
  }
  
  public void refreshFeedsList(int paramInt1, int paramInt2, boolean paramBoolean, CloudFileCallback paramCloudFileCallback)
  {
    nativeRefreshFeedsListTyped(paramInt1, paramInt2, paramBoolean, paramCloudFileCallback);
  }
  
  public void refreshFeedsList(int paramInt, boolean paramBoolean, CloudFileCallback paramCloudFileCallback)
  {
    nativeRefreshFeedsList(paramInt, paramBoolean, paramCloudFileCallback);
  }
  
  public void registerContext(CloudFileCallbackCenter paramCloudFileCallbackCenter, CloudFileContext paramCloudFileContext)
  {
    nativeRegisterContext(paramCloudFileCallbackCenter, paramCloudFileContext);
  }
  
  public void renameFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, CloudFileCallback paramCloudFileCallback)
  {
    nativeRenameFile(paramArrayOfByte1, paramArrayOfByte2, paramString, paramCloudFileCallback);
  }
  
  public void renameFolder(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, CloudFileCallback paramCloudFileCallback)
  {
    nativeRenameFolder(paramArrayOfByte1, paramArrayOfByte2, paramString, paramCloudFileCallback);
  }
  
  public long searchFileList(CloudSearchReq paramCloudSearchReq, CloudFileCallback paramCloudFileCallback)
  {
    return nativeSearchFileList(paramCloudSearchReq, paramCloudFileCallback);
  }
  
  public void searchRecentHistory(String paramString, int paramInt, long paramLong, CloudFileCallback paramCloudFileCallback)
  {
    nativeSearchHistory(paramString, paramInt, paramLong, paramCloudFileCallback);
  }
  
  public void setAutoAddHistoryForTimeCloud(boolean paramBoolean)
  {
    nativeSetAutoAddHistoryForTimeCloud(paramBoolean);
  }
  
  public void setDownloadSucStatus(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, boolean paramBoolean)
  {
    nativeSetDownloadSucStatus(paramArrayOfByte1, paramArrayOfByte2, paramString, paramBoolean);
  }
  
  public void setTeamDownloadSucStatus(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    nativeSetTeamDownloadSucStatus(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void start()
  {
    if (!this.started)
    {
      CloudFileContext.nativeLog(3, "CloudFileSDK", "sdk start", 0);
      nativeStart();
      this.started = true;
    }
  }
  
  public void startDownloadFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    nativeStartDownloadFile(paramArrayOfByte1, paramArrayOfByte2, paramString);
  }
  
  public void startDownloadTeamFile(String paramString1, String paramString2, String paramString3)
  {
    nativeStartDownloadTeamFile(paramString1, paramString2, paramString3);
  }
  
  public void startFetchAllCloudList()
  {
    nativeStartFetchAllCloudList();
  }
  
  public void startUploadFile(List<Long> paramList)
  {
    nativeStartUploadFile(paramList);
  }
  
  public void stop()
  {
    if (this.started)
    {
      CloudFileContext.nativeLog(3, "CloudFileSDK", "sdk stop", 0);
      nativeStop();
      this.started = false;
    }
  }
  
  public void stopAllFileUpload(int paramInt)
  {
    StopAllUpload(paramInt);
  }
  
  public void stopDownloadFile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    nativeStopDownloadFile(paramArrayOfByte1, paramArrayOfByte2, paramInt);
  }
  
  public void stopDownloadTeamFile(String paramString1, String paramString2, int paramInt)
  {
    nativeStopDownloadTeamFile(paramString1, paramString2, paramInt);
  }
  
  public void stopUploadFile(List<Long> paramList, int paramInt)
  {
    nativeStopUploadFile(paramList, paramInt);
  }
  
  public void updateOnlineInfo(CloudOnlineFileExt paramCloudOnlineFileExt)
  {
    nativeUpdateOnlineInfo(paramCloudOnlineFileExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudFileSDK
 * JD-Core Version:    0.7.0.1
 */