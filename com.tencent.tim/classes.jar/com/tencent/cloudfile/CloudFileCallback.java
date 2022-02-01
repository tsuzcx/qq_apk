package com.tencent.cloudfile;

import java.util.List;

public abstract class CloudFileCallback
{
  public void onAddRecentHistoryCallback(int paramInt, String paramString) {}
  
  public void onAirCopyToOtherBizCallBack(byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void onAirCopyToRecentFolderCallBack(byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void onBatchCheckExistInRecentFolderCallback(List<BatchCheckResult> paramList) {}
  
  public void onCancelSearchCallback(int paramInt, String paramString) {}
  
  public void onCancelSearchRecentHistoryCallback(int paramInt, String paramString) {}
  
  public void onCheckExistInRecentFolderCallback(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4) {}
  
  public void onCheckPreviewFileCallback(PreviewInfo paramPreviewInfo, int paramInt, String paramString) {}
  
  public void onCopyTMCFileCallBack(int paramInt, String paramString, CloudFile paramCloudFile) {}
  
  public void onCreateFolderCallback(CloudDir paramCloudDir, int paramInt, String paramString) {}
  
  public void onDeleteFolderCallBack(int paramInt, String paramString, List<BatchResult> paramList) {}
  
  public void onDeleteRecentHistoryCallback(int paramInt, String paramString) {}
  
  public void onFetchDirFileListCallback(byte[] paramArrayOfByte, List<CloudBase> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2) {}
  
  public void onFetchDirFileListCallback(byte[] paramArrayOfByte, List<CloudBase> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString) {}
  
  public void onFetchDownloadListCallback(List<CloudFile> paramList, int paramInt, String paramString) {}
  
  public void onFetchFeedsListCallback(List<CloudFeed> paramList, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, String paramString) {}
  
  public void onFetchFeedsListCallback(List<CloudFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public void onFetchGridThumListCallback(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, List<GridThumResult> paramList) {}
  
  public void onFetchRecentHistoryCallback(List<CloudHistoryInfo> paramList, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onFetchUploadListCallback(List<CloudUploadFile> paramList, int paramInt, String paramString) {}
  
  public void onFetchUserInfoCallback(CloudUserInfo paramCloudUserInfo, int paramInt, String paramString) {}
  
  public void onGetAllItemCountCallback(long paramLong1, long paramLong2, int paramInt, String paramString) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase) {}
  
  public void onGetDownloadUrlCallBack(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {}
  
  public void onGetItemCountInDir(long paramLong1, long paramLong2, int paramInt, String paramString) {}
  
  public void onGetLatestSortTime(long paramLong, int paramInt, String paramString) {}
  
  public void onIsDirKeyMatchedCallBack(byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public void onIsTeamFileDownloadedCallback(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onMoveFolderCallBack(int paramInt, String paramString, List<BatchResult> paramList) {}
  
  public void onRenameFileCallback(int paramInt, String paramString) {}
  
  public void onRenameFolderCallback(int paramInt, String paramString) {}
  
  public void onSearchListCallback(List<CloudBase> paramList, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onSearchRecentHistoryCallback(List<CloudHistoryInfo> paramList, boolean paramBoolean, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudFileCallback
 * JD-Core Version:    0.7.0.1
 */