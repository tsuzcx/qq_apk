package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VaProfileGate
{
  public static final class CommTaskInfo
    extends MessageMicro<CommTaskInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_task_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appid", "bytes_task_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CommTaskInfo.class);
    }
  }
  
  public static final class GetGiftListReq
    extends MessageMicro<GetGiftListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin" }, new Object[] { Integer.valueOf(0) }, GetGiftListReq.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
  }
  
  public static final class GetGiftListRsp
    extends MessageMicro<GetGiftListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "gift_url", "custom_url", "desc", "is_on" }, new Object[] { "", "", "", Boolean.valueOf(false) }, GetGiftListRsp.class);
    public final PBStringField custom_url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatField<String> gift_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField is_on = PBField.initBool(false);
  }
  
  public static final class GetVipCareReq
    extends MessageMicro<GetVipCareReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, GetVipCareReq.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetVipCareRsp
    extends MessageMicro<GetVipCareRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_buss", "uint32_notice" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetVipCareRsp.class);
    public final PBUInt32Field uint32_buss = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notice = PBField.initUInt32(0);
  }
  
  public static final class OidbFlagInfo
    extends MessageMicro<OidbFlagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField byets_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_fieled = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_fieled", "byets_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, OidbFlagInfo.class);
    }
  }
  
  public static final class PrivilegeBaseInfoReq
    extends MessageMicro<PrivilegeBaseInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uReqUin" }, new Object[] { Long.valueOf(0L) }, PrivilegeBaseInfoReq.class);
    public final PBUInt64Field uReqUin = PBField.initUInt64(0L);
  }
  
  public static final class PrivilegeBaseInfoRsp
    extends MessageMicro<PrivilegeBaseInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField strJumpUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField strMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uIsGrayUsr = PBField.initUInt32(0);
    public final PBRepeatMessageField<VaProfileGate.PrivilegeInfo> vClosePriv = PBField.initRepeatMessage(VaProfileGate.PrivilegeInfo.class);
    public final PBRepeatMessageField<VaProfileGate.PrivilegeInfo> vOpenPriv = PBField.initRepeatMessage(VaProfileGate.PrivilegeInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "strMsg", "strJumpUrl", "vOpenPriv", "vClosePriv", "uIsGrayUsr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0) }, PrivilegeBaseInfoRsp.class);
    }
  }
  
  public static final class PrivilegeInfo
    extends MessageMicro<PrivilegeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field iFeeType = PBField.initInt32(0);
    public final PBInt32Field iFlag = PBField.initInt32(0);
    public final PBInt32Field iIsBig = PBField.initInt32(0);
    public final PBInt32Field iLevel = PBField.initInt32(0);
    public final PBInt32Field iSort = PBField.initInt32(0);
    public final PBInt32Field iType = PBField.initInt32(0);
    public final PBBytesField strDeluxeIconUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField strIconUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField strJumpUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72 }, new String[] { "iType", "iSort", "iFeeType", "iLevel", "iFlag", "strIconUrl", "strDeluxeIconUrl", "strJumpUrl", "iIsBig" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, PrivilegeInfo.class);
    }
  }
  
  public static final class VaProfileGateReq
    extends MessageMicro<VaProfileGateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uCmd", "stPrivilegeReq", "stGiftReq", "rpt_task_item", "rpt_oidb_flag", "st_vip_care" }, new Object[] { Integer.valueOf(0), null, null, null, null, null }, VaProfileGateReq.class);
    public final PBRepeatMessageField<VaProfileGate.OidbFlagInfo> rpt_oidb_flag = PBField.initRepeatMessage(VaProfileGate.OidbFlagInfo.class);
    public final PBRepeatMessageField<VaProfileGate.CommTaskInfo> rpt_task_item = PBField.initRepeatMessage(VaProfileGate.CommTaskInfo.class);
    public VaProfileGate.GetGiftListReq stGiftReq = new VaProfileGate.GetGiftListReq();
    public VaProfileGate.PrivilegeBaseInfoReq stPrivilegeReq = new VaProfileGate.PrivilegeBaseInfoReq();
    public VaProfileGate.GetVipCareReq st_vip_care = new VaProfileGate.GetVipCareReq();
    public final PBUInt32Field uCmd = PBField.initUInt32(0);
  }
  
  public static final class VaProfileGateRsp
    extends MessageMicro<VaProfileGateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field iRetCode = PBField.initInt32(0);
    public final PBRepeatMessageField<VaProfileGate.OidbFlagInfo> rpt_oidb_flag = PBField.initRepeatMessage(VaProfileGate.OidbFlagInfo.class);
    public final PBRepeatMessageField<VaProfileGate.CommTaskInfo> rpt_task_item = PBField.initRepeatMessage(VaProfileGate.CommTaskInfo.class);
    public final PBBytesField sRetMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public VaProfileGate.GetGiftListRsp stGiftRsp = new VaProfileGate.GetGiftListRsp();
    public VaProfileGate.PrivilegeBaseInfoRsp stPrivilegeRsp = new VaProfileGate.PrivilegeBaseInfoRsp();
    public VaProfileGate.GetVipCareRsp st_vip_care = new VaProfileGate.GetVipCareRsp();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "iRetCode", "sRetMsg", "stPrivilegeRsp", "stGiftRsp", "rpt_task_item", "rpt_oidb_flag", "st_vip_care" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null }, VaProfileGateRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate
 * JD-Core Version:    0.7.0.1
 */