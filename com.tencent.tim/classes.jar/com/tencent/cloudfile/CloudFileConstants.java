package com.tencent.cloudfile;

public abstract interface CloudFileConstants
{
  public static abstract interface AirCopyType
  {
    public static final int Copy = 2;
    public static final int Forward = 1;
    public static final int Unknow = 0;
    public static final int Upload = 3;
  }
  
  public static abstract interface DataReportType
  {
    public static final int List = 2;
    public static final int RecursiveList = 3;
    public static final int Transfer = 1;
    public static final int Unknow = 0;
  }
  
  public static abstract interface DefaultFolder
  {
    public static final int DefaultFolder_AIORecent = 0;
    public static final int DefaultFolder_MyAddFolder = 1;
  }
  
  public static abstract interface DeleteType
  {
    public static final int Both = 2;
    public static final int Local_Only = 0;
    public static final int Server_Only = 2;
  }
  
  public static abstract interface DownloadScenes
  {
    public static final int AIO = 1;
    public static final int NotCare = 0;
    public static final int TimCloud = 2;
  }
  
  public static abstract interface ErrorCode
  {
    public static final int ERROR_DATABASE = -1;
    public static final int ERROR_NETWORK = -999;
    public static final int ERROR_NOT_FOUND_IN_DB = -2;
    public static final int ERROR_NO_ROOT_MSG = -3;
    public static final int ERROR_OTHER = -7;
    public static final int ERROR_PARAMETER = -6;
    public static final int ERROR_RECV_PACK = -5;
    public static final int ERROR_SEND_PACK = -4;
  }
  
  public static abstract interface FeedType
  {
    public static final int FeedType_CombinePhonto = 3;
    public static final int FeedType_Dir = 1;
    public static final int FeedType_File = 2;
    public static final int FeedType_None_Invalid = 0;
  }
  
  public static abstract interface FileBussnessType
  {
    public static final int FileBussnessType_C2C = 3;
    public static final int FileBussnessType_Discuss = 106;
    public static final int FileBussnessType_Group = 102;
    public static final int FileBussnessType_None = 0;
  }
  
  public static abstract interface FileCopyExistOpt
  {
    public static final int Failed = 0;
    public static final int Rename = 4;
  }
  
  public static abstract interface FileSrcType
  {
    public static final int FileSrcType_C2C = 2;
    public static final int FileSrcType_Dataline = 5;
    public static final int FileSrcType_Discuss = 3;
    public static final int FileSrcType_Group = 4;
    public static final int FileSrcType_None = 0;
    public static final int FileSrcType_Online = 6;
    public static final int FileSrcType_Other = 7;
    public static final int FileSrcType_SelfCreate = 1;
  }
  
  public static abstract interface FileStoreBizType
  {
    public static final int Link_Online = 1;
    public static final int Real_Object = 0;
  }
  
  public static abstract interface FileTransferType
  {
    public static final int FileTransferType_None = 0;
    public static final int FileTransferType_Recv = 2;
    public static final int FileTransferType_Send = 1;
  }
  
  public static abstract interface FileType
  {
    public static final int FileType_Doc = 1;
    public static final int FileType_Invalid = 0;
    public static final int FileType_Music = 3;
    public static final int FileType_Other = 5;
    public static final int FileType_Photo = 2;
    public static final int FileType_Rar = 6;
    public static final int FileType_Video = 4;
  }
  
  public static abstract interface ModelType
  {
    public static final int ModelType_Dir = 1;
    public static final int ModelType_File = 2;
    public static final int ModelType_None_Invalid = 0;
  }
  
  public static abstract interface OnlineCreateSrcType
  {
    public static final int Default = 0;
    public static final int TMC = 1;
  }
  
  public static abstract interface OnlineFileType
  {
    public static final int Doc = 1;
    public static final int Sheet = 2;
  }
  
  public static abstract interface OnlineListType
  {
    public static final int Browse = 3;
    public static final int Create = 1;
    public static final int Share = 2;
  }
  
  public static abstract interface OnlinePermissionType
  {
    public static final int AllEditable = 4;
    public static final int AllReadable = 3;
    public static final int Invalid = 0;
    public static final int SelfOnly = 1;
    public static final int SpecificMembers = 2;
  }
  
  public static abstract interface SearchFileType
  {
    public static final int All = 63;
    public static final int Doc = 1;
    public static final int Music = 4;
    public static final int None = 0;
    public static final int Other = 16;
    public static final int Photo = 2;
    public static final int Rar = 32;
    public static final int Video = 8;
  }
  
  public static abstract interface SearchModelType
  {
    public static final int All = 3;
    public static final int Dir = 1;
    public static final int File = 2;
    public static final int None = 0;
  }
  
  public static abstract interface SearchStoreBizType
  {
    public static final int All = 3;
    public static final int Link_Online = 2;
    public static final int None = 0;
    public static final int Real_Object = 1;
  }
  
  public static abstract interface SearchTransferType
  {
    public static final int All = 7;
    public static final int Other = 4;
    public static final int Recv = 2;
    public static final int Send = 1;
  }
  
  public static abstract interface ThumbSize
  {
    public static final int ThumbSize1024 = 1024;
    public static final int ThumbSize128 = 128;
    public static final int ThumbSize256 = 256;
    public static final int ThumbSize64 = 64;
    public static final int ThumbSize640 = 640;
  }
  
  public static abstract interface TimCloudDataFrom
  {
    public static final int DataFrom_Database = 1;
    public static final int DataFrom_Memory = 0;
    public static final int DataFrom_Network = 2;
  }
  
  public static abstract interface TransferStatus
  {
    public static final int TransferStatus_Downloading = 2;
    public static final int TransferStatus_Fail = 4;
    public static final int TransferStatus_Init = 0;
    public static final int TransferStatus_Stop = 3;
    public static final int TransferStatus_Suc = 5;
    public static final int TransferStatus_Uploading = 1;
  }
  
  public static abstract interface TransferStopType
  {
    public static final int Account_Changed = 1;
    public static final int Net_Change = 4;
    public static final int Net_Unknow = 0;
    public static final int Recall = 2;
    public static final int User_Cancel = 3;
    public static final int User_delete = 5;
  }
  
  public static abstract interface UploadType
  {
    public static final int UploadType_Forward = 3;
    public static final int UploadType_Forward_ExtInfo = 4;
    public static final int UploadType_Local = 0;
    public static final int UploadType_Local_ExtInfo = 1;
    public static final int UploadType_Online = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudFileConstants
 * JD-Core Version:    0.7.0.1
 */