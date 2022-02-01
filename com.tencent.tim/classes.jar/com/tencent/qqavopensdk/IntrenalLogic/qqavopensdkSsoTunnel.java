package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqavopensdkSsoTunnel
{
  public static final class CmdErrorCode
    extends MessageMicro<CmdErrorCode>
  {
    public static final int BYTES_ERR_MSG_FIELD_NUMBER = 2;
    public static final int UINT32_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_code", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CmdErrorCode.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int BYTES_REQBODY_FIELD_NUMBER = 2;
    public static final int MSG_SDK_DATA_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqavopensdkSsoTunnel.SdkData msg_sdk_data = new qqavopensdkSsoTunnel.SdkData();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_sdk_data", "bytes_reqbody" }, new Object[] { null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int BYTES_RSPBODY_FIELD_NUMBER = 2;
    public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqavopensdkSsoTunnel.CmdErrorCode msg_cmd_error_code = new qqavopensdkSsoTunnel.CmdErrorCode();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_cmd_error_code", "bytes_rspbody" }, new Object[] { null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class STAVCtrlParamReq
    extends MessageMicro<STAVCtrlParamReq>
  {
    public static final int LOCALVER_FIELD_NUMBER = 2;
    public static final int SDKAPPID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "sdkAppId", "localVer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STAVCtrlParamReq.class);
    public final PBUInt32Field localVer = PBField.initUInt32(0);
    public final PBUInt32Field sdkAppId = PBField.initUInt32(0);
  }
  
  public static final class STAVCtrlParamRsp
    extends MessageMicro<STAVCtrlParamRsp>
  {
    public static final int CTRLPARAM_FIELD_NUMBER = 3;
    public static final int SVRVER_FIELD_NUMBER = 2;
    public static final int UPDATEFLAG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ctrlParam = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field svrVer = PBField.initUInt32(0);
    public final PBUInt32Field updateFlag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "updateFlag", "svrVer", "ctrlParam" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, STAVCtrlParamRsp.class);
    }
  }
  
  public static final class STAudioVideoReq
    extends MessageMicro<STAudioVideoReq>
  {
    public static final int GAMEID_FIELD_NUMBER = 2;
    public static final int REQBODY_FIELD_NUMBER = 1;
    public static final int ROOMID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "reqBody", "gameId", "roomId" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, STAudioVideoReq.class);
    public final PBUInt32Field gameId = PBField.initUInt32(0);
    public qqavopensdkSsoTunnel.ReqBody reqBody = new qqavopensdkSsoTunnel.ReqBody();
    public final PBUInt64Field roomId = PBField.initUInt64(0L);
  }
  
  public static final class STAudioVideoRsp
    extends MessageMicro<STAudioVideoRsp>
  {
    public static final int RSPBODY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rspbody" }, new Object[] { null }, STAudioVideoRsp.class);
    public qqavopensdkSsoTunnel.RspBody rspbody = new qqavopensdkSsoTunnel.RspBody();
  }
  
  public static final class SdkData
    extends MessageMicro<SdkData>
  {
    public static final int BYTES_SDK_APP_TOKEN_FIELD_NUMBER = 2;
    public static final int CMLB_TEST_FIELD_NUMBER = 9;
    public static final int TINYID_FIELD_NUMBER = 10;
    public static final int UINT32_SDK_APP_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sdk_app_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField cmlb_test = PBField.initBool(false);
    public final PBStringField tinyid = PBField.initString("");
    public final PBUInt32Field uint32_sdk_app_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 72, 82 }, new String[] { "uint32_sdk_app_id", "bytes_sdk_app_token", "cmlb_test", "tinyid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false), "" }, SdkData.class);
    }
  }
  
  public static final class UniSsoServerReq
    extends MessageMicro<UniSsoServerReq>
  {
    public static final int COMM_FIELD_NUMBER = 1;
    public static final int PBREQDATA_FIELD_NUMBER = 3;
    public static final int REQDATA_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public qqavopensdkSsoTunnel.UniSsoServerReqComm comm = new qqavopensdkSsoTunnel.UniSsoServerReqComm();
    public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField reqdata = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqdata", "pbReqData" }, new Object[] { null, "", localByteStringMicro }, UniSsoServerReq.class);
    }
  }
  
  public static final class UniSsoServerReqComm
    extends MessageMicro<UniSsoServerReqComm>
  {
    public static final int MQQVER_FIELD_NUMBER = 3;
    public static final int OSVER_FIELD_NUMBER = 2;
    public static final int PLATFORM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, UniSsoServerReqComm.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class UniSsoServerRsp
    extends MessageMicro<UniSsoServerRsp>
  {
    public static final int COMM_FIELD_NUMBER = 3;
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int PBRSPDATA_FIELD_NUMBER = 5;
    public static final int RET_FIELD_NUMBER = 1;
    public static final int RSPDATA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public qqavopensdkSsoTunnel.UniSsoServerRspComm comm = new qqavopensdkSsoTunnel.UniSsoServerRspComm();
    public final PBStringField errmsg = PBField.initString("");
    public final PBBytesField pbRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public final PBStringField rspdata = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "errmsg", "comm", "rspdata", "pbRspData" }, new Object[] { Long.valueOf(0L), "", null, "", localByteStringMicro }, UniSsoServerRsp.class);
    }
  }
  
  public static final class UniSsoServerRspComm
    extends MessageMicro<UniSsoServerRspComm>
  {
    public static final int DELAYMS_FIELD_NUMBER = 1;
    public static final int PACKAGESIZE_FIELD_NUMBER = 2;
    public static final int PROCTIME_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "delayms", "packagesize", "proctime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UniSsoServerRspComm.class);
    public final PBUInt32Field delayms = PBField.initUInt32(0);
    public final PBUInt32Field packagesize = PBField.initUInt32(0);
    public final PBInt32Field proctime = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel
 * JD-Core Version:    0.7.0.1
 */