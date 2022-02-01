package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl
{
  public static final class QQHeadUrlReq
    extends MessageMicro<QQHeadUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "srcUsrType", "srcUin", "dstUsrType", "dstUsrInfos", "dstEncryptType" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, QQHeadUrlReq.class);
    public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQHeadUrl.ReqUsrInfo> dstUsrInfos = PBField.initRepeatMessage(QQHeadUrl.ReqUsrInfo.class);
    public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
    public final PBUInt64Field srcUin = PBField.initUInt64(0L);
    public final PBUInt32Field srcUsrType = PBField.initUInt32(0);
  }
  
  public static final class QQHeadUrlRsp
    extends MessageMicro<QQHeadUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "srcUsrType", "srcUin", "result", "dstUsrType", "dstHeadInfos", "dstEncryptType" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, QQHeadUrlRsp.class);
    public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQHeadUrl.RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(QQHeadUrl.RspHeadInfo.class);
    public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt64Field srcUin = PBField.initUInt64(0L);
    public final PBUInt32Field srcUsrType = PBField.initUInt32(0);
  }
  
  public static final class ReqUsrInfo
    extends MessageMicro<ReqUsrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "dstUin", "timestamp", "dstEncid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, ReqUsrInfo.class);
    public final PBStringField dstEncid = PBField.initString("");
    public final PBUInt64Field dstUin = PBField.initUInt64(0L);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
  }
  
  public static final class RspHeadInfo
    extends MessageMicro<RspHeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66 }, new String[] { "dstUin", "faceType", "timestamp", "faceFlag", "url", "sysid", "dstUid", "headVerify" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, RspHeadInfo.class);
    public final PBStringField dstUid = PBField.initString("");
    public final PBUInt64Field dstUin = PBField.initUInt64(0L);
    public final PBUInt32Field faceFlag = PBField.initUInt32(0);
    public final PBUInt32Field faceType = PBField.initUInt32(0);
    public final PBStringField headVerify = PBField.initString("");
    public final PBUInt32Field sysid = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.avatarinfo.QQHeadUrl
 * JD-Core Version:    0.7.0.1
 */