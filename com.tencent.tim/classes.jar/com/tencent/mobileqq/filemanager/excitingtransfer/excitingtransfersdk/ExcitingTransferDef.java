package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferDef
{
  public static final int ChatType_C2C = 0;
  public static final int ChatType_Discuss = 2;
  public static final int ChatType_Group = 1;
  public static final int ChatType_Temp = 3;
  public static final int ClientType_Androidqq = 2;
  public static final int ClientType_Iosqq = 3;
  public static final int ClientType_Pcqq = 1;
  public static final int ClientType_Unkonw = 0;
  public static final int TerminalType_Android = 2;
  public static final int TerminalType_Ios = 3;
  public static final int TerminalType_Pc = 1;
  public static final int TerminalType_Unkonw = 0;
  
  public static class Recv
  {
    public static class EMDownloadResult
    {
      public static final int EMDownloadResult_Canceled = 101;
      public static final int EMDownloadResult_Connect_Begin = 300;
      public static final int EMDownloadResult_Connect_Call_Error = 302;
      public static final int EMDownloadResult_Connect_End = 400;
      public static final int EMDownloadResult_Connect_Failed = 303;
      public static final int EMDownloadResult_Connect_Param_Error = 301;
      public static final int EMDownloadResult_Connect_SSL_Failed = 304;
      public static final int EMDownloadResult_Connect_SSL_Recv_Failed = 306;
      public static final int EMDownloadResult_Connect_SSL_Send_Failed = 305;
      public static final int EMDownloadResult_Connect_SSL_Write_Failed = 307;
      public static final int EMDownloadResult_Connect_Verify_Failed = 308;
      public static final int EMDownloadResult_File_CheckMd5_Failed = 504;
      public static final int EMDownloadResult_File_Create_Failed = 501;
      public static final int EMDownloadResult_File_Open_Failed = 502;
      public static final int EMDownloadResult_File_Rename_Failed = 505;
      public static final int EMDownloadResult_File_Write_Failed = 503;
      public static final int EMDownloadResult_Http_Range_Error = 407;
      public static final int EMDownloadResult_Http_Server_Refuse = 408;
      public static final int EMDownloadResult_Internal_Error = 201;
      public static final int EMDownloadResult_NotEnoughSpace = 506;
      public static final int EMDownloadResult_OK = 0;
      public static final int EMDownloadResult_Recv_Body_Error = 406;
      public static final int EMDownloadResult_Recv_Error = 402;
      public static final int EMDownloadResult_Recv_Header_Error = 405;
      public static final int EMDownloadResult_Recv_Server_Closed = 404;
      public static final int EMDownloadResult_Recv_Timeout = 403;
      public static final int EMDownloadResult_Recv_Zero = 401;
    }
    
    public static class ReceiveResultCS
    {
      public static final int ReceiveResult_CS_ReqDownload_Danger_file = 4;
      public static final int ReceiveResult_CS_ReqDownload_DownloadInfo_NULL = 5;
      public static final int ReceiveResult_CS_ReqDownload_DownloadUrl_NULL = 6;
      public static final int ReceiveResult_CS_ReqDownload_Refuse = 3;
      public static final int ReceiveResult_CS_ReqDownload_RspData_NULL = 2;
      public static final int ReceiveResult_CS_ReqDownload_Server_Return_Err = 7;
      public static final int ReceiveResult_CS_ReqDownload_Timeout = 1;
      public static final int ReceiveResult_CS_SendSucc_Failed = 12;
      public static final int ReceiveResult_CS_SendSucc_ReplyData_NULL = 13;
      public static final int ReceiveResult_CS_SendSucc_RspData_NULL = 14;
      public static final int ReceiveResult_CS_SendSucc_ServerFailed = 15;
      public static final int ReceiveResult_CS_SendSucc_Timeout = 11;
    }
    
    public static class ReceiveResultIO
    {
      public static final int ReceiveResult_IO_NoSpace = 3;
      public static final int ReceiveResult_IO_Open_Failed = 1;
      public static final int ReceiveResult_IO_SavePath_Error = 2;
    }
    
    public static class ReceiveResultInternal
    {
      public static final int ReceiveResult_Internal_NoNetWork = 3;
      public static final int ReceiveResult_Internal_Retry_Exceed = 2;
      public static final int ReceiveResult_Internal_Uuid_Invalid = 1;
    }
    
    public static class ReceiveResultType
    {
      public static final int ReceiveResultType_CS = 2;
      public static final int ReceiveResultType_Http = 4;
      public static final int ReceiveResultType_IO = 3;
      public static final int ReceiveResultType_Internal = 5;
      public static final int ReceiveResultType_Suc = 0;
      public static final int ReceiveResultType_User = 1;
    }
    
    public static class ReceiveResultUser
    {
      public static final int ReceiveResult_User_Cancel_Not_Start = 2;
      public static final int ReceiveResult_User_Cancel_OtherTerm = 4;
      public static final int ReceiveResult_User_Cancel_Started = 3;
      public static final int ReceiveResult_User_Refuse = 1;
    }
  }
  
  public static class Send
  {
    public static final int BigDataCmdId_Upload_DataLine = 72;
    public static final int BigDataCmdId_Upload_Group = 71;
    public static final int BigDataCmdId_Upload_OfflineFile = 69;
    public static final int FileBusinessId_Group = 102;
    public static final int FileBusinessId_Group_Temp = 104;
    public static final int FileBusinessId_Offline = 3;
    
    public static class DataReport
    {
      public static final int AppType_QQ = 0;
      public static final int Platrform_ANDROID_QQ = 2;
      public static final int Platrform_IOS_QQ = 1;
      public static final int Platrform_PC_QQ = 0;
      public static final int UploadType_Buddy = 0;
      public static final int UploadType_Group = 2;
      public static final int UploadType_Temp = 1;
    }
    
    public static class ResultCode
    {
      public static final int EMSenderResult_CSFail = 31;
      public static final int EMSenderResult_CSTimeOut = 30;
      public static final int EMSenderResult_CanNotConnect = 1;
      public static final int EMSenderResult_DelayRetryFail = 19;
      public static final int EMSenderResult_DelayTooMuchFail = 20;
      public static final int EMSenderResult_FileException = 8;
      public static final int EMSenderResult_HashCalFail = 32;
      public static final int EMSenderResult_NetWorkFail = 2;
      public static final int EMSenderResult_NoAvailIp = 18;
      public static final int EMSenderResult_OK = 0;
      public static final int EMSenderResult_OtherErr = 17;
      public static final int EMSenderResult_ParameterErr = 7;
      public static final int EMSenderResult_QueryFail = 14;
      public static final int EMSenderResult_QueryTimeOut = 15;
      public static final int EMSenderResult_RangDiffTooLarge = 16;
      public static final int EMSenderResult_RollBackTooMuch = 13;
      public static final int EMSenderResult_SenderGeneralErr = 11;
      public static final int EMSenderResult_ServerClose = 6;
      public static final int EMSenderResult_ServerDenyErr = 4;
      public static final int EMSenderResult_ServerErr = 5;
      public static final int EMSenderResult_ServerReset = 12;
      public static final int EMSenderResult_ServerRspFormatErr = 3;
      public static final int EMSenderResult_TimeOut = 9;
      public static final int EMSenderResult_UerCancel = 33;
      public static final int EMSenderResult_WatchDogTimeOut = 10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDef
 * JD-Core Version:    0.7.0.1
 */