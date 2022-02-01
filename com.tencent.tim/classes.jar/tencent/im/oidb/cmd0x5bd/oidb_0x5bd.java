package tencent.im.oidb.cmd0x5bd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5bd
{
  public static final class AdReport
    extends MessageMicro<AdReport>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_report_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_report_url" }, new Object[] { localByteStringMicro }, AdReport.class);
    }
  }
  
  public static final class GuideInfo
    extends MessageMicro<GuideInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x5bd.SkinInfo msg_skin_info = new oidb_0x5bd.SkinInfo();
    public final PBUInt32Field uint32_begin_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_guide_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 90 }, new String[] { "bytes_id", "bytes_name", "uint32_begin_timestamp", "uint32_end_timestamp", "uint64_seq", "bytes_url", "uint32_guide_type", "msg_skin_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), null }, GuideInfo.class);
    }
  }
  
  public static final class RefreshInfo
    extends MessageMicro<RefreshInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x5bd.AdReport> msg_ad_click_report = PBField.initRepeatMessage(oidb_0x5bd.AdReport.class);
    public final PBRepeatMessageField<oidb_0x5bd.AdReport> msg_ad_exposure_report = PBField.initRepeatMessage(oidb_0x5bd.AdReport.class);
    public final PBUInt32Field uint32_begin_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ad = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ad_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 80 }, new String[] { "bytes_id", "bytes_name", "uint32_begin_timestamp", "uint32_end_timestamp", "uint64_seq", "bytes_url", "uint32_is_ad", "msg_ad_click_report", "msg_ad_exposure_report", "uint64_ad_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), null, null, Long.valueOf(0L) }, RefreshInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 106, 114, 120 }, new String[] { "uint64_uin", "msg_current_skin_info", "msg_next_guide_info", "msg_current_refresh_info", "msg_current_guide_info", "uint32_source" }, new Object[] { Long.valueOf(0L), null, null, null, null, Integer.valueOf(0) }, ReqBody.class);
    public oidb_0x5bd.GuideInfo msg_current_guide_info = new oidb_0x5bd.GuideInfo();
    public oidb_0x5bd.RefreshInfo msg_current_refresh_info = new oidb_0x5bd.RefreshInfo();
    public oidb_0x5bd.SkinInfo msg_current_skin_info = new oidb_0x5bd.SkinInfo();
    public oidb_0x5bd.GuideInfo msg_next_guide_info = new oidb_0x5bd.GuideInfo();
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 106, 114, 120 }, new String[] { "uint64_uin", "msg_now_skin_info", "msg_next_guide_info", "msg_operation_guide_info", "msg_operation_refresh_info", "uint32_source" }, new Object[] { Long.valueOf(0L), null, null, null, null, Integer.valueOf(0) }, RspBody.class);
    public oidb_0x5bd.GuideInfo msg_next_guide_info = new oidb_0x5bd.GuideInfo();
    public oidb_0x5bd.SkinInfo msg_now_skin_info = new oidb_0x5bd.SkinInfo();
    public oidb_0x5bd.GuideInfo msg_operation_guide_info = new oidb_0x5bd.GuideInfo();
    public oidb_0x5bd.RefreshInfo msg_operation_refresh_info = new oidb_0x5bd.RefreshInfo();
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SkinInfo
    extends MessageMicro<SkinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_begin_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50 }, new String[] { "bytes_id", "bytes_name", "uint32_begin_timestamp", "uint32_end_timestamp", "uint64_seq", "bytes_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3 }, SkinInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5bd.oidb_0x5bd
 * JD-Core Version:    0.7.0.1
 */