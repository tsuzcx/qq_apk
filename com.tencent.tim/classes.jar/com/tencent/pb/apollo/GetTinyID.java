package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTinyID
{
  public static final class CmdErrorCode
    extends MessageMicro<CmdErrorCode>
  {
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
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
    public GetTinyID.SdkData msg_sdk_data = new GetTinyID.SdkData();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_sdk_data", "bytes_reqbody" }, new Object[] { null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
    public GetTinyID.CmdErrorCode msg_cmd_error_code = new GetTinyID.CmdErrorCode();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_cmd_error_code", "bytes_rspbody" }, new Object[] { null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class STAVCtrlParamReq
    extends MessageMicro<STAVCtrlParamReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "sdkAppId", "localVer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STAVCtrlParamReq.class);
    public final PBUInt32Field localVer = PBField.initUInt32(0);
    public final PBUInt32Field sdkAppId = PBField.initUInt32(0);
  }
  
  public static final class STAVCtrlParamRsp
    extends MessageMicro<STAVCtrlParamRsp>
  {
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "reqBody", "gameId", "roomId" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, STAudioVideoReq.class);
    public final PBUInt32Field gameId = PBField.initUInt32(0);
    public GetTinyID.ReqBody reqBody = new GetTinyID.ReqBody();
    public final PBUInt64Field roomId = PBField.initUInt64(0L);
  }
  
  public static final class STAudioVideoRsp
    extends MessageMicro<STAudioVideoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rspbody" }, new Object[] { null }, STAudioVideoRsp.class);
    public GetTinyID.RspBody rspbody = new GetTinyID.RspBody();
  }
  
  public static final class STCheckGameRsp
    extends MessageMicro<STCheckGameRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appIdSource = PBField.initUInt32(0);
    public final PBUInt32Field expTs = PBField.initUInt32(0);
    public final PBBytesField extInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field isPatch = PBField.initUInt32(0);
    public final PBUInt32Field needGCoins = PBField.initUInt32(0);
    public final PBStringField openId = PBField.initString("");
    public final PBStringField openKey = PBField.initString("");
    public final PBUInt64Field packageSize = PBField.initUInt64(0L);
    public final PBBytesField patchContent = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField patchUrl = PBField.initString("");
    public final PBUInt32Field remainPlays = PBField.initUInt32(0);
    public final PBStringField sessionOpenId = PBField.initString("");
    public final PBStringField ssoCmdRule = PBField.initString("");
    public final PBStringField st = PBField.initString("");
    public final PBStringField stKey = PBField.initString("");
    public final PBUInt32Field svrResVer = PBField.initUInt32(0);
    public final PBUInt64Field tipsSize = PBField.initUInt64(0L);
    public final PBUInt32Field updateFlag = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
    public final PBStringField wordingV2 = PBField.initString("");
    public final PBStringField zipMd5 = PBField.initString("");
    public final PBStringField zipUrl = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96, 106, 114, 122, 130, 136, 144, 152, 162, 170, 176 }, new String[] { "st", "stKey", "expTs", "remainPlays", "wording", "openId", "openKey", "sessionOpenId", "needGCoins", "wordingV2", "updateFlag", "isPatch", "patchContent", "patchUrl", "zipMd5", "zipUrl", "svrResVer", "packageSize", "tipsSize", "ssoCmdRule", "extInfo", "appIdSource" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro2, Integer.valueOf(0) }, STCheckGameRsp.class);
    }
  }
  
  public static final class STTinyID2UserAccInfoReq
    extends MessageMicro<STTinyID2UserAccInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "tinyids" }, new Object[] { Long.valueOf(0L) }, STTinyID2UserAccInfoReq.class);
    public final PBRepeatField<Long> tinyids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class STTinyID2UserAccInfoRsp
    extends MessageMicro<STTinyID2UserAccInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_acc_info" }, new Object[] { null }, STTinyID2UserAccInfoRsp.class);
    public final PBRepeatMessageField<GetTinyID.STUserAccInfo> user_acc_info = PBField.initRepeatMessage(GetTinyID.STUserAccInfo.class);
  }
  
  public static final class STUserAccInfo
    extends MessageMicro<STUserAccInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "tinyid", "identifier" }, new Object[] { Long.valueOf(0L), "" }, STUserAccInfo.class);
    public final PBStringField identifier = PBField.initString("");
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  }
  
  public static final class SdkData
    extends MessageMicro<SdkData>
  {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID
 * JD-Core Version:    0.7.0.1
 */