package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MultiHeadUrl
{
  public static final class MultiBusidUrlReq
    extends MessageMicro<MultiBusidUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "srcUidType", "srcUin", "srcTid", "srcOpenid", "dstUsrType", "dstUidType", "dstUsrInfos" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), null }, MultiBusidUrlReq.class);
    public final PBUInt32Field dstUidType = PBField.initUInt32(0);
    public final PBRepeatMessageField<MultiHeadUrl.ReqUsrInfo> dstUsrInfos = PBField.initRepeatMessage(MultiHeadUrl.ReqUsrInfo.class);
    public final PBRepeatField<Integer> dstUsrType = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField srcOpenid = PBField.initString("");
    public final PBUInt64Field srcTid = PBField.initUInt64(0L);
    public final PBUInt32Field srcUidType = PBField.initUInt32(0);
    public final PBUInt64Field srcUin = PBField.initUInt64(0L);
  }
  
  public static final class MultiBusidUrlRsp
    extends MessageMicro<MultiBusidUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "srcUidType", "srcUin", "srcTid", "srcOpenid", "result", "dstUidType", "dstUsrHeadInfos" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), null }, MultiBusidUrlRsp.class);
    public final PBUInt32Field dstUidType = PBField.initUInt32(0);
    public final PBRepeatMessageField<MultiHeadUrl.RspUsrHeadInfo> dstUsrHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspUsrHeadInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField srcOpenid = PBField.initString("");
    public final PBUInt64Field srcTid = PBField.initUInt64(0L);
    public final PBUInt32Field srcUidType = PBField.initUInt32(0);
    public final PBUInt64Field srcUin = PBField.initUInt64(0L);
  }
  
  public static final class ReqUsrInfo
    extends MessageMicro<ReqUsrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "dstUin", "dstTid", "dstOpenid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, ReqUsrInfo.class);
    public final PBStringField dstOpenid = PBField.initString("");
    public final PBUInt64Field dstTid = PBField.initUInt64(0L);
    public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  }
  
  public static final class RspHeadInfo
    extends MessageMicro<RspHeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58 }, new String[] { "usrType", "faceType", "timestamp", "faceFlag", "url", "sysid", "headVerify" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" }, RspHeadInfo.class);
    public final PBUInt32Field faceFlag = PBField.initUInt32(0);
    public final PBUInt32Field faceType = PBField.initUInt32(0);
    public final PBStringField headVerify = PBField.initString("");
    public final PBUInt32Field sysid = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field usrType = PBField.initUInt32(0);
  }
  
  public static final class RspUsrHeadInfo
    extends MessageMicro<RspUsrHeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "dstUin", "dstTid", "dstOpenid", "dstHeadInfos" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", null }, RspUsrHeadInfo.class);
    public final PBRepeatMessageField<MultiHeadUrl.RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(MultiHeadUrl.RspHeadInfo.class);
    public final PBStringField dstOpenid = PBField.initString("");
    public final PBUInt64Field dstTid = PBField.initUInt64(0L);
    public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.avatarinfo.MultiHeadUrl
 * JD-Core Version:    0.7.0.1
 */