package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB
{
  public static final class GetUrlReq
    extends MessageMicro<GetUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "delta_mode", "storage_mode", "compress_mode", "item_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetUrlReq.class);
    public final PBUInt32Field compress_mode = PBField.initUInt32(0);
    public final PBUInt32Field delta_mode = PBField.initUInt32(0);
    public final PBRepeatMessageField<SCUpdatePB.ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
    public final PBUInt32Field storage_mode = PBField.initUInt32(0);
  }
  
  public static final class GetUrlRsp
    extends MessageMicro<GetUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "update_list" }, new Object[] { null }, GetUrlRsp.class);
    public final PBRepeatMessageField<SCUpdatePB.UpdateInfo> update_list = PBField.initRepeatMessage(SCUpdatePB.UpdateInfo.class);
  }
  
  public static final class ItemVersion
    extends MessageMicro<ItemVersion>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "bid", "scid", "version", "flag" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, ItemVersion.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBStringField scid = PBField.initString("");
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class SCPreload
    extends MessageMicro<SCPreload>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plver", "item_list" }, new Object[] { Long.valueOf(0L), null }, SCPreload.class);
    public final PBRepeatMessageField<SCUpdatePB.ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
    public final PBInt64Field plver = PBField.initInt64(0L);
  }
  
  public static final class SCReport
    extends MessageMicro<SCReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "rpver", "item_list" }, new Object[] { Long.valueOf(0L), null }, SCReport.class);
    public final PBRepeatMessageField<SCUpdatePB.ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
    public final PBInt64Field rpver = PBField.initInt64(0L);
  }
  
  public static final class SCUpdateReq
    extends MessageMicro<SCUpdateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "cmd", "comm", "req0x01", "req0x02" }, new Object[] { Integer.valueOf(0), null, null, null }, SCUpdateReq.class);
    public final PBInt32Field cmd = PBField.initInt32(0);
    public SCUpdatePB.SCUpdateReqComm comm = new SCUpdatePB.SCUpdateReqComm();
    public SCUpdatePB.SyncVCRReq req0x01 = new SCUpdatePB.SyncVCRReq();
    public SCUpdatePB.GetUrlReq req0x02 = new SCUpdatePB.GetUrlReq();
  }
  
  public static final class SCUpdateReqComm
    extends MessageMicro<SCUpdateReqComm>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt64Field cookie = PBField.initInt64(0L);
    public final PBBytesField from = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field network = PBField.initInt32(0);
    public final PBBytesField osrelease = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field plat = PBField.initUInt32(0);
    public final PBBytesField qver = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "plat", "qver", "osrelease", "network", "from", "cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L) }, SCUpdateReqComm.class);
    }
  }
  
  public static final class SCUpdateRsp
    extends MessageMicro<SCUpdateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field cmd = PBField.initInt32(0);
    public SCUpdatePB.SCUpdateRspComm comm = new SCUpdatePB.SCUpdateRspComm();
    public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public SCUpdatePB.SyncVCRRsp rsp0x01 = new SCUpdatePB.SyncVCRRsp();
    public SCUpdatePB.GetUrlRsp rsp0x02 = new SCUpdatePB.GetUrlRsp();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "ret", "msg", "cmd", "comm", "rsp0x01", "rsp0x02" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), null, null, null }, SCUpdateRsp.class);
    }
  }
  
  public static final class SCUpdateRspComm
    extends MessageMicro<SCUpdateRspComm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "polltime", "cookie" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SCUpdateRspComm.class);
    public final PBInt64Field cookie = PBField.initInt64(0L);
    public final PBInt32Field polltime = PBField.initInt32(0);
  }
  
  public static final class SyncVCRReq
    extends MessageMicro<SyncVCRReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "seq", "sync_mode", "item_list", "plver", "rpver" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L) }, SyncVCRReq.class);
    public final PBRepeatMessageField<SCUpdatePB.ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
    public final PBInt64Field plver = PBField.initInt64(0L);
    public final PBInt64Field rpver = PBField.initInt64(0L);
    public final PBInt64Field seq = PBField.initInt64(0L);
    public final PBInt32Field sync_mode = PBField.initInt32(0);
  }
  
  public static final class SyncVCRRsp
    extends MessageMicro<SyncVCRRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "seq", "vcr_list", "continue_flag", "preload", "report", "sync_switch" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, null, Integer.valueOf(0) }, SyncVCRRsp.class);
    public final PBInt32Field continue_flag = PBField.initInt32(0);
    public SCUpdatePB.SCPreload preload = new SCUpdatePB.SCPreload();
    public SCUpdatePB.SCReport report = new SCUpdatePB.SCReport();
    public final PBInt64Field seq = PBField.initInt64(0L);
    public final PBUInt32Field sync_switch = PBField.initUInt32(0);
    public final PBRepeatMessageField<SCUpdatePB.VCR> vcr_list = PBField.initRepeatMessage(SCUpdatePB.VCR.class);
  }
  
  public static final class UpdateInfo
    extends MessageMicro<UpdateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBUInt32Field compress_mode = PBField.initUInt32(0);
    public final PBUInt32Field delta_mode = PBField.initUInt32(0);
    public final PBStringField dst_version = PBField.initString("");
    public final PBBytesField filecontent = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field filesize = PBField.initInt64(0L);
    public final PBStringField scid = PBField.initString("");
    public final PBStringField src_version = PBField.initString("");
    public final PBUInt32Field storage_mode = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 66, 72, 82, 88 }, new String[] { "bid", "scid", "dst_version", "src_version", "delta_mode", "storage_mode", "compress_mode", "url", "filesize", "filecontent", "code" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, UpdateInfo.class);
    }
  }
  
  public static final class VCR
    extends MessageMicro<VCR>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "seq", "bid", "scid", "optype", "version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "" }, VCR.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field optype = PBField.initUInt32(0);
    public final PBStringField scid = PBField.initString("");
    public final PBInt64Field seq = PBField.initInt64(0L);
    public final PBStringField version = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB
 * JD-Core Version:    0.7.0.1
 */